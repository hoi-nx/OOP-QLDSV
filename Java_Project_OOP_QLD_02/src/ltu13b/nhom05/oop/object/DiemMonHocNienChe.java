package ltu13b.nhom05.oop.object;

/**
 * Created by Heart Of Dead on 5/19/2017.
 */
public class DiemMonHocNienChe {
    private MonHocNienChe monHocNienChe;
    private int diemKiemTraThuongXuyen, diemThiGiuaKy, diemKetThucHocTrinh, soDonViHocTrinh;

    public int getSoDonViHocTrinh() {
        return soDonViHocTrinh;
    }

    public void setSoDonViHocTrinh(int soDonViHocTrinh) {
        this.soDonViHocTrinh = soDonViHocTrinh;
    }

    public MonHocNienChe getMonHocNienChe() {
        return monHocNienChe;
    }

    public void setMonHocNienChe(MonHocNienChe monHocNienChe) {
        this.monHocNienChe = monHocNienChe;
    }

    public int getDiemKiemTraThuongXuyen() {
        return diemKiemTraThuongXuyen;
    }

    public void setDiemKiemTraThuongXuyen(int diemKiemTraThuongXuyen) {
        this.diemKiemTraThuongXuyen = diemKiemTraThuongXuyen;
    }

    public int getDiemThiGiuaKy() {
        return diemThiGiuaKy;
    }

    public void setDiemThiGiuaKy(int diemThiGiuaKy) {
        this.diemThiGiuaKy = diemThiGiuaKy;
    }

    public int getDiemKetThucHocTrinh() {
        return diemKetThucHocTrinh;
    }

    public void setDiemKetThucHocTrinh(int diemKetThucHocTrinh) {
        this.diemKetThucHocTrinh = diemKetThucHocTrinh;
    }

    public DiemMonHocNienChe(int diemKiemTraThuongXuyen, int diemThiGiuaKy, int diemKetThucHocTrinh, int soDonViHocTrinh, MonHocNienChe monHocNienChe) {
        this.diemKiemTraThuongXuyen = diemKiemTraThuongXuyen;
        this.diemThiGiuaKy = diemThiGiuaKy;
        this.diemKetThucHocTrinh = diemKetThucHocTrinh;
        this.soDonViHocTrinh = soDonViHocTrinh;
        this.monHocNienChe = monHocNienChe;
    }

    public boolean checkDiemThi() {
        if (diemKetThucHocTrinh < 5) {
            return false;
        }
        return true;
    }

    public double tinhDiem() {
        if (checkDiemThi()) {
            return 0.2 * diemKiemTraThuongXuyen + 0.2 * diemThiGiuaKy + 0.6 * diemKetThucHocTrinh;
        }

        return 0;
    }

}
