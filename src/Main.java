import Controller.Admin;
import Controller.Students;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        String operations;
        boolean exit = false;
        int count = 3;

        //Admin
        Admin admin = new Admin();
        String username;
        String password;

        //Öğrenci
        Students students = new Students();
        int student_id;
        String name;
        String surname;
        String birthday;
        String email;

        System.out.println("Giriş yap.");
        do {
            System.out.print("Kullanıcı Adı: ");
            username = input.nextLine();

            System.out.print("Parola: ");
            password = input.nextLine();
            if (admin.login(username, password)){
                System.out.println("\nOkul otomasyon sistemine hoşgeldiniz...\n");
                do {
                    System.out.println("Öğrencileri listelemek için: 'listele'");
                    System.out.println("Öğrencileri güncellemek için: 'güncelle'");
                    System.out.println("Öğrenci eklemek için: 'ekle'");
                    System.out.println("Öğrenci silmek için: 'sil'");
                    System.out.println("Çıkış için: 'cikis'");
                    operations = input.nextLine();
                    switch (operations){
                        case "listele":
                            System.out.println("\n************************************\n");
                            System.out.println("Veritabanında kayıtlı öğrenciler: ");
                            students.listStudents();
                            System.out.println("\n************************************\n");
                            break;
                        case "güncelle":
                            System.out.println("\n************************************\n");
                            System.out.print("Öğrenci numarası: ");
                            student_id = input.nextInt();
                            input.nextLine();//dummy input
                            System.out.print("Email: ");
                            email = input.nextLine();
                            students.updateEmail(student_id, email);
                            System.out.println("\n************************************\n");
                            break;
                        case "ekle":
                            System.out.println("\n************************************\n");
                            System.out.print("Örenci No: ");
                            student_id = input.nextInt();
                            input.nextLine();//dummy input
                            System.out.print("\nAdı: ");
                            name = input.nextLine();
                            System.out.println("\nSoyadı: ");
                            surname = input.nextLine();
                            System.out.println("\nDoğum Tarihi: ");
                            birthday = input.nextLine();
                            System.out.println("\nEmaili: ");
                            email = input.nextLine();
                            students.createStudent(student_id, name, surname, birthday, email);
                            System.out.println("\n************************************\n");
                            break;
                        case "sil":
                            System.out.println("\n************************************\n");
                            System.out.print("Sistemden kaldırmak istediğiniz öğrencinin numarası: ");
                            student_id = input.nextInt();
                            input.nextLine();//dummy input
                            students.removeStudent(student_id);
                            System.out.println("\n************************************\n");
                            break;
                        case "cikis":
                            exit = true;
                            count = 3;
                            break;
                        default:
                            System.out.println("Hatalı işlem!");
                            break;
                    }
                }while (!exit);
            }else {
                System.out.println("Kullanıcı adı veya parola hatalı.");
                System.out.println(--count + " giriş hakkınız kaldı.");
            }
        }while (count > 0);
        System.out.println("Giriş hakkınızın tamamını kullandınız.");

    }
}