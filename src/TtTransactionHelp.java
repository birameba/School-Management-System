
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class TtTransactionHelp extends JFrame {

    JPanel pane;
    JLabel logo, ichchha, tilak, tinfo, icinfo,jlapplelogo,jlviews;

    public TtTransactionHelp() {

        pane = new JPanel();
        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);
        Font ft = new Font("", Font.PLAIN, 15);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pane.add(jlapplelogo);
        jlapplelogo.setBounds(315, 20, 700, 124);
        
    
        tinfo = new JLabel("<html><table border='1'><tr><td style='padding-left:10px;padding-top:5px;padding-bottom:10px;'> On this section,"
                + " accountant performs the transactions of the teachers"
                + " based on payment of monthly salaries, advanced payment etc. Also, transaction of total teachers"
                + " can be viewed.This section is handled by the accountant of the school.\n"
                + ""
                + "<br><br>Once you click the item <b>Transaction</b> in the menu bar, two sub-items appear as below : <br><br><b>Teacher:</b> used to perform all the transactions "
                + "based on teachers.<br><br><b>Student:</b> used to perform all the transactions "
                + "based on students.<br><br> Once you click the item <b>Teacher</b>, two sub-items appear namely:<br><br>- New<br> - View\n"
                
                + "<br><br><b>New :-  </b> used to make a transaction of the teacher based on the payment "
                + "of monthly salaries, advanced payment etc. Enter the id of the particular teacher and click the <b>submit</b> button"
                + ", then you get another form to enter the complete details of the transaction.\n"
                + " <br><br><b>View :-  </b> used to display the complete record of all the teachers transactions involved in the school."
                + " You can also view the records on the basis of months. This helps you to find the "
                + "transaction of particular teacher more quickly and efficiently.<br><br><b>Note:</b> You can make the payment of the respective teacher by clicking the button <b>Make Payment</b>. Similarly, <b>Delete</b> button is used to delete the complete record of the transactions of the respective teacher who is not currently associated to the school.\n"
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
//    public static void main(String[] args) {
//        new TtTransactionHelp();
//    }

  
}
