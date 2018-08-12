package ltu13b.nhom05.oop.gui;

import ltu13b.nhom05.oop.interfaces.MyMouseListener;
import ltu13b.nhom05.oop.object.MonHocTinChi;
import ltu13b.nhom05.oop.object.QuanLyChung;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.*;

/**
 * Created by lhhie on 4/30/2017.
 */
public class PanelInfoGredit extends BasePanel{

    private JLabel lblSubjectID, lblSubjectName, lblNumberOfCredit, lblSemester, lblCoefficent;
    private JTable table;
    private JTextField txtSubjectID, txtSubjectName, txtNumberOfCredit, txtSearch;
    private JComboBox cbxFinalCoefficent, cbxMidtermCoefficent, cbxChooserSerach;
    private QuanLyChung<MonHocTinChi> quanLyMonHocTinChi;
    private String path;

    public PanelInfoGredit(int sizeWidth, int sizeHeight) {
        super(sizeWidth, sizeHeight);
        quanLyMonHocTinChi=new QuanLyChung<>();

        initPanel();
//        initEvent();
        path=getClass().getResource("/res/file/MonHocTinChi.txt").getPath().replaceAll("%20"," ");
        loadDataOnTable();
    }


    @Override
    public void initPanel() {
        setLayout(null);

        Border border = BorderFactory.createLineBorder(Color.RED);
        TitledBorder titledBorder = new TitledBorder(border, "Information");
        setBorder(titledBorder);

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

        Border border = BorderFactory.createLineBorder(Color.RED);
        TitledBorder titledBorder = new TitledBorder(border, "Information");
        panelCenter.setBorder(titledBorder);


        Font font = new Font("NewellsHand", Font.PLAIN, 20);
        int withPanelCenter = panelCenter.getWidth();
        int heighPanelCenter = panelCenter.getHeight();
        lblSubjectID = createLabel("Mã học phần", withPanelCenter / 10, heighPanelCenter / 6, 25, font, null);
        panelCenter.add(lblSubjectID);
        txtSubjectID = createTextField(withPanelCenter / 5, heighPanelCenter / 6, sizeWidth / 5, HEIGHT_CONTROLS);
        panelCenter.add(txtSubjectID);

        lblSubjectName = createLabel("Tên học phần:", withPanelCenter / 2, heighPanelCenter / 6, 25, font, null);
        panelCenter.add(lblSubjectName);
        txtSubjectName = createTextField(6 * withPanelCenter / 10, heighPanelCenter / 6, sizeWidth / 5, HEIGHT_CONTROLS);
        panelCenter.add(txtSubjectName);

        lblNumberOfCredit = createLabel("Số tín chỉ:", withPanelCenter / 10, heighPanelCenter / 3, 25, font, null);
        panelCenter.add(lblNumberOfCredit);
        txtNumberOfCredit = createTextField(withPanelCenter / 5, heighPanelCenter / 3, sizeWidth / 5, HEIGHT_CONTROLS);
        panelCenter.add(txtNumberOfCredit);

        lblCoefficent = createLabel("Trọng số:", withPanelCenter / 10, heighPanelCenter / 2, 25, font, null);
        panelCenter.add(lblCoefficent);

        cbxFinalCoefficent = createCombobox(withPanelCenter / 5, heighPanelCenter / 2, sizeWidth / 15, 25, Color.WHITE);
        panelCenter.add(cbxFinalCoefficent);

        cbxMidtermCoefficent = createCombobox(3 * withPanelCenter / 10, heighPanelCenter / 2, sizeWidth / 15, 25, Color.WHITE);
        panelCenter.add(cbxMidtermCoefficent);


        btnAdd = createButton(ID_BUTTON_ADD, 17 * sizeWidth / 20, heighPanelCenter / 6, withPanelCenter / 10, sizeHeight / 15, ICON_ADD);
        panelCenter.add(btnAdd);

        btnUpdate = createButton(ID_BUTTON_UPDATE, 17 * sizeWidth / 20, heighPanelCenter / 3, withPanelCenter / 10, sizeHeight / 15, ICON_UPDATE);
        panelCenter.add(btnUpdate);


        btnDelete = createButton(ID_BUTTON_DELETE, 17 * sizeWidth / 20, heighPanelCenter / 2, withPanelCenter / 10, sizeHeight / 15, ICON_DELETE);
        panelCenter.add(btnDelete);

        btnFind = createButton(ID_BUTTON_FIND, 11 * withPanelCenter / 20, 5 * heighPanelCenter / 6, withPanelCenter / 10, sizeHeight / 20, ICON_FIND);
        panelCenter.add(btnFind);

        btnReset = createButton(ID_BUTTON_RESET, 17 * sizeWidth / 20, 2 * heighPanelCenter / 3, withPanelCenter / 10, sizeHeight / 15, ICON_RESET);
        panelCenter.add(btnReset);

        cbxChooserSerach = createCombobox(withPanelCenter / 10, 5 * heighPanelCenter / 6, withPanelCenter / 10, HEIGHT_CONTROLS, Color.WHITE);
        cbxChooserSerach.addItem("Tất cả");
        cbxChooserSerach.addItem("Mã học phần");
        cbxChooserSerach.addItem("Tên học phần");
        panelCenter.add(cbxChooserSerach);

        txtSearch = createTextField(withPanelCenter / 5, 5 * heighPanelCenter / 6, sizeWidth / 3, HEIGHT_CONTROLS);
        panelCenter.add(txtSearch);
    }

    private void initTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã học phần");
        tableModel.addColumn("Tên học phần");
        tableModel.addColumn("Số tín chỉ");
        tableModel.addColumn("Hệ số cuối kì");
        tableModel.addColumn("Hệ số giữa kì");
        table = new JTable(tableModel);

        JScrollPane csTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        csTable.setBounds(0, panelTitle.getHeight() + panelCenter.getHeight(), sizeWidth, 3 * sizeHeight / 8);
        add(csTable);
        addItemInCombobox();

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
        lblTitle.setText("QUẢN HỌC PHẦN TÍN CHỈ");
        panelTitle.add(lblTitle, BorderLayout.CENTER);
    }

    @Override
    public void initEvent() {
        addEvents();
        MyMouseListener myMouseListener=new MyMouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                clickTable();
            }
        };
        table.addMouseListener(myMouseListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case ID_BUTTON_ADD:
                eventAdd();
                saveDataInText();
                loadDataOnTable();
                break;
            case ID_BUTTON_UPDATE:
                eventUpdate();
                saveDataInText();
                loadDataOnTable();
                break;
            case ID_BUTTON_DELETE:
                eventDelete();
                saveDataInText();
                loadDataOnTable();
                break;
            case ID_BUTTON_FIND:
                eventSearch();
                break;
            case ID_BUTTON_RESET:
                loadDataOnTable();
                break;
            default:
                break;
        }
    }

    private void eventSearch() {
        String textSearch=txtSearch.getText();
        int chooser=cbxChooserSerach.getSelectedIndex();
        quanLyMonHocTinChi.setLists(quanLyMonHocTinChi.readObject(path));
        tableModel=new DefaultTableModel();
        tableModel.addColumn("Mã học phần");
        tableModel.addColumn("Tên học phần");
        tableModel.addColumn("Số tín chỉ");
        tableModel.addColumn("Hệ số cuối kì");
        tableModel.addColumn("Hệ số giữa kì");
        for (MonHocTinChi monHocTinChi:quanLyMonHocTinChi.getLists()){
            if(chooser==0&&monHocTinChi.getMaHocPhan().contains(textSearch)
                    ||monHocTinChi.getTenMonHoc().contains(textSearch)){
                Vector<Object> vector=new Vector<>();
                vector.add(monHocTinChi.getMaHocPhan());
                vector.add(monHocTinChi.getTenMonHoc());
                vector.add(monHocTinChi.getSoTinChi());
                vector.add(monHocTinChi.getTrongSo());
                vector.add(1.0-monHocTinChi.getTrongSo());
                tableModel.addRow(vector);
            }else if(chooser==1&&monHocTinChi.getMaHocPhan().contains(textSearch)){
                Vector<Object>vector=new Vector<>();
                vector.add(monHocTinChi.getMaHocPhan());
                vector.add(monHocTinChi.getTenMonHoc());
                vector.add(monHocTinChi.getSoTinChi());
                vector.add(monHocTinChi.getTrongSo());
                vector.add(1.0-monHocTinChi.getTrongSo());
                tableModel.addRow(vector);
            }else if(chooser==2&&monHocTinChi.getTenMonHoc().contains(textSearch)){
                Vector<Object>vector=new Vector<>();
                vector.add(monHocTinChi.getMaHocPhan());
                vector.add(monHocTinChi.getTenMonHoc());
                vector.add(monHocTinChi.getSoTinChi());
                vector.add(monHocTinChi.getTrongSo());
                vector.add(1.0-monHocTinChi.getTrongSo());
                tableModel.addRow(vector);
            }

        }

        table.setModel(tableModel);
    }

    private void eventDelete() {
        int row=table.getSelectedRow();
        String maHocPhan= (String) table.getValueAt(row,0);
        String tenHocPhan=(String) table.getValueAt(row,1);
        int soTinChi=Integer.parseInt(table.getValueAt(row,2).toString());
        double trongSoCuoiKy= Double.parseDouble(table.getValueAt(row,3).toString());
        if(quanLyMonHocTinChi.removeObject(new MonHocTinChi(maHocPhan,tenHocPhan,soTinChi,trongSoCuoiKy))){
            JOptionPane.showMessageDialog(this,"Xóa môn học thành công");
        }else {
            JOptionPane.showMessageDialog(this,"Không xóa được");
        }
    }

    private void eventUpdate() {
        String maHocPhan=txtSubjectID.getText();
        String tenHocPhan=txtSubjectName.getText();
        int soTinChi=Integer.parseInt(txtNumberOfCredit.getText().toString());
        double trongSoCuoiKy= (double) cbxFinalCoefficent.getSelectedItem();
        if(quanLyMonHocTinChi.updateObject(new MonHocTinChi(maHocPhan,tenHocPhan,soTinChi,trongSoCuoiKy))){
            JOptionPane.showMessageDialog(this,"Sửa môn học thành công");
        }else {
            JOptionPane.showMessageDialog(this,"không có bản ghi cần sửa");
        }
    }

    private void eventAdd() {
        String maHocPhan=txtSubjectID.getText();
        String tenHocPhan=txtSubjectName.getText();
        int soTinChi=Integer.parseInt(txtNumberOfCredit.getText().toString());
        double trongSoCuoiKy= (double) cbxFinalCoefficent.getSelectedItem();
        if(quanLyMonHocTinChi.addObject(new MonHocTinChi(maHocPhan,tenHocPhan,soTinChi,trongSoCuoiKy))){
            JOptionPane.showMessageDialog(this,"Thêm môn học thành công");
        }else {
            JOptionPane.showMessageDialog(this,"Mã môn học bị trùng");
        }
    }
    private void loadDataOnTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã học phần");
        tableModel.addColumn("Tên học phần");
        tableModel.addColumn("Số tín chỉ");
        tableModel.addColumn("Hệ số cuối kì");
        tableModel.addColumn("Hệ số giữa kì");
        for(MonHocTinChi monHocTinChi:quanLyMonHocTinChi.readObject(path)){
            Vector<Object>vector=new Vector<>();
            vector.add(monHocTinChi.getMaHocPhan());
            vector.add(monHocTinChi.getTenMonHoc());
            vector.add(monHocTinChi.getSoTinChi());
            vector.add(monHocTinChi.getTrongSo());
            vector.add(1.0-monHocTinChi.getTrongSo());
            tableModel.addRow(vector);
        }
        table.setModel(tableModel);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
    }
public void saveDataInText(){
    quanLyMonHocTinChi.saveObject(quanLyMonHocTinChi.getLists(),path);
}
    private void clickTable() {
        int row = table.getSelectedRow();
        String subjectID = (String) table.getValueAt(row, 0);
        txtSubjectID.setText(subjectID);
        String subjectName = (String) table.getValueAt(row, 1);
        txtSubjectName.setText(subjectName);
        int numberOfcredit = Integer.parseInt(table.getValueAt(row, 2).toString());
        txtNumberOfCredit.setText(numberOfcredit + "");
        double finalCoefficent = Double.parseDouble(table.getValueAt(row, 3).toString());
        for (int i = 0; i < cbxFinalCoefficent.getItemCount(); i++) {
            if (cbxFinalCoefficent.getItemAt(i).equals(finalCoefficent)) {
                cbxFinalCoefficent.setSelectedIndex(i);
                cbxMidtermCoefficent.setSelectedIndex(8-i);
                break;
            }
        }
//        double midtermCoefficent = Double.parseDouble(table.getValueAt(row, 4).toString());
//        for (int i = 0; i < cbxMidtermCoefficent.getItemCount(); i++) {
//            if (cbxMidtermCoefficent.getItemAt(i).equals(midtermCoefficent)) {
//                cbxMidtermCoefficent.setSelectedIndex(i);
//                break;
//            }
//        }
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);
    }
    private void addItemInCombobox() {
        cbxFinalCoefficent.addItem(0.1);
        cbxFinalCoefficent.addItem(0.2);
        cbxFinalCoefficent.addItem(0.3);
        cbxFinalCoefficent.addItem(0.4);
        cbxFinalCoefficent.addItem(0.5);
        cbxFinalCoefficent.addItem(0.6);
        cbxFinalCoefficent.addItem(0.7);
        cbxFinalCoefficent.addItem(0.8);
        cbxFinalCoefficent.addItem(0.9);

        cbxMidtermCoefficent.addItem(0.1);
        cbxMidtermCoefficent.addItem(0.2);
        cbxMidtermCoefficent.addItem(0.3);
        cbxMidtermCoefficent.addItem(0.4);
        cbxMidtermCoefficent.addItem(0.5);
        cbxMidtermCoefficent.addItem(0.6);
        cbxMidtermCoefficent.addItem(0.7);
        cbxMidtermCoefficent.addItem(0.8);
        cbxMidtermCoefficent.addItem(0.9);
    }
}
