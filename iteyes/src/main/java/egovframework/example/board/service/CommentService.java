package egovframework.example.board.service;

import java.util.List;

/**
 * @Class Name : CommentService.java
 * @Description : CommentService Interface
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.02.24                  최초생성
 *
 * @author 최유리
 * 댓글 
 */
public interface CommentService {
	//입력
	public int insertComment(CommentVO vo) throws Exception;
	//내용 수정
	public int updateComment(CommentVO vo) throws Exception;
	//삭제
	public int deleteComment(CommentVO vo) throws Exception;
	//조회
	public List<CommentVO> getComment(CommentVO vo) throws Exception;
}
