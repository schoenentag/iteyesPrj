package egovframework.example.board.service.impl;

import java.util.List;
import java.util.Map;


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
		System.out.println("인서트보드 임플");
		mapper.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) throws Exception {

	}

	@Override
	public void deleteBoard(BoardVO vo) throws Exception {

	}

	@Override
	public BoardVO selectBoard(BoardVO vo) throws Exception {
		return null;
	}

	@Override
	public List<Map<?,?>> selectBoardList() throws Exception {
		return mapper.selectBoardList();
	}

    @Override
    public int boardInfoCnt(Map<?, ?> cri) {
        return mapper.boardInfoCnt(cri);
    }

    @Override
    public List<Map<String, String>> boardInfoProc(Map<?, ?> cri) {
        return mapper.boardInfoProc(cri);
    }


}
