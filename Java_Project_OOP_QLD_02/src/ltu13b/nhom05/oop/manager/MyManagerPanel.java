package ltu13b.nhom05.oop.manager;

import ltu13b.nhom05.oop.object.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * Created by Heart Of Dead on 5/22/2017.
 */
public class MyManagerPanel {
    private List<SinhVienNienChe> quanLyList;
    private List<SinhVienTinChi> quanLyList2;
    private List<QuanLy> quanLyList3;
    private SinhVien sinhVien;
    private List<SinhVienTinChi> sinhVienTinChis;
    private List<SinhVienNienChe> sinhVienNienChes;
    private FileFactory fileFactory;
    private String path;


    private QuanLyChung<QuanLy> quanLyQuanLyChung;


    public MyManagerPanel() {
        fileFactory = new FileFactory();
        System.out.println(getClass().getResource("/res/file/StudentYearly.data").getPath().replaceAll("%20", " "));

        // khoiTaoNguoiQuanLy();

        quanLyList = new ArrayList<>();
        SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        String date2 = "30/11/1995";
        try {
            date = sim.parse(date2);
        } catch (ParseException ex) {

        }
        SinhVienNienChe manager = new SinhVienNienChe("Nguyễn Thị Vân Anh", date, true, "HN", 988872930, "nguyenthivananh@gmail.com", "20148104", "LTU13B", "K59");
        quanLyList.add(manager);

        fileFactory = new FileFactory();
        fileFactory.savaData(quanLyList, "E:\\Project\\Google Driver\\ProjectIntellij\\Java_Project_OOP_QLD_02\\src\\res\\file\\StudentYearly.data");


        quanLyList2 = new ArrayList<>();


        SinhVienTinChi svTC = new SinhVienTinChi("Nguyễn Thị Vân Anh", date, true, "HN", 988872930, "nguyenthivananh@gmail.com", "20148104", "LTU13B", "K59");
        quanLyList2.add(svTC);


        fileFactory.savaData(quanLyList2, "E:\\Project\\Google Driver\\ProjectIntellij\\Java_Project_OOP_QLD_02\\src\\res\\file\\CreditStudent.data");

        quanLyList3 = new ArrayList<>();
        QuanLy quanLy = new QuanLy("Nguyễn Thị Vân Anh", date, true, "HN", 988872930, "nguyenthivananh@gmail.com", "QL1", "Root");
        quanLyList3.add(quanLy);
        fileFactory.savaData(quanLyList3, "E:\\Project\\Google Driver\\ProjectIntellij\\Java_Project_OOP_QLD_02\\src\\res\\file\\Manager.data");
    }

    public static void main(String[] args) {
        MyManagerPanel myManagerPanel = new MyManagerPanel();
    }

    private void khoiTaoNguoiQuanLy() {
        path = getClass().getResource("/res/file/Manager.txt").getPath();
        path = path.replaceAll("%20", " ");
        // quanLyQuanLyChung.setLists(fileFactory.readData(path));
        quanLyQuanLyChung.readObject(path);


    }

    private void khoiTaoSinhVienNienChe() {
        sinhVienNienChes = new ArrayList<>();

    }

    private void khoiTaoSinhVienTinChi() {
        sinhVienTinChis = new ArrayList<>();

    }


    public DefaultTableModel showDanhSachNguoiQuanLy(DefaultTableModel defaultTableModel) {
        defaultTableModel.setRowCount(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d/M/yyyy");
        for (QuanLy quanLy : quanLyQuanLyChung.readObject(path)) {
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
            defaultTableModel.addRow(vector);
        }
        return defaultTableModel;
    }

    public void onClick(JTable table, JTextField txtTen, JTextField txtNgaySinh, JTextField txtDiaChi, JComboBox cbbChucVu, JTextField txtSoDienThoai, JTextField txtEmail, JTextField txtID, JRadioButton rbNam, JRadioButton rbNu) {
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
        }
    }

    public void addQuanLy(QuanLy quanLy) {
        quanLyQuanLyChung.addObject(quanLy);
        //System.out.println(quanLy.getChucVu()+" "+quanLy.getMail());
        //quanLyQuanLyChung.getLists();

    }


}
