import java.io.*;
import java.util.*;

public class Main {
    static int batasan;
    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);
    private static ArrayList<Camping> DataCamping = new ArrayList<>();

    private static void clear() {
        System.out.println("\033[H\033[2J");
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("1. Tambah data");
            System.out.println("2. Tampilkan data");
            System.out.println("3. Update data");
            System.out.println("4. Hapus data");
            System.out.println("5. Keluar");
            while (true) {
                try {
                    System.out.print("Masukkan pilihan >>> ");
                    int pilih = Integer.parseInt(input.readLine());
                    switch (pilih) {
                        case 1:
                            menuTambah();
                            break;
                        case 2:
                            display();
                            break;
                        case 3:
                            updateData();
                            break;
                        case 4:
                            hapusData();
                            break;
                        case 5:
                            System.out.println("Terima kasih");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Pilihan tidak valid");
                            break;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Harap Masukkan Inputan Dengan Format Yang Valid!");
                }
            }
        }
    }

    static void menuTambah() throws NumberFormatException, IOException {
        boolean ulang = true;
        while (ulang == true) {
            System.out.println("1. Tambah Data Alat Masak");
            System.out.println("2. Tambah Data Tenda");
            System.out.println("0. Keluar");
            while (true) {
                try {
                    System.out.print("Masukkan pilihan >>> ");
                    int pilih = Integer.parseInt(input.readLine());
                    switch (pilih) {
                        case 1:
                            addAlatMasak();
                            break;
                        
                        case 2:
                            addCamping();
                            break;
                    
                        case 0:
                            ulang = false;
                            break;
        
                        default:
                            break;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Harap Masukkan Inputan Dengan Format Yang Valid!");
                }
            }
        }
    }

    static void addAlatMasak() throws NumberFormatException, IOException {
        System.out.println("Tambah Data");
        System.out.println("============");
        while (true) {
            try {
                System.out.println("Masukkan jumlah data yang ingin ditambahkan >>>");
                batasan = Integer.parseInt(input.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Harap Masukkan Inputan Dengan Format Yang Valid!");
            }
        }
        for (int i = 1; i <= batasan; i++) {
            int harga;
            System.out.println("Masukkan Kode Barang >>>");
            String kode = input.readLine();
            System.out.println("Masukkan Nama Barang >>>");
            String nama = input.readLine();
            while (true) {
                try {
                    System.out.println("Masukkan Harga Barang>>>");
                    harga = Integer.parseInt(input.readLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Harap Masukkan Inputan Dengan Format Yang Valid!");
                }
            }
            System.out.println("Masukkan Jenis Barang >>>");
            String jenis = input.readLine();
            Camping cpg = new AlatMasak(kode, nama, harga, jenis);
            DataCamping.add(cpg);
        }
        System.out.println("Data telah ditambahkan!!!");
    }

    static void addCamping() throws NumberFormatException, IOException {
        System.out.println("Tambah Data");
        System.out.println("============");
        while (true) {
            try {
                System.out.println("Masukkan jumlah data yang ingin ditambahkan >>>");
                batasan = Integer.parseInt(input.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Harap Masukkan Inputan Dengan Format Yang Valid!");
            }
        }
        for (int i = 1; i <= batasan; i++) {
            int harga, kapasitas;
            System.out.println("Masukkan Kode Barang >>>");
            String kode = input.readLine();
            System.out.println("Masukkan Nama Barang >>>");
            String nama = input.readLine();
            while (true) {
                try {
                    System.out.println("Masukkan Harga Barang>>>");
                    harga = Integer.parseInt(input.readLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Harap Masukkan Inputan Dengan Format Yang Valid!");
                }
            }
            while (true) {
                try {
                    System.out.println("Masukkan Kapasitas Tenda>>>");
                    kapasitas = Integer.parseInt(input.readLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Harap Masukkan Inputan Dengan Format Yang Valid!");
                }
            }
            Camping cpg = new Tenda(kode, nama, harga, kapasitas);
            DataCamping.add(cpg);
        }
        System.out.println("Data telah ditambahkan!!!");
    }

    static void display() {
        System.out.println("Data Camping PT Puncak Dingin");
        int i = 0;
        for (Camping cpg : DataCamping) {
            if (cpg instanceof AlatMasak) {
                ((AlatMasak) cpg).display(i);
            } else if (cpg instanceof Tenda) {
                ((Tenda) cpg).display(i);
            }
        }
    }

    static void updateData() throws IOException {
        System.out.println("Update Data");
        System.out.println("============");
        System.out.print("Masukkan kode data yang ingin diupdate >>> ");
        String kodeUpdate = input.readLine();
        for (int i = 0; i < DataCamping.size(); i++) {
            Camping camping = DataCamping.get(i);
            if (camping.getKode().equals(kodeUpdate)) {
                int newPrice;
                System.out.println("Masukkan Nama Baru >>> ");
                String newName = input.readLine();
                while (true) {
                    try {
                        System.out.println("Masukkan Harga baru >>> ");
                        newPrice = Integer.parseInt(input.readLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Harap Masukkan Inputan Dengan Format Yang Valid!");
                    }
                }

                // Update data
                camping.setNama(newName);
                camping.setHarga(newPrice);
                System.out.println("Data berhasil diupdate!");
                return;
            }
        }
        System.out.println("Data tidak ditemukan!");
    }

    static void hapusData() throws IOException {
        System.out.println("Hapus Data");
        System.out.println("==========");
        System.out.print("Masukkan kode data yang ingin dihapus >>> ");
        String kodeHapus = input.readLine();
        for (int i = 0; i < DataCamping.size(); i++) {
            Camping camping = DataCamping.get(i);
            if (camping.getKode().equals(kodeHapus)) {
                DataCamping.remove(i);
                System.out.println("Data berhasil dihapus!");
                return;
            }
        }
        System.out.println("Data tidak ditemukan!");
    }
}
