import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

public class ViewGradeUKG extends JFrame {

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
    String s,remarks,gpa,c,finalgrade;
    double percent,total,eng;
    int stid;

    public ViewGradeUKG(String grade, int id) {
        c = grade;
        stid = id;
        add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        panel.add(jlapplelogo);
        jlapplelogo.setBounds(315, 5, 669, 140);

        jlviews = new JLabel(new ImageIcon("images/studentsgrade.png"));
        panel.add(jlviews);
        jlviews.setBounds(0, 148, 1400, 33);

        table.getTableHeader().setReorderingAllowed(false);
        model.addColumn("Student Id");
        model.addColumn("Student Name");
        model.addColumn("Class");
        model.addColumn("Roll. No.");
        model.addColumn("Terminal");
        model.addColumn("Grade");
         model.addColumn("Final GPA");
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
            table.getColumnModel().getColumn(5).setPreferredWidth(70);
              table.getColumnModel().getColumn(6).setPreferredWidth(50);
   table.getColumnModel().getColumn(7).setPreferredWidth(50);
        /////////////////reordering of the table column is set false//////////////////////////////////// 
        for (int i = 0; i < model.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
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
        //new ViewGradeUKG("Ukg",123);
    }

    public void getData(){
     try {
         model.setRowCount(0);
          //pstmt = db.cn.prepareStatement("SELECT (n.computer_practical+n.english_practical+n.science_practical+n.health_pop_env_practical+n.compulsory_english+n.compulsory_nepali+n.science+n.social_studies+n.health_pop_env_edu+n.optional_mathematics+n.computer) AS total,n.terminal, r.student_id,r.fname,r.mname,r.lname,r.class,r.roll_no FROM nine n JOIN record r ON n.sid=r.student_id WHERE n.sid= ? ");
         pstmt=db.cn.prepareStatement("SELECT e.terminal, e.english AS english,e.nepali AS nepali,e.mathematics AS maths,e.science AS science,e.social_studies AS social,e.g_k AS gk,e.english_oral AS engoral,e.nepali_oral AS neporal,e.mathematics_oral AS mathoral,e.rhymes AS rhymes,e.drawing AS draw,e.conversation AS conversation,e.dictation AS dictation,r.student_id,r.fname,r.mname,r.lname,r.class,r.roll_no FROM ukg e JOIN record r ON e.sid=r.student_id WHERE e.sid= ?"); 
         pstmt.setInt(1, stid);
            rs = pstmt.executeQuery();
            while(rs.next()){
                   model.addRow(new Object[]{rs.getInt("student_id"), rs.getString("fname") + " " + rs.getString("mname") + " " + rs.getString("lname"), rs.getString("class"), rs.getString("roll_no"),rs.getString("terminal"),GettingGPA(getGPA(getGrade(rs.getDouble("english")))+getGPA(getGrade(rs.getDouble("nepali")))+getGPA(getGrade(rs.getDouble("maths")))+getGPA(rs.getString("neporal"))+getGPA(rs.getString("mathoral"))+getGPA(rs.getString("engoral"))+getGPA(rs.getString("rhymes"))+getGPA(rs.getString("conversation"))+getGPA(rs.getString("draw"))+getGPA(rs.getString("dictation"))+getGPA(getGrade(rs.getDouble("science")))+getGPA(getGrade25(rs.getDouble("gk")))+getGPA(getGrade(rs.getDouble("social")))),percent,getRemarks(percent)});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     
     public String getGrade25(Double y) {
        String grade = null;

        if (y >= 22.5) {
            grade = "A+";
        } else if (y >= 20.0 && y < 22.5) {
            grade = "A";
        } else if (y >= 17.5 && y < 20.0) {
            grade = "B+";
        } else if (y >= 15.0 && y < 17.5) {
            grade = "B";
        } else if (y >= 12.5 && y < 15.0) {
            grade = "C+";
        } else if (y >= 10.0 && y < 12.5) {
            grade = "C";
        } else if (y >= 7.5 && y < 10.0) {
            grade = "D+";
        } else if (y >= 5.0 && y < 7.5) {
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
    
    
    public String GettingGPA(double zz){
        finalgrade=null;
      DecimalFormat dec = new DecimalFormat("0.00");
          percent= Double.parseDouble(dec.format((zz / 13.0)));
       if (percent >= 3.6) {
            finalgrade = "A+";
        } else if (percent >= 3.2 && percent < 3.6) {
            finalgrade = "A";
        } else if (percent >= 2.8 && percent < 3.2) {
            finalgrade = "B+";
        } else if (percent >= 2.4 && percent < 2.8) {
            finalgrade = "B";
        } else if (percent >= 2.0 && percent < 2.4) {
            finalgrade = "C+";
        } else if (percent >= 1.6 && percent < 2.0) {
            finalgrade = "C";
        } else if (percent >= 1.2 && percent < 1.6) {
            finalgrade = "D+";
        } else if (percent >= 0.8 && percent < 1.2) {
            finalgrade = "D";
        } else {
            finalgrade = "E";
        }
        return finalgrade;
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
 }
