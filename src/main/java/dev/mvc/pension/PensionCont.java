package dev.mvc.pension;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
 
@Controller
public class PensionCont {
  @Autowired
  @Qualifier("dev.mvc.pension.pensionDAO")
  private PensionDAO pensionDAO;
  
  public PensionCont(){
    System.out.println("--> PensionCont created.");
  }
}