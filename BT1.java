import java.util.*;
class Student {
    private String firstName;
    private String lastName;
    private String birthdate;
    private String address;
    private String className;
    private Map<String, Double> scores; // Lưu điểm các môn học

    public Student(String firstName, String lastName, String birthdate, String address, String className, Map<String, Double> scores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.className = className;
        this.scores = new HashMap<>(scores); // Tạo bản sao của HashMap
    }

    // Tính điểm trung bình
    public double getAverageScore() {
        double total = 0;
        for (double score : scores.values()) {
            total += score;
        }
        return total / scores.size();
    }

    // Xác định rank theo điểm trung bình
    public String getRank() {
        double avg = getAverageScore();
        if (avg >= 8.5) return "A";
        else if (avg >= 7.0) return "B";
        else if (avg >= 5.5) return "C";
        else if (avg >= 4.0) return "D";
        else return "<D";
    }

    // Hiển thị thông tin sinh viên
    public void displayInfo() {
        System.out.println("Ho tên: " + firstName + " " + lastName);
        System.out.println("Ngay sinh: " + birthdate);
        System.out.println("dia chi: " + address);
        System.out.println("Lop: " + className);
        System.out.println("diem cac mon:");
        for (Map.Entry<String, Double> entry : scores.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("diem trung binh: " + getAverageScore());
        System.out.println("Xep loai: " + getRank());
        System.out.println("-----------------------------");
    }
}

class Classroom {
    private String className;
    private List<Student> students;

    public Classroom(String className) {
        this.className = className;
        this.students = new ArrayList<>();
    }

    // Thêm sinh viên vào lớp
    public void addStudent(Student student) {
        students.add(student);
    }

    // Hiển thị danh sách sinh viên và tổng kết theo rank
    public void displayStudents() {
        System.out.println("Danh sach sinh viên lop " + className + ":");
        for (Student student : students) {
            student.displayInfo();
        }
        displayRankSummary();
    }

    // Tổng kết số sinh viên theo rank
    public void displayRankSummary() {
        Map<String, Integer> rankCount = new HashMap<>();
        rankCount.put("A", 0);
        rankCount.put("B", 0);
        rankCount.put("C", 0);
        rankCount.put("D", 0);
        rankCount.put("<D", 0);

        for (Student student : students) {
            String rank = student.getRank();
            rankCount.put(rank, rankCount.get(rank) + 1);
        }

        System.out.println("Tong ket xep loai:");
        for (Map.Entry<String, Integer> entry : rankCount.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " sinh viên");
        }
        System.out.println("-----------------------------");
    }
}

public class BT1 {
    public static void main(String[] args) {
        // Tạo danh sách lớp
        Classroom classA = new Classroom("CNTT_A");
        Classroom classB = new Classroom("CNTT_B");

        // Thêm sinh viên cho lớp CNTT_A
        Map<String, Double> scoresA1 = new HashMap<>();
        scoresA1.put("OOP", 8.5);
        scoresA1.put("PM", 9.0);
        scoresA1.put("ML", 7.5);
        scoresA1.put("DB", 8.0);
        scoresA1.put("Mobile", 7.0);
        classA.addStudent(new Student("Nguyen", "An", "2003-09-24", "Hà Nội", "CNTT_A", scoresA1));

        Map<String, Double> scoresA2 = new HashMap<>();
        scoresA2.put("OOP", 6.0);
        scoresA2.put("PM", 7.0);
        scoresA2.put("ML", 5.5);
        scoresA2.put("DB", 6.5);
        scoresA2.put("Mobile", 5.0);
        classA.addStudent(new Student("Le", "Binh", "2003-12-01", "Hà Nội", "CNTT_A", scoresA2));

        // Thêm sinh viên cho lớp CNTT_B
        Map<String, Double> scoresB1 = new HashMap<>();
        scoresB1.put("OOP", 9.0);
        scoresB1.put("PM", 8.5);
        scoresB1.put("ML", 9.0);
        scoresB1.put("DB", 8.5);
        scoresB1.put("Mobile", 8.0);
        classB.addStudent(new Student("Tran", "Chi", "2003-07-15", "Hà Nội", "CNTT_B", scoresB1));

        Map<String, Double> scoresB2 = new HashMap<>();
        scoresB2.put("OOP", 4.5);
        scoresB2.put("PM", 5.0);
        scoresB2.put("ML", 4.0);
        scoresB2.put("DB", 4.5);
        scoresB2.put("Mobile", 3.5);
        classB.addStudent(new Student("Hoang", "Duong", "2003-11-20", "Hà Nội", "CNTT_B", scoresB2));

        // Hiển thị danh sách lớp và chọn lớp
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nDANH SACH CAC LOP:");
            System.out.println("1. CNTT_A");
            System.out.println("2. CNTT_B");
            System.out.println("0. Thoát");
            System.out.print("Chon lop dde xem thông tin: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                classA.displayStudents();
            } else if (choice == 2) {
                classB.displayStudents();
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Lua chon khong hop le!");
            }
        }
        scanner.close();
    }

}
