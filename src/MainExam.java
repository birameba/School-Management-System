
import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainExam extends JFrame implements ActionListener, MouseListener, WindowListener {

    JPanel pane, pane1, pane2, pane3;
    JMenuBar menuBar;
    JMenu mhelp, mexamination, mbar, mabout, mbackup;
    JMenuItem misnew, misedit, misview,
            mitnew, mitedit, mitview,
            memark, meadmit, meentry, meview,megrade,
            examhelp,
            mdeveloper, msoftware;
    JDesktopPane jdp;
    JButton admitcard, brecordex, marksentry, marksheet, useraccountpanel, changepw, logout, logoff, exit, backup, viewmarks;
    JLabel admingreeting, tinfo, mainform, jtime, admin, jlapplelogo, trecordex, jldeveloper1, jldeveloper2;

    public MainExam() {

        Font ft8 = new Font("", Font.BOLD, 25);
        Font ft = new Font("", Font.BOLD, 16);
        Font ft1 = new Font("", Font.BOLD, 15);
        Font ft2 = new Font("", Font.BOLD, 17);
        Font ft5 = new Font("", Font.BOLD, 20);
        
        
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
        mexamination = new JMenu("Examination");
        mbackup = new JMenu("Backup");
        mabout = new JMenu("About");
        mhelp = new JMenu("Help");

        mexamination.setFont(ft1);
        mbackup.setFont(ft1);
        mabout.setFont(ft1);
        mhelp.setFont(ft1);

        mexamination.addMouseListener(this);
        mabout.addMouseListener(this);
        mbackup.addMouseListener(this);
        mhelp.addMouseListener(this);
       

        mbar = new JMenu("|");
        mbar.setFont(ft8);
        menuBar.add(mbar);

        menuBar.add(mexamination);
        meadmit = new JMenuItem("Admit Card");
        mexamination.add(meadmit);
        mexamination.addSeparator();
        meadmit.setFont(ft1);
        meadmit.addActionListener(this);

        meentry = new JMenuItem("Marks Entry");
        mexamination.add(meentry);
        mexamination.addSeparator();
        meentry.setFont(ft1);
        meentry.addActionListener(this);

        memark = new JMenuItem("MarkSheet");
        mexamination.add(memark);
         mexamination.addSeparator();
        memark.setFont(ft1);
        memark.addActionListener(this);
        
         megrade = new JMenuItem("View Grades");
        mexamination.add(megrade);
         mexamination.addSeparator();
        megrade.setFont(ft1);
        megrade.addActionListener(this);

        meview = new JMenuItem("View Marks");
        mexamination.add(meview);
        meview.setFont(ft1);
        meview.addActionListener(this);

        mbar = new JMenu("|");
        mbar.setFont(ft8);
        menuBar.add(mbar);

        menuBar.add(mbackup);
       
        mbar = new JMenu("|");
        mbar.setFont(ft8);
        menuBar.add(mbar);

        menuBar.add(mabout);
        mbar = new JMenu("|");
        mbar.setFont(ft8);
        menuBar.add(mbar);

        msoftware = new JMenuItem("Software");
        mabout.add(msoftware);
         mabout.addSeparator();
        msoftware.setFont(ft1);
        msoftware.addActionListener(this);

        mdeveloper = new JMenuItem("Developer");
        mabout.add(mdeveloper);
         
        mdeveloper.setFont(ft1);
        mdeveloper.addActionListener(this);

        menuBar.add(mhelp);
        mbar = new JMenu("|");
        mbar.setFont(ft8);
        menuBar.add(mbar);

        examhelp = new JMenuItem("Examination Section Help");
        mhelp.add(examhelp);
        examhelp.setFont(ft1);
        examhelp.addActionListener(this);
          mbackup.addActionListener(this);

        
        admin = new JLabel(new ImageIcon("images/admin.png"));
        pane1.add(admin);
        admin.setFont(ft5);
        admin.setBounds(25, 10, 82, 90);

        tinfo = new JLabel("Hello,Administrator");
        pane1.add(tinfo);
        tinfo.setFont(ft5);
        tinfo.setBounds(138, 23, 600, 30);
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

        logoff = new JButton("Log Out", new ImageIcon("images/logout.png"));
        pane1.add(logoff);
        logoff.setFont(ft5);
        logoff.setBounds(900, 30, 180, 45);
        logoff.setBackground(Color.getHSBColor(200, 99, 87));
        logoff.setForeground(Color.BLACK);
        logoff.addActionListener(this);

        exit = new JButton("Exit", new ImageIcon("images/exit.png"));
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

        admitcard = new JButton("Admit Card", new ImageIcon("images/admit.png"));
        pane2.add(admitcard);
        admitcard.setFont(ft2);
        admitcard.setBounds(0, 70, 300, 45);
        admitcard.setBackground(Color.WHITE);
        admitcard.setForeground(Color.BLACK);
        admitcard.addActionListener(this);

        marksentry = new JButton("Marks Entry", new ImageIcon("images/marksentry.png"));
        pane2.add(marksentry);
        marksentry.setFont(ft2);
        marksentry.setBounds(0, 120, 300, 45);
        marksentry.setBackground(Color.WHITE);
        marksentry.setForeground(Color.BLACK);
        marksentry.addActionListener(this);

        marksheet = new JButton("Mark Sheet", new ImageIcon("images/marksheet.png"));
        pane2.add(marksheet);
        marksheet.setFont(ft2);
        marksheet.setBounds(0, 170, 300, 45);
        marksheet.setBackground(Color.WHITE);
        marksheet.setForeground(Color.BLACK);
        marksheet.addActionListener(this);

        viewmarks = new JButton("View Grades", new ImageIcon("images/viewgrades.png"));
        pane2.add(viewmarks);
        viewmarks.setFont(ft2);
        viewmarks.setBounds(0, 220, 300, 45);
        viewmarks.setBackground(Color.WHITE);
        viewmarks.setForeground(Color.BLACK);
        viewmarks.addActionListener(this);

        backup = new JButton("Backup Data", new ImageIcon("images/backup.png"));
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

        changepw = new JButton("Change Password", new ImageIcon("images/changepassword.png"));
        pane2.add(changepw);
        changepw.setFont(ft2);
        changepw.setBounds(0, 405, 300, 45);
        changepw.setBackground(Color.WHITE);
        changepw.setForeground(Color.BLACK);
        changepw.addActionListener(this);

        logout = new JButton("Log Out", new ImageIcon("images/logout.png"));
        pane2.add(logout);
        logout.setFont(ft2);
        logout.setBounds(0, 455, 300, 45);
        logout.setBackground(Color.WHITE);
        logout.setForeground(Color.BLACK);
        logout.addActionListener(this);

        mainform = new JLabel(new ImageIcon("images/mainform.png"));
        pane3.add(mainform);
        mainform.setBounds(470, 90, 768, 600);

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
        setSize(500, 500);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setIconImage(new ImageIcon("images/fb.png").getImage());
        setTitle("Apple Academy--Examination Section");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new MainExam();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mbackup) {
            new BackupData();

        }

        if (e.getSource() == logoff || e.getSource() == logout) {
            new ExaminationLogin();
            this.dispose();
        }
        if (e.getSource() == exit) {
            new StartPage();
            this.dispose();
        }

        if (e.getSource() == admitcard) {
            new AdmitCardText();
        }
        if (e.getSource() == marksentry) {
            new ChooseClass();
        }
        if (e.getSource() == marksheet) {
            new MarkSheetMain();
        }
        if (e.getSource() == viewmarks || e.getSource()== megrade) {
            new GradeClassView();
        }

        if (e.getSource() == backup) {
            new BackupData();

        }
        if (e.getSource() == changepw) {
            new ChangeAccount();

        }

        if (e.getSource() == memark) {
            new MarkSheetMain();
        }
        if (e.getSource() == meadmit) {
            new AdmitCardText();
        }
        if (e.getSource() == meentry) {
            new ChooseClass();
        }
        if (e.getSource() == meview) {
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
        if (e.getSource() == mbackup) {
            mbackup.setForeground(Color.BLUE);
//            mbackup.setOpaque(true);
//            mbackup.setBackground(Color.YELLOW);
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

        if (e.getSource() == mbackup) {
            mbackup.setForeground(Color.BLACK);
           // mbackup.setOpaque(false);
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
           // mabout.setOpaque(false);
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
                //System.exit(0);
                this.dispose();
                new ExaminationLogin();
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
