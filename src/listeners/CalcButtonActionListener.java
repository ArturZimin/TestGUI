package listeners;

import by.zimin.MyJTextField;
import calc.CalcOperations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcButtonActionListener implements ActionListener {

    private MyJTextField jtxtChislo1;
    private MyJTextField jtxtChislo2;
    private MyJTextField jtxtResult;

    public CalcButtonActionListener(MyJTextField jtxtChislo1, MyJTextField jtxtChislo2, MyJTextField jtxtResult) {
        this.jtxtChislo1 = jtxtChislo1;
        this.jtxtChislo2 = jtxtChislo2;
        this.jtxtResult = jtxtResult;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof JButton)) {//если источник событий не является кнопкой?
            return;//тогда выходим
        }
        JButton btn = (JButton) e.getSource();//из объекта превращаем в кнопку
        final double a = Double.parseDouble(jtxtChislo1.getText());//превращаем в числа double
        final double b = Double.parseDouble(jtxtChislo2.getText());

        if (btn.getActionCommand().equals("Plus '+'")) {//если == сложению
            jtxtResult.setText(String.valueOf(CalcOperations.add(a, b)));
        } else if (btn.getActionCommand().equals("Minus '-'")) {
            jtxtResult.setText(String.valueOf(CalcOperations.subtract(a, b)));
        }else if (btn.getActionCommand().equals("Divide '/'")) {
            jtxtResult.setText(String.valueOf(CalcOperations.divide(a, b)));
        }else if (btn.getActionCommand().equals("Multiply '*'")){
            jtxtResult.setText(String.valueOf(CalcOperations.multiply(a,b)));
        }
    }
}

