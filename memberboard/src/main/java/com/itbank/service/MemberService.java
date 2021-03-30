package com.itbank.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.member.MemberDAO;
import com.itbank.member.MemberDTO;

@Service
public class MemberService {
	
	@Autowired private MemberDAO dao;

	public int insertmember(MemberDTO dto) {
		return dao.insertmember(dto);
	}

	public void selectUser(MemberDTO dto,HttpSession session) {
		MemberDTO login =  dao.selectMemberOne(dto);
		session.setAttribute("login", login);
		session.setMaxInactiveInterval(600);
	}

	public int updateuser(HttpSession session, HashMap<String, String> request) {
		String newpw = request.get("newpw1");
		String newpw2 = request.get("newpw2");
		if(newpw.equals(newpw2) == false) {
			return -1;
		}
		
		String dbpw = dao.selectPw(request.get("userid"));
		String pw = request.get("userpw");
		
		if(pw.equals(dbpw) == false) {
			return -2;
		}
		
		int row = dao.updateUser(request);
		
		if(row == 1) {
			MemberDTO dto = new MemberDTO();
			dto.setUserid(request.get("userid"));
			dto.setUserpw(newpw);
			
			MemberDTO outputData = dao.selectMemberOne(dto);
			session.setAttribute("login", outputData);
			session.setMaxInactiveInterval(600);
		}
		return row;
		
	}

	public boolean selectId(String userid) {
		String user = dao.selectId(userid);
		if(user.length() == 0) {
			return true;
		}
		return false;
	}

}
