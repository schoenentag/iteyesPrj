package egovframework.example.board.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.board.service.CategoryService;
@Service("categoryService")
//@Resource(name="categoryMapper")
public class CategoryServiceImpl implements CategoryService {

	@Resource(name="categoryMapper")
	private CategoryMapper cMap;
	
	/* 전체 조회*/
	@Override
	public List<Map<String, String>> jsonCategoryList() throws Exception {
		return cMap.jsonCategoryList();
	}

	/* 단건 조회 */
	@Override
	public Map<String, String> jsonCategoryDetail(Map<String, String> map) throws Exception {
		return cMap.jsonCategoryDetail(map);
	}
	
	/* 등록 */
	@Override
	public int jsonCategoryInsert(Map<String, String>map) throws Exception{
		return cMap.jsonCategoryInsert(map);
	}

	/* 수정 */
	@Override
	public int jsonCategoryUpdate(Map<String, String> map) throws Exception {
		return cMap.jsonCategoryUpdate(map);
	}

	/* 삭제 */
	@Override
	public int jsonCategoryDelete(Map<String, String> map) throws Exception {
		return cMap.jsonCategoryDelete(map);
	}

	/* 검색 */
	@Override
	public List<Map<String, String>> jsonCategorySearch(Map<String, String> map) throws Exception {
		return cMap.jsonCategorySearch(map);
	}

}
