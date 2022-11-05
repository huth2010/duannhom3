package laptrinhandroid.fpoly.dnnhm3.Entity;

public class KhachHang {
    private String maKhach,anh,hoTen,soDT,diaChi;



    public KhachHang() {
    }

    public KhachHang(String anh, String hoTen, String soDT, String diaChi) {
        this.anh = anh;
        this.hoTen = hoTen;
        this.soDT = soDT;
        this.diaChi = diaChi;
    }

    public String getMaKhach() {
        return maKhach;
    }

    public void setMaKhach(String maKhach) {
        this.maKhach = maKhach;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
