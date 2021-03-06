/////////////////////////Displaying the marks of overall students from class 9 and 10//////////////////////////////////////
import java.awt.event.*;
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class ClassDisplay910 extends JFrame implements ActionListener, KeyListener, FocusListener {

    JPanel panel = new JPanel();
    JLabel jlapplelogo, jlviews, jlmenu, sortby;
    JTextField txtsortby;
    JComboBox cbsortby;
    JButton btnedit, btndelete, btnrefresh;
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model) {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    DBConnection1 db = new DBConnection1();
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    String s, c;
    int st;
     Font ft=new Font("Roman",Font.BOLD,17);
      Font ft1=new Font("Roman",Font.PLAIN,19);
    public ClassDisplay910(String grade) {
        c = grade;
        add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        panel.add(jlapplelogo);
        jlapplelogo.setBounds(315, 5, 669, 140);

        jlviews = new JLabel(new ImageIcon("images/overallclassmarks.png"));
        panel.add(jlviews);
        jlviews.setBounds(0, 148, 1400, 33);

       sortby = new JLabel("Sort By:");
        panel.add(sortby);
        sortby.setFont(new Font("Roman", Font.BOLD, 18));
        sortby.setBounds(160, 200, 120, 38);

        cbsortby = new JComboBox();
        panel.add(cbsortby);
        cbsortby.setBounds(263, 200, 195, 38);
        cbsortby.addItem("");
        cbsortby.addItem("Student ID");
        cbsortby.addItem("Terminal");
        cbsortby.addActionListener(this);

        txtsortby = new JTextField("Search");
        panel.add(txtsortby);
        txtsortby.setFont(ft1);
        txtsortby.setEnabled(false);
        txtsortby.setBounds(488, 200, 250, 40);
        txtsortby.addKeyListener(this);
        txtsortby.addFocusListener(this);

        btndelete = new JButton("Delete",new ImageIcon("images/delete.png"));
        panel.add(btndelete);
        btndelete.setFont(ft1);
        btndelete.setBackground(Color.WHITE);
        btndelete.setForeground(Color.RED);
        btndelete.setBounds(850, 200, 120, 38);
        btndelete.addActionListener(this);

         btnrefresh = new JButton("Refresh",new ImageIcon("images/refresh.png"));
        panel.add(btnrefresh);
        btnrefresh.setFont(ft1);
        btnrefresh.setBackground(Color.WHITE);
        btnrefresh.setForeground(Color.BLUE);
        btnrefresh.setBounds(995, 200, 120, 38);
        btnrefresh.addActionListener(this);

        model.addColumn("Student Id");
        model.addColumn("Terminal");
        model.addColumn("English Th.");
        model.addColumn("English Pr.");
        model.addColumn("Nepali");
        model.addColumn("Com. Maths");
        model.addColumn("Science Th.");
        model.addColumn("Science Pr.");
        model.addColumn("Social Studies");
        model.addColumn("EPH Theory");
        model.addColumn("EPH Practical");
        model.addColumn("Computer Th.");
        model.addColumn("Computer Pr.");
        model.addColumn("Opt. Maths");
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp = new JScrollPane(table, v, h);
        panel.add(jsp);
        jsp.setBounds(15, 250, 1337, 600);
        table.getTableHeader().setFont(new Font("Roman", Font.BOLD, 12));
        table.setRowHeight(26);
        table.getTableHeader().setPreferredSize(new Dimension(0, 33));
        table.getColumnModel().getColumn(0).setPreferredWidth(33);
        table.getColumnModel().getColumn(1).setMinWidth(145);
        table.getColumnModel().getColumn(2).setPreferredWidth(35);
        table.getColumnModel().getColumn(3).setPreferredWidth(38);
        table.getColumnModel().getColumn(4).setPreferredWidth(52);
        table.getColumnModel().getColumn(5).setPreferredWidth(45);
        table.getColumnModel().getColumn(6).setPreferredWidth(45);
        table.getColumnModel().getColumn(7).setPreferredWidth(45);
        table.getColumnModel().getColumn(8).setPreferredWidth(52);
        table.getColumnModel().getColumn(9).setPreferredWidth(43);
        table.getColumnModel().getColumn(10).setPreferredWidth(43);
        table.getColumnModel().getColumn(11).setPreferredWidth(45);
        table.getColumnModel().getColumn(12).setPreferredWidth(45);
        table.getColumnModel().getColumn(13).setPreferredWidth(45);

        /////////////////reordering of the table column is set false//////////////////////////////////// 
        for (int i = 0; i < model.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
        }
        DisplayData();

        setSize(1000, 900);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setTitle("APPLE  ACADEMY-Veiw Student Result");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        //new ClassDisplay910("Nine");
    }

    //////////////////////////Getting all marks from the grade table ////////////////////////////////////////////
    public void DisplayData() {
        try {
            model.setRowCount(0);
            stmt = db.cn.createStatement();
            rs = stmt.executeQuery("SELECT *  FROM " + c + "");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("sid"), rs.getString("terminal"), rs.getString("Compulsory_English"), rs.getString("English_Practical"), rs.getString("Compulsory_Nepali"), rs.getString("Compulsory_Mathematics"), rs.getString("Science"), rs.getString("Science_Practical"), rs.getString("Social_Studies"), rs.getString("Health_POP_ENV_EDU"), rs.getString("Health_POP_ENV_Practical"), rs.getString("Computer"), rs.getString("Computer_Practical"), rs.getString("Optional_Mathematics")});
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
     if (e.getSource() == cbsortby) {
            if (!(cbsortby.getSelectedItem().equals(""))) {
                DisplayData();
                txtsortby.setEnabled(true);
            } else if (cbsortby.getSelectedItem().equals("")) {
                txtsortby.setText("Search");
                txtsortby.setEnabled(false);
            }
        }
        if (e.getSource() == btnrefresh) {
             DisplayData();
           cbsortby.setSelectedItem("");
            txtsortby.setText("Search");
        }
        if (e.getSource() == btndelete) {
            if (!table.isRowSelected(table.getSelectedRow())) {
                JOptionPane.showMessageDialog(null, "Please select student to delete record !!", "Data Deleting Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    pstmt = db.cn.prepareStatement("delete from " + c + " where sid=?");
                    pstmt.setInt(1, Integer.parseInt(model.getValueAt(table.getSelectedRow(), 0).toString()));
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Deleted !");
                    DisplayData();
                } catch (Exception exx) {
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == txtsortby) {
            try {
                String col = null;
                switch (cbsortby.getSelectedIndex()) {
                    case 1:
                        col = "sid";
                        break;

                    case 2:
                        col = "terminal";
                        break;
                }

                model.setRowCount(0);
                pstmt = db.cn.prepareStatement("select * from " + c + " where " + col + " like ?");
                pstmt.setString(1, txtsortby.getText() + "%");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    model.addRow(new Object[]{rs.getString("sid"), rs.getString("terminal"), rs.getString("Compulsory_English"), rs.getString("English_Practical"), rs.getString("Compulsory_Nepali"), rs.getString("Compulsory_Mathematics"), rs.getString("Science"), rs.getString("Science_Practical"), rs.getString("Social_Studies"), rs.getString("Health_POP_ENV_EDU"), rs.getString("Health_POP_ENV_Practical"), rs.getString("Computer"), rs.getString("Computer_Practical"), rs.getString("Optional_Mathematics")});
                }
            } catch (Exception exx) {
                exx.printStackTrace();
            }
        }
    }

 

    @Override
    public void focusGained(FocusEvent e) {
   if (e.getSource() == txtsortby) {
            txtsortby.setText("");
        }  
    }

    @Override
    public void focusLost(FocusEvent e) {
if (e.getSource() == txtsortby) {
            if (txtsortby.getText().trim().length() == 0) {
                txtsortby.setText("Search");
            }
        }        }
}
