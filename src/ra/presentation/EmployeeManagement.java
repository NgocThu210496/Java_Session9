package ra.presentation;

import ra.business.IEmployee;
import ra.businessImp.Employee;
import ra.main.StudentManagement;

import java.util.*;

import static java.lang.Integer.parseInt;

public class EmployeeManagement {
    //Khởi tạo danh sách nhân viên với List Interface và lớp ArrayList
    static List<Employee> listEmployees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static {
        listEmployees.add(new Employee("Nv01", "Nguyen A", 2000, 2, 3000, 0, true));
        listEmployees.add(new Employee("Nv02", "Nguyen C", 2001, 1, 3500, 0, false));
        listEmployees.add(new Employee("Nv03", "Nguyen B", 2002, 3, 4000, 0, true));
    }

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
                    EmployeeManagement.salaryEmployee();
                    break;

                case 4:
                    System.out.println("4. Tìm kiếm nhân viên theo tên nhân viên");
                    EmployeeManagement.seacherEmployeeListbyName();
                    break;
                case 5:
                    System.out.println("5. Cập nhật thông tin nhân viên");
                    EmployeeManagement.updateEmployee();
                    break;
                case 6:
                    System.out.println("6. Xóa nhân viên theo mã nhân viên");
                    EmployeeManagement.daleteEmployee();
                    break;
                case 7:
                    System.out.println("7. Sắp xếp nhân viên theo lương tăng dần (Comparable)");
                    EmployeeManagement.sortEmployeeList();
                    break;
                case 8:
                    System.out.println("8. Sắp xếp nhân viên theo tên nhân viên giảm dần (Comparator)");
                    EmployeeManagement.sortEmployeeName();
                    break;
                case 9:
                    System.out.println("9. Sắp xếp nhân vên theo năm sinh tăng dần (Comparator));");
                    EmployeeManagement.sortEmployeeAge();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (true);
    }

    public static void inputListEmployee(Scanner scanner) {
        int n = Integer.parseInt(scanner.next());
        for (int i = 0; i < n; i++) {
            //khoi tao doi tuong nhan vien
            Employee employee = new Employee();
            employee.inputData(scanner);
            //them vao danh sach
            listEmployees.add(employee);
        }
    }

    public static void displayListEmployee() {
        for (IEmployee e : listEmployees) {
            e.displayData();
        }
    }

    public static void salaryEmployee() {
        for (int i = 0; i < listEmployees.size(); i++) {
            listEmployees.get(i).calSalary();
        }
    }

    // Sử dụng phương thức contains() để kiểm tra xem tên có trong danh sách không
    public static void seacherEmployeeListbyName() {
        System.out.println("Nhập tên nhân viên cần tìm: ");

        boolean test = true; //tim san pham co hay khong
        scanner.nextLine(); // Xóa bất kỳ dữ liệu thừa trong bộ đệm
        String searchName = scanner.nextLine();
        for (int i = 0; i < listEmployees.size(); i++) {
            test = true;
            // String productName = listEmployees.size().g.toLowerCase(); // Chuyển tên sản phẩm về chữ thường để tìm kiếm không phân biệt hoa thường
            if (listEmployees.get(i).getName().equals(searchName)) {
                listEmployees.get(i).displayData(); // Hiển thị thông tin sản phẩm tìm thấy
                break;
            } else {
                test = false;
            }
        }
        if (!test) {
            System.err.println("Không tìm thấy sản phẩm nào có tên: " + searchName + " vui lòng nhập lại! ");
        }
    }

    public static void updateEmployee() {
        boolean check = false;
        System.out.println("Nhập mã id cần cập nhật: ");
        scanner.nextLine(); // Xóa bất kỳ dữ liệu thừa trong bộ đệm
        String editId = scanner.nextLine();
        for (int i = 0; i < listEmployees.size(); i++) {

            if (listEmployees.get(i).getId().equals(editId)) {
                listEmployees.get(i).inputData(scanner);// Cập nhật thông tin nhưng không cập nhật Id
                listEmployees.get(i).calSalary(); // Tính lại lương sau khi cập nhật
                check = true;
                break;
            }
        }
        if (!check) {
            System.err.println("Không tìm thấy mã nhân viên cần cập nhật, vui lòng nhập lại");
        } else {
            System.out.println("Thông tin nhân viên đã được cập nhật.");
        }

    }

    public static void daleteEmployee() {
        boolean check = false;
        System.out.println("Nhập mã id cần xoá: ");
        String deleteId = scanner.next();
        for (int i = 0; i < listEmployees.size(); i++) {
            if (listEmployees.get(i).getId().equals(deleteId)) {
                listEmployees.remove(i);
                check = true;
                break;
            }
        }
        if (!check) {
            System.err.println("Không tìm thấy mã nhân viên cần xóa, vui lòng nhập lại");
        } else {
            System.out.println("Đã xoá thành công!");
        }
    }
    public static void sortEmployeeList(){
        Collections.sort(listEmployees);

    }
    public static void sortEmployeeName(){
        Collections.sort(listEmployees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getName().compareTo(o1.getName()) ;
            }
        });
    }
    public static void sortEmployeeAge(){
        Collections.sort(listEmployees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getYear()-o2.getYear();
            }
        });
    }


}
