package gui;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {
    /**
     * icon get from repository images
     */
   // private  Image calc=new ImageIcon(getClass().getResource("images/icon.jpg")).getImage();

    public MyJFrame(String title, int width, int height) {
        super(title);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);//чтобы центрировать окно рамку и тд.Следует вызывать после setSize()
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//штобы закрывался по закрытии окошка
        super.setLayout(new FlowLayout());
        super.setIconImage(new ImageIcon("C:\\Users\\Office\\IdeaProjects\\TestGUI\\src\\images\\icon.jpg").getImage());//добавляем иконку в рамку


    }

    public MyJFrame(String title, int width, int height, Component comp) {
        this(title, width, height);
        super.getContentPane().add(comp);

    }

    public MyJFrame(String title, int width, int height, LayoutManager layout) {
        super(title);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);//чтобы центрировать окно рамку и тд.Следует вызывать после setSize()
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//штобы закрывался по закрытии окошка
        super.setLayout(layout);
        super.setIconImage(new ImageIcon("C:\\Users\\Office\\IdeaProjects\\TestGUI\\src\\images\\icon.jpg").getImage());//добавляем иконку в рамку


    }
}
