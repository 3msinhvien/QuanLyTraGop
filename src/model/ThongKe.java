package model;

import java.util.ArrayList;

public class ThongKe extends KhachHang {
    private double tongDuNoCon;
    private double tongDuNoQuaHan;
    private ArrayList<DotThanhToan> dsDotThanhToan;

    public ThongKe() {
        super();
    }

    public ThongKe(int id, String ten, double tongDuNoCon, double tongDuNoQuaHan, DotThanhToan dotThanhToan) {
        super();
        this.tongDuNoCon = tongDuNoCon;
        this.tongDuNoQuaHan = tongDuNoQuaHan;
    }

    public double getTongDuNoCon() {
        return tongDuNoCon;
    }

    public void setTongDuNoCon(double tongDuNoCon) {
        this.tongDuNoCon = tongDuNoCon;
    }

    public double getTongDuNoQuaHan() {
        return tongDuNoQuaHan;
    }

    public void setTongDuNoQuaHan(double tongDuNoQuaHan) {
        this.tongDuNoQuaHan = tongDuNoQuaHan;
    }

    public void setDsDotThanhToan(ArrayList<DotThanhToan> ds) {
        this.dsDotThanhToan = ds;
    }

    public ArrayList<DotThanhToan> getDsDotThanhToan() {
        return dsDotThanhToan;
    }

}
