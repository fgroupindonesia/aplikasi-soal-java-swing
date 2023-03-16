package fgroupindonesia.helper;

import java.io.File;

/**
 *
 * @author asus
 */
public class SystemPath {

    private static final String APP_NAME = "fgroupindonesia" + File.separator + "AplikasiSoal";

    public static String getCompletePath() {

        File f = new File(System.getenv("APPDATA") + File.separator + APP_NAME);
        if (!f.exists()) {
            f.mkdirs();
        }

        return f.getAbsolutePath();

    }

    public static String getCompletePath(String fname) {
        return getCompletePath() + File.separator + fname;

    }
}
