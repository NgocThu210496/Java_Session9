package ra.main;

import ra.impl.Student;

import java.util.*;

public class StudentManagement {
    static Scanner scanner = new Scanner(System.in);
    //Khởi tạo 1 danh sách từ List và ArrayList chứa các sinh viên
    static List<Student> studentsList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("****************MENU*****************");
            System.out.println("1. Nhập thông tin n sinh viên (thêm sinh viên vào danh sách)");
            System.out.println("2. Hiển thị thông tin sinh viên (Hiển thị dữ liệu của danh sách)");
            System.out.println("3. Sắp xếp danh sách sinh viên theo tuổi giảm dần (get, set)");
            System.out.println("4. Sắp xếp danh sách sinh viên theo tuổi tăng dần ");
            System.out.println("5. Sắp xếp danh sách sinh viên theo tên giảm dần ");
            System.out.println("6. Thoát");

            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên (n): ");
                    StudentManagement.inputListStudent(scanner);
                    break;
                case 2:
                    System.out.println("Danh sách sinh viên:");
                    StudentManagement.displayListStudent();
                    break;
                case 3:
                    System.out.println("3. Sắp xếp danh sách sinh viên theo tuổi giảm dần (get, set)");
                    StudentManagement.sortStudentByAge();
                    break;
                case 4:
                    System.out.println("4. Sắp xếp danh sách sinh viên theo tuổi tăng dần ");
                    StudentManagement.sortStudentByAgeASC_Comparator();
                    break;
                case 5:
                    System.out.println("5. Sắp xếp danh sách sinh viên theo tên giảm dần ");
                    StudentManagement.sortStudentByName_Comparator();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:

                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (true);
    }

    public static void inputListStudent(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            //khoi tao doi tuong sv can nhap thong tin
            Student student = new Student();
            student.inputData(scanner);
            //them vao danh sach
            studentsList.add(student);
        }

    }

    public static void displayListStudent() {
        for (Student student : studentsList) {
            student.displayData();
        }
    }

    public static void sortStudentByAge(){
        for (int i=0; i<studentsList.size();i++){
            for (int j=i+1; j< studentsList.size();j++){
                if(studentsList.get(i).getAge()<studentsList.get(j).getAge()){
                    Student temp=studentsList.get(i);
                    studentsList.set(i, studentsList.get(j));
                    studentsList.set(j,temp);
                }
            }
        }
    }
    //sau khi cai dat thi ta co:
    // c1: su dung Comparable
    public static void sortStudentByAge_Comparable(){
        Collections.sort(studentsList);
    }

    //c2: su dung Comparator
    public static void sortStudentByAgeASC_Comparator(){
        Collections.sort(studentsList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) { //sap xep tuoi tang dang
                return o1.getAge()-o2.getAge();
            }
        });
    }
    public static void sortStudentByName_Comparator(){
        Collections.sort(studentsList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getStudentName().compareTo(o1.getStudentName());
            }
        });
    }

}
