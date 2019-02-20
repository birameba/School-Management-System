////////////////////////Called from AdmitCardText//////////////////////////////
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class AdmitCard extends JDialog implements ActionListener,WindowListener {

    JPanel pane;
    JLabel logo, name, sec, roll, sym, grade, regno, jlexam, jlterm;
    JButton btnprint;

    public AdmitCard(String[] values) {

        pane = new JPanel();
        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);
        Font ft = new Font("", Font.BOLD, 15);
        Font ft1 = new Font("", Font.PLAIN, 15);

        logo = new JLabel(new ImageIcon("images/admitcard.png"));
        pane.add(logo);
        logo.setBounds(60, 5, 360, 60);

        jlterm = new JLabel("  " + values[4]);
        pane.add(jlterm);
        jlterm.setBounds(140, 73, 400, 30);
        jlterm.setFont(ft);

        logo = new JLabel(new ImageIcon("images/admitname.png"));
        pane.add(logo);
        logo.setBounds(126, 105, 230, 43);

        name = new JLabel("Name:  " + values[0]);
        pane.add(name);
        name.setBounds(33, 160, 300, 25);
        name.setFont(ft);

        sym = new JLabel("Symbol no:  " + values[3]);
        pane.add(sym);
        sym.setBounds(315, 160, 120, 25);
        sym.setFont(ft);

        grade = new JLabel("Grade:   " + values[2]);
        pane.add(grade);
        grade.setBounds(33, 208, 150, 25);
        grade.setFont(ft);

        roll = new JLabel("Roll no:   " + values[1]);
        pane.add(roll);
        roll.setBounds(315, 208, 110, 25);
        roll.setFont(ft);

        jlexam = new JLabel("<html>..............................           <br>Examination Incharge </html>");
        pane.add(jlexam);
        jlexam.setBounds(295, 260, 220, 40);
        jlexam.setFont(ft);

        btnprint = new JButton("Print",new ImageIcon("images/print.png"));
        pane.add(btnprint);
        btnprint.setBounds(40, 270, 110, 30);
        btnprint.setFont(new Font("", Font.BOLD, 20));
        btnprint.setForeground(Color.BLACK);
        btnprint.setBackground(Color.WHITE);
        btnprint.addActionListener(this);
       // btnprint.setMnemonic(KeyEvent.VK_P);

        addWindowListener(this);
        setSize(490, 355);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Admit Card");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == btnprint) {
//
//        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
//        if(e.getWindow()==this){
//        new AdmitCardText();
//        }
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
