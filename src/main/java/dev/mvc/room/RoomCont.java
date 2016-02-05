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

  // ����,���� ���
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
    // Thumb ���� ���� ����
    // --------------------------------------------------
    String absPath = Tool.getRealPath(request, "/room/storage");

    String file = "";
    // ������ �������� �ʾƵ� ��ü�� ������.
    MultipartFile fileMF = roomVO.getFileMF();
    if (fileMF.getSize() > 0) {
      file = Upload.saveFileSpring(fileMF, absPath);
    }
    roomVO.setFile(file); // ���۵� ���ϸ� ����

    // --------------------------------------------------

    // --------------------------------------------------
    // ���� ���� ����
    // --------------------------------------------------

    String file1 = "";
    MultipartFile file1MF = roomVO.getFile1MF();
    if (file1MF.getSize() > 0) {
      file1 = Upload.saveFileSpring(file1MF, absPath);
    }
    roomVO.setFile1(file1); // ���۵� ���ϸ� ����
    

    String file2 = "";
    MultipartFile file2MF = roomVO.getFile2MF();
    if (file2MF.getSize() > 0) {
      file2 = Upload.saveFileSpring(file2MF, absPath);
    }
    roomVO.setFile2(file2); // ���۵� ���ϸ� ����

    String file3 = "";
    MultipartFile file3MF = roomVO.getFile3MF();
    if (file3MF.getSize() > 0) {
      file3 = Upload.saveFileSpring(file3MF, absPath);
    }
    roomVO.setFile3(file3); // ���۵� ���ϸ� ����

    String file4 = "";
    MultipartFile file4MF = roomVO.getFile4MF();
    if (file4MF.getSize() > 0) {
      file4 = Upload.saveFileSpring(file4MF, absPath);
    }
    roomVO.setFile4(file4); // ���۵� ���ϸ� ����
    
    String file5 = "";
    MultipartFile file5MF = roomVO.getFile5MF();
      if (file5MF.getSize() > 0) {
        file5 = Upload.saveFileSpring(file5MF, absPath);
      }
      roomVO.setFile5(file5); // ���۵� ���ϸ� ����

    // --------------------------------------------------

    if (roomDAO.create(roomVO) == 1) {
      msgs.add("���� ����߽��ϴ�.");
      links.add("<button type='button' onclick=\"location.href='./create.do'\">��� ���</button>");
    } else {
      msgs.add("�� ��Ͽ� �����߽��ϴ�.");
      msgs.add("�ٽ� �õ����ּ���.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽýõ�</button>");
    }

    links.add("<button type='button' onclick=\"location.href='./home.do'\">Ȩ������</button>");
    links.add(
        "<button type='button' onclick=\"location.href='./list.do?roomno=" + roomVO.getRoomno() + "'\">���</button>");
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);

    return mav;
  }

  // ���
  @RequestMapping(value = "/room/list.do", method = RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/room/list");
    mav.addObject("list", roomDAO.list());

    return mav;
  }

  // ��ȸ
  @RequestMapping(value = "/room/read.do", method = RequestMethod.GET)
  public ModelAndView read(int roomno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/room/read");
    mav.addObject("roomVO", roomDAO.read(roomno));

    return mav;
  }

  // ����
  /**
   * ������
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
   * ���� ó��
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
    // Thumb ���� ���� ����
    // --------------------------------------------------
    String absPath = Tool.getRealPath(request, "/room/storage");
    
    String file = "";
    MultipartFile fileMF = roomVO.getFileMF();
      if (fileMF.getSize() > 0) {
        Tool.deleteFile(absPath + roomVO_old.getFile());//�������ϻ���
        file = Upload.saveFileSpring(fileMF, absPath);//���ο� ���� ����
        roomVO.setFile(file); // ���۵� ���ϸ� ����
      }else{
      roomVO.setFile(roomVO_old.getFile());// ������ ���ϸ� ����
    }
    // --------------------------------------------------

    // --------------------------------------------------
    // ���� ���� ����
    // --------------------------------------------------

    String file1 = "";
    MultipartFile file1MF = roomVO.getFile1MF();
      if (file1MF.getSize() > 0) {
        Tool.deleteFile(absPath + roomVO.getFile1());
        file1 = Upload.saveFileSpring(file1MF, absPath);
        roomVO.setFile1(file1); // ���۵� ���ϸ� ����
      }else{
        roomVO.setFile1(roomVO_old.getFile1());
    }

    String file2 = "";
    MultipartFile file2MF = roomVO.getFile2MF();
      if (file2MF.getSize() > 0) {
        Tool.deleteFile(absPath + roomVO.getFile2());
        file2 = Upload.saveFileSpring(file2MF, absPath);
        roomVO.setFile2(file2); // ���۵� ���ϸ� ����
      }else{
        roomVO.setFile2(roomVO_old.getFile2());
    }

    String file3 = "";
    MultipartFile file3MF = roomVO.getFile3MF();
      if (file3MF.getSize() > 0) {
        Tool.deleteFile(absPath + roomVO.getFile3());
        file3 = Upload.saveFileSpring(file3MF, absPath);
        roomVO.setFile3(file3); // ���۵� ���ϸ� ����
      }else{
        roomVO.setFile3(roomVO_old.getFile3());
    }

    String file4 = "";
    MultipartFile file4MF = roomVO.getFile4MF();
      if (file4MF.getSize() > 0) {
        Tool.deleteFile(absPath + roomVO.getFile4());
        file4 = Upload.saveFileSpring(file4MF, absPath);
        roomVO.setFile4(file4); // ���۵� ���ϸ� ����
      }else{
        roomVO.setFile4(roomVO_old.getFile4());
    }

    String file5 = "";
    MultipartFile file5MF = roomVO.getFile5MF();
      if (file5MF.getSize() > 0) {
        Tool.deleteFile(absPath + roomVO.getFile5());
        file5 = Upload.saveFileSpring(file5MF, absPath);
        roomVO.setFile5(file5); // ���۵� ���ϸ� ����
      }else{
        roomVO.setFile5(roomVO_old.getFile5());
    }
    // --------------------------------------------------

    if (roomDAO.update(roomVO) == 1) {
      // ������ ��ȸ�� �ڵ� �̵�
      /*
       * mav.setViewName("redirect:/room/read.do?roomno=" + roomVO.getRoomno() +
       * "&roomno=" + roomVO.getRoomno()); // Ȯ���� ���
       */

      msgs.add("�����Ǿ����ϴ�.");

    } else {
      msgs.add("�Խ��� ������ ���� �ϼ̽��ϴ�.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽ� �õ�</button>");
      links.add(
          "<button type='button' onclick=\"location.href='./list.do?roomno=" + roomVO.getRoomno() + "'\">���</button>");
    }
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    links.add(
        "<button type='button' onclick=\"location.href='./list.do?roomno=" + roomVO.getRoomno() + "'\">���</button>");

    return mav;
  }

  // ����
  /**
   * ������
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
   * ���� ó��
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
    // Thumb ���� ����
    // --------------------------------------------------
    RoomVO vo = roomDAO.read(roomVO.getRoomno());
    String absPath = Tool.getRealPath(request, "/room/storage");
    Tool.deleteFile(absPath + vo.getOldfile());
    // --------------------------------------------------

    // --------------------------------------------------
    // ���� ���� ����
    // --------------------------------------------------
    Tool.deleteFile(absPath + vo.getOldfile1());
    Tool.deleteFile(absPath + vo.getOldfile2());
    Tool.deleteFile(absPath + vo.getOldfile3());
    Tool.deleteFile(absPath + vo.getOldfile4());
    Tool.deleteFile(absPath + vo.getOldfile5());
    // --------------------------------------------------

    if (roomDAO.delete(roomVO.getRoomno()) == 1) {
      // ���� �� ��ȸ�� �ڵ��̵�
      /*
       * mav.setViewName("redirect:/room/list.do?roomno=" + roomVO.getRoomno());
       * // Ȯ���� ���
       */

      msgs.add("�����Ǿ����ϴ�.");
    } else {
      msgs.add("�� ������ �����߽��ϴ�.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽýõ�</button>");
      links.add("<button type='button' onclick=\"location.href='./home.do'\">Ȩ������</button>");
      links.add(
          "<button type='button' onclick=\"location.href='./list.do?roomno=" + roomVO.getRoomno() + "'\">���</button>");
    }

    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    links.add(
        "<button type='button' onclick=\"location.href='./list.do?roomno=" + roomVO.getRoomno() + "'\">���</button>");

    return mav;
  }

}