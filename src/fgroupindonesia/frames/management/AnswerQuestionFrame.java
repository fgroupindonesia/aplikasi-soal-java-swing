package fgroupindonesia.frames.management;

import fgroupindonesia.data.AnswerQuestion;
import fgroupindonesia.data.Question;
import fgroupindonesia.data.Student;
import fgroupindonesia.frames.MainFrame;
import fgroupindonesia.helper.DBConnection;
import fgroupindonesia.helper.TableRenderer;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class AnswerQuestionFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form AnswerQuestionFrame
     */
    public AnswerQuestionFrame() {
        initComponents();
        db = new DBConnection();
        renderNamaStudent();
        renderNamaSoal();
    }

    private void renderNamaStudent() {
        comboboxNamaStudent.removeAllItems();

        ArrayList<Student> list = db.select_student_all();

        for (Student st : list) {
            comboboxNamaStudent.addItem(st.getNama());
        }

    }

    private void renderNamaSoal() {
        comboboxNamaSoal.removeAllItems();

        ArrayList<Question> list = db.select_question_all();

        for (Question st : list) {
            comboboxNamaSoal.addItem(st.getNama());
        }

    }

    DBConnection db;
    TableRenderer tableRender;
    MainFrame mframe;
    AnswerQuestion data;

    public void setMainFrameReference(MainFrame mf) {
        mframe = mf;
    }

    private void obtainFormValues() {
        data.setNama_soal(comboboxNamaSoal.getSelectedItem().toString());
        data.setNama_student(comboboxNamaStudent.getSelectedItem().toString());
        data.setNomor_soal((Integer.parseInt(textfieldNomorSoal.getText())));
        data.setJawaban_soal(textfieldJawabanSoal.getText());
        data.setStatus(comboboxStatus.getSelectedItem().toString());
    }

    public void setEditMode(int id) {
        data = db.select_answer_question_specific(id);

        comboboxNamaStudent.setSelectedItem(data.getNama_student());
        comboboxNamaSoal.setSelectedItem(data.getNama_soal());
        textfieldNomorSoal.setText("" + data.getNomor_soal());
        textfieldJawabanSoal.setText(data.getJawaban_soal());
        comboboxStatus.setSelectedItem(data.getStatus());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboboxNamaStudent = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboboxNamaSoal = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        textfieldNomorSoal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textfieldJawabanSoal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboboxStatus = new javax.swing.JComboBox<>();

        buttonSave.setText("Simpan");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSave, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.GridLayout(10, 1));

        jLabel1.setText("Nama Student :");
        jPanel1.add(jLabel1);

        comboboxNamaStudent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(comboboxNamaStudent);

        jLabel2.setText("Nama Soal :");
        jPanel1.add(jLabel2);

        comboboxNamaSoal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(comboboxNamaSoal);

        jLabel3.setText("Nomor Soal :");
        jPanel1.add(jLabel3);
        jPanel1.add(textfieldNomorSoal);

        jLabel4.setText("Jawaban Soal :");
        jPanel1.add(jLabel4);
        jPanel1.add(textfieldJawabanSoal);

        jLabel5.setText("Status :");
        jPanel1.add(jLabel5);

        comboboxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "benar", "salah" }));
        jPanel1.add(comboboxStatus);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed

        if (data == null) {

            // coming data from new entry
            data = new AnswerQuestion();
            obtainFormValues();
            db.insert_answer_question(data);
        } else {
            // coming data from editing mode
            obtainFormValues();
            db.update_answer_question(data);
        }

        mframe.refresh_answerQuestionManagement();

    }//GEN-LAST:event_buttonSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSave;
    private javax.swing.JComboBox<String> comboboxNamaSoal;
    private javax.swing.JComboBox<String> comboboxNamaStudent;
    private javax.swing.JComboBox<String> comboboxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textfieldJawabanSoal;
    private javax.swing.JTextField textfieldNomorSoal;
    // End of variables declaration//GEN-END:variables
}
