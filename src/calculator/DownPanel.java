package calculator;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

class DownPanel extends Calculator{
    public DownPanel() {
        JButton[] btn = new JButton[20];
        setLayout(new GridLayout(5, 4, 2, 2));
        setBackground(new Color(242, 242, 242));
        setBorder(new LineBorder(new Color(242, 242, 242), 2));

        btn[0] = new JButton("%");
        btn[1] = new JButton("CE");
        btn[2] = new JButton("C");
        btn[3] = new JButton("÷");

        btn[4] = new JButton("7");
        btn[5] = new JButton("8");
        btn[6] = new JButton("9");
        btn[7] = new JButton("×");

        btn[8] = new JButton("4");
        btn[9] = new JButton("5");
        btn[10] = new JButton("6");
        btn[11] = new JButton("-");

        btn[12] = new JButton("1");
        btn[13] = new JButton("2");
        btn[14] = new JButton("3");
        btn[15] = new JButton("+");

        btn[16] = new JButton(".");
        btn[17] = new JButton("0");
        btn[18] = new JButton("←");
        btn[19] = new JButton("=");

        int i = 0;
        for(JButton j:btn) {
            j.setPreferredSize(new Dimension(0, 65));
            j.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
            j.setForeground(Color.BLACK);
            j.setBorderPainted(false);

            if(3 < i && i < 15 && i % 4 != 3) {
                Color color = new Color(252, 252, 252);
                j.setBackground(color);

                j.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) { j.setBackground(Color.red); }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        j.setBackground(color);
                    }
                });
            } else if(i == 17) {
                Color color = new Color(252, 252, 252);
                j.setBackground(color);

                j.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) { j.setBackground(Color.red); }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        j.setBackground(color);
                    }
                });
            } else if(i == 19) {
                Color color = new Color(192, 192, 192);
                j.setBackground(color);

                j.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) { j.setBackground(Color.red); }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        j.setBackground(color);
                    }
                });
            } else {
                Color color = new Color(248, 248, 248);
                j.setBackground(color);
                j.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) { j.setBackground(Color.red); }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        j.setBackground(color);
                    }
                });
            }
            j.addActionListener(new Result());
            add(j);
            i++;
        }
    }
}