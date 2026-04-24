import java.util.Scanner;

public class SuratDemo04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StackSurat04 stack = new StackSurat04(10);
        int pilih;

        do {
            System.out.println("\nSISTEM KELOLA SURAT IZIN PRODI");
            System.out.println("==================================");
            System.out.println("1. Terima Surat Izin (Push)");
            System.out.println("2. Proses Surat Izin (Pop)");
            System.out.println("3. Lihat Surat Izin Terakhir (Peek)");
            System.out.println("4. Lihat Semua Tumpukan Surat (Print)");
            System.out.println("5. Cari Surat Mahasiswa");
            System.out.println("6. Keluar");
            System.out.print("Pilih Menu: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.println("\n--- Masukkan Data Surat ---");
                    System.out.print("ID Surat: "); 
                    String id = sc.nextLine();
                    System.out.print("Nama Mahasiswa: "); 
                    String nama = sc.nextLine();
                    System.out.print("Kelas: "); 
                    String kelas = sc.nextLine();
                    System.out.print("Jenis Izin(S/I): "); 
                    char jenisIzin = sc.next().charAt(0);
                    System.out.print("Durasi (hari): "); 
                    int durasi = sc.nextInt();
                    
                    Surat04 srt = new Surat04(id, nama, kelas, jenisIzin, durasi);
                    stack.push(srt);
                    System.out.println("Surat berhasil ditambahkan ke tumpukan.");
                    break;

                case 2:
                    Surat04 diproses = stack.pop();
                    if (diproses != null) {
                        System.out.println("\n--- Memproses Surat (LIFO) ---");
                        System.out.printf("Memvalidasi surat ID %s atas nama %s\n", diproses.idSurat, diproses.namaMahasiswa);
                        System.out.println("Status: VALID & SELESAI");
                    }
                    break;

                case 3:
                    if (!stack.isEmpty()) {
                        Surat04 topSrt = stack.tumpukanSurat[stack.top];
                        System.out.println("\n--- Surat Teratas saat ini ---");
                        System.out.printf("Nama: %s (ID: %s)\n", topSrt.namaMahasiswa, topSrt.idSurat);
                    } else {
                        System.out.println("Tumpukan Kosong.");
                    }
                    break;

                case 4:
                    stack.print();
                    break;

                case 5:
                    System.out.print("Masukkan Nama Mahasiswa Yang Dicari: ");
                    String cari = sc.nextLine();
                    stack.cariSurat(cari);
                    break;

                case 6:
                    System.out.println("Keluar");
                    break;

                default:
                    System.out.println("Pilihan Tidak Valid");
            }
        } while (pilih != 6);
        
        sc.close();
    }
}
