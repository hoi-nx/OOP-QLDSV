package ltu13b.nhom05.oop.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Heart Of Dead on 5/19/2017.
 */
public class SinhVienNienChe extends SinhVien {
    private int tongSoHocTrinh;
    private List<DiemMonHocNienChe> diemMonHocNienChes;

    public int getTongSoHocTrinh() {
        return tongSoHocTrinh;
    }

    public void setTongSoHocTrinh(int tongSoHocTrinh) {
        this.tongSoHocTrinh = tongSoHocTrinh;
    }

    public List<DiemMonHocNienChe> getDiemMonHocNienChes() {
        return diemMonHocNienChes;
    }

    public void setDiemMonHocNienChes(List<DiemMonHocNienChe> diemMonHocNienChes) {
        this.diemMonHocNienChes = diemMonHocNienChes;
    }

    public SinhVienNienChe(String ten, Date ngaySinh, boolean gioiTinh, String diaChi, int soDienThoai, String mail, String maSinhVien, String lop, String khoa) {
        super(ten, ngaySinh, gioiTinh, diaChi, soDienThoai, mail, maSinhVien, lop, khoa);
        diemMonHocNienChes = new ArrayList<>();

//        MonHocNienChe monHocNienChe1 = new MonHocNienChe("ID1090", "Tin học", 4);
//        MonHocNienChe monHocNienChe2 = new MonHocNienChe("ID1090", "Tin họ", 5);
//        MonHocNienChe monHocNienChe3 = new MonHocNienChe("ID1090", "Tin h", 6);
//        MonHocNienChe monHocNienChe4 = new MonHocNienChe("ID1090", "Tin ", 7);
//        DiemMonHocNienChe diemMonHocNienChe1 = new DiemMonHocNienChe(10, 5, 4, 4, monHocNienChe1);
//        DiemMonHocNienChe diemMonHocNienChe2 = new DiemMonHocNienChe(1, 6, 5, 5, monHocNienChe2);
//        DiemMonHocNienChe diemMonHocNienChe3 = new DiemMonHocNienChe(8, 6, 8, 6, monHocNienChe3);
//        DiemMonHocNienChe diemMonHocNienChe4 = new DiemMonHocNienChe(6, 8, 9, 7, monHocNienChe4);
//        diemMonHocNienChes.add(diemMonHocNienChe1);
//        diemMonHocNienChes.add(diemMonHocNienChe2);
//        diemMonHocNienChes.add(diemMonHocNienChe3);
//        diemMonHocNienChes.add(diemMonHocNienChe4);
    }

    public double trungBinhHocTap() {
        double tmp = 0;
        tongSoHocTrinh = 0;
        for (int i = 0; i < diemMonHocNienChes.size(); i++) {
            tongSoHocTrinh += diemMonHocNienChes.get(i).getSoDonViHocTrinh();
        }

        for (int i = 0; i < diemMonHocNienChes.size(); i++) {
            tmp += (diemMonHocNienChes.get(i).tinhDiem()
                    * diemMonHocNienChes.get(i).getSoDonViHocTrinh());

        }
        return tmp / tongSoHocTrinh;
    }

    public String xepLoaiHocTap() {
        double trungBinhHocTap = trungBinhHocTap();
        if (trungBinhHocTap >= 9.0) {
            return "Xuất sắc";
        }
        if (trungBinhHocTap >= 8.0) {
            return "Giỏi";
        }
        if (trungBinhHocTap >= 7.0) {
            return "Khá";
        }
        if (trungBinhHocTap >= 6.0) {
            return "Trung bình khá";
        }
        if (trungBinhHocTap >= 5.0) {
            return "Trung bình";
        }
        if (trungBinhHocTap >= 4.0) {
            return "Yếu";
        }
        return "Kém";
    }

//    @Override
//    public boolean equals(Object obj) {
//        SinhVienNienChe sinhVienNienChe = (SinhVienNienChe) obj;
//        if (this.getMaSinhVien().equals(sinhVienNienChe.getMaSinhVien())) {
//            return true;
//        }
//        return false;
//    }

}
