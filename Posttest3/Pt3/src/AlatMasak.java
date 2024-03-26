public class AlatMasak extends Camping {
    private String jenis;

    public AlatMasak(String kode, String nama, int harga, String jenis) {
        super(kode, nama, harga);
        this.jenis = jenis;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    @Override
    public void display() {
        System.out.println("Alat Masak - Kode: " + kode + ", Nama: " + nama + ", Harga: " + harga + ", Jenis: " + jenis);
    }
}