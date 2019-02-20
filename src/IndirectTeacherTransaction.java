//////////////////////called from PresentDays////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class IndirectTeacherTransaction extends JDialog implements ActionListener, KeyListener {

    JLabel jlttran, jlapplelogo, jlid, jlfname, jlmname, jllname, jladvance, jlinfo, jldeduct, jlamtpaid, jlsalary, jldate, jlmonth;
    JTextField txtid, txtfname, txtmname, txtlname, txtsalary, txtdeduct, txtamtpaid, txtadvance, txtdate;
    JComboBox jcb;
    JButton jbsubmit;
    JCheckBox jpaid;
    JPanel pan = new JPanel();
    PreparedStatement pstmt;
    DBConnection1 dbc = new DBConnection1();
    ResultSet rs;
    int p,advance, sal, ded;

    public IndirectTeacherTransaction(int teacher_id, int present) {
        p = present;

        add(pan);
        pan.setLayout(null);
        pan.setBackground(Color.WHITE);
           Font ft2 = new Font("", Font.BOLD, 17);
        Font ft = new Font("", Font.BOLD, 15);
        Font ft1 = new Font("", Font.PLAIN, 15);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pan.add(jlapplelogo);
        jlapplelogo.setBounds(63, 5, 669, 140);

        jlttran = new JLabel(new ImageIcon("images/updateteachertransaction.png"));
        pan.add(jlttran);
        jlttran.setBounds(0, 148, 804, 33);

        jlid = new JLabel("Teacher ID");
        pan.add(jlid);
        jlid.setBounds(45, 201, 90, 25);
        jlid.setFont(ft);

        txtid = new JTextField();
        pan.add(txtid);
        txtid.setBounds(155, 201, 100, 30);
        txtid.setEnabled(false);
        txtid.setFont(ft1);

        jlfname = new JLabel("First Name");
        pan.add(jlfname);
        jlfname.setBounds(45, 253, 90, 25);
        jlfname.setFont(ft);

        txtfname = new JTextField();
        pan.add(txtfname);
        txtfname.setBounds(155, 253, 150, 30);
        txtfname.setFont(ft1);
        txtfname.setEnabled(false);

        jlmname = new JLabel("Middle Name");
        pan.add(jlmname);
        jlmname.setBounds(430, 253, 130, 25);
        jlmname.setFont(ft);

        txtmname = new JTextField();
        pan.add(txtmname);
        txtmname.setBounds(560, 253, 150, 30);
        txtmname.setFont(ft1);
        txtmname.setEnabled(false);

        jllname = new JLabel("Last Name");
        pan.add(jllname);
        jllname.setBounds(45, 301, 90, 25);
        jllname.setFont(ft);

        txtlname = new JTextField();
        pan.add(txtlname);
        txtlname.setBounds(155, 301, 150, 30);
        txtlname.setFont(ft1);
        txtlname.setEnabled(false);

        jlsalary = new JLabel("Salary");
        pan.add(jlsalary);
        jlsalary.setBounds(45, 349, 90, 25);
        jlsalary.setFont(ft);

        txtsalary = new JTextField();
        pan.add(txtsalary);
        txtsalary.setBounds(155, 349, 150, 30);
        txtsalary.setEnabled(false);
        txtsalary.setFont(ft1);
        txtsalary.addKeyListener(this);

        jldeduct = new JLabel("Deducted Amount:");
        pan.add(jldeduct);
        jldeduct.setBounds(415, 345, 400, 25);
        jldeduct.setFont(ft);

        txtdeduct = new JTextField("");
        pan.add(txtdeduct);
        txtdeduct.setBounds(585, 345, 120, 25);
        txtdeduct.setFont(ft);
        txtdeduct.setEnabled(false);

        jlamtpaid = new JLabel("Amount to be paid:");
        pan.add(jlamtpaid);
        jlamtpaid.setBounds(415, 387, 400, 25);
        jlamtpaid.setFont(ft);

        txtamtpaid = new JTextField("");
        pan.add(txtamtpaid);
        txtamtpaid.setBounds(585, 387, 120, 25);
        txtamtpaid.setFont(ft);
        txtamtpaid.setEnabled(false);

        jladvance = new JLabel("Advanced Payment:");
        pan.add(jladvance);
        jladvance.setBounds(415, 430, 220, 31);
        jladvance.setFont(ft);

        txtadvance = new JTextField();
        pan.add(txtadvance);
        txtadvance.setBounds(585, 430, 120, 30);
        txtadvance.setFont(ft1);
        txtadvance.addKeyListener(this);

        jlinfo = new JLabel("<html>You must enter advanced payment. Enter 0(zero) if no <br>advance payment is done.</html>");
        pan.add(jlinfo);
        jlinfo.setBounds(395, 467, 420, 45);
        jlinfo.setFont(ft1);
        jlinfo.setForeground(Color.BLUE);

        jlmonth = new JLabel("Month");
        pan.add(jlmonth);
        jlmonth.setBounds(45, 403, 90, 25);
        jlmonth.setFont(ft);

        jcb = new JComboBox();
        pan.add(jcb);
        jcb.setBounds(140, 403, 120, 25);
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

        jldate = new JLabel("Date_of_Payment");
        pan.add(jldate);
        jldate.setBounds(45, 455, 200, 25);
        jldate.setFont(ft);

        txtdate = new JTextField();
        pan.add(txtdate);
        txtdate.setBounds(200, 455, 150, 30);
        txtdate.setFont(ft1);
        txtdate.addKeyListener(this);

        jpaid = new JCheckBox("Paid");
        pan.add(jpaid);
        jpaid.setBounds(100, 520, 70, 30);
        jpaid.setFont(ft);
        jpaid.addKeyListener(this);

      
        try {
            pstmt = dbc.cn.prepareStatement("SELECT * FROM teachertran where teacher_id=?");
            pstmt.setInt(1, teacher_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                txtid.setText(rs.getString("teacher_id"));
                txtfname.setText(rs.getString("fname"));
                txtmname.setText(rs.getString("mname"));
                txtlname.setText(rs.getString("lname"));
                txtsalary.setText(rs.getString("salary"));
                txtdate.setText(rs.getString("Date_of_payment"));
                jcb.setSelectedItem(new String(rs.getString("month")));
                jpaid.setSelected(rs.getBoolean("paid"));
                txtadvance.setText(rs.getString("advanced_amount"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       

        jbsubmit = new JButton("Submit");
        pan.add(jbsubmit);
        jbsubmit.setFont(ft2);
        jbsubmit.setBackground(Color.BLUE);
        jbsubmit.setForeground(Color.WHITE);
        jbsubmit.setBounds(520, 540, 130, 38);
        jbsubmit.addActionListener(this);
        jbsubmit.addKeyListener(this);
        
        advance=Integer.parseInt(txtadvance.getText());
          sal = (((Integer.parseInt(txtsalary.getText()) / 30) * p)-advance);
        ded = ((Integer.parseInt(txtsalary.getText())) - sal);

             txtamtpaid.setText(String.valueOf(sal));
             txtdeduct.setText(String.valueOf(ded));

        addKeyListener(this);
        setSize(800, 650);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Teacher Transaction");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
//         new IndirectTeacherTransaction(19,20);
    }

    /////////////////////////////////Updating the teachertransaction table/////////////////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbsubmit) {
            if (txtsalary.getText().equals("") || txtdate.getText().equals("") || jladvance.getText().equals("") || jpaid.isSelected() == false || jcb.getSelectedItem() == "") {
                JOptionPane.showMessageDialog(null, "Incomplete Information !!", "Updating Error", JOptionPane.ERROR_MESSAGE);
            } else {

                try {
                    pstmt = dbc.cn.prepareStatement("update teachertran set fname=?,mname=?,lname=?,month=?,paid=?,salary=?,deducted_amount=?,paid_amount=?,advanced_amount=?,Date_of_payment=? where teacher_id=?");
                    pstmt.setString(1, txtfname.getText());
                    pstmt.setString(2, txtmname.getText());
                    pstmt.setString(3, txtlname.getText());
                    pstmt.setString(4, jcb.getSelectedItem().toString());
                    pstmt.setString(6, txtsalary.getText());
                    pstmt.setString(7, txtdeduct.getText());
                    pstmt.setString(8, txtamtpaid.getText());
                    pstmt.setString(9, txtadvance.getText());
                    pstmt.setString(10, txtdate.getText());
                    pstmt.setInt(11, Integer.parseInt(txtid.getText()));
                    String status;
                    if (jpaid.isSelected()) {
                        status = "Paid";
                    } else {
                        status = "Not Paid";
                    }
                    pstmt.setString(5, status);

                    int result = pstmt.executeUpdate();
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
    public void keyTyped(KeyEvent e) {
         if(e.getSource()==txtdate){
             char c = e.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_MINUS)  )) {
            getToolkit().beep();
            e.consume();
        }
        }
       else if (e.getSource() == txtsalary || e.getSource()==txtadvance ) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtsalary.getText().equals("") || txtdate.getText().equals("") || jladvance.getText().equals("") || jpaid.isSelected() == false || jcb.getSelectedItem() == "") {
                JOptionPane.showMessageDialog(null, "Incomplete Information !!", "Updating Error", JOptionPane.ERROR_MESSAGE);
            } else {

                try {
                    pstmt = dbc.cn.prepareStatement("update teachertran set fname=?,mname=?,lname=?,month=?,paid=?,salary=?,deducted_amount=?,paid_amount=?,advanced_amount=?,Date_of_payment=? where teacher_id=?");
                    pstmt.setString(1, txtfname.getText());
                    pstmt.setString(2, txtmname.getText());
                    pstmt.setString(3, txtlname.getText());
                    pstmt.setString(4, jcb.getSelectedItem().toString());
                    pstmt.setString(6, txtsalary.getText());
                    pstmt.setString(7, txtdeduct.getText());
                    pstmt.setString(8, txtamtpaid.getText());
                    pstmt.setString(9, txtadvance.getText());
                    pstmt.setString(10, txtdate.getText());
                    pstmt.setInt(11, Integer.parseInt(txtid.getText()));
                     String status;
                    if (jpaid.isSelected()) {
                        status = "Paid";
                    } else {
                        status = "Not Paid";
                    }
                    pstmt.setString(5, status);

                    int result = pstmt.executeUpdate();
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
            }
             else if (txtdate.getText().length() > 9) {
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);
                txtdate.setText(txtdate.getText().substring(0, 10));
            }
        }
    }
}
