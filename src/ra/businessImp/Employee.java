package ra.businessImp;

import ra.business.IEmployee;

import java.util.Scanner;

public class Employee implements IEmployee, Comparable<Employee>{
    private String id;
    private String name;
    private int year; //nam sinh nhan vien
    private float rate; //he so luong nhan vien
    private float commmission; //Hoa hồng của nhân viên hàng tháng
    private float salary;
    private boolean status; //Trạng thái nhân viên (true – đang làm việc,false – Nghỉ việc)

    public Employee() {
    }

    public Employee(String id, String name, int year, float rate, float commmission, float salary, boolean status) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rate = rate;
        this.commmission = commmission;
        this.salary = salary;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public float getRate() {
        return rate;
    }

    public float getCommmission() {
        return commmission;
    }

    public float getSalary() {
        return salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setCommmission(float commmission) {
        this.commmission = commmission;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào mã nhân viên:");
        this.id=scanner.next();
        System.out.println("Nhập vào tên nhân viên: ");
        this.name=scanner.next();
        System.out.println("Nhập vào năm sinh nhân viên: ");
        this.year=Integer.parseInt(scanner.next());
        System.out.println("Nhập vào hệ số lương nhân viên: ");
        this.rate=Float.parseFloat(scanner.next());
        System.out.println("Nhập vào hoa hồng hàng tháng: ");
        this.commmission=Float.parseFloat(scanner.next());
        System.out.println("Nhập vào trạng thái nhân viên: ");
        this.status=Boolean.parseBoolean(scanner.next());
    }

    @Override
    public void displayData() {
        System.out.printf("Mã nhân viên: %s - Tên nhân viên: %s - Năm sinh nhân viên: %d\n", this.id, this.name, this.year);
        System.out.printf("Hệ số lương nhân viên: %.2f - Hoa hồng hàng tháng: %.2f - Lương nhân viên hàng tháng: %.2f - Trạng thái nhân viên: %s\n", this.rate, this.commmission, this.salary, this.status ? "Dang làm việc" : "Nghỉ việc");
        System.out.println("------------------------------------");

    }
    public void calSalary(){
        salary = rate * BASIC_SALARY + commmission;
    }

    @Override
    public int compareTo(Employee o) {
        return 0;
    }
}
