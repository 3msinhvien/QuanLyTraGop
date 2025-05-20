package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gdChinhQLFrm extends JFrame implements ActionListener {
    private JButton btnThongKe;

    public gdChinhQLFrm(String tenQuanLy) {
        setTitle("Trang chủ quản lý");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTitle = new JLabel("Trang chủ quản lý");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblTitle);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel lblTen = new JLabel(tenQuanLy);
        lblTen.setFont(new Font("Arial", Font.ITALIC, 22));
        lblTen.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblTen);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        btnThongKe = new JButton("Xem thống kê");
        btnThongKe.setFont(new Font("Arial", Font.BOLD, 20));
        btnThongKe.setBackground(new Color(144, 238, 144));
        btnThongKe.setForeground(Color.BLACK);
        btnThongKe.setFocusPainted(false);
        btnThongKe.setBorder(BorderFactory.createLineBorder(new Color(60, 120, 60), 2));
        btnThongKe.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnThongKe.setPreferredSize(new Dimension(200, 50));
        btnThongKe.addActionListener(this);
        mainPanel.add(btnThongKe);

        add(mainPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnThongKe) {
            new gdChonTKFrm().setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new gdChinhQLFrm("Đỗ Văn A").setVisible(true);
        });
    }
}
