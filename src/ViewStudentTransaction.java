////////////////////////////View Student Transaction Form/////////////////////////////////////////

import java.awt.event.*;
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class ViewStudentTransaction extends JFrame implements ActionListener, KeyListener,  FocusListener {

    JLabel jlapplelogo, jlstran, jlsort;
    JTextField txtsortby;
    JButton btnsearch, btnupdate, btndelete,btnrefresh;
    JComboBox cbsortby;
    DBConnection1 dbc = new DBConnection1();
    JPanel panel = new JPanel(null);
    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;
    Font ft = new Font("Roman", Font.BOLD, 17);
    Font ft1 = new Font("Roman", Font.PLAIN, 19);
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model) {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;//To change body of generated methods, choose Tools | Templates.
        }

    };

    public ViewStudentTransaction() {

        add(panel);
        panel.setBackground(Color.WHITE);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        panel.add(jlapplelogo);
        jlapplelogo.setBounds(315, 5, 669, 140);

        jlstran = new JLabel(new ImageIcon("images/viewst.png"));
        panel.add(jlstran);
        jlstran.setBounds(0, 148, 1400, 33);

        jlsort = new JLabel("Sort  By :");
        panel.add(jlsort);
        jlsort.setFont(ft);
        jlsort.setBounds(40, 210, 120, 38);

        cbsortby = new JComboBox();
        panel.add(cbsortby);
        cbsortby.setBounds(140, 210, 200, 35);
        cbsortby.addItem("");
        cbsortby.addItem("Student ID");
        cbsortby.addItem("First Name");
        cbsortby.addItem("Last Name");
        cbsortby.addItem("Class");
        cbsortby.addItem("Roll No.");
        cbsortby.addActionListener(this);

        txtsortby = new JTextField("Search");
        panel.add(txtsortby);
        txtsortby.setBounds(380, 210, 280, 40);
        txtsortby.setEnabled(false);
        txtsortby.setFont(ft1);
        txtsortby.setForeground(Color.GRAY);
        txtsortby.addKeyListener(this);
       
        txtsortby.addFocusListener(this);

         btndelete = new JButton("Delete",new ImageIcon("images/delete.png"));
        panel.add(btndelete);
        btndelete.setFont(ft);
        btndelete.setBackground(Color.WHITE);
        btndelete.setForeground(Color.RED);
        btndelete.setBounds(715, 210, 130, 38);
        btndelete.addActionListener(this);

        btnupdate = new JButton("Make Payment",new ImageIcon("images/makepayment.png"));
        panel.add(btnupdate);
        btnupdate.setFont(ft);
        btnupdate.setBackground(Color.WHITE);
        btnupdate.setForeground(Color.BLUE);
        btnupdate.setBounds(870, 210, 185, 38);
        btnupdate.addActionListener(this);
        
          btnrefresh = new JButton("Refresh",new ImageIcon("images/refresh.png"));
        panel.add(btnrefresh);
        btnrefresh.setFont(ft);
        btnrefresh.setBackground(Color.WHITE);
        btnrefresh.setForeground(Color.BLUE);
        btnrefresh.setBounds(1085, 210, 130, 38);
        btnrefresh.addActionListener(this);

        table.getTableHeader().setReorderingAllowed(false);
        model.addColumn("Student Id");
        model.addColumn(" Student Name");
        model.addColumn("Class");
        model.addColumn("Roll No.");
        model.addColumn("<html>Admission<br> Amount</html>");
        model.addColumn("<html>Admission<br> Status</html>");
        model.addColumn("<html>Monthly <br>Fee</html>");
        model.addColumn("<html>Paid <br>Amount</html>");
        model.addColumn("Paid Duration");
        model.addColumn("<html>Balance<br> Due</html>");
        model.addColumn("<html>computer<br> Lab Fee</html>");
        model.addColumn("<html>Lab Fee<br> Status</html>");
        model.addColumn("Extra Fees");
        model.addColumn("<html>Extra Fees <br>Status</html>");
        model.addColumn("Date of Payment");
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp = new JScrollPane(table, v, h);
        panel.add(jsp);
        jsp.setBounds(15, 265, 1337, 600);
        table.getTableHeader().setFont(new Font("Roman", Font.BOLD, 12));
        table.setRowHeight(30);
        table.getTableHeader().setPreferredSize(new Dimension(0, 33));
        table.getColumnModel().getColumn(0).setPreferredWidth(42);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(29);
        table.getColumnModel().getColumn(3).setPreferredWidth(25);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(33);
        table.getColumnModel().getColumn(6).setPreferredWidth(44);
        table.getColumnModel().getColumn(7).setPreferredWidth(45);
        table.getColumnModel().getColumn(8).setPreferredWidth(120);
        table.getColumnModel().getColumn(9).setPreferredWidth(35);
        table.getColumnModel().getColumn(10).setPreferredWidth(35);
        table.getColumnModel().getColumn(11).setPreferredWidth(47);
        table.getColumnModel().getColumn(12).setPreferredWidth(145);
        table.getColumnModel().getColumn(13).setPreferredWidth(43);
        table.getColumnModel().getColumn(14).setPreferredWidth(76);

        /////////////////reordering of the table column is set false//////////////////////////////////// 
        for (int i = 0; i < model.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
        }

        DisplayData();

        setSize(1000, 900);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("APPLE  ACADEMY-Veiw Student  Transaction");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }

        //new ViewStudentTransaction();
    }

    public void DisplayData() {
        try {
            model.setRowCount(0);
            DBConnection1 dbc = new DBConnection1();
            stmt = dbc.cn.createStatement();
            rs = stmt.executeQuery("SELECT *  FROM studenttran");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("student_id"), rs.getString("fname") + " " + rs.getString("mname") + " " + rs.getString("lname"), rs.getString("class"), rs.getInt("roll_no"), rs.getInt("admission"), rs.getBoolean("admission_sts"), rs.getInt("monthly_fee"), rs.getInt("paid_amt"), rs.getString("paid_upto"), rs.getDouble("balance_due"), rs.getInt("computer_lab"), rs.getBoolean("lab_sts"), rs.getString("extra_amt"), rs.getBoolean("extra_paid"), rs.getString("date_of_payment")});
            }
        } catch (Exception ex) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cbsortby) {
            if (!(cbsortby.getSelectedItem().equals(""))){
                DisplayData();
               txtsortby.setEnabled(true);
            }
          else if(cbsortby.getSelectedItem().equals("")){
               txtsortby.setText("Search");
           txtsortby.setEnabled(false);
           }

        }
        if(e.getSource()==btnrefresh){
         DisplayData();
           cbsortby.setSelectedItem("");
            txtsortby.setText("Search");
        }

        if (e.getSource() == btnupdate) {
             if (!table.isRowSelected(table.getSelectedRow())) {
                JOptionPane.showMessageDialog(null, "Please select student to make payment !!", "Making Payment Error ", JOptionPane.ERROR_MESSAGE);
           }
             else{
            int sid = Integer.parseInt(model.getValueAt(table.getSelectedRow(), 0).toString());
            IndirectStudentTransaction tt = new IndirectStudentTransaction(sid);
            this.dispose();
        }
        }
        if (e.getSource() == btndelete) {
             if (!table.isRowSelected(table.getSelectedRow())) {
                JOptionPane.showMessageDialog(null, "Please select student transaction to delete !!", "Deleting Transaction Error ", JOptionPane.ERROR_MESSAGE);
           }
             else{
            try {
                pstmt = dbc.cn.prepareStatement("delete from studenttran where student_id=?");
                pstmt.setInt(1, Integer.parseInt(model.getValueAt(table.getSelectedRow(), 0).toString()));
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Deleted !");
                DisplayData();
            } catch (Exception ex) {
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
                switch (cbsortby.getSelectedItem().toString()) {
                    case "Student ID":
                        col = "student_id";
                        break;

                    case "First Name":
                        col = "fname";
                        break;

                    case "Last Name":
                        col = "lname";
                        break;

                    case "Class":
                        col = "class";
                        break;

                    case "Roll No.":
                        col = "roll_no";
                        break;

                }
                model.setRowCount(0);
                pstmt = dbc.cn.prepareStatement("select * from studenttran where " + col + " like ?");
                pstmt.setString(1, txtsortby.getText() + "%");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    model.addRow(new Object[]{rs.getString("student_id"), rs.getString("fname") + " " + rs.getString("mname") + " " + rs.getString("lname"), rs.getString("class"), rs.getInt("roll_no"), rs.getInt("admission"), rs.getBoolean("admission_sts"), rs.getInt("monthly_fee"), rs.getInt("paid_amt"), rs.getString("paid_upto"), rs.getDouble("balance_due"), rs.getInt("computer_lab"), rs.getBoolean("lab_sts"), rs.getString("extra_amt"), rs.getBoolean("extra_paid"), rs.getString("date_of_payment")});
                }
            } catch (Exception ex) {
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
        }
    }

}
