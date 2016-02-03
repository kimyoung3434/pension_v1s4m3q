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
    
    
    if (roomDAO.create(roomVO) == 1){ 
      msgs.add("글을 등록했습니다.");
      links.add("<button type='button' onclick=\"location.href='./create.do'\">계속 등록</button>");
    }else{
      msgs.add("글 등록에 실패했습니다.");
      msgs.add("다시 시도해주세요.");
      links.add("<button type='button' onclick=\"history.back()\">다시시도</button>");
    }
    
    links.add("<button type='button' onclick=\"location.href='./home.do'\">홈페이지</button>");
    links.add("<button type='button' onclick=\"location.href='./list2.do?roomno="+roomVO.getRoomno()+"'\">목록</button>");
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }
  
}