////////////////////////////View Teacher Form/////////////////////////////////////////

import java.awt.event.*;
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class AdminViewTeacher extends JFrame implements ActionListener, KeyListener, FocusListener {

    JPanel panel = new JPanel();
    JLabel jlapplelogo, jlviewtch, transactionBar, jlmenu, sortby;
    JTextField txtsortby;
    JComboBox cbsortby;
    JButton btndelete, btnedit, btnrefresh;
    Statement stmt;
    ResultSet rs;
    PreparedStatement pstmt;
    DBConnection1 dbc = new DBConnection1();
    Font ft = new Font("Roman", Font.BOLD, 17);
    Font ft1 = new Font("Roman", Font.PLAIN, 19);
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; //To change body of generated methods, choose Tools | Templates.
        }
    };

    public AdminViewTeacher() {

        add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        panel.add(jlapplelogo);
        jlapplelogo.setBounds(315, 5, 669, 140);

        jlviewtch = new JLabel(new ImageIcon("images/trecord.png"));
        panel.add(jlviewtch);
        jlviewtch.setBounds(0, 155, 1400, 33);

        sortby = new JLabel("Sort By:");
        panel.add(sortby);
        sortby.setFont(ft);
        sortby.setBounds(170, 213, 120, 40);

        cbsortby = new JComboBox();
        panel.add(cbsortby);
        cbsortby.setBounds(260, 213, 200, 35);
        cbsortby.addItem("");
        cbsortby.addItem("Teacher_Id");
        cbsortby.addItem("First Name");
        cbsortby.addItem("Last Name");
        cbsortby.addItem("Gender");
        cbsortby.addItem("Level");
        cbsortby.addItem("Subject");
        cbsortby.addItem("Type");
        cbsortby.addActionListener(this);

        txtsortby = new JTextField("Search");
        panel.add(txtsortby);
        txtsortby.setBounds(530, 210, 350, 40);
        txtsortby.setEnabled(false);
        txtsortby.setFont(ft1);
        txtsortby.setForeground(Color.GRAY);
        txtsortby.addKeyListener(this);

        txtsortby.addFocusListener(this);

        btnrefresh = new JButton("Refresh", new ImageIcon("images/refresh.png"));
        panel.add(btnrefresh);
        btnrefresh.setFont(ft);
        btnrefresh.setBackground(Color.WHITE);
        btnrefresh.setForeground(Color.BLUE);
        btnrefresh.setBounds(953, 210, 150, 38);
        btnrefresh.addActionListener(this);

        table.getTableHeader().setReorderingAllowed(false);
        model.addColumn("Teacher Id");
        model.addColumn(" Name");
        model.addColumn("Gender");
        model.addColumn("Address");
        model.addColumn("Qualification");
        model.addColumn("Level");
        model.addColumn("Subject");
        model.addColumn(" Job Type");
        model.addColumn("Salary");
        model.addColumn("Phone");
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp = new JScrollPane(table, v, h);
        panel.add(jsp);
        jsp.setBounds(15, 280, 1337, 600);
        table.getTableHeader().setFont(new Font("Roman", Font.BOLD, 15));
        table.setRowHeight(30);
        table.getTableHeader().setPreferredSize(new Dimension(0, 33));
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(35);
        table.getColumnModel().getColumn(3).setPreferredWidth(65);
        table.getColumnModel().getColumn(4).setPreferredWidth(55);
        table.getColumnModel().getColumn(5).setPreferredWidth(50);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.getColumnModel().getColumn(7).setPreferredWidth(80);
        table.getColumnModel().getColumn(8).setPreferredWidth(50);
        table.getColumnModel().getColumn(9).setPreferredWidth(90);

        /////////////////reordering of the table column is set false//////////////////////////////////// 
        for (int i = 0; i < model.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
        }

        DisplayData();
        txtsortby.setEnabled(false);
        setSize(1000, 900);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setTitle("APPLE  ACADEMY - Teachers  Record");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new AdminViewTeacher();
    }

    public void DisplayData() {
        try {
            model.setRowCount(0);
            stmt = dbc.cn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM teacher");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("teacher_id"), rs.getString("fname") + " " + rs.getString("mname") + " " + rs.getString("lname"), rs.getString("gender"), rs.getString("address"), rs.getString("qualification"), rs.getString("level"), rs.getString("subject"), rs.getString("type"), rs.getInt("salary"), rs.getString("phone")});
            }
        } catch (Exception ex) {
            // JOptionPane.showMessageDialog(null,ex);
        }
//catch(ClassNotFoundException exx){}

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
                    case "Teacher_Id":
                        col = "teacher_id";
                        break;

                    case "First Name":
                        col = "fname";
                        break;

                    case "Last Name":
                        col = "lname";
                        break;

                    case "Qualification":
                        col = "qualification";
                        break;

                    case "Address":
                        col = "address";
                        break;

                    case "Gender":
                        col = "gender";
                        break;

                    case "Level":
                        col = "level";
                        break;

                    case "Subject":
                        col = "subject";
                        break;

                    case "Salary":
                        col = "salary";
                        break;

                    case "Type":
                        col = "type";
                        break;

                    case "Phone":
                        col = "phone";
                        break;

                }
                model.setRowCount(0);
                pstmt = dbc.cn.prepareStatement("select * from teacher where " + col + " like ?");
                pstmt.setString(1, txtsortby.getText() + "%");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    model.addRow(new Object[]{rs.getString("teacher_id"), rs.getString("fname") + " " + rs.getString("mname") + " " + rs.getString("lname"), rs.getString("gender"), rs.getString("address"), rs.getString("qualification"), rs.getString("level"), rs.getString("subject"), rs.getString("type"), rs.getInt("salary"), rs.getString("phone")});
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
