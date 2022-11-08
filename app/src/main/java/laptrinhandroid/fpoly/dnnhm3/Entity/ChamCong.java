package laptrinhandroid.fpoly.dnnhm3.Entity;

import java.util.Date;

public class ChamCong {
    private String maCong,maNV;
    private Date gioBatDau,gioKetThuc;
    private Date  ngay;
    private Boolean xacNhanChamCong;

    public Boolean getXacNhanChamCong() {
        return xacNhanChamCong;
    }

    public void setXacNhanChamCong(Boolean xacNhanChamCong) {
        this.xacNhanChamCong = xacNhanChamCong;
    }

    public ChamCong(String maNV, Date gioBatDau, Date gioKetThuc, Date ngay) {
        this.maNV = maNV;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.ngay = ngay;
    }

    public String getMaCong() {
        return maCong;
    }

    public void setMaCong(String maCong) {
        this.maCong = maCong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
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

}
