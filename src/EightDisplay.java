//////////////////////Called from the View Student and View Marksheet of class 8//////////////////////////////////// 
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import java.sql.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
public class EightDisplay extends JFrame {

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
    String ss, c;
    int st;

    public EightDisplay(String sr,int student_id) {
        st = student_id;
        c=sr;
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
        model.addColumn("English Th.");
        model.addColumn("English Pr.");
        model.addColumn("Nepali");
        model.addColumn("Com. Maths");
        model.addColumn("Science Th.");
        model.addColumn("Science Pr.");
        model.addColumn("Social Std Th.");
        model.addColumn("Social Std Pr.");
        model.addColumn("Vocation & Occu.");
        model.addColumn("Health");
        model.addColumn("Computer Th.");
        model.addColumn("Computer Pr.");
        model.addColumn("Opt. Maths");
       
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp = new JScrollPane(table, v, h);
        panel.add(jsp);
        jsp.setBounds(15, 195, 1337, 600);
        table.getTableHeader().setFont(new Font("Roman", Font.BOLD, 12));
          table.setRowHeight(26);
        table.getTableHeader().setPreferredSize(new Dimension(0, 33));
          table.getColumnModel().getColumn(0).setPreferredWidth(33);
        table.getColumnModel().getColumn(1).setMinWidth(145);
        table.getColumnModel().getColumn(2).setPreferredWidth(40);
        table.getColumnModel().getColumn(3).setPreferredWidth(34);
        table.getColumnModel().getColumn(4).setPreferredWidth(42);
        table.getColumnModel().getColumn(5).setPreferredWidth(40);
        table.getColumnModel().getColumn(6).setPreferredWidth(55);
        table.getColumnModel().getColumn(7).setPreferredWidth(55);
        table.getColumnModel().getColumn(8).setPreferredWidth(52);
        table.getColumnModel().getColumn(9).setPreferredWidth(52);
        table.getColumnModel().getColumn(10).setPreferredWidth(70);
        table.getColumnModel().getColumn(11).setPreferredWidth(18);
        table.getColumnModel().getColumn(12).setPreferredWidth(52);
        table.getColumnModel().getColumn(13).setPreferredWidth(50);
         table.getColumnModel().getColumn(14).setPreferredWidth(35);
             
               /////////////////reordering of the table column is set false//////////////////////////////////// 
        for (int i = 0; i < model.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
        }
          getMarks();
       // showTable();

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
    }

/////////////////////////Getting Marks of the student of the respective grade///////////////////////////////
    public void getMarks() {
        try {
          model.setRowCount(0);
            pstmt = db.cn.prepareStatement("select * from " + c + " where sid=? ");
            pstmt.setInt(1, st);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("sid"), rs.getString("terminal"),rs.getString("Compulsory_English"), rs.getString("English_Practical"), rs.getString("Compulsory_Nepali"), rs.getString("Compulsory_Mathematics"), rs.getString("Science"), rs.getString("Science_Practical"), rs.getString("Social_Studies"), rs.getString("Social_Practical"), rs.getString("Vocation_and_Occupation"),rs.getString("Health"), rs.getString("Computer"), rs.getString("Computer_Practical"), rs.getString("Optional_Mathematics")});      
            }
        } catch (SQLException e) {
        }

    }

}
