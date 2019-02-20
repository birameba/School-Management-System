
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class SecAdmitText extends JDialog implements ActionListener, KeyListener {

    JPanel pane;
    JLabel logo, name, sec, roll, sym, grade, regno, jlexam;
    JTextField tname, troll, tgrade, tsym, tregno;
    JButton submit;
    JComboBox cbterm;
    DBConnection1 db = new DBConnection1();
    ResultSet rs;
    PreparedStatement pstmt;
    String g,term;

    public SecAdmitText(String level,String terminal) {
        g=level;
        term=terminal;
        pane = new JPanel();
        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);
        Font ft = new Font("", Font.BOLD, 19);
        Font ft1 = new Font("", Font.PLAIN, 19);
        Font ft2 = new Font("", Font.BOLD, 20);

        logo = new JLabel(new ImageIcon("images/admitcard.png"));
        pane.add(logo);
        logo.setBounds(70, 5, 360, 60);

        logo = new JLabel(new ImageIcon("images/admitname.png"));
        pane.add(logo);
        logo.setBounds(135, 123, 230, 43);

        try{
            PreparedStatement pstmt=db.cn.prepareStatement("select id from record where class=?");
            pstmt.setString(1, level);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
            
            }
        }catch(Exception ex){}
        
        
        addKeyListener(this);
        setSize(530, 275);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Admit Card");

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new SecAdmitText("Two","First Terminal Examination");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cbterm) {
            if (!(cbterm.getSelectedItem().equals(""))) {
                tsym.setEnabled(true);
            } else {
                tsym.setEnabled(false);
            }
        }

        if (e.getSource() == submit || e.getSource() == tsym) {
            if (tsym.getText().equals("") || cbterm.getSelectedItem() == "") {
                JOptionPane.showMessageDialog(null, "Incomplete Information", "Card Printing Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int sid = Integer.parseInt(tsym.getText());
                    pstmt = db.cn.prepareStatement("SELECT student_id  FROM record where student_id=?");
                    pstmt.setInt(1, sid);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                        try {
                            PreparedStatement pstmt = db.cn.prepareStatement("select fname,mname,lname,roll_no,class from record where student_id=?");
                            pstmt.setInt(1, Integer.parseInt(tsym.getText()));
                            ResultSet rs = pstmt.executeQuery();
                            if (rs.next()) {
                                troll.setText(rs.getString("roll_no"));
                                tgrade.setText(rs.getString("class"));
                                tname.setText(rs.getString("fname") + " " + rs.getString("mname") + " " + rs.getString("lname"));
                            }

                        } catch (SQLException exx) {
                            exx.printStackTrace();
                        }

                        String[] values = {tname.getText(), troll.getText(), tgrade.getText(), tsym.getText(), cbterm.getSelectedItem().toString()};
                        new AdmitCard(values);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, " Please Enter Valid Student ID!!", "Non Existed ID", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception ex) {
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e
    ) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == tsym) {
            if (tsym.getText().length() > 5) {
                tsym.setText(tsym.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
