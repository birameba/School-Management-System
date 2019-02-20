///////////////Called for editing student information//////////////////////////////////////
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class EditStudent extends JFrame implements ActionListener, KeyListener {

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
    DBConnection1 db = new DBConnection1();

    public EditStudent() {

        table = new JTable(model);
        Font ft = new Font("", Font.BOLD, 18);
        Font ft1 = new Font("", Font.PLAIN, 19);

        add(pan);
        pan.setLayout(null);
        pan.setBackground(Color.WHITE);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pan.add(jlapplelogo);
        jlapplelogo.setBounds(26, 5, 669, 140);

        jledits = new JLabel(new ImageIcon("images/editst.png"));
        pan.add(jledits);
        jledits.setBounds(0, 148, 700, 33);

        jlattribute = new JLabel("Student ID :");
        pan.add(jlattribute);
        jlattribute.setBounds(110, 210, 115, 38);
        jlattribute.setFont(ft);
        jlattribute.setForeground(Color.BLUE);

        txtsearch = new JTextField();
        pan.add(txtsearch);
        txtsearch.setBounds(230, 210, 310, 38);
        txtsearch.setFont(ft1);
        txtsearch.addKeyListener(this);
        txtsearch.addActionListener(this);

        btnedit = new JButton("Edit",new ImageIcon("images/edit.png"));
        pan.add(btnedit);
        btnedit.setFont(ft);
        btnedit.setBounds(230, 278, 130, 42);
        btnedit.setBackground(Color.WHITE);
        btnedit.setForeground(Color.BLUE);
        btnedit.addActionListener(this);

        btndelete = new JButton("Delete",new ImageIcon("images/delete.png"));
        pan.add(btndelete);
         btndelete.setFont(ft);
        btndelete.setBounds(410, 278, 130, 42);
        btndelete.setBackground(Color.WHITE);
        btndelete.setForeground(Color.RED);
        btndelete.addActionListener(this);

        setSize(700, 385);
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
        new EditStudent();
      }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnedit || e.getSource()==txtsearch) {
            if(txtsearch.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Student ID !!","Information Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                 try {
                    int sid=Integer.parseInt(txtsearch.getText());
                    pstmt = db.cn.prepareStatement("SELECT student_id  FROM record where student_id=?");
                    pstmt.setInt(1,sid);
                    rs = pstmt.executeQuery();
                    if(rs.next()) {
                            EditTable st = new EditTable(sid);
                            this.dispose();
                        }
                        else {
                         JOptionPane.showMessageDialog(null, " Please Enter Valid Student ID!!", "Non Existed ID", JOptionPane.ERROR_MESSAGE);
                        }
                    
                } catch (Exception ex) {
                }
        }
        }
        if (e.getSource() == btndelete) {
            new ViewStudent();
            this.dispose();
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
