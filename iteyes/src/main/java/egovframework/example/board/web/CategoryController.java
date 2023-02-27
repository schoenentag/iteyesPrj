package egovframework.example.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.board.service.CategoryService;
import egovframework.example.board.service.Pagination;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoriService;
	
	/* 페이지 이동 */
	@RequestMapping("/categoryPage2.do")
	public String categoryList() {
		//System.out.println("controller");
		return "board/categoryPage2";
	}
	
	/* 전체조회 */
	@ResponseBody
	@RequestMapping("/jsonCategoryList.do")
	public List<Map<String,String>>jsonCategoryList(@RequestParam(defaultValue="1") int curPage) throws Exception{
		// param : 현재페이지 default 1,   
		System.out.println("jsonCategoryList contoller 실행");
		
		/*전체글 갯수 조회*/
		int listCnt = categoriService.CategorListyCnt();
		
		/*pagination 인스턴스 생성 (param :  전체 개시글 개수, 현재 페이지*/ 
		Pagination pn = new Pagination(listCnt, curPage);
		System.out.println("=========pn : "+pn);
		
		Map<String, Object> param = new HashMap<>();
		/* 받아온 값을 map에 담음*/
		System.out.println("pn.getStartIndex() : "+ pn.getStartIndex());
		System.out.println("pn.getPageSize() : "+ pn.getPageSize());
		param.put("pageStart", pn.getPageSize());
		param.put("perPageNum", pn.getStartIndex());
		 
		return categoriService.jsonCategoryList(param);
	}
	
	/* 페이징 처리 */
	@ResponseBody
	@RequestMapping("/pagination.do")
	public Pagination pagination(@RequestParam(defaultValue="1") int curPage) throws Exception{
		System.out.println("****************************************** /pagination.do curpage : "+ curPage);
		/*전체글 갯수 조회*/
		int listCnt = categoriService.CategorListyCnt();
		/*pagination 인스턴스 생성 (param :  전체 개시글 개수, 현재 페이지*/ 
		Pagination pn = new Pagination(listCnt, curPage);
		
		return pn;
	}
	
	/* 등록 페이지 이동 */
	@RequestMapping("/categoryInsertForm.do")
	public String categoryDetailPage() {
		return "board/categoryInsert";
	}
	/* 삭제 */
	@RequestMapping("/categoryDelete.do")
	public int categoryDelete(Map<String,String> map) throws Exception {
		return categoriService.jsonCategoryDelete(map);
	}
	
	
	/* 단건 조회 */
	@ResponseBody
	@RequestMapping("/jsonCategoryDetail.do")
	public Map<String,String>jsonCategoryDetail(Map<String,String> map) throws Exception{
		return categoriService.jsonCategoryDetail(map);
	}
	

}
