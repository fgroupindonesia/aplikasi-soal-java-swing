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
import fgroupindonesia.helper.ImageFitting;
import fgroupindonesia.helper.fx.ComboboxHelper;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    
    ComboboxHelper cbx = new ComboboxHelper();
    
    public void setEditMode(int id) {
        data = db.select_rewards_specific(id);
        
        renderPicture(data.getFilename());
        
        if (cbx.isInCombobox(comboboxJenisImbalan, data.getJenis())) {
            comboboxJenisImbalan.setSelectedItem(data.getJenis());
        } else {
            // display the last item
            comboboxJenisImbalan.setSelectedIndex(comboboxJenisImbalan.getItemCount() - 1);
        }
        textfieldNama.setText(data.getNama());
        
    }
    
    private void renderPicture(String filePath) {
        
        if (filePath != null) {
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
        data.setJenis(comboboxJenisImbalan.getSelectedItem().toString());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        buttonSimpan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textfieldNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        labelFilename = new javax.swing.JLabel();
        labelBrowse = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboboxJenisImbalan = new javax.swing.JComboBox<>();

        setTitle("Imbalan");
        setPreferredSize(new java.awt.Dimension(300, 300));

        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSimpan, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.GridLayout(8, 1));

        jLabel1.setText("Nama :");
        jPanel1.add(jLabel1);
        jPanel1.add(textfieldNama);

        jLabel2.setText("Pictures :");
        jPanel1.add(jLabel2);

        labelFilename.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFilename.setText("-preview-");
        jPanel1.add(labelFilename);

        labelBrowse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBrowse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fgroupindonesia/images/edit.png"))); // NOI18N
        labelBrowse.setText("browse...");
        labelBrowse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelBrowse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBrowseMouseClicked(evt);
            }
        });
        jPanel1.add(labelBrowse);

        jLabel3.setText("Jenis :");
        jPanel1.add(jLabel3);

        comboboxJenisImbalan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Internet Akses 60 Menit", "Internet Akses 90 Menit", "Internet Akses 120 Menit", "Internet Akses Unlimited", "lain-lain" }));
        jPanel1.add(comboboxJenisImbalan);

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

    private void labelBrowseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBrowseMouseClicked
        
        jFileChooser1 = new JFileChooser();
        FileFilter imageFilter = new FileNameExtensionFilter(
                "Image files", ImageIO.getReaderFileSuffixes());
        
        jFileChooser1.setFileFilter(imageFilter);
        
        int option = jFileChooser1.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            new ImageFitting().fitInto(labelFilename, file.getAbsolutePath());

            // hide some file information for later usage
            labelFilename.setName(file.getAbsolutePath());
            System.out.println("Nama file na " + labelFilename.getName());
        }

    }//GEN-LAST:event_labelBrowseMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JComboBox<String> comboboxJenisImbalan;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelBrowse;
    private javax.swing.JLabel labelFilename;
    private javax.swing.JTextField textfieldNama;
    // End of variables declaration//GEN-END:variables

}
