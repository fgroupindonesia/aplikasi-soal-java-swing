package fgroupindonesia.helper;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JDesktopPane;

/**
 *
 * @author asus
 */
public class CustomJDesktopPane extends JDesktopPane {

    private BufferedImage img;

    public CustomJDesktopPane(BufferedImage imgIn) {
        img = imgIn;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
         grphcs.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(img.getWidth(), img.getHeight());
    }

}
