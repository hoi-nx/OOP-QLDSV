/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltu13b.nhom05.oop.gui;

import ltu13b.nhom05.oop.interfaces.MyMouseListener;
import ltu13b.nhom05.oop.manager.MyManagerPanel;
import ltu13b.nhom05.oop.object.QuanLy;
import ltu13b.nhom05.oop.object.QuanLyChung;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Administrator
 *///Vũ
public class PanelInfoUser extends BasePanel {

    private JTable table;
    private JLabel lblID, lblChucVu, lblTen, lblNgaySinh, lblGioiTinh, lblDiaChi, lblSoDienThoai, lblEmail;
    private JTextField txtID, txtTen, txtNgaySinh, txtDiaChi, txtSoDienThoai, txtEmail, txtFind;
    private JComboBox cbbChucVu;
    private JRadioButton rbNam, rbNu;
    private ButtonGroup btnGroupSex;

    private MyMouseListener myMouseListener;
    private QuanLy quanLy;

    private QuanLyChung<QuanLy> quanLyChung;
    private String path;
    private SimpleDateFormat simpleDateFormat;

    public PanelInfoUser(int sizeWidth, int sizeHeight) {
        super(sizeWidth, sizeHeight);
        quanLyChung = new QuanLyChung<>();
        simpleDateFormat = new SimpleDateFormat("d/M/yyyy");
        path = getClass().getResource("/res/file/Manager.data").getPath().replaceAll("%20", " ");
        showDanhSachNguoiQuanLy();
        onClick();

    }

    private void showDanhSachNguoiQuanLy() {
//        tableModel.setRowCount(0);
        tableModel = new DefaultTableModel();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d/M/yyyy");
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Tên");
        tableModel.addColumn("Ngày Sinh");
        tableModel.addColumn("Giới Tính");
        tableModel.addColumn("Địa Chỉ");
        tableModel.addColumn("Số Điện Thoại");
        tableModel.addColumn("Email");
        tableModel.addColumn("ID");
        tableModel.addColumn("Chức Vụ");
        for (QuanLy quanLy : quanLyChung.readObject(path)) {
            Vector<Object> vector = new Vector<>();
            vector.add(quanLy.getTen());
            Date date = quanLy.getNgaySinh();
            String d = simpleDateFormat.format(date);
            vector.add(d);
            vector.add(quanLy.isGioiTinh() ? "Nam" : "Nữ");
            vector.add(quanLy.getDiaChi());
            vector.add(quanLy.getSoDienThoai());
            vector.add(quanLy.getMail());
            vector.add(quanLy.getMaQuanLy());
            vector.add(quanLy.getChucVu());
            tableModel.addRow(vector);
        }
        table.setModel(tableModel);
    }

    private void onClick() {
        myMouseListener = new MyMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table.getSelectedRow();
                if (row != -1) {
                    txtTen.setText(table.getValueAt(row, 0).toString());
                    txtNgaySinh.setText(table.getValueAt(row, 1).toString());
                    txtDiaChi.setText(table.getValueAt(row, 3).toString());
                    cbbChucVu.setSelectedItem(table.getValueAt(row, 7));
                    txtSoDienThoai.setText(table.getValueAt(row, 4).toString());
                    txtEmail.setText(table.getValueAt(row, 5).toString());
                    txtID.setText(table.getValueAt(row, 6).toString());
                    boolean sSex = ((String) table.getValueAt(row, 2)).equals("Nam");
                    if (sSex) {
                        rbNam.setSelected(true);
                    } else {
                        rbNu.setSelected(true);
                    }
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);

                }
            }
        };
        table.addMouseListener(myMouseListener);
    }

    @Override
    public void initPanel() {
        setLayout(null);
    }

    @Override
    public void initControls() {
        initTitle();
        initPanelCenter();
        initTable();
    }

    private void initPanelCenter() {
        panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBounds(0, panelTitle.getHeight(), sizeWidth, sizeHeight / 2);
        panelCenter.setBackground(Color.WHITE);
        add(panelCenter);
        Font font = new Font("", Font.PLAIN, 20);
        int withPanelCenter = panelCenter.getWidth();
        int heighPanelCenter = panelCenter.getHeight();
        lblTen = createLabel("Họ và tên:", withPanelCenter / 10, heighPanelCenter / 6, 25, font, null);
        panelCenter.add(lblTen);
        txtTen = createTextField(withPanelCenter / 5, heighPanelCenter / 6, sizeWidth / 5, HEIGHT_CONTROLS);
        panelCenter.add(txtTen);
        lblNgaySinh = createLabel("Ngày Sinh:", withPanelCenter / 10, 2 * heighPanelCenter / 6, 25, font, null);
        panelCenter.add(lblNgaySinh);
        txtNgaySinh = createTextField(withPanelCenter / 5, 2 * heighPanelCenter / 6, sizeWidth / 5, HEIGHT_CONTROLS);
        panelCenter.add(txtNgaySinh);
        lblGioiTinh = createLabel("Giới Tính:", withPanelCenter / 10, 3 * heighPanelCenter / 6, 25, font, null);
        panelCenter.add(lblGioiTinh);
        rbNam = createRadioButton("Nam", withPanelCenter / 5, 3 * heighPanelCenter / 6, sizeWidth / 10, HEIGHT_CONTROLS, Color.WHITE);
        panelCenter.add(rbNam);
        rbNu = createRadioButton("Nữ", withPanelCenter / 5 + withPanelCenter / 10, 3 * heighPanelCenter / 6, sizeWidth / 10, HEIGHT_CONTROLS, Color.WHITE);
        panelCenter.add(rbNu);
        btnGroupSex = new ButtonGroup();
        btnGroupSex.add(rbNam);
        btnGroupSex.add(rbNu);
        lblDiaChi = createLabel("Địa Chỉ:", withPanelCenter / 10, 4 * heighPanelCenter / 6, 25, font, null);
        panelCenter.add(lblDiaChi);
        txtDiaChi = createTextField(withPanelCenter / 5, 4 * heighPanelCenter / 6, sizeWidth / 5, HEIGHT_CONTROLS);
        panelCenter.add(txtDiaChi);
        lblID = createLabel("ID:", withPanelCenter / 2, 4 * heighPanelCenter / 6, 25, font, null);
        panelCenter.add(lblID);
        txtID = createTextField(3 * withPanelCenter / 5, 4 * heighPanelCenter / 6, sizeWidth / 5, HEIGHT_CONTROLS);
        panelCenter.add(txtID);
        lblSoDienThoai = createLabel("SĐT:", withPanelCenter / 2, 2 * heighPanelCenter / 6, 25, font, null);
        panelCenter.add(lblSoDienThoai);
        txtSoDienThoai = createTextField(3 * withPanelCenter / 5, 2 * heighPanelCenter / 6, sizeWidth / 5, HEIGHT_CONTROLS);
        panelCenter.add(txtSoDienThoai);
        lblEmail = createLabel("Email:", withPanelCenter / 2, 3 * heighPanelCenter / 6, 25, font, null);
        panelCenter.add(lblEmail);
        txtEmail = createTextField(3 * withPanelCenter / 5, 3 * heighPanelCenter / 6, sizeWidth / 5, HEIGHT_CONTROLS);
        panelCenter.add(txtEmail);
        txtFind = createTextField(1 * withPanelCenter / 3, 5 * heighPanelCenter / 6, sizeWidth / 3, sizeHeight / 20);
        panelCenter.add(txtFind);
        lblChucVu = createLabel("Chức Vụ:", withPanelCenter / 2, heighPanelCenter / 6, 25, font, null);
        panelCenter.add(lblChucVu);

        cbbChucVu = createCombobox(6 * withPanelCenter / 10, heighPanelCenter / 6, sizeWidth / 5, HEIGHT_CONTROLS, Color.WHITE);
        cbbChucVu.addItem("Root");
        cbbChucVu.addItem("Giảng Viên");
        cbbChucVu.addItem("Admin");
        panelCenter.add(cbbChucVu);
        btnAdd = createButton(ID_BUTTON_ADD, 17 * sizeWidth / 20, heighPanelCenter / 6, withPanelCenter / 10, sizeHeight / 15, ICON_ADD);
        panelCenter.add(btnAdd);

        btnUpdate = createButton(ID_BUTTON_UPDATE, 17 * sizeWidth / 20, heighPanelCenter / 3, withPanelCenter / 10, sizeHeight / 15, ICON_UPDATE);
        panelCenter.add(btnUpdate);

        btnDelete = createButton(ID_BUTTON_DELETE, 17 * sizeWidth / 20, heighPanelCenter / 2, withPanelCenter / 10, sizeHeight / 15, ICON_DELETE);
        panelCenter.add(btnDelete);

        btnFind = createButton(ID_BUTTON_FIND, 14 * sizeWidth / 20, 5 * heighPanelCenter / 6, withPanelCenter / 10, sizeHeight / 20, ICON_FIND);
        panelCenter.add(btnFind);

        btnReset = createButton(ID_BUTTON_RESET, 17 * sizeWidth / 20, 2 * heighPanelCenter / 3, withPanelCenter / 10, sizeHeight / 15, ICON_RESET);
        panelCenter.add(btnReset);
    }

    private void initTitle() {
        panelTitle = new JPanel();
        panelTitle.setBounds(0, 0, sizeWidth, sizeHeight / 8);
        panelTitle.setBackground(Color.ORANGE);
        lblTitle = new JLabel();
        lblTitle.setLayout(new BorderLayout());
        add(panelTitle);
        lblTitle = new JLabel();
        lblTitle.setFont(new Font("", Font.BOLD, 50));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setText("QUẢN LÝ TÀI KHOẢN");
        panelTitle.add(lblTitle, BorderLayout.CENTER);
    }

    public void initTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Tên");
        tableModel.addColumn("Ngày Sinh");
        tableModel.addColumn("Giới Tính");
        tableModel.addColumn("Địa Chỉ");
        tableModel.addColumn("Số Điện Thoại");
        tableModel.addColumn("Email");
        tableModel.addColumn("ID");
        tableModel.addColumn("Chức Vụ");
        table = new JTable(tableModel);

        JScrollPane csTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        csTable.setBounds(0, panelTitle.getHeight() + panelCenter.getHeight(), sizeWidth, 3 * sizeHeight / 8);
        add(csTable);
    }

    @Override
    public void initEvent() {
        addEvents();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = e.getActionCommand();
        switch (id) {
            case ID_BUTTON_ADD:
                addAdmin();
                break;
            case ID_BUTTON_UPDATE:
                updateAdmin();
                break;
            case ID_BUTTON_DELETE:
                xoaAdmin();
                break;
            case ID_BUTTON_FIND:
                timKiemAdmin();

                break;
            case ID_BUTTON_RESET:
                txtTen.setText("");
                txtNgaySinh.setText("");
                rbNam.setSelected(false);
                rbNu.setSelected(false);
                txtDiaChi.setText("");
                txtSoDienThoai.setText("");
                txtEmail.setText("");
                txtID.setText("");
                cbbChucVu.setSelectedItem(null);
                btnDelete.setEnabled(false);
                btnUpdate.setEnabled(false);
                showDanhSachNguoiQuanLy();
                break;
            default:
                break;
        }
    }

    private void timKiemAdmin() {
        if (!txtFind.getText().equals("")) {
            String text_search = txtFind.getText().trim();
            Vector<Object> vector1 = new Vector<>();
            vector1.addElement("Tên");
            vector1.addElement("Ngày Sinh");
            vector1.addElement("Giới Tính");
            vector1.addElement("Địa Chỉ");
            vector1.addElement("Số Điện Thoại");
            vector1.addElement("Email");
            vector1.addElement("ID");
            vector1.addElement("Chức Vụ");

            Vector data = new Vector();
            for (QuanLy quanLy : quanLyChung.readObject(path)) {
                if(quanLy.getTen().contains(txtFind.getText())){
                Vector<Object> vector2 = new Vector<>();
                vector2.add(quanLy.getTen());
                Date date = quanLy.getNgaySinh();
                String d = simpleDateFormat.format(date);
                vector2.add(d);
                vector2.add(quanLy.isGioiTinh() ? "Nam" : "Nữ");
                vector2.add(quanLy.getDiaChi());
                vector2.add(quanLy.getSoDienThoai());
                vector2.add(quanLy.getMail());
                vector2.add(quanLy.getMaQuanLy());
                vector2.add(quanLy.getChucVu());
                //if (vector2.toString().contains(text_search)) {
                    data.addElement(vector2);
                //}
                }
            }
            table.setModel(new DefaultTableModel(data, vector1));
        } else {

            showDanhSachNguoiQuanLy();
        }
    }

    private void xoaAdmin() {
        khoiTaoQuanLy();
        if (quanLyChung.removeObject(quanLy)) {
            JOptionPane.showConfirmDialog(this, "ban co muon xoa khong");
            quanLyChung.saveObject(quanLyChung.getLists(), path);
            showDanhSachNguoiQuanLy();
        } else {
            JOptionPane.showMessageDialog(this, "Khong the xoa");
        }
        showDanhSachNguoiQuanLy();
    }

    private void updateAdmin() {
        if (!txtTen.getText().equals("") || !txtNgaySinh.getText().equals("") || !txtEmail.getText().equals("") || !txtDiaChi.getText().equals("")
                || !txtID.getText().equals("") || !txtSoDienThoai.getText().equals("")) {
            btnUpdate.setEnabled(true);
            if (!txtTen.getText().equals(txtTen)) {
            khoiTaoQuanLy();
            if (quanLyChung.updateObject(quanLy)) {
                JOptionPane.showMessageDialog(this, "Cap nhat thanh cong");
                quanLyChung.saveObject(quanLyChung.getLists(), path);
                showDanhSachNguoiQuanLy();
            } else {
                JOptionPane.showMessageDialog(this, "Khong the cap nhat");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Cap nhat khong thanh cong!");
            }
            showDanhSachNguoiQuanLy();
        } else {
            JOptionPane.showMessageDialog(this, "Không thể cập nhật! Mời điền thông tin");
        }
    }

    private void addAdmin() {
        if (!txtTen.getText().equals("") || !txtNgaySinh.getText().equals("") || !txtEmail.getText().equals("") || !txtDiaChi.getText().equals("")
                || !txtID.getText().equals("") || !txtSoDienThoai.getText().equals("")) {
            btnAdd.setEnabled(true);
            khoiTaoQuanLy();
            if (quanLyChung.addObject(quanLy)) {
                JOptionPane.showMessageDialog(this, "Them thanh cong");
                quanLyChung.saveObject(quanLyChung.getLists(), path);
                showDanhSachNguoiQuanLy();

            } else {
                JOptionPane.showMessageDialog(this, "Loi trung lap");
            }
            showDanhSachNguoiQuanLy();
        } else {
            JOptionPane.showMessageDialog(this, "Không được để trống các trường!");
        }
    }

    private void khoiTaoQuanLy() {
        String date0 = txtNgaySinh.getText();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("d/M/yyyy");
        Date date2 = null;
        {
            try {
                date2 = simpleDateFormat1.parse(date0);
            } catch (ParseException ex) {
                Logger.getLogger(PanelInfoUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int sdt1 = Integer.parseInt(txtSoDienThoai.getText().toString());
        quanLy = new QuanLy(txtTen.getText(), date2, rbNam.isSelected(), txtDiaChi.getText(), sdt1, txtEmail.getText(), txtID.getText(), (String) cbbChucVu.getSelectedItem());
    }

}
