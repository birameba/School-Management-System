
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

public class ViewClassGrade extends JFrame {

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
    Font ft1 = new Font("Roman", Font.PLAIN, 19);
    ResultSet rs;
    String s,remarks, c,english, nepali, maths, science, social, health, opt, computer;
     double total,percent,eng,nep,math,sci,soc,hth,optmath,comp;
    int stid,a[],i;

    public ViewClassGrade(String grade) {
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

        table.getTableHeader().setReorderingAllowed(false);
        model.addColumn("Student Id");
        model.addColumn("Student Name");
        model.addColumn("Class");
        model.addColumn("Roll. No.");
        model.addColumn("Terminal");
        model.addColumn("Grade");
        model.addColumn("Remarks");

        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp = new JScrollPane(table, v, h);
        panel.add(jsp);
        jsp.setBounds(15, 193, 1337, 600);
        table.getTableHeader().setFont(new Font("Roman", Font.BOLD, 12));
        table.setRowHeight(26);
        table.getTableHeader().setPreferredSize(new Dimension(0, 36));
        table.getColumnModel().getColumn(0).setPreferredWidth(35);
        table.getColumnModel().getColumn(1).setMinWidth(165);
        table.getColumnModel().getColumn(2).setPreferredWidth(35);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(120);
            table.getColumnModel().getColumn(5).setPreferredWidth(50);
              table.getColumnModel().getColumn(5).setPreferredWidth(50);

        /////////////////reordering of the table column is set false//////////////////////////////////// 
        for (int i = 0; i < model.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
        }
        
        try {
            i=0;
             stmt = db.cn.createStatement();
            rs = stmt.executeQuery("SELECT sid  FROM " + c + "");
            while (rs.next()) {
                a[i]=rs.getInt("sid");
                i++;
        } 
        }catch (Exception e) {
        }
     
        getData();
       

        setSize(1000, 900);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setTitle("APPLE  ACADEMY-Veiw Students' Grade");

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
       // new ViewClassGrade("Five");
    }

    
//    public void getData(){
//        try {
//             model.setRowCount(0);
//            stmt = db.cn.createStatement();
//            rs = stmt.executeQuery("SELECT *  FROM " + c + "");
//            while (rs.next()) {
//                model.addRow(new Object[]{rs.getString("sid"), rs.getString("terminal"), rs.getString("Compulsory_English"), rs.getString("English_Practical"), rs.getString("Compulsory_Nepali"), rs.getString("Compulsory_Mathematics"), rs.getString("Science"), rs.getString("Science_Practical"), rs.getString("Social_Studies"), rs.getString("Health_POP_ENV_EDU"), rs.getString("Health_POP_ENV_Practical"), rs.getString("Computer"), rs.getString("Computer_Practical"), rs.getString("Optional_Mathematics")});
//            }
//        } catch (Exception e) {
//        }
//    
//    }
    public void getData(){
     try {
         i=0;
            model.setRowCount(0);
            pstmt = db.cn.prepareStatement("select student_id,fname,mname,lname,class,roll_no from record where student_id = ?");
            pstmt.setInt(1, a[i]);
            rs = pstmt.executeQuery();
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt("student_id"), rs.getString("fname") + " " + rs.getString("mname") + " " + rs.getString("lname"), rs.getString("class"), rs.getString("roll_no"),GetTerminal(),GettingGPA(),getRemarks()});
            }
            i++;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public String GetTerminal(){
    String terminal=null;
        try {
            pstmt = db.cn.prepareStatement("select terminal from " + c + " ");
            pstmt.setInt(1, stid);
            rs = pstmt.executeQuery();
            while(rs.next()){
            terminal=rs.getString("terminal");
            }
        } catch (Exception e) {
        }  
    return terminal;
    }
    
    
    
    public String GettingGPA() {
        String gpa = null;
       
        try {
            pstmt = db.cn.prepareStatement("SELECT (english_practical+compulsory_english) AS english, compulsory_nepali,compulsory_mathematics,(science_practical+science) AS science, social_studies,(health_pop_env_practical+health_pop_env_edu) AS health,optional_mathematics,(computer_practical+computer) AS computer FROM " + c + " WHERE sid=?");
            pstmt.setInt(1, stid);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                english = getGrade(rs.getDouble(1));
                nepali = getGrade(rs.getDouble(2));
                maths = getGrade(rs.getDouble(3));
                science = getGrade(rs.getDouble(4));
                social = getGrade(rs.getDouble(5));
                health = getGrade(rs.getDouble(6));
                opt = getGrade(rs.getDouble(7));
                computer = getGrade(rs.getDouble(8));
            }
        } catch (Exception eeee) {
            eeee.printStackTrace();
        }

        for (int i = 0; i < 8; i++) {
           
            eng=getGPA(english);
            nep=getGPA(nepali);
            math=getGPA(maths);
            sci=getGPA(science);
            soc=getGPA(social);
            hth=getGPA(health);
            optmath=getGPA(opt);
            comp=getGPA(computer);
        }
       total = eng + nep + math + sci + soc + hth + optmath + comp;
        
        DecimalFormat dec = new DecimalFormat("0.00");
        percent = (total / 8.0);
       gpa=getFinalGrade(percent);
        return gpa;
    }

    public String getRemarks(){
    String remark=null;
    remark=getRemarks(percent);
    return remark;
    }
    
    public String getGrade(Double x) {
        String grade = null;
        if (x >= 90.0) {
            grade = "A+";
        } else if (x >= 80.0 && x < 90.0) {
            grade = "A";
        } else if (x >= 70.0 && x < 80.0) {
            grade = "B+";
        } else if (x >= 60.0 && x < 70.0) {
            grade = "B";
        } else if (x >= 50.0 && x < 60.0) {
            grade = "C+";
        } else if (x >= 40.0 && x < 50.0) {
            grade = "C";
        } else if (x >= 30.0 && x < 40.0) {
            grade = "D+";
        } else if (x >= 20.0 && x < 30.0) {
            grade = "D";
        } else {
            grade = "E";
        }
        return grade;
    }

    public double getGPA(String ss) {
        double x = 0.0;
        if (ss.equals("A+")) {
            x = 4.0;
        }
        if (ss.equals("A")) {
            x = 3.6;
        }
        if (ss.equals("B+")) {
            x = 3.2;
        }
        if (ss.equals("B")) {
            x = 2.8;
        }
        if (ss.equals("C+")) {
            x = 2.4;
        }
        if (ss.equals("C")) {
            x = 2.0;
        }
        if (ss.equals("D+")) {
            x = 1.6;
        }
        if (ss.equals("D")) {
            x = 1.2;
        }
        if (ss.equals("E")) {
            x = 0.8;
        }
        return x;
    }
 public String getRemarks(Double y) {
        String remarks = null;

        if (y >= 4.0) {
            remarks = "Outstanding";
        } else if (y >= 3.6 && y < 4.0) {
            remarks = "Excellent";
        } else if (y >= 3.2 && y < 3.6) {
            remarks = "Very Good";
        } else if (y >= 2.8 && y < 3.2) {
            remarks = "Good";
        } else if (y >= 2.4 && y < 2.8) {
            remarks = "Satisfactory";
        } else if (y >= 2.0 && y < 2.4) {
            remarks = "Acceptable";
        } else if (y >= 1.6 && y < 2.0) {
            remarks = "Partially Acceptable";
        } else if (y >= 1.2 && y < 1.6) {
            remarks = "Insufficient";
        } else {
            remarks = "Very Insufficient";
        }
        return remarks;
    }
 
  public String getFinalGrade(Double m) {
        String finalgrade = null;
        if (m >= 3.6) {
            finalgrade = "A+";
        } else if (m >= 3.2 && m < 3.6) {
            finalgrade = "A";
        } else if (m >= 2.8 && m < 3.2) {
            finalgrade = "B+";
        } else if (m >= 2.4 && m < 2.8) {
            finalgrade = "B";
        } else if (m >= 2.0 && m < 2.4) {
            finalgrade = "C+";
        } else if (m >= 1.6 && m < 2.0) {
            finalgrade = "C";
        } else if (m >= 1.2 && m < 1.6) {
            finalgrade = "D+";
        } else if (m >= 0.8 && m < 1.2) {
            finalgrade = "D";
        } else {
            finalgrade = "E";
        }
        return finalgrade;

    }

}
