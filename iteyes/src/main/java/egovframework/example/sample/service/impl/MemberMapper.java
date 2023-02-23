package egovframework.example.sample.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.sample.service.MemberVO;

@Mapper("memberMapper")
//패키지를 포함하는 클래스명 부분이 mapper xml 상의 namespace가 선택되고 
//인터페이스 메소드가 query id로 호출되는 방식
public interface MemberMapper {
	
	List<MemberVO> memberList();
	int memberInsert(MemberVO vo);

}
