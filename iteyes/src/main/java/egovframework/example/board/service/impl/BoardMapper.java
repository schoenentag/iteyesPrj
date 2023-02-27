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
    /**
     * 글을 등록한다.
     * 
     * @param vo - 등록할 정보가 담긴 BoardVO
     * @return 등록 결과
     * @exception Exception
     */
    void insertBoard(BoardVO vo) throws Exception;

    /**
     * 글을 수정한다.
     * 
     * @param vo - 수정할 정보가 담긴 BoardVO
     * @return void형
     * @exception Exception
     */
    void updateBoard(BoardVO vo) throws Exception;

    /**
     * 글을 삭제한다.
     * 
     * @param vo - 삭제할 정보가 담긴 BoardVO
     * @return void형
     * @exception Exception
     */
    void deleteBoard(BoardVO vo) throws Exception;

    /**
     * 글을 조회한다.
     * 
     * @param vo - 조회할 정보가 담긴 BoardVO
     * @return 조회한 글
     * @exception Exception
     */
    BoardVO selectBoard(BoardVO vo) throws Exception;

    /**
     * 글 목록을 조회한다.
     * 
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return 글 목록
     * @exception Exception
     */
    List<Map<?, ?>> selectBoardList() throws Exception;

}
