package com.sshProject.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sshProject.entity.Ers_reimbursement;
import com.sshProject.entity.Ers_reimbursement_status;
import com.sshProject.entity.Ers_users;
import com.sshProject.service.ErsUserService;
import com.sshProject.util.PassUtil;

@Controller
public class Controllers {

	@Autowired
	private ErsUserService ersUserService;

	@RequestMapping("/allreim")
	public String allReim(HttpSession session, Model model, Integer status) {
		List<Ers_reimbursement> ers_reimbursements = null;
		List<Ers_reimbursement> ret = new ArrayList<Ers_reimbursement>();
		Ers_users u = (Ers_users) session.getAttribute("user");

		if (u == null) {
			return "redirect:login.jsp";

		}

		if (u.getUser_role_id().getErs_user_role_id() == 0) {
			ers_reimbursements = ersUserService.allreim(u);
		} else if (u.getUser_role_id().getErs_user_role_id() == 1) {
			ers_reimbursements = ersUserService.allreim();
		}
		System.out.println(status);
		if (!StringUtils.isEmpty(status)) {
			for (Ers_reimbursement ers_reimbursement : ers_reimbursements) {
				if (ers_reimbursement.getReimb_status_id().getReimb_status_id() == status) {
					ret.add(ers_reimbursement);
				}
			}

		} else {
			ret = ers_reimbursements;
		}
		model.addAttribute("ers_reimbursements", ret);

		return "allreim";
	}

	@RequestMapping("/add")
	public String newReim(Ers_reimbursement ers_reimbursement, HttpSession session, MultipartFile file)
			throws Exception {

		String filename = file.getOriginalFilename();

		String uuid = UUID.randomUUID().toString();
		filename = uuid + filename;

		File serverFile = new File(
				"C:\\Users\\xuhao\\git\\project-1-haochengca\\src\\main\\webapp\\static\\img" + "/" + filename);
		if (!serverFile.exists()) {
			// 判断如果不存在创建
			serverFile.mkdirs();
		}

		file.transferTo(serverFile);

		Ers_users u = (Ers_users) session.getAttribute("user");

		if (u == null) {
			return "redirect:login.jsp";

		}
		ers_reimbursement.setErs_author(u);

		Ers_reimbursement_status ers_reimbursement_status = new Ers_reimbursement_status();
		ers_reimbursement_status.setReimb_status_id(1);

		ers_reimbursement.setReimb_status_id(ers_reimbursement_status);

		SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
		sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
		Date date = new Date();// 获取当前时间

		ers_reimbursement.setReimb_submitted(date);
		ers_reimbursement.setReceipt(filename);

		ersUserService.add(ers_reimbursement);

		return "redirect:allreim.action";
	}

	@RequestMapping("/loginuser")
//	@PostMapping("/login")
	public String login(Ers_users user, HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 调用service
//		System.out.println(user);
		String passMd5 = PassUtil.MD5EncodeUtf8(user.getErs_password());
		user.setErs_password(passMd5);
		List<Ers_users> u = ersUserService.loginUser(user);

		// 判断
		if (u.size() > 0) {// 成功
			// 使用session域对象
			session.setAttribute("user", u.get(0));

			return "redirect:allreim.action";
		} else {
			// request.getRequestDispatcher("").forward(arg0, arg1);

			return "redirect:login.jsp";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");

		return "redirect:login.jsp";
	}

	@RequestMapping("/approve")
	public String approve(int id, int flag, HttpSession session) {

		Ers_users u = (Ers_users) session.getAttribute("user");
		if (u == null) {
			return "redirect:login.jsp";

		}

		Ers_reimbursement ers_reimbursement = new Ers_reimbursement();
		ers_reimbursement.setReimb_id(id);

		Ers_reimbursement_status ers_reimbursement_status = new Ers_reimbursement_status();
		ers_reimbursement_status.setReimb_status_id(flag);

		SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
		sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
		Date date = new Date();// 获取当前时间

		ers_reimbursement.setReimb_resolved(date);

		ers_reimbursement.setReimb_status_id(ers_reimbursement_status);
		ers_reimbursement.setErs_resolver(u);
		ersUserService.approve(ers_reimbursement);

		return "redirect:allreim.action";
	}

	@RequestMapping("/upload")
	public String upload(MultipartFile file, HttpServletRequest request) throws Exception {

		String filename = file.getOriginalFilename();

		String uuid = UUID.randomUUID().toString();
		filename = uuid + filename;

		File serverFile = new File(
				"C:\\Users\\xuhao\\git\\project-1-haochengca\\src\\main\\webapp\\static\\img" + "/" + filename);
		if (!serverFile.exists()) {
			// 判断如果不存在创建
			serverFile.mkdirs();
		}

		file.transferTo(serverFile);

		return "forward:add.action";

	}

}
