
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class PresentDays extends JDialog implements ActionListener, KeyListener {

    JLabel jlapplelogo, jledits, editlabel, edittxt, jlattribute;
    JTextField txtsearch;
    JButton btnedit, btndelete;
    JTable table;
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane jsp;
    JPanel pan = new JPanel();
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    DBConnection1 dbc = new DBConnection1();
    int id, present;

    public PresentDays(int teacher_id) {
        id = teacher_id;
        table = new JTable(model);
        Font ft = new Font("", Font.BOLD, 18);
        Font ft1 = new Font("", Font.PLAIN, 15);

        add(pan);
        pan.setLayout(null);
        pan.setBackground(Color.WHITE);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pan.add(jlapplelogo);
        jlapplelogo.setBounds(26, 5, 669, 140);

        jledits = new JLabel(new ImageIcon("images/idinfo.png"));
        pan.add(jledits);
        jledits.setBounds(0, 148, 700, 33);

        jlattribute = new JLabel("Present Days:");
        pan.add(jlattribute);
        jlattribute.setBounds(40, 220, 140, 35);
        jlattribute.setFont(ft);

        txtsearch = new JTextField();
        pan.add(txtsearch);
        txtsearch.setBounds(175, 218, 280, 35);
        txtsearch.setFont(ft1);
        txtsearch.addKeyListener(this);

        btnedit = new JButton("Payment",new ImageIcon("images/makepayment.png"));
        pan.add(btnedit);
        btnedit.setBounds(490, 218, 150, 42);
        btnedit.setFont(ft);
        btnedit.setBackground(Color.BLUE);
        btnedit.setForeground(Color.WHITE);
        btnedit.addActionListener(this);
        btnedit.addKeyListener(this);

        setSize(700, 330);
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
     // new PresentDays(1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnedit) {
            if (txtsearch.getText().equals("")) {
                JOptionPane.showMessageDialog(null, " Please enter total present days !!", "Transaction Failed", JOptionPane.ERROR_MESSAGE);
            } else {
                 present = Integer.parseInt(txtsearch.getText());
                  this.dispose();
               IndirectTeacherTransaction st = new IndirectTeacherTransaction(id, present);
               
      
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
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtsearch.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "  Please enter total present days!!", "Transaction Failed", JOptionPane.ERROR_MESSAGE);
            } else {
                present = Integer.parseInt(txtsearch.getText());
                this.dispose();
                IndirectTeacherTransaction st = new IndirectTeacherTransaction(id, present);
                
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
             if (e.getSource() == txtsearch) {
            if (txtsearch.getText().length() > 1) {
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "Numbering Error !!", JOptionPane.ERROR_MESSAGE);
                txtsearch.setText(txtsearch.getText().substring(0, 2));
            }  
            }
           }
        }
    

