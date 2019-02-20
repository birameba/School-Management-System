//////////////////////Called from Edit Student ////////////////////////////////

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class EditTable extends JDialog implements ActionListener, KeyListener {

    JLabel jlnewst, jlapplelogo, jlroll, jlstdid, newstdimg, jlfname, jllname, jlclass, jlhouse, jlgender, jlmname, jladdress, jldob, jlguardian, jlnationality, jlmobile, jlphone;
    JTextField txtstdid, txtfname, txtroll, txtclass, txthouse, txtlname, txtmname, txtaddress, txtdob, txtguardian, txtmobile, txtphone;
    JComboBox cbnationality;
    JButton btnupdate;
    JRadioButton rbmale, rbfemale;
    ButtonGroup bg;
    Statement stmt;
    PreparedStatement pstmt;
    DBConnection1 dbc = new DBConnection1();
    JPanel pan;
    int result;

    public EditTable(int student_id) {

        pan = new JPanel(null);
        add(pan);
        pan.setBackground(Color.WHITE);
        Font ft2 = new Font("", Font.BOLD, 18);
        Font ft = new Font("", Font.BOLD, 15);
        Font ft1 = new Font("", Font.PLAIN, 15);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pan.add(jlapplelogo);
        jlapplelogo.setBounds(15, 5, 669, 140);

        jlnewst = new JLabel(new ImageIcon("images/editst.png"));
        pan.add(jlnewst);
        jlnewst.setBounds(0, 150, 696, 33);

        jlstdid = new JLabel("Student ID");
        pan.add(jlstdid);
        jlstdid.setBounds(50, 208, 80, 25);
        jlstdid.setFont(ft);

        txtstdid = new JTextField();
        pan.add(txtstdid);
        txtstdid.setEnabled(false);
        txtstdid.setFont(ft1);
        txtstdid.addKeyListener(this);
        txtstdid.setBounds(187, 208, 135, 30);

        jlfname = new JLabel("First Name");
        pan.add(jlfname);
        jlfname.setBounds(50, 253, 80, 25);
        jlfname.setFont(ft);

        txtfname = new JTextField();
        pan.add(txtfname);
        txtfname.setBounds(187, 253, 135, 30);
        txtfname.setEnabled(false);
        txtfname.addKeyListener(this);
        txtfname.setFont(ft1);

        jlmname = new JLabel("Middle Name");
        pan.add(jlmname);
        jlmname.setBounds(365, 253, 130, 25);
        jlmname.setFont(ft);

        txtmname = new JTextField();
        pan.add(txtmname);
        txtmname.setBounds(480, 253, 135, 30);
        txtmname.setEnabled(false);
        txtmname.addKeyListener(this);
        txtmname.setFont(ft1);

        jllname = new JLabel("Last Name");
        pan.add(jllname);
        jllname.setBounds(50, 298, 80, 25);
        jllname.setFont(ft);

        txtlname = new JTextField();
        pan.add(txtlname);
        txtlname.setBounds(187, 298, 135, 30);
        txtlname.setEnabled(false);
        txtlname.addKeyListener(this);
        txtlname.setFont(ft1);

        jldob = new JLabel("Date of Birth");
        pan.add(jldob);
        jldob.setBounds(365, 298, 100, 25);
        jldob.setFont(ft);

        txtdob = new JTextField();
        pan.add(txtdob);
        txtdob.setBounds(480, 298, 135, 30);
        txtdob.setEnabled(false);
        txtdob.setFont(ft1);
        txtdob.addKeyListener(this);

        jlclass = new JLabel("Class");
        pan.add(jlclass);
        jlclass.setBounds(50, 343, 80, 25);
        jlclass.setFont(ft);

        txtclass = new JTextField();
        pan.add(txtclass);
        txtclass.setBounds(187, 343, 135, 30);
        txtclass.setFont(ft1);
        txtclass.addKeyListener(this);

        jlroll = new JLabel("Roll No.");
        pan.add(jlroll);
        jlroll.setBounds(365, 343, 80, 25);
        jlroll.setFont(ft);

        txtroll = new JTextField();
        pan.add(txtroll);
        txtroll.setBounds(480, 343, 135, 30);
        txtroll.setFont(ft1);
        txtroll.addKeyListener(this);

        jladdress = new JLabel("Address");
        pan.add(jladdress);
        jladdress.setBounds(50, 388, 80, 25);
        jladdress.setFont(ft);

        txtaddress = new JTextField();
        pan.add(txtaddress);
        txtaddress.setBounds(187, 388, 135, 30);
        txtaddress.setFont(ft1);
        txtaddress.addKeyListener(this);

        jlhouse = new JLabel("House");
        pan.add(jlhouse);
        jlhouse.setBounds(365, 388, 80, 25);
        jlhouse.setFont(ft);

        txthouse = new JTextField();
        pan.add(txthouse);
        txthouse.setBounds(480, 388, 135, 30);
        txthouse.setFont(ft1);
        txthouse.addKeyListener(this);

        jlgender = new JLabel("Gender");
        pan.add(jlgender);
        jlgender.setBounds(50, 433, 90, 25);
        jlgender.setFont(ft);

        rbmale = new JRadioButton("Male");
        pan.add(rbmale);
        rbmale.setBounds(187, 433, 60, 25);
        rbmale.setEnabled(false);
        rbmale.addKeyListener(this);

        rbmale.setFont(ft);

        rbfemale = new JRadioButton("Female");
        pan.add(rbfemale);
        rbfemale.setBounds(250, 433, 80, 25);
        rbfemale.setEnabled(false);
        rbfemale.setFont(ft);
        rbfemale.addKeyListener(this);

        bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        jlguardian = new JLabel("Gaurdian Name");
        pan.add(jlguardian);
        jlguardian.setBounds(365, 433, 130, 25);
        jlguardian.setFont(ft);

        txtguardian = new JTextField();
        pan.add(txtguardian);
        txtguardian.setBounds(480, 433, 135, 30);
        txtguardian.setEnabled(false);
        txtguardian.addKeyListener(this);
        txtguardian.setFont(ft1);
        
         jlnationality = new JLabel("Nationality");
        pan.add(jlnationality);
        jlnationality.setBounds(50, 478, 80, 17);
        jlnationality.setFont(ft);
        
        
        cbnationality = new JComboBox();
        pan.add(cbnationality);
        cbnationality.setBounds(190, 478, 135, 30);
        cbnationality.addItem("");
        cbnationality.addItem("nepali");
        cbnationality.addItem("indian");
        cbnationality.addItem("others");
        cbnationality.setEnabled(false);
        cbnationality.setFont(ft);
        cbnationality.addKeyListener(this);
        cbnationality.setFont(ft1);

        jlmobile = new JLabel("Mobile Number");
        pan.add(jlmobile);
        jlmobile.setBounds(50, 523, 130, 25);
        jlmobile.setFont(ft);

        txtmobile = new JTextField("");
        pan.add(txtmobile).setBounds(187, 523, 135, 30);
        txtmobile.setFont(ft1);
        txtmobile.addKeyListener(this);

        jlphone = new JLabel("Phone Number");
        pan.add(jlphone);
        jlphone.setBounds(365, 523, 130, 25);
        jlphone.setFont(ft);

        txtphone = new JTextField("");
        pan.add(txtphone);
        txtphone.setBounds(480, 523, 135, 30);
        txtphone.setFont(ft1);
        txtphone.addKeyListener(this);

       


        btnupdate = new JButton("Update",new ImageIcon("images/save.png"));
        pan.add(btnupdate);
        btnupdate.setBounds(300, 580, 120, 40);
        btnupdate.setFont(ft2);   
        btnupdate.setBackground(Color.WHITE);
        btnupdate.setForeground(Color.BLUE);
        btnupdate.addActionListener(this);
        btnupdate.addKeyListener(this);

        /////////////////////retrieving students' data from the record table//////////////////////////////////////
        try {
            PreparedStatement pstmt = dbc.cn.prepareStatement("SELECT * FROM record where student_id=?");
            pstmt.setInt(1, student_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                txtstdid.setText(rs.getString("student_id"));
                txtfname.setText(rs.getString("fname"));
                txtmname.setText(rs.getString("mname"));
                txtlname.setText(rs.getString("lname"));
                txtroll.setText(rs.getString("roll_no"));
                String gender = rs.getString("gender");
                if (gender.equalsIgnoreCase("male")) {
                    rbmale.setSelected(true);
                }
                if (gender.equalsIgnoreCase("female")) {
                    rbfemale.setSelected(true);
                }
                txtdob.setText(rs.getString("DOB"));
                txtclass.setText(rs.getString("class"));
                txthouse.setText(rs.getString("sc_home"));
                txtaddress.setText(rs.getString("address"));
                txtguardian.setText(rs.getString("guardian"));
                txtmobile.setText(rs.getString("mobile"));
                txtphone.setText(rs.getString("phone"));
                cbnationality.setSelectedItem(new String(rs.getString("nationality")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        setSize(700, 670);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Edit Student Record");

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        //new EditTable(5);
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnupdate) {
            if (txtroll.getText().equals("") || txtaddress.getText().equals("") || txtclass.getText().equals("") || txthouse.getText().equals("") || txtmobile.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Incomplete Information", "Updating Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String gen = "";
                if (rbmale.isSelected()) {
                    gen = "male";
                } else if (rbfemale.isSelected()) {
                    gen = "female";
                }
                try {
                    pstmt = dbc.cn.prepareStatement("update record set fname=?,mname=?,lname=?,roll_no=?,gender=?,DOB=?,class=?,sc_home=?,address=?,guardian=?,mobile=?,phone=?,nationality=? where student_id=?");
                    pstmt.setString(1, txtfname.getText());
                    pstmt.setString(2, txtmname.getText());
                    pstmt.setString(3, txtlname.getText());
                    pstmt.setString(4, txtroll.getText());
                    pstmt.setString(5, gen);
                    pstmt.setString(6, txtdob.getText());
                    pstmt.setString(7, txtclass.getText());
                    pstmt.setString(8, txthouse.getText());
                    pstmt.setString(9, txtaddress.getText());
                    pstmt.setString(10, txtguardian.getText());
                    pstmt.setString(11, txtmobile.getText());
                    pstmt.setString(12, txtphone.getText());
                    pstmt.setString(13, cbnationality.getSelectedItem().toString());
                    pstmt.setInt(14, Integer.parseInt(txtstdid.getText()));

                    result = pstmt.executeUpdate();
                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Record Updated !");
                    } else {
                        JOptionPane.showMessageDialog(null, "Record Not Updated");
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
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == txtphone || e.getSource() == txtmobile || e.getSource() == txtroll || e.getSource() == txtdob) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_MINUS))) {
                getToolkit().beep();
                e.consume();
            }
        }
         else if (e.getSource() == txtclass|| e.getSource() == txtaddress || e.getSource() == txthouse ) {
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
            if (txtroll.getText().equals("") || txtaddress.getText().equals("") || txtclass.getText().equals("") || txthouse.getText().equals("") || txtmobile.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Incomplete Information !!", "Saving Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String gen = "";
                if (rbmale.isSelected()) {
                    gen = "male";
                } else if (rbfemale.isSelected()) {
                    gen = "female";
                }
                try {
                    pstmt = dbc.cn.prepareStatement("update record set fname=?,mname=?,lname=?,roll_no=?,gender=?,DOB=?,class=?,sc_home=?,address=?,guardian=?,mobile=?,phone=?,nationality=? where student_id=?");
                    pstmt.setString(1, txtfname.getText());
                    pstmt.setString(2, txtmname.getText());
                    pstmt.setString(3, txtlname.getText());
                    pstmt.setString(4, txtroll.getText());
                    pstmt.setString(5, gen);
                    pstmt.setString(6, txtdob.getText());
                    pstmt.setString(7, txtclass.getText());
                    pstmt.setString(8, txthouse.getText());
                    pstmt.setString(9, txtaddress.getText());
                    pstmt.setString(10, txtguardian.getText());
                    pstmt.setString(11, txtmobile.getText());
                    pstmt.setString(12, txtphone.getText());
                    pstmt.setString(13, cbnationality.getSelectedItem().toString());
                    pstmt.setInt(14, Integer.parseInt(txtstdid.getText()));

                    result = pstmt.executeUpdate();
                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Record Updated !");
                    } else {
                        JOptionPane.showMessageDialog(null, "Record Not Updated");
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

        if (e.getSource() == txtroll) {
            if (txtroll.getText().length() > 4) {
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);
                txtroll.setText(txtroll.getText().substring(0, 5));
            }
        }

        if (e.getSource() == txtmobile) {
            if (txtmobile.getText().length() > 9) {
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Mobile Number Error !!", JOptionPane.ERROR_MESSAGE);
                txtmobile.setText(txtmobile.getText().substring(0, 10));
            }
        }
        if (e.getSource() == txtphone) {
            if (txtphone.getText().length() > 9) {
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Phone Number Error !!", JOptionPane.ERROR_MESSAGE);
                txtphone.setText(txtphone.getText().substring(0, 10));
            }
        }

        if (e.getSource() == txtclass) {
            if (txtclass.getText().length() > 9) {
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Naming Error !!", JOptionPane.ERROR_MESSAGE);
                txtclass.setText(txtclass.getText().substring(0, 10));
            } else {
                String name = txtclass.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());
                String newname = f.toUpperCase() + l.toLowerCase();
                txtclass.setText(newname);
            }
        }

        if (e.getSource() == txthouse) {
            if (txthouse.getText().length() > 8) {
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Naming Error !!", JOptionPane.ERROR_MESSAGE);
                txthouse.setText(txthouse.getText().substring(0, 9));
            } else {
                String name = txthouse.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());
                String newname = f.toUpperCase() + l.toLowerCase();
                txthouse.setText(newname);
            }
        }

        if (e.getSource() == txtaddress) {
            if (txtaddress.getText().length() > 20) {
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Addressing Error !!", JOptionPane.ERROR_MESSAGE);
                txtaddress.setText(txtaddress.getText().substring(0, 21));
            } else {
                String name = txtaddress.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());
                String newname = f.toUpperCase() + l.toLowerCase();
                txtaddress.setText(newname);
            }
        }
    }
}
