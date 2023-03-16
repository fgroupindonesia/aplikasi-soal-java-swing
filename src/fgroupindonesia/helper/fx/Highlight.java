package fgroupindonesia.helper.fx;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author asus
 */
public class Highlight {

    public static void onFocus(Component jb) {
        //setButton(jb);
        jb.setBackground(Color.yellow);

        if (jb instanceof JLabel) {
            jb.setForeground(Color.yellow);
        }

    }

    public static void onLost(Component jb) {
        //setButton(jb);
        jb.setBackground(null);

        if (jb instanceof JLabel) {
            jb.setForeground(null);
        }
    }

}
