
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class StudentHelp extends JFrame {

    JPanel pane;
    JLabel logo,jlapplelogo, ichchha, tilak, tinfo, icinfo;

    public StudentHelp() {

        pane = new JPanel();
        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);
        Font ft = new Font("", Font.PLAIN, 15);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pane.add(jlapplelogo);
        jlapplelogo.setBounds(315, 15, 700, 124);

        tinfo = new JLabel("<html><table border='1'><tr><td style='padding-left:10px;padding-top:5px;padding-bottom:10px;'>  On this section, accountant performs the activities"
                + " related to students such as admitting a new student, payments of students, updating the students’ record.This section is handled by the accountant of the school.\n<br><br>"
                + "Once you click the item “<b>Student</b>” in the menu bar, three sub-items appear namely :<br><br>-  New<br>-  Edit<br>-  View\n<br><br><br>"
                + "<b>New :-  </b>  used to save the record such as name, address, level, contact-number etc. of the new student who is going "
                + "to be admitted in the school. You can enter the name either in uppercase letter or the lowercase letters. "
                + "You should always enter the date of birth of student in the format (<b>Year-Month-Day</b>). <b>Note!</b> You are only allowed "
                + "to enter digits on the space for phone number and contact number.\n"
                + "<br><br><b>Edit :-  </b>  used to update the records of the students if any of them changes. Firstly, you have to enter the student "
                + "id of the student whose records are going to update, and all the records of that student is displayed and "
                + "update can be done on any field of the student.\n"
                + "<br><br><b>View :-  </b>  used to display all the students of the school with their respective record fields. Also you can print the "
                + "hard copy of students record.</td></tr></table></html>");
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
       new StudentHelp();
  }

}
