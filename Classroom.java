package QuanLySinhVien;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private String className;
    private List<Student> students;
    private int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

    public Classroom(String className){
        this.className = className;
        this.students = new ArrayList<>();
    }
    
    public void add(Student student){
        students.add(student);

    }

    public String getClassName(){
        return className;
    }

    public void rankStudents(){
        countA = 0;
        countB = 0;
        countC = 0;
        countD = 0;
        countF = 0;

        for (Student student : students){
            double score = student.averageScore();
            if (score >= 8.0 ) countA++;
            else if (score >= 7.0) countB++;
            else if (score >= 5.5) countC++;
            else if (score >= 4.0) countD++;
            else countF++;
        }
    }

    public void displayStudents(){
        System.out.println("Danh sach sinh vien lop " + className + ": ");
        for (Student student : students){
            student.displayInfo();
        }
    }

    public void displayScore(){
        rankStudents();
        System.out.println("Thong ke xep hang diem sinh vien lop " + className + ":");
        System.out.println("A (>=8.5)   : " + countA);
        System.out.println("B (7.0-8.4) : " + countB);
        System.out.println("C (5.5-6.9) : " + countC);
        System.out.println("D (4.0-5.4) : " + countD);
        System.out.println("F (<4.0)    : " + countF);
    }

}
