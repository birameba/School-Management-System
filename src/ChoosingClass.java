/////////////////////Choosing class from Marks Entry/////////////////////////////////////

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class ChoosingClass extends JDialog implements ActionListener, KeyListener {

    JPanel pane;
    JLabel grade,term;
    JButton submit;
    JComboBox gcb,cbterm;
    String level,terminal;
    
    public ChoosingClass() {
        pane = new JPanel();

        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);
        Font ft = new Font("", Font.BOLD, 16);

        grade = new JLabel("Select Grade: ");
        pane.add(grade, 0);
        grade.setBounds(32, 50, 150, 38);
        grade.setForeground(Color.BLACK);
        grade.setFont(ft);

        gcb = new JComboBox();
        pane.add(gcb);
        gcb.setBounds(143, 50, 180, 38);
        gcb.addItem("");
        gcb.addItem("Nursery");
        gcb.addItem("L.K.G");
        gcb.addItem("U.K.G");
        gcb.addItem("One");
        gcb.addItem("Two");
        gcb.addItem("Three");
        gcb.addItem("Four");
        gcb.addItem("Five");
        gcb.addItem("Six");
        gcb.addItem("Seven");
        gcb.addItem("Eight");
        gcb.addItem("Nine");
        gcb.addItem("Ten");
        gcb.addActionListener(this);
        gcb.addKeyListener(this);
        
         term = new JLabel("Select Terminal: ");
        pane.add(term, 0);
        term.setBounds(352, 50, 170, 38);
        term.setForeground(Color.BLACK);
        term.setFont(ft);
        
         cbterm = new JComboBox();
        pane.add(cbterm);
        cbterm.setBounds(500, 50, 235, 38);
        cbterm.addItem("");
        cbterm.addItem("First Terminal Examination");
        cbterm.addItem("Second Terminal Examination");
        cbterm.addItem("Third Terminal Examination");
        cbterm.addItem("Final Terminal Examination");
        cbterm.addKeyListener(this);
        cbterm.addActionListener(this);

        submit = new JButton("Submit", new ImageIcon("images/save.png"));
        pane.add(submit);
        submit.setFont(ft);
        submit.setBounds(490, 115, 150, 38);
        submit.setForeground(Color.BLUE);
        submit.setBackground(Color.WHITE);
        submit.addActionListener(this);
        submit.addKeyListener(this);

        submit.setEnabled(false);
        addKeyListener(this);
        setSize(800, 190);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Choose Class");
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new ChoosingClass();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gcb) {
            if (!(gcb.getSelectedItem().equals(""))) {
                submit.setEnabled(true);
            }
        } else if (e.getSource() == submit) {
        level=gcb.getSelectedItem().toString();
        terminal=cbterm.getSelectedItem().toString();
        new SecAdmitText(level,terminal);
        this.dispose();
            }
        }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
