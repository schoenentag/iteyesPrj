package egovframework.example.sample.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.sample.service.MemberService;
import egovframework.example.sample.service.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@ResponseBody
	@RequestMapping("/memberInsert.do")
	public List<MemberVO>ajaxMemberInsert(@RequestBody MemberVO vo) throws Exception {
		//public List<MemberVO>ajaxMemberInsert(MemberVO vo) throws Exception {
	
		System.out.println("controller는 실행");
		System.out.println(vo);
		//return memberService.jsonMemberList(mMap);
		
		//Map<> → Object 변환
		//ObjectMapper objectMapper = new ObjectMapper();
		//파라미터Map에서 DTO에 들어있지 않는 변수가 있어도 무시함.
		//objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		//MemberVO mVO = objectMapper.convertValue(mMap.get("MemberVO"), MemberVO.class); //형변환 
		//System.out.println(mVO);
		//return map;
		try {
		    int i = memberService.memberInsert(vo);
			//int i = memberService.jsonMemberInsert(mMap);
		    
			if(i>0) {
				System.out.println("success");
				//List<Map<String, String>> test =memberService.jsonMemberList(mMap);
				List<MemberVO> test = memberService.memberList();
				System.out.println(test);
				
				return  test;
			}else {
				System.out.println("fail");
				return  null;
			}
		}catch(Exception e) {
			System.out.println("err");
			e.printStackTrace();
			return null;
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/memberListTest.do")
	public List<Map<?,?>> memberListTest(@RequestBody List<Map<?,?>> listMap){
		System.out.println("memberList.do controller");
		System.out.println(listMap);
		return listMap;
	}

}
