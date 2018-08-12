package ltu13b.nhom05.oop.object;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Heart Of Dead on 5/19/2017.
 */
public class SinhVien extends ConNguoi{
    private String maSinhVien;
    private String lop;
    private String khoa;

    public SinhVien(String ten, Date ngaySinh, boolean gioiTinh, String diaChi, int soDienThoai, String mail,String maSinhVien,String lop,String khoa) {
        super(ten, ngaySinh, gioiTinh, diaChi, soDienThoai, mail);
        this.maSinhVien=maSinhVien;
        this.lop=lop;
        this.khoa=khoa;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    @Override
    public boolean equals(Object obj) {
        SinhVien sv = (SinhVien) obj;
        if (this.getMaSinhVien().equals(sv.getMaSinhVien())) {
            return true;
        }
        return false;
    }
}
