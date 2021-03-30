package com.itbank.Controller;


import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.member.MemberDTO;
import com.itbank.service.MemberService;

@Controller
public class MemberController {

	@Autowired private MemberService ms;
	
	@GetMapping("join")
	public String join() {
		return "join";
	}
	
	@PostMapping("join")
	public ModelAndView join(MemberDTO dto) {
		ModelAndView mav = new ModelAndView("joinResult");
		int row = ms.insertmember(dto);
		mav.addObject("msg", row == 1 ? "ȸ�������� �Ϸ�Ǿ����ϴ�" : "ȸ�������� �����Ͽ����ϴ�");
		return mav;
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@PostMapping("login")
	public ModelAndView login(MemberDTO dto,HttpSession session) {
		ModelAndView mav = new ModelAndView("loginResult");
		ms.selectUser(dto,session);
		mav.addObject("msg", "��, �������!!");
		return mav;
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	@GetMapping("update")
	public String update() {
		return "update";
	}
	
	@PostMapping("update")
	public ModelAndView update(@RequestParam HashMap<String, String> request,HttpSession session) {
		ModelAndView mav = new ModelAndView("updateResult");
		int row = ms.updateuser(session,request);
		switch(row) {
		case -2: mav.addObject("msg", "���� ��й�ȣ�� ��ġ���� �ʽ��ϴ�");	break;
		case -1: mav.addObject("msg", "�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�"); break;
		case 0: mav.addObject("msg", "������ ���еǾ����ϴ�"); break;
		case 1: mav.addObject("msg", "������ �Ϸ�Ǿ����ϴ�"); break;
		}
		
		return mav;
	}
}
