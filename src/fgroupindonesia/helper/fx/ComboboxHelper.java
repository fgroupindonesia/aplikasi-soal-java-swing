package fgroupindonesia.helper.fx;

import javax.swing.JComboBox;

/**
 *
 * @author asus
 */
public class ComboboxHelper {

    public boolean isInCombobox(JComboBox jc, String val) {
        boolean has = false;

        for (int i = 0; i < jc.getItemCount(); i++) {
            String item = jc.getItemAt(i).toString();
            if (val.equalsIgnoreCase(item)) {
                has = true;
                break;
            }
        }

        return has;
    }

}
