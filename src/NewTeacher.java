
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class NewTeacher extends JFrame implements ActionListener, KeyListener {

    JLabel jltrec, jlapplelogo, jltid, jlfname, jllname, jlqualification, jlgender, jlmname, jladdress, jllevel, jlsalary, jlsubject, jlmobile, jltype;
    JTextField txttid, txtfname, txtqualification, txtlname, txtmname, txtaddress, txtsalary, txtmobile, txtsubject;
    JButton btnsave, btnreset;
    JComboBox  txttype, txtlevel;
    JRadioButton rbmale, rbfemale;
    ButtonGroup bg;
    PreparedStatement pstmt;
    int result;
    ResultSet rs;
    DBConnection1 dbc = new DBConnection1();
    JPanel pan = new JPanel();

    public NewTeacher() {
        add(pan);
        pan.setLayout(null);
        pan.setBackground(Color.WHITE);
        Font ft2 = new Font("", Font.BOLD, 19);
        Font ft = new Font("", Font.BOLD, 15);
        Font ft1 = new Font("", Font.PLAIN, 15);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pan.add(jlapplelogo);
        jlapplelogo.setBounds(200, 5, 560, 124);

        jltrec = new JLabel(new ImageIcon("images/newt.png"));
        pan.add(jltrec);
        jltrec.setBounds(0, 155, 960, 33);

        jltid = new JLabel("Teacher ID");
        pan.add(jltid);
        jltid.setBounds(50, 218, 80, 25);
        jltid.setFont(ft);

        txttid = new JTextField();
        pan.add(txttid);
        txttid.setBounds(165, 218, 160, 30);
        txttid.setEnabled(false);

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

        jlqualification = new JLabel("Qualification");
        pan.add(jlqualification);
        jlqualification.setBounds(50, 311, 100, 25);
        jlqualification.setFont(ft);

        txtqualification = new JTextField();
        pan.add(txtqualification);
        txtqualification.setBounds(165, 311, 160, 30);
        txtqualification.setFont(ft1);
        txtqualification.addKeyListener(this);

        jladdress = new JLabel("Address");
        pan.add(jladdress);
        jladdress.setBounds(50, 356, 80, 25);
        jladdress.setFont(ft);

        txtaddress = new JTextField();
        pan.add(txtaddress);
        txtaddress.setBounds(165, 356, 160, 30);
        txtaddress.setFont(ft1);
        txtaddress.addKeyListener(this);

        jlgender = new JLabel("Gender:");
        pan.add(jlgender);
        jlgender.setBounds(355, 356, 100, 25);
        jlgender.setFont(ft);

        rbmale = new JRadioButton("Male");
        pan.add(rbmale);
        rbmale.setBounds(460, 356, 60, 25);
        rbmale.setFont(ft);
        rbmale.addKeyListener(this);

        rbfemale = new JRadioButton("Female");
        pan.add(rbfemale);
        rbfemale.setBounds(540, 356, 80, 25);
        rbfemale.setFont(ft);
        rbfemale.addKeyListener(this);

        jlsubject = new JLabel("Subject");
        pan.add(jlsubject);
        jlsubject.setBounds(50, 401, 80, 25);
        jlsubject.setFont(ft);

        txtsubject = new JTextField();
        pan.add(txtsubject);
        txtsubject.setBounds(165, 401, 160, 30);
        txtsubject.setFont(ft1);
        txtsubject.addKeyListener(this);

//
        jllevel = new JLabel("Level");
        pan.add(jllevel);
        jllevel.setBounds(50, 446, 80, 25);
        jllevel.setFont(ft);

        txtlevel = new JComboBox();
        pan.add(txtlevel);
        txtlevel.setBounds(165, 446, 160, 30);
          txtlevel.addItem("");
        txtlevel.addItem("Pre-Primary");
        txtlevel.addItem("Primary");
        txtlevel.addItem("Lower Secondary");
         txtlevel.addItem("Secondary");
        txtlevel.setFont(ft1);
        txtlevel.addKeyListener(this);
        txtlevel.addActionListener(this);

        bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        jltype = new JLabel("Job Type");
        pan.add(jltype);
        jltype.setBounds(50, 491, 90, 25);
        jltype.setFont(ft);

        txttype = new JComboBox();
        pan.add(txttype);
        txttype.setBounds(165, 491, 160, 30);
          txttype.addItem("");
        txttype.addItem("Full Time");
        txttype.addItem("Part Time");
        txttype.setFont(ft1);
        txttype.addKeyListener(this);
        txttype.addActionListener(this);

        jlsalary = new JLabel("Salary");
        pan.add(jlsalary);
        jlsalary.setBounds(50, 536, 100, 25);
        jlsalary.setFont(ft);

        txtsalary = new JTextField();
        pan.add(txtsalary);
        txtsalary.setBounds(165, 536, 160, 30);
        txtsalary.setFont(ft1);
        txtsalary.addKeyListener(this);

        jlmobile = new JLabel("Mobile Number");
        pan.add(jlmobile);
        jlmobile.setBounds(50, 581, 150, 25);
        jlmobile.setFont(ft);

        txtmobile = new JTextField();
        pan.add(txtmobile);
        txtmobile.setBounds(165, 581, 160, 30);
        txtmobile.setFont(ft1);
        txtmobile.addKeyListener(this);

        btnsave = new JButton("Submit", new ImageIcon("images/save.png"));
        pan.add(btnsave);
        btnsave.setBackground(Color.WHITE);
        btnsave.setForeground(Color.BLUE);
        btnsave.setBounds(630, 600, 130, 30);
        btnsave.setFont(ft2);
        btnsave.addActionListener(this);
        btnsave.addKeyListener(this);

        btnreset = new JButton("Reset", new ImageIcon("images/refresh.png"));
        pan.add(btnreset);
        btnreset.setBounds(780, 600, 130, 30);
        btnreset.setBackground(Color.WHITE);
        btnreset.setForeground(Color.BLUE);
        btnreset.setFont(ft2);
        btnreset.addActionListener(this);
        btnreset.addKeyListener(this);

        setSize(960, 670);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Teacher Record");

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new NewTeacher();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnsave) {

            if (txtfname.getText().equals("") || txtlname.getText().equals("") || rbmale.isSelected() == false && rbfemale.isSelected() == false || txtqualification.getText().equals("") || txtaddress.getText().equals("") || txtlevel.getSelectedItem()=="" || txtsubject.getText().equals("") || txttype.getSelectedItem()=="" || txtsalary.getText().equals("") || txtmobile.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Incomplete Information", "Record Saving Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String gen = "";
                if (rbmale.isSelected()) {
                    gen = "male";
                } else if (rbfemale.isSelected()) {
                    gen = "female";
                }
                try {

                    pstmt = dbc.cn.prepareStatement("insert into teacher (fname,mname,lname,qualification,address,gender,level,subject,type,salary,phone) values(?,?,?,?,?,?,?,?,?,?,?)");
                    pstmt.setString(1, txtfname.getText());
                    pstmt.setString(2, txtmname.getText());
                    pstmt.setString(3, txtlname.getText());
                    pstmt.setString(4, txtqualification.getText());
                    pstmt.setString(5, txtaddress.getText());
                    pstmt.setString(6, gen);
                    pstmt.setString(7, txtlevel.getSelectedItem().toString());
                    pstmt.setString(8, txtsubject.getText());
                    pstmt.setString(9, txttype.getSelectedItem().toString());
                    pstmt.setString(10, txtsalary.getText());
                    pstmt.setString(11, txtmobile.getText());

                    result = pstmt.executeUpdate();
                    if (result > 0) {
                        try{
                             pstmt = dbc.cn.prepareStatement("select teacher_id  from teacher where fname=? and lname=?");
                    pstmt.setString(1,txtfname.getText());
                     pstmt.setString(2,txtlname.getText());
                    rs = pstmt.executeQuery();
                    if(rs.next()){
                        int id=Integer.parseInt(rs.getString("teacher_id"));
                     JOptionPane.showMessageDialog(null, "Teacher Added.\n Respective Teacher ID is: " + id,"New Teacher Admitted",JOptionPane.INFORMATION_MESSAGE);
                    }
                        }catch(SQLException ee){}
                    } 
                    else {
                        JOptionPane.showMessageDialog(null, "Record not saved");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
//          catch(ClassNotFoundException exx){}
                this.dispose();
            }
        }
        if (e.getSource() == btnreset) {

            txtfname.setText("");
            txtlname.setText("");
            txtmname.setText("");
            rbmale.getSelectedIcon();
            rbfemale.getSelectedIcon();
            txtqualification.setText("");
            txtaddress.setText("");
            txtlevel.setSelectedItem("");
            txtsubject.setText("");
            txttype.setSelectedItem("");
            txtsalary.setText("");
            txtmobile.setText("");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == txtmobile) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_MINUS))) {
                getToolkit().beep();
                e.consume();
            }
        }

        if (e.getSource() == txtsalary) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_MINUS) || (c == KeyEvent.VK_COMMA))) {
                getToolkit().beep();
                e.consume();
            }
        }
        if (e.getSource() == txtfname || e.getSource() == txtmname || e.getSource() == txtlname || e.getSource() == txtqualification || e.getSource() == txtaddress || e.getSource() == txtsubject) {
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

            if (txtfname.getText().equals("") || txtlname.getText().equals("") || txtqualification.getText().equals("") || txtaddress.getText().equals("") || rbmale.isSelected() == false && rbfemale.isSelected() == false || txtlevel.getSelectedItem()=="" || txtsubject.getText().equals("") || txttype.getSelectedItem()=="" || txtsalary.getText().equals("") || txtmobile.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Incomplete Information", "Record Saving Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String gen = "";
                if (rbmale.isSelected()) {
                    gen = "male";
                } else if (rbfemale.isSelected()) {
                    gen = "female";
                }
                try {

                    pstmt = dbc.cn.prepareStatement("insert into teacher (fname,mname,lname,qualification,address,gender,level,subject,type,salary,phone) values(?,?,?,?,?,?,?,?,?,?,?)");
                    pstmt.setString(1, txtfname.getText());
                    pstmt.setString(2, txtmname.getText());
                    pstmt.setString(3, txtlname.getText());
                    pstmt.setString(4, txtqualification.getText());
                    pstmt.setString(5, txtaddress.getText());
                    pstmt.setString(6, gen);
                    pstmt.setString(7, txtlevel.getSelectedItem().toString());
                    pstmt.setString(8, txtsubject.getText());
                    pstmt.setString(9, txttype.getSelectedItem().toString());
                    pstmt.setString(10, txtsalary.getText());
                    pstmt.setString(11, txtmobile.getText());

                    result = pstmt.executeUpdate();
                    if (result > 0) {
                        try{
                             pstmt = dbc.cn.prepareStatement("select teacher_id  from teacher where fname=? and lname=? ");
                    pstmt.setString(1,txtfname.getText());
                     pstmt.setString(2,txtlname.getText());
                    rs = pstmt.executeQuery();
                    if(rs.next()){
                        int id=Integer.parseInt(rs.getString("teacher_id"));
                     JOptionPane.showMessageDialog(null, " <html> Teacher Added.<br>Respective Teacher ID is </html> " + id,"New Teacher Admitted",JOptionPane.INFORMATION_MESSAGE);
                    }
                        }catch(SQLException ee){}
                    } else {
                        JOptionPane.showMessageDialog(null, "Record not saved");
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
            if (txtmobile.getText().length() > 10) {
                txtmobile.setText(txtmobile.getText().substring(0, 10));
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Mobile Number Error !!", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == txtsalary) {
            if (txtsalary.getText().length() > 6) {
                txtsalary.setText(txtsalary.getText().substring(0, 6));
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Salary Format Error !!", JOptionPane.ERROR_MESSAGE);

            }
        }

        if (e.getSource() == txtfname) {
            if (txtfname.getText().length() > 10) {
                txtfname.setText(txtfname.getText().substring(0, 10));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Naming Error !!", JOptionPane.ERROR_MESSAGE);

            } else {
                if (e.getSource() == txtfname) {
                    String name = txtfname.getText();
                    String f = name.substring(0, 1);
                    String l = name.substring(1, name.length());

                    String newname = f.toUpperCase() + l.toLowerCase();

                    txtfname.setText(newname);
                }
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

        if (e.getSource() == txtqualification) {
            if (txtqualification.getText().length() > 16) {
                txtqualification.setText(txtqualification.getText().substring(0, 16));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Naming Error !!", JOptionPane.ERROR_MESSAGE);

            } else {
                String name = txtqualification.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());

                String newname = f.toUpperCase() + l.toLowerCase();

                txtqualification.setText(newname);
            }
        }
       

        if (e.getSource() == txtsubject) {
            if (txtsubject.getText().length() > 26) {
                txtsubject.setText(txtsubject.getText().substring(0, 26));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Naming Error !!", JOptionPane.ERROR_MESSAGE);

            } else {
                String name = txtsubject.getText();
                String f = name.substring(0, 1);
                String l = name.substring(1, name.length());
                String newname = f.toUpperCase() + l.toLowerCase();
                txtsubject.setText(newname);
            }
        }

        if (e.getSource() == txtaddress) {
            if (txtaddress.getText().length() > 26) {
                txtaddress.setText(txtaddress.getText().substring(0, 26));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Addressing Error !!", JOptionPane.ERROR_MESSAGE);

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
