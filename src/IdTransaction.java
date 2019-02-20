
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class IdTransaction extends JDialog implements ActionListener,KeyListener {

    JLabel jlapplelogo, jledits, editlabel, edittxt, jlattribute;
    JTextField txtsearch;
    JButton btnedit;
    JPanel pan = new JPanel();
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    DBConnection1 db = new DBConnection1();

    public IdTransaction() {

        Font ft = new Font("", Font.BOLD, 17);
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

        jlattribute = new JLabel("Student ID:");
        pan.add(jlattribute);
        jlattribute.setBounds(60, 220, 100, 35);
        jlattribute.setFont(ft);

        txtsearch = new JTextField();
        pan.add(txtsearch);
        txtsearch.setBounds(170, 218, 230, 35);
        txtsearch.setFont(ft1);
        txtsearch.addKeyListener(this);
        txtsearch.addActionListener(this);

        btnedit = new JButton("Payment",new ImageIcon("images/makepayment.png"));
        pan.add(btnedit);
        btnedit.setFont(ft);
        btnedit.setBounds(447, 219, 130, 39);
        btnedit.setBackground(Color.WHITE);
        btnedit.setForeground(Color.BLUE);
        btnedit.addActionListener(this);
        btnedit.addKeyListener(this);

        setSize(700, 330);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Student ID Form");
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
       new IdTransaction();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnedit || e.getSource()==txtsearch) {
            if (txtsearch.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Student ID!!", "Receipt Printing Failed", JOptionPane.ERROR_MESSAGE);
            } 
            else {
                   try {
                    int sid=Integer.parseInt(txtsearch.getText());
                    pstmt = db.cn.prepareStatement("SELECT student_id  FROM record where student_id=?");
                    pstmt.setInt(1,sid);
                    rs = pstmt.executeQuery();
                    if(rs.next()) {
                            CashReceiptText st = new CashReceiptText(sid);
                            this.dispose();
                        }
                        else {
                         JOptionPane.showMessageDialog(null, " Please Enter Valid Student ID!!", "Non Existed ID", JOptionPane.ERROR_MESSAGE);
                        }
                    
                } catch (Exception ex) {
                }     
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == txtsearch) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
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
          if (e.getSource() == txtsearch) {
            if (txtsearch.getText().length() > 5) {
                  txtsearch.setText(txtsearch.getText().substring(0, 5));
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);
              
            }
        }
    }
}
