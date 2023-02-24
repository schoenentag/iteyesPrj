package egovframework.example.board.service;

import lombok.Data;

/**
 * 카테고리 관련 VO 변수 선언
 * @author han
 *
 */
@Data
public class CategoryVO {
	
	private String id; // 카테고리 id(PK)
	private String name; // 카테고리 이름
	private String description; // 카테고리 설명
	private String useYn; //사용여부 (y or n)
	private String regUser; //등록자(default ADMIN);

}
