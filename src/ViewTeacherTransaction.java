////////////////////////////View Teacher Transaction Form/////////////////////////////////////////

import java.awt.event.*;
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class ViewTeacherTransaction extends JFrame implements ActionListener, KeyListener, FocusListener {

    JLabel jlapplelogo, jlmenu, jlmonth, jltview;
    JTextField jtsearch;
    JButton btnsearch, btndelete, btnrefresh;
    DBConnection1 dbc = new DBConnection1();
    JPanel panel = new JPanel(null);
    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model) {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;//To change body of generated methods, choose Tools | Templates.
        }

    };

    public ViewTeacherTransaction() {
        add(panel);
        panel.setBackground(Color.WHITE);
        Font ft1 = new Font("Roman", Font.BOLD, 17);
        Font ft2 = new Font("Roman", Font.PLAIN, 19);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        panel.add(jlapplelogo);
        jlapplelogo.setBounds(315, 5, 669, 140);

        jltview = new JLabel(new ImageIcon("images/viewt.png"));
        panel.add(jltview);
        jltview.setBounds(0, 148, 1400, 33);

        jlmonth = new JLabel("Sort  By  Month:");
        panel.add(jlmonth);
        jlmonth.setFont(ft1);
        jlmonth.setBounds(160, 205, 150, 40);

        jtsearch = new JTextField("Search");
        panel.add(jtsearch);
        jtsearch.setFont(ft2);
        jtsearch.setBounds(310, 205, 200, 38);
        jtsearch.setFont(ft2);
        jtsearch.addKeyListener(this);
        jtsearch.addFocusListener(this);

        btndelete = new JButton("Delete", new ImageIcon("images/delete.png"));
        panel.add(btndelete);
        btndelete.setFont(ft1);
        btndelete.setBackground(Color.WHITE);
        btndelete.setForeground(Color.RED);
        btndelete.setBounds(590, 205, 130, 38);
        btndelete.addActionListener(this);

        btnsearch = new JButton("Make Payment", new ImageIcon("images/makepayment.png"));
        panel.add(btnsearch);
        btnsearch.setFont(ft1);
        btnsearch.setBounds(753, 205, 180, 38);
        btnsearch.setBackground(Color.WHITE);
        btnsearch.setForeground(Color.BLUE);
        btnsearch.addActionListener(this);

        btnrefresh = new JButton("Refresh", new ImageIcon("images/refresh.png"));
        panel.add(btnrefresh);
        btnrefresh.setFont(ft1);
        btnrefresh.setBackground(Color.WHITE);
        btnrefresh.setForeground(Color.BLUE);
        btnrefresh.setBounds(953, 205, 130, 36);
        btnrefresh.addActionListener(this);

        table.getTableHeader().setReorderingAllowed(false);
        model.addColumn("Teacher Id");
        model.addColumn(" Name");
        model.addColumn("Month");
        model.addColumn("Total Salary");
        model.addColumn("Deducted Amount");
        model.addColumn("Amount Paid");
        model.addColumn("Advanced Payment");
        model.addColumn("Date_Of_Payment");
        model.addColumn("Paid Status");
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp = new JScrollPane(table, v, h);
        panel.add(jsp);
        jsp.setBounds(15, 265, 1337, 600);
        table.getTableHeader().setFont(new Font("Roman", Font.BOLD, 15));
        table.setRowHeight(30);
        table.getTableHeader().setPreferredSize(new Dimension(0, 33));
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(50);
        table.getColumnModel().getColumn(6).setPreferredWidth(50);
        table.getColumnModel().getColumn(7).setPreferredWidth(50);
        table.getColumnModel().getColumn(8).setPreferredWidth(30);

        /////////////////reordering of the table column is set false//////////////////////////////////// 
        for (int i = 0; i < model.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
        }

        DisplayData();

        setSize(1000, 900);
        setLocationRelativeTo(null);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("APPLE  ACADEMY - View  Teacher  Transaction");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        //new ViewTeacherTransaction();
    }

    public void DisplayData() {
        try {
            model.setRowCount(0);
            stmt = dbc.cn.createStatement();
            rs = stmt.executeQuery("select * from teachertran");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("teacher_id"), rs.getString("fname") + "  " + rs.getString("lname") + "  " + rs.getString("mname"), rs.getString("month"), rs.getString("salary"), rs.getString("deducted_amount"), rs.getString("paid_amount"), rs.getString("advanced_amount"), rs.getString("Date_of_payment"), rs.getString("paid")});
            }
        } catch (Exception ex) {
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnsearch) {
             if (!table.isRowSelected(table.getSelectedRow())) {
                JOptionPane.showMessageDialog(null, "Please select teacher to make payment !!", "Making Payment Error ", JOptionPane.ERROR_MESSAGE);
           }
             else{
            int tid = Integer.parseInt(model.getValueAt(table.getSelectedRow(), 0).toString());
            PresentDays pd = new PresentDays(tid);
            this.dispose();
        }
        }

        if (e.getSource() == btndelete) {
             if (!table.isRowSelected(table.getSelectedRow())) {
                JOptionPane.showMessageDialog(null, "Please select teacher transaction to delete !!", "Deleting Transaction Error ", JOptionPane.ERROR_MESSAGE);
           }
             else{
            try {
                pstmt = dbc.cn.prepareStatement("delete from teachertran where teacher_id=?");
                pstmt.setInt(1, Integer.parseInt(model.getValueAt(table.getSelectedRow(), 0).toString()));
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Deleted !");
                DisplayData();
            } catch (Exception ex) {
            }
        }
        }
        if (e.getSource() == btnrefresh) {
            DisplayData();
            jtsearch.setText("Search");

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
        if (e.getSource() == jtsearch) {
            searchData();
        }
    }

    public void searchData() {
        try {
            model.setRowCount(0);
            pstmt = dbc.cn.prepareStatement("select * from teachertran where month like ?");
            pstmt.setString(1, jtsearch.getText() + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{model.getRowCount() + 1, rs.getString("fname") + " " + rs.getString("mname") + " " + rs.getString("lname"), rs.getString("month"), rs.getString("salary"), rs.getString("deducted_amount"), rs.getString("paid_amount"), rs.getString("advanced_amount"), rs.getString("Date_of_payment"), rs.getString("paid")});
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == jtsearch) {
            jtsearch.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == jtsearch) {
            if (jtsearch.getText().trim().length() == 0) {
                jtsearch.setText("Search");
            }
        }
    }
}
