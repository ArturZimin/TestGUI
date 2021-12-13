package gui;

import javax.swing.*;
import java.awt.*;

public class MyJTextField extends JTextField {


    public MyJTextField() {
    }

    public MyJTextField(String text, int columns) {//сдесь можнот задавать текст и размер
        this(columns);
        super.setText(text);
    }

    public MyJTextField(int columns) {//можно задавать размер
        super.setColumns(columns);
        Font font = new Font("Courier", Font.ITALIC, 12);//шрифт
        super.setFont(font);
        super.setForeground(Color.GRAY);//цвет фона текстового поля
    }

    public MyJTextField(int columns, Color textColor) {//можем передать цвет текста и он будет такого цвера
        super.setColumns(columns);
        Font font = new Font("Courier", Font.ITALIC, 12);
        super.setFont(font);
        super.setForeground(textColor);
    }


}
