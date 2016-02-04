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
  
 
  public RoomCont(){
    System.out.println("--> RoomCont created.");
  }
  
  //����,���� ���
  @RequestMapping(value="/room/create.do", method=RequestMethod.GET)
  public ModelAndView create(RoomVO roomVO){
    // System.out.println("--> create() GET called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/room/create");   // /webapp/blog/create.jsp
    mav.addObject("roomVO", roomVO);
    
    return mav;
  }

  @RequestMapping(value="/room/create.do", method=RequestMethod.POST)
  public ModelAndView create(RoomVO roomVO, HttpServletRequest request){
    // System.out.println("--> create() POST called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/room/message");

    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    // --------------------------------------------------
    // Thumb ���� ���� ����
    // --------------------------------------------------
    String file = "";
    String absPath = Tool.getRealPath(request, "/room/storage");
    MultipartFile fileMF = roomVO.getFileMF();
    if (fileMF != null){
      if (fileMF.getSize() > 0){
        file = Upload.saveFileSpring(fileMF, absPath);
        roomVO.setFile(file); // ���۵� ���ϸ� ����
      }
    }
    // --------------------------------------------------
    
    // --------------------------------------------------
    // ���� ���� ����
    // --------------------------------------------------
    
    String file1 = "";
    MultipartFile file1MF = roomVO.getFile1MF();
    if (file1MF != null){
      if (file1MF.getSize() > 0){
        file1 = Upload.saveFileSpring(file1MF, absPath);
        roomVO.setFile1(file1); // ���۵� ���ϸ� ����
      }
    }
      
    String file2 = "";
    MultipartFile file2MF = roomVO.getFile2MF();
    if (file2MF != null){
      if (file2MF.getSize() > 0){
        file2 = Upload.saveFileSpring(file2MF, absPath);
        roomVO.setFile2(file2); // ���۵� ���ϸ� ����
      }
    }
    
    String file3 = "";
    MultipartFile file3MF = roomVO.getFile3MF();
    if (file3MF != null){
      if (file3MF.getSize() > 0){
        file3 = Upload.saveFileSpring(file3MF, absPath);
        roomVO.setFile3(file3); // ���۵� ���ϸ� ����
      }
    }
    
    String file4 = "";
    MultipartFile file4MF = roomVO.getFile4MF();
    if (file4MF != null){
      if (file4MF.getSize() > 0){
        file4 = Upload.saveFileSpring(file4MF, absPath);
        roomVO.setFile4(file4); // ���۵� ���ϸ� ����
      }
    }
    
    String file5 = "";
    MultipartFile file5MF = roomVO.getFile5MF();
    if (file5MF != null){
      if (file5MF.getSize() > 0){
        file5 = Upload.saveFileSpring(file5MF, absPath);
        roomVO.setFile5(file5); // ���۵� ���ϸ� ����
      }
    }
    
    // --------------------------------------------------
    
    if (roomDAO.create(roomVO) == 1){ 
      msgs.add("���� ����߽��ϴ�.");
      links.add("<button type='button' onclick=\"location.href='./create.do'\">��� ���</button>");
    }else{
      msgs.add("�� ��Ͽ� �����߽��ϴ�.");
      msgs.add("�ٽ� �õ����ּ���.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽýõ�</button>");
    }
    
    links.add("<button type='button' onclick=\"location.href='./home.do'\">Ȩ������</button>");
    links.add("<button type='button' onclick=\"location.href='./list2.do?roomno="+roomVO.getRoomno()+"'\">���</button>");
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }
  
  //���
  @RequestMapping(value = "/room/list.do", method = RequestMethod.GET)
  public ModelAndView list(){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/room/list");
    mav.addObject("list", roomDAO.list());
    
    return mav;
  }
  
  //��ȸ
  @RequestMapping(value = "/room/read.do", method = RequestMethod.GET)
  public ModelAndView read(int roomno, int blogcategoryno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/room/read");
    mav.addObject("roomVO", roomDAO.read(roomno));
    
    RoomVO vo = roomDAO.read(roomno);
    mav.addObject("title", vo.getRoomno());

    return mav;
  }
  
  
}