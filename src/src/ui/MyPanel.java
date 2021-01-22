package ui;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private Image background;

    public MyPanel() {
        background = new ImageIcon("sheep.png").getImage();
        this.setPreferredSize(new Dimension(640, 381));

    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 0, null);
    }

}
