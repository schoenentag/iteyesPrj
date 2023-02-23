package egovframework.example.sample.service;

import java.util.List;

public interface MemberService {
	
	List<MemberVO> memberList();
	int memberInsert(MemberVO vo);

}
