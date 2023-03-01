package egovframework.example.board.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.board.service.CategoryService;
import egovframework.example.board.service.CategoryVO;
import egovframework.example.board.service.Pagination;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	/* 페이지 이동(indexPage) */
	@RequestMapping("/categoryPage2.do")
	public String categoryList() {
		return "board/categoryPage2";
	}
	
	/* 전체조회 */
	@ResponseBody
	@RequestMapping("/jsonCategoryList.do")
	public List<Map<String,String>>jsonCategoryList(@RequestBody Map<String,Integer> map) throws Exception{
		System.out.println("jsonCategoryList contoller 실행");
		System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLIST /jsonCategoryList.do curPage: " + map.get("curPage"));
		/*전체글 갯수 조회*/
		int curPage = 1;
		int listCnt = categoryService.CategoryListyCnt();
		
		if (map.get("curPage") != null  ) {
			//&& map.get("curPage").isEmpty() X
			curPage = map.get("curPage"); 
		} 
		Pagination pn = new Pagination(listCnt,curPage);
		
		Map<String, Object> param = new HashMap<>();
		/* 받아온 값을 map에 담음*/
		param.put("pageStart", pn.getPageSize());
		param.put("perPageNum", pn.getStartIndex());
		 
		return categoryService.jsonCategoryList(param);
	}
	
	/* 페이징 처리 */
	@ResponseBody
	@RequestMapping("/pagination.do")
	public Pagination pagination(@RequestParam(defaultValue="1") int curPage) throws Exception{
		/*전체글 갯수 조회*/
		int listCnt = categoryService.CategoryListyCnt();
		/*pagination 인스턴스 생성 (param :  전체 개시글 개수, 현재 페이지*/ 
		Pagination pn = new Pagination(listCnt, curPage);
		return pn;
	}
	
	/* 페이지 이동 test*/
	@ResponseBody
	@RequestMapping(value="/paginationMove.do")
	public Pagination paginationMove(@RequestBody Map<String,Integer> map) throws Exception{
		
		/*전체글 갯수 조회*/
		int listCnt = categoryService.CategoryListyCnt();
		Pagination pn = new Pagination(listCnt, map.get("curPage"));
		
		return pn;
	}
	
	
	/* 등록 페이지 이동 */
	@GetMapping("/categoryInsertForm.do")
	public String categoryInsertForm() {
		System.out.println("categoryInsertForm controller");
		return "board/categoryInsertForm";
	}
	
	/* 카테고리 등록 */
	@ResponseBody
	@RequestMapping(value="/categoryInsert.do", method=RequestMethod.POST)
	public int categoryInsert(@RequestBody Map<String,String> map) throws Exception{
        
		/* 받아온 map의 value를 vo에 담기 */
		CategoryVO vo = new CategoryVO();
		vo.setName(map.get("name"));
		vo.setDescription(map.get("description"));
		vo.setUseYn(map.get("useYn"));
		vo.setRegUser(map.get("regUser"));
		
		return categoryService.jsonCategoryInsert2(vo);
	}
	
	/* 카테고리 수정*/
	@ResponseBody
	@RequestMapping(value="/categoryUpdate.do", method=RequestMethod.POST)
	public int categoryUpdate(@RequestBody Map<String,String> map) throws Exception{
		
		/* 받아온 map의 value를 vo에 담기 */
		CategoryVO vo = new CategoryVO();
		vo.setId(map.get("id"));
		vo.setName(map.get("name"));
		vo.setDescription(map.get("description"));
		vo.setUseYn(map.get("useYn"));
		vo.setRegUser(map.get("regUser"));
		
		return categoryService.jsonCategoryUpdate(vo);
	}
	
	/* 삭제 */
	@ResponseBody
	@RequestMapping(value="/categoryDelete.do", method=RequestMethod.POST)
	public int categoryDelete(@RequestBody List<Map<String,String>> map) throws Exception {
		int n = 0;
		//@RequestParam(value="checkBoxArr[]") String[] id 인식불가
		
	    //id 값만 담기
		List<String> ids = new ArrayList<>();
		for (int i = 0; i < map.size(); i++){	
		    ids.add(map.get(i).get("id"));
		}
		
	     for(String id : ids ) {
			 n = categoryService.jsonCategoryDelete(id);
		}
			
		return n;
	}
	
	
	/* 단건 조회 페이지 이동*/
	@RequestMapping("/categoryDetail.do")
	public String categoryDetail() throws Exception{
		return "board/categoryDetail";
	}
	
	/* 단건 조회 */
	@ResponseBody
	@GetMapping("/categoryDetailList.do")
	public Map<String, String> categoryDetailList(@RequestParam String id) throws Exception{
		return categoryService.jsonCategoryDetail(id);
	}
	
	/* 검색 */
	@ResponseBody
	@RequestMapping("/categorySearch.do")
	public  List<Map<String,Object>> categorySearch(@RequestBody Map<String, Object> map) throws Exception{
		System.out.println("Search map-------------------- : "+ map);
		int curPage = 1;
		
		/* 검색글 cnt 조회*/
		int listCnt = categoryService.CategorySearchCnt(map);
		
		if (map.get("curPage") != null  ) {
			curPage = Integer.parseInt((String)map.get("curPage"));
		} 
		
		Pagination pn = new Pagination(listCnt,curPage);
		
		Map<String, Object> param = new HashMap<>();
		/* 받아온 값을 map에 담음*/
		param.put("key", map.get("key"));
		param.put("value", map.get("value"));
		param.put("pageStart", pn.getPageSize());
		param.put("perPageNum", pn.getStartIndex());
		
		return categoryService.jsonCategorySearch(param);
	}

}
