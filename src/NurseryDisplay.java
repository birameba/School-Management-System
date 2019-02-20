//////////////////////Called from the View Student and View Marksheet of class Nursery//////////////////////////////////// 
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class NurseryDisplay extends JFrame {

    JPanel panel = new JPanel();
    JLabel jlapplelogo, jlviews, jlmenu, sortby;
    JTextField txtsortby;
    JComboBox cbsortby;
    JButton btnedit, btndelete;
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

    public NurseryDisplay(String grade,int student_id) {
        st = student_id;
        c=grade;
        add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        jlapplelogo = new JLabel(new ImageIcon("images/apple2.png"));
        panel.add(jlapplelogo);
        jlapplelogo.setBounds(315, 5, 669, 140);

        jlviews = new JLabel(new ImageIcon("images/marksobtained.png"));
        panel.add(jlviews);
        jlviews.setBounds(0, 148, 1400, 33);

        table.getTableHeader().setReorderingAllowed(false);
        model.addColumn("Student Id");
        model.addColumn("Terminal");
        model.addColumn("English");
        model.addColumn("English Oral");
        model.addColumn("Nepali");
        model.addColumn("Nepali Oral");
        model.addColumn("Mathematics");
        model.addColumn("Mathematics Oral");
        model.addColumn("Rhymes");
        model.addColumn("Drawing");
        model.addColumn("Conversation");
        model.addColumn("Dictation");
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp = new JScrollPane(table, v, h);
        panel.add(jsp);
        jsp.setBounds(15, 195, 1337, 600);
        table.getTableHeader().setFont(new Font("Roman", Font.BOLD, 12));
        table.setRowHeight(26);
        table.getTableHeader().setPreferredSize(new Dimension(0, 36));
        table.getColumnModel().getColumn(0).setPreferredWidth(38);
        table.getColumnModel().getColumn(1).setMinWidth(145);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setPreferredWidth(45);
        table.getColumnModel().getColumn(4).setPreferredWidth(60);
        table.getColumnModel().getColumn(5).setPreferredWidth(45);
        table.getColumnModel().getColumn(6).setPreferredWidth(55);
        table.getColumnModel().getColumn(7).setPreferredWidth(60);
        table.getColumnModel().getColumn(8).setPreferredWidth(45);
        table.getColumnModel().getColumn(9).setPreferredWidth(45);
        table.getColumnModel().getColumn(10).setPreferredWidth(45);
        table.getColumnModel().getColumn(11).setPreferredWidth(45);
           
              /////////////////reordering of the table column is set false//////////////////////////////////// 
        for (int i = 0; i < model.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
        }
        
            getMarks();
        //showTable();

        setSize(1000, 900);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
       setTitle("APPLE  ACADEMY-Veiw Students' Result");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
//        new NurseryDisplay("ten",5);
    }

    public void getMarks() {
        try {
          model.setRowCount(0);
            pstmt = db.cn.prepareStatement("select * from " + c + " where sid=? ");
            pstmt.setInt(1, st);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("sid"), rs.getString("terminal"), rs.getString("English"), rs.getString("English_Oral"), rs.getString("Nepali"), rs.getString("Nepali_Oral"), rs.getString("Mathematics"), rs.getString("Mathematics_Oral"), rs.getString("Rhymes"), rs.getString("Drawing"), rs.getString("Conversation"), rs.getString("Dictation")});      
            }
        } catch (SQLException e) {
        }

    }
}

