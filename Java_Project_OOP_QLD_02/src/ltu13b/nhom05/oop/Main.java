package ltu13b.nhom05.oop;

import ltu13b.nhom05.oop.gui.MyFrame;
import ltu13b.nhom05.oop.gui.MyFrameManager;
import ltu13b.nhom05.oop.object.DiemMonHocTinChi;
import ltu13b.nhom05.oop.object.MonHocTinChi;
import ltu13b.nhom05.oop.object.QuanLyChung;
import ltu13b.nhom05.oop.object.SinhVienTinChi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Heart Of Dead on 5/19/2017.
 */
public class Main {
    public static void main(String[] args) {
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("d/M/yyyy");
//        String da="29/8/1996";
//        Date data=null;
//        try {
//            data=simpleDateFormat.parse(da);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        List<SinhVien>sinhViens=new ArrayList<>();
//        List<SinhVienTinChi>sinhViens1=new ArrayList<>();
//        SinhVien sinhVien=new SinhVienTinChi("Nguyễn Xuân Hội",data,true,"Hn",988872930,"@mail","123","1","k59",10);
//        SinhVienTinChi sinhVienTinChi=(SinhVienTinChi)sinhVien;
//        sinhVienTinChi.xemDiem();
//
//        MonHocTinChi monHocTinChi=new MonHocTinChi("ID1090","Tin học",4,0.3);
//        DiemMonHocTinChi diemMonHocTinChi=new DiemMonHocTinChi(10,2,monHocTinChi);
//
//
//        QuanLy quanLy=new QuanLy("Nguyễn Xuân Hội",data,true,"Hn",988872930,"@mail","123","Giaos vụ");
//        quanLy.addObject(sinhVien,sinhViens1);
//        quanLy.themDiemSinhVien("123",diemMonHocTinChi);
//
//        System.out.println(diemMonHocTinChi.diemQuyDoi());
//        diemMonHocTinChi.inThongTin();
//
////
////        for(SinhVienTinChi s:sinhViens1){
////            System.out.println(s.getLop()+" "+s.getMaSinhVien()+" "+s.getNgaySinh()+" "+s.getTen()+" "+s.getTongSoTinChi());
////        }
//
//
////        MonHocTinChi monHocTinChi=new MonHocTinChi("ID1090","Tin học",4,0.3);
////        DiemMonHocTinChi diemMonHocTinChi=new DiemMonHocTinChi(10,2,monHocTinChi);
////        System.out.println(diemMonHocTinChi.diemQuyDoi());
////        diemMonHocTinChi.inThongTin();

//        GiaoDien giaoDien=new GiaoDien();


//        MonHocNienChe monHocNienChe1=new MonHocNienChe("ID1090","Tin học",4);
//        MonHocNienChe monHocNienChe2=new MonHocNienChe("ID1090","Tin họ",5);
//        MonHocNienChe monHocNienChe3=new MonHocNienChe("ID1090","Tin h",6);
//        MonHocNienChe monHocNienChe4=new MonHocNienChe("ID1090","Tin ",7);
//        DiemMonHocNienChe diemMonHocNienChe1=new DiemMonHocNienChe(10,5, 4, 4,monHocNienChe1);
//        DiemMonHocNienChe diemMonHocNienChe2=new DiemMonHocNienChe(1,6, 5, 5,monHocNienChe2);
//        DiemMonHocNienChe diemMonHocNienChe3=new DiemMonHocNienChe(8,6, 8, 6,monHocNienChe3);
//        DiemMonHocNienChe diemMonHocNienChe4=new DiemMonHocNienChe(6,8, 9, 7,monHocNienChe4);

//
//        SinhVienNienChe sinhVienNienChe=new SinhVienNienChe("Nguyễn Xuân Hội",new Date(),true,"Hn",988872930,"@mail","123","1","k59");
//        System.out.println(sinhVienNienChe.trungBinhHocTap());
//        System.out.println(sinhVienNienChe.xepLoaiHocTap());

        new MyFrame().setVisible(true);

//        new MyFrameManager().setVisible(true);

//        SinhVienTinChi sinhVienTinChi = new SinhVienTinChi("Nguyễn Xuân Hội",
//                new Date(1996, 10, 10), true, "DH",
//                423423423, "nguyenxuanhoi@gmail.com",
//                "2014342", "LTU13B", "k59");
//        MonHocTinChi monHocTinChi=new MonHocTinChi("IT4040","trí tuệ nhân tạo",3,0.7);
//        DiemMonHocTinChi diemMonHocTinChi=new DiemMonHocTinChi(10,8,monHocTinChi);
//        sinhVienTinChi.themDiem(diemMonHocTinChi);
////
//        List<SinhVienTinChi> listSVTC=new ArrayList<>();
//        listSVTC.add(sinhVienTinChi);
//        QuanLyChung<SinhVienTinChi>quanLyChung = new QuanLyChung<>();
//        quanLyChung.saveObject(listSVTC,"F:\\CreditStudent.data");
    }
}
