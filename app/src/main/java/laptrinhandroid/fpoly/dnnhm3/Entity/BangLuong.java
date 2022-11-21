package laptrinhandroid.fpoly.dnnhm3.Entity;

public class BangLuong {
    private int id;
    private int maNV;
    private float luongCB;
    private int ngayCong;
    private int chuNhat;
    private float ungLuong;
    private float thuong;
private String ngayThang;

    public String getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(String ngayThang) {
        this.ngayThang = ngayThang;
    }

    public float getThuong() {
        return thuong;
    }

    public void setThuong(float thuong) {
        this.thuong = thuong;
    }

    public BangLuong(int id, int maNV, float luongCB, int ngayCong, int chuNhat, float ungLuong, float thuong,String ngayThang) {
        this.id = id;
        this.maNV = maNV;
        this.luongCB = luongCB;
        this.ngayCong = ngayCong;
        this.chuNhat = chuNhat;
        this.ungLuong = ungLuong;
        this.thuong = thuong;
        this.ngayThang = ngayThang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public float getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(float luongCB) {
        this.luongCB = luongCB;
    }

    public int getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(int ngayCong) {
        this.ngayCong = ngayCong;
    }

    public int getChuNhat() {
        return chuNhat;
    }

    public void setChuNhat(int chuNhat) {
        this.chuNhat = chuNhat;
    }

    public float getUngLuong() {
        return ungLuong;
    }

    public void setUngLuong(float ungLuong) {
        this.ungLuong = ungLuong;
    }


    public BangLuong() {
    }
}
