package ltu13b.nhom05.oop.gui;

import ltu13b.nhom05.oop.interfaces.CallBackInterfaces;
import ltu13b.nhom05.oop.object.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

/**
 * Created by Heart Of Dead on 5/23/2017.
 */
public class PanelOfCreditStudent extends BasePanel{
    private JPanel panelChucNangQuanLy;
    private JLabel lblTieuDeMaSinhVien, lblTieuDeTenSinhVien, lblMaSinhVien, lblTenSinhVien, lblHocPhan, lblSoTinChi, lblDiemCuoiky, lblDiemGiuaKy;
    private JTextField txtSoTinChi, txtTenHocPhan, txtDiemCuoiky, txtDiemGiuaKy;
    private JComboBox cbbHocPhan;
    private JTable table;
    private JButton btnBack;
    private CallBackInterfaces callBackInterfaces;
    private String idSinhVien;
    private QuanLyChung<SinhVienTinChi> quanLySinhVienTinChi;
    private QuanLyChung<MonHocTinChi> quanLyMonHocTinChi;
    private SinhVienTinChi sinhVienTinChi;
    private String path;
    private String pathMonHocTinChi;
    private boolean isQuanLy;
    private boolean isSelectedCombobox=true;

    public void setCallBackInterfaces(CallBackInterfaces callBackInterfaces) {
        this.callBackInterfaces = callBackInterfaces;
    }

    public PanelOfCreditStudent(int sizeWidth, int sizeHeight, String idSinhVien, boolean isQuanLy) {
        super(sizeWidth, sizeHeight);
        this.isQuanLy = isQuanLy;
        this.idSinhVien = idSinhVien;
        Font font = new Font("", Font.PLAIN, 30);
        quanLySinhVienTinChi = new QuanLyChung<>();
        quanLyMonHocTinChi = new QuanLyChung<>();
        path = getClass().getResource("/res/file/CreditStudent.data").getPath().replaceAll("%20", " ");
        pathMonHocTinChi = getClass().getResource("/res/file/MonHocTinChi.txt").getPath().replaceAll("%20", " ");
        initsSinhVien();
        loadDataOnTable();
        initsPanelChucNangQuanLy();
        loadDataOnCombobox();
    }

    private void initsPanelChucNangQuanLy() {
        int sizeWidthPanelChucNangQuanLy = sizeWidth / 2;
        int sizeHeightPanleChucNangQuanLy = 4 * sizeHeight / 10;
        Font font = new Font("", Font.PLAIN, 20);

        panelChucNangQuanLy = new JPanel();
        panelChucNangQuanLy.setBounds(sizeWidth / 2, 0, sizeWidthPanelChucNangQuanLy, sizeHeightPanleChucNangQuanLy);
        panelChucNangQuanLy.setBackground(Color.WHITE);
        Border border = BorderFactory.createLineBorder(Color.ORANGE);
        TitledBorder titledBorder = new TitledBorder(border, "Chức năng quản lý");
        add(panelChucNangQuanLy);
        panelChucNangQuanLy.setBorder(titledBorder);
        panelChucNangQuanLy.setLayout(null);

        lblHocPhan = createLabel("Học phần", sizeWidthPanelChucNangQuanLy / 20, sizeHeightPanleChucNangQuanLy / 5, HEIGHT_CONTROLS, font, Color.BLACK);
//        lblTenHocPhan = createLabel("Tên học phần", sizeWidthPanelChucNangQuanLy / 20, 2 * sizeHeightPanleChucNangQuanLy / 5, HEIGHT_CONTROLS, font, Color.BLACK);
        lblDiemCuoiky = createLabel("Điểm cuối kỳ", sizeWidthPanelChucNangQuanLy / 20, 3 * sizeHeightPanleChucNangQuanLy / 5, HEIGHT_CONTROLS, font, Color.BLACK);
        lblDiemGiuaKy = createLabel("Điểm giữa kỳ", sizeWidthPanelChucNangQuanLy / 20, 4 * sizeHeightPanleChucNangQuanLy / 5, HEIGHT_CONTROLS, font, Color.BLACK);

//        txtMaHocPhan = createTextField(5 * sizeWidthPanelChucNangQuanLy / 20, sizeHeightPanleChucNangQuanLy / 5, sizeWidthPanelChucNangQuanLy / 3, HEIGHT_CONTROLS);
        txtTenHocPhan = createTextField(5 * sizeWidthPanelChucNangQuanLy / 20, 2 * sizeHeightPanleChucNangQuanLy / 5, sizeWidthPanelChucNangQuanLy / 3, HEIGHT_CONTROLS);
        txtTenHocPhan.setEditable(false);

        cbbHocPhan = createCombobox(5 * sizeWidthPanelChucNangQuanLy / 20, sizeHeightPanleChucNangQuanLy / 5, sizeWidthPanelChucNangQuanLy / 3, HEIGHT_CONTROLS, Color.WHITE);

        txtDiemCuoiky = createTextField(5 * sizeWidthPanelChucNangQuanLy / 20, 3 * sizeHeightPanleChucNangQuanLy / 5, sizeWidthPanelChucNangQuanLy / 3, HEIGHT_CONTROLS);
        txtDiemGiuaKy = createTextField(5 * sizeWidthPanelChucNangQuanLy / 20, 4 * sizeHeightPanleChucNangQuanLy / 5, sizeWidthPanelChucNangQuanLy / 3, HEIGHT_CONTROLS);


        btnAdd = createButton(ID_BUTTON_ADD, 12 * sizeWidthPanelChucNangQuanLy / 20, sizeHeightPanleChucNangQuanLy / 5, sizeWidthPanelChucNangQuanLy / 4, 2 * HEIGHT_CONTROLS, ICON_ADD);
        btnUpdate = createButton(ID_BUTTON_UPDATE, 12 * sizeWidthPanelChucNangQuanLy / 20, 2 * sizeHeightPanleChucNangQuanLy / 5, sizeWidthPanelChucNangQuanLy / 4, 2 * HEIGHT_CONTROLS, ICON_UPDATE);
        btnDelete = createButton(ID_BUTTON_DELETE, 12 * sizeWidthPanelChucNangQuanLy / 20, 3 * sizeHeightPanleChucNangQuanLy / 5, sizeWidthPanelChucNangQuanLy / 4, 2 * HEIGHT_CONTROLS, ICON_DELETE);
        btnBack = createButton(ID_BUTTON_BACK, 15 * sizeWidthPanelChucNangQuanLy / 20, sizeHeightPanleChucNangQuanLy / 20, sizeWidthPanelChucNangQuanLy / 6, 3 * HEIGHT_CONTROLS / 2, ICON_RESET);

        panelChucNangQuanLy.add(lblHocPhan);
//        panelChucNangQuanLy.add(lblTenHocPhan);
        panelChucNangQuanLy.add(lblDiemCuoiky);
        panelChucNangQuanLy.add(lblDiemGiuaKy);

//        panelChucNangQuanLy.add(txtMaHocPhan);
//        panelChucNangQuanLy.add(txtTenHocPhan);
        panelChucNangQuanLy.add(cbbHocPhan);
        panelChucNangQuanLy.add(txtDiemCuoiky);
        panelChucNangQuanLy.add(txtDiemGiuaKy);

        panelChucNangQuanLy.add(btnAdd);
        panelChucNangQuanLy.add(btnUpdate);
        panelChucNangQuanLy.add(btnDelete);
        panelChucNangQuanLy.add(btnBack);

        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);

        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnBack.addActionListener(this);




        panelChucNangQuanLy.setVisible(isQuanLy);
    }

    public void loadDataOnCombobox() {
        for (MonHocTinChi monHocTinChi : quanLyMonHocTinChi.readObject(pathMonHocTinChi)) {
            System.out.println(monHocTinChi.getMaHocPhan());
            cbbHocPhan.addItem(monHocTinChi.getMaHocPhan()+"-"+monHocTinChi.getTenMonHoc());
        }
    }

    private void loadDataOnTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã học phần");
        tableModel.addColumn("Tên học phần");
        tableModel.addColumn("Điểm cuối kì");
        tableModel.addColumn("Điểm giữa kì");
        tableModel.addColumn("Quy đổi");
        tableModel.addColumn("Số tín chỉ");
        if (sinhVienTinChi.getDiemMonHocTinChis() == null) {
            return;
        }
        for (DiemMonHocTinChi diem : sinhVienTinChi.getDiemMonHocTinChis()) {
            Vector<Object> vector = new Vector<>();
            vector.add(diem.getMonHocTinChi().getMaHocPhan());
            vector.add(diem.getMonHocTinChi().getTenMonHoc());
            vector.add(diem.getDiemCuoiKy());
            vector.add(diem.getDiemGiuaKy());
            vector.add(diem.diemQuyDoi());
            vector.add(diem.getMonHocTinChi().getSoTinChi());
            tableModel.addRow(vector);
        }
        table.setModel(tableModel);
        if (null != btnUpdate && null != btnDelete) {
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
        }
    }

    @Override
    public void initPanel() {
        setLayout(null);
        setBackground(Color.WHITE);
    }

    @Override
    public void initControls() {
        Font font = new Font("", Font.PLAIN, 20);

        lblTieuDeMaSinhVien = createLabel("Mã sinh viên:", sizeWidth / 10, sizeHeight / 20, HEIGHT_CONTROLS, font, null);
        add(lblTieuDeMaSinhVien);

        lblTieuDeTenSinhVien = createLabel("Tên sinh viên:", sizeWidth / 10, 2 * sizeHeight / 20, HEIGHT_CONTROLS, font, null);
        add(lblTieuDeTenSinhVien);

        lblSoTinChi=createLabel("Số tín chỉ",sizeWidth/10,3*sizeHeight/20,HEIGHT_CONTROLS,font,null);
        add(lblSoTinChi);

        txtSoTinChi=createTextField(3*sizeWidth/10,3*sizeHeight/20,sizeHeight/20,HEIGHT_CONTROLS);
        add(txtSoTinChi);
        txtSoTinChi.setEditable(false);
//        lblMaSinhVien = createLabel("", 3 * sizeWidth / 10, sizeHeight / 20, HEIGHT_CONTROLS, font, null);
//        add(lblMaSinhVien);
//
//        lblTenSinhVien = createLabel("", 3 * sizeWidth / 10, 2 * sizeHeight / 20, HEIGHT_CONTROLS, font, null);
//        add(lblTenSinhVien);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã học phần");
        tableModel.addColumn("Tên học phần");
        tableModel.addColumn("Điểm cuối kì");
        tableModel.addColumn("Điểm giữa kì");
        tableModel.addColumn("Quy đổi");
        tableModel.addColumn("Số tín chỉ");
        table = new JTable(tableModel);

        JScrollPane csTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        csTable.setBounds(0, 4 * sizeHeight / 10, sizeWidth, 6 * sizeHeight / 10);
        add(csTable);

    }


    public void initsSinhVien() {
        for (SinhVienTinChi sv : quanLySinhVienTinChi.readObject(path)) {
            if (sv.getMaSinhVien().equals(idSinhVien)) {
                sinhVienTinChi = sv;
                System.out.println(sinhVienTinChi.getTen());
                Font font = new Font("", Font.PLAIN, 20);
                lblMaSinhVien = createLabel(sinhVienTinChi.getMaSinhVien(), 3 * sizeWidth / 10, sizeHeight / 20, HEIGHT_CONTROLS, font, null);
                add(lblMaSinhVien);

                lblTenSinhVien = createLabel(sinhVienTinChi.getTen(), 3 * sizeWidth / 10, 2 * sizeHeight / 20, HEIGHT_CONTROLS, font, null);
                add(lblTenSinhVien);

                sinhVienTinChi.tinhSoTinChiTichLuy();;
                txtSoTinChi.setText(String.valueOf(sinhVienTinChi.getTongSoTinChi()));
                break;
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case ID_BUTTON_ADD:
                MonHocTinChi monHocTinChi = null;
                String hocPhan = (String) cbbHocPhan.getSelectedItem();
                String arr[]=hocPhan.split("-");
                String maHocPhan=arr[0];
                for (MonHocTinChi mhtc : quanLyMonHocTinChi.readObject(pathMonHocTinChi)) {
                    if (mhtc.getMaHocPhan().equals(maHocPhan)) {
                        monHocTinChi = mhtc;
                        break;
                    }
                }
                if (monHocTinChi == null) {
                    JOptionPane.showMessageDialog(this,
                            "Mã học phần không đúng");
                    return;
                }
                String tenHocPhan = txtTenHocPhan.getText();
                double diemCuoiKy = Double.parseDouble(txtDiemCuoiky.getText().toString());
                double diemGiuaKy = Double.parseDouble(txtDiemGiuaKy.getText().toString());
                DiemMonHocTinChi diemMonHocTinChi = new DiemMonHocTinChi(diemCuoiKy, diemGiuaKy, monHocTinChi);
                List<SinhVienTinChi> sinhVienTVList = quanLySinhVienTinChi.readObject(path);

                for (SinhVienTinChi svtc : sinhVienTVList) {
                    if (svtc.getMaSinhVien().equals(idSinhVien)) {
                        svtc.themDiem(diemMonHocTinChi);
                    }
                }
                quanLySinhVienTinChi.saveObject(sinhVienTVList, path);
                initsSinhVien();
                loadDataOnTable();
                break;
            case ID_BUTTON_UPDATE:

                break;
            case ID_BUTTON_DELETE:

                break;
            case ID_BUTTON_BACK:
                System.out.println("vvv");
                callBackInterfaces.onBackPanelOfManager();
                break;
        }
    }
}
