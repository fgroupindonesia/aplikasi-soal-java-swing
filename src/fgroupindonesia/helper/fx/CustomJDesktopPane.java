package fgroupindonesia.helper.fx;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JDesktopPane;

/**
 *
 * @author asus
 */
public class CustomJDesktopPane extends JDesktopPane {

    private BufferedImage img;
    private float alpha = 0f;
    private long startTime = -1;
    final long RUNNING_TIME = 2000;

    final Timer timer = new Timer(40, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (startTime < 0) {
                startTime = System.currentTimeMillis();
            } else {

                long time = System.currentTimeMillis();
                long duration = time - startTime;
                if (duration >= RUNNING_TIME) {
                    startTime = -1;
                    ((Timer) e.getSource()).stop();
                    alpha = 0f;
                } else {
                    alpha = 1f - ((float) duration / (float) RUNNING_TIME);
                }
                repaint();
            }
        }
    });

    public CustomJDesktopPane(BufferedImage imgIn) {
        img = imgIn;
        alpha = 0f;

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs.create();

        g2d.setComposite(AlphaComposite.SrcOver.derive(1f - alpha));
        g2d.drawImage(img, 0, 0, getWidth(), getHeight(), null);

        //g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
        //g2d.drawImage(img, 0, 0, getWidth(), getHeight(), null);

        g2d.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(img.getWidth(), img.getHeight());
    }

}
