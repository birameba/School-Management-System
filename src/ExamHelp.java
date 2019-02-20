
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class ExamHelp extends JFrame {

    JPanel pane;
    JLabel logo, ichchha,jlapplelogo, tilak, tinfo, icinfo;

    public ExamHelp() {

        pane = new JPanel();
        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);
        Font ft = new Font("", Font.PLAIN, 15);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pane.add(jlapplelogo);
        jlapplelogo.setBounds(315, 15, 700, 124);

        tinfo = new JLabel("<html><table border='1'><tr><td style='padding-left:10px;padding-top:5px;padding-bottom:10px;'>On this section, you can perform the activities related to exam such as printing admit card of students, entry of marks obtained by students in their exams, and printing the mark sheet of students.This section is handled by the examination operator.\n"
                + "<br><br>Once you click the item “<b>Examination</b>” in the menu bar, four sub-items appear namely : <br><br>- Admit Card<br> -Marks Entry<br> -View and <br>-Mark Sheet\n"
                + "<br><br><b>Admit Card :-  </b>used to print the admit card of each student. Once you click the sub-item “<b>Admit Card</b>”, you are asked to enter the student id of the respective student. Also, choose the examination terminal and finally click the <b>submit</b> button.\n"
                + " <br><br><b>Marks Entry :-  </b>used to enter the marks obtained by each student. Once you click the sub-item “<b>Marks Entry</b>”, you are asked to select the grade of the respective student. Once you click the <b>submit</b> button, you get the form where you can enter the marks of different subjects obtained by that student. You can also reset the marks by clicking <b>reset</b> button present at the bottom of the form.<b>reset</b> button clears the previously entered marks of the student and allows you to enter the new marks of the same student.\n"
                + " <br><br><b>View :-  </b>used to display marks of all of the students.\n"
                + "<br><br><b>Mark Sheet :-  </b>used to print the mark sheet (report card) of the students. Once you click the sub-item “<b>Mark Sheet</b>”,you get the form where you have to enter the student id, select the examination terminal,enter total attendance (total present days) and the date of issue of mark sheet. Finally, click the <b>submit</b> button. Then, you get the mark sheet of the respective student.<br><b>Note!</b> You can also print the mark-sheet of the student by clicking the <b>print</> button present there.\n"
                + "\n"
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
       new ExamHelp();
  }

}
