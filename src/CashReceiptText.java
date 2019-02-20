///////////////////////Called for Printing Cash Receipt//////////////////////////////////////
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CashReceiptText extends JFrame implements ActionListener, KeyListener {

    JPanel pane = new JPanel();
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    JLabel logoimg, rcptno, date, accno, cashbar, duebalance, receivefrom, roll, name, amtinwords, oaof, grade, paidupto, sumofrs;
    JTextField txtrcptno, txtaccno, txtdate, txtrecvfrom, txtdue, txtamtinwords, txtroll, txtname, txtoaf, txtgrade, txtsumofrs, txtpaidupto;
    JButton submit;
    DBConnection1 db = new DBConnection1();
    PreparedStatement pstmt;
    ResultSet rs;
    Font ft = new Font("", Font.BOLD, 14);
     Font ft2 = new Font("", Font.BOLD, 20);
    Font ft1 = new Font("", Font.PLAIN, 15);

    public CashReceiptText(int student_id) {

        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);

        logoimg = new JLabel(new ImageIcon("images/applecash.png"));
        pane.add(logoimg);
        logoimg.setBounds(8, 0, 372, 78);

        cashbar = new JLabel(new ImageIcon("images/cashbar.png"));
        pane.add(cashbar);
        cashbar.setBounds(0, 83, 700, 33);

        rcptno = new JLabel("Receipt No : ");
        pane.add(rcptno);
        rcptno.setBounds(450, 5, 150, 30);
        rcptno.setFont(ft);

        date = new JLabel("Date   : ");
        pane.add(date);
        date.setBounds(450, 32, 80, 30);
        date.setFont(ft);

        txtdate = new JTextField("");
        pane.add(txtdate);
        txtdate.setBounds(510, 35, 170, 27);
        txtdate.setFont(ft1);
        txtdate.addKeyListener(this);

        receivefrom = new JLabel("Received From: ");
        pane.add(receivefrom);
        receivefrom.setBounds(15, 125, 150, 30);
        receivefrom.setFont(ft);

        txtrecvfrom = new JTextField("");
        pane.add(txtrecvfrom);
        txtrecvfrom.setBounds(135, 127, 130, 30);
        txtrecvfrom.setFont(ft1);
        txtrecvfrom.addKeyListener(this);
        txtrecvfrom.setEnabled(false);

        grade = new JLabel("Class : ");
        pane.add(grade);
        grade.setBounds(390, 125, 80, 30);
        grade.setFont(ft);

        txtgrade = new JTextField("");
        pane.add(txtgrade);
        txtgrade.setBounds(460, 127, 130, 30);
        txtgrade.setFont(ft1);
        grade.addKeyListener(this);
        txtgrade.setEnabled(false);

        name = new JLabel("Student Name : ");
        pane.add(name);
        name.setBounds(15, 170, 130, 30);
        name.setFont(ft);

        txtname = new JTextField("");
        pane.add(txtname);
        txtname.setBounds(135, 172, 230, 30);
        txtname.setFont(ft1);
        name.addKeyListener(this);
        txtname.setEnabled(false);

        roll = new JLabel("Roll  : ");
        pane.add(roll);
        roll.setBounds(390, 170, 70, 30);
        roll.setFont(ft);

        txtroll = new JTextField("");
        pane.add(txtroll);
        txtroll.setBounds(460, 172, 130, 30);
        txtroll.setFont(ft1);
        txtroll.addKeyListener(this);
        txtroll.setEnabled(false);

        sumofrs = new JLabel("A sum of Rs : ");
        pane.add(sumofrs);
        sumofrs.setBounds(15, 212, 150, 30);
        sumofrs.setFont(ft);

        txtsumofrs = new JTextField("");
        pane.add(txtsumofrs);
        txtsumofrs.setBounds(135, 214, 200, 30);
        txtsumofrs.setFont(ft1);
        txtsumofrs.addKeyListener(this);

        paidupto = new JLabel("Paid upto  : ");
        pane.add(paidupto);
        paidupto.setBounds(380, 212, 100, 30);
        paidupto.setFont(ft);

        txtpaidupto = new JTextField("");
        pane.add(txtpaidupto);
        txtpaidupto.setBounds(460, 214, 160, 30);
        txtpaidupto.setFont(ft1);
        txtpaidupto.addKeyListener(this);

        amtinwords = new JLabel("Amount in words: ");
        pane.add(amtinwords);
        amtinwords.setBounds(15, 258, 140, 30);
        amtinwords.setFont(ft);

        txtamtinwords = new JTextField();
        pane.add(txtamtinwords);
        txtamtinwords.setBounds(143, 260, 500, 30);
        txtamtinwords.setFont(ft1);
        txtamtinwords.addKeyListener(this);
        

        duebalance = new JLabel(" Balance Due : ");
        pane.add(duebalance);
        duebalance.setBounds(15, 304, 120, 30);
        duebalance.setFont(ft);

        txtdue = new JTextField("");
        pane.add(txtdue);
        txtdue.setBounds(135, 306, 500, 30);
        txtdue.setFont(ft1);
        txtdue.addKeyListener(this);

        submit = new JButton("Submit ",new ImageIcon("images/save.png"));
        pane.add(submit);
        submit.setFont(ft2);
        submit.setBounds(500, 352, 130, 40);
        submit.addActionListener(this);
        submit.addKeyListener(this);

        try {
            PreparedStatement pstmt = db.cn.prepareStatement("select fname,mname,lname,roll_no,guardian,class from record where student_id=?");
            pstmt.setInt(1, student_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                txtgrade.setText(rs.getString("class"));
                txtrecvfrom.setText(rs.getString("guardian"));
                txtroll.setText(rs.getString("roll_no"));
                txtname.setText(rs.getString("fname") + " " + rs.getString("mname") + " " + rs.getString("lname"));
            }

        } catch (SQLException exx) {
            exx.printStackTrace();
        }
        try {
            PreparedStatement pstmt = db.cn.prepareStatement("select paid_upto,paid_amt,balance_due,date_of_payment from studenttran where student_id=?");
            pstmt.setInt(1, student_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                txtpaidupto.setText(rs.getString("paid_upto"));
                  txtdue.setText(rs.getString("balance_due"));
                txtsumofrs.setText(rs.getString("paid_amt"));
                txtdate.setText(rs.getString("date_of_payment"));
              
            }

        } catch (SQLException exx) {
            exx.printStackTrace();
        }

        setSize(660, 450);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Cash Receipt Text");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new CashReceiptText(5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if (txtdate.getText().equals("") || txtsumofrs.getText().equals("") || txtamtinwords.getText().equals("") || txtpaidupto.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Incomplete Information !!", "Receipt Printing Failed", JOptionPane.ERROR_MESSAGE);

            } else {
                String[] values = {txtdate.getText(), txtrecvfrom.getText(), txtsumofrs.getText(), txtpaidupto.getText(), txtamtinwords.getText(), txtgrade.getText(), txtdue.getText(), txtname.getText(), txtroll.getText(),};
                new CashReceipt(values);
                this.dispose();
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
          if (e.getSource() == txtdue || e.getSource() == txtsumofrs || e.getSource() == txtdate ) {

            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_MINUS))) {
                getToolkit().beep();
                e.consume();

            }
        }
        if (e.getSource() == txtpaidupto|| e.getSource() == txtamtinwords) {
            char c = e.getKeyChar();
            if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtdate.getText().equals("") || txtsumofrs.getText().equals("") || txtamtinwords.getText().equals("") || txtpaidupto.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Incomplete Information !!", "Receipt Printing Failed", JOptionPane.ERROR_MESSAGE);

            } else {
                String[] values = {txtdate.getText(), txtrecvfrom.getText(), txtsumofrs.getText(), txtpaidupto.getText(), txtamtinwords.getText(), txtgrade.getText(), txtdue.getText(), txtname.getText(), txtroll.getText(),};
                new CashReceipt(values);
                this.dispose();
            }
        }
    }

    ///////////////////Auto Capitualization of the choosen fields//////////////////////////////////////
    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getSource() == txtdue) {
            String name = txtdue.getText();
            String f = name.substring(0, 1);
            String l = name.substring(1, name.length());

            String newname = f.toUpperCase() + l.toLowerCase();

            txtdue.setText(newname);
        }
        if (e.getSource() == txtamtinwords) {
            String name = txtamtinwords.getText();
            String f = name.substring(0, 1);
            String l = name.substring(1, name.length());
            String newname = f.toUpperCase() + l.toLowerCase();
            txtamtinwords.setText(newname);
        }
        if (e.getSource() == txtpaidupto) {
            String name = txtpaidupto.getText();
            String f = name.substring(0, 1);
            String l = name.substring(1, name.length());
            String newname = f.toUpperCase() + l.toLowerCase();
            txtpaidupto.setText(newname);
        }

    }
}
