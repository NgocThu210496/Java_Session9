package ra.presentation;

import ra.business.IEmployee;
import ra.businessImp.Employee;
import ra.main.StudentManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class EmployeeManagement {
    //Khởi tạo danh sách nhân viên với List Interface và lớp ArrayList
    static List<IEmployee> listEmployees= new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("****************MENU*****************");
            System.out.println("1. Nhập thông tin cho n nhân viên)");
            System.out.println("2. Hiển thị thông tin nhân viên)");
            System.out.println("3. Tính lương cho các nhân viên");
            System.out.println("4. Tìm kiếm nhân viên theo tên nhân viên");
            System.out.println("5. Cập nhật thông tin nhân viên");
            System.out.println("6. Xóa nhân viên theo mã nhân viên");
            System.out.println("7. Sắp xếp nhân viên theo lương tăng dần (Comparable)");
            System.out.println("8. Sắp xếp nhân viên theo tên nhân viên giảm dần (Comparator)");
            System.out.println("9. Sắp xếp nhân vên theo năm sinh tăng dần (Comparator)");
            System.out.println("0. Thoát");

            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.next());

            switch (choice) {
                case 1:
                    System.out.print("1. Nhập số n nhân viên: ");
                    EmployeeManagement.inputListEmployee(scanner);
                    break;
                case 2:
                    System.out.println("2. Hiển thị thông tin nhân viên)");
                    EmployeeManagement.displayListEmployee();
                    break;
                case 3:
                    System.out.println("3. Tính lương cho các nhân viên");
                    System.out.println("Nhập mã Id của nhân viên cần tính lương: ");
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (true);
    }
    public static void inputListEmployee(Scanner scanner){
        int n = parseInt(scanner.next());
        for(int i=0; i <n; i++){
            //khoi tao doi tuong nhan vien
            Employee employee=new Employee();
            employee.inputData(scanner);
            //them vao danh sach
            listEmployees.add(employee);
        }
    }
    public static void displayListEmployee(){
        for (IEmployee e: listEmployees) {
            e.displayData();
        }
    }
}
