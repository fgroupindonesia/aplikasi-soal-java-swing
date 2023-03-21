package fgroupindonesia.data;

/**
 *
 * @author asus
 */
public class NavigasiQuestion {

    public static int current_index = 0;
    public static final int CONFIG_SOAL = 0;
    public static final int EDIT_SOAL = 1;

    public static void reset() {
        current_index = -1;
    }

}
