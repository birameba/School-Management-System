///////////////////////////Marks Entry Form for class U.KG///////////////////////////////

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Ukg extends JDialog implements ActionListener, KeyListener{

    JLabel id, subjects, gradeimg, drawing, english, nepali, rhymes, gk, englishoral, math, scienceoral, social, science, dictation, conversation, nepalioral, mathoral, socialgk, term, total, percentage, logo, division;
    JPanel pane;
    JComboBox cbterm, cbdiv;
    JTextField txtid, txtsocialgk, txtengoral, txtneporal, txteng, txtgk, txtnepali, txtscienceoral, txtmath, txtscience, txtsocial, txtdictation, txtconversation, txtmathoral, txtdraw, txtrhymes, txttotal, txtpercent;
    //int sum,percent,div;
    PreparedStatement pstmt;
    ResultSet rs;
    JButton submit, reset;
    DBConnection1 db = new DBConnection1();
    int count;

    public Ukg() {

        pane = new JPanel();
        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);
        Font ft = new Font("", Font.BOLD, 13);

        logo = new JLabel(new ImageIcon("images/applexm.png"));
        pane.add(logo);
        logo.setBounds(60, 8, 227, 40);

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

        subjects = new JLabel(new ImageIcon("images/sub.png"));
        pane.add(subjects);
        subjects.setBounds(0, 150, 360, 18);

        english = new JLabel("English   ");
        pane.add(english, 0);
        english.setBounds(40, 185, 150, 25);
        english.setForeground(Color.BLUE);
        english.setFont(ft);

        txteng = new JTextField();
        pane.add(txteng);
        txteng.setBounds(150, 185, 160, 25);
        txteng.addKeyListener(this);

        englishoral = new JLabel("English Oral ");
        pane.add(englishoral, 0);
        englishoral.setBounds(40, 215, 150, 25);
        englishoral.setForeground(Color.BLUE);
        englishoral.setFont(ft);

        txtengoral = new JTextField();
        pane.add(txtengoral);
        txtengoral.setBounds(150, 215, 160, 25);
        txtengoral.addKeyListener(this);

        nepali = new JLabel("Nepali   ");
        pane.add(nepali, 0);
        nepali.setBounds(40, 245, 150, 25);
        nepali.setForeground(Color.BLUE);
        nepali.setFont(ft);

        txtnepali = new JTextField();
        pane.add(txtnepali);
        txtnepali.setBounds(150, 245, 160, 25);
        txtnepali.addKeyListener(this);

        nepalioral = new JLabel("Nepali Oral    ");
        pane.add(nepalioral, 0);
        nepalioral.setBounds(40, 275, 150, 25);
        nepalioral.setForeground(Color.BLUE);
        nepalioral.setFont(ft);

        txtneporal = new JTextField();
        pane.add(txtneporal);
        txtneporal.setBounds(150, 275, 160, 25);
        txtneporal.addKeyListener(this);

        math = new JLabel("Mathematics   ");
        pane.add(math, 0);
        math.setBounds(40, 305, 150, 25);
        math.setForeground(Color.BLUE);
        math.setFont(ft);

        txtmath = new JTextField();
        pane.add(txtmath);
        txtmath.setBounds(150, 305, 160, 25);
        txtmath.addKeyListener(this);

        mathoral = new JLabel("Mathematics Oral  ");
        pane.add(mathoral, 0);
        mathoral.setBounds(40, 335, 150, 25);
        mathoral.setForeground(Color.BLUE);
        mathoral.setFont(ft);

        txtmathoral = new JTextField();
        pane.add(txtmathoral);
        txtmathoral.setBounds(150, 335, 160, 25);
        txtmathoral.addKeyListener(this);

        science = new JLabel("Science   ");
        pane.add(science, 0);
        science.setBounds(40, 365, 150, 25);
        science.setForeground(Color.BLUE);
        science.setFont(ft);

        txtscience = new JTextField();
        pane.add(txtscience);
        txtscience.setBounds(150, 365, 160, 25);
        txtscience.addKeyListener(this);

        social = new JLabel("Social Studies  ");
        pane.add(social, 0);
        social.setBounds(40, 395, 150, 25);
        social.setForeground(Color.BLUE);
        social.setFont(ft);

        txtsocial = new JTextField();
        pane.add(txtsocial);
        txtsocial.setBounds(150, 395, 160, 25);
        txtsocial.addKeyListener(this);

        gk = new JLabel("G.K.  ");
        pane.add(gk, 0);
        gk.setBounds(40, 425, 150, 25);
        gk.setForeground(Color.BLUE);
        gk.setFont(ft);

        txtgk = new JTextField();
        pane.add(txtgk);
        txtgk.setBounds(150, 425, 160, 25);
        txtgk.addKeyListener(this);

        rhymes = new JLabel("Rhymes  ");
        pane.add(rhymes, 0);
        rhymes.setBounds(40, 455, 150, 25);
        rhymes.setForeground(Color.BLUE);
        rhymes.setFont(ft);

        txtrhymes = new JTextField();
        pane.add(txtrhymes);
        txtrhymes.setBounds(150, 455, 160, 25);
        txtrhymes.addKeyListener(this);

        drawing = new JLabel("Drawing   ");
        pane.add(drawing, 0);
        drawing.setBounds(40, 485, 150, 25);
        drawing.setForeground(Color.BLUE);
        drawing.setFont(ft);

        txtdraw = new JTextField();
        pane.add(txtdraw);
        txtdraw.setBounds(150, 485, 160, 25);
        txtdraw.addKeyListener(this);

        conversation = new JLabel("Conversation    ");
        pane.add(conversation, 0);
        conversation.setBounds(40, 515, 150, 25);
        conversation.setForeground(Color.BLUE);
        conversation.setFont(ft);

        txtconversation = new JTextField();
        pane.add(txtconversation);
        txtconversation.setBounds(150, 515, 160, 25);
        txtconversation.addKeyListener(this);

        dictation = new JLabel("Dictation ");
        pane.add(dictation, 0);
        dictation.setBounds(40, 545, 150, 25);
        dictation.setForeground(Color.BLUE);
        dictation.setFont(ft);

        txtdictation = new JTextField();
        pane.add(txtdictation);
        txtdictation.setBounds(150, 545, 160, 25);
        txtdictation.addKeyListener(this);

        submit = new JButton("Submit",new ImageIcon("images/save.png"));
        pane.add(submit, 0);
        submit.setBounds(40, 585, 120, 28);
        submit.setForeground(Color.BLUE);
        submit.setBackground(Color.WHITE);
        submit.setFont(ft);
        submit.addActionListener(this);

        
  reset = new JButton("Reset",new ImageIcon("images/refresh.png"));
        pane.add(reset, 0);
        reset.setBounds(190, 585, 120, 28);
        reset.setForeground(Color.BLUE);
        reset.setBackground(Color.WHITE);
        reset.addActionListener(this);
        reset.setFont(ft);

        setDisabled();
        
      
        setSize(360, 660);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Class-Ukg");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
//        new Ukg();
    }

    public void setEmpty() {
        txteng.setText("");
        txtengoral.setText("");
        cbterm.setSelectedItem("");
        txtnepali.setText("");
        txtneporal.setText("");
        txtmath.setText("");
        txtscience.setText("");
        txtgk.setText("");
        txtsocial.setText("");
        txtmathoral.setText("");
        txtrhymes.setText("");
        txtdraw.setText("");
        txtconversation.setText("");
        txtdictation.setText("");
        txtid.setText("");
    }

    public void setDisabled() {
        txteng.setEnabled(false);
        txtengoral.setEnabled(false);
        cbterm.setEnabled(false);
        txtnepali.setEnabled(false);
        txtneporal.setEnabled(false);
        txtmath.setEnabled(false);
        txtscience.setEnabled(false);
        txtsocial.setEnabled(false);
        txtmathoral.setEnabled(false);
        txtgk.setEnabled(false);
        txtrhymes.setEnabled(false);
        txtdraw.setEnabled(false);
        txtconversation.setEnabled(false);
        txtdictation.setEnabled(false);
    }

    public void setEnabled() {
        txteng.setEnabled(true);
        txtengoral.setEnabled(true);
        cbterm.setEnabled(true);
        txtnepali.setEnabled(true);
        txtneporal.setEnabled(true);
        txtmath.setEnabled(true);
        txtscience.setEnabled(true);
        txtsocial.setEnabled(true);
        txtmathoral.setEnabled(true);
        txtgk.setEnabled(true);
        txtrhymes.setEnabled(true);
        txtdraw.setEnabled(true);
        txtconversation.setEnabled(true);
        txtdictation.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {

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

                PreparedStatement pstmt = db.cn.prepareStatement("insert into ukg (terminal,English,English_Oral,Nepali,Nepali_Oral,Mathematics,Mathematics_Oral,Science,Social_Studies,G_K,Rhymes,Drawing,Conversation,Dictation,sid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pstmt.setString(1, term);
                pstmt.setDouble(2, Double.parseDouble(txteng.getText()));
                pstmt.setString(3, txtengoral.getText());
                pstmt.setDouble(4, Double.parseDouble(txtnepali.getText()));
                pstmt.setString(5, txtneporal.getText());
                pstmt.setDouble(6, Double.parseDouble(txtmath.getText()));
                pstmt.setString(7, txtmathoral.getText());
                pstmt.setDouble(8, Double.parseDouble(txtscience.getText()));
                pstmt.setDouble(9, Double.parseDouble(txtsocial.getText()));
                pstmt.setDouble(10, Double.parseDouble(txtgk.getText()));
                pstmt.setString(11, txtrhymes.getText());
                pstmt.setString(12, txtdraw.getText());
                pstmt.setString(13, txtconversation.getText());
                pstmt.setString(14, txtdictation.getText());
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
        if (e.getSource() == reset) {
            setEmpty();
            txtid.setEnabled(true);
            txtid.requestFocus();
            setDisabled();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == txteng || e.getSource() == txtid || e.getSource() == txtnepali || e.getSource() == txtscience || e.getSource() == txtmath || e.getSource() == txtsocial || e.getSource() == txtgk) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == '.') || (c == KeyEvent.VK_ENTER))) {
                getToolkit().beep();
                e.consume();
            }
        } else {
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
        if (e.getSource() == txtgk) {
            if (txtgk.getText().length() > 5) {
                txtgk.setText(txtgk.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);
            }
              else {
                Double dd = Double.parseDouble(txtgk.getText());
              check25(dd);
            }
        }
        if (e.getSource() == txtsocial) {
            if (txtsocial.getText().length() > 5) {
                txtsocial.setText(txtsocial.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);
            }
            else {
                Double dd = Double.parseDouble(txtsocial.getText());
              check100(dd);
            }
        }

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
              check100(dd);
            }
        }

        if (e.getSource() == txtnepali) {
            if (txtnepali.getText().length() > 5) {
                txtnepali.setText(txtnepali.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);
            }
            else {
                Double dd = Double.parseDouble(txtnepali.getText());
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

        if (e.getSource() == txtscience) {
            if (txtscience.getText().length() > 5) {
                txtscience.setText(txtscience.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);
            }
               else {
                Double dd = Double.parseDouble(txtscience.getText());
              check100(dd);
            }
        }


        if (e.getSource() == txtconversation) {
            if (txtconversation.getText().length() > 2) {
                txtconversation.setText(txtconversation.getText().substring(0, 2));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            } else {
                String name = txtconversation.getText();
                String newname = name.toUpperCase();
                txtconversation.setText(newname);
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
        if (e.getSource() == txtrhymes) {
            if (txtrhymes.getText().length() > 2) {
                txtrhymes.setText(txtrhymes.getText().substring(0, 2));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            } else {
                String name = txtrhymes.getText();
                String newname = name.toUpperCase();
                txtrhymes.setText(newname);
            }
        }
        if (e.getSource() == txtneporal) {
            if (txtneporal.getText().length() > 2) {
                txtneporal.setText(txtneporal.getText().substring(0, 2));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            } else {
                String name = txtneporal.getText();
                String newname = name.toUpperCase();
                txtneporal.setText(newname);
            }
        }
        if (e.getSource() == txtengoral) {
            if (txtengoral.getText().length() > 2) {
                txtengoral.setText(txtengoral.getText().substring(0, 2));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

            } else {
                String name = txtengoral.getText();
                String newname = name.toUpperCase();
                txtengoral.setText(newname);
            }
        }
        if (e.getSource() == txtmathoral) {
            if (txtmathoral.getText().length() > 2) {
                txtmathoral.setText(txtmathoral.getText().substring(0, 2));
                JOptionPane.showMessageDialog(null, "Maximum Character Reached", "Marks Entering Error !!", JOptionPane.ERROR_MESSAGE);

                txtmathoral.setText(txtmathoral.getText().substring(0, 2));
            } else {
                String name = txtmathoral.getText();
                String newname = name.toUpperCase();
                txtmathoral.setText(newname);
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
              public void check25(Double xx){
    if(xx>25.0){
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
                 public void demo() {
        try {
            int sid = Integer.parseInt(txtid.getText());
            pstmt = db.cn.prepareStatement("SELECT student_id  FROM record where student_id=? and class=?");
            pstmt.setInt(1, sid);
            pstmt.setString(2, "Ukg");
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
