package com.itbank.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.board.BoardDAO;
import com.itbank.board.BoardDTO;
import com.itbank.board.BoardPaging;
import com.itbank.board.ReplyDAO;
import com.itbank.board.ReplyDTO;
import com.itbank.member.MemberDTO;


@Service
public class BoardService {

	@Autowired private BoardDAO dao;
	@Autowired private ReplyDAO replydao;
	
	public ModelAndView getBoardList(int page) {
		ModelAndView mav = new ModelAndView("board/board");
		BoardPaging paging = new BoardPaging();
		
		int boardCount = dao.selectCount();	// ���� �Խ����� �Խñ� �� ����
		paging.setPage(boardCount, page);	// ��ü ������ ���� �������� �����ϸ�
		int first = paging.getFirst();		// ����¡ ó���� ù �۹�ȣ��			// 1
		int last = paging.getLast();		// ����¡ ó���� ������ �۹�ȣ�� �޾ƿ´�	// 10
		
		List<BoardDTO> list = dao.selectList(first, last);
		mav.addObject("list", list);
		
		mav.addObject("nowPage", page);				// ���� �����ִ� ������ ��ȣ
		mav.addObject("begin", paging.getBegin());	// ��ü �������� ���� ����
		mav.addObject("end", paging.getEnd());		// ��ü �������� ���� ��
		
		mav.addObject("prev", paging.hasPrev());
		mav.addObject("next", paging.hasNext());
		
		return mav;
	}

	public BoardDTO readList(int idx) {
		return dao.readList(idx);
	}

	public int insertboard(BoardDTO dto) {
		return dao.insertboard(dto);
	}

	public int deleteBaord(int idx) {
		return dao.deleteboard(idx);
		
	}

	public int updateBoard(BoardDTO dto) {
		return dao.updateBoard(dto);
	}

	public int updateViewCount(int idx) {
		return dao.updateViewCount(idx);
	}

	public List<ReplyDTO> getReplyList(int idx) {
		return replydao.replyList(idx);
	}

	public int insertreply(ReplyDTO reply) {
		return replydao.insertreply(reply);
	}

	public int deleteReply(int idx, HttpSession session) {
		int deleted = "admin".equals(((MemberDTO)session.getAttribute("login")).getUserid()) ? 2 : 1;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("idx", idx);
		map.put("deleted",deleted);
		return replydao.deletereply(map);
	}

	public String selectboardidx(int idx) {
		return replydao.selectboardidx(idx);
	}



}
