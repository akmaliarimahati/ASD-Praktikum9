public class StackSurat04 {
    Surat04[] tumpukanSurat;
    int size;
    int top;

    public StackSurat04(int size) {
        this.size = size;
        tumpukanSurat = new Surat04[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(Surat04 srt) {
        if (!isFull()) {
            top++;
            tumpukanSurat[top] = srt;
        } else {
            System.out.println("Tumpukan Surat Penuh!!!");
        }
    }

    public Surat04 pop() {
        if (!isEmpty()) {
            Surat04 srt = tumpukanSurat[top];
            top--;
            return srt;
        } else {
            System.out.println("Tidak Ada Surat Untuk Diproses");
            return null;
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Tumpukan Surat Kosong");
        } else {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s\n", "ID Surat", "Nama Mahasiswa", "Kelas", "Jenis", "Durasi");
            
            for (int i = top; i >= 0; i--) {
                System.out.printf("%-10s | %-20s | %-10s | %-10c | %-2d Hari\n", tumpukanSurat[i].idSurat, tumpukanSurat[i].namaMahasiswa, tumpukanSurat[i].kelas, tumpukanSurat[i].jenisIzin, tumpukanSurat[i].durasi);
            }

            System.out.println("--------------------------------------------------------------------------------");
        }
    }

    public void cariSurat(String nama) {
        boolean ketemu = false;
        for (int i = top; i >= 0; i--) {
            if (tumpukanSurat[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                System.out.println("Surat Ditemukan Pada Posisi Ke-" + (top - i + 1));
                System.out.println("ID: " + tumpukanSurat[i].idSurat + " | Jenis: " + tumpukanSurat[i].jenisIzin);
                ketemu = true;
                break;
            }
        }
        if (!ketemu) System.out.println("Surat atas nama " + nama + " tidak ditemukan.");
    }
}
