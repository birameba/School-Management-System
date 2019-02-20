import java.awt.*;
import javax.swing.*;
public class About extends JFrame{
    JPanel pane;
    JLabel logo,ichchha,tilak,tinfo,icinfo;
    public About(){
        
        pane = new JPanel();
        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);
        Font ft = new Font("", Font.BOLD, 20);
        
         tilak = new JLabel(new ImageIcon("images/tilak.png"));
         
        pane.add(tilak);
        tilak.setBounds(70, 60, 300, 310);
        
        tinfo=new JLabel("<html>Tilak Bahadur Basnet<br>BSc.CSIT, ASCOL<br>Java Developer<br> aasishbasnet11@gmail.com<br> www.facebook.com/tilak.a.basnet.7 <br>Contact: 9860005665</html>");
        pane.add(tinfo);
        tinfo.setBounds(410, 70, 700, 315);
        tinfo.setForeground(new Color(30,144,255));
        tinfo.setFont(ft);
        
        
        ichchha = new JLabel(new ImageIcon("images/ich.jpg"));
        pane.add(ichchha);
        ichchha.setBounds(670, 380, 300, 295);
        
        icinfo=new JLabel("<html>Ichchha Moktan<br>BSc.CSIT, ASCOL<br>Java Developer<br>sassyichchha@gmail.com<br>www.facebook.com/profile.php?id=100001539604369<br>Contact: 9845234685</html>");
        pane.add(icinfo);
        icinfo.setBounds(1020, 390, 310, 310);
        icinfo.setForeground(new Color(255,20,147));
        icinfo.setFont(ft);
        
        setTitle("About Developers");
        setVisible(true);
        setSize(700,700);
       setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    public static void main(String[] args) {
         try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
         new About();
    }
    
}
