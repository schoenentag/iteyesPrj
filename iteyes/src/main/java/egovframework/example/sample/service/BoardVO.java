package egovframework.example.sample.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Class Name : BoardVO.java
 * @Description : BoardVO Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.02.23           최초생성
 *
 * @author 최유리
 * 게시글 
 */
public class BoardVO {
	//아이디
	private String id;
	//카테고리
	private String cartegory;
	//공지 등록 여부
	private String noticeYn;
	//제목
	private String title;
	//작성자
	private String regUser;
	//내용
	private String contents;
	//비밀번호(수정/삭제시 이용)
	private String pw;
	//등록일자
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date dt;
	//조회수
	private int viewCount;
	//첨부파일 이름
	private String fileName;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCartegory() {
		return cartegory;
	}
	public void setCartegory(String cartegory) {
		this.cartegory = cartegory;
	}
	public String getNoticeYn() {
		return noticeYn;
	}
	public void setNoticeYn(String noticeYn) {
		this.noticeYn = noticeYn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegUser() {
		return regUser;
	}
	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Date getDt() {
		return dt;
	}
	public void setDt(Date dt) {
		this.dt = dt;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
