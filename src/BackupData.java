
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.io.File;

public class BackupData extends JFrame implements ActionListener {
    
    JButton exam;
    //JComboBox cbDatabase;
    JFileChooser fileChooser = new JFileChooser("");
    JButton btnBackup, btnRestore;
    JTextField txt;
 Font ft1 = new Font("", Font.BOLD, 18);
    public BackupData() {

        
            exam= new JButton("School Database");
        add(exam).setBounds(50, 40, 180, 40);
        exam.setEnabled(false);
        add(exam).setBackground(Color.BLUE);
         add(exam).setForeground(Color.BLACK);
       add(exam).setFont(ft1);
        
//        cbDatabase = new JComboBox();
//        add(cbDatabase).setBounds(20, 20, 200, 25);
//        cbDatabase.addItem("");
//
//        try {
//           DBConnection1 db = new DBConnection1();
//            Statement stmt = db.cn.createStatement();
//            ResultSet rs = stmt.executeQuery("show databases");
//            while (rs.next()) {
//                cbDatabase.addItem(rs.getString(1));
//            }
//        } catch (Exception ex) {
//        }

        btnBackup = new JButton("Backup");
        add(btnBackup).setBounds(50, 108, 180, 40);
        add(btnBackup).setFont(ft1);
         add(btnBackup).setBackground(Color.BLUE);
          add(btnBackup).setForeground(Color.WHITE);
        btnBackup.addActionListener(this);

        btnRestore = new JButton("Restore");
        add(btnRestore).setBounds(50, 177, 180, 40);
        btnRestore.setFont(ft1);
         btnRestore.setBackground(Color.BLUE);
          btnRestore.setForeground(Color. WHITE);
        btnRestore.addActionListener(this);

//        txt = new JTextField();
//        add(txt).setBounds(20, 140, 100, 35);

        setLayout(null);
        setSize(300, 295);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackup) {
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile().getAbsoluteFile();
                try {
                    //Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump -u root -B " + cbDatabase.getSelectedItem().toString() + " -r " + file + ".sql");
                    ///////////////////////////Backup for selecting one of the multiple databases in combobox/////////////////////////////////////////////////
//                    String executeCmd = "C:/xampp/mysql/bin/mysqldump -u root -ptilak " + cbDatabase.getSelectedItem().toString() + " > " + file + ".sql";
                    
                    String executeCmd = "C:/xampp/mysql/bin/mysqldump -u root -ptilak " + "exam" + " > " + file + ".sql";
                    Process p = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", executeCmd});
                    p.waitFor();
                    if (!p.isAlive()) {
                        p.destroy();
                    }

                    JOptionPane.showMessageDialog(null, "Data Backed Up Successfully !");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }

        if (e.getSource() == btnRestore) {
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile().getAbsoluteFile();
                final JWindow jw = new BackupDialog();
                String createCmd = "C:/xampp/mysql/bin/mysql -u root -ptilak -e \"create database if not exists " + txt.getText() + "\"";
                ///////////////////for multiple database in general form////////////////////////////////////
                String restoreCmd = "C:/xampp/mysql/bin/mysql -u root -ptilak " + txt.getText() + " <" + file;
                // String restoreCmd = "C:/xampp/mysql/bin/mysql -u root -ptilak " + "exam" + " <" + file;
                //--------------------------------------------//
                class BackupThread extends Thread {

                    @Override
                    public void run() {
                        try {
                            Process p = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", createCmd});
                            p.waitFor();
                            p = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", restoreCmd});
                            p.waitFor();
                            if (!p.isAlive()) {
                                p.destroy();
                            }
                            JOptionPane.showMessageDialog(null, "Data Restored");
                            jw.setVisible(false);
                            
                        } catch (Exception ex) {
                        }
                    }
                }
                //--------------------------------------------//
                Thread th = new BackupThread();
                th.start();
                jw.setVisible(true);
                
               

            }

        }

    }
}
