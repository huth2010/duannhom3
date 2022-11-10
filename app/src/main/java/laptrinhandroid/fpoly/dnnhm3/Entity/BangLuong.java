package laptrinhandroid.fpoly.dnnhm3.Entity;

public class BangLuong {
    private int id;
    private String  maNV;
    private float luongCB;
    private int ngayCong;
    private int chuNhat;
    private float ungLuong;

    public BangLuong(String maNV, float luongCB, int ngayCong, int chuNhat, float ungLuong ) {
        this.maNV = maNV;
        this.luongCB = luongCB;
        this.ngayCong = ngayCong;
        this.chuNhat = chuNhat;
        this.ungLuong = ungLuong;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
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
