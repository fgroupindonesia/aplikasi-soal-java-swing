package fgroupindonesia.frames.management;

import fgroupindonesia.data.AnswerQuestion;
import fgroupindonesia.frames.MainFrame;
import fgroupindonesia.helper.DBConnection;
import fgroupindonesia.helper.TableRenderer;
import java.util.ArrayList;

/**
 *
 * @author fgroupindonesia
 */
public class AnswerQuestionManagementFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form CategoryManagementFrame
     */
    
    DBConnection db;
    ArrayList<AnswerQuestion> list;
    MainFrame mframe;
    
    public void setMainFrameReference(MainFrame mf){
        mframe = mf;
    }
    
    public AnswerQuestionManagementFrame() {
        initComponents();
        db = new DBConnection();
        db.connect();
        list = db.select_answer_question_all();
        new TableRenderer().render_answer_question(tableDataManagement, list);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDataManagement = new javax.swing.JTable();
        labelTotalData = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelAdd = new javax.swing.JLabel();
        labelEdit = new javax.swing.JLabel();
        labelDelete = new javax.swing.JLabel();

        jPanel2.setLayout(new java.awt.BorderLayout());

        tableDataManagement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Id", "Nama Student", "Nama Soal", "Nomor Soal", "Jawaban Soal", "Status", "Tanggal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDataManagement);
        if (tableDataManagement.getColumnModel().getColumnCount() > 0) {
            tableDataManagement.getColumnModel().getColumn(0).setMinWidth(45);
            tableDataManagement.getColumnModel().getColumn(0).setPreferredWidth(45);
            tableDataManagement.getColumnModel().getColumn(0).setMaxWidth(45);
            tableDataManagement.getColumnModel().getColumn(1).setMinWidth(0);
            tableDataManagement.getColumnModel().getColumn(1).setPreferredWidth(0);
            tableDataManagement.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        labelTotalData.setText("Total Data : x");
        jPanel2.add(labelTotalData, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Manejemen Jawaban Soal");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        jPanel1.add(jLabel1);

        labelAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fgroupindonesia/images/add.png"))); // NOI18N
        labelAdd.setText("Tambah");
        labelAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(labelAdd);

        labelEdit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fgroupindonesia/images/edit.png"))); // NOI18N
        labelEdit.setText("Edit");
        labelEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(labelEdit);

        labelDelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fgroupindonesia/images/close.png"))); // NOI18N
        labelDelete.setText("Hapus");
        labelDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(labelDelete);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAdd;
    private javax.swing.JLabel labelDelete;
    private javax.swing.JLabel labelEdit;
    private javax.swing.JLabel labelTotalData;
    private javax.swing.JTable tableDataManagement;
    // End of variables declaration//GEN-END:variables
}
