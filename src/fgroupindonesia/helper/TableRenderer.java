package fgroupindonesia.helper;

import fgroupindonesia.data.AnswerQuestion;
import fgroupindonesia.data.Category;
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
