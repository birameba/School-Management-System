//////////////////////////////Called from AskIdTeacherTransaction/////////////////////////////

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class AskIdTeacherTransaction extends JDialog implements ActionListener, KeyListener {

    JLabel jlttran, jlapplelogo, jlid, jlfname, jlinfo, jlamtpaid, jldeduct, jladvance, jlmname, jllname, jlsalary, jldate, jlmonth;
    JTextField txtid, txtfname, txtmname, txtdeduct, txtadvance, txtlname, txtamtpaid, txtsalary, txtdate;
    JComboBox jcb;
    JButton jbsubmit;
    JCheckBox jpaid;
    JPanel pan = new JPanel();
    PreparedStatement pstmt;
    DBConnection1 dbc = new DBConnection1();
    int result, sal, ded;

    public AskIdTeacherTransaction(int teacher_id, int present) {
        add(pan);
        pan.setLayout(null);
        pan.setBackground(Color.WHITE);
        Font ft = new Font("", Font.BOLD, 16);
        Font ft2 = new Font("", Font.BOLD, 22);
        Font ft1 = new Font("", Font.PLAIN, 15);

        int p = present;

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pan.add(jlapplelogo);
        jlapplelogo.setBounds(160, 5, 669, 140);

        jlttran = new JLabel(new ImageIcon("images/newteachertransaction.png"));
        pan.add(jlttran);
        jlttran.setBounds(0, 148, 990, 33);

        jlid = new JLabel("Teacher ID");
        pan.add(jlid);
        jlid.setBounds(45, 201, 90, 25);
        jlid.setFont(ft);

        txtid = new JTextField();
        pan.add(txtid);
        txtid.setBounds(155, 201, 150, 30);
        txtid.setEnabled(false);
        txtid.setFont(ft1);
        
        jldate = new JLabel("Date of Payment");
        pan.add(jldate);
        jldate.setBounds(345, 201, 200, 32);
        jldate.setFont(ft);

        txtdate = new JTextField();
        pan.add(txtdate);
        txtdate.setBounds(480, 201, 150, 30);
        txtdate.setFont(ft1);
        txtdate.addKeyListener(this);


        jlfname = new JLabel("First Name");
        pan.add(jlfname);
        jlfname.setBounds(45, 253, 90, 25);
        jlfname.setFont(ft);

        txtfname = new JTextField();
        pan.add(txtfname);
        txtfname.setBounds(155, 253, 150, 30);
        txtfname.setEnabled(false);
        txtfname.setFont(ft1);

        jlmname = new JLabel("Middle Name");
        pan.add(jlmname);
        jlmname.setBounds(345, 253, 130, 25);
        jlmname.setFont(ft);

        txtmname = new JTextField();
        pan.add(txtmname);
        txtmname.setBounds(480, 253, 150, 30);
        txtmname.setEnabled(false);
        txtmname.setFont(ft1);

        jllname = new JLabel("Last Name");
        pan.add(jllname);
        jllname.setBounds(660, 253, 90, 25);
        jllname.setFont(ft);

        txtlname = new JTextField();
        pan.add(txtlname);
        txtlname.setBounds(770, 253, 150, 30);
        txtlname.setEnabled(false);
        txtlname.setFont(ft1);

        jlsalary = new JLabel("Salary");
        pan.add(jlsalary);
        jlsalary.setBounds(45, 305, 90, 25);
        jlsalary.setFont(ft);

        txtsalary = new JTextField();
        pan.add(txtsalary);
        txtsalary.setBounds(155, 305, 150, 30);
        txtsalary.setFont(ft1);
        txtsalary.addKeyListener(this);
        txtsalary.setEnabled(false);
        
         jlmonth = new JLabel("Month");
        pan.add(jlmonth);
        jlmonth.setBounds(345, 305, 90, 25);
        jlmonth.setFont(ft);

        jcb = new JComboBox();
        pan.add(jcb);
        jcb.setBounds(480, 305, 150, 33);
        jcb.addItem("");
        jcb.addItem("Baisakh");
        jcb.addItem("Jestha");
        jcb.addItem("Ashad");
        jcb.addItem("Shrawan");
        jcb.addItem("Bhadra");
        jcb.addItem("Ashwin");
        jcb.addItem("Kartik");
        jcb.addItem("Mangsir");
        jcb.addItem("Poush");
        jcb.addItem("Margh");
        jcb.addItem("Falgun");
        jcb.addItem("Chaitra");
        jcb.addKeyListener(this);
        jcb.setFont(ft1);


        jldeduct = new JLabel("Deducted Amt");
        pan.add(jldeduct);
        jldeduct.setBounds(45, 357, 250, 25);
        jldeduct.setFont(ft);

        txtdeduct = new JTextField();
        pan.add(txtdeduct);
        txtdeduct.setBounds(155, 357, 150, 30);
        txtdeduct.setFont(ft1);

        jlamtpaid = new JLabel("Amount to be paid");
        pan.add(jlamtpaid);
        jlamtpaid.setBounds(345, 357, 300, 25);
        jlamtpaid.setFont(ft);

        txtamtpaid = new JTextField();
        pan.add(txtamtpaid);
        txtamtpaid.setBounds(490, 357, 140, 30);
        txtamtpaid.setFont(ft1);

        jladvance = new JLabel("Advanced Payment");
        pan.add(jladvance);
        jladvance.setBounds(45, 409, 220, 31);
        jladvance.setFont(ft);

        txtadvance = new JTextField();
        pan.add(txtadvance);
        txtadvance.setBounds(200, 409, 110, 30);
        txtadvance.setFont(ft1);
        txtadvance.addKeyListener(this);
        
        jpaid = new JCheckBox("Paid");
        pan.add(jpaid);
        jpaid.setBounds(350, 409, 70, 30);
        jpaid.setFont(ft);
        jpaid.addKeyListener(this);

        jlinfo = new JLabel("<html>NOTE!!You must enter advanced payment. Enter 0(zero) if no <br>advance payment is done.</html>");
        pan.add(jlinfo);
        jlinfo.setBounds(485, 409, 420, 45);
        jlinfo.setFont(ft1);
        jlinfo.setForeground(Color.RED);

      
        jbsubmit = new JButton("Submit",new ImageIcon("images/save.png"));
        pan.add(jbsubmit);
        jbsubmit.setFont(ft2);
        jbsubmit.setBackground(Color.BLUE);
        jbsubmit.setForeground(Color.WHITE);
        jbsubmit.setBounds(400, 485, 140, 42);
        jbsubmit.addActionListener(this);
        jbsubmit.addKeyListener(this);

        try {
            pstmt = dbc.cn.prepareStatement("select teacher_id,fname,mname,lname,salary from teacher where teacher_id=?");
            pstmt.setInt(1, teacher_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                txtid.setText(rs.getString("teacher_id"));
                txtfname.setText(rs.getString("fname"));
                txtmname.setText(rs.getString("mname"));
                txtlname.setText(rs.getString("lname"));
                txtsalary.setText(rs.getString("salary"));
            }
        } catch (SQLException exx) {
            exx.printStackTrace();
        }
        sal = ((Integer.parseInt(txtsalary.getText()) / 30) * p);
        txtamtpaid.setText(String.valueOf(sal));

        ded = ((Integer.parseInt(txtsalary.getText())) - sal);
        txtdeduct.setText(String.valueOf(ded));

        setSize(990, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Teacher Transaction");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
//        new AskIdTeacherTransaction(19, 10);
    }

    ////////////////////////////////inserting data into the teacher transaction/////////////////////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbsubmit) {
            if (txtsalary.getText().equals("") || txtdate.getText().equals("") || jladvance.getText().equals("") || jpaid.isSelected() == false || jcb.getSelectedItem().toString() == null) {
                JOptionPane.showMessageDialog(null, "Incomplete Information !!", "Saving Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    pstmt = dbc.cn.prepareStatement("insert into teachertran (teacher_id,fname,mname,lname,month,salary,paid_amount,deducted_amount,advanced_amount,Date_of_payment,paid) values(?,?,?,?,?,?,?,?,?,?,?)");
                     pstmt.setInt(1, Integer.parseInt(txtid.getText()));
                    pstmt.setString(2, txtfname.getText());
                    pstmt.setString(3, txtmname.getText());
                    pstmt.setString(4, txtlname.getText());
                    pstmt.setString(5, jcb.getSelectedItem().toString());
                    pstmt.setString(6, txtsalary.getText());
                    pstmt.setString(7, txtamtpaid.getText());
                    pstmt.setString(8, txtdeduct.getText());
                    pstmt.setString(9, txtadvance.getText());
                    pstmt.setString(10, txtdate.getText());
                    String status;
                    if (jpaid.isSelected()) {
                        status = "Paid";
                    } else {
                        status = "Not Paid";
                    }
                    pstmt.setString(11, status);
                    result = pstmt.executeUpdate();
                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Payment Successful !!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Payment Not Successful !!");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                this.dispose();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == txtdate) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_MINUS))) {
                getToolkit().beep();
                e.consume();
            }
        } else if (e.getSource() == txtsalary || e.getSource() == txtadvance) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_COMMA))) {
                getToolkit().beep();
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtsalary.getText().equals("") || txtdate.getText().equals("") || jladvance.getText().equals("") || jpaid.isSelected() == false || jcb.getSelectedItem() == "") {
                JOptionPane.showMessageDialog(null, "Incomplete Information !!", "Saving Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    pstmt = dbc.cn.prepareStatement("insert into teachertran (fname,mname,lname,month,salary,paid_amount,deducted_amount,advanced_amount,Date_of_payment,paid) values(?,?,?,?,?,?,?,?,?,?)");
                    pstmt.setString(1, txtfname.getText());
                    pstmt.setString(2, txtmname.getText());
                    pstmt.setString(3, txtlname.getText());
                    pstmt.setString(4, jcb.getSelectedItem().toString());
                    pstmt.setString(5, txtsalary.getText());
                    pstmt.setString(6, txtamtpaid.getText());
                    pstmt.setString(7, txtdeduct.getText());
                    pstmt.setString(8, txtadvance.getText());
                    pstmt.setString(9, txtdate.getText());
                    String status;
                    if (jpaid.isSelected()) {
                        status = "Paid";
                    } else {
                        status = "Not Paid";
                    }
                    pstmt.setString(10, status);
                    result = pstmt.executeUpdate();
                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Payment Successful !!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Payment Not Successful !!");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                //catch(ClassNotFoundException exx){}

                this.dispose();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == txtadvance) {
            if (txtadvance.getText().length() > 5) {
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);
                txtadvance.setText(txtadvance.getText().substring(0, 6));
            } else if (txtdate.getText().length() > 9) {
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);
                txtdate.setText(txtdate.getText().substring(0, 10));
            }
        }
    }
}
