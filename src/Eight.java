///////////////////////Marks Entry Form for class 8/////////////////////////////////////

import java.awt.*;
import java.awt.Robot;
import java.awt.event.*;
import java.sql.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Eight extends JDialog implements ActionListener, KeyListener{

    JLabel id, subjects, nepali, english, english2, engprac, health, socialprac, sciprac, comprac, science, mlskills, computer, social, vocation, optmath, cmath, term, total, percentage, logo, division;
    JPanel pane;
    JComboBox cbterm, cbdiv;
    JTextField txtid, txtnep, txteng, txteng2, txtsocial, thealth, tsocialprac, tsciprac, tcomprac, tengprac, txtcomputer, txtmlskills, txtscience, txtvocation, txtcmath, txtoptmath, txttotal, txtpercent;
    //int sum,percent,div;
    JButton submit, reset;
    DBConnection1 db = new DBConnection1();
    PreparedStatement pstmt;
    ResultSet rs;
    int count;

    public Eight() {

        pane = new JPanel();
        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);
        Font ft = new Font("", Font.BOLD, 13);

        logo = new JLabel(new ImageIcon("images/applexm.png"));
        pane.add(logo);
        logo.setBounds(60, 8, 227, 50);

        id = new JLabel("Student ID   ");
        pane.add(id, 0);
        id.setBounds(40, 70, 150, 25);
        id.setForeground(Color.BLUE);
        id.setFont(ft);

        txtid = new JTextField();
        pane.add(txtid);
        txtid.setBounds(150, 70, 160, 25);
        txtid.addKeyListener(this);
       

        term = new JLabel("Terminal    ");
        pane.add(term, 0);
        term.setBounds(40, 100, 150, 25);
        term.setForeground(Color.BLUE);
        term.setFont(ft);

        cbterm = new JComboBox();
        pane.add(cbterm);
        cbterm.setBounds(150, 100, 160, 25);
        cbterm.addItem("");
        cbterm.addItem("First Terminal Examination");
        cbterm.addItem("Second Terminal Examination");
        cbterm.addItem("Third Terminal Examination");
        cbterm.addItem("Final Terminal Examination");
        cbterm.addKeyListener(this);

        subjects = new JLabel(new ImageIcon("images/sub.png"));
        pane.add(subjects);
        subjects.setBounds(0, 150, 360, 18);

        english = new JLabel("English  ");
        pane.add(english, 0);
        english.setBounds(40, 200, 150, 25);
        english.setForeground(Color.BLUE);
        english.setFont(ft);

        txteng = new JTextField();
        pane.add(txteng);
        txteng.setBounds(150, 200, 160, 25);
        txteng.addKeyListener(this);

        nepali = new JLabel("Nepali    ");
        pane.add(nepali, 0);
        nepali.setBounds(40, 230, 150, 25);
        nepali.setForeground(Color.BLUE);
        nepali.setFont(ft);

        txtnep = new JTextField();
        pane.add(txtnep);
        txtnep.setBounds(150, 230, 160, 25);
        txtnep.addKeyListener(this);

        science = new JLabel("Science    ");
        pane.add(science, 0);
        science.setBounds(40, 260, 150, 25);
        science.setForeground(Color.BLUE);
        science.setFont(ft);

        txtscience = new JTextField();
        pane.add(txtscience);
        txtscience.setBounds(150, 260, 160, 25);
        txtscience.addKeyListener(this);

        cmath = new JLabel("C.Math    ");
        pane.add(cmath, 0);
        cmath.setBounds(40, 290, 150, 25);
        cmath.setForeground(Color.BLUE);
        cmath.setFont(ft);

        txtcmath = new JTextField();
        pane.add(txtcmath);
        txtcmath.setBounds(150, 290, 160, 25);
        txtcmath.addKeyListener(this);

        social = new JLabel("Social Studies    ");
        pane.add(social, 0);
        social.setBounds(40, 320, 150, 25);
        social.setForeground(Color.BLUE);
        social.setFont(ft);

        txtsocial = new JTextField();
        pane.add(txtsocial);
        txtsocial.setBounds(150, 320, 160, 25);
        txtsocial.addKeyListener(this);

        computer = new JLabel("Computer ");
        pane.add(computer, 0);
        computer.setBounds(40, 350, 150, 25);
        computer.setForeground(Color.BLUE);
        computer.setFont(ft);

        txtcomputer = new JTextField();
        pane.add(txtcomputer);
        txtcomputer.setBounds(150, 350, 160, 25);
        txtcomputer.addKeyListener(this);

        optmath = new JLabel("Opt.Maths    ");
        pane.add(optmath, 0);
        optmath.setBounds(40, 380, 150, 25);
        optmath.setForeground(Color.BLUE);
        optmath.setFont(ft);

        txtoptmath = new JTextField();
        pane.add(txtoptmath);
        txtoptmath.setBounds(150, 380, 160, 25);
        txtoptmath.addKeyListener(this);

        vocation = new JLabel("Vocation & Occu. ");
        pane.add(vocation, 0);
        vocation.setBounds(40, 410, 150, 25);
        vocation.setForeground(Color.BLUE);
        vocation.setFont(ft);

        txtvocation = new JTextField();
        pane.add(txtvocation);
        txtvocation.setBounds(150, 410, 160, 25);
        txtvocation.addKeyListener(this);

        health = new JLabel("Health    ");
        pane.add(health, 0);
        health.setBounds(40, 440, 150, 25);
        health.setForeground(Color.BLUE);
        health.setFont(ft);

        thealth = new JTextField();
        pane.add(thealth);
        thealth.setBounds(150, 440, 160, 25);
        thealth.addKeyListener(this);

        engprac = new JLabel("English Pr.    ");
        pane.add(engprac, 0);
        engprac.setBounds(40, 470, 150, 25);
        engprac.setForeground(Color.BLUE);
        engprac.setFont(ft);

        tengprac = new JTextField();
        pane.add(tengprac);
        tengprac.setBounds(150, 470, 160, 25);

        sciprac = new JLabel("Science Pr.    ");
        pane.add(sciprac, 0);
        sciprac.setBounds(40, 500, 150, 25);
        sciprac.setForeground(Color.BLUE);
        sciprac.setFont(ft);

        tsciprac = new JTextField();
        pane.add(tsciprac);
        tsciprac.setBounds(150, 500, 160, 25);
        tsciprac.addKeyListener(this);

        socialprac = new JLabel("Social Pr.    ");
        pane.add(socialprac, 0);
        socialprac.setBounds(40, 530, 150, 25);
        socialprac.setForeground(Color.BLUE);
        socialprac.setFont(ft);

        tsocialprac = new JTextField();
        pane.add(tsocialprac);
        tsocialprac.setBounds(150, 530, 160, 25);
        tsocialprac.addKeyListener(this);

        comprac = new JLabel("Computer Pr.    ");
        pane.add(comprac, 0);
        comprac.setBounds(40, 560, 150, 25);
        comprac.setForeground(Color.BLUE);
        comprac.setFont(ft);

        tcomprac = new JTextField();
        pane.add(tcomprac);
        tcomprac.setBounds(150, 560, 160, 25);
        tcomprac.addKeyListener(this);

         submit = new JButton("Submit",new ImageIcon("images/save.png"));
        pane.add(submit, 0);
        submit.setBounds(40, 607, 120, 28);
        submit.setForeground(Color.BLUE);
        submit.setBackground(Color.WHITE);
        submit.setFont(ft);
        submit.addActionListener(this);

         reset = new JButton("Reset",new ImageIcon("images/refresh.png"));
        pane.add(reset, 0);
        reset.setBounds(190, 607, 120, 28);
        reset.setForeground(Color.BLUE);
        reset.setBackground(Color.WHITE);
        reset.addActionListener(this);
        reset.setFont(ft);

        setDisabled();
        setSize(360, 680);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Class-Eight");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new Eight();
    }

    public void setEmpty() {
        txteng.setText("");
        txtnep.setText("");
        txtscience.setText("");
        cbterm.setSelectedItem("");
        txtcmath.setText("");
        txtsocial.setText("");
        txtcomputer.setText("");
        txtoptmath.setText("");
        thealth.setText("");
        txtvocation.setText("");
        tengprac.setText("");
        tsciprac.setText("");
        tsocialprac.setText("");
        tcomprac.setText("");
        txtid.setText("");
    }

    public void setDisabled() {
        cbterm.setEnabled(false);
        txteng.setEnabled(false);
        txtnep.setEnabled(false);
        txtscience.setEnabled(false);
        txtcmath.setEnabled(false);
        txtsocial.setEnabled(false);
        txtcomputer.setEnabled(false);
        txtoptmath.setEnabled(false);
        thealth.setEnabled(false);
        txtvocation.setEnabled(false);
        tengprac.setEnabled(false);
        tsciprac.setEnabled(false);
        tsocialprac.setEnabled(false);
        tcomprac.setEnabled(false);

    }

    public void setEnabled() {
        txteng.setEnabled(true);
        txtnep.setEnabled(true);
        txtscience.setEnabled(true);
        txtcmath.setEnabled(true);
        txtsocial.setEnabled(true);
        txtcomputer.setEnabled(true);
        txtoptmath.setEnabled(true);
        thealth.setEnabled(true);
        txtvocation.setEnabled(true);
        tengprac.setEnabled(true);
        tsciprac.setEnabled(true);
        tsocialprac.setEnabled(true);
        tcomprac.setEnabled(true);
        cbterm.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if (txtid.getText().equals("") || cbterm.getSelectedItem().equals("") || txtnep.getText().equals("") || txteng.getText().equals("") || txtscience.getText().equals("") || txtcmath.getText().equals("") || txtoptmath.getText().equals("") || txtsocial.getText().equals("") || txtcomputer.getText().equals("") || txtvocation.getText().equals("") || tengprac.getText().equals("") || tsciprac.getText().equals("") || tsocialprac.getText().equals("") || tcomprac.getText().equals("") || thealth.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Incomplete Data", "Insertion Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String term = "";
                if (cbterm.getSelectedItem() == "First Terminal Examination") {
                    term = "First Terminal Examination";
                } else if (cbterm.getSelectedItem() == "Second Terminal Examination") {
                    term = "Second Terminal Examination";
                } else if (cbterm.getSelectedItem() == "Third Terminal Examination") {
                    term = "Third Terminal Examination";
                } else {
                    term = "Final Terminal Examination";
                }

                try {

                    PreparedStatement pstmt = db.cn.prepareStatement("insert into eight (terminal,Compulsory_English,Compulsory_Nepali,Science,Compulsory_Mathematics,Social_Studies,Computer,Optional_Mathematics,Vocation_and_Occupation,Health,English_Practical,Science_Practical,Social_Practical,Computer_Practical,sid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pstmt.setString(1, term);
                    pstmt.setDouble(2, Double.parseDouble(txteng.getText()));
                    pstmt.setDouble(3, Double.parseDouble(txtnep.getText()));
                    pstmt.setDouble(4, Double.parseDouble(txtscience.getText()));
                    pstmt.setDouble(5, Double.parseDouble(txtcmath.getText()));
                    pstmt.setDouble(6, Double.parseDouble(txtsocial.getText()));
                    pstmt.setDouble(7, Double.parseDouble(txtcomputer.getText()));
                    pstmt.setDouble(8, Double.parseDouble(txtoptmath.getText()));
                    pstmt.setDouble(9, Double.parseDouble(txtvocation.getText()));
                    pstmt.setDouble(10, Double.parseDouble(thealth.getText()));
                    pstmt.setDouble(11, Double.parseDouble(tengprac.getText()));
                    pstmt.setDouble(12, Double.parseDouble(tsciprac.getText()));
                    pstmt.setDouble(13, Double.parseDouble(tsocialprac.getText()));
                    pstmt.setDouble(14, Double.parseDouble(tcomprac.getText()));
                    pstmt.setInt(15, Integer.parseInt(txtid.getText()));

                    int ch = pstmt.executeUpdate();

                    if (ch > 0) {
                        JOptionPane.showMessageDialog(null, "Marks has been added","Marks Entry",JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Marks not added","Marks Entry",JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                setEmpty();
                txtid.setEnabled(true);
                txtid.requestFocus();
                setDisabled();
            }
        }

        if (e.getSource() == reset) {
            setEmpty();
            txtid.setEnabled(true);
            txtid.requestFocus();
            setDisabled();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == txteng || e.getSource() == txtid || e.getSource() == txtnep || e.getSource() == txtscience || e.getSource() == txtcmath || e.getSource() == txtoptmath || e.getSource() == txtsocial || e.getSource() == txtcomputer || e.getSource() == txtvocation || e.getSource() == thealth || e.getSource() == tengprac || e.getSource() == tsciprac || e.getSource() == tsocialprac || e.getSource() == tcomprac) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == '.') || (c == KeyEvent.VK_ENTER))) {
                getToolkit().beep();
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == txtid) {
            if (txtid.getText().length() > 5) {
                txtid.setText(txtid.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "ID Format Error !!", JOptionPane.ERROR_MESSAGE);
            }
            else {
                Thread th = new Thread() {
                    public void run() {
                        count = 0;
                        for (int i = 1; i <= 2; i++) {
                            try {
                                TimeUnit.MILLISECONDS.sleep(1000);
                            } catch (Exception e) {
                            }
                            count = count + 1;
                            if (count == 2) {
                                demo();
                            }
                        }
                    }
                };
                th.start();
        }
        }
        if (e.getSource() == txteng) {
            if (txteng.getText().length() > 5) {
                txteng.setText(txteng.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
            else {
                Double dd = Double.parseDouble(txteng.getText());
               check75(dd);
            }
        }

        if (e.getSource() == txtnep) {
            if (txtnep.getText().length() > 5) {
                txtnep.setText(txtnep.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
            else {
                Double dd = Double.parseDouble(txtnep.getText());
               check100(dd);
            }
        }

        if (e.getSource() == txtscience) {
            if (txtscience.getText().length() > 5) {
                txtscience.setText(txtscience.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
        }

        if (e.getSource() == txtsocial) {
            if (txtsocial.getText().length() > 5) {
                txtsocial.setText(txtsocial.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
            else {
                Double dd = Double.parseDouble(txtsocial.getText());
               check75(dd);
            }
        }

        if (e.getSource() == txtoptmath) {
            if (txtoptmath.getText().length() > 5) {
                txtoptmath.setText(txtoptmath.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
            else {
                Double dd = Double.parseDouble(txtoptmath.getText());
               check100(dd);
            }
        }

        if (e.getSource() == txtcomputer) {
            if (txtcomputer.getText().length() > 5) {
                txtcomputer.setText(txtcomputer.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }else {
                Double dd = Double.parseDouble(txtcomputer.getText());
               check50(dd);
            }
        }

        if (e.getSource() == tsciprac) {
            if (tsciprac.getText().length() > 5) {
                tsciprac.setText(tsciprac.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
            else {
                Double dd = Double.parseDouble(tsciprac.getText());
               check25(dd);
            }
        }
        if (e.getSource() == tsocialprac) {
            if (tsocialprac.getText().length() > 5) {
                tsocialprac.setText(tsocialprac.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
            else {
                Double dd = Double.parseDouble(tsocialprac.getText());
               check25(dd);
            }
        }

        if (e.getSource() == tcomprac) {
            if (tcomprac.getText().length() > 5) {
                tcomprac.setText(tcomprac.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
            else {
                Double dd = Double.parseDouble(tcomprac.getText());
               check50(dd);
            }
        }
        if (e.getSource() == txtcmath) {
            if (txtcmath.getText().length() > 5) {
                txtcmath.setText(txtcmath.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
            else {
                Double dd = Double.parseDouble(txtcmath.getText());
               check100(dd);
            }
        }

        if (e.getSource() == thealth) {
            if (thealth.getText().length() > 5) {
                thealth.setText(thealth.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
        else {
                Double dd = Double.parseDouble(thealth.getText());
               check50(dd);
            }

        }
        if (e.getSource() == txtvocation) {
            if (txtvocation.getText().length() > 5) {
                txtvocation.setText(txtvocation.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }else {
                Double dd = Double.parseDouble(txtvocation.getText());
               check50(dd);
            }
        }
        if (e.getSource() == tengprac) {
            if (tengprac.getText().length() > 5) {
                tengprac.setText(tengprac.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
else {
                Double dd = Double.parseDouble(tengprac.getText());
               check25(dd);
            }
        }
    }
       public void check100(Double xx){
    if(xx>100.0){
      JOptionPane.showMessageDialog(null, "Mark is greater than 100 !!", "Marks Entry Error", JOptionPane.ERROR_MESSAGE);
                    //e.consume();
                    try {
                        Robot robot = new Robot();
                        robot.keyPress(KeyEvent.VK_BACK_SPACE);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
    }
    
    public void check75(Double yy){
     if(yy>75.0){
      JOptionPane.showMessageDialog(null, "Mark is greater than 75 !!", "Marks Entry Error", JOptionPane.ERROR_MESSAGE);
                    //e.consume();
                    try {
                        Robot robot = new Robot();
                        robot.keyPress(KeyEvent.VK_BACK_SPACE);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
    }
    
      public void check25(Double yy){
     if(yy>25.0){
      JOptionPane.showMessageDialog(null, "Mark is greater than 25 !!", "Marks Entry Error", JOptionPane.ERROR_MESSAGE);
                    //e.consume();
                    try {
                        Robot robot = new Robot();
                        robot.keyPress(KeyEvent.VK_BACK_SPACE);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
    }
       public void check50(Double yy){
     if(yy>50.0){
      JOptionPane.showMessageDialog(null, "Mark is greater than 50 !!", "Marks Entry Error", JOptionPane.ERROR_MESSAGE);
                    //e.consume();
                    try {
                        Robot robot = new Robot();
                        robot.keyPress(KeyEvent.VK_BACK_SPACE);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
    }
       
         public void demo() {
        try {
            int sid = Integer.parseInt(txtid.getText());
            pstmt = db.cn.prepareStatement("SELECT student_id  FROM record where student_id=? and class=?");
            pstmt.setInt(1, sid);
            pstmt.setString(2, "Eight");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                txtid.setEnabled(false);
                setEnabled();
                cbterm.requestFocus();

            } else {
                txtid.requestFocus();
                JOptionPane.showMessageDialog(null, " Please Enter Valid Student ID!!", "Non Existed ID", JOptionPane.ERROR_MESSAGE);

            }
        } catch (Exception p) {
        }
    }
}


