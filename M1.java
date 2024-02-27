package TUGAS1.PRAK;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class M1 { //public bisa di akses di semua kelas
    static class LibraryLogin {
        private Scanner scanner; //scanner untuk menerima input dari pengguna
        private final Map<String, String> adminCredentials;
        private final Map<String, String> mahasiswaCredentials;
        private String loggedInUser; //yang menandakan peran pengguna yang sedang login

        public LibraryLogin() { // inisiallisasi map admin/mahasiswa
            scanner = new Scanner(System.in);

            adminCredentials = new HashMap<>(); //admincredentials map yang menyimpan username atau pasword admin
            adminCredentials.put("Admin", "zeshacantik");

            mahasiswaCredentials = new HashMap<>();
            mahasiswaCredentials.put("202310370311225", "kepoya");
        }

        public void loginAdmin() { //meminta input username dan pasword admin dr penguna dan memeriksa kecocockan nya
            System.out.print("Masukkan Username Admin: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan Password Admin: ");
            String password = scanner.nextLine();

            if (adminCredentials.containsKey(username) && adminCredentials.get(username).equals(password)) {
                loggedInUser = "Admin"; ///string untuk menyimpan peran pengguna yang sedang login
                System.out.println("Admin Login Berhasil!");
            } else {
                System.out.println("Username Atau Password Admin Salah,silakan dicoba lagi.");
            }
        }

        public void LoginMahasiswa() {
            System.out.print("Masukkan NIM Mahasiswa: ");
            String nim = scanner.nextLine();

            if (nim.length() == 15 && mahasiswaCredentials.containsKey(nim)) {
                loggedInUser = "Mahasiswa"; //string untuk menyimpan peran pengguna yang sedang login
                System.out.println("Mahasiswa Login Berhasil!");
            } else {
                System.out.println("NIM Tidak Valid Atau Tidak Terdaftar.");
            }
        }

        public void exit() {
            System.out.println("Terima Kasih. Sampai Jumpa!");
            System.exit(0);
        }
    }

    public static void main(String[] args) { //membuat objek librarilogin menampilakn menu pilihan
        LibraryLogin librarySystem = new LibraryLogin();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Exit");
            System.out.print("Pilihan: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    librarySystem.loginAdmin();
                    break;
                case 2:
                    librarySystem.LoginMahasiswa();
                    break;
                case 3:
                    librarySystem.exit();
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid.");
            }
        } while (choice != 3);//program akan terus berjalan selama blum memilih 3
    }
}
