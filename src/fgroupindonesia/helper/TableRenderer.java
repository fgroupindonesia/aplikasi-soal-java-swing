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

    private DefaultTableModel getTableModel(JTable table) {
        return (DefaultTableModel) table.getModel();
    }

    public void render_category(JTable table, ArrayList<Category> list) {
        for (Category cat : list) {
            Object[] data = {false, cat.getId(), cat.getNama(), cat.getTanggal()};
            this.getTableModel(table).addRow(data);
        }
    }

    public void render_question(JTable table, ArrayList<Question> list) {
        for (Question cat : list) {
            Object[] data = {false, cat.getId(), cat.getNama(), cat.getJumlah_pertanyaan(), cat.getKategori(), cat.getTanggal()};
            this.getTableModel(table).addRow(data);
        }
    }
    public void render_rewards(JTable table, ArrayList<Rewards> list) {
        for (Rewards cat : list) {
            Object[] data = {false, cat.getId(), cat.getNama(), cat.getFilename()};
            this.getTableModel(table).addRow(data);
        }
    }
    
    public void render_student(JTable table, ArrayList<Student> list) {
        for (Student cat : list) {
            Object[] data = {false, cat.getId(), cat.getNama(), cat.getTtl(), cat.getKelas()};
            this.getTableModel(table).addRow(data);
        }
    }

    public void render_answer_question(JTable table, ArrayList<AnswerQuestion> list) {
        for (AnswerQuestion cat : list) {
            Object[] data = {false, cat.getId(), cat.getNama_student(), cat.getNama_soal(),
                cat.getNomor_soal(), cat.getJawaban_soal(), cat.getStatus(), cat.getTanggal()};
            this.getTableModel(table).addRow(data);
        }
    }

}
