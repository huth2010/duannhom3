package laptrinhandroid.fpoly.dnnhm3.Entity;

import java.util.Date;

public class ChamCong {
    private String MaCong,MaNV;
    private Date GioBatDau,GioKetThuc,Ngay;

    public String getMaCong() {
        return MaCong;
    }

    public void setMaCong(String maCong) {
        MaCong = maCong;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public Date getGioBatDau() {
        return GioBatDau;
    }

    public void setGioBatDau(Date gioBatDau) {
        GioBatDau = gioBatDau;
    }

    public Date getGioKetThuc() {
        return GioKetThuc;
    }

    public void setGioKetThuc(Date gioKetThuc) {
        GioKetThuc = gioKetThuc;
    }

    public Date getNgay() {
        return Ngay;
    }

    public void setNgay(Date ngay) {
        Ngay = ngay;
    }
}
