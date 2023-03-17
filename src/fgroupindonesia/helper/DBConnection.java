package fgroupindonesia.helper;

import fgroupindonesia.data.AnswerQuestion;
import fgroupindonesia.data.Category;
import fgroupindonesia.data.Conditional;
import fgroupindonesia.data.Rewards;
import fgroupindonesia.data.Soal;
import fgroupindonesia.data.Student;
import fgroupindonesia.helper.QueryBuilder.Mode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author fgroupindonesia
 */
public class DBConnection {

    String db_filename = "database.db";

    public String getFileDBPath() {
        String n = SystemPath.getCompletePath(db_filename);

        return n;
    }

    Connection conn = null;

    public void connect() {

        try {
            // db parameters  
            String url = "jdbc:sqlite:" + getFileDBPath();
            // create a connection to the database  
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error at disconnect() " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        DBConnection konektor = new DBConnection();
        //konektor.connect();
        /*Category data = new Category();
        data.setNama("IPA Air");
        data.setTanggal("2023-03-18");

        konektor.insert_category(data);
        
        Soal data = new Soal();
        data.setNama("testing");
        data.setJumlah_pertanyaan(3);
        data.setKategori("IPA Air");
        data.setLimit_waktu(5);
        data.setTanggal("2023-03-18");
        data.setIsi_soal("{something}");
        
        konektor.insert_soal(data);
        
        Student data = new Student();
        data.setKelas("SD");
        data.setNama("shidqi");
        data.setTtl("Bandung, 12 November 2000");
        AnswerQuestion data = new AnswerQuestion();
        data.setJawaban_soal("b");
        data.setNama_soal("IPA A");
        data.setNama_student("syahmi");
        data.setNomor_soal(1);
        data.setStatus("benar");
        data.setTanggal("2023-03-13");*/
        
        Rewards data = new Rewards();
        data.setNama("nonton 30 menit");
        data.setFilename("waktu.png");
        
        konektor.insert_rewards(data);
        QueryBuilder qbs = new QueryBuilder();
        //qbs.setUpdates(new Update())
        qbs.setConditional(new Conditional("nama", "syamsul"));
        System.out.println("testing " + qbs.generate(Mode.UPDATE, "table_rewards", Rewards.class));
    }

    QueryBuilder qb = new QueryBuilder();

    public void insert_rewards(Rewards data) {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.INSERT, "table_rewards", Rewards.class);

        try {
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setNull(1, data.getId());
            pstmt.setString(2, data.getNama());
            pstmt.setString(3, data.getFilename());
           
            pstmt.executeUpdate();

            this.disconnect();
        } catch (SQLException e) {
            System.out.println("Error at insert_rewards() " + e.getMessage());
        }
    }
    
    public void insert_soal(Soal data) {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.INSERT, "table_soal", Soal.class);

        try {
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setNull(1, data.getId());
            pstmt.setInt(2, data.getJumlah_pertanyaan());
            pstmt.setString(3, data.getKategori());
            pstmt.setInt(4, data.getLimit_waktu());
            pstmt.setString(5, data.getIsi_soal());
            pstmt.setString(6, data.getTanggal());
            pstmt.executeUpdate();

            this.disconnect();
        } catch (SQLException e) {
            System.out.println("Error at insert_soal() " + e.getMessage());
        }
    }

    public void insert_category(Category data) {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.INSERT, "table_category", Category.class);

        try {
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setNull(1, data.getId());
            pstmt.setString(2, data.getNama());
            pstmt.setString(3, data.getTanggal());
            pstmt.executeUpdate();

            this.disconnect();
        } catch (SQLException e) {
            System.out.println("Error at insert_category() " + e.getMessage());
        }
    }

    public void insert_answer_question(AnswerQuestion data) {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.INSERT, "table_answer_question", AnswerQuestion.class);

        try {
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setNull(1, data.getId());
            pstmt.setString(2, data.getNama_student());
            pstmt.setString(3, data.getNama_soal());
            pstmt.setInt(4, data.getNomor_soal());
            pstmt.setString(5, data.getJawaban_soal());
            pstmt.setString(6, data.getStatus());
            pstmt.setString(7, data.getTanggal());
            pstmt.executeUpdate();

            this.disconnect();
        } catch (SQLException e) {
            System.out.println("Error at insert_answer_question() " + e.getMessage());
        }
    }
    
    public void insert_student(Student data) {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.INSERT, "table_student", Student.class);

        try {
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setNull(1, data.getId());
            pstmt.setString(2, data.getNama());
            pstmt.setString(3, data.getKelas());
            pstmt.setString(4, data.getTtl());
            pstmt.executeUpdate();

            this.disconnect();
        } catch (SQLException e) {
            System.out.println("Error at insert_student() " + e.getMessage());
        }
    }
    
}
