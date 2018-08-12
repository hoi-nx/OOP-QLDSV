package ltu13b.nhom05.oop.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Heart Of Dead on 5/19/2017.
 */
public class SinhVienTinChi extends SinhVien {
    private int tongSoTinChi;
    private List<DiemMonHocTinChi> diemMonHocTinChis;

    public List<DiemMonHocTinChi> getDiemMonHocTinChis() {
        return diemMonHocTinChis;
    }

    public void setDiemMonHocTinChis(List<DiemMonHocTinChi> diemMonHocTinChis) {
        this.diemMonHocTinChis = diemMonHocTinChis;
    }

    public int getTongSoTinChi() {
        return tongSoTinChi;
    }

    public void setTongSoTinChi(int tongSoTinChi) {
        this.tongSoTinChi = tongSoTinChi;
    }

    public SinhVienTinChi(String ten, Date ngaySinh, boolean gioiTinh, String diaChi, int soDienThoai, String mail, String maSinhVien, String lop, String khoa) {
        super(ten, ngaySinh, gioiTinh, diaChi, soDienThoai, mail, maSinhVien, lop, khoa);
        diemMonHocTinChis = new ArrayList<>();
//        MonHocTinChi monHocTinChi=new MonHocTinChi("ID1090","Tin học",4,0.3);
//        DiemMonHocTinChi diemMonHocTinChi=new DiemMonHocTinChi(10,2,monHocTinChi);
//
//        diemMonHocTinChis.add(diemMonHocTinChi);

    }

    public void xemDiem() {
        for (DiemMonHocTinChi diemMonHocTinChi : diemMonHocTinChis) {
            diemMonHocTinChi.inThongTin();
        }
    }

    public void themDiem(DiemMonHocTinChi diemMonHocTinChi) {
        diemMonHocTinChis.add(diemMonHocTinChi);
    }

    public void tinhSoTinChiTichLuy() {
        int tinChi = 0;
        for (DiemMonHocTinChi diem : diemMonHocTinChis) {
            if (diem.diemQuyDoi().equalsIgnoreCase("F")) {
                continue;
            }
            tinChi += diem.getMonHocTinChi().getSoTinChi();
        }
        this.tongSoTinChi= tinChi;
    }
//    @Override
//    public boolean equals(Object obj) {
//        SinhVienTinChi sinhVienTC = (SinhVienTinChi) obj;
//        if (this.getMaSinhVien().equals(sinhVienTC.getMaSinhVien())) {
//            return true;
//        }
//        return false;
//    }
}
