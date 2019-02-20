
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountLogin extends JFrame implements ActionListener, KeyListener, MouseListener, WindowListener {

    JLabel jluser, jlpassword, jlview, jback, jimage;
    JTextField jtuser, jtshow;
    JButton jlogin, jsignup, jchange;
    JPasswordField jppass;
    DBConnection1 dbc = new DBConnection1();
    Statement stmt;
    ResultSet rs;
    public MessageDigest md;
    Font ft = new Font("Roman", Font.BOLD, 16);
    Font ft1 = new Font("Roman", Font.PLAIN, 15);

    public AccountLogin() {
//          jback=new JLabel(new ImageIcon("images/back2.png"));
//       add(jback).setBounds(8, 0, 40, 40);

        jimage = new JLabel(new ImageIcon("images/examlogin2.png"));
        add(jimage).setBounds(8, 40, 250, 250);
       // jlview.addMouseListener(this);

        jluser = new JLabel("User Name");
        add(jluser).setBounds(270, 60, 120, 30);
        jluser.setForeground(Color.BLUE);
        jluser.setFont(ft);
        jluser.addMouseListener(this);

        jtuser = new JTextField("Account Section");
        add(jtuser).setBounds(367, 60, 170, 37);
        jtuser.setFont(ft);
        jtuser.setEditable(false);
        jtuser.addMouseListener(this);
        jtuser.addKeyListener(this);

        jlpassword = new JLabel("Password");
        add(jlpassword).setBounds(270, 115, 90, 30);
        jlpassword.setForeground(Color.BLUE);
        jlpassword.addMouseListener(this);
        jlpassword.setFont(ft);

        jppass = new JPasswordField("Enter Password");
        add(jppass).setBounds(367, 115, 170, 37);
        jppass.setFont(ft1);
        jppass.addKeyListener(this);

        jppass.setEchoChar((char) 0);
        jppass.addMouseListener(this);

        jlview = new JLabel(new ImageIcon("images/eye.png"));
        add(jlview).setBounds(536, 115, 40, 35);
        jlview.addMouseListener(this);

        jlogin = new JButton("Log  In");
        add(jlogin).setBounds(367, 175, 95, 39);
        jlogin.setFont(ft);
        jlogin.setBackground(Color.BLUE);
        jlogin.setForeground(Color.WHITE);
        jlogin.addActionListener(this);

        jchange = new JButton("Change Password", new ImageIcon("images/changepassword.png"));
        add(jchange).setBounds(310, 230, 220, 39);
        jchange.setFont(ft);
        jchange.setBackground(Color.RED);
        jchange.setForeground(Color.WHITE);
        jchange.addActionListener(this);

        addWindowListener(this);
        setLayout(null);
        setSize(585, 370);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setTitle("Apple Academy--Account Login");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new AccountLogin();
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

    //////////////////////Account Login Section////////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jlogin) {
            String pass = null;
            try {
                stmt = dbc.cn.createStatement();
                rs = stmt.executeQuery("select * from login");
                while (rs.next()) {
                    pass = rs.getString("account");
                }
            } catch (Exception ex) {
            }

            if (((passen(jppass.getText()).equals(pass)))) {
                new MainAccount();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password !!", "Login Failed", JOptionPane.ERROR_MESSAGE);
                jtuser.setText("Account Section");
                jtuser.setFont(new Font("Roman", Font.BOLD, 16));
                jppass.setText("Enter Password");
                jppass.setEchoChar((char) 0);

            }
        }

        if (e.getSource() == jchange) {
            new ChangeAccount();

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    ////////////////////////////////Login using ENTER key///////////////////////////////////////
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == jtuser || e.getSource() == jppass) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                String pass = null;
                try {
                    stmt = dbc.cn.createStatement();
                    rs = stmt.executeQuery("select * from login");
                    while (rs.next()) {
                        pass = rs.getString("account");
                    }
                } catch (Exception ex) {
                }

                if (((passen(jppass.getText()).equals(pass)))) {
                    new MainAccount();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password !!", "Login Failed", JOptionPane.ERROR_MESSAGE);
                    jtuser.setText("Account Section ");
                    jtuser.setFont(new Font("Roman", Font.BOLD, 16));
                    jppass.setText("Enter Password");
                    jppass.setEchoChar((char) 0);

                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == jppass) {
            if (jppass.getText().length() > 18) {
                jppass.setText(jppass.getText().substring(0, 18));
                JOptionPane.showMessageDialog(null, "Maximum Characters Reached", "Password Error !!", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == jlpassword) {
            jppass.requestFocus();
            jppass.setText("");
        }

        if (e.getSource() == jppass) {
            jppass.setText("");
            jppass.setEchoChar('*');
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == jlview) {
            jppass.setText(jppass.getText());
            jppass.setEchoChar((char) 0);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == jlview) {
            jppass.setText(jppass.getText());
            jppass.setEchoChar('*');
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == jlogin) {
            jlogin.setForeground(Color.BLACK);
            jlogin.setBackground(Color.YELLOW);
        }
        if (e.getSource() == jchange) {
            jchange.setForeground(Color.BLACK);
            jchange.setBackground(Color.YELLOW);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getSource() == jlogin) {
            jlogin.setForeground(Color.WHITE);
            jlogin.setBackground(Color.RED);
        }
        if (e.getSource() == jchange) {
            jchange.setForeground(Color.WHITE);
            jchange.setBackground(Color.RED);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (e.getWindow() == this) {
//           String ObjButtons[]={"Yes","No"};
//        int PromptResult=JOptionPane.showOptionDialog(null, "Are you sure you want to exit the program?","Exit Confirmation",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,ObjButtons,ObjButtons[1]);
//        if(PromptResult==JOptionPane.YES_OPTION){
//        //System.exit(0);
            this.dispose();
            new StartPage();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    //////////////////////////////code for password encryption////////////////////////
    public String encryptPassword(String pass) {
        MessageDigest md;
        StringBuffer sb = null;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            sb = new StringBuffer();
            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
        } catch (Exception ex) {
        }
        return sb.toString();
    }
}
