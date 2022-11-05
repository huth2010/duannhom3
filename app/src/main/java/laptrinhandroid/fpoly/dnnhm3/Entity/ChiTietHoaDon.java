package laptrinhandroid.fpoly.dnnhm3.Entity;

public class ChiTietHoaDon {
    private String id, maHD, maSp;
    private int soLuong;
    private float donGia;
    private String khuyenMai;
    private float thanhTien;

    public ChiTietHoaDon() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public String getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(String khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public ChiTietHoaDon(String maHD, String maSp, int soLuong, float donGia, String khuyenMai, float thanhTien) {
        this.maHD = maHD;
        this.maSp = maSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.khuyenMai = khuyenMai;
        this.thanhTien = thanhTien;
    }
}
