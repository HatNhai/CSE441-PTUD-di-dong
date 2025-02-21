package QuanLySinhVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Classroom> lop  = new ArrayList<>();
        // List<Student> sv = new ArrayList<>();

        Classroom cntt1 = new Classroom("CNTT1");
        Classroom cntt2 = new Classroom("CNTT2");
        Classroom cntt3 = new Classroom("CNTT3");


        cntt1.add(new Student("Nguyen", "An", "2004-05-10", "Ha Noi", "CNTT1", 8.5, 7.0, 9.0, 8.0, 8.5));
        cntt1.add(new Student("Nguyen", "Tuyen", "2004-07-16", "Thai Binh", "CNTT1", 10.0, 9.0, 9.0, 9.0, 9.5));
        cntt2.add(new Student("Pham", "Duy", "2004-08-12", "Hai Phong", "CNTT2", 3.5, 4.0, 4.5, 4.0, 3.0));
        cntt3.add(new Student("Vu", "Nhai", "2004-01-29", "Thai Binh", "CNTT2", 3.5, 4.0, 4.5, 4.0, 3.0));

        lop.add(cntt1);
        lop.add(cntt2);
        lop.add(cntt3);

        System.out.println("Danh sach cac lop hoc: ");
        for(Classroom classroom : lop){
            System.out.println(classroom.getClassName());
        }

        System.out.println("Nhap lop can xem danh sach diem: ");
        String input = scanner.nextLine();

        Classroom selectedClass = null;

        for (Classroom classroom : lop) {
            if (classroom.getClassName().equalsIgnoreCase(input)) {
                selectedClass = classroom;
                break;
            }
        }

        if (selectedClass == null){
            System.out.println("Khong tim thay lop hoc!");
        }
        else{
            System.out.println("Danh sach diem va sinh vien lop " + selectedClass.getClassName() + " la: ");
            selectedClass.displayStudents();
            selectedClass.displayScore();
        }
        scanner.close();
    } 
}
