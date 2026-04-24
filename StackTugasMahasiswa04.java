public class StackTugasMahasiswa04 {
    Mahasiswa04[] stack;
    int top;
    int size;

    public StackTugasMahasiswa04(int size) {
        this.size = size;
        stack = new Mahasiswa04[size];
        top = -1;
    }

    public boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (top == - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(Mahasiswa04 mhs) {
        if (!isFull()) {
            top++;
            stack[top] = mhs;
        } else {
            System.out.println("Stack Penuh! Tidak Bisa Menambahkan Tugas Lagi.");
        }
    }

    public Mahasiswa04 pop() {
        if (!isEmpty()) {
            Mahasiswa04 m = stack[top];
            top--;
            return m;
        } else {
            System.out.println("Stack Kosong! Tidak Ada Tugas Untuk Dinilai.");
            return null;
        }
    }

    public Mahasiswa04 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack Kosong! Tidak Ada Tugas Yang Dikumpulkan");
            return null;
        }
    }

    // modifikasi nomor 4
    public Mahasiswa04 peekBottom() {
        if (!isEmpty()) {
            return stack[0];
        } else {
            System.out.println("Stack Kosong! Tidak Ada Tugas Yang Dikumpulkan");
            return null;
        }
    }

    // modifikasi nomor 5
    public int hitungTugas() {
        return top + 1; 
    }

    public void print() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i].nama + "\t" + stack[i].nim + "\t" + stack[i].kelas);
        }
        System.out.println("");
    }

    // percobaan 2
    public String konversiDesimalKeBiner(int nilai) {
        StackKonversi04 stack = new StackKonversi04();
        // while (nilai > 0) {
        //     int sisa = nilai % 2;
        //     stack.push(sisa);
        //     nilai = nilai / 2;
        // }

        while (nilai != 0) {
            int sisa = nilai % 2;
            stack.push(sisa);
            nilai = nilai / 2;
        }

        String biner = new String();
        while (!stack.isEmpty()) {
            biner += stack.pop();
        }
        return biner;
    }
}
