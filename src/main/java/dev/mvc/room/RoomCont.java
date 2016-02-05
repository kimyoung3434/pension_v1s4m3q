package dev.mvc.room;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.room.RoomDAO;
import dev.mvc.room.RoomVO;
import web.tool.Tool;
import web.tool.Upload;

@Controller
public class RoomCont {
  @Autowired
  @Qualifier("dev.mvc.room.RoomDAO")
  private RoomDAO roomDAO;

  public RoomCont() {
    System.out.println("--> RoomCont created.");
  }

  // 내용,파일 등록
  @RequestMapping(value = "/room/create.do", method = RequestMethod.GET)
  public ModelAndView create(RoomVO roomVO) {
    // System.out.println("--> create() GET called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/room/create"); // /webapp/blog/create.jsp
    mav.addObject("roomVO", roomVO);

    return mav;
  }

  @RequestMapping(value = "/room/create.do", method = RequestMethod.POST)
  public ModelAndView create(RoomVO roomVO, HttpServletRequest request) {
    // System.out.println("--> create() POST called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/room/message");

    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();

    // --------------------------------------------------
    // Thumb 파일 전송 관련
    // --------------------------------------------------
    String absPath = Tool.getRealPath(request, "/room/storage");

    String file = "";
    // 파일을 선택하지 않아도 객체가 생성됨.
    MultipartFile fileMF = roomVO.getFileMF();
    if (fileMF.getSize() > 0) {
      file = Upload.saveFileSpring(fileMF, absPath);
    }
    roomVO.setFile(file); // 전송된 파일명 저장

    // --------------------------------------------------

    // --------------------------------------------------
    // 파일 전송 관련
    // --------------------------------------------------

    String file1 = "";
    MultipartFile file1MF = roomVO.getFile1MF();
    if (file1MF.getSize() > 0) {
      file1 = Upload.saveFileSpring(file1MF, absPath);
    }
    roomVO.setFile1(file1); // 전송된 파일명 저장
    

    String file2 = "";
    MultipartFile file2MF = roomVO.getFile2MF();
    if (file2MF.getSize() > 0) {
      file2 = Upload.saveFileSpring(file2MF, absPath);
    }
    roomVO.setFile2(file2); // 전송된 파일명 저장

    String file3 = "";
    MultipartFile file3MF = roomVO.getFile3MF();
    if (file3MF.getSize() > 0) {
      file3 = Upload.saveFileSpring(file3MF, absPath);
    }
    roomVO.setFile3(file3); // 전송된 파일명 저장

    String file4 = "";
    MultipartFile file4MF = roomVO.getFile4MF();
    if (file4MF.getSize() > 0) {
      file4 = Upload.saveFileSpring(file4MF, absPath);
    }
    roomVO.setFile4(file4); // 전송된 파일명 저장
    
    String file5 = "";
    MultipartFile file5MF = roomVO.getFile5MF();
      if (file5MF.getSize() > 0) {
        file5 = Upload.saveFileSpring(file5MF, absPath);
      }
      roomVO.setFile5(file5); // 전송된 파일명 저장

    // --------------------------------------------------

    if (roomDAO.create(roomVO) == 1) {
      msgs.add("글을 등록했습니다.");
      links.add("<button type='button' onclick=\"location.href='./create.do'\">계속 등록</button>");
    } else {
      msgs.add("글 등록에 실패했습니다.");
      msgs.add("다시 시도해주세요.");
      links.add("<button type='button' onclick=\"history.back()\">다시시도</button>");
    }

    links.add("<button type='button' onclick=\"location.href='./home.do'\">홈페이지</button>");
    links.add(
        "<button type='button' onclick=\"location.href='./list.do?roomno=" + roomVO.getRoomno() + "'\">목록</button>");
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);

    return mav;
  }

  // 목록
  @RequestMapping(value = "/room/list.do", method = RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/room/list");
    mav.addObject("list", roomDAO.list());

    return mav;
  }

  // 조회
  @RequestMapping(value = "/room/read.do", method = RequestMethod.GET)
  public ModelAndView read(int roomno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/room/read");
    mav.addObject("roomVO", roomDAO.read(roomno));

    return mav;
  }

  // 수정
  /**
   * 수정폼
   * 
   * @param blogno
   * @return
   */
  @RequestMapping(value = "/room/update.do", method = RequestMethod.GET)
  public ModelAndView update(int roomno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/room/update");

    RoomVO roomVO = roomDAO.read(roomno);
    mav.addObject("roomVO", roomVO);

    return mav;

  }

  /**
   * 수정 처리
   * 
   * @param roomVO
   * @return
   */
  @RequestMapping(value = "/room/update.do", method = RequestMethod.POST)
  public ModelAndView update(RoomVO roomVO, HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/room/message");

    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();

    RoomVO roomVO_old = roomDAO.read(roomVO.getRoomno());
    
    // --------------------------------------------------
    // Thumb 파일 전송 관련
    // --------------------------------------------------
    String absPath = Tool.getRealPath(request, "/room/storage");
    
    String file = "";
    MultipartFile fileMF = roomVO.getFileMF();
      if (fileMF.getSize() > 0) {
        Tool.deleteFile(absPath + roomVO_old.getFile());//기존파일삭제
        file = Upload.saveFileSpring(fileMF, absPath);//새로운 파일 전송
        roomVO.setFile(file); // 전송된 파일명 저장
      }else{
      roomVO.setFile(roomVO_old.getFile());// 기존의 파일명 저장
    }
    // --------------------------------------------------

    // --------------------------------------------------
    // 파일 전송 관련
    // --------------------------------------------------

    String file1 = "";
    MultipartFile file1MF = roomVO.getFile1MF();
      if (file1MF.getSize() > 0) {
        Tool.deleteFile(absPath + roomVO.getFile1());
        file1 = Upload.saveFileSpring(file1MF, absPath);
        roomVO.setFile1(file1); // 전송된 파일명 저장
      }else{
        roomVO.setFile1(roomVO_old.getFile1());
    }

    String file2 = "";
    MultipartFile file2MF = roomVO.getFile2MF();
      if (file2MF.getSize() > 0) {
        Tool.deleteFile(absPath + roomVO.getFile2());
        file2 = Upload.saveFileSpring(file2MF, absPath);
        roomVO.setFile2(file2); // 전송된 파일명 저장
      }else{
        roomVO.setFile2(roomVO_old.getFile2());
    }

    String file3 = "";
    MultipartFile file3MF = roomVO.getFile3MF();
      if (file3MF.getSize() > 0) {
        Tool.deleteFile(absPath + roomVO.getFile3());
        file3 = Upload.saveFileSpring(file3MF, absPath);
        roomVO.setFile3(file3); // 전송된 파일명 저장
      }else{
        roomVO.setFile3(roomVO_old.getFile3());
    }

    String file4 = "";
    MultipartFile file4MF = roomVO.getFile4MF();
      if (file4MF.getSize() > 0) {
        Tool.deleteFile(absPath + roomVO.getFile4());
        file4 = Upload.saveFileSpring(file4MF, absPath);
        roomVO.setFile4(file4); // 전송된 파일명 저장
      }else{
        roomVO.setFile4(roomVO_old.getFile4());
    }

    String file5 = "";
    MultipartFile file5MF = roomVO.getFile5MF();
      if (file5MF.getSize() > 0) {
        Tool.deleteFile(absPath + roomVO.getFile5());
        file5 = Upload.saveFileSpring(file5MF, absPath);
        roomVO.setFile5(file5); // 전송된 파일명 저장
      }else{
        roomVO.setFile5(roomVO_old.getFile5());
    }
    // --------------------------------------------------

    if (roomDAO.update(roomVO) == 1) {
      // 수정후 조회로 자동 이동
      /*
       * mav.setViewName("redirect:/room/read.do?roomno=" + roomVO.getRoomno() +
       * "&roomno=" + roomVO.getRoomno()); // 확장자 명시
       */

      msgs.add("수정되었습니다.");

    } else {
      msgs.add("게시판 수정에 실패 하셨습니다.");
      links.add("<button type='button' onclick=\"history.back()\">다시 시도</button>");
      links.add(
          "<button type='button' onclick=\"location.href='./list.do?roomno=" + roomVO.getRoomno() + "'\">목록</button>");
    }
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    links.add(
        "<button type='button' onclick=\"location.href='./list.do?roomno=" + roomVO.getRoomno() + "'\">목록</button>");

    return mav;
  }

  // 삭제
  /**
   * 삭제폼
   * 
   * @param roomno
   * @return
   */
  @RequestMapping(value = "/room/delete.do", method = RequestMethod.GET)
  public ModelAndView delete(int roomno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/room/delete"); // /webapp/member/delete.jsp
    mav.addObject("roomno", roomno);

    return mav;
  }

  /**
   * 삭제 처리
   * 
   * @param blogVO
   * @return
   */
  @RequestMapping(value = "/room/delete.do", method = RequestMethod.POST)
  public ModelAndView delete(RoomVO roomVO, HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/room/message");

    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();

    // --------------------------------------------------
    // Thumb 파일 삭제
    // --------------------------------------------------
    RoomVO vo = roomDAO.read(roomVO.getRoomno());
    String absPath = Tool.getRealPath(request, "/room/storage");
    Tool.deleteFile(absPath + vo.getOldfile());
    // --------------------------------------------------

    // --------------------------------------------------
    // 파일 전송 관련
    // --------------------------------------------------
    Tool.deleteFile(absPath + vo.getOldfile1());
    Tool.deleteFile(absPath + vo.getOldfile2());
    Tool.deleteFile(absPath + vo.getOldfile3());
    Tool.deleteFile(absPath + vo.getOldfile4());
    Tool.deleteFile(absPath + vo.getOldfile5());
    // --------------------------------------------------

    if (roomDAO.delete(roomVO.getRoomno()) == 1) {
      // 삭제 후 조회로 자동이동
      /*
       * mav.setViewName("redirect:/room/list.do?roomno=" + roomVO.getRoomno());
       * // 확장자 명시
       */

      msgs.add("삭제되었습니다.");
    } else {
      msgs.add("글 삭제에 실패했습니다.");
      links.add("<button type='button' onclick=\"history.back()\">다시시도</button>");
      links.add("<button type='button' onclick=\"location.href='./home.do'\">홈페이지</button>");
      links.add(
          "<button type='button' onclick=\"location.href='./list.do?roomno=" + roomVO.getRoomno() + "'\">목록</button>");
    }

    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    links.add(
        "<button type='button' onclick=\"location.href='./list.do?roomno=" + roomVO.getRoomno() + "'\">목록</button>");

    return mav;
  }

}