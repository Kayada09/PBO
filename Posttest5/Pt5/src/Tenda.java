public class Tenda extends Camping {
    private int kapasitas;

    public Tenda(String kode, String nama, int harga, int kapasitas) {
        super(kode, nama, harga);
        this.kapasitas = kapasitas;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    @Override
    public void display() {
        System.out.println("Tenda - Kode: " + kode + ", Nama: " + nama + ", Harga: " + harga + ", Kapasitas: " + kapasitas);
    }

    public void display(int index) {
        System.out.println("Index: " + index + ", Kode: " + kode + ", Nama: " + nama + ", Harga: " + harga + ", Kapasitas: " + kapasitas);
    }
}