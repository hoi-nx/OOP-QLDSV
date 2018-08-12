package ltu13b.nhom05.oop.manager;

import ltu13b.nhom05.oop.object.QuanLy;
import ltu13b.nhom05.oop.object.QuanLyChung;
import ltu13b.nhom05.oop.object.SinhVienNienChe;
import ltu13b.nhom05.oop.object.SinhVienTinChi;

/**
 * Created by Heart Of Dead on 5/23/2017.
 */
public class QuanLyDangNhap {
  private   QuanLyChung<QuanLy>quanLyQuanLyChung;
  private   QuanLyChung<SinhVienTinChi>quanLyQuanLyChung1;
  private   QuanLyChung<SinhVienNienChe>quanLyQuanLyChung2;


    public QuanLyDangNhap() {
        quanLyQuanLyChung = new QuanLyChung<>();
        quanLyQuanLyChung1 = new QuanLyChung<>();
        quanLyQuanLyChung2 = new QuanLyChung<>();

    }
    public boolean checkAdmin(String user,String pass){
        String path = getClass().getResource("/res/file/Manager.data").getPath().replaceAll("%20"," ");

        for(QuanLy quanLy:quanLyQuanLyChung.readObject(path)){
            String id=quanLy.getMaQuanLy();
            String us=id+"@manager.hust.edu.vn";
            if(us.equals(user)&&id.equals(pass)){
                return true;
            }
        }
        return false;
    }
    public boolean checkSinhVien(String user,String pass){
        String path2 = getClass().getResource("/res/file/CreditStudent.data").getPath().replaceAll("%20"," ");
        for(SinhVienTinChi sv:quanLyQuanLyChung1.readObject(path2)){
            String id=sv.getMaSinhVien();
            String us=id+"@student.hust.edu.vn";
            if(us.equals(user)&&id.equals(pass)){
                return true;
            }
        }
        return false;
    }

    public boolean checkSinhVienNienChe(String user,String pass){
        String path1 = getClass().getResource("/res/file/StudentYearly.data").getPath();
        path1 = path1.replaceAll("%20", " ");
        for(SinhVienNienChe sv:quanLyQuanLyChung2.readObject(path1)){
            String id=sv.getMaSinhVien();
            String us=id+"@student.hust.edu.vn";
            if(us.equals(user)&&id.equals(pass)){
                return true;
            }
        }
        return false;
    }

}
