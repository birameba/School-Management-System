import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainAccount extends JFrame implements ActionListener, MouseListener, WindowListener {

    JPanel pane, pane1, pane2, pane3;
    JMenuBar menuBar;
    JMenu mstudent, mteacher, mtransaction,mbackup,mbar, mhelp, mabout, mtteacher, mtstudent;
    JMenuItem misnew, misedit, misview,
            mitnew, mitedit, mitview,
            mttnew, mttview,
            mtsview, mtsnew, mtsprint,
            sthelp, thelp, tthelp, stthelp,
            mdeveloper, msoftware;
    JDesktopPane jdp;
    JButton admitcard, brecordex,addnew,makenew,viewrecord,viewtrans, useraccountpanel, changepw,logout, logoff, exit, backup;
    JLabel admingreeting, admin,tinfo, mainform,jtime, jlapplelogo,image, trecordex, jldeveloper1, jldeveloper2;


    public MainAccount() {
          Font ft8= new Font("", Font.BOLD, 25);
         Font ft = new Font("", Font.BOLD, 17);
          // Font ft3 = new Font("", Font.BOLD, 19);
        Font ft1 = new Font("", Font.BOLD, 15);
         Font ft5 = new Font("", Font.BOLD, 20);
        Font ft2 = new Font("", Font.BOLD, 17);

        pane = new JPanel();
        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.WHITE);

        pane1 = new JPanel();
        add(pane1);
        pane1.setLayout(null);
        pane1.setBackground(new Color(228, 58, 54));
        // pane1.setSize(250, 900);
        pane1.setBounds(0, 2, 1400, 110);

        pane2 = new JPanel();
        add(pane2);
        pane2.setLayout(null);
        pane2.setBackground(Color.getHSBColor(348, 99, 87));
        // pane1.setSize(250, 900);
        pane2.setBounds(0, 115, 300, 900);

        pane3 = new JPanel();
        add(pane3);
        pane3.setLayout(null);
        pane3.setBackground(Color.WHITE);
        // pane1.setSize(250, 900);
        pane3.setBounds(303, 115, 1300, 900);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        //menuBar.setSize(1400, 35);

        mstudent = new JMenu("Student");
        mteacher = new JMenu("Teacher");
        mtransaction = new JMenu("Transaction");
        mbackup=new JMenu("Backup");
        mabout = new JMenu("About");
        mhelp = new JMenu("Help");

        mstudent.setFont(ft2);
        mteacher.setFont(ft2);
        mtransaction.setFont(ft2);
        mabout.setFont(ft2);
        mbackup.setFont(ft2);
        mhelp.setFont(ft2);
        
        
        mstudent.addMouseListener(this);
        mteacher.addMouseListener(this);
        mbackup.addMouseListener(this);
        mtransaction.addMouseListener(this);
        mabout.addMouseListener(this);
        mhelp.addMouseListener(this);
       

        misnew = new JMenuItem("New");
        misview = new JMenuItem("View");
        misedit = new JMenuItem("Edit");

        misnew.setFont(ft1);
        misedit.setFont(ft1);
        misview.setFont(ft1);
        misnew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
        misedit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
        misview.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));

        
         mbar=new JMenu("|");
        mbar.setFont(ft8);
          menuBar.add(mbar);
        menuBar.add(mstudent);
        mstudent.add(misnew);
        misnew.addActionListener(this);
        mstudent.addSeparator();
        mstudent.add(misview);
        misview.addActionListener(this);
         mstudent.addSeparator();
        mstudent.add(misedit);
        misedit.addActionListener(this);

        mitnew = new JMenuItem("New");
        mitview = new JMenuItem("View");
        mitedit = new JMenuItem("Edit");

        mitnew.setFont(ft1);
        mitview.setFont(ft1);
        mitedit.setFont(ft1);
        mitnew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
        mitedit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
        mitview.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));

      mbar=new JMenu("|");
      mbar.setFont(ft8);
          menuBar.add(mbar);
          
        menuBar.add(mteacher);
        mteacher.add(mitnew);
        mteacher.addSeparator();
        mteacher.add(mitview);
         mteacher.addSeparator();
        mteacher.add(mitedit);
       
        mitnew.addActionListener(this);
        mitedit.addActionListener(this);
        mitview.addActionListener(this);

         mbar=new JMenu("|");
      mbar.setFont(ft8);
          menuBar.add(mbar);
        menuBar.add(mtransaction);
        mtstudent = new JMenu("Student");
        mtransaction.add(mtstudent);
        mtstudent.setFont(ft1);
        mtteacher = new JMenu("Teacher");
        mtransaction.addSeparator();
        mtransaction.add(mtteacher);
        mtteacher.setFont(ft1);

        mttnew = new JMenuItem("New Transaction");
        mttview = new JMenuItem("View");
        mtteacher.add(mttnew);
        mtteacher.addSeparator();
        mtteacher.add(mttview);
        mttnew.setFont(ft1);
        mttview.setFont(ft1);
        mttnew.addActionListener(this);
        mttview.addActionListener(this);
        mttnew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
        mttview.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));

        mtsnew = new JMenuItem("Make Transaction");
        mtsprint = new JMenuItem("Print Receipt");
        mtsview = new JMenuItem("View");
        mtstudent.add(mtsnew);
        mtstudent.addSeparator();
        mtstudent.add(mtsprint);
         mtstudent.addSeparator();
        mtstudent.add(mtsview);
        mtsnew.setFont(ft1);
        mtsprint.setFont(ft1);
        mtsview.setFont(ft1);
        mtsnew.addActionListener(this);
        mtsprint.addActionListener(this);
        mtsview.addActionListener(this);
        mtsnew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_MASK));
        mtsprint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
        mtsview.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));
        
         mbar=new JMenu("|");
      mbar.setFont(ft8);
          menuBar.add(mbar);
       
             
        menuBar.add(mbackup);
        mbackup.addActionListener(this);
        
         mbar=new JMenu("|");
      mbar.setFont(ft8);
          menuBar.add(mbar);
        menuBar.add(mabout);
        msoftware = new JMenuItem("Software");
        mabout.add(msoftware);
        msoftware.setFont(ft1);
        msoftware.addActionListener(this);
        mabout.addSeparator();
        mdeveloper = new JMenuItem("Developer");
        mabout.add(mdeveloper);
        mdeveloper.setFont(ft1);
        mdeveloper.addActionListener(this);

         mbar=new JMenu("|");
      mbar.setFont(ft8);
          menuBar.add(mbar);
        menuBar.add(mhelp);
        sthelp = new JMenuItem("Student Help");
        mhelp.add(sthelp);
        sthelp.setFont(ft1);
        sthelp.addActionListener(this);
        mhelp.addSeparator();
        thelp = new JMenuItem("Teacher Help");
        mhelp.add(thelp);
        thelp.setFont(ft1);
        thelp.addActionListener(this);
         mhelp.addSeparator();
        stthelp = new JMenuItem("Student Transaction Help");
        mhelp.add(stthelp);
        stthelp.setFont(ft1);
        stthelp.addActionListener(this);
         mhelp.addSeparator();
        tthelp = new JMenuItem("Teacher Transaction Help");
        mhelp.add(tthelp);
        tthelp.setFont(ft1);
        tthelp.addActionListener(this);
          mbar=new JMenu("|");
      mbar.setFont(ft8);
          menuBar.add(mbar);

//        image = new JLabel(new ImageIcon("images/accounting.png"));
//        pane.add(image);
//        image.setBounds(0, 500, 360, 18);
        
        
        admin = new JLabel(new ImageIcon("images/admin.png"));
        pane1.add(admin);
        admin.setFont(ft5);
        admin.setBounds(25, 10, 82, 90);
        

          tinfo = new JLabel("Hello, Accountant !!");
        pane1.add(tinfo);
        tinfo.setFont(ft5);
       tinfo.setBounds(138, 15, 400, 40);
        tinfo.setBackground(Color.WHITE);
        tinfo.setForeground(Color.WHITE);
        
           jtime=new JLabel();
           pane1.add(jtime);
           jtime.setFont(ft);
        jtime.setBounds(138,53,600,30);
         jtime.setForeground(Color.WHITE);
         Thread timer=new Thread(){
             public void run(){
                 while(true){
        SimpleDateFormat ft=new SimpleDateFormat( "'Date:' yyyy-MM-dd, E   'Time: ' hh:mm:ss a zzz");
        jtime.setText(ft.format(new Date()));
        
                 }
             }
         };
         timer.start();

        logoff = new JButton("Log Out",new ImageIcon("images/logout.png"));
        pane1.add(logoff);
        logoff.setFont(ft5);
        logoff.setBounds(900, 30, 180, 45);
        logoff.setBackground(Color.getHSBColor(200, 99, 87));
        logoff.setForeground(Color.BLACK);
        logoff.addActionListener(this);

        exit = new JButton("Exit",new ImageIcon("images/exit.png"));
        pane1.add(exit);
        exit.setFont(ft5);
        exit.setBounds(1130, 30, 170, 45);
        exit.setBackground(Color.getHSBColor(200, 99, 87));
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);

        brecordex = new JButton("Record Explorer");
        pane2.add(brecordex);
        brecordex.setFont(ft);
        brecordex.setBounds(0, 0, 300, 50);
        brecordex.setBackground(Color.BLACK);
        brecordex.setForeground(Color.WHITE);

        addnew = new JButton("Add New Record",new ImageIcon("images/addnewrecord.png"));
        pane2.add(addnew);
        addnew.setFont(ft2);
        addnew.setBounds(0, 70, 300, 45);
        addnew.setBackground(Color.WHITE);
        addnew.setForeground(Color.BLACK);
        addnew.addActionListener(this);

        makenew = new JButton("Make New Transaction",new ImageIcon("images/makenewtransaction.png"));
        pane2.add(makenew);
        makenew.setFont(ft2);
        makenew.setBounds(0, 120, 300, 45);
        makenew.setBackground(Color.WHITE);
        makenew.setForeground(Color.BLACK);
        makenew.addActionListener(this);

        viewrecord = new JButton("View Record",new ImageIcon("images/viewrecord.png"));
        pane2.add(viewrecord);
        viewrecord.setFont(ft2);
        viewrecord.setBounds(0, 170, 300, 45);
        viewrecord.setBackground(Color.WHITE);
        viewrecord.setForeground(Color.BLACK);
        viewrecord.addActionListener(this);

        viewtrans = new JButton("View Transaction",new ImageIcon("images/viewtransaction.png"));
        pane2.add(viewtrans);
        viewtrans.setFont(ft2);
        viewtrans.setBounds(0, 220, 300, 45);
        viewtrans.setBackground(Color.WHITE);
        viewtrans.setForeground(Color.BLACK);
        viewtrans.addActionListener(this);

        backup = new JButton("Backup Data",new ImageIcon("images/backup.png"));
        pane2.add(backup);
        backup.setFont(ft2);
        backup.setBounds(0, 270, 300, 45);
        backup.setBackground(Color.WHITE);
        backup.setForeground(Color.BLACK);
        backup.addActionListener(this);

        useraccountpanel = new JButton("User Account Panel");
        pane2.add(useraccountpanel);
        useraccountpanel.setFont(ft);
        useraccountpanel.setBounds(0, 335, 300, 50);
        useraccountpanel.setBackground(Color.BLACK);
        useraccountpanel.setForeground(Color.WHITE);

        changepw = new JButton("Change Password",new ImageIcon("images/changepassword.png"));
        pane2.add(changepw);
        changepw.setFont(ft2);
        changepw.setBounds(0, 405, 300, 45);
        changepw.setBackground(Color.WHITE);
        changepw.setForeground(Color.BLACK);
        changepw.addActionListener(this);

        logout = new JButton("Log Out",new ImageIcon("images/logout.png"));
        pane2.add(logout);
        logout.setFont(ft2);
        logout.setBounds(0, 455, 300, 45);
        logout.setBackground(Color.WHITE);
        logout.setForeground(Color.BLACK);
        logout.addActionListener(this);
        mainform = new JLabel(new ImageIcon("images/mainform.png"));
        pane3.add(mainform);
        mainform.setBounds(470, 90, 768, 600);

        
        jldeveloper1=new JLabel("Developed By:    Tilak Bahadur Basnet");
        pane3.add(jldeveloper1);
        jldeveloper1.setBounds(1045,600,500,35);
         jldeveloper1.setFont(ft);
        jldeveloper1.setForeground(Color.BLUE);
        
         jldeveloper2=new JLabel("Ichchha Moktan");
        pane3.add(jldeveloper2);
        jldeveloper2.setBounds(1180,630,500,35);
         jldeveloper2.setFont(ft);
        jldeveloper2.setForeground(Color.BLUE);
        
        addWindowListener(this);
        setSize(500, 500);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setIconImage(new ImageIcon("images/fb.png").getImage());
        setTitle("Apple Academy-Account Section");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new MainAccount();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == logoff || e.getSource() == logout) {
            new AccountLogin();
            this.dispose();
        }
           if (e.getSource() == backup) {
            new BackupData();
          
        }
            if (e.getSource() == mbackup) {
            new BackupData();
            }
            
          if (e.getSource() == exit) {
            new StartPage();
            this.dispose();
        }
          
           if (e.getSource() == addnew) {
            new AddNew();
        }
          if (e.getSource() == viewrecord) {
            new ViewRecords();
        }
           if (e.getSource() == viewtrans) {
            new ViewTransactions();
        }
          if (e.getSource() == makenew) {
            new MakeNewTransactions();
        }
         
           if (e.getSource() == changepw) {
            new ChangeAccount();
            this.dispose();
        }
        
        if (e.getSource() == misnew) {
            new NewStudent();
        }
        if (e.getSource() == misedit) {
            new EditStudent();
        }
        if (e.getSource() == misview) {
            new ViewStudent();
        }
        if (e.getSource() == mitnew) {
            new NewTeacher();
        }
        if (e.getSource() == mitedit) {
            new EditTeacher();
        }
        if (e.getSource() == mitview) {
            new ViewTeacher();
        }
        if (e.getSource() == mttnew) {
            new AskIdTeacher();
        }
        if (e.getSource() == mttview) {
            new ViewTeacherTransaction();
        }

        if (e.getSource() == mtsnew) {
            new AskId();
        }
        if (e.getSource() == mtsprint) {
            new IdTransaction();
        }

        if (e.getSource() == mtsview) {
            new ViewStudentTransaction();
        }
        if (e.getSource() == sthelp) {
            new StudentHelp();
        }
        if (e.getSource() == thelp) {
            new TeacherHelp();
        }
        if (e.getSource() == stthelp) {
            new StTransactionHelp();
        }
        if (e.getSource() == tthelp) {
            new TtTransactionHelp();
        }
        if (e.getSource() == mdeveloper) {
            new About();
        }
        if (e.getSource() == msoftware) {
            new Software();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
         if (e.getSource() == mbackup) {
            mbackup.setForeground(Color.BLUE);
         }
         
        if (e.getSource() == mstudent) {
            mstudent.setForeground(Color.BLUE);
           // mstudent.setOpaque(true);
            //mstudent.setBackground(Color.WHITE);
        }
        if (e.getSource() == mteacher) {
            mteacher.setForeground(Color.BLUE);
//            mteacher.setOpaque(true);
//            mteacher.setBackground(Color.WHITE);
        }
        if (e.getSource() == mtransaction) {
            mtransaction.setForeground(Color.BLUE);
//            mtransaction.setOpaque(true);
//            mtransaction.setBackground(Color.WHITE);
        }

        if (e.getSource() == mhelp) {
            mhelp.setForeground(Color.BLUE);
//            mhelp.setOpaque(true);
//            mhelp.setBackground(Color.WHITE);
        }
        if (e.getSource() == mabout) {
            mabout.setForeground(Color.BLUE);
//            mabout.setOpaque(true);
//            mabout.setBackground(Color.WHITE);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == mstudent) {
            mstudent.setForeground(Color.BLACK);
            //mstudent.setOpaque(false);
        }

         if (e.getSource() == mbackup) {
            mbackup.setForeground(Color.BLACK);
         }
         
        if (e.getSource() == mteacher) {
            mteacher.setForeground(Color.BLACK);
//            mteacher.setOpaque(false);
        }

        if (e.getSource() == mtransaction) {
            mtransaction.setForeground(Color.BLACK);
            //mtransaction.setOpaque(false);
        }

        if (e.getSource() == mhelp) {
            mhelp.setForeground(Color.BLACK);
            //mhelp.setOpaque(false);
        }

        if (e.getSource() == mabout) {
            mabout.setForeground(Color.BLACK);
            //mabout.setOpaque(false);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if(e.getWindow()==this){
        String ObjButtons[] = {"Yes", "No"};
        int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit the program?", "Exit Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, ObjButtons, ObjButtons[1]);
        if (PromptResult == JOptionPane.YES_OPTION) {
            //System.exit(0);
             this.dispose();
            new AccountLogin();
        }
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //new StartPage();
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
