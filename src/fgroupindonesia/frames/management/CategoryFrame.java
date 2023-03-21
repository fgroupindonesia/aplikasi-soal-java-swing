/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fgroupindonesia.frames.management;

import fgroupindonesia.data.Category;
import fgroupindonesia.frames.MainFrame;
import fgroupindonesia.helper.DBConnection;

/**
 *
 * @author asus
 */
public class CategoryFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form CategoryFrame
     */
    public CategoryFrame() {
        initComponents();
        db = new DBConnection();
    }

    DBConnection db;
    Category data;
    MainFrame mframe;

    public void setMainFrameReference(MainFrame mf) {
        mframe = mf;
    }

    public void setEditMode(int id) {
        data = db.select_category_specific(id);

        textfieldCategoryName.setText(data.getNama());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textfieldCategoryName = new javax.swing.JTextField();

        setTitle("Kategori");

        buttonSave.setText("Simpan");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSave, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setText("Nama Kategori : ");
        jPanel1.add(jLabel1);
        jPanel1.add(textfieldCategoryName);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed

        if (data != null) {
            // coming from editing mode
            obtainFormValues();

            db.update_category(data);
        } else {
            // coming from new data
            data = new Category();
            obtainFormValues();

            db.insert_category(data);
        }

        mframe.refresh_categoryManagement();
        this.dispose();
        
    }//GEN-LAST:event_buttonSaveActionPerformed

    public void obtainFormValues() {
        data.setNama(textfieldCategoryName.getText());
        data.setTanggal(DBConnection.getDateNow());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textfieldCategoryName;
    // End of variables declaration//GEN-END:variables
}
