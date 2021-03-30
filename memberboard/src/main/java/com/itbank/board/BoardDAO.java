package com.itbank.board;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired private SqlSessionTemplate st;
	
public List<BoardDTO> selectList(int first, int last) {
		
		HashMap<String, Integer> param = new HashMap<String, Integer>();
		param.put("first", first);
		param.put("last", last);
		return st.selectList("selectList", param);
	}

	// board 테이블의 row가 총 몇개냐?
	public int selectCount() {
		return st.selectOne("selectCount");
	}

	public BoardDTO readList(int idx) {
		return st.selectOne("selectBoard", idx);
	}

	public int insertboard(BoardDTO dto) {
		return st.insert("insertBoard",dto);
	}

	public int deleteboard(int idx) {
		return st.delete("deleteBoard",idx);
	}

	public int updateBoard(BoardDTO dto) {
		return st.update("updateboard",dto);
	}

	public int updateViewCount(int idx) {
		return st.update("updateViewCount",idx);
	}
}


