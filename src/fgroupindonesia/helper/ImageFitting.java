package fgroupindonesia.helper;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author fgroupindonesia
 */
public class ImageFitting {

    public void fitInto(JLabel label, String fileName) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(fileName));
            Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
                    Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            label.setIcon(imageIcon);

        } catch (Exception e) {
            System.out.println("Error at fitInto() " + e.getMessage());
            //e.printStackTrace();
        }
    }

}
