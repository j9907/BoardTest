package com.itbank.Controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.board.BoardDTO;
import com.itbank.board.Fileupload;
import com.itbank.board.ReplyDTO;
import com.itbank.member.MemberDTO;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("board/")
public class BoardController {

	@Autowired private BoardService bs;
	@Autowired private Fileupload fs;
	
	@GetMapping("")
	public ModelAndView boardList() {
		return boardList(1);
	}
	
	@GetMapping("{page}")
	public ModelAndView boardList(@PathVariable int page) {
		return bs.getBoardList(page);
	}
	
	@GetMapping("read/{idx}/")
	public ModelAndView read(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView();
		BoardDTO dto = bs.readList(idx);
		int row = bs.updateViewCount(idx);
		List<ReplyDTO> replyList = bs.getReplyList(idx);
		mav.setViewName("board/read");
		mav.addObject("dto", dto);
		mav.addObject("replyList", replyList);
		return mav;
	}
	
	@PostMapping("read/{idx}/")
	public ModelAndView read(@PathVariable int idx, ReplyDTO reply) {
		ModelAndView mav = new ModelAndView("redirect:.");
		int row = bs.insertreply(reply);
		return mav;
	}

	@GetMapping("write/")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("write/")
	public ModelAndView write(MultipartRequest request,BoardDTO dto) throws IllegalStateException, IOException {
		ModelAndView mav = new ModelAndView();
		MultipartFile file = request.getFile("File"); 
		boolean flag = fs.uploadFile(file);
		if(flag) {
			if(file.getOriginalFilename() != null) {
				dto.setUploadFile(file.getOriginalFilename());
			}
			
		}
		int row = bs.insertboard(dto);	
		if(row == 1) mav.setViewName("redirect:/board/");
		return mav;
	}
	
	@GetMapping("delete/{idx}")
	public String erase(@PathVariable int idx) {
		bs.deleteBaord(idx);
		return "redirect:/board/";
	}

	@GetMapping("update/{idx}")
	public ModelAndView update(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView("board/update");
		BoardDTO dto = bs.readList(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("update/{idx}")
	public String update(@PathVariable int idx, MultipartRequest request, BoardDTO dto) throws IllegalStateException, IOException {
		MultipartFile file = request.getFile("File"); 
		if(file.equals(dto.getUploadfile()) == false) {
		boolean flag = fs.uploadFile(file);
		if(flag) {
			if(file.getOriginalFilename() != null) {
				dto.setUploadFile(file.getOriginalFilename());
			}
			
		}
		}
		int row = bs.updateBoard(dto);
		return "redirect:/board/read/" + idx + "/";
	}
	
	@GetMapping("deleteReply/{idx}")
	public String deleteReply(@PathVariable int idx,HttpSession session) {
		int row = bs.deleteReply(idx,session);
		String boardidx = bs.selectboardidx(idx);
		return "redirect:/board/read/" + boardidx + "/";
	}
	
	
}