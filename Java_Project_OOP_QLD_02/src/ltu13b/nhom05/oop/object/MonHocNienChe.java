package ltu13b.nhom05.oop.object;

/**
 * Created by Heart Of Dead on 5/19/2017.
 */
public class MonHocNienChe  extends MonHoc{
    private int soHocTrinh;

    public int getSoHocTrinh() {
        return soHocTrinh;
    }

    public void setSoHocTrinh(int soHocTrinh) {
        this.soHocTrinh = soHocTrinh;
    }

    public MonHocNienChe (String maHocPhan, String tenMonHoc, int soHocTrinh) {
        super(maHocPhan, tenMonHoc);
        this.soHocTrinh=soHocTrinh;


    }
}
