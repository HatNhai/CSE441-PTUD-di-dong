import java.util.*;

public class BTVN1 {
    static class Student{
        String firstName, lastName, address, className;
        Date birthDate;
        Map<String, Double> grades;
        public Student(String firstName, String lastName, Date birthDate, String address, String className){
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.className = className;
            this.birthDate = birthDate; 
            this.grades = new HashMap<>(); //HashMap: lưu trữ dữ liệu dưới dạng key:value
        }
        public void addGrade(String subject, double grade){
            grades.put(subject, grade);
        }
        /*tinh diem trung binh
         Lấy tất cả điểm số từ grades.values() 
         Chuyển thành luồng số (Stream), rồi đổi sang kiểu double
         Trả về 0 nếu không có điểm nào (tránh lỗi khi danh sách rỗng).
         */
        public double getAverageGrade() {
            return grades.values().stream().mapToDouble(Double::doubleValue).average().orElse(0);
        }
        public String getRank() {
            double avg = getAverageGrade();
            if(avg >= 8.5) return "A";
            if(avg >=7.0) return "B";
            if(avg >= 5.5) return "C";
            if(avg >= 4.0) return "D";
            return "<D";
        }
        //ghi đè
        @Override
        public String toString() {
            return firstName + " " + lastName + " - Rank: " + getRank();
        }
    }
    static class Classroom {
        private String classId;
        private List<Student>students; //Lưu danh sách sinh viên dưới dạng list
        public Classroom(String classId){
            this.classId = classId;
            this.students = new ArrayList<>();
        }
        public void addStudent(Student student){
            students.add(student);
        }
        //Tính số lượng sinh viên theo thang điểm dựa trên avg
        public Map<String, Long> getRankSummary(){
            Map<String, Long> rankCount = new HashMap<>();
            for(String rank: Arrays.asList("A", "B", "C", "D", "<D")){
                rankCount.put(rank, students.stream().filter(s -> s.getRank().equals(rank)).count());
                //Lọc (filter) những sinh viên có getRank() trùng với rank hiện tại.
            }
            return rankCount;
        }
        public void displayStudents(){
            students.forEach(System.out::println);
            System.out.println("Tong so nguoi theo Rank: " + getRankSummary());
        }
    }        
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Classroom> classes = new HashMap<>();

        Classroom class1 = new Classroom("HTTT3");
        Student s1 = new Student("Tran", "Hue", new Date(), "Hanoi", "HTTT3");
        s1.addGrade("LTHDT", 8.5);
        s1.addGrade("QLDA", 7.0);
        s1.addGrade("Hoc may", 9.0);
        s1.addGrade("CSDL", 8.0);
        s1.addGrade("Mobile App", 7.5);
        class1.addStudent(s1);//them vao lop
        
        Student s2 = new Student("Duong", "Manh", new Date(), "HCM", "CNTT1");
        s2.addGrade("LTHDT", 5.5);
        s2.addGrade("QLDA", 6.0);
        s2.addGrade("Hoc may", 5.0);
        s2.addGrade("CSDL", 4.5);
        s2.addGrade("Mobile App", 5.0);
        class1.addStudent(s2);
        
        classes.put("HTTT3", class1);//luu lop vao danh sach
        
        System.out.println("Danh sach lop: " + classes.keySet()); // keySet trả về danh sách các lớp hiện có
        System.out.print("Nhap ma lop : ");
        String classId = scanner.nextLine();//nhan ma lop 
        
        Classroom selectedClass = classes.get(classId);
        if (selectedClass != null) {
            selectedClass.displayStudents();
        } else {
            System.out.println("Khong tim thay ma lop: " + classId);
        }
        
        scanner.close();
    }
}
    
