 ////////////////////////////View Student Form/////////////////////////////////////////
import java.awt.event.*;
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class AdminViewStudent extends JFrame implements ActionListener, KeyListener,FocusListener {
     String c,grade;
    JPanel panel = new JPanel();
    JLabel jlapplelogo, jlviews, jlmenu, sortby;
    JTextField txtsortby;
    JComboBox cbsortby;
    JButton btnview, btnrefresh,btngrade;
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
    
    public AdminViewStudent() {
         
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
        sortby.setBounds(130, 215, 120, 38);

        cbsortby = new JComboBox();
        panel.add(cbsortby);
        cbsortby.setBounds(220, 215, 195, 38);
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

        txtsortby = new JTextField("Search");
        panel.add(txtsortby);
       // txtsortby.setEditable();
        txtsortby.setFont(ft2);
        txtsortby.setBounds(470, 215, 280, 40);
        txtsortby.addKeyListener(this);
       
        txtsortby.addActionListener(this);
        txtsortby.addFocusListener(this);

     

        btnview = new JButton("View Marks",new ImageIcon("images/viewresult.png"));
        panel.add(btnview);
        btnview.setFont(ft1);
        btnview.setBackground(Color.WHITE);
        btnview.setForeground(Color.BLUE);
        btnview.setBounds(800, 215, 150, 40);
        btnview.addActionListener(this);
        
        
         btngrade = new JButton("View Grade",new ImageIcon("images/viewgrades.png"));
        panel.add(btngrade);
        btngrade.setFont(ft1);
        btngrade.setBackground(Color.WHITE);
        btngrade.setForeground(Color.BLUE);
        btngrade.setBounds(990, 215, 150, 40);
        btngrade.addActionListener(this);


        btnrefresh = new JButton("Refresh",new ImageIcon("images/refresh.png"));
        panel.add(btnrefresh);
        btnrefresh.setFont(ft);
        btnrefresh.setBackground(Color.WHITE);
        btnrefresh.setForeground(Color.BLUE);
        btnrefresh.setBounds(1180, 215, 150, 40);
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
        setSize(1100, 900);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setTitle("APPLE  ACADEMY-Veiw Student");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new AdminViewStudent();
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
