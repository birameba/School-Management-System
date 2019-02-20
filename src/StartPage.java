//////////////////////////////Start Page for the application///////////////////////////////////////////
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StartPage extends JFrame implements ActionListener, WindowListener,MouseListener {
    JLabel jacc,jexam1,jtime,jadmin1;
    JButton jadmin, jexam, jaccount;
    Font ft1 = new Font("", Font.BOLD, 20);
    Font ft2 = new Font("", Font.PLAIN, 12);
    Font ft5 = new Font("", Font.BOLD, 15);
//    @Override
//    public void setDefaultCloseOperation(int operation) {
//        super.setDefaultCloseOperation(operation); //To change body of generated methods, choose Tools | Templates.
//    }

    public StartPage() {

        jacc = new JLabel(new ImageIcon("images/Accounting1.png"));
         add(jacc).setBounds(70, 310, 93,93);
         jacc.addMouseListener(this);
       
          jexam1 = new JLabel(new ImageIcon("images/exam1.png"));
         add(jexam1).setBounds(70, 170, 90,90);
         jexam1.addMouseListener(this);
        
          jadmin1 = new JLabel(new ImageIcon("images/admin1.png"));
         add(jadmin1).setBounds(70, 35, 90,90);
         jadmin1.addMouseListener(this);
         
        jadmin = new JButton("Administration");
          add(jadmin).setBounds(172, 51, 220, 55);
        jadmin.setBackground(new Color(30,144,255));
        jadmin.setForeground(Color.BLACK);
        jadmin.setFont(ft1);
        jadmin.addActionListener(this);
        jadmin.addMouseListener(this);

        jexam = new JButton("Examination");
        add(jexam).setBounds(172, 186, 220, 55);
        jexam.setBackground(new Color(0,255,127));
        jexam.setForeground(Color.BLACK);
        jexam.setFont(ft1);
        jexam.addActionListener(this);
        jexam.addMouseListener(this);

        jaccount = new JButton("Account Section");
        add(jaccount).setBounds(172, 331, 220, 55);
       jaccount.setBackground(new Color(255,99,71));
        jaccount.setForeground(Color.BLACK);
        jaccount.setFont(ft1);
        jaccount.addActionListener(this);
        jaccount.addMouseListener(this);
        
        
        jtime=new JLabel();
        add(jtime).setBounds(198,415,350,30);
         jtime.setForeground(Color.BLACK);
         jtime.setFont(ft5);
         Thread timer=new Thread(){
             public void run(){
                 while(true){
        SimpleDateFormat ft=new SimpleDateFormat( "'Date:' yyyy-MM-dd, E   'Time: ' hh:mm:ss a zzz");
        jtime.setText(ft.format(new Date()));
        jtime.setFont(ft2);
                 }
             }
         };
         timer.start();
          
        
        addWindowListener(this);
        setLayout(null);
        setSize(490, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setTitle("Apple Academy--USERS");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }

        SplashClass sp = new SplashClass();
        try {
            Thread.sleep(6000);
        } catch (Exception e) {
        }
        sp.dispose();

        new StartPage();
    }

       public String DateTime(){
          String dd;
          Date date=new Date();
        //SimpleDateFormat ft=new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        dd=date.toString();
        return(dd);
        }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jadmin) {
            new HomeForm();
            this.dispose();
        }
        if (e.getSource() == jexam) {
            new ExaminationLogin();
            this.dispose();
        }
        if (e.getSource() == jaccount) {
            new AccountLogin();
            this.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        String ObjButtons[] = {"Yes", "No"};
        int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit the program?", "Exit Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, ObjButtons, ObjButtons[1]);
        if (PromptResult == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

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

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==jacc){
         new AccountLogin();
            this.dispose();
        }
         if (e.getSource() == jexam1) {
            new ExaminationLogin();
            this.dispose();
        }
        if (e.getSource() == jadmin1) {
            new HomeForm();
            this.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==jadmin){
         jadmin.setBackground(new Color(0,0,255));
        jadmin.setForeground(Color.WHITE);
        }
        if(e.getSource()==jaccount){
          jaccount.setBackground(new Color(255,0,0));
        jaccount.setForeground(Color.WHITE);
        }
        if(e.getSource()==jexam){
          jexam.setBackground(new Color(0,255,0));
        jexam.setForeground(Color.WHITE);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
          if(e.getSource()==jadmin){
         jadmin.setBackground(new Color(30,144,255));
        jadmin.setForeground(Color.BLACK);
          }
         if(e.getSource()==jexam){
         jexam.setBackground(new Color(0,255,127));
        jexam.setForeground(Color.BLACK);
         }
         if(e.getSource()==jaccount){
         jaccount.setBackground(new Color(255,99,71));
        jaccount.setForeground(Color.BLACK);
        
        }
    }
}
