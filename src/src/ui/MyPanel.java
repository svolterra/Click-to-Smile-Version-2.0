package ui;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public Image background;

    public MyPanel(String imageName) {
        background = new ImageIcon(imageName).getImage();
        this.setPreferredSize(new Dimension(640, 381));

    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 0, null);
    }



}
