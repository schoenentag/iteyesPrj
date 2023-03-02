package egovframework.example.board.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public String boardInsertProc(@RequestParam Map<String, String> map, MultipartFile uploadFile) throws Exception {
        System.out.println(map);
        
        // 파일이 존재하면
        if (!uploadFile.isEmpty()) {
            // 저장파일명(난수활용)
            int ran = (int) (Math.random() * 9000) + 1000;
            String fileName = map.get("id") + "_" + ran + "_" + uploadFile.getOriginalFilename();
            
            // 파일 저장
            File saveFile = new File("C:/FileServer", fileName);
            uploadFile.transferTo(saveFile);
            
            // map에 추가하고 서비스로 넘김
            map.put("fileName", fileName);
            service.boardInsertProc(map);
        } else {
            service.boardInsertProc(map);
        }
        
        return "redirect:goBoard.do";
    }
    
    
    // 게시글 첨부파일 다운로드
    @RequestMapping("/downloadFile.do")
    public void download(HttpServletRequest request, HttpServletResponse response, String downloadFile) throws Exception {
        try {
//            String encodedFileName = EncodeFileName.getEncodedFileName(downloadFile, EncodeFileName.getBrowser(request));
//            System.out.println(encodedFileName);
            System.out.println(downloadFile);
            
            String path = "C:/FileServer/" + downloadFile;
            System.out.println(path);
            
            File file = new File(path);
            // downFileName: 다운창에 표시되는 이름. 한글변환(URLEncoder.encode), '+'문자를 공백(%20)으로 변환
            String downFileName = URLEncoder.encode(file.getName().substring(9,file.getName().length()),"UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-Disposition", "attachment;filename=" + downFileName); // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더
            
            FileInputStream fileInputStream = new FileInputStream(path); // 파일 읽어오기 
            OutputStream out = response.getOutputStream();
            
            int read = 0;
                byte[] buffer = new byte[1024];
                while ((read = fileInputStream.read(buffer)) != -1) { // 1024바이트씩 계속 읽으면서 outputStream에 저장, -1이 나오면 더이상 읽을 파일이 없음
                    out.write(buffer, 0, read);
                }
        } catch (Exception e) {
            throw new Exception("download error");
        }
    }
    
    
    
    
    // 게시글 수정
    @RequestMapping("/boardUpdateProc.do")
    public String boardUpdateProc(@RequestParam Map<?,?> map) throws Exception {
        System.out.println(map);
        service.boardUpdateProc(map);
        return "redirect:goBoardOne.do";
    }
    
    
    // 게시글 삭제
    @ResponseBody
    @RequestMapping("/boardDelete.do")
    public void boardDelete(@RequestParam("id") String id) throws Exception {
        System.out.println(id);
        service.boardDelete(id);
    }
    
    
    
    
    
    /*
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
    */

}
