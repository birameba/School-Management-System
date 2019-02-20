
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class ViewRecords extends JDialog implements ActionListener {

    JButton btnstudent, btnteacher;
    JTable table;
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane jsp;
    JPanel pan = new JPanel();
  
    public ViewRecords() {

        table = new JTable(model);
        Font ft = new Font("", Font.BOLD, 16);
      
        add(pan);
        pan.setLayout(null);
        pan.setBackground(Color.WHITE);


        btnstudent = new JButton("View Student Records",new ImageIcon("images/viewrecord1.png"));
        pan.add(btnstudent);
        btnstudent.setBounds(30, 50, 230, 39);
        btnstudent.setFont(ft);
        btnstudent.setBackground(Color.BLUE);
        btnstudent.setForeground(Color.WHITE);
        btnstudent.addActionListener(this);

        btnteacher = new JButton("View Teacher Records",new ImageIcon("images/viewrecord1.png"));
        pan.add(btnteacher);
        btnteacher.setBounds(30, 130, 230, 39);
        btnteacher.setFont(ft);
        btnteacher.setBackground(Color.BLUE);
        btnteacher.setForeground(Color.WHITE);
        btnteacher.addActionListener(this);

        setSize(300, 250);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocation(304, 215);
        //setLocationRelativeTo(null);
        setTitle("View Records");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        //new ViewRecords();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
  if (e.getSource() == btnstudent) {
            new ViewStudent();
            this.dispose();
        }
          if (e.getSource() == btnteacher) {
            new ViewTeacher();
            this.dispose();
        }
    }
}
