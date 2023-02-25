package egovframework.example.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@ResponseBody
	@RequestMapping("/selectBoardList.do")
	List<Map<?,?>> selectBoardList() throws Exception{
		System.out.println("ttttttttttttttttttttttt");
		System.out.println(service.selectBoardList());
		return service.selectBoardList();
	}
	
	@RequestMapping("/insertBoard.do")
	void insertBoard() throws Exception {
		System.out.println("인서트");
		service.insertBoard(null);
	
	}
	

}
