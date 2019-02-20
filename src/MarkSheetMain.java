////////////////////////////////Form to enter the details of the student to print the marksheet//////////////////////////////
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MarkSheetMain extends JDialog implements ActionListener,KeyListener,FocusListener {
    JPanel pane;
    JLabel id, present, date,jgcb;
    JTextField tid, tdate, tgrade, tname, tparent, troll, tpresent;
    JButton submit;
    JComboBox gcb;
    PreparedStatement pstmt;
    ResultSet rs;
    DBConnection1 dbc = new DBConnection1();
    String ss;

    public MarkSheetMain() {
        pane = new JPanel();
        add(pane);
        pane.setLayout(null);
         Font ft1 = new Font("", Font.PLAIN, 15);
        pane.setBackground(Color.WHITE);
        Font ft = new Font("", Font.BOLD, 17);

        id = new JLabel("Student ID : ");
        pane.add(id);
        id.setBounds(35, 20, 130, 40);
        id.setFont(ft);
        id.setForeground(Color.BLUE);

        tid = new JTextField();
        pane.add(tid);
        tid.setBounds(160, 20, 200, 35);
        tid.setFont(ft1);
        tid.addActionListener(this);
        tid.addKeyListener(this);
        tid.addFocusListener(this);

        present = new JLabel("Attendence : ");
        pane.add(present);
        present.setBounds(385, 20, 130, 40);
        present.setFont(ft);
         present.setForeground(Color.BLUE);

        tpresent = new JTextField();
        pane.add(tpresent);
        tpresent.setBounds(500, 20, 202, 35);
         tpresent.setFont(ft1);
        tpresent.addActionListener(this);
          tpresent.addKeyListener(this);
        
           jgcb = new JLabel("Terminal : ");
        pane.add(jgcb);
        jgcb.setBounds(385, 65, 130, 40);
        jgcb.setFont(ft);
         jgcb.setForeground(Color.BLUE);
        
        gcb = new JComboBox();
        pane.add(gcb);
        gcb.setBounds(500, 70, 202, 35);
        gcb.addItem("");
        gcb.addItem("First Terminal Examination");
        gcb.addItem("Second Terminal Examination");
        gcb.addItem("Third Terminal Examination");
        gcb.addItem("Final Terminal Examination");
        gcb.addKeyListener(this);
        

        date = new JLabel("Date Of Issue : ");
        pane.add(date);
        date.setBounds(35, 70, 130, 40);
        date.setFont(ft);
         date.setForeground(Color.BLUE);

        tdate = new JTextField();
        pane.add(tdate);
        tdate.setBounds(160, 70, 200, 35);
         tdate.setFont(ft1);
        tdate.addActionListener(this);
          tdate.addKeyListener(this);

        tname = new JTextField();
        pane.add(tname);
        tname.setFont(ft);

        tparent = new JTextField();
        pane.add(tparent);
        tparent.setFont(ft);

        tgrade = new JTextField();
        pane.add(tgrade);
        tgrade.setFont(ft);

        troll = new JTextField();
        pane.add(troll);
        troll.setFont(ft);

        submit = new JButton("Submit");
        pane.add(submit);
        submit.setBounds(500, 119, 160, 35);
        submit.setFont(ft);
        submit.addActionListener(this);
        submit.addKeyListener(this);
         submit.setForeground(Color.WHITE);
         submit.setBackground(Color.BLUE);

        addKeyListener(this);
        setSize(750, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Mark Sheet");
    }

    public static void main(String[] args) {
       try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new MarkSheetMain();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if (tid.getText().equals("") ||  tdate.getText().equals("") || tpresent.getText().equals("")||gcb.getSelectedItem()=="") {
                JOptionPane.showMessageDialog(null, "Incomplete Information","Marksheet Error",JOptionPane.ERROR_MESSAGE);
            }else
            {
            try {

                pstmt = dbc.cn.prepareStatement("select fname,mname,lname,roll_no,class,guardian from record where student_id=?");
                pstmt.setInt(1, Integer.parseInt(tid.getText().trim()));
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    troll.setText(rs.getString("roll_no"));
                    tgrade.setText(rs.getString("class"));
                    tparent.setText(rs.getString("guardian"));
                    tname.setText(rs.getString("fname") + " " + rs.getString("mname") + " " + rs.getString("lname"));
                }
                

            } catch (SQLException exx) {
            }
            if(gcb.getSelectedItem().toString().equals("First Terminal Examination")){ss="First Terminal Examination";}
            else if(gcb.getSelectedItem().toString().equals("Second Terminal Examination")){ss="Second Terminal Examination";}
            else if(gcb.getSelectedItem().toString().equals("Third Terminal Examination")){ss="Third Terminal Examination";}
            else{ss="Final Terminal Examination";}
            String[] values = {tid.getText().trim(),ss,tname.getText(), troll.getText(), tgrade.getText(), tid.getText(), tparent.getText(), tdate.getText(), tpresent.getText()};
            new MarkSheet(values);
            this.dispose();
            }
    }
    }

    @Override
    public void keyTyped(KeyEvent e) {
         if (e.getSource() == tpresent || e.getSource() == tid ||  e.getSource() == tdate) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_MINUS))) {
                getToolkit().beep();
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                  if (tid.getText().equals("") ||  tdate.getText().equals("") || tpresent.getText().equals("")||gcb.getSelectedItem()=="") {
                JOptionPane.showMessageDialog(null, "Incomplete Information","Marksheet Error",JOptionPane.ERROR_MESSAGE);
            }else
            {
            try {

                pstmt = dbc.cn.prepareStatement("select fname,mname,lname,roll_no,class,guardian from record where student_id=?");
                pstmt.setInt(1, Integer.parseInt(tid.getText().trim()));
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    troll.setText(rs.getString("roll_no"));
                    tgrade.setText(rs.getString("class"));
                    tparent.setText(rs.getString("guardian"));
                    tname.setText(rs.getString("fname") + " " + rs.getString("mname") + " " + rs.getString("lname"));
                }

            } catch (SQLException exx) {
            }
                 if(gcb.getSelectedItem().toString().equals("First Terminal Examination")){ss="First Terminal Examination";}
            else if(gcb.getSelectedItem().toString().equals("Second Terminal Examination")){ss="Second Terminal Examination";}
            else if(gcb.getSelectedItem().toString().equals("Third Terminal Examination")){ss="Third Terminal Examination";}
            else{ss="Final Terminal Examination";}
           String[] values = {tid.getText().trim(),ss,tname.getText(), troll.getText(), tgrade.getText(), tid.getText(), tparent.getText(), tdate.getText(), tpresent.getText()};
            new MarkSheet(values);
            this.dispose();
        }
    }
          }
    

    @Override
    public void keyReleased(KeyEvent e) {
              if (e.getSource() == tid) {
            if (tid.getText().length() > 5) {
                 tid.setText(tid.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);
               
            }
        }
                 if (e.getSource() == tpresent) {
            if (tpresent.getText().length() > 2) {
                   tpresent.setText(tpresent.getText().substring(0, 2));
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Present Days Error !!", JOptionPane.ERROR_MESSAGE);
             
            }
    }
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
         if (e.getSource() == tid) {
            try {
                int sid = Integer.parseInt(tid.getText());
                pstmt = dbc.cn.prepareStatement("SELECT student_id  FROM record where student_id=?");
                pstmt.setInt(1, sid);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    tpresent.requestFocus();
                } else {
                    tid.requestFocus();
                    JOptionPane.showMessageDialog(null, " Please Enter Valid Student ID!!", "Non Existed ID", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception p) {
            }
        }
    }
}
