package laptrinhandroid.fpoly.dnnhm3.Entity;

import java.util.Date;

public class HoaDonBan {
    private String MaHD,MaNV,MaKH;
    private Date NgayBan;
    private float TongTien;

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String maHD) {
        MaHD = maHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public Date getNgayBan() {
        return NgayBan;
    }

    public void setNgayBan(Date ngayBan) {
        NgayBan = ngayBan;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float tongTien) {
        TongTien = tongTien;
    }
}
