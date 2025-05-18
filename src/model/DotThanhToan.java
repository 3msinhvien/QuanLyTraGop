package model;

import java.io.Serializable;
import java.util.Date;

public class DotThanhToan implements Serializable {
    private int id;
    private Date ngayThanhToan;
    private double soTienPhaiThanhToan;
    private int trangThai;

    public DotThanhToan() {
        super();
    }

    public DotThanhToan(Date ngayThanhToan, double soTienPhaiThanhToan, int trangThai) {
        super();
        this.ngayThanhToan = ngayThanhToan;
        this.soTienPhaiThanhToan = soTienPhaiThanhToan;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public double getSoTienPhaiThanhToan() {
        return soTienPhaiThanhToan;
    }

    public void setSoTienPhaiThanhToan(double soTienPhaiThanhToan) {
        this.soTienPhaiThanhToan = soTienPhaiThanhToan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}

