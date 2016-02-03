package dev.mvc.pension;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class PensionDAO implements PensionMapperInter{
  @Autowired
  private SqlSession sqlSession; // MyBATIS 3 ¿¬°á °´Ã¼
  
  public PensionDAO(){
    System.out.println("--> PensionDAO created.");
  }
  
  public PensionMapperInter mapper(){
    PensionMapperInter mapper = sqlSession.getMapper(PensionMapperInter.class);    
    
    return mapper;
  }
  
}