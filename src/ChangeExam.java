///////////////////////////Changing the password of the examination section////////////////////////////////////////////

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ChangeExam extends JFrame implements ActionListener, MouseListener, KeyListener {

    JLabel jlold, jlnew, jlrenew,lblBack;
    JButton jbupdate;
    JPasswordField jpold, jppass, jprenew;
    DBConnection1 dbc = new DBConnection1();
    Statement stmt;
    PreparedStatement st1;
    ResultSet rs, i;
    String newpass;
    public MessageDigest md;
    Font ft1 = new Font("", Font.PLAIN, 15);
    Font ft = new Font("", Font.BOLD, 17);
    Font ft2 = new Font("", Font.BOLD, 21);

    public ChangeExam() {
         lblBack = new JLabel(new ImageIcon("images/changepassword.png"));
        add(lblBack).setBounds(0, 0, 450, 300);
        
        jlold = new JLabel("Old Password");
        add(jlold,0).setBounds(24, 50, 160, 30);
        jlold.setFont(ft);
        jlold.setForeground(Color.BLUE);

        jpold = new JPasswordField("Enter Old Password");
        add(jpold,0).setBounds(203, 50, 200, 35);
        jpold.setFont(ft1);
        jpold.setEchoChar((char) 0);
        jpold.addMouseListener(this);
        jpold.addActionListener(this);
        jpold.addKeyListener(this);

        jlnew = new JLabel("New Password");
        add(jlnew,0).setBounds(24, 95, 150, 30);
        jlnew.setFont(ft);
        jlnew.setForeground(Color.BLUE);

        jppass = new JPasswordField("Enter New Password");
        add(jppass,0).setBounds(205, 95, 200, 35);
        jppass.setFont(ft1);
        jppass.setEchoChar((char) 0);
        jppass.addMouseListener(this);
        jppass.addActionListener(this);
        jppass.addKeyListener(this);

        jlrenew = new JLabel("Confirm New Password");
        add(jlrenew,0).setBounds(23, 145, 200, 30);
        jlrenew.setFont(ft);
        jlrenew.setForeground(Color.BLUE);

        jprenew = new JPasswordField("Re-Enter New Password");
        add(jprenew,0).setBounds(205, 145, 200, 35);
        jprenew.setFont(ft1);
        jprenew.setEchoChar((char) 0);
        jprenew.addMouseListener(this);
        jprenew.addActionListener(this);
        jprenew.addKeyListener(this);

        jbupdate = new JButton("Update",new ImageIcon("images/save.png"));
        add(jbupdate,0).setBounds(255, 205, 120, 39);
        jbupdate.setFont(ft2);
        jbupdate.setBackground(Color.WHITE);
        jbupdate.setForeground(Color.BLUE);
        jbupdate.addActionListener(this);
        jbupdate.addMouseListener(this);
        
        addKeyListener(this);
        setLayout(null);
        setSize(450, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Change Password");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new ChangeExam();
    }

     ///////////////////////////////Function for password encryption using MD5//////////////////////
    public String passen(String pass) {
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(passencrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////
    
    //////////////////////////Changing  password//////////////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbupdate || e.getSource() == jpold  || e.getSource() == jppass || e.getSource() == jprenew ) {
            try {
                stmt = dbc.cn.createStatement();
                rs = stmt.executeQuery("select * from login");
                while (rs.next()) {
                    String pass = rs.getString("exam");
                    if (passen(jpold.getText()).equals(pass) && jppass.getText().equals(jprenew.getText())) {
                        st1 = dbc.cn.prepareStatement("update login set exam=?");
                        newpass = passen(jppass.getText());
                        st1.setString(1, newpass);
                        st1.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Password Successfully Changed");
                        new ExaminationLogin();
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Confirm Password");
                        jpold.setText("Enter Old Password");
                        jpold.setEchoChar((char)0);
                        jppass.setText("Enter New Password");
                             jppass.setEchoChar((char)0);
                        jprenew.setText("Re-Enter New Password");
                             jprenew.setEchoChar((char)0);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
         if (e.getSource() == jpold) {
            if (jpold.getText().length() > 18) {
                 jpold.setText(jpold.getText().substring(0, 18));
                JOptionPane.showMessageDialog(null, "Maximum Characters Reached", "Password Error !!", JOptionPane.ERROR_MESSAGE);
               
            }
        }
           if (e.getSource() == jppass) {
            if (jppass.getText().length() > 18) {
                 jppass.setText(jppass.getText().substring(0, 18));
                JOptionPane.showMessageDialog(null, "Maximum Characters Reached", "Password Error !!", JOptionPane.ERROR_MESSAGE);
               
            }
        }
             if (e.getSource() == jprenew) {
            if (jprenew.getText().length() > 18) {
                 jprenew.setText(jprenew.getText().substring(0, 18));
                JOptionPane.showMessageDialog(null, "Maximum Characters Reached", "Password Error !!", JOptionPane.ERROR_MESSAGE);
               
            }
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jpold) {
            jpold.setText("");
            jpold.setEchoChar('*');
        }
        if (e.getSource() == jppass) {
            jppass.setText("");
            jppass.setEchoChar('*');
        }
        if (e.getSource() == jprenew) {
            jprenew.setText("");
            jprenew.setEchoChar('*');
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == jbupdate) {
            jbupdate.setForeground(Color.BLACK);
            jbupdate.setBackground(Color.YELLOW);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == jbupdate) {
            jbupdate.setForeground(Color.WHITE);
            jbupdate.setBackground(Color.BLUE);
        }
    }
}
