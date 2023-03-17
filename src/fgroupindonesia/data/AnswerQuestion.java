
package fgroupindonesia.data;

/**
 *
 * @author fgroupindonesia
 */
public class AnswerQuestion {

    private int id;
    private String nama_student;
    private String nama_soal;
    private int nomor_soal;
    private String jawaban_soal;
    private String status;
    private String tanggal;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nama_student
     */
    public String getNama_student() {
        return nama_student;
    }

    /**
     * @param nama_student the nama_student to set
     */
    public void setNama_student(String nama_student) {
        this.nama_student = nama_student;
    }

    /**
     * @return the nama_soal
     */
    public String getNama_soal() {
        return nama_soal;
    }

    /**
     * @param nama_soal the nama_soal to set
     */
    public void setNama_soal(String nama_soal) {
        this.nama_soal = nama_soal;
    }

    /**
     * @return the nomor_soal
     */
    public int getNomor_soal() {
        return nomor_soal;
    }

    /**
     * @param nomor_soal the nomor_soal to set
     */
    public void setNomor_soal(int nomor_soal) {
        this.nomor_soal = nomor_soal;
    }

    /**
     * @return the jawaban_soal
     */
    public String getJawaban_soal() {
        return jawaban_soal;
    }

    /**
     * @param jawaban_soal the jawaban_soal to set
     */
    public void setJawaban_soal(String jawaban_soal) {
        this.jawaban_soal = jawaban_soal;
    }

    /**
     * @return the tanggal
     */
    public String getTanggal() {
        return tanggal;
    }

    /**
     * @param tanggal the tanggal to set
     */
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
