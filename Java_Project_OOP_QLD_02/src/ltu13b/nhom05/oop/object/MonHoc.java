package ltu13b.nhom05.oop.object;

import java.io.Serializable;

/**
 * Created by Heart Of Dead on 5/19/2017.
 */
public class MonHoc implements Serializable{
    private String maHocPhan;
    private String tenMonHoc;

    public MonHoc(String maHocPhan, String tenMonHoc) {
        this.maHocPhan = maHocPhan;
        this.tenMonHoc = tenMonHoc;
    }

    public String getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(String maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }
}
