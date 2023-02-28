package egovframework.example.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import egovframework.example.board.service.BoardService;
import egovframework.example.cmmn.web.DataTableVO;

@Controller
public class BoardController {

    @Autowired
    BoardService service;

    // 게시글 목록 페이지 이동
    @RequestMapping("/goBoard.do")
    String goBoard() {
        return "board/boardList";
    }
    
    // 게시글 단건 페이지 이동
    @RequestMapping("/goBoardOne.do")
    String goBoardOne() {
        return "board/boardOne";
    }

    // 게시글 단건 조회
    @ResponseBody
    @RequestMapping("/boardOne.do")
    public Map<?, ?> boardOne(@RequestParam("id") String id) {
        System.out.println(id);
//        model.addAttribute("id", service.boardOne(id));
        return service.boardOne(id);
    }
    
    // 전체 게시글 목록
    @RequestMapping("/boardInfoProc.do")
    @ResponseBody
    public DataTableVO boardInfoProc(DataTableVO vo, @RequestParam Map<String,String> formData) {
        int draw = Integer.parseInt(formData.get("draw")); // 필수
        int start = Integer.parseInt(formData.get("start")); // 현 페이지의 첫 레코드의 순번(전체 레코드 중)
        int length = Integer.parseInt(formData.get("length")); // 페이지 당 레코드 수
        int order = Integer.parseInt(formData.get("order[0][column]")); // 정렬칼럼번호
        String orderDir = formData.get("order[0][dir]"); // 정렬방향(오름,내림차순)
        String uType = formData.get("uType"); // 카테고리 구분

        String schId = formData.get("columns[0][search][value]");
        String schCategory = formData.get("columns[1][search][value]");
        String schNoticeYn = formData.get("columns[2][search][value]");
        String schTitle = formData.get("columns[3][search][value]");
        String schContent = formData.get("columns[4][search][value]");
        String schRegUser = formData.get("columns[5][search][value]");
        String schDt = formData.get("columns[6][search][value]");
        String schViewCount = formData.get("columns[7][search][value]");
        String schFileName = formData.get("columns[8][search][value]");
        String schPw = formData.get("columns[9][search][value]");

        System.out.println(formData);
        System.out.println(start + " ▶ 현 페이지의 첫 레코드 순번(전체 레코드 중)");
        System.out.println(length + " ▶ 페이지 당 레코드 수");
        System.out.println(order + ", " + orderDir + " ▶ 정렬칼럼");
        System.out.println(uType + " ▶ 카테고리 구분" );

        // Map에 담기
        Map<String, Comparable> cri = new HashMap<String, Comparable>();
        cri.put("start", start);
        cri.put("length", length);
        cri.put("order", order);
        cri.put("orderDir", orderDir);
        cri.put("uType", uType);

        cri.put("schId", schId);
        cri.put("schCategory", schCategory);
        cri.put("schNoticeYn", schNoticeYn);
        cri.put("schTitle", schTitle);
        cri.put("schContent", schContent);
        cri.put("schRegUser", schRegUser);
        cri.put("schDt", schDt);
        cri.put("schViewCount", schViewCount);
        cri.put("schFileName", schFileName);
        cri.put("schPw", schPw);

        // 서비스 실행
        int total = (int) service.boardInfoCnt(cri);
        List<?> data = service.boardInfoProc(cri);

        vo.setDraw(draw);
        vo.setRecordsFiltered(total);
        vo.setRecordsTotal(total);
        vo.setData(data);

        return vo;
    }


    
    // 게시글 등록
    @RequestMapping("/boardInsertProc.do")
    public String boardInsertProc(@RequestParam Map<?,?> map) throws Exception {
        System.out.println("ejoifjwaeoifjw");
        System.out.println(map);
        service.boardInsertProc(map);
        return "redirect:goBoard.do";
    }
    
    
    
    
    @ResponseBody
    @RequestMapping("/selectBoardList.do")
    List<Map<?, ?>> selectBoardList() throws Exception {
        System.out.println("ttttttttttttttttttttttt");
        System.out.println(service.selectBoardList());
        return service.selectBoardList();
    }

    @ResponseBody
    @RequestMapping("/ex1.do")
    void ex1(@RequestBody Map<?,?> vo) throws Exception {
        System.out.println("ttttttttttttttttttttttt");
        System.out.println(vo);
    }

}
