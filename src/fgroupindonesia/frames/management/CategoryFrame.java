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
public class CategoryFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form CategoryFrame
     */
    public CategoryFrame() {
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

        jButton1.setText("Simpan");
        getContentPane().add(jButton1, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setText("Nama Kategori : ");
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
