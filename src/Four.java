////////////////////////Marks Entry Form for class 4//////////////////////////////////

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class Four extends JDialog implements ActionListener, KeyListener{

    JLabel id, subjects, gradeimg, nepali, english1, sciprac, socialprac, draw, dictation, moral, moralprac, comprac, eng1prac, eng2prac, english2, science, computer, social, gk, drawingdiet, math, term, total, percentage, logo, division;
    JPanel pane;
    JComboBox cbterm, cbdiv;
    JTextField txtid, txtnep, txteng1, txteng2, txtsocial, tgk, tsciprac, tmoral, txtdraw, txtdictation, tsocialprac, tgkprac, tmoralprac, tcomprac, teng1prac, teng2prac, txtcomputer, txtscience, txtdrawingdiet, txtmath, txttotal, txtpercent;
    //int sum,percent,div;
    PreparedStatement pstmt;
    ResultSet rs;
    JButton submit, reset;
    DBConnection1 db = new DBConnection1();
    int count;

    public Four() {

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
        subjects.setBounds(0, 140, 360, 18);

        english1 = new JLabel("English-I   ");
        pane.add(english1, 0);
        english1.setBounds(40, 170, 150, 25);
        english1.setForeground(Color.BLUE);
        english1.setFont(ft);

        txteng1 = new JTextField();
        pane.add(txteng1);
        txteng1.setBounds(150, 170, 160, 25);
        txteng1.addKeyListener(this);

        english2 = new JLabel("English-II ");
        pane.add(english2, 0);
        english2.setBounds(40, 200, 150, 25);
        english2.setForeground(Color.BLUE);
        english2.setFont(ft);

        txteng2 = new JTextField();
        pane.add(txteng2);
        txteng2.setBounds(150, 200, 160, 25);
        txteng2.addKeyListener(this);

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

        math = new JLabel("Maths    ");
        pane.add(math, 0);
        math.setBounds(40, 290, 150, 25);
        math.setForeground(Color.BLUE);
        math.setFont(ft);

        txtmath = new JTextField();
        pane.add(txtmath);
        txtmath.setBounds(150, 290, 160, 25);
        txtmath.addKeyListener(this);

        social = new JLabel("Social   ");
        pane.add(social, 0);
        social.setBounds(40, 320, 150, 25);
        social.setForeground(Color.BLUE);
        social.setFont(ft);

        txtsocial = new JTextField();
        pane.add(txtsocial);
        txtsocial.setBounds(150, 320, 160, 25);
        txtsocial.addKeyListener(this);

        computer = new JLabel("Computer   ");
        pane.add(computer, 0);
        computer.setBounds(40, 350, 150, 25);
        computer.setForeground(Color.BLUE);
        computer.setFont(ft);

        txtcomputer = new JTextField();
        pane.add(txtcomputer);
        txtcomputer.setBounds(150, 350, 160, 25);
        txtcomputer.addKeyListener(this);

        gk = new JLabel("G.K   ");
        pane.add(gk, 0);
        gk.setBounds(40, 380, 150, 25);
        gk.setForeground(Color.BLUE);
        gk.setFont(ft);

        tgk = new JTextField();
        pane.add(tgk);
        tgk.setBounds(150, 380, 160, 25);
        tgk.addKeyListener(this);

        moral = new JLabel("Moral    ");
        pane.add(moral, 0);
        moral.setBounds(40, 410, 150, 25);
        moral.setForeground(Color.BLUE);
        moral.setFont(ft);

        tmoral = new JTextField();
        pane.add(tmoral);
        tmoral.setBounds(150, 410, 160, 25);
        tmoral.addKeyListener(this);

        eng1prac = new JLabel("English-I Pr.    ");
        pane.add(eng1prac, 0);
        eng1prac.setBounds(40, 440, 150, 25);
        eng1prac.setForeground(Color.BLUE);
        eng1prac.setFont(ft);

        teng1prac = new JTextField();
        pane.add(teng1prac);
        teng1prac.setBounds(150, 440, 160, 25);
        teng1prac.addKeyListener(this);

        eng2prac = new JLabel("English-II Pr.    ");
        pane.add(eng2prac, 0);
        eng2prac.setBounds(40, 470, 150, 25);
        eng2prac.setForeground(Color.BLUE);
        eng2prac.setFont(ft);

        teng2prac = new JTextField();
        pane.add(teng2prac);
        teng2prac.setBounds(150, 470, 160, 25);
        teng2prac.addKeyListener(this);

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

        draw = new JLabel("Drawing  ");
        pane.add(draw, 0);
        draw.setBounds(40, 590, 150, 25);
        draw.setForeground(Color.BLUE);
        draw.setFont(ft);

        txtdraw = new JTextField();
        pane.add(txtdraw);
        txtdraw.setBounds(150, 590, 160, 25);
        txtdraw.addKeyListener(this);

        dictation = new JLabel("Dictation  ");
        pane.add(dictation, 0);
        dictation.setBounds(40, 620, 150, 25);
        dictation.setForeground(Color.BLUE);
        dictation.setFont(ft);

        txtdictation = new JTextField();
        pane.add(txtdictation);
        txtdictation.setBounds(150, 620, 160, 25);
        txtdictation.addKeyListener(this);

         submit = new JButton("Submit",new ImageIcon("images/save.png"));
        pane.add(submit, 0);
        submit.setBounds(40, 660, 120, 28);
        submit.setForeground(Color.BLUE);
        submit.setBackground(Color.WHITE);
        submit.setFont(ft);
        submit.addActionListener(this);


      reset = new JButton("Reset",new ImageIcon("images/refresh.png"));
        pane.add(reset, 0);
        reset.setBounds(190, 660, 120, 28);
        reset.setForeground(Color.BLUE);
        reset.setBackground(Color.WHITE);
        reset.addActionListener(this);
        reset.setFont(ft);
 
        setDisabled();
        setSize(360, 745);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Class-Four");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new Four();
    }

      public void setEmpty() {
        txteng1.setText("");
        txteng2.setText("");
        txtnep.setText("");
        txtdraw.setText("");
        txtdictation.setText("");
        txtscience.setText("");
        cbterm.setSelectedItem("");
        txtmath.setText("");
        txtsocial.setText("");
        txtcomputer.setText("");
        tgk.setText("");
        tmoral.setText("");
        teng1prac.setText("");
        teng2prac.setText("");
        tsciprac.setText("");
        tsocialprac.setText("");
        tcomprac.setText("");
        txtid.setText("");
    }

    public void setDisabled() {
        txteng1.setEnabled(false);
        txteng2.setEnabled(false);
        txtnep.setEnabled(false);
        txtdraw.setEnabled(false);
        txtdictation.setEnabled(false);
        txtscience.setEnabled(false);
        cbterm.setEnabled(false);
        txtmath.setEnabled(false);
        txtsocial.setEnabled(false);
        txtcomputer.setEnabled(false);
        tgk.setEnabled(false);
        tmoral.setEnabled(false);
        teng1prac.setEnabled(false);
        teng2prac.setEnabled(false);
        tsciprac.setEnabled(false);
        tsocialprac.setEnabled(false);
        tcomprac.setEnabled(false);

    }

    public void setEnabled() {
        txteng1.setEnabled(true);
        txteng2.setEnabled(true);
        txtnep.setEnabled(true);
        txtdraw.setEnabled(true);
        txtdictation.setEnabled(true);
        txtscience.setEnabled(true);
        cbterm.setEnabled(true);
        txtmath.setEnabled(true);
        txtsocial.setEnabled(true);
        txtcomputer.setEnabled(true);
        tgk.setEnabled(true);
        tmoral.setEnabled(true);
        teng1prac.setEnabled(true);
        teng2prac.setEnabled(true);
        tsciprac.setEnabled(true);
        tsocialprac.setEnabled(true);
        tcomprac.setEnabled(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if (txtid.getText().equals("") || cbterm.getSelectedItem().equals("") || txtnep.getText().equals("") || txteng1.getText().equals("") || txteng2.getText().equals("") || txtscience.getText().equals("") || txtmath.getText().equals("") || txtsocial.getText().equals("") || txtcomputer.getText().equals("") || tmoral.getText().equals("") || teng2prac.getText().equals("") || teng1prac.getText().equals("") || tsciprac.getText().equals("") || tsocialprac.getText().equals("") || tcomprac.getText().equals("") || tgk.getText().equals("")) {
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

                    PreparedStatement pstmt = db.cn.prepareStatement("insert into four (terminal,English_I,English_II,Compulsory_Nepali,Science,Compulsory_Mathematics,Social_Studies,Computer,G_K,Moral,English_I_Practical,English_II_Practical,Science_Practical,Social_Practical,Computer_Practical,Drawing,Dictation,sid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pstmt.setString(1, term);
                    pstmt.setDouble(2, Double.parseDouble(txteng1.getText()));
                    pstmt.setDouble(3, Double.parseDouble(txteng2.getText()));
                    pstmt.setDouble(4, Double.parseDouble(txtnep.getText()));
                    pstmt.setDouble(5, Double.parseDouble(txtscience.getText()));
                    pstmt.setDouble(6, Double.parseDouble(txtmath.getText()));
                    pstmt.setDouble(7, Double.parseDouble(txtsocial.getText()));
                    pstmt.setDouble(8, Double.parseDouble(txtcomputer.getText()));
                    pstmt.setDouble(9, Double.parseDouble(tgk.getText()));
                    pstmt.setDouble(10, Double.parseDouble(tmoral.getText()));
                    pstmt.setDouble(11, Double.parseDouble(teng1prac.getText()));
                    pstmt.setDouble(12, Double.parseDouble(teng2prac.getText()));
                    pstmt.setDouble(13, Double.parseDouble(tsciprac.getText()));
                    pstmt.setDouble(14, Double.parseDouble(tsocialprac.getText()));
                    pstmt.setDouble(15, Double.parseDouble(tcomprac.getText()));
                    pstmt.setString(16, txtdraw.getText());
                    pstmt.setString(17, txtdictation.getText());
                    pstmt.setInt(18, Integer.parseInt(txtid.getText()));

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
        if (e.getSource() == txteng1 || e.getSource() == txteng2 || e.getSource() == txtid || e.getSource() == txtnep || e.getSource() == txtscience || e.getSource() == txtmath || e.getSource() == txtsocial || e.getSource() == txtcomputer || e.getSource() == tgk || e.getSource() == tmoral || e.getSource() == teng1prac || e.getSource() == tsciprac || e.getSource() == teng2prac || e.getSource() == tcomprac || e.getSource() == tsocialprac) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == '.')  || (c == KeyEvent.VK_ENTER))) {
                getToolkit().beep();
                e.consume();
            }
        } else if (e.getSource() == txtdraw || e.getSource() == txtdictation) {
            char c = e.getKeyChar();
            if (!((c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == '+') || (c == 'a') || (c == 'A') || (c == 'b') || (c == 'B') || (c == 'c') || (c == 'C') || (c == 'd') || (c == 'D') || (c == 'e') || (c == 'E'))) {
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
        
        if (e.getSource() == txteng1) {
            if (txteng1.getText().length() > 5) {
                txteng1.setText(txteng1.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);
            }
                   else {
                Double dd = Double.parseDouble(txteng1.getText());
               check80(dd);
            }

        }
        if (e.getSource() == txteng2) {
            if (txteng2.getText().length() > 5) {
                txteng2.setText(txteng2.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
                   else {
                Double dd = Double.parseDouble(txteng2.getText());
               check80(dd);
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
        if (e.getSource() == txtmath) {
            if (txtmath.getText().length() > 5) {
                txtmath.setText(txtmath.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
                   else {
                Double dd = Double.parseDouble(txtmath.getText());
               check100(dd);
            }

        }
        if (e.getSource() == teng1prac) {
            if (teng1prac.getText().length() > 5) {
                teng1prac.setText(teng1prac.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
                   else {
                Double dd = Double.parseDouble(teng1prac.getText());
               check20(dd);
            }

        }
        if (e.getSource() == teng2prac) {
            if (teng2prac.getText().length() > 5) {
                teng2prac.setText(teng2prac.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
                   else {
                Double dd = Double.parseDouble(teng2prac.getText());
               check20(dd);
            }

        }

        if (e.getSource() == txtcomputer) {
            if (txtcomputer.getText().length() > 5) {
                txtcomputer.setText(txtcomputer.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
                   else {
                Double dd = Double.parseDouble(txtcomputer.getText());
               check50(dd);
            }

        }

        if (e.getSource() == txtscience) {
            if (txtscience.getText().length() > 5) {
                txtscience.setText(txtscience.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
                   else {
                Double dd = Double.parseDouble(txtscience.getText());
               check75(dd);
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
        if (e.getSource() == tmoral) {
            if (tmoral.getText().length() > 5) {
                tmoral.setText(tmoral.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
                   else {
                Double dd = Double.parseDouble(tmoral.getText());
               check25(dd);
            }

        }

        if (e.getSource() == tgk) {
            if (tgk.getText().length() > 5) {
                tgk.setText(tgk.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            }
       else {
                Double dd = Double.parseDouble(tgk.getText());
               check25(dd);
            }

        }
        if (e.getSource() == txtdictation) {
            if (txtdictation.getText().length() > 2) {
                txtdictation.setText(txtdictation.getText().substring(0, 2));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            } else {
                String name = txtdictation.getText();
                String newname = name.toUpperCase();
                txtdictation.setText(newname);
            }
        }

        if (e.getSource() == txtdraw) {
            if (txtdraw.getText().length() > 2) {
                txtdraw.setText(txtdraw.getText().substring(0, 2));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);
            } else {
                String name = txtdraw.getText();
                String newname = name.toUpperCase();
                txtdraw.setText(newname);
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
  public void check20(Double yy){
     if(yy>20.0){
      JOptionPane.showMessageDialog(null, "Mark is greater than 20 !!", "Marks Entry Error", JOptionPane.ERROR_MESSAGE);
                    //e.consume();
                    try {
                        Robot robot = new Robot();
                        robot.keyPress(KeyEvent.VK_BACK_SPACE);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
    }
       public void check80(Double yy){
     if(yy>80.0){
      JOptionPane.showMessageDialog(null, "Mark is greater than 80 !!", "Marks Entry Error", JOptionPane.ERROR_MESSAGE);
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
            pstmt.setString(2, "Four");
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


