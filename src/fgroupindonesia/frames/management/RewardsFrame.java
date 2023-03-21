/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fgroupindonesia.frames.management;

import fgroupindonesia.data.Rewards;
import fgroupindonesia.data.Student;
import fgroupindonesia.frames.MainFrame;
import fgroupindonesia.helper.DBConnection;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author asus
 */
public class RewardsFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form RewardsFrame
     */
    public RewardsFrame() {
        initComponents();
        db = new DBConnection();
    }

    MainFrame mframe;
    Rewards data;
    DBConnection db;

    public void setMainFrameReference(MainFrame mf) {
        mframe = mf;
    }

    public void setEditMode(int id) {
        data = db.select_rewards_specific(id);

        renderPicture(data.getFilename());
        textfieldNama.setText(data.getNama());

    }

    private void renderPicture(String filePath) {
        
        if(filePath!=null){
        if (new File(filePath).exists()) {
            labelFilename.setText("");
            labelFilename.setIcon(new ImageIcon(filePath));
        } else {
            labelFilename.setText("N/A");

        }
        }
    }

    public void obtainFormValues() {
        data.setFilename(labelFilename.getName());
        data.setNama(textfieldNama.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonSimpan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textfieldNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        labelFilename = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setTitle("Imbalan");

        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSimpan, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.GridLayout(5, 1));

        jLabel1.setText("Nama :");
        jPanel1.add(jLabel1);
        jPanel1.add(textfieldNama);

        jLabel2.setText("Pictures :");
        jPanel1.add(jLabel2);

        labelFilename.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFilename.setText("-preview-");
        jPanel1.add(labelFilename);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fgroupindonesia/images/edit.png"))); // NOI18N
        jLabel3.setText("browse...");
        jPanel1.add(jLabel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed

        if (data == null) {
            // data inserted
            data = new Rewards();
            obtainFormValues();

            db.insert_rewards(data);
        } else {
            // data updated
            obtainFormValues();
            db.update_rewards(data);
        }

        mframe.refresh_rewardsManagement();

        this.dispose();

    }//GEN-LAST:event_buttonSimpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelFilename;
    private javax.swing.JTextField textfieldNama;
    // End of variables declaration//GEN-END:variables

}
