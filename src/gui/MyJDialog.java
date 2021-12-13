package gui;

import javax.swing.*;
import java.awt.*;

public class MyJDialog extends JDialog {
    /**
     * класс который отвечает за контейнер JDialog
     */
    public MyJDialog(String title, int width, int heith) {
        super.setTitle(title);
        super.setSize(width, heith);
        super.setLocationRelativeTo(null);
        super.setLayout(new FlowLayout());
        super.setVisible(true);

        /**
         * нелзя такзакрывать(будет ошибка)
         * super.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
         * т.е окно закроет ,а программу не закроет
         */
    }

    public MyJDialog(String title, int width, int heith, Component comp) {
        this(title, width, heith);
        super.getContentPane().add(comp);
    }

}
