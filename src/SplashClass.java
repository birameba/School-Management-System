
import javax.swing.*;
public class SplashClass extends JWindow {

    JLabel splashimg;

    public SplashClass() {

        splashimg = new JLabel(new ImageIcon("images/applee1.png"));
        add(splashimg);
        
        setVisible(true);
        setSize(1050, 263);
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
       
    }
}
