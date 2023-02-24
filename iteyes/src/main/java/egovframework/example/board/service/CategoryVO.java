package egovframework.example.board.service;

import lombok.Data;

/**
 * @Class Name : CategoryVO.java
 * @Description : CategoryVO Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.02.23                  최초생성
 *
 * @author 김하은
 * 카테고리
 */
@Data
public class CategoryVO {
	
	private String id; // 카테고리 id(PK)
	private String name; // 카테고리 이름
	private String description; // 카테고리 설명
	private String useYn; //사용여부 (y or n)
	private String regUser; //등록자(default ADMIN);

}
