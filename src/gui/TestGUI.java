package gui;

import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import listeners.CalcButtonActionListener;
import listeners.CalcTextFieldFocusListener;
import listeners.ChangeSkinActionListener;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;

public class TestGUI {

    public static final String INPUT_NUMBER = "Enter number";

    private MyJButton btnAdd;
    private MyJButton btnSubtract;
    private MyJButton btnDivide;
    private MyJButton btnMultiply;
    private MyJButton btnChangesSkin;
    private MyJButton btnChangesSkin2;
    private MyJButton btnChangesSkin3;


    private JLabel labelChislo1;
    private JLabel labelChislo2;
    private JLabel labelResult;

    private MyJTextField myJTextChislo1;
    private MyJTextField myJTextChislo2;
    private MyJTextField myJTextResult;


    private MyJPanel panel1;
    private MyJPanel panel2;
    private MyJPanel result;

    private MyJFrame frame;


    public static void main(String[] args) {
/**
 * Подключать скин  нужно в самом начале!
 */


        // UIManager.setLookAndFeel(new AeroLookAndFeel());
        try {
            UIManager.setLookAndFeel(new HiFiLookAndFeel());//подключаем скин AcrylLookAndFeel
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


        JFrame.setDefaultLookAndFeelDecorated(true);

        TestGUI testGUI = new TestGUI();//создаем экземпляр класса

        testGUI.createLabels();
        testGUI.createTextField();
        testGUI.createButton();
        testGUI.createPanels();
        testGUI.createFrame();
        testGUI.creatSkinListeners();

    }


    private void createButton() {//создает кнопки
        btnAdd = new MyJButton("Plus '+'");
        btnSubtract = new MyJButton("Minus '-'");
        btnDivide = new MyJButton("Divide '/'");
        btnMultiply = new MyJButton("Multiply '*'");

        btnChangesSkin = new MyJButton("Aero skin");
        btnChangesSkin2 = new MyJButton("Metal skin");
        btnChangesSkin3 = new MyJButton("Luna skin");


        addButtonListeners();

    }

    private void createLabels() {//3 текста отображения
        labelChislo1 = new JLabel("Number 1:");
        labelChislo2 = new JLabel("Number 2:");
        labelResult = new JLabel("Result:");
    }

    private void createTextField() {//метод создает текстовые поля
        myJTextChislo1 = new MyJTextField(INPUT_NUMBER, 10);//cоздается текстовое поле с шириной 10
        myJTextChislo2 = new MyJTextField(INPUT_NUMBER, 10);

        myJTextResult = new MyJTextField(20, Color.RED);//создается 3 текстовое поле шир15 с цветом
        myJTextResult.setEditable(false);//нельзя редактировать
        myJTextResult.setFocusable(false);//нельзя на негосчелкнуть мышкой

        addTextFieldListeners();
    }


    private void createPanels() {//will be three containers
        panel1 = new MyJPanel("Panel1", 100, 100);//создается панел
        panel1.setPreferredSize(new Dimension(200, 50));//задается предпочитаемый размер
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));//указываем менеджер расположения встроку(Flow) ,
        // начинает добавлять с лева на право
/**
 * на все панели нужно дабавить все наши компоненты
 */
        panel2 = new MyJPanel("Panel2", 100, 100);
        panel2.setPreferredSize(new Dimension(200, 50));
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

        result = new MyJPanel("Panel3", 100, 100);
        result.setPreferredSize(new Dimension(200, 50));
        result.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel1.add(labelChislo1);
        panel1.add(myJTextChislo1);
        panel1.add(labelChislo2);
        panel1.add(myJTextChislo2);

        panel2.add(btnAdd);
        panel2.add(btnSubtract);
        panel2.add(btnMultiply);
        panel2.add(btnDivide);

        result.add(labelResult);
        result.add(myJTextResult);
        result.add(btnChangesSkin);
        result.add(btnChangesSkin2);
        result.add(btnChangesSkin3);

    }

    private void createFrame() {
        /**
         * создается фрэйм (главный контейнер) ,указывается размер в пикселях
         */
        frame = new MyJFrame("My new app Calculate from Artur Zimin ", 590, 250, new BorderLayout(2, 2));//2 расстояние между контейнерами(panels)
        frame.setMinimumSize(new Dimension(530, 250));//чтобы нельзя было уменьшить размер меньше заданного

        frame.setResizable(false);//запретить изменять размер окна и убирает кнопку развернуть
        /**
         * добавляем наши панели с крмпанентами во фрэйм
         */
        frame.getContentPane().add(panel1, BorderLayout.NORTH);
        frame.getContentPane().add(panel2, BorderLayout.CENTER);
        frame.getContentPane().add(result, BorderLayout.SOUTH);

        frame.setVisible(true);

    }

    private void addButtonListeners() {
        /**
         * cоздаем экземпляр класса слушателя и передаем ссылки текстовыею
         * Чтобы обработать 2 ,а в третьем вывести результат
         */
        CalcButtonActionListener b1 = new CalcButtonActionListener(myJTextChislo1, myJTextChislo2, myJTextResult);
        btnAdd.addActionListener(b1);
        btnSubtract.addActionListener(b1);
        btnMultiply.addActionListener(b1);
        btnDivide.addActionListener(b1);
    }

    private void addTextFieldListeners() {
        myJTextChislo1.addFocusListener(new CalcTextFieldFocusListener(myJTextChislo1));
        myJTextChislo2.addFocusListener(new CalcTextFieldFocusListener(myJTextChislo2));

    }

    private void creatSkinListeners() {
        btnChangesSkin.addActionListener(new ChangeSkinActionListener(frame, new AeroLookAndFeel()));
        btnChangesSkin2.addActionListener(new ChangeSkinActionListener(frame, new MetalLookAndFeel()));
        btnChangesSkin3.addActionListener(new ChangeSkinActionListener(frame, new LunaLookAndFeel()));

    }

}