package fgroupindonesia.frames.management;

import fgroupindonesia.frames.MainFrame;

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
    }

    MainFrame mframe;

    public void setMainFrameReference(MainFrame mf) {
        mframe = mf;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelConfigSoal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
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

        jPanel2.setLayout(new java.awt.CardLayout());

        panelConfigSoal.setLayout(new java.awt.GridLayout(8, 1));

        jLabel1.setText("Nama Soal : ");
        panelConfigSoal.add(jLabel1);
        panelConfigSoal.add(jTextField1);

        jLabel2.setText("Jumlah Pertanyaan :");
        panelConfigSoal.add(jLabel2);
        panelConfigSoal.add(jSpinner1);

        jLabel3.setText("Kategori : ");
        panelConfigSoal.add(jLabel3);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelConfigSoal.add(jComboBox1);

        jLabel4.setText("Limit Waktu : (Menit)");
        panelConfigSoal.add(jLabel4);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "10", "15", "20", "25", "30" }));
        panelConfigSoal.add(jComboBox2);

        jPanel2.add(panelConfigSoal, "card2");

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
                {"A", null, null},
                {"B", null, null},
                {"C", null, null},
                {"D", null, null}
            },
            new String [] {
                "PG", "Text", "Jawaban"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
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
            tableJawabanPGSoal.getColumnModel().getColumn(0).setMinWidth(40);
            tableJawabanPGSoal.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableJawabanPGSoal.getColumnModel().getColumn(0).setMaxWidth(40);
            tableJawabanPGSoal.getColumnModel().getColumn(2).setMinWidth(55);
            tableJawabanPGSoal.getColumnModel().getColumn(2).setPreferredWidth(55);
            tableJawabanPGSoal.getColumnModel().getColumn(2).setMaxWidth(55);
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

        comboboxModelSoal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Model 1", "Model 2", "Model 3", "Model 4" }));
        jPanel5.add(comboboxModelSoal);

        jPanel4.add(jPanel5);

        panelEditSoal.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(panelEditSoal, "card3");

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        buttonKembali.setText("Kembali <<");
        jPanel1.add(buttonKembali);

        buttonSelanjutnya.setText(">> Selanjutnya");
        jPanel1.add(buttonSelanjutnya);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonKembali;
    private javax.swing.JButton buttonSelanjutnya;
    private javax.swing.JComboBox<String> comboboxModelSoal;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelNomorSoal;
    private javax.swing.JPanel panelConfigSoal;
    private javax.swing.JPanel panelEditSoal;
    private javax.swing.JPanel panelModelSoal;
    private javax.swing.JPanel panelModelSoal1;
    private javax.swing.JPanel panelModelSoal2;
    private javax.swing.JTable tableJawabanPGSoal;
    private javax.swing.JTextArea textareaPertanyaanSoal;
    // End of variables declaration//GEN-END:variables
}
