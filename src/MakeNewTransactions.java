
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class MakeNewTransactions extends JDialog implements ActionListener {

    JButton btnstudent, btnteacher;
    JTable table;
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane jsp;
    JPanel pan = new JPanel();
  
    public MakeNewTransactions() {

        table = new JTable(model);
        Font ft = new Font("", Font.BOLD, 16);
      
        add(pan);
        pan.setLayout(null);
        pan.setBackground(Color.WHITE);


        btnstudent = new JButton("Make Student Transaction", new ImageIcon("images/addnew.png"));
        pan.add(btnstudent);
        btnstudent.setBounds(40, 50, 260, 39);
        btnstudent.setFont(ft);
        btnstudent.setBackground(Color.BLUE);
        btnstudent.setForeground(Color.WHITE);
        btnstudent.addActionListener(this);

        btnteacher = new JButton("Make Teacher Transaction",new ImageIcon("images/addnew.png"));
        pan.add(btnteacher);
        btnteacher.setBounds(40, 130, 260, 39);
        btnteacher.setFont(ft);
        btnteacher.setBackground(Color.BLUE);
        btnteacher.setForeground(Color.WHITE);
        btnteacher.addActionListener(this);

        setSize(334, 250);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocation(304, 200);
       // setLocationRelativeTo(null);
        setTitle("Making Transactions");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new MakeNewTransactions();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
  if (e.getSource() == btnstudent) {
            new AskId();
            this.dispose();
        }
  
          if (e.getSource() == btnteacher) {
            new AskIdTeacher();
           this.dispose();
        }
    }
    
}
