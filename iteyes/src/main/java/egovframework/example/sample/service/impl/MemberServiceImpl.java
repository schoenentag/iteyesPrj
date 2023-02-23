package egovframework.example.sample.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.sample.service.MemberService;
import egovframework.example.sample.service.MemberVO;


@Service("memberService")
@Resource(name="MemberMapper")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mMap;

	@Override
	public List<MemberVO> memberList() throws Exception {
		return mMap.memberList();
	}

	@Override
	public int memberInsert(MemberVO vo) throws Exception{
		
	System.out.println("service실행");
	    return mMap.memberInsert(vo);
	
		 
	}

	@Override
	public Map<String, String> jsonMemberList(Map<String, String> map) throws Exception {
		return mMap.jsonMemberList(map);
	}
	

}
