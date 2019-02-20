
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AdmitCardText extends JDialog implements ActionListener, KeyListener {

    JPanel pane;
    JLabel logo, name, sec, roll, sym, grade, regno, jlexam;
    JTextField tname, troll, tgrade, tsym, tregno;
    JButton submit;
    JComboBox cbterm;
    DBConnection1 db = new DBConnection1();
    ResultSet rs;
    PreparedStatement pstmt;

    public AdmitCardText() {

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

        cbterm = new JComboBox();
        pane.add(cbterm);
        cbterm.setBounds(137, 80, 240, 38);
        cbterm.addItem("");
        cbterm.addItem("First Terminal Examination");
        cbterm.addItem("Second Terminal Examination");
        cbterm.addItem("Third Terminal Examination");
        cbterm.addItem("Final Terminal Examination");
        cbterm.addKeyListener(this);
        cbterm.addActionListener(this);

        logo = new JLabel(new ImageIcon("images/admitname.png"));
        pane.add(logo);
        logo.setBounds(135, 123, 230, 43);

        tname = new JTextField();
        pane.add(tname);
        tname.setFont(ft);
        tname.addKeyListener(this);

        sym = new JLabel("Student ID : ");
        pane.add(sym);
        sym.setBounds(38, 182, 130, 40);
        sym.setFont(ft);
        sym.setForeground(Color.BLACK);

        tsym = new JTextField();
        pane.add(tsym);
        tsym.setBounds(158, 182, 170, 36);
        tsym.setEnabled(false);
        tsym.setFont(ft1);
        tsym.addKeyListener(this);
        tsym.addActionListener(this);

        tgrade = new JTextField();
        pane.add(tgrade);
        tgrade.addKeyListener(this);
        tgrade.setFont(ft1);

        troll = new JTextField();
        pane.add(troll);
        troll.addKeyListener(this);
        troll.setFont(ft1);

        submit = new JButton("Submit ",new ImageIcon("images/save.png"));
        pane.add(submit);
        submit.setBounds(350, 182, 140, 38);
        submit.setFont(ft2);
        submit.setForeground(Color.BLACK);
        submit.setBackground(Color.WHITE);
        submit.addActionListener(this);
        submit.addKeyListener(this);

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
        new AdmitCardText();
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
