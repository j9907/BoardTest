package com.itbank.member;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired private SqlSessionTemplate st;
	
	public int insertmember(MemberDTO dto) {
		return st.insert("insertmember", dto);
	}

	public MemberDTO selectMemberOne(MemberDTO dto) {
		return st.selectOne("selectUser",dto);
	}

	public String selectPw(String string) {
		return st.selectOne("selectPw", string);
	}

	public int updateUser(HashMap<String, String> request) {
		return st.update("updateUser", request);
	}

	public String selectId(String userid) {
		return st.selectOne("selectUserid",userid);
	}

	

}
