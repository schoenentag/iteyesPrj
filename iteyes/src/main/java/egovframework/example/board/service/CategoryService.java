package egovframework.example.board.service;

import java.util.List;
import java.util.Map;
/**
 * @Class Name : CategoryService.java
 * @Description : CategoryService Interface
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.02.23                  최초생성
 *
 * @author 김하은
 *  카테고리 서비스단 
 */
public interface CategoryService {
	/* 전체 조회 */
	List<Map<String, String>> jsonCategoryList(Map<String, Object> param) throws Exception; 
    /* 단건 조회 */
	Map<String, String> jsonCategoryDetail(String id) throws Exception;
	/* 등록 : 사용안함 */
	int jsonCategoryInsert(Map<String, String>map) throws Exception;
	/* 등록2 */
	int jsonCategoryInsert2(CategoryVO vo) throws Exception;
	/* 수정 */
	int jsonCategoryUpdate(CategoryVO vo) throws Exception;
	/* 삭제 */
	int jsonCategoryDelete(String id) throws Exception;
	/* 검색 */
	List<Map<String, Object>> jsonCategorySearch(Map<String, Object> map) throws Exception; 
	/* 전체글 cnt*/
	int CategoryListyCnt() throws Exception;
	/* 검색글 cnt */
	int CategorySearchCnt(Map<String, Object>map) throws Exception;

	
	
}
