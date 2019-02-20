//////////////////////////Called from CashReceiptText///////////////////////////////////////////
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CashReceipt extends JFrame implements ActionListener {

    JPanel pane = new JPanel();
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    JLabel logoimg, rcptno, date, accno, jsign, cashbar, name, roll, receivefrom, amtinwords, oaof, grade, duebalance, paidupto, sumofrs;
    JButton btnprint;
    Font ft = new Font("", Font.BOLD, 13);
    Font ft1 = new Font("", Font.PLAIN, 15);

    public CashReceipt(String[] values) {

        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);

        logoimg = new JLabel(new ImageIcon("images/applecash.png"));
        pane.add(logoimg);
        logoimg.setBounds(8, 0, 372, 78);

        rcptno = new JLabel("Receipt No : ");
        pane.add(rcptno);
        rcptno.setBounds(450, 5, 150, 30);
        rcptno.setFont(ft);

        date = new JLabel("Date          :      " + values[0]);
        pane.add(date);
        date.setBounds(450, 32, 170, 30);
        date.setFont(ft);

        cashbar = new JLabel(new ImageIcon("images/cashbar.png"));
        pane.add(cashbar);
        cashbar.setBounds(0, 83, 700, 33);

        receivefrom = new JLabel("Received From   :      " + values[1]);
        pane.add(receivefrom);
        receivefrom.setBounds(15, 125, 700, 30);
        receivefrom.setFont(ft);

        grade = new JLabel("Class        :      " + values[5]);
        pane.add(grade);
        grade.setBounds(390, 125, 150, 30);
        grade.setFont(ft);

        name = new JLabel("Student Name     :      " + values[7]);
        pane.add(name);
        name.setBounds(15, 156, 350, 30);
        name.setFont(ft);

        roll = new JLabel("Roll. No.    :      " + values[8]);
        pane.add(roll);
        roll.setBounds(390, 156, 200, 30);
        roll.setFont(ft);

        sumofrs = new JLabel("A sum of Rs         :      " + values[2]);
        pane.add(sumofrs);
        sumofrs.setBounds(15, 185, 350, 30);
        sumofrs.setFont(ft);

        amtinwords = new JLabel("Amount in words :       " + values[4]);
        pane.add(amtinwords);
        amtinwords.setBounds(15, 219, 900, 30);
        amtinwords.setFont(ft);

        paidupto = new JLabel("Paid upto  :      " + values[3]);
        pane.add(paidupto);
        paidupto.setBounds(390, 185, 450, 30);
        paidupto.setFont(ft);

        duebalance = new JLabel("Balance Due        :     " + values[6]);
        pane.add(duebalance);
        duebalance.setBounds(15, 254, 900, 30);
        duebalance.setFont(ft);

        jsign = new JLabel("<html>............................ <br>    Accountant </html>");
        pane.add(jsign);
        jsign.setBounds(463, 276, 100, 30);
        jsign.setFont(ft);

        btnprint = new JButton("Print",new ImageIcon("images/print.png"));
        pane.add(btnprint);
        btnprint.setBounds(260, 280, 120, 35);
        btnprint.setFont(new Font("", Font.BOLD, 20));
        btnprint.setForeground(Color.BLACK);
        btnprint.setBackground(Color.WHITE);
        btnprint.addActionListener(this);

        setSize(650, 355);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Cash Receipt");

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == btnprint) {
//
//        }
    }
}
