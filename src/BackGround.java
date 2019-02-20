
import java.awt.*;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.*;


public class BackGround extends JFrame {

    JTextField txt;
    JLabel lbl;
    public BackGround() {
        
        lbl=new JLabel(new ImageIcon("images/eye.png"));
        add(lbl).setBounds(20,20,34,30);
        
        txt=new JTextField();
        add(txt).setBounds(54,20,200,30);
        //txt.setBackground(Color.WHITE);
        txt.setBorder(BorderFactory.createBevelBorder(0, Color.WHITE, Color.WHITE));
        txt.setMargin(new Insets(0,20,0,0));
       

        setLayout(null);
        setSize(330, 153);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new BackGround();
    }
    
}
