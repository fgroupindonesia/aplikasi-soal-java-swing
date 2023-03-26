
package fgroupindonesia.data;

/**
 *
 * @author asus
 */
public class User {
    public enum Type {
        kids, 
        parents
    }
    
    private Type jenis;
    private String username;
    private String pass;

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
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the jenis
     */
    public Type getJenis() {
        return jenis;
    }

    /**
     * @param jenis the jenis to set
     */
    public void setJenis(Type jenis) {
        this.jenis = jenis;
    }
    
}
