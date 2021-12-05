package listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private JPanel panel;
    public ButtonListener(JPanel panel){
        this.panel=panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton){//проверка JButton ли это
            JButton button=(JButton) e.getSource();//сохраняем в переменную button
            JOptionPane.showMessageDialog(panel,"Test message from "+button.getText());

        }
    }
}
