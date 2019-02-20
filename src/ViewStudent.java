 ////////////////////////////View Student Form/////////////////////////////////////////
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ViewStudent extends JFrame implements ActionListener, KeyListener,FocusListener {
     String c,grade;
    JPanel panel = new JPanel();
    JLabel jlapplelogo, jlviews, jlmenu, sortby;
    JTextField txtsortby;
    JComboBox cbsortby;
    JButton btnedit, btndelete, btnview, btnrefresh,btngrade;
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
     Font ft2=new Font("Roman",Font.PLAIN,19);
    Font ft=new Font("Roman",Font.BOLD,17);
    Font ft1=new Font("Roman",Font.BOLD,16);
    
    public ViewStudent() {
         
        add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        panel.add(jlapplelogo);
        jlapplelogo.setBounds(315, 5, 669, 140);

        jlviews = new JLabel(new ImageIcon("images/srecord.png"));
        panel.add(jlviews);
        jlviews.setBounds(0, 148, 1400, 33);

        sortby = new JLabel("Sort By:");
        panel.add(sortby);
        sortby.setFont(ft);
        sortby.setBounds(42, 215, 120, 38);

        cbsortby = new JComboBox();
        panel.add(cbsortby);
        cbsortby.setBounds(143, 215, 185, 38);
        cbsortby.addItem("");
        cbsortby.addItem("Student ID");
        cbsortby.addItem("First Name");
        cbsortby.addItem("Last Name");
        cbsortby.addItem("Class");
        cbsortby.addItem("Roll No.");
        cbsortby.addItem("Address");
        cbsortby.addItem("Gender");
        cbsortby.addItem("House Group");
        cbsortby.addItem("Nationality");
        cbsortby.addActionListener(this);

        txtsortby=new JTextField("Search");
       // txtsortby = new JTextField("Search",new ImageIcon("images/searchicon.png"));
        panel.add(txtsortby);
       // txtsortby.setEditable();
        txtsortby.setFont(ft2);
        txtsortby.setBounds(365, 215, 250, 40);
        txtsortby.addKeyListener(this);
       
        txtsortby.addActionListener(this);
        txtsortby.addFocusListener(this);

        btnedit = new JButton("Edit",new ImageIcon("images/edit.png"));
        panel.add(btnedit);
        btnedit.setFont(ft);
        btnedit.setBackground(Color.WHITE);
        btnedit.setForeground(Color.BLUE);
        btnedit.setBounds(730, 215, 110, 38);
        btnedit.addActionListener(this);
       
        btndelete = new JButton("Delete",new ImageIcon("images/delete.png"));
        panel.add(btndelete);
        btndelete.setFont(ft);
        btndelete.setBackground(Color.WHITE);
        btndelete.setForeground(Color.RED);
        btndelete.setBounds(870, 215, 120, 38);
        btndelete.addActionListener(this);

        btnview = new JButton("View Marks",new ImageIcon("images/viewrecord.png"));
        panel.add(btnview);
        btnview.setFont(ft1);
        btnview.setBackground(Color.WHITE);
        btnview.setForeground(Color.BLUE);
        btnview.setBounds(1020, 215, 150, 38);
        btnview.addActionListener(this);
        
          btngrade = new JButton("View Grade",new ImageIcon("images/viewgrades.png"));
        panel.add(btngrade);
        btngrade.setFont(ft1);
        btngrade.setBackground(Color.WHITE);
        btngrade.setForeground(Color.BLUE);
        btngrade.setBounds(1195, 215, 153, 38);
        btngrade.addActionListener(this);

        btnrefresh = new JButton(new ImageIcon("images/refresh.png"));
        panel.add(btnrefresh);
        btnrefresh.setFont(ft);
        btnrefresh.setBackground(Color.WHITE);
        btnrefresh.setForeground(Color.BLUE);
        btnrefresh.setBounds(638, 215, 60, 40);
        btnrefresh.addActionListener(this);

        table.getTableHeader().setReorderingAllowed(false);
        model.addColumn("Student Id");
        model.addColumn(" Student Name");
        model.addColumn("Roll No.");
        model.addColumn("Gender");
        model.addColumn("Date_of_Birth");
        model.addColumn("Class");
        model.addColumn("House Group");
        model.addColumn("Address");
        model.addColumn("Guardian Name");
        model.addColumn("Mobile");
        model.addColumn("Phone");
        model.addColumn("Nationality");
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp = new JScrollPane(table, v, h);
        panel.add(jsp);
        jsp.setBounds(15, 275, 1337, 600);
        table.getTableHeader().setFont(new Font("Roman", Font.BOLD, 15));
        table.setRowHeight(30);
          table.getTableHeader().setPreferredSize(new Dimension(0, 33));
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setMinWidth(180);
        table.getColumnModel().getColumn(2).setPreferredWidth(25);
        table.getColumnModel().getColumn(3).setPreferredWidth(30);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);
        table.getColumnModel().getColumn(5).setPreferredWidth(25);
        table.getColumnModel().getColumn(6).setPreferredWidth(60);
        table.getColumnModel().getColumn(7).setPreferredWidth(60);
        table.getColumnModel().getColumn(8).setPreferredWidth(120);
        table.getColumnModel().getColumn(9).setPreferredWidth(42);
        table.getColumnModel().getColumn(10).setPreferredWidth(42);
        table.getColumnModel().getColumn(11).setPreferredWidth(40);
        
          /////////////////reordering of the table column is set false//////////////////////////////////// 
        for(int i=0;i<model.getColumnCount();i++){
         table.getColumnModel().getColumn(i).setResizable(false);
        }
        
        DisplayData();
         txtsortby.setEnabled(false);
        setSize(1000, 900);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setTitle("APPLE  ACADEMY-View Student");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new ViewStudent();
    }

    public void DisplayData() {
        try {
            model.setRowCount(0);
            stmt = db.cn.createStatement();
            rs = stmt.executeQuery("SELECT *  FROM record");
            while (rs.next()) {

                model.addRow(new Object[]{rs.getString("student_id"), rs.getString("fname") + "  " + rs.getString("mname") + "  " + rs.getString("lname"), rs.getInt("roll_no"), rs.getString("gender"), rs.getString("DOB"), rs.getString("class"), rs.getString("sc_home"), rs.getString("address"), rs.getString("guardian"), rs.getString("mobile"), rs.getString("phone"), rs.getString("nationality")});

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
           
        
        if (e.getSource() == btndelete) {
            if (!table.isRowSelected(table.getSelectedRow())) {
                JOptionPane.showMessageDialog(null, "Please select student to delete record !!", "Data Deleting Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    pstmt = db.cn.prepareStatement("delete from record where student_id=?");
                    pstmt.setInt(1, Integer.parseInt(model.getValueAt(table.getSelectedRow(), 0).toString()));
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Deleted !");
                    DisplayData();
                } catch (Exception exx) {
                }
            }
        }

        if (e.getSource() == btnedit) {
            if (!table.isRowSelected(table.getSelectedRow())) {
                JOptionPane.showMessageDialog(null, "Please select student data to edit !!", "Editing Information Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int sid = Integer.parseInt(model.getValueAt(table.getSelectedRow(), 0).toString());
                EditTable ns = new EditTable(sid);
                this.dispose();
            }
        }
        if (e.getSource() == btnview) {
            if (!table.isRowSelected(table.getSelectedRow())) {
                JOptionPane.showMessageDialog(null, "Please select student to view result !!", "Viewing Result Error ", JOptionPane.ERROR_MESSAGE);
           }
             else {
               int sid = Integer.parseInt(model.getValueAt(table.getSelectedRow(), 0).toString());             
                try {
                    pstmt = db.cn.prepareStatement("select class from record where student_id=?");
                    pstmt.setInt(1, sid);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                        c = rs.getString(1);
                    }
               
                } catch (Exception ex) {
                }
              if(c.equals("Seven")){
                  grade="seven";
              SevenDisplay n1=new SevenDisplay(grade,sid);
              }
               else if(c.equals("Six")){
                  grade="six";
              SixSevenDisplay n1=new SixSevenDisplay(grade,sid);
              }
                else if(c.equals("Five")){
                  grade="five";
              OneToFiveDisplay n5=new OneToFiveDisplay(grade,sid);
              }
                  else if(c.equals("Four")){
                  grade="four";
              OneToFiveDisplay n5=new OneToFiveDisplay(grade,sid);
              }
                    else if(c.equals("Three")){
                  grade="three";
              OneToFiveDisplay n5=new OneToFiveDisplay(grade,sid);
              }
                      else if(c.equals("Two")){
                  grade="two";
              OneToFiveDisplay n5=new OneToFiveDisplay(grade,sid);
              }
                        else if(c.equals("One")){
                  grade="one";
              OneToFiveDisplay n5=new OneToFiveDisplay(grade,sid);
              }
              else if(c.equals("Ten")){
                  grade="ten";
              NineTenDisplay n3=new NineTenDisplay(grade,sid);
              }
                else if(c.equals("Eight")){
                  grade="eight";
              EightDisplay n4=new EightDisplay(grade,sid);
              }
               else if(c.equals("Nine")){
                  grade="nine";
              NineTenDisplay n3=new NineTenDisplay(grade,sid);
              }
               else if(c.equals("Ukg")){
                  grade="ukg";
              UKGDisplay n11=new UKGDisplay(grade,sid);
              }
               else if(c.equals("Lkg")){
                  grade="lkg";
             LKGDisplay n12=new LKGDisplay(grade,sid);
              }
               else if(c.equals("Nursery")){
                  grade="nursery";
              NurseryDisplay n13=new NurseryDisplay(grade,sid);
              }
            }
     }
        
        
        ////////////////////////////////////Viewing Grade of students//////////////////////////////////////////////////
          if (e.getSource() == btngrade) {
            if (!table.isRowSelected(table.getSelectedRow())) {
                JOptionPane.showMessageDialog(null, "Please select student to view result !!", "Viewing Result Error ", JOptionPane.ERROR_MESSAGE);
           }
             else {
               int sid = Integer.parseInt(model.getValueAt(table.getSelectedRow(), 0).toString());               
                try {
                    pstmt = db.cn.prepareStatement("select class from record where student_id=?");
                    pstmt.setInt(1, sid);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                        c = rs.getString(1);
                    }
               
                } catch (Exception ex) {
                }
                 if(c.equals("Seven")){
                  grade="seven";
              ViewGrade7 n1=new ViewGrade7(grade,sid);
              }
               else if(c.equals("Six")){
                  grade="six";
              ViewGrade6 n14=new ViewGrade6(grade,sid);
              }
                else if(c.equals("Five")){
                  grade="five";
              ViewGrade15 n5=new ViewGrade15(grade,sid);
              }
                  else if(c.equals("Four")){
                  grade="four";
              ViewGrade15 n5=new ViewGrade15(grade,sid);
              }
                    else if(c.equals("Three")){
                  grade="three";
              ViewGrade15 n5=new ViewGrade15(grade,sid);
              }
                      else if(c.equals("Two")){
                  grade="two";
              ViewGrade15 n5=new ViewGrade15(grade,sid);
              }
                        else if(c.equals("One")){
                  grade="one";
              ViewGrade15 n5=new ViewGrade15(grade,sid);
              }
              else if(c.equals("Ten")){
                  grade="ten";
              ViewGrade n3=new ViewGrade(grade,sid);
              }
                else if(c.equals("Eight")){
                  grade="eight";
              ViewGrade8 n4=new ViewGrade8(grade,sid);
                }
            
               else if(c.equals("Nine")){
                  grade="nine";
              ViewGrade n3=new ViewGrade(grade,sid);
              }
                    else if(c.equals("Ukg")){
                  grade="ukg";
              ViewGradeUKG n11=new ViewGradeUKG(grade,sid);
              }
               else if(c.equals("Lkg")){
                  grade="lkg";
             ViewGradeLKG n12=new ViewGradeLKG(grade,sid);
              }
               else if(c.equals("Nursery")){
                  grade="nursery";
              ViewGradeNursery n13=new ViewGradeNursery(grade,sid);
              }
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
//         if(e.getSource()==txtsortby){
//        txtsortby.getText().equals("Search");
//         txtsortby.setText("");
//        }
         }
        
//        if(e.getSource()==txtsortby){
//        if(cbsortby.getSelectedItem().equals("")){
//        JOptionPane.showMessageDialog(null, "Please select an base item to be searched !!", "Viewing Records Error ", JOptionPane.ERROR_MESSAGE);
//          try {
//                    Robot robot=new Robot();
//                   robot.keyPress(KeyEvent.VK_BACK_SPACE);
//                } catch (Exception ex) {
//                }
//          JOptionPane.getRootFrame().dispose();
//        }
//        }
    

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

                    case "Date of Birth":
                        col = "DOB";
                        break;

                    case "Class":
                        col = "class";
                        break;

                    case "Roll No.":
                        col = "roll_no";
                        break;

                    case "Address":
                        col = "address";
                        break;

                    case "Gender":
                        col = "gender";
                        break;

                    case "House Group":
                        col = "sc_home";
                        break;

                    case "Guardian Name":
                        col = "guardian";
                        break;

                    case "Phone":
                        col = "phone";
                        break;

                    case "Mobile":
                        col = "mobile";
                        break;

                    case "Nationality":
                        col = "nationality";
                        break;

                }
                model.setRowCount(0);
                pstmt = db.cn.prepareStatement("select * from record where " + col + " like ?");
                pstmt.setString(1, txtsortby.getText() + "%");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    model.addRow(new Object[]{rs.getString("student_id"), rs.getString("fname") + " " + rs.getString("mname") + " " + rs.getString("lname"), rs.getInt("roll_no"), rs.getString("gender"), rs.getString("DOB"), rs.getString("class"), rs.getString("sc_home"), rs.getString("address"), rs.getString("guardian"), rs.getString("mobile"), rs.getString("nationality")});
                }
            } catch (Exception ex) {
            }

        }
    }



  

    @Override
    public void focusGained(FocusEvent e) {
 if(e.getSource()==txtsortby){
        txtsortby.setText("");
        }    }

    @Override
    public void focusLost(FocusEvent e) {
   if(e.getSource()==txtsortby){
        if(txtsortby.getText().trim().length()==0){
        txtsortby.setText("Search");
        }
        }    }

}
