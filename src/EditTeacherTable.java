///////////////////////////////Called from Edit Teacher/////////////////////////////////////

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class EditTeacherTable extends JDialog implements ActionListener, KeyListener {

    JLabel jltrec, jlapplelogo, jltid, jlfname, jllname, jlqualification, jlgender, jlmname, jladdress, jllevel, jlsalary, jlsubject, jlmobile, jltype;
    JTextField txttid, txtfname, txtlevel, txtqualification, txtlname, txtmname, txtaddress, txtsalary, txttype, txtmobile, txtsubject;
    JButton btnupdate;
    JRadioButton rbmale, rbfemale;
    ButtonGroup bg;
    PreparedStatement pstmt;
    int result;
    DBConnection1 dbc = new DBConnection1();
    JPanel pan = new JPanel();

    public EditTeacherTable(int teacher_id) {
        add(pan);
        pan.setLayout(null);
        pan.setBackground(Color.WHITE);
        Font ft = new Font("", Font.BOLD, 15);
        Font ft2 = new Font("", Font.BOLD, 17);
        Font ft1 = new Font("", Font.PLAIN, 15);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pan.add(jlapplelogo);
        jlapplelogo.setBounds(15, 5, 669, 140);
//
        jltrec = new JLabel(new ImageIcon("images/editteacher.png"));
        pan.add(jltrec);
        jltrec.setBounds(0, 148, 690, 24);

        jltid = new JLabel("Teacher ID");
        pan.add(jltid);
        jltid.setBounds(45, 196, 80, 25);
        jltid.setFont(ft);

        txttid = new JTextField();
        pan.add(txttid);
        txttid.setFont(ft1);
        txttid.addKeyListener(this);
        txttid.setEnabled(false);
        txttid.setBounds(160, 196, 135, 30);

        jlfname = new JLabel("First Name");
        pan.add(jlfname);
        jlfname.setBounds(45, 235, 120, 25);
        jlfname.setFont(ft);

        txtfname = new JTextField();
        pan.add(txtfname);
        txtfname.setBounds(160, 235, 135, 30);
        txtfname.setFont(ft1);
        txtfname.addKeyListener(this);
        txtfname.setEnabled(false);

        jlmname = new JLabel("Middle Name");
        pan.add(jlmname);
        jlmname.setBounds(345, 235, 120, 25);
        jlmname.setFont(ft);

        txtmname = new JTextField();
        pan.add(txtmname);
        txtmname.setBounds(455, 235, 135, 30);
        txtmname.setFont(ft1);
        txtmname.addKeyListener(this);
        txtmname.setEnabled(false);

        jllname = new JLabel("Last Name");
        pan.add(jllname);
        jllname.setBounds(45, 275, 100, 25);
        jllname.setFont(ft);

        txtlname = new JTextField();
        pan.add(txtlname);
        txtlname.setBounds(160, 275, 135, 30);
        txtlname.setFont(ft1);
        txtlname.addKeyListener(this);
        txtlname.setEnabled(false);

        jlqualification = new JLabel("Qualification");
        pan.add(jlqualification);
        jlqualification.setBounds(45, 315, 100, 25);

        jlqualification.setFont(ft);

        txtqualification = new JTextField();
        pan.add(txtqualification);
        txtqualification.setBounds(160, 315, 135, 30);
        txtqualification.setFont(ft1);
        txtqualification.addKeyListener(this);

        jladdress = new JLabel("Address");
        pan.add(jladdress);
        jladdress.setBounds(45, 355, 80, 25);
        jladdress.setFont(ft);

        txtaddress = new JTextField();
        pan.add(txtaddress);
        txtaddress.setBounds(160, 355, 135, 30);
        txtaddress.setFont(ft1);
        txtaddress.addKeyListener(this);

        jllevel = new JLabel("Level");
        pan.add(jllevel);
        jllevel.setBounds(345, 355, 80, 25);
        jllevel.setFont(ft);

        txtlevel = new JTextField();
        pan.add(txtlevel);
        txtlevel.setBounds(455, 355, 135, 30);
        txtlevel.setFont(ft1);
        txtlevel.addKeyListener(this);

        jlsubject = new JLabel("Subject");
        pan.add(jlsubject);
        jlsubject.setBounds(45, 395, 80, 25);
        jlsubject.setFont(ft);

        txtsubject = new JTextField();
        pan.add(txtsubject);
        txtsubject.setBounds(160, 395, 135, 30);
        txtsubject.setFont(ft1);
        txtsubject.addKeyListener(this);

        jlgender = new JLabel("Gender");
        pan.add(jlgender);
        jlgender.setBounds(45, 431, 80, 25);
        jlgender.setFont(ft);

        rbmale = new JRadioButton("Male");
        pan.add(rbmale);
        rbmale.setBounds(160, 431, 60, 25);
        rbmale.setEnabled(false);
        rbmale.addKeyListener(this);
        rbmale.setFont(ft);

        rbfemale = new JRadioButton("Female");
        pan.add(rbfemale);
        rbfemale.setBounds(235, 431, 80, 25);
        rbfemale.setEnabled(false);
        rbfemale.addKeyListener(this);
        rbfemale.setFont(ft);

        bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        jltype = new JLabel("Job Type");
        pan.add(jltype);
        jltype.setBounds(45, 476, 90, 25);
        jltype.setFont(ft);

        txttype = new JTextField();
        pan.add(txttype);
        txttype.setBounds(160, 476, 135, 30);
        txttype.setFont(ft1);
        txttype.addKeyListener(this);

        jlsalary = new JLabel("Salary");
        pan.add(jlsalary);
        jlsalary.setBounds(45, 511, 100, 25);
        jlsalary.setFont(ft);

        txtsalary = new JTextField();
        pan.add(txtsalary);
        txtsalary.setBounds(160, 511, 135, 30);
        txtsalary.setFont(ft1);
        txtsalary.addKeyListener(this);

        jlmobile = new JLabel("Mobile Number");
        pan.add(jlmobile);
        jlmobile.setBounds(45, 551, 120, 25);
        jlmobile.setFont(ft);

        txtmobile = new JTextField();
        pan.add(txtmobile);
        txtmobile.setBounds(160, 551, 135, 30);
        txtmobile.setFont(ft1);
        txtmobile.addKeyListener(this);

        btnupdate = new JButton("Update",new ImageIcon("images/save.png"));
        pan.add(btnupdate);
        btnupdate.setBounds(455, 590, 112, 40);
        btnupdate.setFont(ft2);
        btnupdate.setBackground(Color.BLUE);
        btnupdate.setForeground(Color.WHITE);
        btnupdate.addActionListener(this);
        btnupdate.addKeyListener(this);

        /////////////////////retrieving teachers' data from the teacher table//////////////////////////////////////
        try {
            PreparedStatement pstmt = dbc.cn.prepareStatement("SELECT * FROM teacher where teacher_id=?");
            pstmt.setInt(1, teacher_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                txttid.setText(rs.getString("teacher_id"));
                txtfname.setText(rs.getString("fname"));
                txtmname.setText(rs.getString("mname"));
                txtlname.setText(rs.getString("lname"));
                txtqualification.setText(rs.getString("qualification"));
                txtaddress.setText(rs.getString("address"));
                String gender = rs.getString("gender");
                if (gender.equalsIgnoreCase("male")) {
                    rbmale.setSelected(true);
                }
                if (gender.equalsIgnoreCase("female")) {
                    rbfemale.setSelected(true);
                }
                txtlevel.setText(rs.getString("level"));
                txtsubject.setText(rs.getString("subject"));
                txttype.setText(rs.getString("type"));
                txtsalary.setText(rs.getString("salary"));
                txtmobile.setText(rs.getString("phone"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        setSize(690, 670);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Edit Teacher Record");

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
       // new EditTeacherTable(19);
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnupdate) {
            if (txtfname.getText().equals("") || txtlname.getText().equals("") || rbmale.isSelected() == false && rbfemale.isSelected() == false || txtqualification.getText().equals("") || txtaddress.getText().equals("") || txtlevel.getText().equals("") || txtsubject.getText().equals("") || txttype.getText().equals("") || txtsalary.getText().equals("") || txtmobile.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Incomplete Information", "Updating Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String gen = "";
                if (rbmale.isSelected()) {
                    gen = "male";
                } else if (rbfemale.isSelected()) {
                    gen = "female";
                }
                try {

                    pstmt = dbc.cn.prepareStatement("update teacher set fname=?,mname=?,lname=?,qualification=?,address=?,gender=?,level=?,subject=?,type=?,salary=?,phone=? where teacher_id=?");
                    pstmt.setString(1, txtfname.getText());
                    pstmt.setString(2, txtmname.getText());
                    pstmt.setString(3, txtlname.getText());
                    pstmt.setString(4, txtqualification.getText());
                    pstmt.setString(5, txtaddress.getText());
                    pstmt.setString(6, gen);
                    pstmt.setString(7, txtlevel.getText());
                    pstmt.setString(8, txtsubject.getText());
                    pstmt.setString(9, txttype.getText());
                    pstmt.setString(10, txtsalary.getText());
                    pstmt.setString(11, txtmobile.getText());
                    pstmt.setInt(12, Integer.parseInt(txttid.getText()));

                    result = pstmt.executeUpdate();
                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Record Updated !");
                    } else {
                        JOptionPane.showMessageDialog(null, "Record Not Updated");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
//          catch(ClassNotFoundException exx){}
                this.dispose();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == txtmobile || e.getSource() == txtsalary) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_MINUS))) {
                getToolkit().beep();
                e.consume();
            }
        }
          if (e.getSource() == txtaddress || e.getSource() == txtqualification || e.getSource() == txtsubject || e.getSource() == txttype || e.getSource() == txtlevel) {
            char c = e.getKeyChar();
            if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) )) {
                getToolkit().beep();
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtfname.getText().equals("") || txtlname.getText().equals("") || rbmale.isSelected() == false && rbfemale.isSelected() == false || txtqualification.getText().equals("") || txtaddress.getText().equals("") || txtlevel.getText().equals("") || txtsubject.getText().equals("") || txttype.getText().equals("") || txtsalary.getText().equals("") || txtmobile.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Incomplete Information");
            } else {
                String gen = "";
                if (rbmale.isSelected()) {
                    gen = "male";
                } else if (rbfemale.isSelected()) {
                    gen = "female";
                }
                try {

                    pstmt = dbc.cn.prepareStatement("update teacher set fname=?,mname=?,lname=?,qualification=?,address=?,gender=?,level=?,subject=?,type=?,salary=?,phone=? where teacher_id=?");
                    pstmt.setString(1, txtfname.getText());
                    pstmt.setString(2, txtmname.getText());
                    pstmt.setString(3, txtlname.getText());
                    pstmt.setString(4, txtqualification.getText());
                    pstmt.setString(5, txtaddress.getText());
                    pstmt.setString(6, gen);
                    pstmt.setString(7, txtlevel.getText());
                    pstmt.setString(8, txtsubject.getText());
                    pstmt.setString(9, txttype.getText());
                    pstmt.setString(10, txtsalary.getText());
                    pstmt.setString(11, txtmobile.getText());
                    pstmt.setInt(12, Integer.parseInt(txttid.getText()));

                    result = pstmt.executeUpdate();
                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Record Updated !");
                    } else {
                        JOptionPane.showMessageDialog(null, "Record Not Updated");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
//          catch(ClassNotFoundException exx){}
                this.dispose();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == txtmobile) {
            if (txtmobile.getText().length() > 9) {
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Mobile Number Error !!", JOptionPane.ERROR_MESSAGE);
                txtmobile.setText(txtmobile.getText().substring(0, 10));
            }
        }
        if (e.getSource() == txtsalary) {
            if (txtsalary.getText().length() > 5) {
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Salary Format Error !!", JOptionPane.ERROR_MESSAGE);
                txtsalary.setText(txtsalary.getText().substring(0, 6));
            }
        }

        if (e.getSource() == txtqualification) {
            if (txtqualification.getText().length() > 15) {
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Naming Error !!", JOptionPane.ERROR_MESSAGE);
                txtqualification.setText(txtqualification.getText().substring(0, 16));
            } else {
                String name = txtqualification.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());

                String newname = f.toUpperCase() + l.toLowerCase();

                txtqualification.setText(newname);
            }
        }
        if (e.getSource() == txtlevel) {
            if (txtlevel.getText().length() > 11) {
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Naming Error !!", JOptionPane.ERROR_MESSAGE);
                txtlevel.setText(txtlevel.getText().substring(0, 12));
            } else {

                String name = txtlevel.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());
                String newname = f.toUpperCase() + l.toLowerCase();
                txtlevel.setText(newname);
            }
        }

        if (e.getSource() == txtsubject) {
            if (txtsubject.getText().length() > 25) {
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Naming Error !!", JOptionPane.ERROR_MESSAGE);
                txtsubject.setText(txtsubject.getText().substring(0, 26));
            } else {
                String name = txtsubject.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());
                String newname = f.toUpperCase() + l.toLowerCase();
                txtsubject.setText(newname);
            }
        }

        if (e.getSource() == txttype) {
            if (txttype.getText().length() > 11) {
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Naming Error !!", JOptionPane.ERROR_MESSAGE);
                txttype.setText(txttype.getText().substring(0, 12));
            } else {
                String name = txttype.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());
                String newname = f.toUpperCase() + l.toLowerCase();
                txttype.setText(newname);
            }
        }

        if (e.getSource() == txtaddress) {
            if (txtaddress.getText().length() > 25) {
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Addressing Error !!", JOptionPane.ERROR_MESSAGE);
                txtaddress.setText(txtaddress.getText().substring(0, 26));
            } else {
                String name = txtaddress.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());
                String newname = f.toUpperCase() + l.toLowerCase();
                txtaddress.setText(newname);
           }}}
        
}
