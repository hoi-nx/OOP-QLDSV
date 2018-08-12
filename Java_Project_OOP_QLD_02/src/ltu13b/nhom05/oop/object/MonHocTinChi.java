package ltu13b.nhom05.oop.object;

/**
 * Created by Heart Of Dead on 5/19/2017.
 */
public class MonHocTinChi extends MonHoc {
    private int soTinChi;
    private double trongSo;


    public MonHocTinChi(String maHocPhan, String tenMonHoc,int soTinChi,double trongSo) {
        super(maHocPhan, tenMonHoc);
        this.soTinChi=soTinChi;
        this.trongSo=trongSo;

    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public double getTrongSo() {
        return trongSo;
    }

    public void setTrongSo(double trongSo) {
        this.trongSo = trongSo;
    }

    @Override
    public boolean equals(Object obj) {
        MonHocTinChi monHocTinChi= (MonHocTinChi) obj;
        if(this.getMaHocPhan().equals(monHocTinChi.getMaHocPhan())){
            return true;
        }
        return false;
    }
}
