package ltu13b.nhom05.oop.gui;

import ltu13b.nhom05.oop.interfaces.MyMouseListener;
import ltu13b.nhom05.oop.object.QuanLy;
import ltu13b.nhom05.oop.object.QuanLyChung;
import ltu13b.nhom05.oop.object.SinhVienNienChe;
import ltu13b.nhom05.oop.object.SinhVienTinChi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Heart Of Dead on 5/9/2017.
 */
public class PanelManagerStudentYearly extends BasePanel {
    private JTextField txtMssv, txtTenLop, txtNgaySinh, txtTatca, txtHoTen, txtKhoa, txtEmail, txtDiaChi, txtFind, txtSoDienThoai;
    private JTable tableSinhVienBienChe;
    private JLabel lblVanAnh;
    private MyMouseListener myMouseListener;
    private JComboBox  cbbTatCa;
    private JLabel lblMssv, lblTenLop, lblNgaySinh, lblGioiTinh, lblHoten, lblKhoa, lblDiaChi, lblSoDienThoai, lblMail;
    private QuanLyChung<SinhVienNienChe> quanLyChung;
    private String path1;
    private JRadioButton rbMale, rbFeMale;
    private ButtonGroup groupSex;
    private SinhVienNienChe sinhVienNienChe;
    private SimpleDateFormat simpleDateFormat;



    public PanelManagerStudentYearly(int sizeWidth, int sizeHeight) {
        super(sizeWidth, sizeHeight);
        quanLyChung = new QuanLyChung<>();
        simpleDateFormat = new SimpleDateFormat("d/M/yyyy");
        path1 = getClass().getResource("/res/file/StudentYearly.data").getPath().replaceAll("%20", " ");
        loadDataOnTable();
        onClick();
    }


    private void onClick() {
        myMouseListener = new MyMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = tableSinhVienBienChe.getSelectedRow();
                if (row != -1) {
                    txtHoTen.setText(tableSinhVienBienChe.getValueAt(row, 1).toString());
                    txtNgaySinh.setText(tableSinhVienBienChe.getValueAt(row, 3).toString());
                    txtDiaChi.setText(tableSinhVienBienChe.getValueAt(row, 4).toString());
                    txtTenLop.setText(tableSinhVienBienChe.getValueAt(row, 2).toString());
                    txtSoDienThoai.setText(tableSinhVienBienChe.getValueAt(row, 8).toString());
                    txtKhoa.setText(tableSinhVienBienChe.getValueAt(row, 7).toString());
                    txtEmail.setText(tableSinhVienBienChe.getValueAt(row, 6).toString());
                    txtMssv.setText(tableSinhVienBienChe.getValueAt(row, 0).toString());
                    boolean sSex = ((String) tableSinhVienBienChe.getValueAt(row, 5)).equals("Nam");
                    if (sSex) {
                        rbMale.setSelected(true);
                    } else {
                        rbFeMale.setSelected(true);
                    }
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                }
            }
        };
        tableSinhVienBienChe.addMouseListener(myMouseListener);
    }

    private void loadDataOnTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("MSSV");
        tableModel.addColumn("Họ tên");
        tableModel.addColumn("Lớp");
        tableModel.addColumn("Ngày Sinh");
        tableModel.addColumn("Địa chỉ");
        tableModel.addColumn("Giới tính");
        tableModel.addColumn("Mail");
        tableModel.addColumn("Khóa");
        tableModel.addColumn("Số Điện Thoại");
        tableModel.addColumn("Tổng học trình");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (SinhVienNienChe sinhVienNienChe : quanLyChung.readObject(path1)) {
            Vector<Object> vector = new Vector<>();
            vector.add(sinhVienNienChe.getMaSinhVien());
            vector.add(sinhVienNienChe.getTen());
            vector.add(sinhVienNienChe.getLop());
            Date date = sinhVienNienChe.getNgaySinh();
            String date1 = simpleDateFormat.format(date);
            vector.add(date1);
            vector.add(sinhVienNienChe.getDiaChi());
            vector.add(sinhVienNienChe.isGioiTinh() ? "Nam" : "Nữ");
            vector.add(sinhVienNienChe.getMail());
            vector.add(sinhVienNienChe.getKhoa());
            vector.add(sinhVienNienChe.getSoDienThoai());

            tableModel.addRow(vector);
        }
        tableSinhVienBienChe.setModel(tableModel);
    }


    @Override
    public void initPanel() {
        //Chỗ này sẽ khởi tạo PanelManagerUser
        //Do cái Base Panel kế thừa từ Jpanel nên PanelManagerUser cũng là một JPanel

        setLayout(null);//Layout chuyền vào null tức là layout tùy chọn, cậu có thể dán các control
        //lên vị trí tùy thích. có thể dũng các layout khác như borderlayout,flowlayout......
        //Nhưng cần cái này là đủ rồi
        setBackground(Color.LIGHT_GRAY);//set màu có panel đó
        // c đang hướng dẫn t làm từ đầu đó hả
        //Ừ

    }

    @Override
    public void initControls() {

        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        panel.setBounds(0, 30, sizeWidth, 100);
        panel.setLayout(null);
        add(panel);

//        JButton jButton=new JButton("Vân anh");
//        jButton.setBounds(200,20,100,50);
//        panel.add(jButton);

        JLabel jLabel = new JLabel("QUẢN LÝ SINH VIÊN BIÊN CHẾ");
        jLabel.setForeground(Color.white);
        Font font2 = new Font("Tahoma", Font.ITALIC, 40);
        FontMetrics metrics = getFontMetrics(font2);
        int with = metrics.stringWidth("QUẢN LÝ SINH VIÊN BIÊN CHẾ");
        jLabel.setFont(font2);
        jLabel.setBounds(320, 20, with + 30, 50);
        panel.add(jLabel);

//        JTable jTable = new JTable();
//        jTable.setBackground(Color.YELLOW);
//        jTable.setBounds(0, 480, sizeWidth, 110);
//        add(jTable);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("MSSV");
        tableModel.addColumn("Họ tên");
        tableModel.addColumn("Lớp");
        tableModel.addColumn("Số Điện Thoại");
        tableModel.addColumn("Ngày Sinh");
        tableModel.addColumn("Địa chỉ");
        tableModel.addColumn("Giới tính");
        tableModel.addColumn("Mail");
        tableModel.addColumn("Tổng Học Trình");
//        add(jTable);
        tableSinhVienBienChe = new JTable(tableModel);


        add(tableSinhVienBienChe);
        JScrollPane jScrollPane = new JScrollPane(tableSinhVienBienChe, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        jScrollPane.setBackground(Color.YELLOW);
        jScrollPane.setBounds(0, 500, sizeWidth - 16, 200);
        add(jScrollPane);


        //chỗ này để add các control dán lên panelManagerUser

        //Bây giờ dán các control
        btnAdd = new JButton();
        btnUpdate = new JButton();
        btnDelete = new JButton();
        btnReset = new JButton();
        btnFind = new JButton();


//        allJButton(btnAdd, "Add", 1000, 190, 105, 30, ICON_LOGIN);

        allJButton(btnAdd, "Add", 1000, 190, 105, 30, ICON_KHAC);
        allJButton(btnUpdate, "Update", 1000, 250, 105, 30, ICON_KHAC1);
        allJButton(btnDelete, "Delete", 1000, 310, 105, 30, ICON_KHAC2);
        allJButton(btnReset, "Reset", 1000, 370, 105, 30, ICON_KHAC3);
        allJButton(btnFind, "Find", 700, 430, 105, 30, ICON_KHAC4);


        txtMssv = new JTextField();
        allJtext(txtMssv, 230, 180, 170, 25);

        txtTenLop = new JTextField();
        allJtext(txtTenLop, 230, 240, 170, 25);

        txtNgaySinh = new JTextField();
        allJtext(txtNgaySinh, 230, 310, 170, 25);

        txtTatca = new JTextField();
        allJtext(txtTatca, 400, 430, 250, 25);

        txtEmail = new JTextField();
        allJtext(txtEmail, 670, 380, 250, 25);





        rbMale = createRadioButton("Nam", 230, 370, sizeWidth / 20, 25, Color.WHITE);
        rbFeMale = createRadioButton("Nữ", 340, 370, sizeWidth / 20, 25, Color.WHITE);
        groupSex = new ButtonGroup();
        groupSex.add(rbMale);
        groupSex.add(rbFeMale);
        add(rbMale);
        add(rbFeMale);



        txtHoTen = new JTextField();
        allJtext(txtHoTen, 670, 180, 170, 25);

        txtKhoa = new JTextField();
        allJtext(txtKhoa, 670, 230, 170, 25);




        cbbTatCa = createCombobox(250, 430, 150, 25, Color.WHITE);
        cbbTatCa.addItem("Tất cả");
        add(cbbTatCa);


//        allJtext(txtHeDaoTao, 670, 250, 170, 25);

        txtDiaChi = new JTextField();
        allJtext(txtDiaChi, 670, 280, 170, 25);

        txtSoDienThoai = new JTextField();
        allJtext(txtSoDienThoai, 670, 330, 170, 25);




        lblVanAnh = new JLabel();
        lblMssv = new JLabel();
        lblTenLop = new JLabel();
        lblNgaySinh = new JLabel();
        lblGioiTinh = new JLabel();
        lblHoten = new JLabel();
        lblKhoa = new JLabel();
        lblDiaChi = new JLabel();
        lblSoDienThoai = new JLabel();
        lblMail = new JLabel();
        Font font = new Font("Tohama", Font.BOLD, 30);
        Font font1 = new Font("van ", Font.BOLD, 15);
//        allJlable(lblVanAnh, "QUẢN LÝ SINH VIÊN BIÊN CHẾ", 400, 150, 35, font, Color.red);

        allJlable(lblMssv, "MSSV", 100, 180, 20, font1, Color.black);
        allJlable(lblTenLop, "Tên Lớp", 100, 240, 20, font1, Color.black);
        allJlable(lblNgaySinh, "Ngày Sinh", 100, 310, 20, font1, Color.black);
        allJlable(lblGioiTinh, "Giới Tính", 100, 370, 20, font1, Color.black);
        allJlable(lblHoten, "Họ Tên", 515, 180, 20, font1, Color.black);
        allJlable(lblKhoa, "Khóa", 515, 230, 20, font1, Color.black);
        allJlable(lblDiaChi, "Địa Chỉ", 515, 280, 20, font1, Color.black);
        allJlable(lblSoDienThoai, "Số Điện Thoại", 515, 330, 20, font1, Color.black);
        allJlable(lblMail, "Mail", 515, 380, 20, font1, Color.black);


    }

    @Override
    public void initEvent() {
        //add sự kiện cho các button

        //thử xử lý sự kiện cho button kia nhé
        //dùng cậu lệnh sau
      addEvents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = e.getActionCommand();
        switch (id) {
            case ID_BUTTON_ADD:
                khoiTaoSinhVienBienChe();
                if (quanLyChung.addObject(sinhVienNienChe)) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    quanLyChung.saveObject(quanLyChung.getLists(), path1);
                    loadDataOnTable();

                } else {
                    JOptionPane.showMessageDialog(this, "Trùng lặp");
                }
                break;
            case ID_BUTTON_UPDATE:
                khoiTaoSinhVienBienChe();
                if (quanLyChung.updateObject(sinhVienNienChe)) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                    quanLyChung.saveObject(quanLyChung.getLists(), path1);
                    loadDataOnTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể cập nhật");
                }
                break;
            case ID_BUTTON_DELETE:
                khoiTaoSinhVienBienChe();
                if (quanLyChung.removeObject(sinhVienNienChe)) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    quanLyChung.saveObject(quanLyChung.getLists(), path1);
                    loadDataOnTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể xóa");
                }
                break;
            case ID_BUTTON_FIND:
                if (!txtTatca.getText().equals("")) {
                    String text_search = txtTatca.getText().trim();
                    Vector<Object> vector1 = new Vector<>();
                    vector1.addElement("MSSV");
                    vector1.addElement("Họ Tên");
                    vector1.addElement("Lớp");
                    vector1.addElement("Ngày Sinh");
                    vector1.addElement("Địa Chỉ");
                    vector1.addElement("Giới Tính");
                    vector1.addElement("Mail");
                    vector1.addElement("Khóa");
                    vector1.addElement("Số Điện Thoại");
                    vector1.addElement("Tổng học trình");

                    Vector data = new Vector();
                    for (SinhVienNienChe sv : quanLyChung.readObject(path1)) {
                        if (sv.getTen().contains(txtTatca.getText())) {
                            Vector<Object> vector2 = new Vector<>();
                            vector2.add(sv.getMaSinhVien());
                            vector2.add(sv.getTen());
                            vector2.add(sv.getLop());
                            Date date = sv.getNgaySinh();
                            String d = simpleDateFormat.format(date);
                            vector2.add(d);
                            vector2.add(sv.getDiaChi());
                            vector2.add(sv.isGioiTinh() ? "Nam" : "Nữ");
                            vector2.add(sv.getMail());
                            vector2.add(sv.getKhoa());
                            vector2.add(sv.getSoDienThoai());
                            vector2.add(sv.getTongSoHocTrinh());

                            data.addElement(vector2);

                        }
                        else
                            if (sv.getMaSinhVien().contains(txtTatca.getText()) ){
                            Vector<Object> vector2 = new Vector<>();
                            vector2.add(sv.getMaSinhVien());
                            vector2.add(sv.getTen());
                            vector2.add(sv.getLop());
                            Date date = sv.getNgaySinh();
                            String d = simpleDateFormat.format(date);
                            vector2.add(d);
                            vector2.add(sv.getDiaChi());
                            vector2.add(sv.isGioiTinh() ? "Nam" : "Nữ");
                            vector2.add(sv.getMail());
                            vector2.add(sv.getKhoa());
                            vector2.add(sv.getSoDienThoai());
                            vector2.add(sv.getTongSoHocTrinh());

                            data.addElement(vector2);

                        }
                    }
                    tableSinhVienBienChe.setModel(new DefaultTableModel(data, vector1));

            }

            else {
                    loadDataOnTable();
                }


                break;
            case ID_BUTTON_RESET:
                // TODO Auto-generated method stub
                int i=JOptionPane.showConfirmDialog(null, "Do you want to reset?","",JOptionPane.YES_NO_OPTION);
                if(i==JOptionPane.OK_OPTION){
                    txtMssv.setText(null);
                    txtEmail.setText(null);
                    txtNgaySinh.setText(null);
                    txtSoDienThoai.setText(null);
                    txtDiaChi.setText(null);
                    txtHoTen.setText(null);
                    txtTenLop.setText(null);
                    cbbTatCa.setSelectedIndex(0);
                    txtKhoa.setText(null);
//                    groupSex.setSelected(null, false);

                }




                break;
            default:
                break;
        }
    }

    private void khoiTaoSinhVienBienChe() {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        String date0 = txtNgaySinh.getText();
        Date date2 = null;
        {
            try {
                date2 = simpleDateFormat1.parse(date0);
            } catch (ParseException ex) {
                Logger.getLogger(PanelInfoUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        int sdt1 = Integer.parseInt(txtSoDienThoai.getText().toString());
        sinhVienNienChe = new SinhVienNienChe(txtHoTen.getText(), date2, rbMale.isSelected(), txtDiaChi.getText(), Integer.parseInt(txtSoDienThoai.getText()), txtEmail.getText(), txtMssv.getText(), txtTenLop.getText(), txtKhoa.getText());
    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        //xử lý sự kiện các button
//        String string = e.getActionCommand();//Cậu lệnh này nghĩa là lấy ra id tức là mã
//        //của cái button mà set mã cho nó là gì đấy
//        switch (string) {
//            case "Add123"://Add là cái string mình vừa truyền vào ở trên đó
//                System.out.println("Vân anh óc heo");
//                break;
//
//            //ĐƯỢC CHƯA
//            //VÀ NHIỆM VỤ CỦA CẬU LÀ LÀM GIAO DIÊN NHƯ NÀY NÀY
//            //GIAO DIỆN QUẢN LÝ TÀI KHOẢN NHƯ KIA
//            //Chữ tài khoản, mật khẩu ,quản lý tài khoản là JLbal
//            //bên cạnh là JTextFile;
//            //Dưới là JTable
////t chuaw hieeru lawsm ddaau
//            // ddeer tớ tự làm ms biết đc
//            //==
//            //oki có gì mai lên lớp
//        }
////        if(e.getActionCommand().equalsIgnoreCase("ADD")){
////            String txt=txtMssv.getText();
////            Vector<String>vector=new Vector<>();
////            vector.add(txt);
////            tableModel.addRow(vector);
////        }

}

