package fgroupindonesia.helper;

import fgroupindonesia.data.History;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class LoginHistory {

    String filename = SystemPath.getCompletePath("user_history.log");

    public void add(History masuk) {

        try {
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(masuk.toString());
            bw.newLine();
            bw.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
