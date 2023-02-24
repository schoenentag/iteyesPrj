package egovframework.example.sample.service;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.util.EgovMap;

public interface MemberService {
	
	List<MemberVO> memberList()  throws Exception;
	int memberInsert(MemberVO vo)  throws Exception;
	
	//json type으로 통신시 사용되는 메소드
	List<Map<String, String>> jsonMemberList(Map<String, String> map) throws Exception;
	int jsonMemberInsert(Map<String, String>map) throws Exception;
	
	//EgovMap
	//EgovMap egovMemberList(Object parameterObject);

}
