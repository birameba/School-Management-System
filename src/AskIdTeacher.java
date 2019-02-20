///////////////////////////////Call for new Teacher Transaction/////////////////////////////////////////

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class AskIdTeacher extends JDialog implements ActionListener, KeyListener {

    JLabel jlapplelogo, jledits, jlpresent, editlabel, edittxt, jlattribute;
    JTextField txtsearch, txtpresent;
    JButton btnedit, btndelete;
    JTable table;
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane jsp;
    JPanel pan = new JPanel();
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    DBConnection1 db = new DBConnection1();

    public AskIdTeacher() {

        table = new JTable(model);
        Font ft = new Font("", Font.BOLD, 19);
        Font ft3 = new Font("", Font.BOLD, 17);
        Font ft2 = new Font("", Font.BOLD, 22);
        Font ft1 = new Font("", Font.PLAIN, 19);
        add(pan);
        pan.setLayout(null);
        pan.setBackground(Color.WHITE);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pan.add(jlapplelogo);
        jlapplelogo.setBounds(26, 5, 669, 140);

        jledits = new JLabel(new ImageIcon("images/idinfo.png"));
        pan.add(jledits);
        jledits.setBounds(0, 148, 700, 33);

        jlattribute = new JLabel("Teacher ID");
        pan.add(jlattribute);
        jlattribute.setBounds(120, 220, 100, 35);
        jlattribute.setFont(ft3);

        txtsearch = new JTextField();
        pan.add(txtsearch);
        txtsearch.setBounds(240, 218, 300, 35);
        txtsearch.setFont(ft1);
        txtsearch.addKeyListener(this);
        txtsearch.addActionListener(this);

        jlpresent = new JLabel("Present Days");
        pan.add(jlpresent);
        jlpresent.setBounds(120, 270, 120, 35);
        jlpresent.setFont(ft3);

        txtpresent = new JTextField();
        pan.add(txtpresent);
        txtpresent.setBounds(240, 270, 300, 35);
        txtpresent.setFont(ft1);
        txtpresent.addKeyListener(this);
        txtpresent.addActionListener(this);

        btnedit = new JButton("Make Payment", new ImageIcon("images/makepayment.png"));
        pan.add(btnedit);
        btnedit.setBounds(265, 330, 210, 43);
        btnedit.setFont(ft2);
        btnedit.setBackground(Color.BLUE);
        btnedit.setForeground(Color.WHITE);
        btnedit.addActionListener(this);
        btnedit.addKeyListener(this);

        addKeyListener(this);
        setSize(700, 425);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Teacher ID Form");
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new AskIdTeacher();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnedit || e.getSource() == txtsearch || e.getSource() == txtpresent) {

            if (txtsearch.getText().equals("") || txtpresent.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Teacher ID and Total Present Days !!", "Transaction Failed", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int teacher_id = Integer.parseInt(txtsearch.getText());
                    int present = Integer.parseInt(txtpresent.getText());
                    pstmt = db.cn.prepareStatement("select teacher_id from teacher where teacher_id=? ");
                    pstmt.setInt(1, teacher_id);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                          this.dispose();
                        AskIdTeacherTransaction st = new AskIdTeacherTransaction(teacher_id, present);
                        
                       
                    } else {
                        JOptionPane.showMessageDialog(null, " Please Enter Valid Teacher ID!!", "Non Existed ID", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception exx) {
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == txtsearch || e.getSource() == txtpresent) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                e.consume();

            }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
////////pressing enter is done by adding ActionListener to the TextField (txtsearch and txtpresent)///////////////////
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == txtsearch) {
            if (txtsearch.getText().length() > 5) {
                txtsearch.setText(txtsearch.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == txtpresent) {
            if (txtpresent.getText().length() > 2) {
                txtpresent.setText(txtpresent.getText().substring(0, 2));
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Present Days Error !!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

