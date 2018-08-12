package ltu13b.nhom05.oop.object;

import java.io.Serializable;

/**
 * Created by Heart Of Dead on 5/22/2017.
 */
public class TaiKhoan implements Serializable{
    private String tenDangNhap;
    private String matKhau;

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public TaiKhoan(String tenDangNhap, String matKhau) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }
}
