
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class ViewTransactions extends JDialog implements ActionListener {

    JButton btnstudent, btnteacher;
    JTable table;
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane jsp;
    JPanel pan = new JPanel();
  
    public ViewTransactions() {

        table = new JTable(model);
        Font ft = new Font("", Font.BOLD, 16);
      
        add(pan);
        pan.setLayout(null);
        pan.setBackground(Color.WHITE);


        btnstudent = new JButton("View Student Transactions");
        pan.add(btnstudent);
        btnstudent.setBounds(40, 50, 240, 39);
        btnstudent.setFont(ft);
        btnstudent.setBackground(Color.BLUE);
        btnstudent.setForeground(Color.WHITE);
        btnstudent.addActionListener(this);

        btnteacher = new JButton("View Teacher Transactions");
        pan.add(btnteacher);
        btnteacher.setBounds(40, 130, 240, 39);
        btnteacher.setFont(ft);
        btnteacher.setBackground(Color.BLUE);
        btnteacher.setForeground(Color.WHITE);
        btnteacher.addActionListener(this);

        setSize(334, 250);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocation(304, 210);
//        setLocationRelativeTo(null);
        setTitle("View Transactions");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        //new ViewTransactions();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
  if (e.getSource() == btnstudent) {
            new ViewStudentTransaction();
            this.dispose();
        }
          if (e.getSource() == btnteacher) {
            new ViewTeacherTransaction();
            this.dispose();
        }
    }
}
