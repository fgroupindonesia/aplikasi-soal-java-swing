/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fgroupindonesia.frames.management;

import fgroupindonesia.frames.MainFrame;

/**
 *
 * @author asus
 */
public class RewardsFrame extends javax.swing.JInternalFrame {

    /** Creates new form RewardsFrame */
    public RewardsFrame() {
        initComponents();
    }

    MainFrame mframe;
    
    public void setMainFrameReference(MainFrame mf) {
        mframe = mf;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jButton1.setText("Simpan");
        getContentPane().add(jButton1, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.GridLayout(5, 1));

        jLabel1.setText("Nama :");
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);

        jLabel2.setText("Pictures :");
        jPanel1.add(jLabel2);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("-preview-");
        jPanel1.add(jLabel4);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fgroupindonesia/images/edit.png"))); // NOI18N
        jLabel3.setText("browse...");
        jPanel1.add(jLabel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
