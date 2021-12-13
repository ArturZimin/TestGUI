package listeners;

import gui.MyJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChangeSkinActionListener implements ActionListener {
    private LookAndFeel laf;
    private MyJFrame frame;

    public ChangeSkinActionListener(MyJFrame frame, LookAndFeel laf) {
        this.frame = frame;
        this.laf = laf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            UIManager.setLookAndFeel(laf);//подключаем скин AcrylLookAndFeel    }
        } catch (UnsupportedLookAndFeelException o) {
            Logger.getLogger(ChangeSkinActionListener.class.getName()).log(Level.SEVERE,null,o);
        }
        SwingUtilities.updateComponentTreeUI(frame);//занимается перересовкой всех компонентов с новым скином
    }
}