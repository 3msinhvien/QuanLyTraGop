package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import model.KhachHang;
import dao.KhachHangDAO;
import model.HopDong;
import java.util.ArrayList;

public class gdDSHopDongFrm extends JFrame {
    private JTable tblDSHopDong;
    private KhachHang khachHang;

    public gdDSHopDongFrm(KhachHang khachHang) {
        this.khachHang = khachHang;

        // Khởi tạo giao diện
        setTitle("Danh sách hợp đồng");
        setLayout(new BorderLayout(10, 10));

        // Panel chứa tiêu đề
        JPanel titlePanel = new JPanel();
        JLabel lblTitle = new JLabel("Danh sách hợp đồng của khách hàng: " + khachHang.getTen());
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        titlePanel.add(lblTitle);
        add(titlePanel, BorderLayout.NORTH);

        // Tạo table
        tblDSHopDong = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblDSHopDong);
        add(scrollPane, BorderLayout.CENTER);

        // Panel chứa nút điều khiển
        JPanel buttonPanel = new JPanel();
        JButton btnDong = new JButton("Đóng");
        btnDong.setBackground(new Color(144, 238, 144));
        btnDong.setPreferredSize(new Dimension(100, 30));
        buttonPanel.add(btnDong);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load dữ liệu
        loadTableData();

        // Thêm action listener
        btnDong.addActionListener(e -> dispose());

        // Cài đặt frame
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void loadTableData() {
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        ArrayList<HopDong> dsHopDong = khachHangDAO.getDSHopDong(khachHang.getId());

        String[] columnNames = {
                "STT", "Mã HĐ", "Ngày ký", "Tổng tiền vay", "Tổng số lần trả", "Tổng dư nợ", "Tổng dư nợ quá hạn"
        };

        Object[][] data = new Object[dsHopDong.size()][columnNames.length];
        for (int i = 0; i < dsHopDong.size(); i++) {
            data[i][0] = i + 1;
            data[i][1] = dsHopDong.get(i).getId();
            data[i][2] = dsHopDong.get(i).getNgayKy();
            data[i][3] = dsHopDong.get(i).getTongTienVay();
            data[i][4] = dsHopDong.get(i).getTongSoLanTra();
            data[i][5] = dsHopDong.get(i).getTongDuNo();
            data[i][6] = dsHopDong.get(i).getTongDuNoQuaHan();
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblDSHopDong.setModel(model);
    }
}
