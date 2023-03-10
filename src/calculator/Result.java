package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class Result extends Calculator implements ActionListener  {
    boolean check(String text) {
        return text.equals("+") || text.equals("-") || text.equals("×") || text.equals("÷") || text.equals("%");
    }
    protected void reset() {
        label.setText("");
        total_data = "";
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = e.getActionCommand();

        System.out.println(math);

        if(math.equals("?")) {
            info.setFont(new Font("맑은 고딕", Font.BOLD , 55));
            info.setText("0");
            reset();
        }

        if (text.equals("=")) {
            if(label.getText().contains("=")) {
                return;
            }
            if(check(math)||info.getText().equals("0")) {
                total_data+=info.getText();
            }
//            if(!total_data.contains("+")&&!total_data.contains("-")&&!total_data.contains("×")&&!total_data.contains("÷")&&!total_data.contains("%")&&!total_data.contains("=")) {
//                total_data+="+0";
//            }
            if(!num.equals("")) num1 = num;
            num = info.getText();
            label.setText(total_data+text);
            if (total_data != null && total_data.length() > 0) {
                try{
                    BigDecimal data = calc(total_data);
                    info.setText(data.toString());
                } catch (ArithmeticException ex) {
                    System.out.println(ex.toString());
                    text = "";
                    info.setFont(new Font("맑은 고딕", Font.BOLD , 30));
                    info.setText("0으로 나눌수 없습니다.");
                }
            }
        } else if(text.equals("←"))  {
            if(check(math)) return;
            if(label.getText().contains("=")) {
                reset();
                return;
            }
            if(info.getText().length()>1) {
                info.setText(info.getText().substring(0, info.getText().length()-1));
                total_data = label.getText()+info.getText();
            } else {
                info.setText("0");
                total_data= label.getText();
            }
        } else if (text.equals("C")) {
            info.setText("0");
            reset();
        } else if (text.equals("CE")) {
            info.setText("0");
            total_data = label.getText();
            if(label.getText().contains("=")) {
                reset();
            }
        } else if(check(text)) {
            if(text.equals(math)||math.equals("?")) {
                return;
            } else if ((label.getText().equals("")&&info.getText().equals("0"))) {
                total_data = "0";
            } else if(check(math)) {
                total_data = total_data.substring(0, total_data.length()-1);
            } else if(math.equals("=")) {
                total_data = info.getText();
                history.setText(label.getText());
            } else if(math.equals("CE")&&info.getText().equals("0")) {
                total_data+="0";
            }
            total_data += text;
            label.setText(total_data);
        }
        else {
            if(label.getText().contains("=")) {
                info.setText("0");
                history.setText(label.getText());
                reset();
            }
            if (check(math)) {
                info.setText("0");
            }
            if ((text.equals("0")&&info.getText().equals("0"))||((info.getText().contains(".")&&text.equals(".")))) {
                return;
            }
            if(((info.getText().equals("0")||info.getText()==null))||check(math)) info.setText("");
            if(text.equals(".")&&(info.getText().equals("0")||info.getText().equals("")||info.getText()==null)) {
                total_data+="0";
                info.setText("0");
            }


            total_data += text;

            info.setText(info.getText()+text);
        }
        math = text;
    }
    public static BigDecimal calc(String input) {
        int i;
        i = input.indexOf('+'); //TODO [+] 문자의 인덱스 위치 확인

        if (i != -1) { //TODO [+] 문자가 있으니까 -1이 아니여야 함 (indexOf는 찾을려는 문자가 없으면 -1 반환)
            return calc(input.substring(0, i)).add(calc(input.substring(i + 1)));
        }
        else { //TODO [+] 문자가 없을 경우는 [-], [*], [/] 연산자 포함 여부를 확인합니다
            i = input.indexOf('-');
            if (i != -1) {
                return calc(input.substring(0, i)).subtract(calc(input.substring(i + 1)));
            }
            else {
                i = input.indexOf('×');
                if (i != -1) {
                    return calc(input.substring(0, i)).multiply(calc(input.substring(i + 1)));
                }
                else {
                    i = input.indexOf('÷');
                    if (i != -1) {
                        return calc(input.substring(0, i)).divide(calc(input.substring(i + 1)), 2, BigDecimal.ROUND_CEILING);
                    }
                    else {
                        i = input.indexOf('%');
                        if (i != -1) {
                            return calc(input.substring(0, i)).remainder(calc(input.substring(i + 1)));
                        }
                    }
                }
            }
        }

        return new BigDecimal(input.trim());
        //((Math.round(Double.parseDouble(data)*10000)/10000.0))
    }

}