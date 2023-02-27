package egovframework.example.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @Class Name : BoardVO.java
 * @Description : BoardVO Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.02.23   최유리        최초생성
 * @ 2023.02.23   곽주엽        오타수정(content), Lombok활용
 *
 * @author 최유리, 곽주엽
 * 게시글 
 */
@Data
public class BoardVO {
	//아이디
	private String id;
	//카테고리
	private String category;
	//공지 등록 여부
	private String noticeYn;
	//제목
	private String title;
	//작성자
	private String regUser;
	//내용
	private String content;
	//비밀번호(수정/삭제시 이용)
	private String pw;
	//등록일자
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date dt;
	//조회수
	private int viewCount;
	//첨부파일 이름
	private String fileName;
	
}
