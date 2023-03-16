/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fgroupindonesia.frames;

import fgroupindonesia.data.User;
import fgroupindonesia.helper.fx.Highlight;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;

/**
 *
 * @author asus
 */
public class LoginFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form LoginFrame
     */
    MainFrame mainFrame = null;
    CardLayout cardLayout;
    Container container = null;

    public void setMainFrameReference(MainFrame mf) {
        mainFrame = mf;

    }

    public LoginFrame() {
        initComponents();
        applySizeShown();

        container = this.getContentPane();
        cardLayout = (CardLayout) container.getLayout();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUserType = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        kidsLabel = new javax.swing.JLabel();
        parentsLabel = new javax.swing.JLabel();
        panelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usernameTextfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordTextfield = new javax.swing.JPasswordField();
        buttonLogin = new javax.swing.JButton();
        panelKidsDetail = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        kidsNameTextfield = new javax.swing.JTextField();

        getContentPane().setLayout(new java.awt.CardLayout());

        panelUserType.setLayout(new java.awt.GridLayout(3, 1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Login Sebagai...");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelUserType.add(jLabel3);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        kidsLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        kidsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kidsLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fgroupindonesia/images/user.png"))); // NOI18N
        kidsLabel.setText("Anak");
        kidsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kidsLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kidsLabel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        kidsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kidsLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kidsLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                kidsLabelMouseExited(evt);
            }
        });
        jPanel1.add(kidsLabel);

        parentsLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        parentsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        parentsLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fgroupindonesia/images/group.png"))); // NOI18N
        parentsLabel.setText("Orang Tua");
        parentsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        parentsLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        parentsLabel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        parentsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parentsLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                parentsLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                parentsLabelMouseExited(evt);
            }
        });
        jPanel1.add(parentsLabel);

        panelUserType.add(jPanel1);

        getContentPane().add(panelUserType, "login as");

        panelLogin.setLayout(new java.awt.GridLayout(5, 1));

        jLabel1.setText("Username : ");
        panelLogin.add(jLabel1);
        panelLogin.add(usernameTextfield);

        jLabel2.setText("Password : ");
        panelLogin.add(jLabel2);

        passwordTextfield.setText("jPasswordField1");
        panelLogin.add(passwordTextfield);

        buttonLogin.setText("Login");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        panelLogin.add(buttonLogin);

        getContentPane().add(panelLogin, "login form");

        panelKidsDetail.setLayout(new java.awt.GridLayout(3, 1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ketik nama kamu disini...");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelKidsDetail.add(jLabel4);

        kidsNameTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kidsNameTextfieldActionPerformed(evt);
            }
        });
        panelKidsDetail.add(kidsNameTextfield);

        getContentPane().add(panelKidsDetail, "kids detail");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kidsLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kidsLabelMouseEntered
        Highlight.onFocus(kidsLabel);
    }//GEN-LAST:event_kidsLabelMouseEntered

    private void kidsLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kidsLabelMouseExited
        Highlight.onLost(kidsLabel);
    }//GEN-LAST:event_kidsLabelMouseExited

    private void parentsLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parentsLabelMouseEntered
        Highlight.onFocus(parentsLabel);
    }//GEN-LAST:event_parentsLabelMouseEntered

    private void parentsLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parentsLabelMouseExited
        Highlight.onLost(kidsLabel);
    }//GEN-LAST:event_parentsLabelMouseExited

    private void kidsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kidsLabelMouseClicked
        cardLayout.show(container, "kids detail");
    }//GEN-LAST:event_kidsLabelMouseClicked

    private void parentsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parentsLabelMouseClicked

        cardLayout.show(container, "login form");
    }//GEN-LAST:event_parentsLabelMouseClicked

    private void kidsNameTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kidsNameTextfieldActionPerformed

        setAccess(kidsNameTextfield.getText(), User.Type.kids);

    }//GEN-LAST:event_kidsNameTextfieldActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed

        setAccess(usernameTextfield.getText(), User.Type.parents);

    }//GEN-LAST:event_buttonLoginActionPerformed

    private void setAccess(String us, User.Type jenis) {
        mainFrame.setAccess(us, jenis);
    }

    int w = 300, h = 250;

    private void applySizeShown() {
        setPreferredSize(new Dimension(w, h));
        setMaximumSize(new Dimension(w, h));
        setMinimumSize(new Dimension(w, h));
        setMaximizable(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel kidsLabel;
    private javax.swing.JTextField kidsNameTextfield;
    private javax.swing.JPanel panelKidsDetail;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelUserType;
    private javax.swing.JLabel parentsLabel;
    private javax.swing.JPasswordField passwordTextfield;
    private javax.swing.JTextField usernameTextfield;
    // End of variables declaration//GEN-END:variables
}
