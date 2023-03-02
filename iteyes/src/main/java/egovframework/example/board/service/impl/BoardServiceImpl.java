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

    @Override
    public Map<?, ?> boardOne(String id) {
        return mapper.boardOne(id);
    }

    @Override
    public void boardInsertProc(Map<?, ?> map) throws Exception {
        mapper.boardInsertProc(map);
    }

    @Override
    public void boardUpdateProc(Map<?, ?> map) throws Exception {
        mapper.boardUpdateProc(map);
    }

    @Override
    public void boardDelete(String id) throws Exception {
        mapper.boardDelete(id);
    }


}
