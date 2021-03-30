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
		
		int boardCount = dao.selectCount();	// 현재 게시판의 게시글 총 개수
		paging.setPage(boardCount, page);	// 전체 개수와 현재 페이지를 전달하면
		int first = paging.getFirst();		// 페이징 처리된 첫 글번호와			// 1
		int last = paging.getLast();		// 페이징 처리된 마지막 글번호를 받아온다	// 10
		
		List<BoardDTO> list = dao.selectList(first, last);
		mav.addObject("list", list);
		
		mav.addObject("nowPage", page);				// 현재 보고있는 페이지 번호
		mav.addObject("begin", paging.getBegin());	// 전체 페이지의 범위 시작
		mav.addObject("end", paging.getEnd());		// 전체 페이지의 범위 끝
		
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
