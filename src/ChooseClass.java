/////////////////////Choosing class from Marks Entry/////////////////////////////////////
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChooseClass extends JDialog implements ActionListener,KeyListener{

    JPanel pane;
    JLabel grade;
    JButton submit;
    JComboBox gcb;

    public ChooseClass() {
        pane = new JPanel();

        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);
        Font ft = new Font("", Font.BOLD, 19);

        grade = new JLabel("Select Grade: ");
        pane.add(grade, 0);
        grade.setBounds(32, 50, 150, 38);
        grade.setForeground(Color.BLACK);
        grade.setFont(ft);

        gcb = new JComboBox();
        pane.add(gcb);
        gcb.setBounds(170, 50, 180, 38);
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

        submit = new JButton("Submit", new ImageIcon("images/save.png"));
        pane.add(submit);
        submit.setFont(ft);
        submit.setBounds(400, 50, 150, 38);
         submit.setForeground(Color.BLUE);
          submit.setBackground(Color.WHITE);
        submit.addActionListener(this);
        submit.addKeyListener(this);
        
        submit.setEnabled(false);
        addKeyListener(this);
        setSize(600, 170);
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
       // new ChooseClass();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==gcb){
        if(!(gcb.getSelectedItem().equals(""))){
        submit.setEnabled(true);
        }
        }
       else if (e.getSource() == submit) {
                        if (gcb.getSelectedItem() == "Nursery") {
                            new Nursery();
                           this.dispose();
                        }
            
                        if (gcb.getSelectedItem() == "L.K.G") {
                            new Lkg();
                              this.dispose();
                        }

                        if (gcb.getSelectedItem() == "U.K.G") {
                            new Ukg();
                             this.dispose();
                        }

                        if (gcb.getSelectedItem() == "One") {
                            new One();
                            this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Two") {
                            new Two();
                             this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Three") {
                            new Three();
                           this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Four") {
                            new Four();
                          this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Five") {
                            new Five();
                            this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Six") {
                            new Six();
                         this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Seven") {
                            new Seven();
                             this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Eight") {
                            new Eight();
                               this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Nine") {
                            new Nine();
                             this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Ten") {
                            new Ten();
                              this.dispose();
                        }
                    }
                }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (gcb.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "Please select grade to enter marks !!", "Entering Marks Error", JOptionPane.ERROR_MESSAGE);
            } 
            else{
              if (gcb.getSelectedItem() == "Nursery") {
                            new Nursery();
                            this.dispose();
                        }
            
                        if (gcb.getSelectedItem() == "L.K.G") {
                            new Lkg();
                            this.dispose();
                        }

                        if (gcb.getSelectedItem() == "U.K.G") {
                            new Ukg();
                            this.dispose();
                        }

                        if (gcb.getSelectedItem() == "One") {
                            new One();
                            this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Two") {
                            new Two();
                            this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Three") {
                            new Three();
                            this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Four") {
                            new Four();
                            this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Five") {
                            new Five();
                            this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Six") {
                            new Six();
                            this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Seven") {
                            new Seven();
                            this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Eight") {
                            new Eight();
                            this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Nine") {
                            new Nine();
                            this.dispose();
                        }
                        if (gcb.getSelectedItem() == "Ten") {
                            new Ten();
                            this.dispose();
                        }
            }
    }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
   

