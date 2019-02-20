
import java.awt.BorderLayout;
import javax.swing.*;

public class BackupDialog extends JWindow {

    JLabel lbl;

    public BackupDialog() {

        lbl = new JLabel("Database Backup in Progress...");
        add(lbl).setBounds(40, 30, 260, 25);

        setLayout(null);
        setSize(300, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
         try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new BackupDialog();
    }

}
