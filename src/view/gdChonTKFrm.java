package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gdChonTKFrm extends JFrame implements ActionListener {
    private JButton btnTiepTuc;

    public gdChonTKFrm() {
        setTitle("Chọn thống kê");
        setSize(450, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTitle = new JLabel("Chọn thống kê");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblTitle);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel lblTen = new JLabel("Đỗ Văn A");
        lblTen.setFont(new Font("Arial", Font.ITALIC, 22));
        lblTen.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblTen);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel selectPanel = new JPanel();
        selectPanel.setLayout(new BoxLayout(selectPanel, BoxLayout.X_AXIS));
        selectPanel.setOpaque(false);

        JLabel lblLoai = new JLabel("Loại thống kê");
        lblLoai.setFont(new Font("Arial", Font.BOLD, 20));
        selectPanel.add(lblLoai);
        selectPanel.add(Box.createRigidArea(new Dimension(20, 0)));

        JComboBox<String> cbLoai = new JComboBox<>(new String[] { "Thống kê khách hàng theo dư nợ" });
        cbLoai.setFont(new Font("Arial", Font.BOLD, 18));
        cbLoai.setBackground(new Color(200, 200, 200));
        cbLoai.setPreferredSize(new Dimension(220, 40));
        selectPanel.add(cbLoai);

        mainPanel.add(selectPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        btnTiepTuc = new JButton("Tiếp tục");
        btnTiepTuc.setFont(new Font("Arial", Font.BOLD, 22));
        btnTiepTuc.setBackground(new Color(144, 238, 144));
        btnTiepTuc.setForeground(Color.BLACK);
        btnTiepTuc.setFocusPainted(false);
        btnTiepTuc.setBorder(BorderFactory.createLineBorder(new Color(60, 120, 60), 2));
        btnTiepTuc.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnTiepTuc.setPreferredSize(new Dimension(250, 50));
        btnTiepTuc.addActionListener(this);
        mainPanel.add(btnTiepTuc);

        add(mainPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTiepTuc) {
            new gdThongKeFrm().setVisible(true);
        }
    }
}
