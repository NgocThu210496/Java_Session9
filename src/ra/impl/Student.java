package ra.impl;

import ra.business.IStudent;

import java.util.Scanner;

public class Student implements IStudent, Comparable<Student> { // so snh sinh vien voi sinh vien

    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, boolean sex) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public boolean getSex() {
        return sex;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhap Student Id: ");
        this.studentId=scanner.nextLine();
        System.out.println("Nhap vao ten: ");
        this.studentName=scanner.nextLine();
        System.out.println("Nhap vao tuoi: ");
        this.age=Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap vao gioi tinh: ");
        this.sex=Boolean.parseBoolean(scanner.nextLine());
    }
    @Override
    public void displayData() {
        System.out.printf("Ma SV: %s - Ten SV: %s\n", this.studentId, this.studentName);
        System.out.printf("Tuoi SV: %d - Gioi tinh: %b\n", this.age, this.sex ? "Nam" : "Nữ");
        System.out.println("-----------------------------------");
    }
    public int birthYear(int currentYear){
        int  birthdaytYear = currentYear - this.age;
        return birthdaytYear;
    }

    @Override
    public int compareTo(Student o) { // so sanh sv hien tai voi sv o
        //cai dat theo tuoi tang dan
        //c1
//        if(this.age>o.getAge()){
//            return 1; //sv hien tai dang > sv o
//        }else if (this.age==o.getAge()){
//            return 0;
//        }else {
//            return -1 ;
//        }
        //c2
        return  this.age -o.getAge();

    }
}
