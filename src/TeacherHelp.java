
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class TeacherHelp extends JFrame {

    JPanel pane;
    JLabel logo, ichchha,jlapplelogo, tilak, tinfo, icinfo;

    public TeacherHelp() {

        pane = new JPanel();
        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);
        Font ft = new Font("", Font.PLAIN, 15);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pane.add(jlapplelogo);
        jlapplelogo.setBounds(315, 15, 700, 124);

        tinfo = new JLabel("<html><table border='1'><tr><td style='padding-left:10px;padding-top:5px;padding-bottom:10px;'> On this section, accountant performs the activities related to teachers such as admitting a new teacher, payments of teachers, updating the teachers’ record and made available the list of the teachers of school.This section is handled by the account section of the school.\n"
                + "<br><br>Once you click the menu “<b>Teacher</b>” in the menu bar, three sub-items appear namely :<br><br>-  New <br>-  Edit<br> -  View\n"
                + "<br><br> <b>New :-  </b>used to save the record such as name, address, qualification, level he/she teaches, job type (part time or full time), salary, contact-number etc. of the new teacher who is going to be admitted in the school. You can enter the name either in uppercase letter or the lowercase letters.<b>Note!</b> You are allowed to enter only digits on the space for phone number and salary. You cannot leave any record space blank for teacher. Once you enter all the data records in the form, then click the button <b>save record</b> to save the record. Once you make entry of the teacher, then you can have his/her teacher id by viewing the teachers list.\n"
                + "<br><br><b>Edit :-   </b>used to update the records of the teachers in case of the changes required. Enter the id of the teacher whose records need to be updated and then you get another form where you can edit the required records of the respective teacher."
                + "<br><br><b>View :-   </b>used to display all the teachers of the school with their respective record fields. You can view the student records on the basis of teacher id, first name, last name, gender, level, subject and type. This helps you to find the record of particular teacher more quickly and efficiently. You can also edit information of the teacher by clicking the button “<b>Edit</b>” displayed on this page.<br><br> <b>Delete :-  </b> used to delete the record of the teacher who is not currently associated to the school. Click the required record of teacher in the table and click the <b>Delete</b> button.\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "</td></tr></table></html>");
        pane.add(tinfo);
        tinfo.setBounds(40, -35, 1290, 900);
        tinfo.setForeground(Color.black);
        tinfo.setFont(ft);

        setTitle("Apple Academy - School Management System");
        setVisible(true);
        setSize(1500, 1500);
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    
    public static void main(String[] args) {
       new TeacherHelp();
  }


}
