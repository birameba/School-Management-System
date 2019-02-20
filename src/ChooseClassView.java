///////////////////////Choosing the student id or the grade for viewing marks///////////////////////////////////
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class ChooseClassView extends JDialog implements ActionListener, KeyListener {

    JPanel pane;
    JLabel grade, stid, inform;
    JTextField txtstid;
    JButton submit;
    JComboBox gcb;
    int id;
    DBConnection1 db=new DBConnection1();
    ResultSet rs;
    PreparedStatement pstmt;
    String c, cl;

    public ChooseClassView() {
        pane = new JPanel();

        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);
        Font ft = new Font("", Font.BOLD, 16);
        Font ft1 = new Font("", Font.BOLD, 16);
        Font ft2 = new Font("", Font.PLAIN, 15);

        stid = new JLabel("Student ID : ");
        pane.add(stid, 0);
        stid.setBounds(90, 35, 120, 38);
        stid.setForeground(Color.BLACK);
        stid.setFont(ft);

        txtstid = new JTextField();
        pane.add(txtstid, 0);
        txtstid.setBounds(200, 35, 130, 36);
        txtstid.addKeyListener(this);
        txtstid.setFont(ft2);
        txtstid.addActionListener(this);

        grade = new JLabel("Select Grade   : ");
        pane.add(grade, 0);
        grade.setBounds(365, 35, 120, 38);
        grade.setForeground(Color.BLACK);
        grade.setFont(ft);

        gcb = new JComboBox();
        pane.add(gcb);
        gcb.setBounds(510, 35, 190, 38);
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

        inform = new JLabel("\"NOTE!!Please enter only one, either Student ID or Grade.\"");
        pane.add(inform, 0);
        inform.setBounds(200, 72, 700, 38);
        inform.setForeground(Color.RED);
        inform.setFont(ft1);

        submit = new JButton("View Result",new ImageIcon("images/viewresult.png"));
        pane.add(submit);
        submit.setFont(ft);
        submit.setBounds(350, 120, 150, 38);
        inform.setForeground(Color.BLUE);
        inform.setBackground(Color.WHITE);
        submit.addActionListener(this);
        
        addKeyListener(this);
        setSize(750, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Choose Class ");
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
      new ChooseClassView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit || e.getSource()==txtstid) {
            if (gcb.getSelectedItem() == "" && txtstid.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter either student ID or grade to view result !!", "Result Viewing Error", JOptionPane.ERROR_MESSAGE);
            }
               if(gcb.getSelectedItem().equals("")) {
                      try {
                    int sid=Integer.parseInt(txtstid.getText());
                    pstmt = db.cn.prepareStatement("SELECT student_id  FROM record where student_id=?");
                    pstmt.setInt(1,sid);
                    rs = pstmt.executeQuery();
                    if(rs.next()) {
                            new IdMarksDisplay(sid);
                           this.dispose();
                        }
                        else {
                         JOptionPane.showMessageDialog(null, " Please Enter Valid Student ID!!", "Non Existed ID", JOptionPane.ERROR_MESSAGE);
                        }
                    
                } catch (Exception ex) {
                }
            } 
                 
                } else if (txtstid.getText().equals("")) {
                    c = gcb.getSelectedItem().toString();
                    switch (c) {
                        case "Ten":
                            cl = "ten";
                            new ClassDisplay910(cl);
                           this.dispose();
                            break;

                        case "Nine":
                            cl = "nine";
                            new ClassDisplay910(cl);
                             this.dispose();
                            break;

                        case "Eight":
                            cl = "eight";
                            new ClassDisplay8(cl);
                              this.dispose();
                            break;

                        case "Seven":
                            cl = "seven";
                            new ClassDisplay7(cl);
                           this.dispose();
                            break;

                        case "Six":
                            cl = "six";
                            new ClassDisplay67(cl);
                            this.dispose();
                            break;

                        case "Five":
                            cl = "five";
                            new ClassDisplay15(cl);
                          this.dispose();
                            break;

                        case "Four":
                            cl = "four";
                            new ClassDisplay15(cl);
                             this.dispose();
                            break;

                        case "Three":
                            cl = "three";
                            new ClassDisplay15(cl);
                             this.dispose();
                            break;

                        case "Two":
                            cl = "two";
                            new ClassDisplay15(cl);
                              this.dispose();
                            break;

                        case "One":
                            cl = "one";
                            new ClassDisplay15(cl);
                            this.dispose();
                            break;
                            
                         case "U.K.G":
                            cl = "ukg";
                            new ClassDisplayUKG(cl);
                          this.dispose();
                            break;
                             
                              case "L.K.G":
                            cl = "lkg";
                            new ClassDisplayLKG(cl);
                              this.dispose();
                            break;
                                  
                                   case "Nursery":
                            cl = "nursery";
                            new ClassDisplayNursery(cl);
                           this.dispose();
                            break;
                    }
                }
        
        if(e.getSource()==gcb){
        if(gcb.getSelectedIndex()!=0){
        txtstid.setEnabled(false);
        }
        else{
        txtstid.setEnabled(true);
        }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == gcb) {
            txtstid.setEnabled(false);
        }
        if (e.getSource() == txtstid) {
            {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//            if (gcb.getSelectedItem() == "" && txtstid.getText().equals("")) {
//                JOptionPane.showMessageDialog(null, "Please enter either student ID or grade to view result !!", "Result Viewing Error", JOptionPane.ERROR_MESSAGE);
//            } 
//            
//              else if (gcb.getSelectedItem().equals("")) {
//                    id = Integer.parseInt(txtstid.getText());
//                    new IdMarksDisplay(id);
//                    this.dispose();
//
//                } else if (txtstid.getText().equals("")) {
//                    c = gcb.getSelectedItem().toString();
//                    switch (c) {
//                       case "Ten":
//                            cl = "ten";
//                            new ClassDisplay910(cl);
//                            this.dispose();
//                            break;
//
//                        case "Nine":
//                            cl = "nine";
//                            new ClassDisplay910(cl);
//                            this.dispose();
//                            break;
//
//                        case "Eight":
//                            cl = "eight";
//                            new ClassDisplay8(cl);
//                            this.dispose();
//                            break;
//
//                        case "Seven":
//                            cl = "seven";
//                            new ClassDisplay7(cl);
//                            this.dispose();
//                            break;
//
//                        case "Six":
//                            cl = "six";
//                            new ClassDisplay67(cl);
//                            this.dispose();
//                            break;
//
//                        case "Five":
//                            cl = "five";
//                            new ClassDisplay15(cl);
//                            this.dispose();
//                            break;
//
//                        case "Four":
//                            cl = "four";
//                            new ClassDisplay15(cl);
//                            this.dispose();
//                            break;
//
//                        case "Three":
//                            cl = "three";
//                            new ClassDisplay15(cl);
//                            this.dispose();
//                            break;
//
//                        case "Two":
//                            cl = "two";
//                            new ClassDisplay15(cl);
//                            this.dispose();
//                            break;
//
//                        case "One":
//                            cl = "one";
//                            new ClassDisplay15(cl);
//                            this.dispose();
//                            break;
//                            
//                         case "U.K.G":
//                            cl = "ukg";
//                            new ClassDisplayUKG(cl);
//                            this.dispose();
//                            break;
//                             
//                              case "L.K.G":
//                            cl = "lkg";
//                            new ClassDisplayLKG(cl);
//                            this.dispose();
//                            break;
//                                  
//                                   case "Nursery":
//                            cl = "nursery";
//                            new ClassDisplayNursery(cl);
//                            this.dispose();
//                            break;
//                    }
//                }
//            }
        }
    

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource()==txtstid){
            if(txtstid.getText().length()>0){
        gcb.setEnabled(false);
            }     
             else{
            gcb.setEnabled(true);
            }
             if (txtstid.getText().length() > 4) {
                  txtstid.setText(txtstid.getText().substring(0, 4));
                JOptionPane.showMessageDialog(null, "Maximum Digits Reached", "ID Length Error !!", JOptionPane.ERROR_MESSAGE);
               
            }
        }
        }
    }

