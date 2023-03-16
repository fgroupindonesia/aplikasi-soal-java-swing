package fgroupindonesia.data;

import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author asus
 */
public class History {

    public History(String us, User.Type jns) {
        this.setUsername(us);
        this.setJenis(jns);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        this.setTanggal(sdf.format(new Date()));
    }

    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    private String username;
    private User.Type jenis;
    private String tanggal;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the jenis
     */
    public User.Type getJenis() {
        return jenis;
    }

    /**
     * @param jenis the jenis to set
     */
    public void setJenis(User.Type jenis) {
        this.jenis = jenis;
    }

    /**
     * @return the tanggal
     */
    public String getTanggal() {
        return tanggal;
    }

    /**
     * @param tanggal the tanggal to set
     */
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
