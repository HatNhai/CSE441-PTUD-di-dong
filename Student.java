package QuanLySinhVien;

public class Student {
    private String firstName, lastName, birthdate, address, className;
    private double oop, qlda, hocmay, csdl, ltdd;

    public Student(String firstName, String lastName, String birthdate, String address, String className, double oop, double qlda, double hocmay, double csdl, double ltdd ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.className = className;
        this.oop = oop;
        this.qlda = qlda;
        this.hocmay = hocmay;
        this.csdl = csdl;
        this.ltdd = ltdd;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public void displayInfo(){
        System.out.println("Ho va ten: " + getFullName());
        System.out.println("Ngay sinh:" + birthdate);
        System.out.println("Dia chi: " + address);
        System.out.println("Lop: " + className);
        System.out.println("Diem Lap trinh huong doi tuong: " + oop);
        System.out.println("Diem Quan ly du an: " + qlda);
        System.out.println("Diem Hoc may: " + hocmay);
        System.out.println("Diem Co so du lieu: " + csdl);
        System.out.println("Diem Lap trinh di dong: " + ltdd);
    }

    public double averageScore(){
        return (oop + qlda + hocmay + csdl + ltdd) / 5;
    }
}
