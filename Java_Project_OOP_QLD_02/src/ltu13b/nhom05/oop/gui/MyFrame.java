package ltu13b.nhom05.oop.gui;

import ltu13b.nhom05.oop.interfaces.CallBackInterfaces;
import ltu13b.nhom05.oop.interfaces.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Heart Of Dead on 4/23/2017.
 */
public class MyFrame extends JFrame implements CallBackInterfaces, ActionListener,Constants {
    private PanelLogin panelLogin;
    private JTabbedPane jTabbedPane;
    private PanelManagerCreditStudent managerCreditStudent;
    private PanelManagerStudentYearly panelManagerStudentYearly;
    private PanelInfoUser panelInfoUser;
    private PanelInfoGredit panelInfoGredit;
    private PanelOfCreditStudent panelOfCreditStudent;
    private PanelOfStudentYearly panelOfStudentYearly;

    private JMenuBar jMenuBar;
    private JMenuItem jMenuItem;
    private JMenu jMenu;

    public MyFrame() {
        initFrame();
        addPanel();


        //panelOfCreditStudent=new PanelOfCreditStudent(Constants.W_FRAME_MANAGER,Constants.H_FRAME_MANAGER,"1");


    }

    private void addPanel() {
        panelLogin = new PanelLogin(W_FRAME_LOGIN,H_FRAME_LOGIN);
        panelLogin.setCallBackInterfaces(this);
        add(panelLogin);
    }

    private void initFrame() {
        setSize(W_FRAME_LOGIN, H_FRAME_LOGIN);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new CardLayout());
    }


    @Override
    public void onPanelOfCreditStudent(String id) {
        System.out.println(id);
        remove(panelLogin);
        setSize(W_FRAME_MANAGER, H_FRAME_MANAGER);
        setLocationRelativeTo(null);
        panelOfCreditStudent = new PanelOfCreditStudent(W_FRAME_MANAGER, H_FRAME_MANAGER, id, false);
        add(panelOfCreditStudent);

    }

    @Override
    public void onPanelOfManager() {
        remove(panelLogin);
        showPanelOfManager();
        // validate();


    }

    private void showPanelOfManager() {
        jTabbedPane = new JTabbedPane();
        setSize(W_FRAME_MANAGER, H_FRAME_MANAGER);
        setLocationRelativeTo(null);
        managerCreditStudent = new PanelManagerCreditStudent(W_FRAME_MANAGER, Constants.H_FRAME_MANAGER);
        managerCreditStudent.setCallBackInterfaces(this);
        panelManagerStudentYearly = new PanelManagerStudentYearly(Constants.W_FRAME_MANAGER, Constants.H_FRAME_MANAGER);
        panelInfoUser = new PanelInfoUser(Constants.W_FRAME_MANAGER, Constants.H_FRAME_MANAGER);
        panelInfoGredit = new PanelInfoGredit(Constants.W_FRAME_MANAGER, Constants.H_FRAME_MANAGER);

        jTabbedPane.add("Quản Lý Sinh Viên Tín Chỉ", managerCreditStudent);
        jTabbedPane.add("Quản Lý Sinh Viên Niên Chế", panelManagerStudentYearly);
        jTabbedPane.add("Quản Lý Tài Khoản Sử Dụng", panelInfoUser);
        jTabbedPane.add("Quản lý học phần tín chỉ", panelInfoGredit);
        // jTabbedPane.add("Quản lý ĐIỂM",panelOfCreditStudent);
        add(jTabbedPane);

        jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);
        jMenu = new JMenu("File");
        jMenuItem = new JMenuItem("Logout");
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        jMenuItem.setIcon(IMG_EXIT_JMENU);
        jMenuItem.addActionListener(this);
        jMenu.add(jMenuItem);
        jMenuBar.add(jMenu);
    }

    @Override
    public void onPanelOfYearlyStudent() {
        remove(panelLogin);
        setSize(Constants.W_FRAME_MANAGER, Constants.H_FRAME_MANAGER);
        setLocationRelativeTo(null);
        panelOfStudentYearly = new PanelOfStudentYearly(Constants.W_FRAME_MANAGER, Constants.H_FRAME_MANAGER);
        add(panelOfStudentYearly);
    }

    @Override
    public void onPanelScoreOfCreditStudentOfManager(String idSv) {
        System.out.println(idSv);
        remove(jTabbedPane);
        panelOfCreditStudent = new PanelOfCreditStudent(Constants.W_FRAME_MANAGER, Constants.H_FRAME_MANAGER, idSv, true);
        //jTabbedPane.add("Quản lý ĐIỂM",panelOfCreditStudent);
        panelOfCreditStudent.setCallBackInterfaces(this);

        add(panelOfCreditStudent);
        validate();
    }

    @Override
    public void onBackPanelOfManager() {
        remove(panelOfCreditStudent);
        showPanelOfManager();
        validate();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        remove(jTabbedPane);
        jMenuBar.setVisible(false);
        setSize(Constants.W_FRAME_LOGIN, Constants.H_FRAME_LOGIN);
        setLocationRelativeTo(null);
        addPanel();
        validate();

    }
}
