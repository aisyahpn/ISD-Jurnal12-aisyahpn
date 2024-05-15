import java.util.PriorityQueue; 
import java.util.Comparator; 
import java.util.Scanner;

class Task {    // merepresentasikan sebuah tugas dengan prioritas dan nama tugas
    public int priority;
    public String task;

    public Task(int priority, String task) {    // menginisialisasi tugas dengan prioritas dan nama tugas
        this.priority = priority;
        this.task = task;
    }

    public String getTask() {
        return task;
    }
}


class TaskComparator implements Comparator<Task> {  // membandingkan dua tugas berdasarkan prioritasnya
    public int compare(Task t1, Task t2) {
        if (t1.priority > t2.priority) {      
            return 1;
        }
        else if (t1.priority < t2.priority) {      
            return -1;
        }       
        return 0;
    }
}


public class ToDoListPQ {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Membuat PriorityQueue dengan kapasitas awal 5 dan menggunakan TaskComparator untuk mengurutkan tugas berdasarkan prioritas
        PriorityQueue<Task> todoList = new PriorityQueue<>(5, new TaskComparator());

        char ch;

        do {
            System.out.println("To-Do List");
            System.out.println("1. Simpan tugas \n2. Tampilkan tugas \n3. Tandai tugas selesai \n4. Hapus To-Do List");
            int choice = s.nextInt(); s.nextLine();     // Membaca pilihan pengguna ; Membersihkan buffer input

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama tugas:");
                    String tugas = s.nextLine();
                    System.out.print("Masukkan prioritas:");
                    int prioritas = s.nextInt();

                    todoList.add(new Task(prioritas, tugas));

                    System.out.println("Tugas " + tugas + " berhasil ditambahkan ke list");
                    break;
                case 2:     // Menampilkan tugas terdekat yang harus diselesaikan
                    System.out.println("Tugas terdekat yang harus diselesaikan: " + todoList.peek().getTask());
                    break;
                case 3:     // Menandai tugas sebagai selesai dan menampilkan tugas berikutnya
                    System.out.println(todoList.poll().getTask() + " selesai dilaksanakan, berikutnya " + todoList.peek().getTask());
                    break;
                case 4:     // Menghapus semua tugas dalam to-do list
                    todoList.clear();
                    System.out.println("To-Do List berhasil dikosongkan");
                break;
            }

            System.out.println("Lanjut? (y/n)");

            ch = s.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');

    }
}