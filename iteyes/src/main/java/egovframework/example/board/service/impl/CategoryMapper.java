package egovframework.example.board.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.board.service.CategoryVO;

/**
 * @Class Name : CategoryMapper.java
 * @Description : CategoryMapper Class
 * @Modification Mapping
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.02.23                  최초생성
 *
 * @author 김하은
 * 
 */
@Mapper("categoryMapper")
//패키지를 포함하는 클래스명 부분이 mapper xml 상의 namespace가 선택되고 
//인터페이스 메소드가 query id로 호출되는 방식
public interface CategoryMapper {
	/* 전체 조회 */
	List<Map<String, String>> jsonCategoryList(Map<String, Object> param) throws Exception; 
    /* 단건 조회 */
	Map<String, String> jsonCategoryDetail(String id) throws Exception;
	/* 등록 */
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
