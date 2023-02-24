package egovframework.example.board.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.board.service.BoardService;
import egovframework.example.board.service.BoardVO;
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper mapper;

	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("인서트보드 임플");
		mapper.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO selectBoard(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<?,?>> selectBoardList() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectBoardList();
	}


}
