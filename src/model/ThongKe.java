package model;

public class ThongKe extends KhachHang{
    private double tongDuNoCon ;
    private double tongDuNoQuaHan;

    public ThongKe() {
        super();
    }

    public ThongKe(int id, String ten, double tongDuNoCon, double tongDuNoQuaHan) {
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

    

}
