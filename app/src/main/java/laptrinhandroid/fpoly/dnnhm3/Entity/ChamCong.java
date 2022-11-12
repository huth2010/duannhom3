package laptrinhandroid.fpoly.dnnhm3.Entity;

import java.sql.Date;

public class ChamCong {
    private int maCong;
    private int  maNV;
    private Date gioBatDau,gioKetThuc;
    private Date  ngay;
    private int xacNhanChamCong;

    public int getXacNhanChamCong() {
        return xacNhanChamCong;
    }

    public void setXacNhanChamCong(int xacNhanChamCong) {
        this.xacNhanChamCong = xacNhanChamCong;
    }

    public ChamCong(int maNV, Date gioBatDau, Date gioKetThuc, Date ngay) {
        this.maNV = maNV;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.ngay = ngay;
    }

    public int getMaCong() {
        return maCong;
    }

    public void setMaCong(int maCong) {
        this.maCong = maCong;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public Date getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(Date gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public Date getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(Date gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public ChamCong() {
    }

    public ChamCong(int maCong, int maNV, Date gioBatDau, Date gioKetThuc, Date ngay, int xacNhanChamCong) {
        this.maCong = maCong;
        this.maNV = maNV;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.ngay = ngay;
        this.xacNhanChamCong = xacNhanChamCong;
    }
}
