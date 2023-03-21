package fgroupindonesia.helper;

import fgroupindonesia.data.AnswerQuestion;
import fgroupindonesia.data.Category;
import fgroupindonesia.data.History;
import fgroupindonesia.data.Question;
import fgroupindonesia.data.Rewards;
import fgroupindonesia.data.Student;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class TableRenderer {

    public static final int DATA_NOT_AVAILABLE = -1;
    
    public int getCheckedData(JTable table, int colIndex) {
        int val = -1;

        for (int i = 0; i < table.getRowCount(); i++) {
            boolean b = (Boolean) this.getTableModel(table).getValueAt(i, 0);
            if (b) {
                val = (Integer) this.getTableModel(table).getValueAt(i, colIndex);
                break;
            }
        }

        return val;
    }

    public ArrayList<Integer> getAllCheckedData(JTable table, int colIndex) {
        int val = -1;
        ArrayList<Integer> data = new ArrayList<Integer>();

        for (int i = 0; i < table.getRowCount(); i++) {
            boolean b = (Boolean) this.getTableModel(table).getValueAt(i, 0);
            if (b) {
                val = (Integer) this.getTableModel(table).getValueAt(i, colIndex);
                data.add(val);
            }
        }

        return data;
    }

    private void clearData(JTable table) {
        DefaultTableModel dfm = (DefaultTableModel) table.getModel();
        dfm.setRowCount(0);
    }

    private DefaultTableModel getTableModel(JTable table) {
        DefaultTableModel dfm = (DefaultTableModel) table.getModel();
        return dfm;
    }

    public void render_category(JTable table, ArrayList<Category> list) {
        clearData(table);

        for (Category cat : list) {
            Object[] data = {false, cat.getId(), cat.getNama(), cat.getTanggal()};
            this.getTableModel(table).addRow(data);
        }
    }

    public void render_question(JTable table, ArrayList<Question> list) {
        clearData(table);

        for (Question cat : list) {
            Object[] data = {false, cat.getId(), cat.getNama(), cat.getJumlah_pertanyaan(), cat.getKategori(), cat.getTanggal()};
            this.getTableModel(table).addRow(data);
        }
    }
    
    public void render_history(JTable table, ArrayList<History> list) {
        clearData(table);

        for (History cat : list) {
            Object[] data = {cat.getId(), cat.getUsername(), cat.getJenis(), cat.getDescription(), cat.getTanggal()};
            this.getTableModel(table).addRow(data);
        }
    }

    public void render_rewards(JTable table, ArrayList<Rewards> list) {
        clearData(table);

        for (Rewards cat : list) {
            Object[] data = {false, cat.getId(), cat.getNama(), cat.getFilename()};
            this.getTableModel(table).addRow(data);
        }
    }

    public void render_student(JTable table, ArrayList<Student> list) {
        clearData(table);

        for (Student cat : list) {
            Object[] data = {false, cat.getId(), cat.getNama(), cat.getTtl(), cat.getKelas()};
            this.getTableModel(table).addRow(data);
        }
    }

    public void render_answer_question(JTable table, ArrayList<AnswerQuestion> list) {
        clearData(table);

        for (AnswerQuestion cat : list) {
            Object[] data = {false, cat.getId(), cat.getNama_student(), cat.getNama_soal(),
                cat.getNomor_soal(), cat.getJawaban_soal(), cat.getStatus(), cat.getTanggal()};
            this.getTableModel(table).addRow(data);
        }
    }

}
