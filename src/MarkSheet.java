////////////////////////////////MarksSheet Printing/////////////////////////////////////

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

public class MarkSheet extends JFrame implements ActionListener {

    String c, terminal, pp;
    double total = 0, percent, rr, rr2, rr3, rr4, rr5, rr6, rr7;
    int id;
    Font ft = new Font("", Font.BOLD, 13);
    Font ft1 = new Font("", Font.BOLD, 16);
    DBConnection1 db = new DBConnection1();
    JPanel pane = new JPanel();
    PreparedStatement pstmt;
    JButton btnprint;
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model) {
        double total = 0;

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };
    ResultSet rs;
    JLabel logoimg, jterminal, reportcard, remarks, jgpa, jclass, name, idno, faculty, grade, doi, principal, section, parentsname, result, percentage, division, cwrank, swrank, attendance;

    public MarkSheet(String[] values) {

        id = Integer.parseInt(values[0]);
        terminal = values[1];

        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);

        logoimg = new JLabel(new ImageIcon("images/apple2.png"));
        pane.add(logoimg);
        logoimg.setBounds(165, 3, 669, 140);

        jterminal = new JLabel(" " + values[1]);
        pane.add(jterminal);
        jterminal.setBounds(392, 132, 500, 35);
        jterminal.setFont(ft1);

        reportcard = new JLabel(new ImageIcon("images/reportcard.png"));
        pane.add(reportcard);
        reportcard.setBounds(0, 171, 1000, 33);

        name = new JLabel("Name of the student : " + values[2]);
        pane.add(name);
        name.setBounds(30, 210, 450, 30);
        name.setFont(ft);

        idno = new JLabel("Symbol No : " + values[5]);
        pane.add(idno);
        idno.setBounds(830, 210, 150, 30);
        idno.setFont(ft);

        grade = new JLabel("Class : " + values[4]);
        pane.add(grade);
        grade.setBounds(30, 240, 150, 30);
        grade.setFont(ft);

        section = new JLabel("Roll No : " + values[3]);
        pane.add(section);
        section.setBounds(830, 240, 150, 30);
        section.setFont(ft);

        parentsname = new JLabel("Parent's Name : " + values[6]);
        pane.add(parentsname);
        parentsname.setBounds(30, 270, 300, 30);
        parentsname.setFont(ft);

        table.getTableHeader().setReorderingAllowed(false);

        model.addColumn("S.N");
        model.addColumn("Subject");
        model.addColumn("Credit Hours");
        model.addColumn("<html>Marks obtained<br> Theory</html>");
        model.addColumn("<html>Marks obtained<br> Practical</html>");
        model.addColumn("Final Grade");
        model.addColumn("Grade Point");
        table.getColumnModel().getColumn(0).setPreferredWidth(35);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);
        table.getColumnModel().getColumn(6).setPreferredWidth(80);
        table.setRowHeight(26);
        table.getTableHeader().setPreferredSize(new Dimension(0, 38));

        /////////////////reordering of the table column is set false//////////////////////////////////// 
        for (int i = 0; i < model.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
        }

        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp = new JScrollPane(table, v, h);
        pane.add(jsp);
        jsp.setBounds(30, 310, 935, 255);

        remarks = new JLabel("Remarks : ");
        pane.add(remarks);
        remarks.setBounds(55, 570, 450, 30);
        remarks.setFont(ft);

        doi = new JLabel("Date Of Issue : " + values[7]);
        pane.add(doi);
        doi.setBounds(55, 602, 300, 42);
        doi.setFont(ft);

        jclass = new JLabel("<html>____________<br>Class Teacher</html> ");
        pane.add(jclass);
        jclass.setBounds(55, 640, 150, 49);
        jclass.setFont(ft);

        division = new JLabel("Grade Point Average(GPA) : ");
        pane.add(division);
        division.setBounds(730, 602, 300, 30);
        division.setFont(ft);

        attendance = new JLabel("Attendance : " + values[8]);
        pane.add(attendance);
        attendance.setBounds(830, 570, 150, 30);
        attendance.setFont(ft);

        btnprint = new JButton("Print",new ImageIcon("images/print.png"));
        pane.add(btnprint);
        btnprint.setBounds(430, 660, 140, 35);
        btnprint.setFont(new Font("", Font.BOLD, 24));
        btnprint.setForeground(Color.BLACK);
        btnprint.setBackground(Color.WHITE);
        btnprint.addActionListener(this);
        btnprint.setMnemonic(KeyEvent.VK_P);// KeyEvent.CTRL_MASK);

        principal = new JLabel("<html>_____________<br>  Principal </html>");
        pane.add(principal);
        principal.setBounds(830, 640, 150, 42);
        principal.setFont(ft);

        setSize(1000, 750);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("MarkSheet");
        getTable();

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        
    }

    /////////////////////////////get grade 100 from marks///////////////////////////////////////////////
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
    ////////////////////////////////////////////////////////////////////////////

    /////////////////////////////get grade 80 from marks///////////////////////////////////////////////
    public String getGrade80(Double x) {
        String grade = null;
        if (x >= 72) {
            grade = "A+";
        } else if (x >= 64 && x < 72) {
            grade = "A";
        } else if (x >= 56 && x < 64) {
            grade = "B+";
        } else if (x >= 48 && x < 56) {
            grade = "B";
        } else if (x >= 40 && x < 48) {
            grade = "C+";
        } else if (x >= 32 && x < 40) {
            grade = "C";
        } else if (x >= 24 && x < 32) {
            grade = "D+";
        } else if (x >= 16 && x < 24) {
            grade = "D";
        } else {
            grade = "E";
        }
        return grade;
    }
    ////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////get grade 20 from marks///////////////////////////////////////////////
    public String getGrade20(Double x) {
        String grade = null;
        if (x >= 18) {
            grade = "A+";
        } else if (x >= 16 && x < 18) {
            grade = "A";
        } else if (x >= 14 && x < 16) {
            grade = "B+";
        } else if (x >= 12 && x < 14) {
            grade = "B";
        } else if (x >= 10 && x < 12) {
            grade = "C+";
        } else if (x >= 8 && x < 10) {
            grade = "C";
        } else if (x >= 6 && x < 8) {
            grade = "D+";
        } else if (x >= 4 && x < 6) {
            grade = "D";
        } else {
            grade = "E";
        }
        return grade;
    }
    /////////////////////////////////////////////////////////////////////////////////

    //////////////////////////grade for practical 25 marks/////////////////////////////////////////////
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
    ////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////For grade 50 marks////////////////////////////////////////
    public String getGrade50(Double y) {
        String grade = null;

        if (y >= 45) {
            grade = "A+";
        } else if (y >= 40 && y < 45) {
            grade = "A";
        } else if (y >= 35 && y < 40) {
            grade = "B+";
        } else if (y >= 30 && y < 35) {
            grade = "B";
        } else if (y >= 25 && y < 30) {
            grade = "C+";
        } else if (y >= 20 && y < 25) {
            grade = "C";
        } else if (y >= 15 && y < 20) {
            grade = "D+";
        } else if (y >= 10 && y < 15) {
            grade = "D";
        } else {
            grade = "E";
        }
        return grade;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////For grade 75 marks////////////////////////////////////////////// 
    public String getGrade75(Double y) {
        String grade = null;

        if (y >= 67.5) {
            grade = "A+";
        } else if (y >= 60 && y < 67.5) {
            grade = "A";
        } else if (y >= 52.5 && y < 60) {
            grade = "B+";
        } else if (y >= 45 && y < 52.5) {
            grade = "B";
        } else if (y >= 37.5 && y < 45) {
            grade = "C+";
        } else if (y >= 30 && y < 37.5) {
            grade = "C";
        } else if (y >= 22.5 && y < 30) {
            grade = "D+";
        } else if (y >= 15 && y < 22.5) {
            grade = "D";
        } else {
            grade = "E";
        }
        return grade;
    }

    ///////////////////////////////For remarks////////////////////
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

    /////////////////////////////Getting GPA////////////////////////
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

    /////////////////////Getting grade for calculated GPA////////////////////////////////
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

    /////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////Finding the Class and the subjects of the respective student's ID/////////////////////////////
    public void getTable() {
        try {
            pstmt = db.cn.prepareStatement("select class from record where student_id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                c = rs.getString(1);

                if (c.equals("Ten") || c.equals("Nine")) {
                    model.setRowCount(0);
                    Statement stmt = db.cn.createStatement();
                    rs = stmt.executeQuery("show columns from " + c);
                    while (rs.next()) {
                        if (rs.getRow() > 5 && !rs.isLast()) {
                            model.addRow(new Object[]{model.getRowCount() + 1, rs.getString("field")});
                        }
                    }
                    getMarks910();
                    sum910();
                } else if (c.equals("Eight")) {
                    model.setRowCount(0);
                    Statement stmt = db.cn.createStatement();
                    rs = stmt.executeQuery("show columns from " + c);
                    while (rs.next()) {
                        if (rs.getRow() > 5 && !rs.isLast()) {
                            model.addRow(new Object[]{model.getRowCount() + 1, rs.getString("field")});
                        }
                    }
                    getMarks8();
                    sum8();
                } else if (c.equals("Seven")) {
                    model.setRowCount(0);
                    Statement stmt = db.cn.createStatement();
                    rs = stmt.executeQuery("show columns from " + c);
                    while (rs.next()) {
                        if (rs.getRow() > 7 && !rs.isLast()) {
                            model.addRow(new Object[]{model.getRowCount() + 1, rs.getString("field")});
                        }
                    }
                    getMarks7();
                    sum7();

                } else if (c.equals("Six")) {
                    model.setRowCount(0);
                    Statement stmt = db.cn.createStatement();
                    rs = stmt.executeQuery("show columns from " + c);
                    while (rs.next()) {
                        if (rs.getRow() > 7 && !rs.isLast()) {
                            model.addRow(new Object[]{model.getRowCount() + 1, rs.getString("field")});
                        }
                    }
                    getMarks6();
                    sum6();
                } else if (c.equals("One") || c.equals("Two") || c.equals("Three") || c.equals("Four") || c.equals("Five")) {
                    model.setRowCount(0);
                    Statement stmt = db.cn.createStatement();
                    rs = stmt.executeQuery("show columns from " + c);
                    while (rs.next()) {
                        if (rs.getRow() > 6 && !rs.isLast()) {
                            model.addRow(new Object[]{model.getRowCount() + 1, rs.getString("field")});
                        }
                    }
                    getMarks15();
                    sum15();
                } else if (c.equals("Nursery")) {
                    model.setRowCount(0);
                    Statement stmt = db.cn.createStatement();
                    rs = stmt.executeQuery("show columns from " + c);
                    while (rs.next()) {
                        if (rs.getRow() > 1 && !rs.isLast()) {
                            model.addRow(new Object[]{model.getRowCount() + 1, rs.getString("field")});
                        }
                    }
                    getMarksnursery();
                    sumnursery();

                } else if (c.equals("Lkg")) {
                    model.setRowCount(0);
                    Statement stmt = db.cn.createStatement();
                    rs = stmt.executeQuery("show columns from " + c);
                    while (rs.next()) {
                        if (rs.getRow() > 1 && !rs.isLast()) {
                            model.addRow(new Object[]{model.getRowCount() + 1, rs.getString("field")});
                        }
                    }
                    getMarkslkg();
                    sumlkg();
                } else if (c.equals("Ukg")) {
                    model.setRowCount(0);
                    Statement stmt = db.cn.createStatement();
                    rs = stmt.executeQuery("show columns from " + c);
                    while (rs.next()) {
                        if (rs.getRow() > 1 && !rs.isLast()) {
                            model.addRow(new Object[]{model.getRowCount() + 1, rs.getString("field")});
                        }
                    }
                    getMarksukg();
                    sumukg();
                }
            }
        } catch (Exception ex) {
        }
    }
///////////////////////////////For Class Nine and Ten//////////////////////////////////////

    public void getMarks910() {
        for (int i = 0; i < model.getRowCount(); i++) {
            String subject = model.getValueAt(i, 1).toString();
            try {
                pstmt = db.cn.prepareStatement("select " + subject + " from " + c + " where terminal =? and sid=? ");
                pstmt.setString(1, terminal);
                pstmt.setInt(2, id);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    rr = Double.parseDouble(rs.getString(1));
                    if (i == 0 || i == 3 || i == 5) {
                        model.setValueAt(getGrade75(rr), i, 3);
                    } else if (i == 7) {
                        model.setValueAt(getGrade50(rr), i, 3);
                    } else {
                        model.setValueAt(getGrade(rr), i, 3);
                    }
//                    model.setValueAt(getGrade75(rr), i, 3);
//                    model.setValueAt(getGrade(rr), i, 3);
//                    model.setValueAt(getGrade(rr), i, 3);
//                    model.setValueAt(getGrade75(rr), i, 3);
//                    model.setValueAt(getGrade(rr), i, 3);
//                    model.setValueAt(getGrade75(rr), i, 3);
//                    model.setValueAt(getGrade(rr), i, 3);
//                    model.setValueAt(getGrade50(rr), i, 3);
                }
                model.setValueAt("4", i, 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            pstmt = db.cn.prepareStatement("select English_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr2 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade25(rr2), 0, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Science_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr3 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade25(rr3), 3, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Health_POP_ENV_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr4 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade25(rr4), 5, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Computer_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr5 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade50(rr5), 7, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("SELECT (english_practical+compulsory_english) AS english, compulsory_nepali,compulsory_mathematics,(science_practical+science) AS science, social_studies,(health_pop_env_practical+health_pop_env_edu) AS health,optional_mathematics,(computer_practical+computer) AS computer FROM " + c + " WHERE terminal=? AND sid=?");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
//                    System.out.println("ok");
                model.setValueAt(getGrade(rs.getDouble(1)), 0, 5);
                model.setValueAt(getGrade(rs.getDouble(2)), 1, 5);
                model.setValueAt(getGrade(rs.getDouble(3)), 2, 5);
                model.setValueAt(getGrade(rs.getDouble(4)), 3, 5);
                model.setValueAt(getGrade(rs.getDouble(5)), 4, 5);
                model.setValueAt(getGrade(rs.getDouble(6)), 5, 5);
                model.setValueAt(getGrade(rs.getDouble(7)), 6, 5);
                model.setValueAt(getGrade(rs.getDouble(8)), 7, 5);

            }
        } catch (Exception eeee) {
            eeee.printStackTrace();
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            String grade = model.getValueAt(i, 5).toString();
            model.setValueAt(getGPA(grade), i, 6);
        }
    }
/////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////For Class 8/////////////////////////////
    public void getMarks8() {
        for (int i = 0; i < model.getRowCount(); i++) {
            String subject = model.getValueAt(i, 1).toString();
            try {
                pstmt = db.cn.prepareStatement("select " + subject + " from " + c + " where terminal =? and sid=? ");
                pstmt.setString(1, terminal);
                pstmt.setInt(2, id);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    rr = Double.parseDouble(rs.getString(1));
                    if (i == 0 || i == 3 || i == 4) {
                        model.setValueAt(getGrade75(rr), i, 3);
                    } else if (i == 8 || i == 5 || i == 6) {
                        model.setValueAt(getGrade50(rr), i, 3);
                    } else {
                        model.setValueAt(getGrade(rr), i, 3);
                    }
//                    model.setValueAt(getGrade75(rr), i, 3);
//                    model.setValueAt(getGrade(rr), i, 3);
//                    model.setValueAt(getGrade(rr), i, 3);
//                    model.setValueAt(getGrade75(rr), i, 3);
//                    model.setValueAt(getGrade75(rr), i, 3);
//                    model.setValueAt(getGrade50(rr), i, 3);
//                    model.setValueAt(getGrade50(rr), i, 3);
//                    model.setValueAt(getGrade(rr), i, 3);
//                    model.setValueAt(getGrade50(rr), i, 3);
                }
                model.setValueAt("4", i, 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            pstmt = db.cn.prepareStatement("select English_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr2 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade25(rr2), 0, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Science_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr3 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade25(rr3), 3, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Social_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr4 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade25(rr4), 4, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Computer_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr5 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade50(rr5), 8, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("SELECT (english_practical+compulsory_english) AS english, compulsory_nepali,compulsory_mathematics,(science_practical+science) AS science, (social_studies+social_practical) AS social,vocation_and_occupation,health,optional_mathematics,(computer_practical+computer) AS computer FROM " + c + " WHERE terminal=? AND sid=?");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
//                    System.out.println("ok");
                model.setValueAt(getGrade(rs.getDouble(1)), 0, 5);
                model.setValueAt(getGrade(rs.getDouble(2)), 1, 5);
                model.setValueAt(getGrade(rs.getDouble(3)), 2, 5);
                model.setValueAt(getGrade(rs.getDouble(4)), 3, 5);
                model.setValueAt(getGrade(rs.getDouble(5)), 4, 5);
                model.setValueAt(getGrade50(rs.getDouble(6)), 5, 5);
                model.setValueAt(getGrade50(rs.getDouble(7)), 6, 5);
                model.setValueAt(getGrade(rs.getDouble(8)), 7, 5);
                model.setValueAt(getGrade(rs.getDouble(9)), 8, 5);
            }
        } catch (Exception eeee) {
            eeee.printStackTrace();
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            String grade = model.getValueAt(i, 5).toString();
            model.setValueAt(getGPA(grade), i, 6);
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////For class 7/////////////////////////////////////////////
    public void getMarks7() {
        for (int i = 0; i < model.getRowCount(); i++) {
            String subject = model.getValueAt(i, 1).toString();
            try {
                pstmt = db.cn.prepareStatement("select " + subject + " from " + c + " where terminal =? and sid=? ");
                pstmt.setString(1, terminal);
                pstmt.setInt(2, id);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    rr = Double.parseDouble(rs.getString(1));
                    if (i == 0 || i == 1) {
                        model.setValueAt(getGrade80(rr), i, 3);
                    } else if (i == 4 || i == 5) {
                        model.setValueAt(getGrade75(rr), i, 3);
                    } else if (i == 9) {
                        model.setValueAt(getGrade50(rr), i, 3);
                    } else if (i == 6 || i == 7) {
                        model.setValueAt(getGrade25(rr), i, 3);
                    } else {
                        model.setValueAt(getGrade(rr), i, 3);
                    }
//                    model.setValueAt(getGrade80(rr), i, 3);
//                    model.setValueAt(getGrade80(rr), i, 3);
//                    model.setValueAt(getGrade(rr), i, 3);
//                    model.setValueAt(getGrade(rr), i, 3);
//                    model.setValueAt(getGrade75(rr), i, 3);
//                    model.setValueAt(getGrade75(rr), i, 3);
//                    model.setValueAt(getGrade25(rr), i, 3);
//                    model.setValueAt(getGrade25(rr), i, 3);
//                    model.setValueAt(getGrade(rr), i, 3);
//                    model.setValueAt(getGrade50(rr), i, 3);
                }
                model.setValueAt("4", i, 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            pstmt = db.cn.prepareStatement("select English_I_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr2 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade20(rr2), 0, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select English_II_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr6 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade20(rr6), 1, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Science_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr3 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade25(rr3), 4, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Social_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr4 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade25(rr4), 5, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Computer_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr5 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade50(rr5), 9, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Vocation_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr7 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade25(rr7), 6, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("SELECT (english_I_practical+english_I) AS englishI,(english_II_practical+english_II) AS englishII, compulsory_nepali,compulsory_mathematics,(science_practical+science) AS science, (social_studies+social_practical) AS social,(vocation+vocation_practical) AS vocation,moral,optional_mathematics,(computer_practical+computer) AS computer FROM " + c + " WHERE terminal=? AND sid=?");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
//                    System.out.println("ok");
                model.setValueAt(getGrade(rs.getDouble(1)), 0, 5);
                model.setValueAt(getGrade(rs.getDouble(2)), 1, 5);
                model.setValueAt(getGrade(rs.getDouble(3)), 2, 5);
                model.setValueAt(getGrade(rs.getDouble(4)), 3, 5);
                model.setValueAt(getGrade(rs.getDouble(5)), 4, 5);
                model.setValueAt(getGrade(rs.getDouble(6)), 5, 5);
                model.setValueAt(getGrade50(rs.getDouble(7)), 6, 5);
                model.setValueAt(getGrade25(rs.getDouble(8)), 7, 5);
                model.setValueAt(getGrade(rs.getDouble(9)), 8, 5);
                model.setValueAt(getGrade(rs.getDouble(10)), 9, 5);
            }
        } catch (Exception eeee) {
            eeee.printStackTrace();
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            String grade = model.getValueAt(i, 5).toString();
            model.setValueAt(getGPA(grade), i, 6);
        }
    }

    //////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////For class 6/////////////////////////////////////////////
    public void getMarks6() {
        for (int i = 0; i < model.getRowCount(); i++) {
            String subject = model.getValueAt(i, 1).toString();
            try {
                pstmt = db.cn.prepareStatement("select " + subject + " from " + c + " where terminal =? and sid=? ");
                pstmt.setString(1, terminal);
                pstmt.setInt(2, id);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    rr = Double.parseDouble(rs.getString(1));
                    if (i == 0 || i == 1) {
                        model.setValueAt(getGrade80(rr), i, 3);
                    } else if (i == 4 || i == 5) {
                        model.setValueAt(getGrade75(rr), i, 3);
                    } else if (i == 8) {
                        model.setValueAt(getGrade50(rr), i, 3);
                    } else if (i == 6 || i == 7) {
                        model.setValueAt(getGrade25(rr), i, 3);
                    } else {
                        model.setValueAt(getGrade(rr), i, 3);
                    }

                }
                model.setValueAt("4", i, 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            pstmt = db.cn.prepareStatement("select English_I_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr2 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade20(rr2), 0, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select English_II_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr6 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade20(rr6), 1, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Science_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr3 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade25(rr3), 4, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Social_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr4 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade25(rr4), 5, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Computer_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr5 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade50(rr5), 8, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Vocation_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr7 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade25(rr7), 6, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("SELECT (english_I_practical+english_I) AS englishI,(english_II_practical+english_II) AS englishII, compulsory_nepali,compulsory_mathematics,(science_practical+science) AS science, (social_studies+social_practical) AS social,(vocation+vocation_practical) AS vocation,moral,(computer_practical+computer) AS computer FROM " + c + " WHERE terminal=? AND sid=?");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
//                    System.out.println("ok");
                model.setValueAt(getGrade(rs.getDouble(1)), 0, 5);
                model.setValueAt(getGrade(rs.getDouble(2)), 1, 5);
                model.setValueAt(getGrade(rs.getDouble(3)), 2, 5);
                model.setValueAt(getGrade(rs.getDouble(4)), 3, 5);
                model.setValueAt(getGrade(rs.getDouble(5)), 4, 5);
                model.setValueAt(getGrade(rs.getDouble(6)), 5, 5);
                model.setValueAt(getGrade50(rs.getDouble(7)), 6, 5);
                model.setValueAt(getGrade25(rs.getDouble(8)), 7, 5);
                model.setValueAt(getGrade(rs.getDouble(9)), 8, 5);
            }
        } catch (Exception eeee) {
            eeee.printStackTrace();
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            String grade = model.getValueAt(i, 5).toString();
            model.setValueAt(getGPA(grade), i, 6);
        }
    }

    //////////////////////////////////////////////////////////////////////////
    ////////////////////////////////For class 1 to 5////////////////////////////////////////
    public void getMarks15() {
        for (int i = 0; i < model.getRowCount(); i++) {
            String subject = model.getValueAt(i, 1).toString();
            try {
                pstmt = db.cn.prepareStatement("select " + subject + " from " + c + " where terminal =? and sid=? ");
                pstmt.setString(1, terminal);
                pstmt.setInt(2, id);
                rs = pstmt.executeQuery();
                if (rs.next()) {

                    if (i == 0 || i == 1) {
                        rr = Double.parseDouble(rs.getString(1));
                        model.setValueAt(getGrade80(rr), i, 3);
                    } else if (i == 4 || i == 5) {
                        rr = Double.parseDouble(rs.getString(1));
                        model.setValueAt(getGrade75(rr), i, 3);
                    } else if (i == 8) {
                        rr = Double.parseDouble(rs.getString(1));
                        model.setValueAt(getGrade50(rr), i, 3);
                    } else if (i == 6 || i == 7) {
                        rr = Double.parseDouble(rs.getString(1));
                        model.setValueAt(getGrade25(rr), i, 3);
                    } /////////////////////for input of obtained grade directly////////////////////////
                    else if (i == 9) {
                        model.setValueAt(rs.getString(1), i, 3);
                    } else if (i == 10) {
                        model.setValueAt(rs.getString(1), i, 3);
                    } ///////////////////////////////////////////////////////////////////////////////////
                    else {
                        rr = Double.parseDouble(rs.getString(1));
                        model.setValueAt(getGrade(rr), i, 3);
                    }
                }
                model.setValueAt("4", i, 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            pstmt = db.cn.prepareStatement("select English_I_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr2 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade20(rr2), 0, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select English_II_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr6 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade20(rr6), 1, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Science_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr3 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade25(rr3), 4, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Social_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr4 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade25(rr4), 5, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("select Computer_Practical from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rr5 = Double.parseDouble(rs.getString(1));
                model.setValueAt(getGrade50(rr5), 8, 4);
            }
        } catch (SQLException ee) {
        };

        try {
            pstmt = db.cn.prepareStatement("SELECT (english_I_practical+english_I) AS englishI,(english_II_practical+english_II) AS englishII, compulsory_nepali,compulsory_mathematics,(science_practical+science) AS science, (social_studies+social_practical) AS social,moral,g_k,(computer_practical+computer) AS computer,Drawing,Dictation FROM " + c + " WHERE terminal=? AND sid=?");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
//                    System.out.println("ok");
                model.setValueAt(getGrade(rs.getDouble(1)), 0, 5);
                model.setValueAt(getGrade(rs.getDouble(2)), 1, 5);
                model.setValueAt(getGrade(rs.getDouble(3)), 2, 5);
                model.setValueAt(getGrade(rs.getDouble(4)), 3, 5);
                model.setValueAt(getGrade(rs.getDouble(5)), 4, 5);
                model.setValueAt(getGrade(rs.getDouble(6)), 5, 5);
                model.setValueAt(getGrade25(rs.getDouble(7)), 6, 5);
                model.setValueAt(getGrade25(rs.getDouble(8)), 7, 5);
                model.setValueAt(getGrade(rs.getDouble(9)), 8, 5);
                model.setValueAt(rs.getString(10), 9, 5);
                model.setValueAt(rs.getString(11), 10, 5);
            }
        } catch (Exception eeee) {
            eeee.printStackTrace();
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            String grade = model.getValueAt(i, 5).toString();
            model.setValueAt(getGPA(grade), i, 6);
        }
    }

    //////////////////////////////////////For Class Nursery/////////////////////////////////////
    public void getMarksnursery() {
        try {
            pstmt = db.cn.prepareStatement("select English,English_Oral,Nepali,Nepali_Oral,Mathematics,Mathematics_Oral,Rhymes,Drawing,Conversation,Dictation from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {

                model.setValueAt(getGrade(rs.getDouble(1)), 0, 3);
                model.setValueAt(getGrade(rs.getDouble(1)), 0, 5);
                model.setValueAt(rs.getString(2), 1, 3);
                model.setValueAt(rs.getString(2), 1, 5);
                model.setValueAt((getGrade(rs.getDouble(3))), 2, 3);
                model.setValueAt((getGrade(rs.getDouble(3))), 2, 5);
                model.setValueAt(rs.getString(4), 3, 3);
                model.setValueAt(rs.getString(4), 3, 5);
                model.setValueAt(getGrade(rs.getDouble(5)), 4, 3);
                model.setValueAt(getGrade(rs.getDouble(5)), 4, 5);
                model.setValueAt(rs.getString(6), 5, 3);
                model.setValueAt(rs.getString(6), 5, 5);
                model.setValueAt(rs.getString(7), 6, 3);
                model.setValueAt(rs.getString(7), 6, 5);
                model.setValueAt(rs.getString(8), 7, 3);
                model.setValueAt(rs.getString(8), 7, 5);
                model.setValueAt(rs.getString(9), 8, 3);
                model.setValueAt(rs.getString(9), 8, 5);
                model.setValueAt(rs.getString(10), 9, 3);
                model.setValueAt(rs.getString(10), 9, 5);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt("4", i, 2);
        }

        /////////////////////////Getting GPA ///////////////////////////////////////////////
        for (int i = 0; i < model.getRowCount(); i++) {
            String grade = model.getValueAt(i, 5).toString();
            model.setValueAt(getGPA(grade), i, 6);
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////For Class LKG///////////////////////////////////////////
    public void getMarkslkg() {
        try {
            pstmt = db.cn.prepareStatement("select English,English_Oral,Nepali,Nepali_Oral,Mathematics,Mathematics_Oral,Science,General_Studies,Rhymes,Drawing,Conversation,Dictation from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {

                model.setValueAt(getGrade(rs.getDouble(1)), 0, 3);
                model.setValueAt(getGrade(rs.getDouble(1)), 0, 5);
                model.setValueAt(rs.getString(2), 1, 3);
                model.setValueAt(rs.getString(2), 1, 5);
                model.setValueAt((getGrade(rs.getDouble(3))), 2, 3);
                model.setValueAt((getGrade(rs.getDouble(3))), 2, 5);
                model.setValueAt(rs.getString(4), 3, 3);
                model.setValueAt(rs.getString(4), 3, 5);
                model.setValueAt(getGrade(rs.getDouble(5)), 4, 3);
                model.setValueAt(getGrade(rs.getDouble(5)), 4, 5);
                model.setValueAt(rs.getString(6), 5, 3);
                model.setValueAt(rs.getString(6), 5, 5);
                model.setValueAt(getGrade(rs.getDouble(7)), 6, 3);
                model.setValueAt(getGrade(rs.getDouble(7)), 6, 5);
                model.setValueAt(getGrade(rs.getDouble(8)), 7, 3);
                model.setValueAt(getGrade(rs.getDouble(8)), 7, 5);
                model.setValueAt(rs.getString(9), 8, 3);
                model.setValueAt(rs.getString(9), 8, 5);
                model.setValueAt(rs.getString(10), 9, 3);
                model.setValueAt(rs.getString(10), 9, 5);
                model.setValueAt(rs.getString(11), 10, 3);
                model.setValueAt(rs.getString(11), 10, 5);
                model.setValueAt(rs.getString(12), 11, 3);
                model.setValueAt(rs.getString(12), 11, 5);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt("4", i, 2);
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            String grade = model.getValueAt(i, 5).toString();
            model.setValueAt(getGPA(grade), i, 6);
        }

    }

    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////For Class UKG//////////////////////////////////////
    public void getMarksukg() {
        try {
            pstmt = db.cn.prepareStatement("select English,English_Oral,Nepali,Nepali_Oral,Mathematics,Mathematics_Oral,Science,Social_Studies,G_K,Rhymes,Drawing,Conversation,Dictation from " + c + " where terminal =? and sid=? ");
            pstmt.setString(1, terminal);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {

                model.setValueAt(getGrade(rs.getDouble(1)), 0, 3);
                model.setValueAt(getGrade(rs.getDouble(1)), 0, 5);
                model.setValueAt(rs.getString(2), 1, 3);
                model.setValueAt(rs.getString(2), 1, 5);
                model.setValueAt((getGrade(rs.getDouble(3))), 2, 3);
                model.setValueAt((getGrade(rs.getDouble(3))), 2, 5);
                model.setValueAt(rs.getString(4), 3, 3);
                model.setValueAt(rs.getString(4), 3, 5);
                model.setValueAt(getGrade(rs.getDouble(5)), 4, 3);
                model.setValueAt(getGrade(rs.getDouble(5)), 4, 5);
                model.setValueAt(rs.getString(6), 5, 3);
                model.setValueAt(rs.getString(6), 5, 5);
                model.setValueAt(getGrade(rs.getDouble(7)), 6, 3);
                model.setValueAt(getGrade(rs.getDouble(7)), 6, 5);
                model.setValueAt(getGrade(rs.getDouble(8)), 7, 3);
                model.setValueAt(getGrade(rs.getDouble(8)), 7, 5);
                model.setValueAt(getGrade25(rs.getDouble(9)), 8, 3);
                model.setValueAt(getGrade25(rs.getDouble(9)), 8, 5);
                model.setValueAt(rs.getString(10), 9, 3);
                model.setValueAt(rs.getString(10), 9, 5);
                model.setValueAt(rs.getString(11), 10, 3);
                model.setValueAt(rs.getString(11), 10, 5);
                model.setValueAt(rs.getString(12), 11, 3);
                model.setValueAt(rs.getString(12), 11, 5);
                model.setValueAt(rs.getString(13), 12, 3);
                model.setValueAt(rs.getString(13), 12, 5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt("4", i, 2);
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            String grade = model.getValueAt(i, 5).toString();
            model.setValueAt(getGPA(grade), i, 6);
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    public void sum910() {
        for (int i = 0; i < model.getRowCount(); i++) {
            double mark = Double.parseDouble(model.getValueAt(i, 6).toString());
            total = total + mark;
        }
        DecimalFormat dec = new DecimalFormat("0.00");
        percent = (total / 8.0);
        division.setText(division.getText() + "" + dec.format(percent) + "  " + "(" + getFinalGrade(percent) + ")");
        remarks.setText(remarks.getText() + "" + getRemarks(percent));
    }

    //////////////////////////Getting the GPA  for class 8/////////////////////////////////
    public void sum8() {
        for (int i = 0; i < model.getRowCount(); i++) {
            double mark = Double.parseDouble(model.getValueAt(i, 6).toString());
            total = total + mark;
        }
        DecimalFormat dec = new DecimalFormat("0.00");
        percent = (total / 9.0);
        division.setText(division.getText() + "" + dec.format(percent) + "  " + "(" + getFinalGrade(percent) + ")");
        remarks.setText(remarks.getText() + "" + getRemarks(percent));
    }

    //////////////////////////Getting the GPA  for class 6 and 7/////////////////////////////////
    public void sum7() {
        for (int i = 0; i < model.getRowCount(); i++) {
            double mark = Double.parseDouble(model.getValueAt(i, 6).toString());
            total = total + mark;
        }
        DecimalFormat dec = new DecimalFormat("0.00");
        percent = (total / 10.0);
        division.setText(division.getText() + "" + dec.format(percent) + "  " + "(" + getFinalGrade(percent) + ")");
        remarks.setText(remarks.getText() + "" + getRemarks(percent));
    }

    //////////////////////////Getting the GPA  for class 6 /////////////////////////////////
    public void sum6() {
        for (int i = 0; i < model.getRowCount(); i++) {
            double mark = Double.parseDouble(model.getValueAt(i, 6).toString());
            total = total + mark;
        }
        DecimalFormat dec = new DecimalFormat("0.00");
        percent = (total / 9.0);
        division.setText(division.getText() + "" + dec.format(percent) + "  " + "(" + getFinalGrade(percent) + ")");
        remarks.setText(remarks.getText() + "" + getRemarks(percent));
    }

    //////////////////////////Getting the GPA  for class 1 to 5/////////////////////////////////
    public void sum15() {
        for (int i = 0; i < model.getRowCount(); i++) {
            double mark = Double.parseDouble(model.getValueAt(i, 6).toString());
            total = total + mark;
        }
        DecimalFormat dec = new DecimalFormat("0.00");
        percent = (total / 11.0);
        division.setText(division.getText() + "" + dec.format(percent) + "  " + "(" + getFinalGrade(percent) + ")");
        remarks.setText(remarks.getText() + "" + getRemarks(percent));
    }

    //////////////////////////Getting the GPA  for class Nursery/////////////////////////////////
    public void sumnursery() {
        for (int i = 0; i < model.getRowCount(); i++) {
            double mark = Double.parseDouble(model.getValueAt(i, 6).toString());
            total = total + mark;
        }
        DecimalFormat dec = new DecimalFormat("0.00");
        percent = (total / 10.0);
        division.setText(division.getText() + "" + dec.format(percent) + "  " + "(" + getFinalGrade(percent) + ")");
        remarks.setText(remarks.getText() + "" + getRemarks(percent));
    }

    //////////////////////////Getting the GPA  for class LKG/////////////////////////////////
    public void sumlkg() {
        for (int i = 0; i < model.getRowCount(); i++) {
            double mark = Double.parseDouble(model.getValueAt(i, 6).toString());
            total = total + mark;
        }
        DecimalFormat dec = new DecimalFormat("0.00");
        percent = (total / 12.0);
        division.setText(division.getText() + "" + dec.format(percent) + "  " + "(" + getFinalGrade(percent) + ")");
        remarks.setText(remarks.getText() + "" + getRemarks(percent));
    }

    //////////////////////////Getting the GPA  for class UKG/////////////////////////////////
    public void sumukg() {
        for (int i = 0; i < model.getRowCount(); i++) {
            double mark = Double.parseDouble(model.getValueAt(i, 6).toString());
            total = total + mark;
        }
        DecimalFormat dec = new DecimalFormat("0.00");
        percent = (total / 13.0);
        division.setText(division.getText() + "" + dec.format(percent) + "  " + "(" + getFinalGrade(percent) + ")");
        remarks.setText(remarks.getText() + "" + getRemarks(percent));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == btnprint) {
//          
//        }
    }

}
