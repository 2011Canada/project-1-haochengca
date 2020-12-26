package com.sshProject.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sshProject.entity.Ers_users;
import com.sshProject.service.ErsUserService;

@RestController
public class LoginAction {

	@Autowired
	private ErsUserService ersUserService;

	@RequestMapping("/allusers")
	public ResponseEntity<Ers_users> allUsers(Model model) {
		Ers_users user = ersUserService.allUsers();
		System.out.println(user);
		System.out.println(user.getUser_role_id().getUser_role());
		model.addAttribute("user", user);
		return new ResponseEntity<Ers_users>(user, HttpStatus.OK);
	}

	@GetMapping("/getuser")
	public Ers_users allUsers() {
		Ers_users user = ersUserService.allUsers();
		System.out.println(user);
		System.out.println(user.getUser_role_id().getUser_role());
		return user;
	}

//	@RequestMapping("/loginuser")
	@PostMapping("/login")
	public String login(@RequestBody Ers_users user, HttpSession session) {
		// 调用service
		System.out.println(user);
		List<Ers_users> u = ersUserService.loginUser(user);
		// 判断
		if (u.size() > 0) {// 成功
			// 使用session域对象
			session.setAttribute("user", u);
			return "welcome";
		} else {
			// request.getRequestDispatcher("").forward(arg0, arg1);
			return "fail";
		}
	}

}
