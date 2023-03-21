package fgroupindonesia.frames;

import fgroupindonesia.data.History;
import fgroupindonesia.data.User;
import fgroupindonesia.frames.management.AnswerQuestionFrame;
import fgroupindonesia.frames.management.AnswerQuestionManagementFrame;
import fgroupindonesia.frames.management.CategoryFrame;
import fgroupindonesia.frames.management.CategoryManagementFrame;
import fgroupindonesia.frames.management.QuestionFrame;
import fgroupindonesia.frames.management.QuestionManagementFrame;
import fgroupindonesia.frames.management.RewardsFrame;
import fgroupindonesia.frames.management.RewardsManagementFrame;
import fgroupindonesia.frames.management.StudentFrame;
import fgroupindonesia.frames.management.StudentManagementFrame;
import fgroupindonesia.helper.CustomJDesktopPane;
import fgroupindonesia.helper.DBConnection;

import fgroupindonesia.helper.SystemPath;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author asus
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    JDesktopPane desktop;
    User.Type akses;
    User dataUser;
    History dataHistory;
    DBConnection db;
    BufferedImage myBackground;

    private void openMenuAccess(boolean b) {
        aktifitasMenu.setEnabled(b);

        if (akses != User.Type.kids) {
            managementMenu.setEnabled(b);
        }
    }

    public void setAccess(String nama, User.Type jenis) {
        dataUser = new User();
        dataUser.setUsername(nama);

        akses = jenis;
        dataHistory = new History(nama, jenis);
        dataHistory.setDescription("login");

        loginMenu.setText("Logout dari (" + jenis + ")");

        db.insert_history(dataHistory);
        openMenuAccess(true);
    }

    private void updateImageIcon() {
        this.setIconImage(new ImageIcon(SystemPath.getCompletePath("logo.png")).getImage());
    }

    public MainFrame() {
        initComponents();
        updateImageIcon();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultLookAndFeelDecorated(true);

        // first time
        db = new DBConnection();
        openMenuAccess(false);

        //desktop = new JDesktopPane();
        try {
            myBackground = ImageIO.read(new File(SystemPath.getCompletePath("background.jpg")));
            desktop = new CustomJDesktopPane(myBackground);

        } catch (Exception ex) {
            desktop = new JDesktopPane();
        }

        setContentPane(desktop);
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loginMenu = new javax.swing.JMenuItem();
        updateLanguageMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenu = new javax.swing.JMenuItem();
        aktifitasMenu = new javax.swing.JMenu();
        historyMenu = new javax.swing.JMenuItem();
        checkRewardsMenu = new javax.swing.JMenuItem();
        startQuestionMenu = new javax.swing.JMenuItem();
        requestAdditionalQuestionMenu = new javax.swing.JMenuItem();
        managementMenu = new javax.swing.JMenu();
        categoryManagementMenu = new javax.swing.JMenuItem();
        questionManagementMenu = new javax.swing.JMenuItem();
        answerQuestionManagementMenu = new javax.swing.JMenuItem();
        studentManagementMenu = new javax.swing.JMenuItem();
        rewardsManagementMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Aplikasi Soal Home Schooling");
        setResizable(false);

        fileMenu.setMnemonic('F');
        fileMenu.setText("File");

        loginMenu.setMnemonic('L');
        loginMenu.setText("Login");
        loginMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginMenuActionPerformed(evt);
            }
        });
        fileMenu.add(loginMenu);

        updateLanguageMenu.setMnemonic('U');
        updateLanguageMenu.setText("Update Bahasa");
        updateLanguageMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateLanguageMenuActionPerformed(evt);
            }
        });
        fileMenu.add(updateLanguageMenu);
        fileMenu.add(jSeparator1);

        exitMenu.setMnemonic('E');
        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenu);

        jMenuBar1.add(fileMenu);

        aktifitasMenu.setMnemonic('A');
        aktifitasMenu.setText("Aktifitas");

        historyMenu.setMnemonic('H');
        historyMenu.setText("Check Riwayat");
        historyMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyMenuActionPerformed(evt);
            }
        });
        aktifitasMenu.add(historyMenu);

        checkRewardsMenu.setText("Melihat Imbalan");
        aktifitasMenu.add(checkRewardsMenu);

        startQuestionMenu.setText("Mulai Mengerjakan Soal");
        aktifitasMenu.add(startQuestionMenu);

        requestAdditionalQuestionMenu.setText("Minta Soal Tambahan");
        aktifitasMenu.add(requestAdditionalQuestionMenu);

        jMenuBar1.add(aktifitasMenu);

        managementMenu.setMnemonic('M');
        managementMenu.setText("Manajemen");

        categoryManagementMenu.setMnemonic('K');
        categoryManagementMenu.setText("Kategori");
        categoryManagementMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryManagementMenuActionPerformed(evt);
            }
        });
        managementMenu.add(categoryManagementMenu);

        questionManagementMenu.setMnemonic('S');
        questionManagementMenu.setText("Soal");
        questionManagementMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionManagementMenuActionPerformed(evt);
            }
        });
        managementMenu.add(questionManagementMenu);

        answerQuestionManagementMenu.setMnemonic('J');
        answerQuestionManagementMenu.setText("Jawaban");
        answerQuestionManagementMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerQuestionManagementMenuActionPerformed(evt);
            }
        });
        managementMenu.add(answerQuestionManagementMenu);

        studentManagementMenu.setMnemonic('S');
        studentManagementMenu.setText("Siswa");
        studentManagementMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentManagementMenuActionPerformed(evt);
            }
        });
        managementMenu.add(studentManagementMenu);

        rewardsManagementMenu.setMnemonic('I');
        rewardsManagementMenu.setText("Imbalan");
        rewardsManagementMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rewardsManagementMenuActionPerformed(evt);
            }
        });
        managementMenu.add(rewardsManagementMenu);

        jMenuBar1.add(managementMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginMenuActionPerformed

        if (loginMenu.getText().contains("Login")) {
            LoginFrame frame = new LoginFrame();
            deployDesktop(frame);
            frame.setMainFrameReference(this);

        } else {
            logout();
        }


    }//GEN-LAST:event_loginMenuActionPerformed

    private void categoryManagementMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryManagementMenuActionPerformed
        displayManagementCategory();
    }//GEN-LAST:event_categoryManagementMenuActionPerformed

    private void questionManagementMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionManagementMenuActionPerformed
        displayManagementQuestion();
    }//GEN-LAST:event_questionManagementMenuActionPerformed

    private void answerQuestionManagementMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerQuestionManagementMenuActionPerformed
        displayManagementAnswerQuestion();
    }//GEN-LAST:event_answerQuestionManagementMenuActionPerformed

    private void updateLanguageMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateLanguageMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateLanguageMenuActionPerformed

    private void historyMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyMenuActionPerformed
        displayHistory();
    }//GEN-LAST:event_historyMenuActionPerformed

    private void studentManagementMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentManagementMenuActionPerformed
        displayManagementStudent();
    }//GEN-LAST:event_studentManagementMenuActionPerformed

    private void rewardsManagementMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rewardsManagementMenuActionPerformed
        displayManagementRewards();
    }//GEN-LAST:event_rewardsManagementMenuActionPerformed

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed

        System.exit(0);

    }//GEN-LAST:event_exitMenuActionPerformed

    public void displayHistory() {
        HistoryFrame frame = new HistoryFrame();
        deployDesktop(frame);
        frame.setMainFrameReference(this);
    }

    StudentManagementFrame stm_frame;
    RewardsManagementFrame rtm_frame;
    QuestionManagementFrame qm_frame;
    CategoryManagementFrame ctm_frame;
    AnswerQuestionManagementFrame aqm_frame;

    public void displayManagementStudent() {
        stm_frame = new StudentManagementFrame();
        deployDesktop(stm_frame);
        stm_frame.setMainFrameReference(this);
    }

    public void displayManagementRewards() {
        rtm_frame = new RewardsManagementFrame();
        deployDesktop(rtm_frame);
        rtm_frame.setMainFrameReference(this);
    }

    public void displayManagementCategory() {
        ctm_frame = new CategoryManagementFrame();
        deployDesktop(ctm_frame);
        ctm_frame.setMainFrameReference(this);
    }

    public void displayManagementAnswerQuestion() {
        aqm_frame = new AnswerQuestionManagementFrame();
        deployDesktop(aqm_frame);
        aqm_frame.setMainFrameReference(this);
    }

    public void displayManagementQuestion() {
        qm_frame = new QuestionManagementFrame();
        deployDesktop(qm_frame);
        qm_frame.setMainFrameReference(this);
    }

    public void displayStudentForm() {
        StudentFrame frame = new StudentFrame();
        deployDesktop(frame);
        frame.setMainFrameReference(this);
    }

    public void displayCategoryForm(int id) {
        CategoryFrame frame = new CategoryFrame();
        frame.setEditMode(id);
        deployDesktop(frame);
        frame.setMainFrameReference(this);
    }

    public void displayAnswerQuestionForm(int id) {
        AnswerQuestionFrame frame = new AnswerQuestionFrame();
        frame.setEditMode(id);
        deployDesktop(frame);
        frame.setMainFrameReference(this);
    }

    public void displayQuestionForm(int id) {
        QuestionFrame frame = new QuestionFrame();
        frame.setEditMode(id);
        deployDesktop(frame);
        frame.setMainFrameReference(this);
    }

    public void displayStudentForm(int id) {
        StudentFrame frame = new StudentFrame();
        frame.setEditMode(id);
        deployDesktop(frame);
        frame.setMainFrameReference(this);
    }

    public void displayRewardsForm(int id) {
        RewardsFrame frame = new RewardsFrame();
        frame.setEditMode(id);
        deployDesktop(frame);
        frame.setMainFrameReference(this);
    }

    public void displayRewardsForm() {
        RewardsFrame frame = new RewardsFrame();
        deployDesktop(frame);
        frame.setMainFrameReference(this);
    }

    public void displayQuestionForm() {
        QuestionFrame frame = new QuestionFrame();
        deployDesktop(frame);
        frame.setMainFrameReference(this);
    }

    public void displayCategoryForm() {
        CategoryFrame frame = new CategoryFrame();
        deployDesktop(frame);
        frame.setMainFrameReference(this);
    }

    public void displayAnswerQuestionForm() {
        AnswerQuestionFrame frame = new AnswerQuestionFrame();
        deployDesktop(frame);
        frame.setMainFrameReference(this);
    }

    public void displayMenuManagement() {
        MenuManagementFrame frame = new MenuManagementFrame();
        deployDesktop(frame);
        frame.setMainFrameReference(this);
    }

    public void displayMenuActivity() {
        MenuActivityFrame frame = new MenuActivityFrame();
        deployDesktop(frame);
        frame.setMainFrameReference(this);
    }

    private void deployDesktop(JInternalFrame frame) {
        frame.setVisible(true);
        frame.setClosable(true);
        frame.setMaximizable(false);

        setCenterInternal(frame);

        desktop.add(frame);

        try {
            frame.setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error " + e.getMessage());
        }
    }

    public void refresh_studentManagement() {
        stm_frame.refresh();
    }

    public void refresh_categoryManagement() {
        ctm_frame.refresh();
    }

    public void refresh_questionManagement() {
        qm_frame.refresh();
    }

    public void refresh_answerQuestionManagement() {
        aqm_frame.refresh();
    }

    public void refresh_rewardsManagement() {
        rtm_frame.refresh();
    }

    private void setCenterInternal(JInternalFrame frame) {
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    public void logout() {
        loginMenu.setText("Login");

        dataHistory.setDescription("logout");
        db.insert_history(dataHistory);
        openMenuAccess(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aktifitasMenu;
    private javax.swing.JMenuItem answerQuestionManagementMenu;
    private javax.swing.JMenuItem categoryManagementMenu;
    private javax.swing.JMenuItem checkRewardsMenu;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem historyMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem loginMenu;
    private javax.swing.JMenu managementMenu;
    private javax.swing.JMenuItem questionManagementMenu;
    private javax.swing.JMenuItem requestAdditionalQuestionMenu;
    private javax.swing.JMenuItem rewardsManagementMenu;
    private javax.swing.JMenuItem startQuestionMenu;
    private javax.swing.JMenuItem studentManagementMenu;
    private javax.swing.JMenuItem updateLanguageMenu;
    // End of variables declaration//GEN-END:variables
}
