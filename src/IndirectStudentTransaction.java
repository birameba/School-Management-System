////////////////////////Called from the ViewStudentTransaction for the selected row of the student////////////////////////////

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class IndirectStudentTransaction extends JFrame implements ActionListener, KeyListener {

    JLabel jlapplelogo, jlstt, jlstid, jlfname, jlmname, jllname, jlclass, jldue, jlroll, jlpaid, jladmission, jlmonthly, jlpaidupto, jlcomputer, jlextra, jldate;
    JTextField txtsearch, txtstid, txtfname, txtmname, txtlname, txtclass, txtdue, txtroll, txtadmission, txtmonthly, txtpaid, txtpaidupto, txtcomputer, txtextra, txtdate;
    ;
    JButton btnsubmit;
    JCheckBox cbadmission, cblabsts, cbexsts;
    JPanel pan = new JPanel();
    PreparedStatement pstmt;
    int rss;
    DBConnection1 dbc = new DBConnection1();

    public IndirectStudentTransaction(int student_id) {

        add(pan);
        pan.setLayout(null);
        pan.setBackground(Color.WHITE);
        Font ft2 = new Font("", Font.BOLD, 18);
        Font ft = new Font("", Font.BOLD, 15);
        Font ft1 = new Font("", Font.PLAIN, 15);
        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pan.add(jlapplelogo);
        jlapplelogo.setBounds(165, 5, 669, 140);

        jlstt = new JLabel(new ImageIcon("images/updatestudenttransaction.png"));
        pan.add(jlstt);
        jlstt.setBounds(0, 148, 1000, 33);

        jlstid = new JLabel("Student ID");
        pan.add(jlstid);
        jlstid.setBounds(40, 220, 80, 25);
        jlstid.setFont(ft);

        txtstid = new JTextField();
        pan.add(txtstid);
        txtstid.setBounds(150, 220, 130, 30);
        txtstid.setEnabled(false);
        txtstid.addKeyListener(this);
        txtstid.setFont(ft1);

        jlfname = new JLabel("First Name");
        pan.add(jlfname);
        jlfname.setBounds(40, 268, 80, 25);
        jlfname.setFont(ft);

        txtfname = new JTextField();
        pan.add(txtfname);
        txtfname.setBounds(150, 268, 130, 30);
        txtfname.setEnabled(false);
        txtfname.setFont(ft1);

        jlmname = new JLabel("Middle Name");
        pan.add(jlmname);
        jlmname.setBounds(345, 268, 130, 25);
        jlmname.setFont(ft);

        txtmname = new JTextField();
        pan.add(txtmname);
        txtmname.setBounds(460, 268, 130, 30);
        txtmname.setEnabled(false);
        txtmname.setFont(ft1);

        jllname = new JLabel("Last Name");
        pan.add(jllname);
        jllname.setBounds(640, 268, 120, 25);
        jllname.setFont(ft);

        txtlname = new JTextField();
        pan.add(txtlname);
        txtlname.setBounds(735, 268, 130, 30);
        txtlname.setEnabled(false);
        txtlname.setFont(ft1);

        jlclass = new JLabel("Class");
        pan.add(jlclass);
        jlclass.setBounds(40, 318, 80, 25);
        jlclass.setFont(ft);

        txtclass = new JTextField();
        pan.add(txtclass);
        txtclass.setBounds(150, 318, 130, 30);
        txtclass.setFont(ft1);
        txtclass.addKeyListener(this);
        txtclass.setEnabled(false);

        jlroll = new JLabel("Roll No.");
        pan.add(jlroll);
        jlroll.setBounds(345, 318, 80, 25);
        jlroll.setFont(ft);

        txtroll = new JTextField();
        pan.add(txtroll);
        txtroll.setBounds(460, 318, 130, 30);
        txtroll.setFont(ft1);
        txtroll.addKeyListener(this);
        txtroll.setEnabled(false);

        jladmission = new JLabel("Admission Fee");
        pan.add(jladmission);
        jladmission.setBounds(40, 363, 190, 25);
        jladmission.setFont(ft);

        txtadmission = new JTextField();
        pan.add(txtadmission);
        txtadmission.setBounds(150, 363, 130, 30);
        txtadmission.setFont(ft1);
        txtadmission.addKeyListener(this);

        cbadmission = new JCheckBox("Admitted");
        pan.add(cbadmission);
        cbadmission.setBounds(340, 363, 120, 25);
        cbadmission.setFont(ft);
        cbadmission.addKeyListener(this);

        jlmonthly = new JLabel("Monthly Fee");
        pan.add(jlmonthly);
        jlmonthly.setBounds(40, 410, 120, 25);
        jlmonthly.setFont(ft);

        txtmonthly = new JTextField();
        pan.add(txtmonthly);
        txtmonthly.setBounds(150, 410, 130, 30);
        txtmonthly.setFont(ft1);
        txtmonthly.addKeyListener(this);

        jlpaid = new JLabel("Paid Amount");
        pan.add(jlpaid);
        jlpaid.setBounds(340, 410, 130, 25);
        jlpaid.setFont(ft);

        txtpaid = new JTextField();
        pan.add(txtpaid);
        txtpaid.setBounds(460, 410, 130, 30);
        txtpaid.setFont(ft1);
        txtpaid.addKeyListener(this);

        jlpaidupto = new JLabel("Paid Upto");
        pan.add(jlpaidupto);
        jlpaidupto.setBounds(650, 410, 120, 25);
        jlpaidupto.setFont(ft);

        txtpaidupto = new JTextField();
        pan.add(txtpaidupto);
        txtpaidupto.setBounds(745, 410, 150, 30);
        txtpaidupto.setFont(ft1);
        txtpaidupto.addKeyListener(this);

        jlcomputer = new JLabel("Comp Lab Fee");
        pan.add(jlcomputer);
        jlcomputer.setBounds(40, 463, 160, 25);
        jlcomputer.setFont(ft);

        txtcomputer = new JTextField();
        pan.add(txtcomputer);
        txtcomputer.setBounds(150, 463, 130, 30);
        txtcomputer.setFont(ft1);
        txtcomputer.addKeyListener(this);

        cblabsts = new JCheckBox("Lab Paid");
        pan.add(cblabsts);
        cblabsts.setBounds(335, 463, 120, 25);
        cblabsts.setFont(ft);
        cblabsts.addKeyListener(this);

        jldue = new JLabel("Balance Due ");
        pan.add(jldue);
        jldue.setBounds(650, 463, 110, 25);
        jldue.setFont(ft);

        txtdue = new JTextField();
        pan.add(txtdue);
        txtdue.setBounds(745, 463, 150, 30);
        txtdue.setFont(ft1);
        txtdue.addKeyListener(this);

        jlextra = new JLabel("Extra");
        pan.add(jlextra);
        jlextra.setBounds(40, 519, 70, 25);
        jlextra.setFont(ft);

        txtextra = new JTextField();
        pan.add(txtextra);
        txtextra.setBounds(150, 519, 130, 30);
        txtextra.setFont(ft1);
        txtextra.addKeyListener(this);

        cbexsts = new JCheckBox("Extra Paid??");
        pan.add(cbexsts);
        cbexsts.setBounds(340, 519, 120, 25);
        cbexsts.setFont(ft);
        cbexsts.addKeyListener(this);

        jldate = new JLabel("Payment Date");
        pan.add(jldate);
        jldate.setBounds(345, 220, 130, 25);
        jldate.setFont(ft);

        txtdate = new JTextField();
        pan.add(txtdate);
        txtdate.setBounds(460, 220, 130, 30);
        txtdate.setFont(ft1);
        txtdate.addKeyListener(this);

        btnsubmit = new JButton("Update",new ImageIcon("images/save.png"));
        pan.add(btnsubmit);
        btnsubmit.setFont(ft2);
        btnsubmit.setBackground(Color.BLUE);
        btnsubmit.setForeground(Color.WHITE);
        btnsubmit.setBounds(420, 580, 140, 40);
        btnsubmit.addActionListener(this);

        ////////////////////////////retrieving the data record from the studenttran table///////////////////////////////////
        try {
            pstmt = dbc.cn.prepareStatement("select * from studenttran where student_id=?");
            pstmt.setInt(1, student_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                txtstid.setText(rs.getString("student_id"));
                txtfname.setText(rs.getString("fname"));
                txtmname.setText(rs.getString("mname"));
                txtlname.setText(rs.getString("lname"));
                txtclass.setText(rs.getString("class"));
                txtroll.setText(rs.getString("roll_no"));
                txtdate.setText(rs.getString("date_of_payment"));
                txtextra.setText(rs.getString("extra_amt"));
                txtcomputer.setText(rs.getString("computer_lab"));
                txtpaidupto.setText(rs.getString("paid_upto"));
                txtpaid.setText(rs.getString("paid_amt"));
                txtmonthly.setText(rs.getString("monthly_fee"));
                txtdue.setText(rs.getString("balance_due"));
                txtadmission.setText(rs.getString("admission"));
                cbadmission.setSelected(rs.getBoolean("admission_sts"));
                cblabsts.setSelected(rs.getBoolean("lab_sts"));
                cbexsts.setSelected(rs.getBoolean("extra_paid"));

            }
        } catch (SQLException exx) {
            exx.printStackTrace();
        }
        addKeyListener(this);
        setSize(1000, 670);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Student  Transaction");
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        //new IndirectStudentTransaction(5);
    }

    //////////////////////////Updating Students' Transaction////////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnsubmit) {
            if (txtclass.getText().equals("") || txtdate.getText().equals("") || txtroll.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Incomplete Information !!", "Updating Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtadmission.getText().equals("") || txtmonthly.getText().equals("") || txtcomputer.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "You have to specify admission, monthly and computer lab fee always!!", "Updating Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    pstmt = dbc.cn.prepareStatement("update studenttran set fname=?,mname=?,lname=?,class=?,roll_no=?,admission=?,admission_sts=?,monthly_fee=?,paid_amt=?,paid_upto=?,balance_due=?,computer_lab=?,lab_sts=?,extra_amt=?,extra_paid=?,date_of_payment=? where student_id=?");

                    pstmt.setString(1, txtfname.getText());
                    pstmt.setString(2, txtmname.getText());
                    pstmt.setString(3, txtlname.getText());
                    pstmt.setString(4, txtclass.getText());
                    pstmt.setString(5, txtroll.getText());
                    pstmt.setString(6, txtadmission.getText());
                    String status;
                    if (cbadmission.isSelected()) {
                        status = "Admitted";
                    } else {
                        status = "Not Admitted";
                    }
                    pstmt.setString(7, status);
                    pstmt.setString(8, txtmonthly.getText());
                    pstmt.setString(9, txtpaid.getText());
                    pstmt.setString(10, txtpaidupto.getText());
                    pstmt.setString(11, txtdue.getText());
                    pstmt.setString(12, txtcomputer.getText());
                    String bb;
                    if (cblabsts.isSelected()) {
                        bb = "Lab Paid";
                    } else {
                        bb = "Lab Not Paid";
                    }
                    pstmt.setString(13, bb);

                    pstmt.setString(14, txtextra.getText());
                    String ss;
                    if (cbexsts.isSelected()) {
                        ss = "Extra Paid";
                    } else {
                        ss = "Extra Not Paid";
                    }
                    pstmt.setString(15, ss);
                    pstmt.setString(16, txtdate.getText());
                    pstmt.setInt(17, Integer.parseInt(txtstid.getText()));

                    rss = pstmt.executeUpdate();

                    if (rss > 0) {
                        JOptionPane.showMessageDialog(null, "Payment Successful !!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Payment Not Successful !!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                this.dispose();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == txtpaidupto) {
            char c = e.getKeyChar();
            if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SPACE))) {
                getToolkit().beep();
                e.consume();
            }
        } else if (e.getSource() == txtcomputer || e.getSource() == txtpaid || e.getSource() == txtmonthly || e.getSource() == txtadmission || e.getSource() == txtdue) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                e.consume();
            }
        } else if (e.getSource() == txtdate) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_MINUS))) {
                getToolkit().beep();
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtclass.getText().equals("") || txtdate.getText().equals("") || txtroll.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Incomplete Information !!", "Updating Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtadmission.getText().equals("") || txtmonthly.getText().equals("") || txtcomputer.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "You have to specify admission, monthly and computer lab fee always!!", "Updating Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    pstmt = dbc.cn.prepareStatement("update studenttran set fname=?,mname=?,lname=?,class=?,roll_no=?,admission=?,admission_sts=?,monthly_fee=?,paid_amt=?,paid_upto=?,balance_due=?,computer_lab=?,lab_sts=?,extra_amt=?,extra_paid=?,date_of_payment=? where student_id=?");

                    pstmt.setString(1, txtfname.getText());
                    pstmt.setString(2, txtmname.getText());
                    pstmt.setString(3, txtlname.getText());
                    pstmt.setString(4, txtclass.getText());
                    pstmt.setString(5, txtroll.getText());
                    pstmt.setString(6, txtadmission.getText());
                    String status;
                    if (cbadmission.isSelected()) {
                        status = "Admitted";
                    } else {
                        status = "Not Admitted";
                    }
                    pstmt.setString(7, status);
                    pstmt.setString(8, txtmonthly.getText());
                    pstmt.setString(9, txtpaid.getText());
                    pstmt.setString(10, txtpaidupto.getText());
                    pstmt.setString(11, txtdue.getText());
                    pstmt.setString(12, txtcomputer.getText());
                    String bb;
                    if (cblabsts.isSelected()) {
                        bb = "Lab Paid";
                    } else {
                        bb = "Lab Not Paid";
                    }
                    pstmt.setString(13, bb);

                    pstmt.setString(14, txtextra.getText());
                    String ss;
                    if (cbexsts.isSelected()) {
                        ss = "Extra Paid";
                    } else {
                        ss = "Extra Not Paid";
                    }
                    pstmt.setString(15, ss);
                    pstmt.setString(16, txtdate.getText());
                    pstmt.setInt(17, Integer.parseInt(txtstid.getText()));

                    rss = pstmt.executeUpdate();

                    if (rss > 0) {
                        JOptionPane.showMessageDialog(null, "Payment Successful !!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Payment Not Successful !!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                this.dispose();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == txtpaidupto) {
            if (txtpaidupto.getText().length() > 40) {
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Duration Error !!", JOptionPane.ERROR_MESSAGE);
                char c = e.getKeyChar();
                txtpaidupto.setText(txtpaidupto.getText().substring(0, 41));
            } else {
                String name = txtpaidupto.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());
                String newname = f.toUpperCase() + l.toLowerCase();
                txtpaidupto.setText(newname);
            }
        }

        if (e.getSource() == txtcomputer) {
            if (txtcomputer.getText().length() > 5) {
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);
                txtcomputer.setText(txtcomputer.getText().substring(0, 6));
            }
        } else if (e.getSource() == txtpaid) {
            if (txtpaid.getText().length() > 5) {
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);
                txtpaid.setText(txtpaid.getText().substring(0, 6));
            }
        } else if (e.getSource() == txtmonthly) {
            if (txtmonthly.getText().length() > 5) {
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);
                txtmonthly.setText(txtmonthly.getText().substring(0, 6));
            }
        } else if (e.getSource() == txtadmission) {
            if (txtadmission.getText().length() > 5) {
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);
                txtadmission.setText(txtadmission.getText().substring(0, 6));
            }
        } else if (e.getSource() == txtdue) {
            if (txtdue.getText().length() > 5) {
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);
                txtdue.setText(txtdue.getText().substring(0, 6));
            }
        } else if (e.getSource() == txtextra) {
            if (txtextra.getText().length() > 40) {
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);
                txtextra.setText(txtextra.getText().substring(0, 41));
            }
        } else if (e.getSource() == txtdate) {
            if (txtdate.getText().length() > 9) {
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);
                txtdate.setText(txtdate.getText().substring(0, 10));
            }
        }
    }
}
