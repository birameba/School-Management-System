
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class EditTeacher extends JDialog implements ActionListener, KeyListener {

    JLabel jlapplelogo, jleditt, editlabel, edittxt, jlattribute;
    JTextField txtsearch;
    JButton btnedit, btndelete;
    JPanel pan = new JPanel();
    DBConnection1 db = new DBConnection1();
    PreparedStatement pstmt;
    ResultSet rs;

    public EditTeacher() {

        Font ft = new Font("", Font.BOLD, 18);
        Font ft1 = new Font("", Font.PLAIN, 19);
        add(pan);
        pan.setLayout(null);
        pan.setBackground(Color.WHITE);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        pan.add(jlapplelogo);
        jlapplelogo.setBounds(26, 5, 669, 140);

        jleditt = new JLabel(new ImageIcon("images/editteacher.png"));
        pan.add(jleditt);
        jleditt.setBounds(0, 160, 700, 33);

        jlattribute = new JLabel("Teacher ID : ");
        pan.add(jlattribute);
        jlattribute.setBounds(38, 225, 120, 38);
        jlattribute.setFont(ft);
        jlattribute.setForeground(Color.BLUE);

        txtsearch = new JTextField();
        pan.add(txtsearch);
        txtsearch.setBounds(147, 225, 180, 38);
        txtsearch.setFont(ft1);
        txtsearch.addKeyListener(this);
        txtsearch.addActionListener(this);

        btnedit = new JButton("Edit",new ImageIcon("images/edit.png"));
        pan.add(btnedit);
        btnedit.setFont(ft);
        btnedit.setBounds(380, 225, 120, 42);
        btnedit.setBackground(Color.WHITE);
        btnedit.setForeground(Color.BLUE);
        btnedit.addActionListener(this);

        btndelete = new JButton("Delete",new ImageIcon("images/delete.png"));
        pan.add(btndelete);
        btndelete.setFont(ft);
        btndelete.setBounds(523, 225, 120, 42);
        btndelete.setBackground(Color.WHITE);
        btndelete.setForeground(Color.RED);
        btndelete.addActionListener(this);

        setSize(700, 335);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
     new EditTeacher(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnedit || e.getSource()==txtsearch) {
            if (txtsearch.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Teacher ID !!", "Information Error", JOptionPane.ERROR_MESSAGE);
            } else {
                     try{
            int teacher_id = Integer.parseInt(txtsearch.getText());
       
            pstmt=db.cn.prepareStatement("select teacher_id from teacher where teacher_id=? ");
            pstmt.setInt(1, teacher_id);
            rs=pstmt.executeQuery();
            if(rs.next()){
            EditTeacherTable st = new EditTeacherTable(teacher_id);
            this.dispose();
            }
            else{
                 JOptionPane.showMessageDialog(null, " Please Enter Valid Teacher ID!!", "Non Existed ID", JOptionPane.ERROR_MESSAGE);
                   }
        }catch (Exception exx){}
        }
             
        }
            if (e.getSource() == btndelete) {
                new ViewTeacher();
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
