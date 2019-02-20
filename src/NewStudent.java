
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class NewStudent extends JDialog implements ActionListener, KeyListener {

    JLabel jlnewst, jlapplelogo, jlroll, jlstdid, jformat, newstdimg, jlfname, jllname, jlclass, jlhouse, jlgender, jlmname, jladdress, jldob, jlguardian, jlnationality, jlmobile, jlphone;
    JTextField txtstdid, txtfname, txtroll, txthouse, txtlname, txtmname, txtaddress, txtdob, txtguardian, txtmobile, txtphone;
    JComboBox cbnationality, txtclass;
    JButton btnsave, btnreset;
    JRadioButton rbmale, rbfemale;
    ButtonGroup bg;
    PreparedStatement pstmt;
    int result;
    ResultSet rs;
    DBConnection1 dbc = new DBConnection1();
    JPanel pan;
    String name, f, l, newname;

    public NewStudent() {
        pan = new JPanel(null);
        add(pan);
        pan.setBackground(Color.WHITE);
        Font ft2 = new Font("", Font.BOLD, 19);
        Font ft = new Font("", Font.BOLD, 15);
        Font ft1 = new Font("", Font.PLAIN, 15);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pan.add(jlapplelogo);
        jlapplelogo.setBounds(200, 5, 560, 124);

        jlnewst = new JLabel(new ImageIcon("images/newst1.png"));
        pan.add(jlnewst);
        jlnewst.setBounds(0, 155, 960, 33);

        jlstdid = new JLabel("Student ID");
        pan.add(jlstdid);
        jlstdid.setBounds(50, 218, 80, 25);
        jlstdid.setFont(ft);

        txtstdid = new JTextField();
        pan.add(txtstdid);
        txtstdid.setBounds(165, 218, 160, 30);
        txtstdid.setEnabled(false);

        jlfname = new JLabel("First Name");
        pan.add(jlfname);
        jlfname.setBounds(50, 263, 80, 25);

        jlfname.setFont(ft);

        txtfname = new JTextField();
        pan.add(txtfname);
        txtfname.setBounds(165, 263, 160, 30);
        txtfname.setFont(ft1);

        txtfname.addActionListener(this);
        txtfname.addKeyListener(this);

        jlmname = new JLabel("Middle Name");
        pan.add(jlmname);
        jlmname.setBounds(355, 263, 130, 25);
        jlmname.setFont(ft);

        txtmname = new JTextField();
        pan.add(txtmname);
        txtmname.setBounds(460, 263, 160, 30);
        txtmname.setFont(ft1);
        txtmname.addKeyListener(this);

        jllname = new JLabel("Last Name");
        pan.add(jllname);
        jllname.setBounds(650, 263, 80, 25);
        jllname.setFont(ft);

        txtlname = new JTextField();
        pan.add(txtlname);
        txtlname.setBounds(740, 263, 160, 30);
        txtlname.setFont(ft1);
        txtlname.addKeyListener(this);

        jldob = new JLabel("Date of Birth");
        pan.add(jldob);
        jldob.setBounds(50, 308, 100, 25);
        jldob.setFont(ft);

        txtdob = new JTextField("");
        pan.add(txtdob);
        txtdob.setBounds(165, 308, 160, 30);
        txtdob.setFont(ft1);

        txtdob.addKeyListener(this);

        jformat = new JLabel("(yy-mm-dd)");
        pan.add(jformat);
        jformat.setBounds(330, 308, 85, 25);
        jformat.setFont(ft);

        jladdress = new JLabel("Address");
        pan.add(jladdress);
        jladdress.setBounds(50, 353, 80, 25);
        jladdress.setFont(ft);

        txtaddress = new JTextField();
        pan.add(txtaddress);
        txtaddress.setBounds(165, 353, 160, 30);
        txtaddress.setFont(ft1);
        txtaddress.addKeyListener(this);

        jlgender = new JLabel("Gender");
        pan.add(jlgender);
        jlgender.setBounds(365, 353, 100, 25);
        jlgender.setFont(ft);

        rbmale = new JRadioButton("Male");
        pan.add(rbmale);
        rbmale.setBounds(440, 353, 60, 25);
        rbmale.setFont(ft);
        rbmale.addKeyListener(this);

        rbfemale = new JRadioButton("Female");
        pan.add(rbfemale);
        rbfemale.setBounds(520, 353, 80, 25);
        rbfemale.setFont(ft);
        rbfemale.addKeyListener(this);

        jlnationality = new JLabel("Nationality");
        pan.add(jlnationality);
        jlnationality.setBounds(650, 353, 80, 25);
        jlnationality.setFont(ft);

        cbnationality = new JComboBox();
        pan.add(cbnationality);
        cbnationality.setBounds(740, 353, 160, 33);
        cbnationality.addKeyListener(this);
        cbnationality.addItem("");
        cbnationality.addItem("Nepali");
        cbnationality.addItem("Indian");
        cbnationality.addItem("Others");
        cbnationality.setFont(ft1);

        jlclass = new JLabel("Class");
        pan.add(jlclass);
        jlclass.setBounds(50, 398, 80, 25);
        jlclass.setFont(ft);

        txtclass = new JComboBox();
        pan.add(txtclass);
        txtclass.setBounds(165, 398, 160, 33);
        txtclass.addItem("");
        txtclass.addItem("Nursery");
        txtclass.addItem("LKG");
        txtclass.addItem("UKG");
        txtclass.addItem("One");
        txtclass.addItem("Two");
        txtclass.addItem("Three");
        txtclass.addItem("Four");
        txtclass.addItem("Five");
        txtclass.addItem("Six");
        txtclass.addItem("Seven");
        txtclass.addItem("Eight");
        txtclass.addItem("Nine");
        txtclass.addItem("Ten");
        txtclass.setFont(ft1);
        txtclass.addKeyListener(this);

        jlroll = new JLabel("Roll No.");
        pan.add(jlroll);
        jlroll.setBounds(50, 443, 80, 25);
        jlroll.setFont(ft);

        txtroll = new JTextField();
        pan.add(txtroll);
        txtroll.setBounds(165, 443, 160, 30);
        txtroll.setFont(ft1);
        txtroll.addKeyListener(this);

        jlhouse = new JLabel("House");
        pan.add(jlhouse);
        jlhouse.setBounds(50, 488, 80, 25);
        jlhouse.setFont(ft);

        txthouse = new JTextField("");
        pan.add(txthouse);
        txthouse.setBounds(165, 488, 160, 30);
        txthouse.setFont(ft1);

        txthouse.addKeyListener(this);

        bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        jlguardian = new JLabel("Gaurdian Name");
        pan.add(jlguardian);
        jlguardian.setBounds(50, 533, 130, 25);
        jlguardian.setFont(ft);

        txtguardian = new JTextField();
        pan.add(txtguardian);
        txtguardian.setBounds(165, 533, 160, 30);
        txtguardian.setFont(ft1);
        txtguardian.addKeyListener(this);

        jlmobile = new JLabel("Mobile Number");
        pan.add(jlmobile);
        jlmobile.setBounds(50, 578, 140, 25);
        jlmobile.setFont(ft);

        txtmobile = new JTextField("");
        pan.add(txtmobile).setBounds(165, 578, 160, 30);
        txtmobile.setFont(ft1);
        txtmobile.addKeyListener(this);

        jlphone = new JLabel("Phone No.");
        pan.add(jlphone);
        jlphone.setBounds(360, 578, 130, 25);
        jlphone.setFont(ft);

        txtphone = new JTextField("");
        pan.add(txtphone);
        txtphone.setBounds(460, 578, 160, 30);
        txtphone.setFont(ft1);
        txtphone.setColumns(15);

        txtphone.addKeyListener(this);

        btnsave = new JButton("Submit", new ImageIcon("images/save.png"));
        pan.add(btnsave);
        btnsave.setBounds(630, 635, 130, 40);
        btnsave.setBackground(Color.WHITE);
        btnsave.setForeground(Color.BLUE);
        btnsave.setFont(ft2);
        btnsave.addActionListener(this);
        btnsave.addKeyListener(this);

        btnreset = new JButton("Reset", new ImageIcon("images/refresh.png"));
        pan.add(btnreset);
        btnreset.setBounds(780, 635, 130, 40);
        btnreset.setBackground(Color.WHITE);
        btnreset.setForeground(Color.BLUE);
        btnreset.setFont(ft2);
        btnreset.addActionListener(this);
        btnreset.addKeyListener(this);

        setSize(960, 730);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Student Record");

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new NewStudent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnsave) {
            if (txtfname.getText().equals("") || txtlname.getText().equals("") || rbmale.isSelected() == false && rbfemale.isSelected() == false || txtroll.getText().equals("") || txtaddress.getText().equals("") || txtdob.getText().equals("") || txtclass.getSelectedItem() == "" || txthouse.getText().equals("") || txtmobile.getText().equals("") || txtguardian.getText().equals("") || cbnationality.getSelectedItem() == "") {
                JOptionPane.showMessageDialog(null, "Incomplete Information !!", "Saving Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String gen = "";
                if (rbmale.isSelected()) {
                    gen = "male";
                } else if (rbfemale.isSelected()) {
                    gen = "female";
                }
                try {
                    pstmt = dbc.cn.prepareStatement("insert into record (fname,mname,lname,roll_no,gender,DOB,class,sc_home,address,guardian,mobile,phone,nationality) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pstmt.setString(1, txtfname.getText());
                    pstmt.setString(2, txtmname.getText());
                    pstmt.setString(3, txtlname.getText());
                    pstmt.setString(4, txtroll.getText());
                    pstmt.setString(5, gen);
                    pstmt.setString(6, txtdob.getText());
                    pstmt.setString(7, txtclass.getSelectedItem().toString());
                    pstmt.setString(8, txthouse.getText());
                    pstmt.setString(9, txtaddress.getText());
                    pstmt.setString(10, txtguardian.getText());
                    pstmt.setString(11, txtmobile.getText());
                    pstmt.setString(12, txtphone.getText());
                    pstmt.setString(13, cbnationality.getSelectedItem().toString());
                    result = pstmt.executeUpdate();
                    if (result > 0) {
                        try {
                            pstmt = dbc.cn.prepareStatement("SELECT student_id  FROM record where class=? and roll_no=?");
                            pstmt.setString(1, txtclass.getSelectedItem().toString());
                            pstmt.setString(2, txtroll.getText());
                            rs = pstmt.executeQuery();
                            if (rs.next()) {
                                int id = Integer.parseInt(rs.getString("student_id"));
                                JOptionPane.showMessageDialog(null, "Student Added.\n Respective Student ID is: " + id, "New Student Admitted", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (SQLException ee) {
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Record not saved !", "Students' Record", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                this.dispose();
            }
        }
        if (e.getSource() == btnreset) {
            txtfname.setText("");
            txtmname.setText("");
            txtlname.setText("");
            rbmale.setSelected(false);
            rbfemale.setSelected(false);
            txtroll.setText("");
            txtguardian.setText("");
            txtphone.setText("");
            txtaddress.setText("");
            txtdob.setText("");
            txtclass.setSelectedItem("");
            txthouse.setText("");
            txtmobile.setText("");
            cbnationality.setSelectedItem("");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == txtphone || e.getSource() == txtmobile || e.getSource() == txtroll || e.getSource() == txtdob) {

            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_MINUS))) {
                getToolkit().beep();
                e.consume();

            }
        }
        if (e.getSource() == txtfname || e.getSource() == txtmname || e.getSource() == txtlname || e.getSource() == txthouse || e.getSource() == txtaddress) {
            char c = e.getKeyChar();
            if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                e.consume();
            }
        }
        if (e.getSource() == txtguardian) {
            char c = e.getKeyChar();
            if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SPACE))) {
                getToolkit().beep();
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtfname.getText().equals("") || txtlname.getText().equals("") || rbmale.isSelected() == false && rbfemale.isSelected() == false || txtroll.getText().equals("") || txtaddress.getText().equals("") || txtdob.getText().equals("") || txtdob.getText().equalsIgnoreCase("year-month-day") || txtclass.getSelectedItem() == "" || txthouse.getText().equals("") || txtmobile.getText().equals("") || cbnationality.getSelectedItem() == "") {
                JOptionPane.showMessageDialog(null, "Incomplete Information", "Saving Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String gen = "";
                if (rbmale.isSelected()) {
                    gen = "male";
                } else if (rbfemale.isSelected()) {
                    gen = "female";
                }
                try {
                    pstmt = dbc.cn.prepareStatement("insert into record (fname,mname,lname,roll_no,gender,DOB,class,sc_home,address,guardian,mobile,phone,nationality) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pstmt.setString(1, txtfname.getText());
                    pstmt.setString(2, txtmname.getText());
                    pstmt.setString(3, txtlname.getText());
                    pstmt.setString(4, txtroll.getText());
                    pstmt.setString(5, gen);
                    pstmt.setString(6, txtdob.getText());
                    pstmt.setString(7, txtclass.getSelectedItem().toString());
                    pstmt.setString(8, txthouse.getText());
                    pstmt.setString(9, txtaddress.getText());
                    pstmt.setString(10, txtguardian.getText());
                    pstmt.setString(11, txtmobile.getText());
                    pstmt.setString(12, txtphone.getText());
                    pstmt.setString(13, cbnationality.getSelectedItem().toString());
                    result = pstmt.executeUpdate();
                    if (result > 0) {
                        try {
                            pstmt = dbc.cn.prepareStatement("SELECT student_id  FROM record where class=? and roll_no=?");
                            pstmt.setString(1, txtclass.getSelectedItem().toString());
                            pstmt.setString(2, txtroll.getText());
                            rs = pstmt.executeQuery();
                            if (rs.next()) {
                                int id = Integer.parseInt(rs.getString("student_id"));
                                JOptionPane.showMessageDialog(null, "<html>Student Added.<br>Respective Student ID is </html>" + id, "New Student Admitted", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (SQLException ee) {
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Record not saved !", "Students' Record", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                // catch(ClassNotFoundException exx){}
                this.dispose();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == txtdob) {
            if (txtdob.getText().length() > 10) {
                txtdob.setText(txtdob.getText().substring(0, 10));
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Date Error !!", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == txtroll) {
            if (txtroll.getText().length() > 5) {
                txtroll.setText(txtroll.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);

            }
        }

        if (e.getSource() == txtmobile) {
            if (txtmobile.getText().length() > 10) {
                txtmobile.setText(txtmobile.getText().substring(0, 10));
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Mobile Number Error !!", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == txtphone) {
            if (txtphone.getText().length() > 10) {
                txtphone.setText(txtphone.getText().substring(0, 10));
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Phone Number Error !!", JOptionPane.ERROR_MESSAGE);

            }
        }

        if (e.getSource() == txtfname) {
            if (txtfname.getText().length() > 13) {
                txtfname.setText(txtfname.getText().substring(0, 13));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Naming Error !!", JOptionPane.ERROR_MESSAGE);

            } else {
                String name = txtfname.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());
                String newname = f.toUpperCase() + l.toLowerCase();
                txtfname.setText(newname);
            }
        }
        if (e.getSource() == txtlname) {
            if (txtlname.getText().length() > 14) {
                txtlname.setText(txtlname.getText().substring(0, 14));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Naming Error !!", JOptionPane.ERROR_MESSAGE);

            } else {
                String name = txtlname.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());
                String newname = f.toUpperCase() + l.toLowerCase();
                txtlname.setText(newname);
            }
        }
        if (e.getSource() == txtmname) {
            if (txtmname.getText().length() > 15) {
                txtmname.setText(txtmname.getText().substring(0, 15));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Naming Error !!", JOptionPane.ERROR_MESSAGE);

            } else {
                String name = txtmname.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());
                String newname = f.toUpperCase() + l.toLowerCase();
                txtmname.setText(newname);
            }
        }

        if (e.getSource() == txthouse) {
            if (txthouse.getText().length() > 9) {
                txthouse.setText(txthouse.getText().substring(0, 9));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Naming Error !!", JOptionPane.ERROR_MESSAGE);

            } else {
                String name = txthouse.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());
                String newname = f.toUpperCase() + l.toLowerCase();
                txthouse.setText(newname);
            }
        }

        if (e.getSource() == txtaddress) {
            if (txtaddress.getText().length() > 21) {
                txtaddress.setText(txtaddress.getText().substring(0, 21));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Addressing Error !!", JOptionPane.ERROR_MESSAGE);

            } else {
                String name = txtaddress.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());
                String newname = f.toUpperCase() + l.toLowerCase();
                txtaddress.setText(newname);
            }
        }
        if (e.getSource() == txtguardian) {
            if (txtguardian.getText().length() > 26) {
                txtguardian.setText(txtguardian.getText().substring(0, 26));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Naming Error !!", JOptionPane.ERROR_MESSAGE);

            } else {
                String name = txtguardian.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());
                String newname = f.toUpperCase() + l.toLowerCase();
                txtguardian.setText(newname);
            }
        }
//        if (e.getSource() == txtphone || e.getSource() == txtmobile || e.getSource() == txtroll || e.getSource() == txtdob) {
//            if(txtphone.getText().length()<=15){
//            char c = e.getKeyChar();
//            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_MINUS))) {
//                getToolkit().beep();
//                e.consume();
//            }
//            }
//            else{
//                  try {
//                    Robot robot=new Robot();
//                   robot.keyPress(KeyEvent.VK_BACK_SPACE);
//                } catch (Exception ex) {
//                }
//            JOptionPane.showMessageDialog(null,"max limit");
//              
//            }
//        }
    }

}
