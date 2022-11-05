package laptrinhandroid.fpoly.dnnhm3.Entity;

import java.util.Date;

public class HoaDonNhapKho {
    private String maHDNhap, maNV, maSP;
    private Date ngayNhap;
    private int soLuong;
    private float tongTien;

    public HoaDonNhapKho() {
    }

    public HoaDonNhapKho(String maNV, String maSP, Date ngayNhap, int soLuong, float tongTien) {
        this.maNV = maNV;
        this.maSP = maSP;
        this.ngayNhap = ngayNhap;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public String getMaHDNhap() {
        return maHDNhap;
    }

    public void setMaHDNhap(String maHDNhap) {
        this.maHDNhap = maHDNhap;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
}
