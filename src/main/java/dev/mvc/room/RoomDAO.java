package dev.mvc.room;
 
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
  
}