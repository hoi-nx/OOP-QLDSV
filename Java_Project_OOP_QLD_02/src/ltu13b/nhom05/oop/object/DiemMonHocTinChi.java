package ltu13b.nhom05.oop.object;

import java.io.Serializable;

/**
 * Created by Heart Of Dead on 5/19/2017.
 */
public class DiemMonHocTinChi implements Serializable{
    private MonHocTinChi monHocTinChi;
    private double diemCuoiKy;
    private double diemGiuaKy;

    public MonHocTinChi getMonHocTinChi() {
        return monHocTinChi;
    }

    public void setMonHocTinChi(MonHocTinChi monHocTinChi) {
        this.monHocTinChi = monHocTinChi;
    }

    public double getDiemCuoiKy() {
        return diemCuoiKy;
    }

    public void setDiemCuoiKy(double diemCuoiKy) {
        this.diemCuoiKy = diemCuoiKy;
    }

    public double getDiemGiuaKy() {
        return diemGiuaKy;
    }

    public void setDiemGiuaKy(double diemGiuaKy) {
        this.diemGiuaKy = diemGiuaKy;
    }

    public DiemMonHocTinChi(double diemCuoiKy, double diemGiuaKy, MonHocTinChi monHoc) {
        this.diemCuoiKy = diemCuoiKy;
        this.diemGiuaKy = diemGiuaKy;
        this.monHocTinChi=monHoc;
    }

    public double tinhDiem() {

        if (checkDiemThi()) {
            return monHocTinChi.getTrongSo() * diemGiuaKy + (1 - monHocTinChi.getTrongSo()) * diemCuoiKy;
        }
        return 0;
    }

    public boolean checkDiemThi() {
        if (diemGiuaKy < 3 || diemCuoiKy < 3) {
            return false;
        }
        return true;
    }
    public String diemQuyDoi(){
        double diem=tinhDiem();
        if(diem>=9.5){
            return "A+";
        }
        if(diem>=8.5){
            return "A";
        }
        if(diem>=8){
            return "B+";
        }
        if(diem>=7){
            return "B";
        }
        if(diem>=6.5){
            return "C+";
        }
        if(diem>=5.5){
            return "C";
        }
        if(diem>=5){
            return "D+";
        }
        if(diem>=4){
            return "D";
        }
        return "F";
    }
    public void inThongTin(){
        System.out.println("Tên môn học: "+monHocTinChi.getTenMonHoc()+"\nMã học phần: "+monHocTinChi.getMaHocPhan()+"\nTrọng số: "+monHocTinChi.getTrongSo());
        System.out.println("Diem Giua Ky: "+diemGiuaKy);
        System.out.println("Diem Cuoi Ky: "+diemCuoiKy);
    }

    @Override
    public boolean equals(Object obj) {
        DiemMonHocTinChi diemMonHocTinChi= (DiemMonHocTinChi) obj;
        if(this.monHocTinChi.equals(diemMonHocTinChi.getMonHocTinChi())){
            return true;
        }
        return false;
    }
}
