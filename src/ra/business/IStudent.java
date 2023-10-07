package ra.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

Xây dựng interface IStudent trong package ra có 2 phương thức trừu tượng:
inputData(Scanner scanner): cho phép nhập thông tin đối tượng
displayData(): Cho phep in thông tin đối tượng
Xây dựng lớp Student trong package ra.impl kế thừa từ IStudent có:
Các thuộc tính: studentId, studentName, age, sex
Các constructors
Các phương thức getter/setter
Triển khai các phương thức inputData, displayData
Có phương thức tính năm sinh của sinh viên
Xây dựng lớp Main thực hiện các chức năng sau:

**MENU**
Nhập thông tin sinh viên
Hiển thị thông tin sinh viên
Thoát
*/

public interface IStudent {
    void inputData(Scanner scanner);
    void displayData();

}
