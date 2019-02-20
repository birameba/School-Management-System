///////////////////////Called from ChooseClassView for displaying marks of the corresponding student id///////////////////////////
import java.sql.*;
import javax.swing.*;

public class IdMarksDisplay {
  
    DBConnection1 db=new DBConnection1();
    PreparedStatement pstmt;
    ResultSet rs;
    String grade,c;
    int sid;
    public IdMarksDisplay(int student_id){
        sid=student_id;
          try {
                    pstmt = db.cn.prepareStatement("select class from record where student_id=?");
                    pstmt.setInt(1, sid);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                        c = rs.getString("class");
                    }
               
                } catch (Exception ex) {
                }
              if(c.equals("Seven")){
                  grade="seven";
              
              SixSevenDisplay n1=new SixSevenDisplay(grade,sid);
              
              }
               else if(c.equals("Six")){
                  grade="six";
              SixSevenDisplay n1=new SixSevenDisplay(grade,sid);
         
              }
                else if(c.equals("Five")){
                  grade="five";
              OneToFiveDisplay n5=new OneToFiveDisplay(grade,sid);
              }
                  else if(c.equals("Four")){
                  grade="four";
              OneToFiveDisplay n5=new OneToFiveDisplay(grade,sid);
              }
                    else if(c.equals("Three")){
                  grade="three";
              OneToFiveDisplay n5=new OneToFiveDisplay(grade,sid);
              }
                      else if(c.equals("Two")){
                  grade="two";
              OneToFiveDisplay n5=new OneToFiveDisplay(grade,sid);
              }
                        else if(c.equals("One")){
                  grade="one";
              OneToFiveDisplay n5=new OneToFiveDisplay(grade,sid);
              }
              else if(c.equals("Ten")){
                  grade="ten";
              NineTenDisplay n3=new NineTenDisplay(grade,sid);
              }
                else if(c.equals("Eight")){
                  grade="eight";
              EightDisplay n4=new EightDisplay(grade,sid);
              }
               else if(c.equals("Nine")){
                  grade="nine";
              NineTenDisplay n3=new NineTenDisplay(grade,sid);
              }
               else if(c.equals("Nursery")){
                  grade="nursery";
              NurseryDisplay n22=new NurseryDisplay(grade,sid);
              }
               else if(c.equals("Lkg")){
                  grade="lkg";
              LKGDisplay n23=new LKGDisplay(grade,sid);
              }
               else if(c.equals("Ukg")){
                  grade="ukg";
              UKGDisplay n24=new UKGDisplay(grade,sid);
              }
            }
    
      public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
//    new IdMarksDisplay(5);
      }
}
