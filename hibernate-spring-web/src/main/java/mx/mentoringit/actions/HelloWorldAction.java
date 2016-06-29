package mx.mentoringit.actions;
import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action{
   private String name;

   public String execute() throws Exception {
      return "success";
   }
   
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}