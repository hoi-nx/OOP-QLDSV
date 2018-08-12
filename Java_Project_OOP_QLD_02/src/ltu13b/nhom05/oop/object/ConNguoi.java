package ltu13b.nhom05.oop.object;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Heart Of Dead on 5/19/2017.
 */
public class ConNguoi implements Serializable{
    private String ten;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String diaChi;
    private int soDienThoai;
    private String mail;

    public ConNguoi(String ten, Date ngaySinh, boolean gioiTinh, String diaChi, int soDienThoai, String mail) {
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.mail = mail;
    }

    public String getTen() {
        return ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public String getMail() {
        return mail;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
