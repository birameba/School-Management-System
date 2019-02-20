
import java.awt.*;
import javax.swing.*;

public class Software extends JFrame {

    JPanel pane;
    JLabel logo, ichchha, jlapplelogo, tilak, tinfo, icinfo;

    public Software() {

        pane = new JPanel();
        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);
        Font ft = new Font("", Font.PLAIN, 15);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pane.add(jlapplelogo);
        jlapplelogo.setBounds(315, 15, 700, 124);

        tinfo = new JLabel("<html><table border='1'><br><b><tr><td style='padding-left:10px;padding-top:5px;padding-bottom:10px;'>The Apple Academy - School Management System</b> is used to perform all the operations or the activities that are used to run the particular school using computer. All the operations within the particular school are listed below:\n<br>"
                + "\n <br>\t •	\t Admitting a new student\n<br>"
                + "\n \t•	Updating the student records\n<br> "
                + "\t•	Payments of students\n<br>"
                + "\t•	Employing a new teacher\n<br>"
                + "\t•	Teachers’ payment\n<br>"
                + "\t•	Updating the teacher records\n<br>"
                + "\t•	Entering or marks obtained by students\n<br>"
                + "\t•	Creating mark sheet of  students\n<br>"
                + "\t•	Creating students’ admit cards\n<br>"
                + "<br> This software is divided into three sections, namely :\n <br><br>"
                + "<b>1.	Administration Section\n<br></b>"
                + "		This section allows the authorized person as administrator (Generally School’s Principal) to view all the activities those were done, those are going on and those will be done by both the examination and account section.\n <br>"
                + "<b><br>2.	Account Section\n<br></b>"
                + "		This section is handled by the accountant of the school. On this section, accountant performs the activities related to students such as admitting a new student, payments of students, updating the students’ record and the activities related to teachers such as entering the record of new teacher, payment of teachers, updating the record of teachers. \n <br>"
                + "<b><br>3.	Examination Section\n<br></b>"
                + "		This section is handled by the staff who is authorized to perform all the operations related to examination such as marks entry of students, creating students’ mark sheets and admit cards.</td></tr></table></html>");
        pane.add(tinfo);
        tinfo.setBounds(50, -35, 1290, 900);
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
        new Software();
    }
}
