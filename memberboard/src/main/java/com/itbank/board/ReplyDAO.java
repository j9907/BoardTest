package com.itbank.board;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAO {

	@Autowired private SqlSessionTemplate st;
	
	public List<ReplyDTO> replyList(int idx) {
		return st.selectList("replylist", idx);
	}

	public int insertreply(ReplyDTO reply) {
		return st.insert("insertreply", reply);
	}
	
	public int deletereply(HashMap<String, Integer> map) {
		return st.update("deletereply",map);
	}

	public String selectboardidx(int idx) {
		return st.selectOne("selectboardidx", idx);
	}

}

