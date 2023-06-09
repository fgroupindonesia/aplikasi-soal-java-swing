package fgroupindonesia.frames.client;

import fgroupindonesia.data.Rewards;
import fgroupindonesia.frames.MainFrame;
import fgroupindonesia.helper.DBConnection;
import fgroupindonesia.helper.ImageFitting;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author asus
 */
public class MenuRewardsFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form MenuRewardsFrame
     */
    public MenuRewardsFrame() {
        initComponents();
        openAllAccess(false);

        db = new DBConnection();
        db.connect();

        list = db.select_rewards_all();
        renderData();
    }

    private void prepareImage(int post, String fileName) {
        JLabel label = null;
        if (post == 0) {
            label = labelImbalan_1;
        } else if (post == 1) {
            label = labelImbalan_2;
        } else if (post == 2) {
            label = labelImbalan_3;
        } else if (post == 3) {
            label = labelImbalan_4;
        } else if (post == 4) {
            label = labelImbalan_5;
        } else if (post == 5) {
            label = labelImbalan_6;
        }

       new ImageFitting().fitInto(label, fileName);

    }

    private void renderData() {
        for (int i = 0; i < list.size(); i++) {
            prepareImage(i, list.get(i).getFilename());

            if (i == 0) {
                labelImbalan_1.setText(list.get(i).getNama());
            } else if (i == 1) {
                labelImbalan_2.setText(list.get(i).getNama());
            } else if (i == 2) {
                labelImbalan_3.setText(list.get(i).getNama());
            } else if (i == 3) {
                labelImbalan_4.setText(list.get(i).getNama());
            } else if (i == 4) {
                labelImbalan_5.setText(list.get(i).getNama());
            } else if (i == 5) {
                labelImbalan_6.setText(list.get(i).getNama());
            }
        }
    }

    ArrayList<Rewards> list;
    MainFrame mframe;
    DBConnection db;

    public void setMainFrameReference(MainFrame mf) {
        mframe = mf;
    }

    private void openAllAccess(boolean b) {
        buttonImbalan_1.setEnabled(b);
        buttonImbalan_2.setEnabled(b);
        buttonImbalan_3.setEnabled(b);
        buttonImbalan_4.setEnabled(b);
        buttonImbalan_5.setEnabled(b);
        buttonImbalan_6.setEnabled(b);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImbalan_1 = new javax.swing.JPanel();
        buttonImbalan_1 = new javax.swing.JButton();
        labelImbalan_1 = new javax.swing.JLabel();
        panelImbalan_2 = new javax.swing.JPanel();
        buttonImbalan_2 = new javax.swing.JButton();
        labelImbalan_2 = new javax.swing.JLabel();
        panelImbalan_3 = new javax.swing.JPanel();
        buttonImbalan_3 = new javax.swing.JButton();
        labelImbalan_3 = new javax.swing.JLabel();
        panelImbalan_4 = new javax.swing.JPanel();
        buttonImbalan_4 = new javax.swing.JButton();
        labelImbalan_4 = new javax.swing.JLabel();
        panelImbalan_5 = new javax.swing.JPanel();
        buttonImbalan_5 = new javax.swing.JButton();
        labelImbalan_5 = new javax.swing.JLabel();
        panelImbalan_6 = new javax.swing.JPanel();
        buttonImbalan_6 = new javax.swing.JButton();
        labelImbalan_6 = new javax.swing.JLabel();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(2, 3));

        panelImbalan_1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 15, 20, 15));
        panelImbalan_1.setLayout(new java.awt.BorderLayout());

        buttonImbalan_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fgroupindonesia/images/na.png"))); // NOI18N
        panelImbalan_1.add(buttonImbalan_1, java.awt.BorderLayout.CENTER);

        labelImbalan_1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelImbalan_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImbalan_1.setText("namaImbalan");
        panelImbalan_1.add(labelImbalan_1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(panelImbalan_1);

        panelImbalan_2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 15, 20, 15));
        panelImbalan_2.setLayout(new java.awt.BorderLayout());

        buttonImbalan_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fgroupindonesia/images/na.png"))); // NOI18N
        panelImbalan_2.add(buttonImbalan_2, java.awt.BorderLayout.CENTER);

        labelImbalan_2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelImbalan_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImbalan_2.setText("Tidak Tersedia");
        panelImbalan_2.add(labelImbalan_2, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(panelImbalan_2);

        panelImbalan_3.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 15, 20, 15));
        panelImbalan_3.setLayout(new java.awt.BorderLayout());

        buttonImbalan_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fgroupindonesia/images/na.png"))); // NOI18N
        panelImbalan_3.add(buttonImbalan_3, java.awt.BorderLayout.CENTER);

        labelImbalan_3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelImbalan_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImbalan_3.setText("namaImbalan");
        panelImbalan_3.add(labelImbalan_3, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(panelImbalan_3);

        panelImbalan_4.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 15, 20, 15));
        panelImbalan_4.setLayout(new java.awt.BorderLayout());

        buttonImbalan_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fgroupindonesia/images/na.png"))); // NOI18N
        panelImbalan_4.add(buttonImbalan_4, java.awt.BorderLayout.CENTER);

        labelImbalan_4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelImbalan_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImbalan_4.setText("namaImbalan");
        panelImbalan_4.add(labelImbalan_4, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(panelImbalan_4);

        panelImbalan_5.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 15, 20, 15));
        panelImbalan_5.setLayout(new java.awt.BorderLayout());

        buttonImbalan_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fgroupindonesia/images/na.png"))); // NOI18N
        panelImbalan_5.add(buttonImbalan_5, java.awt.BorderLayout.CENTER);

        labelImbalan_5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelImbalan_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImbalan_5.setText("namaImbalan");
        panelImbalan_5.add(labelImbalan_5, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(panelImbalan_5);

        panelImbalan_6.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 15, 20, 15));
        panelImbalan_6.setLayout(new java.awt.BorderLayout());

        buttonImbalan_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fgroupindonesia/images/na.png"))); // NOI18N
        panelImbalan_6.add(buttonImbalan_6, java.awt.BorderLayout.CENTER);

        labelImbalan_6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelImbalan_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImbalan_6.setText("namaImbalan");
        panelImbalan_6.add(labelImbalan_6, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(panelImbalan_6);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        this.dispose();
        mframe.displayMenuActivity();

    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonImbalan_1;
    private javax.swing.JButton buttonImbalan_2;
    private javax.swing.JButton buttonImbalan_3;
    private javax.swing.JButton buttonImbalan_4;
    private javax.swing.JButton buttonImbalan_5;
    private javax.swing.JButton buttonImbalan_6;
    private javax.swing.JLabel labelImbalan_1;
    private javax.swing.JLabel labelImbalan_2;
    private javax.swing.JLabel labelImbalan_3;
    private javax.swing.JLabel labelImbalan_4;
    private javax.swing.JLabel labelImbalan_5;
    private javax.swing.JLabel labelImbalan_6;
    private javax.swing.JPanel panelImbalan_1;
    private javax.swing.JPanel panelImbalan_2;
    private javax.swing.JPanel panelImbalan_3;
    private javax.swing.JPanel panelImbalan_4;
    private javax.swing.JPanel panelImbalan_5;
    private javax.swing.JPanel panelImbalan_6;
    // End of variables declaration//GEN-END:variables
}
