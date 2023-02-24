package egovframework.example.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
/**
 * @Class Name : CommentVO.java
 * @Description : CommentVO Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.02.23                  최초생성
 *
 * @author 최유리
 * 댓글 
 */

@Data
public class CommentVO {

	//댓긋 ID
	private int id;
	//게시판 ID
	private String boardId;
	//내용
	private String content;
	//작성일
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date dt;
	//작성자
	private String regUser;
	//상위 댓글 (최상위댓글의 경우 0)
	private int parentId;
}
