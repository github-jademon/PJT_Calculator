package calculator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UpPanel extends Calculator {
    public UpPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(242, 242, 242));

        JPanel j = new JPanel();
        j.setBackground(new Color(242, 242, 242));
        j.setLayout(new BorderLayout());

        label = new JLabel("");
        info = new JLabel("0");
        history = new JLabel("");

        history.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
        history.setForeground(Color.BLACK);
        history.setHorizontalAlignment(SwingConstants.RIGHT);
        history.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(history.getText().contains("=")) {
                    int n = history.getText().length();
                    String m = num1.equals("")||!label.getText().contains("=")?num:num1;
                    if(m.equals(num1)) {
                        num = num1;
                        num1 = "";
                    }
                    info.setText(m);
                    label.setText(history.getText().substring(0, n-1-m.length()));
                    math = "";
                    total_data = label.getText()+info.getText();
                }
            }
        });

        label.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.RIGHT);

        info.setFont(new Font("맑은 고딕", Font.BOLD , 55));
        info.setForeground(Color.BLACK);
        info.setHorizontalAlignment(SwingConstants.RIGHT);

        j.add(history, BorderLayout.NORTH);
        j.add(label, BorderLayout.SOUTH);

        add(j, BorderLayout.NORTH);
        add(info, BorderLayout.CENTER);
    }
}
