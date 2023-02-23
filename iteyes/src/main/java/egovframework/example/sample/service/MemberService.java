package egovframework.example.sample.service;

import java.util.List;
import java.util.Map;

public interface MemberService {
	
	List<MemberVO> memberList()  throws Exception;
	int memberInsert(MemberVO vo)  throws Exception;
	
	Map<String, String> jsonMemberList(Map<String, String> map) throws Exception;

}
