public class Camping {
    protected String kode;
    protected String nama;
    protected int harga;

    public Camping(String kode, String nama, int harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void display() {
        System.out.println("Kode: " + kode + ", Nama: " + nama + ", Harga: " + harga);
    }

    // Overloading method display untuk menangani tipe data yang berbeda
    public void display(int index) {
        System.out.println("Index: " + index + ", Kode: " + kode + ", Nama: " + nama + ", Harga: " + harga);
    }
}
