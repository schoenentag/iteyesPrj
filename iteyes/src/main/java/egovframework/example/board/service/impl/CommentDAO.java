package egovframework.example.board.service.impl;

import org.egovframe.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.stereotype.Repository;

import egovframework.example.board.service.CommentVO;

@Repository("commentDAO")
public class CommentDAO extends EgovAbstractDAO {

	/**
	 * 글을 등록한다.
	 * @param vo - 등록할 정보가 담긴 CommentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertComment(CommentVO vo) throws Exception {
		return (String) insert("commentDAO.insertComment", vo);
	}
}
