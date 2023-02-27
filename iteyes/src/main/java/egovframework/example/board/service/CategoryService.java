package egovframework.example.board.service;

import java.util.List;
import java.util.Map;

public interface CategoryService {
	/* 전체 조회 */
	List<Map<String, String>> jsonCategoryList(Map<String, Object> param) throws Exception; 
    /* 단건 조회 */
	Map<String, String> jsonCategoryDetail(Map<String,String> map) throws Exception;
	/* 등록 */
	int jsonCategoryInsert(Map<String, String>map) throws Exception;
	/* 수정 */
	int jsonCategoryUpdate(Map<String, String> map) throws Exception;
	/* 삭제 */
	int jsonCategoryDelete(Map<String, String> map) throws Exception;
	/* 검색 */
	List<Map<String, String>> jsonCategorySearch(Map<String, String> map) throws Exception; 
	/* 전체글 cnt*/
	int CategorListyCnt() throws Exception;
	
	
}
