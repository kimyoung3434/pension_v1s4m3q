package dev.mvc.room;
 
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository("dev.mvc.room.RoomDAO")
public class RoomDAO implements RoomMapperInter{
  @Autowired
  private SqlSession sqlSession; // MyBATIS 3 ¿¬°á °´Ã¼
  
  public RoomDAO(){
    System.out.println("--> RoomDAO created.");
  }
  
  public RoomMapperInter mapper(){
    RoomMapperInter mapper = sqlSession.getMapper(RoomMapperInter.class);    
    
    return mapper;
  }

  @Override
  public int create(RoomVO roomVO) {
    return mapper().create(roomVO);
  }

  @Override
  public ArrayList<RoomVO> list() {
    return mapper().list();
  }

  @Override
  public RoomVO read(int roomno) {
    return mapper().read(roomno);
  }

  @Override
  public int update(RoomVO roomVO) {
    return mapper().update(roomVO);

  }

  @Override
  public int delete(int roomno) {
    return mapper().delete(roomno);
  }
  
}