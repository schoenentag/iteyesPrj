package egovframework.example.board.web;

import java.util.HashMap;
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
	public int insertComment(@RequestBody CommentVO commentInfo) throws Exception {
		System.out.println(commentInfo);
		return service.insertComment(commentInfo);
	}
	//수정
	@PostMapping("/update.do")
	public int updateComment(@RequestBody CommentVO commentInfo) throws Exception{
		System.out.println("Update Controller");
		return service.updateComment(commentInfo);
	}
	
	//삭제
	@PostMapping("/delete.do")
	public int deleteComment(@RequestBody CommentVO commentInfo) throws Exception{
		System.out.println("Delete Controller");
		return service.deleteComment(commentInfo);
	}
	
	//조회
	@ResponseBody
	@GetMapping("/getList.do")
	public Map<String, Object> getComment(@RequestParam String boardId,
									@RequestParam int parentId,
									@RequestParam(required = false) int pageNum) throws Exception {
		System.out.println("Select Comment Controller");
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("boardId", boardId);		//게시판 ID
		info.put("parentId", parentId);		//상위 댓글 번호
		info.put("start", (pageNum-1)*10);	//시작 위치
		info.put("length", 10);				//한 페이지 출력 개수 10개
		List<CommentVO> list = service.getComment(info);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("listSize", service.commentNum(info));
		return map;
	}
	
	@GetMapping("/word.do")
	public String setWord() {
		return "Comment Controller Working Check OK";
	}
}
