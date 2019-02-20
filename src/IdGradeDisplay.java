///////////////////////Called from ChooseClassView for displaying grade of the corresponding student id///////////////////////////
import java.sql.*;
import javax.swing.*;

public class IdGradeDisplay {
  
    DBConnection1 db=new DBConnection1();
    PreparedStatement pstmt;
    ResultSet rs;
    String grade,c;
    int sid;
    public IdGradeDisplay(int student_id){
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
              ViewGrade7 n1=new ViewGrade7(grade,sid);
              }
               else if(c.equals("Six")){
                  grade="six";
              ViewGrade6 n16=new ViewGrade6(grade,sid);
              }
                else if(c.equals("Five")){
                  grade="five";
              ViewGrade15 n5=new ViewGrade15(grade,sid);
              }
                  else if(c.equals("Four")){
                  grade="four";
              ViewGrade15 n5=new ViewGrade15(grade,sid);
              }
                    else if(c.equals("Three")){
                  grade="three";
              ViewGrade15 n5=new ViewGrade15(grade,sid);
              }
                      else if(c.equals("Two")){
                  grade="two";
              ViewGrade15 n5=new ViewGrade15(grade,sid);
              }
                        else if(c.equals("One")){
                  grade="one";
                 
              ViewGrade15 n5=new ViewGrade15(grade,sid);
              
              }
              else if(c.equals("Ten")){
                  grade="ten";
              ViewGrade n3=new ViewGrade(grade,sid);
              }
                else if(c.equals("Eight")){
                  grade="eight";
              ViewGrade8 n4=new ViewGrade8(grade,sid);
              }
               else if(c.equals("Nine")){
                  grade="nine";
              ViewGrade n3=new ViewGrade(grade,sid);
              }
               else if(c.equals("Nursery")){
                  grade="nine";
              ViewGradeNursery n19=new ViewGradeNursery(grade,sid);
              }
               else if(c.equals("Ukg")){
                  grade="nine";
              ViewGradeUKG n18=new ViewGradeUKG(grade,sid);
              }
               else if(c.equals("Lkg")){
                  grade="nine";
              ViewGradeLKG n17=new ViewGradeLKG(grade,sid);
              }
            }
    
      public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
    //new IdGradeDisplay(25);
      }
}
