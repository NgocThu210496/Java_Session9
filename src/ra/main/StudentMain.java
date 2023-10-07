package ra.main;

import ra.impl.Student;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Student student = new Student();
        int choice;
        do {
            System.out.println("****************MENU*****************");
            System.out.println("1. Nhập thông tin sinh viên");
            System.out.println("2. Hiển thị thông tin sinh viên");
            System.out.println("3. Thoát");

            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    student.inputData(scanner);
                    break;
                case 2:
                    student.displayData();
                    System.out.println("Birth Year: " + student.birthYear(2023));
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (true);
    }
}
