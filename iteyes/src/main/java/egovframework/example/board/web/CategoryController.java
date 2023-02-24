package egovframework.example.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.board.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoriService;
	
	/* 전체조회 */
	@ResponseBody
	@RequestMapping("/jsonCategoryList.do")
	public List<Map<String,String>>jsonCategoryList() throws Exception{
		
		//List<EgovMap>
		return categoriService.jsonCategoryList();
	}
	
	/* 단건 조회 */
	@ResponseBody
	@RequestMapping("/jsonCategoryDetail.do")
	public Map<String,String>jsonCategoryDetail(Map<String,String> map) throws Exception{
		return categoriService.jsonCategoryDetail(map);
	}
	

}
