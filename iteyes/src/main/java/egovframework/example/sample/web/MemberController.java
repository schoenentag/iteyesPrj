package egovframework.example.sample.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.example.sample.service.MemberService;
import egovframework.example.sample.service.MemberVO;

@RestController
public class MemberController {
	
	@Autowired
	private MemberService dao;
	
	@RequestMapping("/memberList")
	public List<MemberVO> memberList(MemberVO vo) {
		System.out.println("list controller 성공");
		
		try {
			
			dao.memberInsert(vo);
			
			return dao.memberList();
			
		} catch (Exception e) {
			System.out.println("exception");
			
			return null;
		}
		
	}
	

}