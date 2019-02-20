//////////////////////////////////Marks Entry Form for class 9///////////////////////////////////////

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.concurrent.TimeUnit;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Nine extends JDialog implements ActionListener, KeyListener {

    JLabel id, subjects, nepali, gradeimg, english, science, sciprac, ephprac, comprac, engprac, computer, social, cmath, eph, optmath, term, total, percentage, logo, division;
    JPanel pane;
    JComboBox cbterm, cbdiv;
    JTextField txtid, txtnep, txteng, txtscience, tsciprac, tephprac, tcomprac, tengprac, txtcomputer, txtcmath, txteph, txtoptmath, txtsocial, txttotal, txtpercent;
    //int sum,percent,div;
    JButton submit, reset;
    PreparedStatement pstmt;
    ResultSet rs;
    DBConnection1 db = new DBConnection1();

    int count;

    public Nine() {

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
        id.setBounds(40, 72, 150, 25);
        id.setForeground(Color.BLUE);
        id.setFont(ft);

        txtid = new JTextField();
        pane.add(txtid);
        txtid.setBounds(150, 72, 160, 25);
        txtid.addKeyListener(this);
        txtid.addActionListener(this);

        term = new JLabel("Terminal    ");
        pane.add(term, 0);
        term.setBounds(40, 109, 160, 25);
        term.setForeground(Color.BLUE);
        term.setFont(ft);

        cbterm = new JComboBox();
        pane.add(cbterm);
        cbterm.setBounds(150, 109, 160, 25);
        cbterm.addItem("");
        cbterm.addItem("First Terminal Examination");
        cbterm.addItem("Second Terminal Examination");
        cbterm.addItem("Third Terminal Examination");
        cbterm.addItem("Final Terminal Examination");
        cbterm.addKeyListener(this);

        subjects = new JLabel(new ImageIcon("images/sub.png"));
        pane.add(subjects);
        subjects.setBounds(0, 147, 360, 18);

        nepali = new JLabel("Nepali   ");
        pane.add(nepali, 0);
        nepali.setBounds(40, 185, 150, 25);
        nepali.setForeground(Color.BLUE);
        nepali.setFont(ft);

        txtnep = new JTextField();
        pane.add(txtnep);
        txtnep.setBounds(150, 185, 160, 25);
        txtnep.addKeyListener(this);

        english = new JLabel("English ");
        pane.add(english, 0);
        english.setBounds(40, 223, 150, 25);
        english.setForeground(Color.BLUE);
        english.setFont(ft);

        txteng = new JTextField();
        pane.add(txteng);
        txteng.setBounds(150, 223, 160, 25);
        txteng.addKeyListener(this);

        science = new JLabel("Science    ");
        pane.add(science, 0);
        science.setBounds(40, 261, 150, 25);
        science.setForeground(Color.BLUE);
        science.setFont(ft);

        txtscience = new JTextField();
        pane.add(txtscience);
        txtscience.setBounds(150, 261, 160, 25);
        txtscience.addKeyListener(this);

        cmath = new JLabel("Comp.Math    ");
        pane.add(cmath, 0);
        cmath.setBounds(40, 299, 150, 25);
        cmath.setForeground(Color.BLUE);
        cmath.setFont(ft);

        txtcmath = new JTextField();
        pane.add(txtcmath);
        txtcmath.setBounds(150, 299, 160, 25);
        txtcmath.addKeyListener(this);

        optmath = new JLabel("Opt.Math    ");
        pane.add(optmath, 0);
        optmath.setBounds(40, 337, 150, 25);
        optmath.setForeground(Color.BLUE);
        optmath.setFont(ft);

        txtoptmath = new JTextField();
        pane.add(txtoptmath);
        txtoptmath.setBounds(150, 337, 160, 25);
        txtoptmath.addKeyListener(this);

        social = new JLabel("Social Studies    ");
        pane.add(social, 0);
        social.setBounds(40, 375, 150, 25);
        social.setForeground(Color.BLUE);
        social.setFont(ft);

        txtsocial = new JTextField();
        pane.add(txtsocial);
        txtsocial.setBounds(150, 375, 160, 25);
        txtsocial.addKeyListener(this);

        computer = new JLabel("Computer    ");
        pane.add(computer, 0);
        computer.setBounds(40, 413, 150, 25);
        computer.setForeground(Color.BLUE);
        computer.setFont(ft);

        txtcomputer = new JTextField();
        pane.add(txtcomputer);
        txtcomputer.setBounds(150, 413, 160, 25);
        txtcomputer.addKeyListener(this);

        eph = new JLabel("EPH    ");
        pane.add(eph, 0);
        eph.setBounds(40, 450, 150, 25);
        eph.setForeground(Color.BLUE);
        eph.setFont(ft);

        txteph = new JTextField();
        pane.add(txteph);
        txteph.setBounds(150, 450, 160, 25);
        txteph.addKeyListener(this);

        engprac = new JLabel("English Pr.    ");
        pane.add(engprac, 0);
        engprac.setBounds(40, 486, 150, 25);
        engprac.setForeground(Color.BLUE);
        engprac.setFont(ft);

        tengprac = new JTextField();
        pane.add(tengprac);
        tengprac.setBounds(150, 486, 160, 25);
        tengprac.addKeyListener(this);

        sciprac = new JLabel("Science Pr.    ");
        pane.add(sciprac, 0);
        sciprac.setBounds(40, 525, 150, 25);
        sciprac.setForeground(Color.BLUE);
        sciprac.setFont(ft);

        tsciprac = new JTextField();
        pane.add(tsciprac);
        tsciprac.setBounds(150, 525, 160, 25);
        tsciprac.addKeyListener(this);

        ephprac = new JLabel("EPH Pr.    ");
        pane.add(ephprac, 0);
        ephprac.setBounds(40, 562, 150, 25);
        ephprac.setForeground(Color.BLUE);
        ephprac.setFont(ft);

        tephprac = new JTextField();
        pane.add(tephprac);
        tephprac.setBounds(150, 562, 160, 25);
        tephprac.addKeyListener(this);

        comprac = new JLabel("Computer Pr.    ");
        pane.add(comprac, 0);
        comprac.setBounds(40, 597, 150, 25);
        comprac.setForeground(Color.BLUE);
        comprac.setFont(ft);

        tcomprac = new JTextField();
        pane.add(tcomprac);
        tcomprac.setBounds(150, 597, 160, 25);
        tcomprac.addKeyListener(this);

         submit = new JButton("Submit",new ImageIcon("images/save.png"));
        pane.add(submit, 0);
        submit.setBounds(40, 643, 120, 28);
        submit.setForeground(Color.BLUE);
        submit.setBackground(Color.WHITE);
        submit.setFont(ft);
        submit.addActionListener(this);

       reset = new JButton("Reset",new ImageIcon("images/refresh.png"));
        pane.add(reset, 0);
        reset.setBounds(190, 643, 120, 28);
        reset.setForeground(Color.BLUE);
        reset.setBackground(Color.WHITE);
        reset.addActionListener(this);
        reset.setFont(ft);

        setDisabled();

      
        setSize(360, 710);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Class-Nine");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new Nine();
    }

    public void setEmpty() {
        txtid.setText("");
        cbterm.setSelectedItem("");
        txtnep.setText("");
        txteng.setText("");
        txtscience.setText("");
        txtcmath.setText("");
        txtoptmath.setText("");
        txtsocial.setText("");
        txtcomputer.setText("");
        txteph.setText("");
        tengprac.setText("");
        tsciprac.setText("");
        tephprac.setText("");
        tcomprac.setText("");
    }

    public void setDisabled() {
        cbterm.setEnabled(false);
        txtnep.setEnabled(false);
        txteng.setEnabled(false);
        txtscience.setEnabled(false);
        txtcmath.setEnabled(false);
        txtoptmath.setEnabled(false);
        txtsocial.setEnabled(false);
        txtcomputer.setEnabled(false);
        txteph.setEnabled(false);
        tengprac.setEnabled(false);
        tsciprac.setEnabled(false);
        tephprac.setEnabled(false);
        tcomprac.setEnabled(false);
    }

    public void setEnabled() {
        cbterm.setEnabled(true);
        txtnep.setEnabled(true);
        txteng.setEnabled(true);
        txtscience.setEnabled(true);
        txtcmath.setEnabled(true);
        txtoptmath.setEnabled(true);
        txtsocial.setEnabled(true);
        txtcomputer.setEnabled(true);
        txteph.setEnabled(true);
        tengprac.setEnabled(true);
        tsciprac.setEnabled(true);
        tephprac.setEnabled(true);
        tcomprac.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if (txtid.getText().equals("") || cbterm.getSelectedItem().equals("") || txtnep.getText().equals("") || txteng.getText().equals("") || txtscience.getText().equals("") || txtcmath.getText().equals("") || txtoptmath.getText().equals("") || txtsocial.getText().equals("") || txtcomputer.getText().equals("") || txteph.getText().equals("") || tengprac.getText().equals("") || tsciprac.getText().equals("") || tephprac.getText().equals("") || tcomprac.getText().equals("")) {
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

                    PreparedStatement pstmt = db.cn.prepareStatement("insert into nine (terminal,Compulsory_Nepali,Compulsory_English,Science,Compulsory_Mathematics,Optional_Mathematics,Social_Studies,Computer,Health_POP_ENV_EDU,English_Practical,Science_Practical,Health_POP_ENV_Practical,Computer_Practical,sid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pstmt.setString(1, term);
                    pstmt.setDouble(2, Double.parseDouble(txtnep.getText()));
                    pstmt.setDouble(3, Double.parseDouble(txteng.getText()));
                    pstmt.setDouble(4, Double.parseDouble(txtscience.getText()));
                    pstmt.setDouble(5, Double.parseDouble(txtcmath.getText()));
                    pstmt.setDouble(6, Double.parseDouble(txtoptmath.getText()));
                    pstmt.setDouble(7, Double.parseDouble(txtsocial.getText()));
                    pstmt.setDouble(8, Double.parseDouble(txtcomputer.getText()));
                    pstmt.setDouble(9, Double.parseDouble(txteph.getText()));
                    pstmt.setDouble(10, Double.parseDouble(tengprac.getText()));
                    pstmt.setDouble(11, Double.parseDouble(tsciprac.getText()));
                    pstmt.setDouble(12, Double.parseDouble(tephprac.getText()));
                    pstmt.setDouble(13, Double.parseDouble(tcomprac.getText()));

                    pstmt.setInt(14, Integer.parseInt(txtid.getText()));

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
            txtid.setEnabled(true);
            txtid.setText("");
            txtid.requestFocus();
            setDisabled();
        }

//        if(e.getSource()==txtid){
//        demo();
//        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == txteng || e.getSource() == txtid || e.getSource() == txtnep || e.getSource() == txtscience || e.getSource() == txtcmath || e.getSource() == txtoptmath || e.getSource() == txtsocial || e.getSource() == txtcomputer || e.getSource() == txteph || e.getSource() == tengprac || e.getSource() == tsciprac || e.getSource() == tephprac || e.getSource() == tcomprac) {
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

            } else {
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

            } else {
                Double dd = Double.parseDouble(txteng.getText());
               check75(dd);
            }
        }

        if (e.getSource() == txtnep) {
            if (txtnep.getText().length() > 5) {
                txtnep.setText(txtnep.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);
            }
                   else{
      Double dd=Double.parseDouble(txtnep.getText());
    check100(dd);
        }
        }

        if (e.getSource() == txtscience) {
            if (txtscience.getText().length() > 5) {
                txtscience.setText(txtscience.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
                   else{
      Double dd=Double.parseDouble(txtscience.getText());
     check75(dd);
        }
        }

        if (e.getSource() == txtsocial) {
            if (txtsocial.getText().length() > 5) {
                txtsocial.setText(txtsocial.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);
            }
                   else{
      Double dd=Double.parseDouble(txtsocial.getText());
      check100(dd);
        }
        }

        if (e.getSource() == txtoptmath) {
            if (txtoptmath.getText().length() > 5) {
                txtoptmath.setText(txtoptmath.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
                   else{
      Double dd=Double.parseDouble(txtoptmath.getText());
     check100(dd);
        }
        }

        if (e.getSource() == txtcomputer) {
            if (txtcomputer.getText().length() > 5) {
                txtcomputer.setText(txtcomputer.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
                   else{
      Double dd=Double.parseDouble(txtcomputer.getText());
    check50(dd);
        }
        }

        if (e.getSource() == txtcmath) {
            if (txtcmath.getText().length() > 5) {
                txtcmath.setText(txtcmath.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
                   else{
      Double dd=Double.parseDouble(txtcmath.getText());
     check100(dd);
        }
        }

        if (e.getSource() == tsciprac) {
            if (tsciprac.getText().length() > 5) {
                tsciprac.setText(tsciprac.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
                   else{
      Double dd=Double.parseDouble(tsciprac.getText());
      check25(dd);
        }
        }
        if (e.getSource() == txteph) {
            if (txteph.getText().length() > 5) {
                txteph.setText(txteph.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
                       else{
      Double dd=Double.parseDouble(txteph.getText());
      check75(dd);
        }
        }

        if (e.getSource() == tcomprac) {
            if (tcomprac.getText().length() > 5) {
                tcomprac.setText(tcomprac.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
                       else{
      Double dd=Double.parseDouble(tcomprac.getText());
    check50(dd);
        }
        }

        if (e.getSource() == tephprac) {
            if (tephprac.getText().length() > 5) {
                tephprac.setText(tephprac.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);
            }
           else{
      Double dd=Double.parseDouble(tephprac.getText());
     check25(dd);
        }
        }

        if (e.getSource() == tengprac) {
            if (tengprac.getText().length() > 5) {
                tengprac.setText(tengprac.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);
            }
           else{
      Double dd=Double.parseDouble(tengprac.getText());
      check25(dd);
        }
        }
    }

    public void demo() {
        try {
            int sid = Integer.parseInt(txtid.getText());
            pstmt = db.cn.prepareStatement("SELECT student_id  FROM record where student_id=? and class=?");
            pstmt.setInt(1, sid);
            pstmt.setString(2, "Nine");
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

}
