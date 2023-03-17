package fgroupindonesia.data;

/**
 *
 * @author asus
 */
public class Soal {

    private int id;
    private String nama;
    private int jumlah_pertanyaan;
    private String kategori;
    private int limit_waktu;
    private String isi_soal;
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
     * @return the jumlah_pertanyaan
     */
    public int getJumlah_pertanyaan() {
        return jumlah_pertanyaan;
    }

    /**
     * @param jumlah_pertanyaan the jumlah_pertanyaan to set
     */
    public void setJumlah_pertanyaan(int jumlah_pertanyaan) {
        this.jumlah_pertanyaan = jumlah_pertanyaan;
    }

    /**
     * @return the kategori
     */
    public String getKategori() {
        return kategori;
    }

    /**
     * @param kategori the kategori to set
     */
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    /**
     * @return the limit_waktu
     */
    public int getLimit_waktu() {
        return limit_waktu;
    }

    /**
     * @param limit_waktu the limit_waktu to set
     */
    public void setLimit_waktu(int limit_waktu) {
        this.limit_waktu = limit_waktu;
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
     * @return the isi_soal
     */
    public String getIsi_soal() {
        return isi_soal;
    }

    /**
     * @param isi_soal the isi_soal to set
     */
    public void setIsi_soal(String isi_soal) {
        this.isi_soal = isi_soal;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

}
