package listeners;

import by.zimin.MyJTextField;
import by.zimin.TestGUI;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CalcTextFieldFocusListener implements FocusListener {

    private MyJTextField field;

    public CalcTextFieldFocusListener(MyJTextField field) {
        this.field = field;
    }


    @Override
    public void focusGained(FocusEvent e) {
        if (field.getText().equals(TestGUI.INPUT_NUMBER)) {
            field.setText("");
            field.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (field.getText().equals("")) {
            field.setText(TestGUI.INPUT_NUMBER);
            field.setForeground(Color.BLACK);
        }
    }
}
