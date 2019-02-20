
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainForm extends JFrame implements ActionListener, MouseListener, WindowListener {

    JPanel pane;
    JPanel pane1, pane2, pane3;
    JMenuBar menuBar;
    JMenu mstudent, mteacher, mbar, mtransaction, mhelp, mexamination, mabout, mtteacher, mtstudent;
    JMenuItem misview,
            mitview,
            mttview,
            mtsview,
            memark,megrade,
            examhelp,
            mdeveloper, msoftware;
    JDesktopPane jdp;
    JButton viewstr, brecordex, viewtr, viewstt, useraccountpanel, changepw, logout, logoff, exit, viewtt, viewmarks;
    JLabel admingreeting, admin, tinfo, mainform, jtime, jlapplelogo, trecordex, jldeveloper1, jldeveloper2;

    public MainForm() {
        Font ft8 = new Font("", Font.BOLD, 24);
        Font ft = new Font("", Font.BOLD, 17);
        Font ft5 = new Font("", Font.BOLD, 20);
        // Font ft3 = new Font("", Font.BOLD, 2);
        Font ft4 = new Font("", Font.BOLD, 18);
        Font ft1 = new Font("", Font.BOLD, 15);
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

        mstudent = new JMenu("Student");
        mteacher = new JMenu("Teacher");
        mtransaction = new JMenu("Transaction");
        mexamination = new JMenu("Examination");
        mabout = new JMenu("About");
        mhelp = new JMenu("Help");

        mstudent.setFont(ft1);
        mteacher.setFont(ft1);
        mtransaction.setFont(ft1);
        mexamination.setFont(ft1);
        mabout.setFont(ft1);
        mhelp.setFont(ft1);

        mstudent.addMouseListener(this);
        mteacher.addMouseListener(this);
        mtransaction.addMouseListener(this);
        mexamination.addMouseListener(this);
        mabout.addMouseListener(this);
        mhelp.addMouseListener(this);

        mbar = new JMenu("|");
        mbar.setFont(ft8);
        menuBar.add(mbar);
        
        misview = new JMenuItem("View");
        misview.setFont(ft1);
        misview.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));
        menuBar.add(mstudent);
        mstudent.add(misview);
        misview.addActionListener(this);

        mitview = new JMenuItem("View");
        mitview.setFont(ft1);
        mitview.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));
        mbar = new JMenu("|");
        mbar.setFont(ft8);
        menuBar.add(mbar);

        menuBar.add(mteacher);
        mteacher.add(mitview);
        mitview.addActionListener(this);

        mbar = new JMenu("|");
        mbar.setFont(ft8);
        menuBar.add(mbar);

        menuBar.add(mtransaction);
        mtstudent = new JMenu("Student");
        mtransaction.add(mtstudent);
        mtstudent.setFont(ft1);
        mtransaction.addSeparator();
        mtteacher = new JMenu("Teacher");
        mtransaction.add(mtteacher);
        mtteacher.setFont(ft1);

        mttview = new JMenuItem("View");

        mtteacher.add(mttview);

        mttview.setFont(ft1);

        mttview.addActionListener(this);

        mttview.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));

        mtsview = new JMenuItem("View");

        mtstudent.add(mtsview);

        mtsview.setFont(ft1);

        mtsview.addActionListener(this);

        mtsview.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));

        mbar = new JMenu("|");
        mbar.setFont(ft8);
        menuBar.add(mbar);
        menuBar.add(mexamination);
        megrade = new JMenuItem("Display Grade");
        mexamination.add(megrade);
        megrade.setFont(ft1);
        megrade.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_MASK));
        megrade.addActionListener(this);
        
         memark = new JMenuItem("Display Marks");
        mexamination.add(memark);
        memark.setFont(ft1);
        memark.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
        memark.addActionListener(this);

        mbar = new JMenu("|");
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

        mbar = new JMenu("|");
        mbar.setFont(ft8);
        menuBar.add(mbar);
        menuBar.add(mhelp);
        examhelp = new JMenuItem("Display Marks Help");
        mhelp.add(examhelp);
        examhelp.setFont(ft1);
        examhelp.addActionListener(this);
        mbar = new JMenu("|");
        mbar.setFont(ft8);
        menuBar.add(mbar);

        admin = new JLabel(new ImageIcon("images/admin.png"));
        pane1.add(admin);
        admin.setFont(ft5);
        admin.setBounds(25, 10, 82, 90);

        tinfo = new JLabel("Hello, Administrator !!");
        pane1.add(tinfo);
        tinfo.setFont(ft5);
        tinfo.setBounds(138, 15, 400, 40);
        tinfo.setBackground(Color.WHITE);
        tinfo.setForeground(Color.WHITE);

        jtime = new JLabel();
        pane1.add(jtime);
        jtime.setFont(ft);
        jtime.setBounds(138, 53, 600, 30);
        jtime.setForeground(Color.WHITE);
        Thread timer = new Thread() {
            public void run() {
                while (true) {
                    SimpleDateFormat ft = new SimpleDateFormat("'Date:' yyyy-MM-dd, E   'Time: ' hh:mm:ss a zzz");
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

        viewstr = new JButton("View Student Record",new ImageIcon("images/viewrecord1.png"));
        pane2.add(viewstr);
        viewstr.setFont(ft2);
        viewstr.setBounds(0, 70, 300, 45);
        viewstr.setBackground(Color.WHITE);
        viewstr.setForeground(Color.BLACK);
        viewstr.addActionListener(this);

        viewtr = new JButton("View Teacher Record",new ImageIcon("images/viewrecord1.png"));
        pane2.add(viewtr);
        viewtr.setFont(ft2);
        viewtr.setBounds(0, 120, 300, 45);
        viewtr.setBackground(Color.WHITE);
        viewtr.setForeground(Color.BLACK);
        viewtr.addActionListener(this);

        viewstt = new JButton("View Student Transactions",new ImageIcon("images/transaction.png"));
        pane2.add(viewstt);
        viewstt.setFont(ft2);
        viewstt.setBounds(0, 170, 300, 45);
        viewstt.setBackground(Color.WHITE);
        viewstt.setForeground(Color.BLACK);
        viewstt.addActionListener(this);

        viewtt = new JButton("View Teacher Transactions",new ImageIcon("images/transaction.png"));
        pane2.add(viewtt);
        viewtt.setFont(ft2);
        viewtt.setBounds(0, 220, 300, 45);
        viewtt.setBackground(Color.WHITE);
        viewtt.setForeground(Color.BLACK);
        viewtt.addActionListener(this);

        viewmarks = new JButton("View Grade",new ImageIcon("images/viewgrades.png"));
        pane2.add(viewmarks);
        viewmarks.setFont(ft2);
        viewmarks.setBounds(0, 270, 300, 45);
        viewmarks.setBackground(Color.WHITE);
        viewmarks.setForeground(Color.BLACK);
        viewmarks.addActionListener(this);

        useraccountpanel = new JButton("User Account Panel");
        pane2.add(useraccountpanel);
        useraccountpanel.setFont(ft);
        useraccountpanel.setBounds(0, 335, 300, 50);
        useraccountpanel.setForeground(Color.WHITE);
        useraccountpanel.setBackground(Color.BLACK);

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
        mainform.setBounds(160, -10, 768, 600);

        
        jldeveloper1 = new JLabel("Developed By:    Tilak Bahadur Basnet");
        pane3.add(jldeveloper1);
        jldeveloper1.setBounds(1045, 600, 500, 35);
        jldeveloper1.setFont(ft);
        jldeveloper1.setForeground(Color.BLUE);

        jldeveloper2 = new JLabel("Ichchha Moktan");
        pane3.add(jldeveloper2);
        jldeveloper2.setBounds(1180, 630, 500, 35);
        jldeveloper2.setFont(ft);
        jldeveloper2.setForeground(Color.BLUE);

        addWindowListener(this);
        setLayout(null);
        setSize(500, 500);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setIconImage(new ImageIcon("images/fb.png").getImage());
        setTitle("Apple Academy-School Management System");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new MainForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoff) {
            new HomeForm();
            this.dispose();
        }
        if (e.getSource() == exit) {
            new StartPage();
            this.dispose();
        }

        if (e.getSource() == viewstr) {
            new AdminViewStudent();

           ///////////////////////if we want to disable the  non required buttons in the called class/////////////////////////////////////
//            ViewStudent v = new ViewStudent();
//            v.btndelete.setVisible(false);
//            v.btnedit.setVisible(false);
        }
        if (e.getSource() == viewtr) {
            new AdminViewTeacher();

        }
        if (e.getSource() == viewstt) {
            new AdminViewStudentTransaction();

        }
        if (e.getSource() == viewtt) {
            new AdminViewTeacherTransaction();

        }

        if (e.getSource() == viewmarks) {
            new GradeClassView();

        }
        if (e.getSource() == changepw) {
            new ChangePassword();
            this.dispose();
        }
        if (e.getSource() == logout) {
            new HomeForm();
            this.dispose();
        }

        if (e.getSource() == misview) {
            new AdminViewStudent();
        }

        if (e.getSource() == mitview) {
            new AdminViewTeacher();
        }

        if (e.getSource() == mttview) {
            new AdminViewTeacherTransaction();
        }
         if (e.getSource() == megrade) {
            new GradeClassView();
        }

        if (e.getSource() == mtsview) {
            new AdminViewStudentTransaction();
        }

        if (e.getSource() == memark) {
            new ChooseClassView();
        }

        if (e.getSource() == examhelp) {
            new ExamHelp();
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
        if (e.getSource() == mstudent) {
            mstudent.setForeground(Color.BLUE);
//            mstudent.setOpaque(true);
//            mstudent.setBackground(Color.YELLOW);
        }
        if (e.getSource() == mteacher) {
            mteacher.setForeground(Color.BLUE);
//            mteacher.setOpaque(true);
//            mteacher.setBackground(Color.YELLOW);
        }
        if (e.getSource() == mtransaction) {
            mtransaction.setForeground(Color.BLUE);
//            mtransaction.setOpaque(true);
//            mtransaction.setBackground(Color.YELLOW);
        }
        if (e.getSource() == mexamination) {
            mexamination.setForeground(Color.BLUE);
//            mexamination.setOpaque(true);
//            mexamination.setBackground(Color.YELLOW);
        }
        if (e.getSource() == mhelp) {
            mhelp.setForeground(Color.BLUE);
//            mhelp.setOpaque(true);
//            mhelp.setBackground(Color.YELLOW);
        }
        if (e.getSource() == mabout) {
            mabout.setForeground(Color.BLUE);
//            mabout.setOpaque(true);
//            mabout.setBackground(Color.YELLOW);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == mstudent) {
            mstudent.setForeground(Color.BLACK);
            //mstudent.setOpaque(false);
        }

        if (e.getSource() == mteacher) {
            mteacher.setForeground(Color.BLACK);
            //mteacher.setOpaque(false);
        }

        if (e.getSource() == mtransaction) {
            mtransaction.setForeground(Color.BLACK);
            //mtransaction.setOpaque(false);
        }

        if (e.getSource() == mexamination) {
            mexamination.setForeground(Color.BLACK);
            //mexamination.setOpaque(false);
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
        if (e.getWindow() == this) {
            String ObjButtons[] = {"Yes", "No"};
            int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit the program?", "Exit Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, ObjButtons, ObjButtons[1]);
            if (PromptResult == JOptionPane.YES_OPTION) {
                // System.exit(0);
                this.dispose();
                new HomeForm();
            }
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
}
