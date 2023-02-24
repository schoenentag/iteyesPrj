package egovframework.example.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import egovframework.example.board.service.CommentService;
import egovframework.example.board.service.CommentVO;

@CrossOrigin()
@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService service;
	
	//등록
	@PostMapping("/insert.do")
	public int insertComment(@RequestBody CommentVO vo) throws Exception {
		System.out.println(vo);
		return service.insertComment(vo);
	}
	//수정
	@PostMapping("/update.do")
	public int updateComment(@RequestBody CommentVO vo) throws Exception{
		System.out.println("Update Controller");
		return service.updateComment(vo);
	}
	
	//삭제
	@PostMapping("/delete.do")
	public int deleteComment(@RequestBody Map<?,?> info) throws Exception{
		System.out.println("Delete Controller");
		int targetId = Integer.parseInt( (String) info.get("id")) ;
		System.out.println("삭제할 댓글 ID : "+ targetId);
		CommentVO vo = new CommentVO();
		vo.setId(targetId);
		return service.deleteComment(vo);
	}
	
	//조회
	@ResponseBody
	@GetMapping("/getList.do")
	public List<CommentVO> getComment(@RequestParam String boardId, int parentId) throws Exception {
		System.out.println("controller");
		CommentVO vo = new CommentVO();
		vo.setBoardId(boardId);
		vo.setParentId(parentId);
		List<CommentVO> list = service.getComment(vo);
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/word.do")
	public String setWord() {
		return "Comment Controller Working Check OK";
	}
}
