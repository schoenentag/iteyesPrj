package egovframework.example.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.sample.service.MemberService;
import egovframework.example.sample.service.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper map;

	@Override
	public List<MemberVO> memberList() {
		return map.memberList();
	}

	@Override
	public int memberInsert(MemberVO vo) {
		
	
		return map.memberInsert(vo);
	}
	

}
