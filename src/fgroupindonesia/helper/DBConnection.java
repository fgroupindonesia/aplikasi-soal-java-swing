package fgroupindonesia.helper;

import fgroupindonesia.data.AnswerQuestion;
import fgroupindonesia.data.Category;
import fgroupindonesia.data.Conditional;
import fgroupindonesia.data.Rewards;
import fgroupindonesia.data.Question;
import fgroupindonesia.data.Student;
import fgroupindonesia.helper.QueryBuilder.Mode;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

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
        
        konektor.insert_question(data);
        
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
        data.setTanggal("2023-03-13");
        
        
        // Testing select all
        Rewards data = new Rewards();
        data.setNama("nonton 30 menit");
        data.setFilename("waktu.png");
        
        konektor.insert_rewards(data);

        int j = konektor.select_rewards_all().size();
        System.out.println("Dapet lah " + j);
        
        // Testing select specific
       
        Rewards item = konektor.select_rewards_specific(9);
        System.out.println("didapat " + item.getNama());

        Student data = new Student();
        data.setNama("shidqi");
        data.setKelas("SD");
        data.setTtl("Bandung, 12 November 2023");

        konektor.insert_student(data);

        int j = konektor.select_student_all().size();
        System.out.println("Dapet lah " + j);

        // Testing select specific
        Student item = konektor.select_student_specific(2);
        System.out.println("didapat " + item.getNama());

        Question data = new Question();
        data.setIsi_soal("{}");
        data.setJumlah_pertanyaan(3);
        data.setKategori("SD");
        data.setLimit_waktu(5);
        data.setNama("Soal SD IPA");
        data.setTanggal("2023-03-13");

        konektor.insert_question(data);

        int j = konektor.select_question_all().size();
        System.out.println("Banyak Question " + j);

        Question item = konektor.select_question_specific(6);
        System.out.println("kategorina " + item.getKategori());

        Category data = new Category();
        data.setNama("SOAL SD");
        data.setTanggal("2023-03-13");

        konektor.insert_category(data);

        int j = konektor.select_category_all().size();
        System.out.println("Ada " + j + " category");

        Category item = konektor.select_category_specific(4);
        System.out.println("Didapat " + item.getNama());
        
        AnswerQuestion data = new AnswerQuestion();
        data.setJawaban_soal("b");
        data.setNama_soal("SOAL IPA SD");
        data.setNama_student("shidqi");
        data.setNomor_soal(1);
        data.setStatus("benar");
        data.setTanggal("2023-03-13");
        
        konektor.insert_answer_question(data);

        int j = konektor.select_answer_question_all().size();
        System.out.println("Ada QA sebanyak " + j);
        
        AnswerQuestion item = konektor.select_answer_question_specific(3);
        System.out.println("Didapatlah QA item "  + item.getNama_student());*/

        System.out.println("Coba delete " + konektor.delete_category_specific(4));

        //QueryBuilder qbs = new QueryBuilder();
        //qbs.setSkippedColumn("id");
        //qbs.setConditional(new Conditional("id", 3));
        //System.out.println("testing " + qbs.generate(Mode.UPDATE, DBTableDefinition.TABLE_REWARDS, Rewards.class));
    }

    QueryBuilder qb = new QueryBuilder();

    private boolean delete_specific(String table_name, int id) {
        qb.setConditional(new Conditional("id", id));
        String sql = qb.generate(Mode.DELETE, table_name, null);
        boolean succeed = false;

        System.out.println(sql);

        try {
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            //pstmt.setInt(1, id);
            // execute the delete statement
            int rowKena = pstmt.executeUpdate();

            this.disconnect();
            if (rowKena != 0) {
                succeed = true;
            }
        } catch (Exception e) {
            System.out.println("Error at delete_specific() " + e.getMessage());
        }

        return succeed;
    }

    public boolean delete_student_specific(int id) {
        return this.delete_specific(DBTableDefinition.TABLE_STUDENT, id);
    }

    public boolean delete_rewards_specific(int id) {
        return this.delete_specific(DBTableDefinition.TABLE_REWARDS, id);
    }

    public boolean delete_category_specific(int id) {
        return this.delete_specific(DBTableDefinition.TABLE_CATEGORY, id);
    }

    public boolean delete_answer_question_specific(int id) {
        return this.delete_specific(DBTableDefinition.TABLE_ANSWER_QUESTION, id);
    }

    public boolean delete_question_specific(int id) {
        return this.delete_specific(DBTableDefinition.TABLE_QUESTION, id);
    }

    public AnswerQuestion select_answer_question_specific(int id) {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        qb.setConditional(new Conditional("id", id));
        String sql = qb.generate(Mode.SELECT_ALL, DBTableDefinition.TABLE_ANSWER_QUESTION, null);
        AnswerQuestion item = new AnswerQuestion();
        try {
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set  
            while (rs.next()) {

                item.setId(rs.getInt("id"));
                item.setNomor_soal(rs.getInt("nomor_soal"));
                item.setJawaban_soal(rs.getString("jawaban_soal"));
                item.setNama_soal(rs.getString("nama_soal"));
                item.setNama_student(rs.getString("nama_student"));
                item.setStatus(rs.getString("status"));
                item.setTanggal(rs.getString("tanggal"));

            }

            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at select_answer_question_specific() " + e.getMessage());
        }

        return item;
    }

    public ArrayList<AnswerQuestion> select_answer_question_all() {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.SELECT_ALL, DBTableDefinition.TABLE_ANSWER_QUESTION, null);
        ArrayList<AnswerQuestion> result = new ArrayList<AnswerQuestion>();
        try {
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set  
            while (rs.next()) {
                AnswerQuestion item = new AnswerQuestion();
                item.setId(rs.getInt("id"));
                item.setNomor_soal(rs.getInt("nomor_soal"));
                item.setJawaban_soal(rs.getString("jawaban_soal"));
                item.setNama_soal(rs.getString("nama_soal"));
                item.setNama_student(rs.getString("nama_student"));
                item.setStatus(rs.getString("status"));
                item.setTanggal(rs.getString("tanggal"));

                result.add(item);
            }

            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at select_answer_question_all() " + e.getMessage());
        }

        return result;
    }

    public Category select_category_specific(int id) {
        qb.setConditional(new Conditional("id", id));
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.SELECT_SPECIFIC, DBTableDefinition.TABLE_CATEGORY, null);
        Category item = new Category();
        try {
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set  
            while (rs.next()) {

                item.setId(rs.getInt("id"));
                item.setNama(rs.getString("nama"));
                item.setTanggal(rs.getString("tanggal"));

            }

            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at select_category_specific() " + e.getMessage());
        }

        return item;
    }

    public ArrayList<Category> select_category_all() {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.SELECT_ALL, DBTableDefinition.TABLE_CATEGORY, null);
        ArrayList<Category> result = new ArrayList<Category>();
        try {
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set  
            while (rs.next()) {
                Category item = new Category();
                item.setId(rs.getInt("id"));
                item.setNama(rs.getString("nama"));
                item.setTanggal(rs.getString("tanggal"));

                result.add(item);
            }

            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at select_category_all() " + e.getMessage());
        }

        return result;
    }

    public Question select_question_specific(int id) {
        qb.setConditional(new Conditional("id", id));
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.SELECT_SPECIFIC, DBTableDefinition.TABLE_QUESTION, null);
        Question item = new Question();

        try {
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set  
            while (rs.next()) {

                item.setId(rs.getInt("id"));
                item.setNama(rs.getString("nama"));
                item.setJumlah_pertanyaan(rs.getInt("jumlah_pertanyaan"));
                item.setKategori(rs.getString("kategori"));
                item.setLimit_waktu(rs.getInt("limit_waktu"));
                item.setIsi_soal(rs.getString("isi_soal"));
                item.setTanggal(rs.getString("tanggal"));

            }

            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at select_question_specific() " + e.getMessage());
        }

        return item;
    }

    public ArrayList<Question> select_question_all() {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.SELECT_ALL, DBTableDefinition.TABLE_QUESTION, null);
        ArrayList<Question> result = new ArrayList<Question>();
        try {
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set  
            while (rs.next()) {
                Question item = new Question();
                item.setId(rs.getInt("id"));
                item.setNama(rs.getString("nama"));
                item.setJumlah_pertanyaan(rs.getInt("jumlah_pertanyaan"));
                item.setKategori(rs.getString("kategori"));
                item.setLimit_waktu(rs.getInt("limit_waktu"));
                item.setIsi_soal(rs.getString("isi_soal"));
                item.setTanggal(rs.getString("tanggal"));

                result.add(item);
            }

            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at select_question_all() " + e.getMessage());
        }

        return result;
    }

    public Student select_student_specific(int id) {
        qb.setConditional(new Conditional("id", id));
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.SELECT_SPECIFIC, DBTableDefinition.TABLE_STUDENT, null);
        Student item = new Student();

        try {
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set  
            while (rs.next()) {

                item.setId(rs.getInt("id"));
                item.setNama(rs.getString("nama"));
                item.setKelas(rs.getString("kelas"));
                item.setTtl(rs.getString("ttl"));

            }

            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at select_student_specific() " + e.getMessage());
        }

        return item;
    }

    public ArrayList<Student> select_student_all() {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.SELECT_ALL, DBTableDefinition.TABLE_STUDENT, null);
        ArrayList<Student> result = new ArrayList<Student>();
        try {
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set  
            while (rs.next()) {
                Student item = new Student();
                item.setId(rs.getInt("id"));
                item.setNama(rs.getString("nama"));
                item.setKelas(rs.getString("kelas"));
                item.setTtl(rs.getString("ttl"));

                result.add(item);
            }

            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at select_student_all() " + e.getMessage());
        }

        return result;
    }

    public Rewards select_rewards_specific(int id) {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        qb.setConditional(new Conditional("id", id));
        String sql = qb.generate(Mode.SELECT_SPECIFIC, DBTableDefinition.TABLE_REWARDS, null);
        Rewards item = new Rewards();
        try {
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set  
            while (rs.next()) {

                item.setId(rs.getInt("id"));
                item.setNama(rs.getString("nama"));
                item.setFilename(rs.getString("filename"));

            }

            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at select_rewards_specific() " + e.getMessage());
        }

        return item;
    }

    public ArrayList<Rewards> select_rewards_all() {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.SELECT_ALL, DBTableDefinition.TABLE_REWARDS, null);
        ArrayList<Rewards> result = new ArrayList<Rewards>();
        try {
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set  
            while (rs.next()) {
                Rewards item = new Rewards();
                item.setId(rs.getInt("id"));
                item.setNama(rs.getString("nama"));
                item.setFilename(rs.getString("filename"));

                result.add(item);
            }

            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error at select_rewards_all() " + e.getMessage());
        }

        return result;
    }

    public void insert_rewards(Rewards data) {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.INSERT, DBTableDefinition.TABLE_REWARDS, Rewards.class);

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

    public void insert_question(Question data) {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.INSERT, DBTableDefinition.TABLE_QUESTION, Question.class);

        try {
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setNull(1, data.getId());
            pstmt.setString(2, data.getNama());
            pstmt.setInt(3, data.getJumlah_pertanyaan());
            pstmt.setString(4, data.getKategori());
            pstmt.setInt(5, data.getLimit_waktu());
            pstmt.setString(6, data.getIsi_soal());
            pstmt.setString(7, data.getTanggal());
            pstmt.executeUpdate();

            this.disconnect();
        } catch (SQLException e) {
            System.out.println("Error at insert_question() " + e.getMessage());
        }
    }

    public void insert_category(Category data) {
        //String sql = "INSERT INTO table_category(nama, tanggal) VALUES(?,?)";
        String sql = qb.generate(Mode.INSERT, DBTableDefinition.TABLE_CATEGORY, Category.class);

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
        String sql = qb.generate(Mode.INSERT, DBTableDefinition.TABLE_ANSWER_QUESTION, AnswerQuestion.class);

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
        String sql = qb.generate(Mode.INSERT, DBTableDefinition.TABLE_STUDENT, Student.class);

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
