package egovframework.example.board.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import egovframework.example.board.service.CommentService;
import egovframework.example.board.service.CommentVO;

@Service("commentService")
public class CommentServiceImpl extends EgovAbstractServiceImpl implements CommentService {

	@Resource(name = "commentMapper")
	CommentMapper mapper;

	@Override
	public int insertComment(CommentVO vo) throws Exception {
		return mapper.insertComment(vo);
	}

	@Override
	public int updateComment(CommentVO vo) throws Exception {
		return mapper.updateComment(vo);
	}

	@Override
	public int deleteComment(CommentVO vo) throws Exception {
		int id = vo.getId();
		return mapper.deleteComment(id);
	}

	@Override
	public List<CommentVO> getComment(Map<?,?> info) throws Exception {
		return mapper.getComment(info);
	}

	@Override
	public int commentNum(Map<?, ?> map) throws Exception {
		return mapper.commentNum(map);
	}
	
	
}
