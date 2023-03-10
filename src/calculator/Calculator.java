package calculator;

import javax.swing.*;

public class Calculator extends JPanel {
    static JLabel history;
    static JLabel label;
    static JLabel info;
    static String math="";
    static String total_data = "";
    static String num="";
    static String num1="";

    public void setBackSpace(String bs) {
        info.setText(bs);
    }

    public String getBackSpace() {
        return info.getText();
    }

}
