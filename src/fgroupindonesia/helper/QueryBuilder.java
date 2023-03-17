package fgroupindonesia.helper;

import fgroupindonesia.data.Conditional;
import java.lang.reflect.Field;

/**
 *
 * @author asus
 */
public class QueryBuilder {

    Conditional condt;
    Object dataObject;

    public static enum Mode {
        INSERT,
        UPDATE,
        DELETE
    }

    public void setConditional(Conditional con) {
        condt = con;
    }

    public String getValueSafe(String val) {
        String data = null;
        try {

            Integer v = Integer.parseInt(val);
            return v.toString();
        } catch (Exception e) {
            data = "'" + val + "'";
        }

        return data;
    }

    private String getConditionalQuery() {
        StringBuilder stb = null;

        if (condt != null) {
            stb = new StringBuilder();
            stb.append(condt.getColumn());
            stb.append("=");
            stb.append(getValueSafe(condt.getValue()));

        }

        return stb.toString();
    }

    public String getConditional() {
        return "WHERE " + getConditionalQuery();
    }

    public String generate(Mode ops, String table_name, Class ob) {
        String query = null;

        if (ops == Mode.INSERT) {
            query = "INSERT INTO " + table_name + getColumnAndValues_forInsert(ob);
        } else if (ops == Mode.UPDATE) {
            query = "UPDATE " + table_name + " " + getColumn_forUpdate(ob) + " " + getConditional();
        } else if (ops == Mode.DELETE) {
            query = "DELETE FROM " + table_name + " " + getConditional();
        }

        return query;
    }

    private String getColumn_forUpdate(Class ob) {
        String result = null;
        StringBuilder stb = new StringBuilder();
        // final output is:
        // column='value'

        Class yourClass = ob;

        stb.append("SET ");
        Field[] fields = yourClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            stb.append(fields[i].getName());
            stb.append("=");

        }

        result = stb.toString();

        return result;
    }

    private String getColumnAndValues_forInsert(Class ob) {
        String result = null;
        StringBuilder stb = new StringBuilder();
        // final output is:
        // (column, col) VALUES (?,?)

        Class yourClass = ob;

        stb.append("(");
        Field[] fields = yourClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            stb.append(fields[i].getName());
            if (i < fields.length - 1) {
                stb.append(",");
            }
        }

        stb.append(")");
        stb.append("VALUES (");
        for (int i = 0; i < fields.length; i++) {
            stb.append("?");
            if (i < fields.length - 1) {
                stb.append(",");
            }
        }

        stb.append(")");
        result = stb.toString();

        return result;
    }
}