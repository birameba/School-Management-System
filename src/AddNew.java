
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class AddNew extends JDialog implements ActionListener {

    JButton btnstudent, btnteacher;
    JTable table;
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane jsp;
    JPanel pan = new JPanel();
  
    public AddNew() {

        table = new JTable(model);
        Font ft = new Font("", Font.BOLD, 16);
      
        add(pan);
        pan.setLayout(null);
        pan.setBackground(Color.WHITE);


        btnstudent = new JButton("Add New Student",new ImageIcon("images/addnew.png"));
        pan.add(btnstudent);
        btnstudent.setBounds(40, 50, 200, 39);
        btnstudent.setFont(ft);
        btnstudent.setBackground(Color.BLUE);
        btnstudent.setForeground(Color.WHITE);
        btnstudent.addActionListener(this);

        btnteacher = new JButton("Add New Teacher",new ImageIcon("images/addnew.png"));
        pan.add(btnteacher);
        btnteacher.setBounds(40, 130, 200, 39);
        btnteacher.setFont(ft);
        btnteacher.setBackground(Color.BLUE);
        btnteacher.setForeground(Color.WHITE);
        btnteacher.addActionListener(this);

        setSize(280, 250);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocation(304, 200);
       // setLocationRelativeTo(null);
        setTitle("Add New Record");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new AddNew();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
  if (e.getSource() == btnstudent) {
            new NewStudent();
            this.dispose();
        }
          if (e.getSource() == btnteacher) {
            new NewTeacher();
            this.dispose();
        }
    }
}
