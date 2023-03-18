package fgroupindonesia.frames.management;

import fgroupindonesia.data.Student;
import fgroupindonesia.frames.MainFrame;
import fgroupindonesia.helper.DBConnection;

/**
 *
 * @author fgroupindonesia
 */
public class StudentFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form CategoryFrame
     */
    public StudentFrame() {
        initComponents();
        db = new DBConnection();
    }

    MainFrame mframe;

    public void setMainFrameReference(MainFrame mf) {
        mframe = mf;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textfieldNamaPelajar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboboxKelas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        textfieldTTL = new javax.swing.JTextField();
        buttonSimpan = new javax.swing.JButton();

        setResizable(true);

        jPanel1.setLayout(new java.awt.GridLayout(6, 1));

        jLabel1.setText("Nama Pelajar : ");
        jPanel1.add(jLabel1);
        jPanel1.add(textfieldNamaPelajar);

        jLabel2.setText("Kelas : ");
        jPanel1.add(jLabel2);

        comboboxKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TK", "SD", "SMP", "SMA", "Mahasiswa" }));
        jPanel1.add(comboboxKelas);

        jLabel3.setText("TTL : ");
        jPanel1.add(jLabel3);
        jPanel1.add(textfieldTTL);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSimpan, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    DBConnection db;
    Student data;

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed

        data = new Student();
        data.setKelas(comboboxKelas.getSelectedItem().toString());
        data.setNama(textfieldNamaPelajar.getText());
        data.setTtl(textfieldTTL.getText());
        
        db.insert_student(data);
        
        mframe.refresh_studentManagement();
        
        this.dispose();
        
        

    }//GEN-LAST:event_buttonSimpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JComboBox<String> comboboxKelas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textfieldNamaPelajar;
    private javax.swing.JTextField textfieldTTL;
    // End of variables declaration//GEN-END:variables
}
