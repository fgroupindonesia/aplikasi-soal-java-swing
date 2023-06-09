package fgroupindonesia.frames.client;

import fgroupindonesia.data.AnswerQuestion;
import fgroupindonesia.data.Question;
import fgroupindonesia.data.User;
import fgroupindonesia.frames.MainFrame;
import fgroupindonesia.helper.DBConnection;
import fgroupindonesia.helper.QJSONHelper;
import fgroupindonesia.helper.fx.TickTimer;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class StudentQuestionFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form QuestionFrame
     */
    public StudentQuestionFrame() {
        initComponents();
    }

    TickTimer counter;
    MainFrame mframe;
    int jumlahMenit;
    DBConnection db;
    String kategori;
    String isiSoal;
    Question questionTerpilih;
    ArrayList<Question> allQuestion;
    ArrayList<AnswerQuestion> allAnswerQuestion;

    public void setMainFrameReference(MainFrame mf) {
        mframe = mf;
    }

    public void startFor(User dataUserna) {
        JOptionPane.showMessageDialog(null, "Soal ini terbatas hanya " + jumlahMenit);

        db = new DBConnection();

        kategori = db.select_student_specific(dataUserna.getUsername()).getKelas();
        allQuestion = db.select_question_specific(kategori);

        System.out.println("Ada beberapa " + allQuestion.size() + " soal untuk " + kategori);

        if (allQuestion.size() != 0) {
            // another check
            // is this student already asked by that question?
            for (Question q : allQuestion) {
                allAnswerQuestion = db.select_answer_question_specific(q.getNama(), dataUserna.getUsername());

                //System.out.println("Jawaban dia " + allAnswerQuestion.size());
                if (allAnswerQuestion.size() == 0) {
                    questionTerpilih = q;
                    break;
                }

            }

            //System.out.println("yg ada soal " + questionTerpilih.getNama());
            // render soal for this question
            renderSoal(questionTerpilih);

        } else {
            // when the question is not available yet
            JOptionPane.showMessageDialog(null, "Pertanyaan untuk siswa " + dataUserna.getUsername() + " [" + kategori + "]" + " saat ini belum tersedia!");
            this.dispose();
        }
    }

    QJSONHelper qjson = new QJSONHelper();
    
    
    private void nextQuestion(){
        qjson.next();
        
    }
    
    private void prepareJSONHelper(){
        qjson.setData(isiSoal);
        
        qjson.setTextarea(textAreaQuestion);
        qjson.setJr1(radioButtonSoalMode1_PG_A1);
        qjson.setJr2(radioButtonSoalMode1_PG_B1);
        qjson.setJr3(radioButtonSoalMode1_PG_C1);
        qjson.setJr4(radioButtonSoalMode1_PG_D1);
        qjson.setQuestionNumberLabel(labelNomorSoal);
    
        qjson.renderAll();
    }
    
    private void renderSoal(Question pertanyaan) {

        // this is json format
        isiSoal = pertanyaan.getIsi_soal();
        
        prepareJSONHelper();
        
        labelTotalSoal.setText("Total Soal : " + pertanyaan.getJumlah_pertanyaan());
        
        System.out.println("isi soalna " + isiSoal);

        buttonSoalSebelumnya.setVisible(false);
        buttonSoalSelanjutnya.setVisible(true);

        counter = new TickTimer();
        counter.setStudentQuestionFrameRef(this);
        counter.setPrefix("Waktu Tersisa ");
        counter.setTimeLimit(pertanyaan.getLimit_waktu());
        counter.setLabel(labelWaktuTersisa);
        counter.start();

    }

    public void warning() {
        JOptionPane.showMessageDialog(null, "waktu habis!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupPilihanGandaSoalMode_1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        buttonSoalSebelumnya = new javax.swing.JButton();
        buttonSoalSelanjutnya = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        labelWaktuTersisa = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelSoal = new javax.swing.JPanel();
        panelSoalMode1_PGText = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaQuestion = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        radioButtonSoalMode1_PG_A1 = new javax.swing.JRadioButton();
        radioButtonSoalMode1_PG_B1 = new javax.swing.JRadioButton();
        radioButtonSoalMode1_PG_C1 = new javax.swing.JRadioButton();
        radioButtonSoalMode1_PG_D1 = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelSoalText_PGGambar = new javax.swing.JPanel();
        panelSoalText_Essay = new javax.swing.JPanel();
        panelSoalVideo_PGText = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        labelNomorSoal = new javax.swing.JLabel();
        labelTotalSoal = new javax.swing.JLabel();

        setTitle("Mulai Mengerjakan Soal");
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

        jPanel1.setPreferredSize(new java.awt.Dimension(394, 50));

        buttonSoalSebelumnya.setText("Sebelumnya <<");
        jPanel1.add(buttonSoalSebelumnya);

        buttonSoalSelanjutnya.setText(">> Selanjutnya");
        buttonSoalSelanjutnya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSoalSelanjutnyaActionPerformed(evt);
            }
        });
        jPanel1.add(buttonSoalSelanjutnya);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        labelWaktuTersisa.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        labelWaktuTersisa.setText("Waktu Tersisa 00:00");
        jPanel3.add(labelWaktuTersisa);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        panelSoal.setPreferredSize(new java.awt.Dimension(394, 200));
        panelSoal.setLayout(new java.awt.CardLayout());

        panelSoalMode1_PGText.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(123, 100));

        textAreaQuestion.setBackground(java.awt.SystemColor.control);
        textAreaQuestion.setColumns(20);
        textAreaQuestion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textAreaQuestion.setLineWrap(true);
        textAreaQuestion.setRows(5);
        textAreaQuestion.setWrapStyleWord(true);
        textAreaQuestion.setAutoscrolls(false);
        jScrollPane1.setViewportView(textAreaQuestion);

        panelSoalMode1_PGText.add(jScrollPane1, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Pilihan Ganda"));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new java.awt.GridLayout(4, 1));

        buttonGroupPilihanGandaSoalMode_1.add(radioButtonSoalMode1_PG_A1);
        radioButtonSoalMode1_PG_A1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        radioButtonSoalMode1_PG_A1.setText("Pilihan A");
        jPanel8.add(radioButtonSoalMode1_PG_A1);

        buttonGroupPilihanGandaSoalMode_1.add(radioButtonSoalMode1_PG_B1);
        radioButtonSoalMode1_PG_B1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        radioButtonSoalMode1_PG_B1.setText("Pilihan B");
        jPanel8.add(radioButtonSoalMode1_PG_B1);

        buttonGroupPilihanGandaSoalMode_1.add(radioButtonSoalMode1_PG_C1);
        radioButtonSoalMode1_PG_C1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        radioButtonSoalMode1_PG_C1.setText("Pilihan C");
        jPanel8.add(radioButtonSoalMode1_PG_C1);

        buttonGroupPilihanGandaSoalMode_1.add(radioButtonSoalMode1_PG_D1);
        radioButtonSoalMode1_PG_D1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        radioButtonSoalMode1_PG_D1.setText("Pilihan D");
        jPanel8.add(radioButtonSoalMode1_PG_D1);

        jPanel5.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel6.setPreferredSize(new java.awt.Dimension(50, 100));
        jPanel6.setLayout(new java.awt.GridLayout(4, 1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("A.");
        jPanel6.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("B.");
        jPanel6.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("C.");
        jPanel6.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("D.");
        jPanel6.add(jLabel4);

        jPanel5.add(jPanel6, java.awt.BorderLayout.WEST);

        panelSoalMode1_PGText.add(jPanel5, java.awt.BorderLayout.CENTER);

        panelSoal.add(panelSoalMode1_PGText, "card2");

        javax.swing.GroupLayout panelSoalText_PGGambarLayout = new javax.swing.GroupLayout(panelSoalText_PGGambar);
        panelSoalText_PGGambar.setLayout(panelSoalText_PGGambarLayout);
        panelSoalText_PGGambarLayout.setHorizontalGroup(
            panelSoalText_PGGambarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        panelSoalText_PGGambarLayout.setVerticalGroup(
            panelSoalText_PGGambarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        panelSoal.add(panelSoalText_PGGambar, "card3");

        javax.swing.GroupLayout panelSoalText_EssayLayout = new javax.swing.GroupLayout(panelSoalText_Essay);
        panelSoalText_Essay.setLayout(panelSoalText_EssayLayout);
        panelSoalText_EssayLayout.setHorizontalGroup(
            panelSoalText_EssayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        panelSoalText_EssayLayout.setVerticalGroup(
            panelSoalText_EssayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        panelSoal.add(panelSoalText_Essay, "card4");

        javax.swing.GroupLayout panelSoalVideo_PGTextLayout = new javax.swing.GroupLayout(panelSoalVideo_PGText);
        panelSoalVideo_PGText.setLayout(panelSoalVideo_PGTextLayout);
        panelSoalVideo_PGTextLayout.setHorizontalGroup(
            panelSoalVideo_PGTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        panelSoalVideo_PGTextLayout.setVerticalGroup(
            panelSoalVideo_PGTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        panelSoal.add(panelSoalVideo_PGText, "card5");

        jPanel2.add(panelSoal, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        labelNomorSoal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNomorSoal.setText("Nomor Soal : xx");
        labelNomorSoal.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 20, 15, 1));
        jPanel4.add(labelNomorSoal);

        labelTotalSoal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTotalSoal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalSoal.setText("Total Soal : xx");
        labelTotalSoal.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 1, 15, 20));
        jPanel4.add(labelTotalSoal);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSoalSelanjutnyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSoalSelanjutnyaActionPerformed

        if (checkFormFilled()) {
            nextQuestion();
        } else {
            JOptionPane.showMessageDialog(null, "Pilih dulu jawabannya baru boleh lanjut...!!!");
        }


    }//GEN-LAST:event_buttonSoalSelanjutnyaActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        this.dispose();
        mframe.displayMenuActivity();
        
    }//GEN-LAST:event_formInternalFrameClosing

    private boolean checkFormFilled() {
        boolean terisi = false;

        if (buttonGroupPilihanGandaSoalMode_1.getSelection() != null) {
            terisi = true;
        }

        return terisi;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupPilihanGandaSoalMode_1;
    private javax.swing.JButton buttonSoalSebelumnya;
    private javax.swing.JButton buttonSoalSelanjutnya;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNomorSoal;
    private javax.swing.JLabel labelTotalSoal;
    private javax.swing.JLabel labelWaktuTersisa;
    private javax.swing.JPanel panelSoal;
    private javax.swing.JPanel panelSoalMode1_PGText;
    private javax.swing.JPanel panelSoalText_Essay;
    private javax.swing.JPanel panelSoalText_PGGambar;
    private javax.swing.JPanel panelSoalVideo_PGText;
    private javax.swing.JRadioButton radioButtonSoalMode1_PG_A1;
    private javax.swing.JRadioButton radioButtonSoalMode1_PG_B1;
    private javax.swing.JRadioButton radioButtonSoalMode1_PG_C1;
    private javax.swing.JRadioButton radioButtonSoalMode1_PG_D1;
    private javax.swing.JTextArea textAreaQuestion;
    // End of variables declaration//GEN-END:variables
}
