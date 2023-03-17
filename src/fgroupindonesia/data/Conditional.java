
package fgroupindonesia.data;

/**
 *
 * @author asus
 */
public class Conditional {
    private String column;
    private String value;

    public Conditional(){
        
    }
    
    public Conditional(String c, int v){
        column = c;
        value = "" + v;
    }
    
    public Conditional(String c, String v){
        column = c;
        value = v;
    }
    
    /**
     * @return the column
     */
    public String getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(String column) {
        this.column = column;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
}
