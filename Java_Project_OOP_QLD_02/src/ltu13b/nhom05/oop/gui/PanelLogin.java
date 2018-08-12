package ltu13b.nhom05.oop.gui;

import ltu13b.nhom05.oop.interfaces.CallBackInterfaces;
import ltu13b.nhom05.oop.interfaces.MyKeyListener;
import ltu13b.nhom05.oop.manager.QuanLyDangNhap;
import ltu13b.nhom05.oop.object.QuanLy;
import ltu13b.nhom05.oop.object.QuanLyChung;
import ltu13b.nhom05.oop.object.TaiKhoan;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

/**
 * Created by Heart Of Dead on 4/23/2017.
 */
public class PanelLogin extends BasePanel{
    private JButton btnLogin, btnLogout;
    private JLabel lblUsername, lblPass;
    private JTextField txtUsername;
    private JLabel lblTitle;
    private JPasswordField txtPass;
    private JCheckBox jCheckBox;
    private QuanLyDangNhap quanLyDangNhap;

    private CallBackInterfaces callBackInterfaces;
    private QuanLyChung<TaiKhoan>taiKhoanQuanLyChung;
    private TaiKhoan taiKhoan;


    public void setCallBackInterfaces(CallBackInterfaces callBackInterfaces) {
        this.callBackInterfaces = callBackInterfaces;
    }

    public PanelLogin(int sizeWidth, int sizeHeight) {
        super(sizeWidth, sizeHeight);
        quanLyDangNhap=new QuanLyDangNhap();
        taiKhoanQuanLyChung=new QuanLyChung<>();
        hienThiLaiThongTinDangNhap();

        loginEnter();

    }

    private void loginEnter() {
        MyKeyListener myKeyListener=new MyKeyListener(){
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    checkLogin();
                }
            }
        };
        txtPass.addKeyListener(myKeyListener);
        txtUsername.addKeyListener(myKeyListener);
    }


    @Override
    public void initPanel() {
        setLayout(null);

    }

    @Override
    public void initControls() {
        Font font = new Font("Tohama", Font.ITALIC, 25);


        lblTitle = createLabel(LBL_TITLE_LOGIN, 50, 30, 25, font, Color.BLUE);


        lblUsername = createLabel(LBL_USERNAME, 30, 100, 25, font, Color.RED);


        lblPass = createLabel(LBL_PASS, 30, 160, 25, font, Color.RED);


        txtUsername = createTextField(180, 100, 300, 30);
        add(txtUsername);

        txtPass = new JPasswordField();
        txtPass.setBounds(180, 160, 300, 30);
        add(txtPass);

        btnLogin = createButton(ID_BUTTON_LOGIN, 30, 250, 250, 70, ICON_LOGIN);
        btnLogout = createButton(ID_BUTTON_LOGOUT, 310, 250, 250, 70, ICON_LOGOUT);


        jCheckBox = new JCheckBox("Save Account Information");
        jCheckBox.setBounds(200, 200, 200, 20);

        Border border = BorderFactory.createLineBorder(Color.RED);
        TitledBorder titledBorder = new TitledBorder(border, "Thông tin đăng nhập");
        titledBorder.setTitleJustification(TitledBorder.CENTER);
        titledBorder.setTitleColor(Color.BLUE);
        setBorder(titledBorder);


    }

    @Override
    public void initEvent() {
        add(lblTitle);
        add(lblUsername);
        add(lblPass);
        add(btnLogin);
        add(btnLogout);
        add(jCheckBox);
        btnLogin.addActionListener(this);
        btnLogout.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = e.getActionCommand();
        switch (id) {
            case ID_BUTTON_LOGIN:
                checkLogin();

                break;
            case ID_BUTTON_LOGOUT:
                System.exit(0);
                break;
        }

    }

    private void checkLogin() {
        if(jCheckBox.isSelected()){
            taiKhoan=new TaiKhoan(txtUsername.getText(),txtPass.getText());
            taiKhoanQuanLyChung.addObject(taiKhoan);
            taiKhoanQuanLyChung.saveObject(taiKhoanQuanLyChung.getLists(),"login.data");

        }else{
            taiKhoan=new TaiKhoan("","");
            taiKhoanQuanLyChung.addObject(taiKhoan);
            taiKhoanQuanLyChung.saveObject(taiKhoanQuanLyChung.getLists(),"login.data");
        }
        if(quanLyDangNhap.checkAdmin(txtUsername.getText(),txtPass.getText())){
            callBackInterfaces.onPanelOfManager();
        }else if(quanLyDangNhap.checkSinhVien(txtUsername.getText(),txtPass.getText())){
            callBackInterfaces.onPanelOfCreditStudent(txtPass.getText());
        }else if(quanLyDangNhap.checkSinhVienNienChe(txtUsername.getText(),txtPass.getText())){
            callBackInterfaces.onPanelOfYearlyStudent();
        }else {
            JOptionPane.showMessageDialog(null,"Tài Khoản Không Hợp Lệ");
        }
    }

    public void hienThiLaiThongTinDangNhap(){
        File f = new File("login.data");
        if (f.exists()) {
            if (taiKhoanQuanLyChung.readObject("login.data") != null) {
                for(TaiKhoan dn:taiKhoanQuanLyChung.readObject("login.data")){
                    txtUsername.setText(dn.getTenDangNhap());
                    txtPass.setText(dn.getMatKhau());

                }
                jCheckBox.setSelected(true);

            }

        }
    }



}
