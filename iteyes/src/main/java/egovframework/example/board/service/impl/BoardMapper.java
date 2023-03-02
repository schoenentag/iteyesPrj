package egovframework.example.board.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.board.service.BoardVO;
@Mapper
public interface BoardMapper {

    // 전체 게시글 목록
    int boardInfoCnt(Map<?, ?> cri);
    List<Map<String, String>> boardInfoProc(Map<?, ?> cri);
    
    // 게시글 단건 조회
    Map<?, ?> boardOne(String id);
    
    // 게시글 등록
    void boardInsertProc(Map<?,?> map) throws Exception;
    
    // 게시글 수정
    void boardUpdateProc(Map<?,?> map) throws Exception;
    
    // 게시글 삭제
    void boardDelete(String id) throws Exception;
    
    
    /**
     * 글 목록을 조회한다.
     * 
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return 글 목록
     * @exception Exception
     */
    List<Map<?, ?>> selectBoardList() throws Exception;

}
