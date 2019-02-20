
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class StTransactionHelp extends JFrame {

    JPanel pane;
    JLabel logo, ichchha, tilak, tinfo,jlapplelogo ,icinfo;

    public StTransactionHelp() {

         pane = new JPanel();
        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);
        Font ft = new Font("", Font.PLAIN, 15);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pane.add(jlapplelogo);
        jlapplelogo.setBounds(315, 15, 700, 124);

        tinfo = new JLabel("<html><table border='1'><tr><td style='padding-left:10px;padding-top:5px;padding-bottom:10px;'> On this section, accountant performs the transaction related to students such as making a new transaction based on admission fee, monthly fee, laboratory fee etc. Also, transaction of total students can be viewed.This section is handled by the accountant of the school.\n"
                + "<br><br>Once you click the item <b>Transaction</b> button in the menu bar, two sub-items appear namely :<br><br>-  Student<br> - Teacher<br><br><b>Student :-  </b>used to perform all the transactions related to the student.<br><br><b>Teacher :-  </b>used to perform all the transactions related to the student. <br><br>Once you click the item <b>Student</b>, two sub-items appear namely :<br>- New<br> - View\n"
                + "<br><br><b>New :-  </b> used to make a new transaction of the student based on admission fee, monthly fee, laboratory fee etc. Enter the id of the particular student and click the <b>submit</b> button, then you get another form to enter the complete details of the transaction.\n"
                + " <br><br><b>View :-  </b> used to display the complete record of all the students transactions involved in the school. You can also view the student transaction on the basis of student id, first name, last name, class and roll number. This helps you to find the transaction of particular student more quickly and efficiently.<br><br><b>Note:</b> You can make the payment of the respective student by clicking the button <b>Make Payment</b>. Similarly, <b>Delete</b> button is used to delete the complete record of transactions of the respective student who is not currently associated to the school.\n"
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
//    public static void main(String[] args) {
//        new StTransactionHelp();
//    }
 
}
