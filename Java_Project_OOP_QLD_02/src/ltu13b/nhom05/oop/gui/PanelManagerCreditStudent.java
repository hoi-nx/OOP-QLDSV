package ltu13b.nhom05.oop.gui;

import jdk.nashorn.internal.scripts.JO;
import ltu13b.nhom05.oop.interfaces.CallBackInterfaces;
import ltu13b.nhom05.oop.interfaces.MyMouseListener;
import ltu13b.nhom05.oop.object.QuanLy;
import ltu13b.nhom05.oop.object.QuanLyChung;
import ltu13b.nhom05.oop.object.SinhVienTinChi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;


public class PanelManagerCreditStudent extends BasePanel {
    private JTextField txtSID, txtDoB, txtEmail, txtPN, txtName, txtES, txtAddress, txtClass, txtFaculty, txtFind;
    private JComboBox<String> cbbDoBD, cbbDoBM, cbbDoBY, cbbSex, cbbES;
    private JTable table;
    private JButton btnXemDiem;

    private QuanLyChung<SinhVienTinChi> quanLyChung;
    private SinhVienTinChi sinhVienTinChi;
    private String path;

    private CallBackInterfaces callBackInterfaces;

    private SimpleDateFormat simpleDateFormat;

    public void setCallBackInterfaces(CallBackInterfaces callBackInterfaces) {
        this.callBackInterfaces = callBackInterfaces;
    }

    public PanelManagerCreditStudent(int sizeWidth, int sizeHeight) {
        super(sizeWidth, sizeHeight);
        simpleDateFormat = new SimpleDateFormat("d/M/yyyy");
        path = getClass().getResource("/res/file/CreditStudent.data").getPath().replaceAll("%20", " ");
        quanLyChung = new QuanLyChung<>();
        showDanhSachSinhVienTinChi();
        onClick();

    }

    @Override
    public void initPanel() {
        // TODO Auto-generated method stub
        setBounds(0, 0, W_FRAME_MANAGER, H_FRAME_MANAGER);
        setLayout(null);
        setBackground(Color.WHITE);

    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);
        g2d.drawImage(IMG_TITLE, 0, 0, W_FRAME_MANAGER, 80, null);
        //g2d.drawImage(imgBG, 0, 0, W_FRAME_MANAGER, H_FRAME_MANAGER, null);

    }

    @Override
    public void initControls() {



        // TODO Auto-generated method stub
        Font font = new Font(null, Font.PLAIN, 20);
        int wTxt = 250;
        int hTxt = 30;
        int i;

        JLabel lblSID = new JLabel();
        JLabel lblDoB = new JLabel();
        JLabel lblEmail = new JLabel();
        JLabel lblSex = new JLabel();
        JLabel lblPN = new JLabel();
        JLabel lblName = new JLabel();
        JLabel lblES = new JLabel();
        JLabel lblAddress = new JLabel();
        JLabel lblClass = new JLabel();
        JLabel lblFaculty = new JLabel();
        JLabel lblFind = new JLabel();


        allJlable(lblSID, "Student ID", 30, 130, 20, font, Color.BLACK);
        allJlable(lblDoB, "Date of Birth", 30, 180, 20, font, Color.BLACK);
        allJlable(lblEmail, "Email", 30, 230, 20, font, Color.BLACK);
        allJlable(lblSex, "Sex", 30, 280, 20, font, Color.BLACK);
        allJlable(lblPN, "Phone Number", 30, 330, 20, font, Color.BLACK);
        allJlable(lblName, "Full Name", 550, 130, 20, font, Color.BLACK);
        //allJlable(lblES, "Educational System", 480, 180, 20, font, Color.BLACK);
        allJlable(lblAddress, "Address", 550, 230, 20, font, Color.BLACK);
        allJlable(lblClass, "Class", 550, 280, 20, font, Color.BLACK);
        allJlable(lblFaculty, "Faculty", 550, 180, 20, font, Color.BLACK);
        allJlable(lblFind, "Search", 370, 380, 20, font, Color.BLACK);

        txtSID = new JTextField();
        //txtDoB    = new JTextField();
        txtEmail = new JTextField();
        txtPN = new JTextField();
        txtName = new JTextField();
        txtES = new JTextField();
        txtAddress = new JTextField();
        txtClass = new JTextField();
        txtFaculty = new JTextField();
        txtFind = new JTextField();

        allJtext(txtSID, 180, 120, wTxt, hTxt);
        //allJtext(txtDoB, 180, 170, wTxt, hTxt);
        allJtext(txtEmail, 180, 220, wTxt, hTxt);
        allJtext(txtPN, 180, 320, wTxt, hTxt);
        allJtext(txtName, 680, 120, wTxt, hTxt);
        allJtext(txtAddress, 680, 220, wTxt, hTxt);
        allJtext(txtClass, 680, 270, wTxt, hTxt);
        allJtext(txtFaculty, 680, 170, wTxt, hTxt);
        allJtext(txtFind, 450, 380, wTxt + 100, hTxt);

        cbbDoBD = new JComboBox<String>();
        cbbDoBM = new JComboBox<String>();
        cbbDoBY = new JComboBox<String>();
        cbbSex = new JComboBox<String>();
        cbbES = new JComboBox<String>();

        allJComboBox(cbbDoBD, 180, 170, 60, hTxt);
        for (i = 1; i <= 31; i++) {
            String str = String.valueOf(i);
            cbbDoBD.addItem(str);
        }
        allJComboBox(cbbDoBM, 260, 170, 60, hTxt);
        for (i = 1; i <= 12; i++) {
            String str = String.valueOf(i);
            cbbDoBM.addItem(str);
        }
        allJComboBox(cbbDoBY, 340, 170, 90, hTxt);
        for (i = 1985; i <= 2000; i++) {
            String str = String.valueOf(i);
            cbbDoBY.addItem(str);
        }

        allJComboBox(cbbSex, 180, 270, wTxt, hTxt);
        cbbSex.addItem("Male");
        cbbSex.addItem("Female");

//		allJComboBox(cbbES, 680, 170, wTxt, hTxt);
//		cbbES.addItem("Annual System");
//		cbbES.addItem("Credit System");

        btnAdd = new JButton();
        btnUpdate = new JButton();
        btnDelete = new JButton();
        btnFind = new JButton();
        btnReset = new JButton();
        btnXemDiem = new JButton();

        allJButton(btnAdd, ID_BUTTON_ADD, 1020, 120, 110, 40, ICON_ADD);
        allJButton(btnUpdate, ID_BUTTON_UPDATE, 1020, 170, 110, 40, ICON_UPDATE);
        allJButton(btnDelete, ID_BUTTON_DELETE, 1020, 220, 110, 40, ICON_DELETE);
        allJButton(btnFind, ID_BUTTON_FIND, 805, 370, 110, 40, ICON_FIND);
        allJButton(btnReset, ID_BUTTON_RESET, 1020, 270, 110, 40, ICON_RESET);
        allJButton(btnXemDiem, ID_BUTTON_XEM_DIEM, 1020, 350, 110, 40, ICON_RESET);
        btnXemDiem.setEnabled(false);

        initTable();

    }

    private void initTable() {

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Student ID");
        tableModel.addColumn("Full Name");
        tableModel.addColumn("Date of Birth");
        tableModel.addColumn("Email");
        tableModel.addColumn("Address");
        tableModel.addColumn("Sex");
        tableModel.addColumn("Class");
        tableModel.addColumn("Faculty");
        tableModel.addColumn("Phone Number");


        table = new JTable(tableModel);

        JScrollPane csTable = new JScrollPane(table,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        csTable.setBounds(0, 450, W_FRAME_MANAGER, 3 * H_FRAME_MANAGER / 8);
        add(csTable);
    }

    @Override
    public void initEvent() {
        addEvents();

        btnXemDiem.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        switch (e.getActionCommand()) {
            case ID_BUTTON_ADD:
                addSinhVien();

                break;
            case ID_BUTTON_UPDATE:
                updateSinhVien();

                break;
            case ID_BUTTON_DELETE:
                xoaSinhVien();
                break;
            case ID_BUTTON_FIND:
                searchCreditStudent();
                break;
            case ID_BUTTON_RESET:
                reset();
                break;
            case ID_BUTTON_XEM_DIEM:
                int row = table.getSelectedRow();
                if (row < 0) {
                    return;
                }
                String maSinhVien = (String) table.getValueAt(row, 0);
                callBackInterfaces.onPanelScoreOfCreditStudentOfManager(maSinhVien);
                break;

            default:
                break;
        }

    }

    private void searchCreditStudent() {
        if (!txtFind.getText().equals("")) {
            String text_search = txtFind.getText().trim();
            Vector<Object> vector1 = new Vector<>();
            vector1.addElement("Student ID");
            vector1.addElement("Full Name");
            vector1.addElement("Date of Birth");
            vector1.addElement("Email");
            vector1.addElement("Address");
            vector1.addElement("Sex");
            vector1.addElement("Class");
            vector1.addElement("Faculty");
            vector1.addElement("Phone Number");


            Vector data = new Vector();
            for (SinhVienTinChi sv : quanLyChung.readObject(path)) {
                //if (sv.getMaSinhVien().contains(txtFind.getText())) {
                Vector<Object> vector2 = new Vector<>();
                vector2.add(sv.getMaSinhVien());
                vector2.add(sv.getTen());
                Date date = sv.getNgaySinh();
                String d = simpleDateFormat.format(date);
                vector2.add(d);
                vector2.add(sv.getMail());
                vector2.add(sv.getDiaChi());
                vector2.add(sv.isGioiTinh() ? "Nam" : "Nữ");
                vector2.add(sv.getLop());
                vector2.add(sv.getKhoa());
                vector2.add(sv.getSoDienThoai());

//                if (vector2.toString().contains(text_search)) {
//                    data.addElement(vector2);
//                }
                if (vector2.toString().toLowerCase().contains(text_search.toLowerCase())) {
                    data.addElement(vector2);
                }
            }
            // }
            table.setModel(new DefaultTableModel(data, vector1));
        } else {
            showDanhSachSinhVienTinChi();


        }
    }


    private void addSinhVien() {
        if (checkTxt(txtSID) || checkTxt(txtEmail) || checkTxt(txtPN) || checkTxt(txtName) || checkTxt(txtAddress) || checkTxt(txtClass) || checkTxt(txtFaculty)) {
            JOptionPane.showMessageDialog(null, "Don't be Empty!", "Error", JOptionPane.PLAIN_MESSAGE);
        } else {
            khoiTaoSinhVienTinChi();
            if (quanLyChung.addObject(sinhVienTinChi)) {
                JOptionPane.showMessageDialog(null, "Thêm Thành Công");
                quanLyChung.saveObject(quanLyChung.getLists(), path);
                showDanhSachSinhVienTinChi();
            } else {
                JOptionPane.showMessageDialog(null, "Mời bạn kiểm tra lại \n Có thể mã số sinh viên bị trùng");
            }
        }
    }

    private void updateSinhVien() {
        if (checkTxt(txtSID) || checkTxt(txtEmail) || checkTxt(txtPN) || checkTxt(txtName) || checkTxt(txtAddress) || checkTxt(txtClass) || checkTxt(txtFaculty)) {
            JOptionPane.showMessageDialog(null, "Don't be Empty!", "Error", JOptionPane.PLAIN_MESSAGE);
        } else {
            khoiTaoSinhVienTinChi();
            if (quanLyChung.updateObject(sinhVienTinChi)) {
                int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn cập nhập không", "Confrim", JOptionPane.YES_NO_OPTION);
                if (check == JOptionPane.OK_OPTION) {
                    JOptionPane.showMessageDialog(null, "Cập Nhập Thành Công");
                    quanLyChung.saveObject(quanLyChung.getLists(), path);
                    showDanhSachSinhVienTinChi();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Cập Nhập Thất Bại");
            }
        }
    }

    private void xoaSinhVien() {
        ImageIcon IMG_QUESTION=new ImageIcon(getClass().getResource("/res/question.png"));
        khoiTaoSinhVienTinChi();
        if (quanLyChung.removeObject(sinhVienTinChi)) {
            int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không", "Confrim", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,IMG_QUESTION);
            if (check == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(null, "Xóa Thành Công");
                quanLyChung.saveObject(quanLyChung.getLists(), path);
                showDanhSachSinhVienTinChi();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Xóa Thất Bại");
        }
    }

    private void khoiTaoSinhVienTinChi() {
        String tmp = cbbDoBD.getSelectedItem() + "/" + cbbDoBM.getSelectedItem() + "/" + cbbDoBY.getSelectedItem();
        SimpleDateFormat x = new SimpleDateFormat("d/M/yyyy");
        Date d = null;
        try {
            d = x.parse(tmp);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        boolean s = true;
        if (cbbSex.getSelectedItem().equals("Male")) s = true;
        else s = false;
        sinhVienTinChi = new SinhVienTinChi(txtName.getText(), d, s, txtAddress.getText(), Integer.parseInt(txtPN.getText()), txtEmail.getText(),
                txtSID.getText(), txtClass.getText(), txtFaculty.getText());
    }


    public boolean checkTxt(JTextField txt) {
        if (txt.getText().equals("")) return true;
        return false;
    }

    private void onClick() {
        MyMouseListener myMouseListener = new MyMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table.getSelectedRow();
                String studentID = (String) table.getValueAt(row, 0);
                txtSID.setText(studentID);
                String name = (String) table.getValueAt(row, 1);
                txtName.setText(name);
                String dateOfBirth = (String) table.getValueAt(row, 2);
                String[] split = dateOfBirth.split("/");
                cbbDoBD.setSelectedItem(split[0]);
                cbbDoBM.setSelectedItem(split[1]);
                cbbDoBY.setSelectedItem(split[2]);
                String email = (String) table.getValueAt(row, 3);
                txtEmail.setText(email);
                String address = (String) table.getValueAt(row, 4);
                txtAddress.setText(address);
                String sex = (String) table.getValueAt(row, 5);
                cbbSex.setSelectedItem(sex);
                String mClass = (String) table.getValueAt(row, 6);
                txtClass.setText(mClass);
                String faculty = (String) table.getValueAt(row, 7);
                txtFaculty.setText(faculty);
                int phone = (int) table.getValueAt(row, 8);
                txtPN.setText(phone + "");
                btnXemDiem.setEnabled(true);
                btnDelete.setEnabled(true);
                btnUpdate.setEnabled(true);
            }
        };
        table.addMouseListener(myMouseListener);
    }


    public void showDanhSachSinhVienTinChi() {
        tableModel.setRowCount(0);
        for (SinhVienTinChi sv : quanLyChung.readObject(path)) {
            Vector<Object> vector = new Vector<>();
            vector.add(sv.getMaSinhVien());
            vector.add(sv.getTen());
            Date date = sv.getNgaySinh();
            String d = simpleDateFormat.format(date);
            vector.add(d);
            vector.add(sv.getMail());
            vector.add(sv.getDiaChi());
            vector.add(sv.isGioiTinh() ? "Nam" : "Nữ");
            vector.add(sv.getLop());
            vector.add(sv.getKhoa());
            vector.add(sv.getSoDienThoai());
            vector.add(sv.getTongSoTinChi());

            tableModel.addRow(vector);
        }
        table.setModel(tableModel);
    }

    private void reset() {
        btnXemDiem.setEnabled(false);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        // TODO Auto-generated method stub
        int i = JOptionPane.showConfirmDialog(null, "Do you want to reset?", "", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.OK_OPTION) {
            txtSID.setText(null);
            txtEmail.setText(null);
            txtPN.setText(null);
            txtName.setText(null);
            txtFaculty.setText(null);
            txtClass.setText(null);
            txtAddress.setText(null);
            cbbDoBD.setSelectedIndex(0);
            cbbDoBM.setSelectedIndex(0);
            cbbDoBY.setSelectedIndex(0);
            cbbSex.setSelectedIndex(0);
            showDanhSachSinhVienTinChi();
        }
    }

}
