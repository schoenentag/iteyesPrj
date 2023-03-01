package egovframework.example.board.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.board.service.CategoryService;
import egovframework.example.board.service.CategoryVO;
@Service("categoryService")
//@Resource(name="categoryMapper")
public class CategoryServiceImpl implements CategoryService {

	@Resource(name="categoryMapper")
	private CategoryMapper cMap;
	
	/* 전체 조회*/
	@Override
	public List<Map<String, String>> jsonCategoryList(Map<String, Object> param) throws Exception {
		return cMap.jsonCategoryList(param);
	}

	/* 단건 조회 */
	@Override
	public Map<String, String> jsonCategoryDetail(String id)  throws Exception {
		return cMap.jsonCategoryDetail(id);
	}
	
	/* 등록 */
	@Override
	public int jsonCategoryInsert(Map<String, String>map) throws Exception{
		return cMap.jsonCategoryInsert(map);
	}

	/* 수정 */
	@Override
	public int jsonCategoryUpdate(CategoryVO vo) throws Exception {
		return cMap.jsonCategoryUpdate(vo);
	}

	/* 삭제 */
	@Override
	public int jsonCategoryDelete(String id) throws Exception {
		return cMap.jsonCategoryDelete(id);
	}

	/* 검색 */
	@Override
	public List<Map<String, Object>> jsonCategorySearch(Map<String, Object> map) throws Exception {
		return cMap.jsonCategorySearch(map);
	}

	/* 전체글 cnt */
	@Override
	public int CategoryListyCnt() throws Exception {
		return cMap.CategoryListyCnt();
	}

	@Override
	public int jsonCategoryInsert2(CategoryVO vo) throws Exception {
		return cMap.jsonCategoryInsert2(vo);
	}

	@Override
	public int CategorySearchCnt(Map<String, Object> map) throws Exception {
		return cMap.CategorySearchCnt(map);
	}

}
