package egovframework.example.board.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.board.service.CommentVO;

@Mapper("commentMapper")
public interface CommentMapper {

	//입력
	public int insertComment(CommentVO vo) throws Exception;
	//내용 수정
	public int updateComment(CommentVO vo) throws Exception;
	//삭제
	public int deleteComment(int id) throws Exception;
	//조회
	public List<CommentVO> getComment(Map<?, ?> map) throws Exception;
	//댓글 수
	public int commentNum(Map<?, ?> map) throws Exception;
}
