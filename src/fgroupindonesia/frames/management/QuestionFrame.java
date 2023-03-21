package fgroupindonesia.frames.management;

import com.google.gson.Gson;
import fgroupindonesia.data.Category;
import fgroupindonesia.data.NavigasiQuestion;
import fgroupindonesia.data.Question;
import fgroupindonesia.data.QuestionSub;
import fgroupindonesia.frames.MainFrame;
import fgroupindonesia.helper.DBConnection;
import fgroupindonesia.helper.TableRenderer;
import java.awt.CardLayout;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class QuestionFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form CategoryFrame
     */
    public QuestionFrame() {
        initComponents();
        db = new DBConnection();
        renderKategori();
        tableRender = new TableRenderer();
        card = (CardLayout) panelCanvas.getLayout();
    }

    private void renderKategori() {
        ArrayList<Category> data = db.select_category_all();
        comboboxKategori.removeAll();
        for (Category ct : data) {
            comboboxKategori.addItem(ct.getNama());
        }
    }

    CardLayout card;
    MainFrame mframe;
    Question data;
    DBConnection db;
    String isiSoal; // this will be json format
    TableRenderer tableRender;

    public void setMainFrameReference(MainFrame mf) {
        mframe = mf;
    }

    public void setEditMode(int id) {
        data = db.select_question_specific(id);

        textfieldNamaSoal.setText(data.getNama());
        spinnerJumlahPertanyaan.setValue(data.getJumlah_pertanyaan());
        comboboxKategori.setSelectedItem(data.getKategori());
        comboboxLimitWaktu.setSelectedItem(data.getLimit_waktu());
    }

    public void obtainFormValues() {

        data.setJumlah_pertanyaan((Integer) spinnerJumlahPertanyaan.getValue());
        data.setNama(textfieldNamaSoal.getText());
        data.setKategori(comboboxKategori.getSelectedItem().toString());
        data.setLimit_waktu((Integer) comboboxLimitWaktu.getSelectedItem());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCanvas = new javax.swing.JPanel();
        panelConfigSoal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textfieldNamaSoal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        spinnerJumlahPertanyaan = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        comboboxKategori = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboboxLimitWaktu = new javax.swing.JComboBox<>();
        panelEditSoal = new javax.swing.JPanel();
        panelModelSoal = new javax.swing.JPanel();
        panelModelSoal1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textareaPertanyaanSoal = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableJawabanPGSoal = new javax.swing.JTable();
        panelModelSoal2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        labelNomorSoal = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboboxModelSoal = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        buttonKembali = new javax.swing.JButton();
        buttonSelanjutnya = new javax.swing.JButton();

        setTitle("Soal ");

        panelCanvas.setLayout(new java.awt.CardLayout());

        panelConfigSoal.setLayout(new java.awt.GridLayout(8, 1));

        jLabel1.setText("Nama Soal : ");
        panelConfigSoal.add(jLabel1);
        panelConfigSoal.add(textfieldNamaSoal);

        jLabel2.setText("Jumlah Pertanyaan :");
        panelConfigSoal.add(jLabel2);
        panelConfigSoal.add(spinnerJumlahPertanyaan);

        jLabel3.setText("Kategori : ");
        panelConfigSoal.add(jLabel3);

        panelConfigSoal.add(comboboxKategori);

        jLabel4.setText("Limit Waktu : (Menit)");
        panelConfigSoal.add(jLabel4);

        comboboxLimitWaktu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "10", "15", "20", "25", "30" }));
        panelConfigSoal.add(comboboxLimitWaktu);

        panelCanvas.add(panelConfigSoal, "config_soal");

        panelEditSoal.setLayout(new java.awt.BorderLayout());

        panelModelSoal.setLayout(new java.awt.CardLayout());

        panelModelSoal1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Text Soal"));

        textareaPertanyaanSoal.setColumns(20);
        textareaPertanyaanSoal.setRows(5);
        jScrollPane1.setViewportView(textareaPertanyaanSoal);

        panelModelSoal1.add(jScrollPane1, java.awt.BorderLayout.PAGE_START);

        tableJawabanPGSoal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "A", null},
                {null, "B", null},
                {null, "C", null},
                {null, "D", null}
            },
            new String [] {
                "Jawaban", "PG", "Text"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableJawabanPGSoal);
        if (tableJawabanPGSoal.getColumnModel().getColumnCount() > 0) {
            tableJawabanPGSoal.getColumnModel().getColumn(0).setMinWidth(55);
            tableJawabanPGSoal.getColumnModel().getColumn(0).setPreferredWidth(55);
            tableJawabanPGSoal.getColumnModel().getColumn(0).setMaxWidth(55);
            tableJawabanPGSoal.getColumnModel().getColumn(1).setMinWidth(40);
            tableJawabanPGSoal.getColumnModel().getColumn(1).setPreferredWidth(40);
            tableJawabanPGSoal.getColumnModel().getColumn(1).setMaxWidth(40);
        }

        panelModelSoal1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        panelModelSoal.add(panelModelSoal1, "card2");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Soal Model 2 ---- not implemented yet ----");
        panelModelSoal2.add(jLabel6);

        panelModelSoal.add(panelModelSoal2, "card3");

        panelEditSoal.add(panelModelSoal, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(10, 40));
        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        labelNomorSoal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelNomorSoal.setText("Nomor : 1 dari x Soal.");
        jPanel6.add(labelNomorSoal);

        jPanel4.add(jPanel6);

        jLabel5.setText("Model Soal : ");
        jPanel5.add(jLabel5);

        comboboxModelSoal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Model 1" }));
        jPanel5.add(comboboxModelSoal);

        jPanel4.add(jPanel5);

        panelEditSoal.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        panelCanvas.add(panelEditSoal, "edit_soal");

        getContentPane().add(panelCanvas, java.awt.BorderLayout.CENTER);

        buttonKembali.setText("Kembali <<");
        jPanel1.add(buttonKembali);

        buttonSelanjutnya.setText(">> Selanjutnya");
        buttonSelanjutnya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSelanjutnyaActionPerformed(evt);
            }
        });
        jPanel1.add(buttonSelanjutnya);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSelanjutnyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSelanjutnyaActionPerformed

        if (data != null) {
            // coming from editing mode
            renderQuestionData();
        } else if (NavigasiQuestion.current_index == NavigasiQuestion.CONFIG_SOAL) {
            // coming from new data

            card.show(panelCanvas, "edit_soal");
            buttonKembali.setEnabled(true);
            buttonSelanjutnya.setEnabled(true);
            
            // prepare empty array with the following numbers
            allqsub = new QuestionSub[(Integer)spinnerJumlahPertanyaan.getValue()];
            prepareUI();
            
        } else if (NavigasiQuestion.current_index == NavigasiQuestion.EDIT_SOAL) {

            proceedNextQuestion();
        }

    }//GEN-LAST:event_buttonSelanjutnyaActionPerformed

    int nomorSaatIni, totalSoal;
    int col_location, col_target;
    QuestionSub [] allqsub;

    private void saveJSONData() {

        col_location = 1;
        col_target = 2;
        
        // extracting from the GUI to json
        QuestionSub qsub = new QuestionSub();
        qsub.setNumber(nomorSaatIni);
        qsub.setCorrect_answer(tableRender.getCheckedDataAsText(tableJawabanPGSoal, 1));
        qsub.setQuestion_text(textareaPertanyaanSoal.getText());
        qsub.setOps_a(tableRender.getValueAt(tableJawabanPGSoal, col_target, col_location, "A"));
        qsub.setOps_b(tableRender.getValueAt(tableJawabanPGSoal, col_target, col_location, "B"));
        qsub.setOps_c(tableRender.getValueAt(tableJawabanPGSoal, col_target, col_location, "C"));
        qsub.setOps_d(tableRender.getValueAt(tableJawabanPGSoal, col_target, col_location, "D"));

        allqsub[nomorSaatIni-1] = qsub;
        
        //new Gson().toJson(qsub);
    }

    private void proceedNextQuestion() {

        // save into json
        saveJSONData();

        // is this in the last question?
        prepareUI();
    }
    
    private void prepareUI(){
        nomorSaatIni++;
        textareaPertanyaanSoal.setText("");
        labelNomorSoal.setText("Nomor " + nomorSaatIni + " dari " + totalSoal + " Soal.");
        tableRender.prepareEmptyQuestionData(tableJawabanPGSoal);

    }

    private void renderQuestionData() {
        data.getIsi_soal();
        Gson dataGson = new Gson();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonKembali;
    private javax.swing.JButton buttonSelanjutnya;
    private javax.swing.JComboBox<String> comboboxKategori;
    private javax.swing.JComboBox<String> comboboxLimitWaktu;
    private javax.swing.JComboBox<String> comboboxModelSoal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelNomorSoal;
    private javax.swing.JPanel panelCanvas;
    private javax.swing.JPanel panelConfigSoal;
    private javax.swing.JPanel panelEditSoal;
    private javax.swing.JPanel panelModelSoal;
    private javax.swing.JPanel panelModelSoal1;
    private javax.swing.JPanel panelModelSoal2;
    private javax.swing.JSpinner spinnerJumlahPertanyaan;
    private javax.swing.JTable tableJawabanPGSoal;
    private javax.swing.JTextArea textareaPertanyaanSoal;
    private javax.swing.JTextField textfieldNamaSoal;
    // End of variables declaration//GEN-END:variables
}
