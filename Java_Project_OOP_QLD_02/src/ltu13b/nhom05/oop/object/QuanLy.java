package ltu13b.nhom05.oop.object;

import java.util.*;

/**
 * Created by Heart Of Dead on 5/19/2017.
 */
public class QuanLy extends ConNguoi {
    private String maQuanLy;
    private String chucVu;
    private List<SinhVienTinChi> sinhVienTinChiList;
    private List<SinhVienNienChe> sinhVienNienChes;
    private List<SinhVien> sinhViens;

    public QuanLy(String ten, Date ngaySinh, boolean gioiTinh, String diaChi, int soDienThoai, String mail, String maQuanLy, String chucVu) {
        super(ten, ngaySinh, gioiTinh, diaChi, soDienThoai, mail);
        this.maQuanLy = maQuanLy;
        this.chucVu = chucVu;
        sinhVienTinChiList=new ArrayList<>();
    }


    public String getMaQuanLy() {
        return maQuanLy;
    }

    public void setMaQuanLy(String maQuanLy) {
        this.maQuanLy = maQuanLy;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public boolean themSinhVien(SinhVien sinhVien) {
        sinhViens.add(sinhVien);
        return true;
    }

//    public void addObject(T t, List<T> list) {
//         list.add(t);
//    }
//
//    public T getObject(int index, List<T> list) {
//        return list.get(index);
//    }
//
//    public boolean xoaObject(T t, List<T> list) {
//        return list.remove(t);
//    }

    public boolean xoaSinhVien(SinhVien sinhVien) {
        sinhViens.remove(sinhVien);
        return true;
    }

    public boolean capNhapThongTin() {
        return true;
    }

    public void sapXepDanhSachSinhVien() {
        Comparator<SinhVien> sinhVienComparator = new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                String ten1 = o1.getTen();
                String ten2 = o1.getTen();
                int copare = ten1.compareTo(ten2);
                if (copare == 0) {
                    return 0;
                }
                if (copare > 1) {
                    return 1;
                }
                return -1;

            }
        };
        Collections.sort(sinhViens, sinhVienComparator);
    }

    private boolean checkMaTrung(String ma) {
        for (SinhVien s : sinhViens) {
            if (s.getMaSinhVien().equals(ma)) {
                return true;
            }
        }
        return false;
    }
    public void themDiemSinhVien(String maSinhVien,DiemMonHocTinChi diemMonHocTinChi){
        for (SinhVienTinChi sinhVienTinChi : sinhVienTinChiList) {
            if(sinhVienTinChi.getMaSinhVien().equalsIgnoreCase(maSinhVien)){
                sinhVienTinChi.themDiem(diemMonHocTinChi);
                return;
            }
        }
    }

    public List<SinhVienTinChi> getSinhVienTinChiList() {
        return sinhVienTinChiList;
    }

    public List<SinhVienNienChe> getSinhVienNienChes() {
        return sinhVienNienChes;
    }

    public List<SinhVien> getSinhViens() {
        return sinhViens;
    }


    @Override
    public boolean equals(Object obj) {
        QuanLy quanLy=(QuanLy) obj;
        if(this.getMaQuanLy().equals(quanLy.maQuanLy)){
            return true;
        }
        return false;
    }


}
