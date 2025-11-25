package JavaBasics;

class Student {
    private String studentId;
    private String name;
    private int age;
    private double gpa;

    public Student() {
        this.studentId = "1";
        this.name = "Unknown";
        this.age = 0;
        this.gpa = 0.0;
    }

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public Student(String studentId, String name, int age, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getID() {
        return this.studentId;
    }

    public String getName() {
        return this.name;
    }

    public int age() {
        return this.age;
    }

    public double gpa() {
        return this.gpa;
    }
}
