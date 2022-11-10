package laptrinhandroid.fpoly.dnnhm3.Entity;

import java.util.Date;

public class HoaDonBan {
    private int maHDBan;
    private String  maNV,maKH;
    private Date ngayBan;

    public HoaDonBan() {
    }

    private float tongTien;

    public HoaDonBan(String maNV, String maKH, Date ngayBan, float tongTien) {
        this.maNV = maNV;
        this.maKH = maKH;
        this.ngayBan = ngayBan;
        this.tongTien = tongTien;
    }

    public int getMaHDBan() {
        return maHDBan;
    }

    public void setMaHDBan(int maHDBan) {
        this.maHDBan = maHDBan;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

}
