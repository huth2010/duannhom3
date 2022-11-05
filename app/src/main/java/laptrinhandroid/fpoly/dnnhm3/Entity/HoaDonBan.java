package laptrinhandroid.fpoly.dnnhm3.Entity;

import java.util.Date;

public class HoaDonBan {
    private String maHDBan,maNV,maKH;
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

    public String getMaHDBan() {
        return maHDBan;
    }

    public void setMaHDBan(String maHDBan) {
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
