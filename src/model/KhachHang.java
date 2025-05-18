package model;
import java.io.Serializable;

public class KhachHang implements Serializable{
    private int id;
    private String ten;
    private String sdt;
    private String email;
    private String cccd;
    private String diaChi;
    private String ghiChu;

    public KhachHang() {
        super();
    }
    public KhachHang(String ten, String sdt, String email, String cccd, String diaChi, String ghiChu) {
        super();
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.cccd = cccd;
        this.diaChi = diaChi;
        this.ghiChu = ghiChu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
