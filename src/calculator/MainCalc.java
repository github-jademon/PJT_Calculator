package calculator;

import javax.swing.*;
import java.awt.*;

public class MainCalc extends JFrame {
    public MainCalc() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        add(p);

        p.setLayout(new BorderLayout(5, 5));
        p.setBackground(new Color(242, 242, 242));

        p.add(new UpPanel(), BorderLayout.EAST);
        p.add(new DownPanel(), BorderLayout.SOUTH);

        setSize(340, 570);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainCalc();
    }
}
