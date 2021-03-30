package com.itbank.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.member.MemberDTO;
import com.itbank.service.MemberService;

@RestController
public class AjaxController {

	@Autowired private MemberService ms;
	
	@GetMapping(value="ajax1", produces = "application/text;charset=utf8")
	public String ajax1() {
		System.out.println("��Ʈ�ѷ�");
		return "�ȳ��ϼ���";
	}
	
	@PostMapping(value="idtest", produces = "application/text;charset=utf8")
	public String login(String userid) {
		System.out.println(userid);
		boolean flag = ms.selectId(userid);
		if(flag) {
			return "���̵� �̹� �����մϴ�.";
		}
		return "";
		
	}
	
}
