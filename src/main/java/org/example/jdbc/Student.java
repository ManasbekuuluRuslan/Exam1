package org.example.jdbc;

public class Student {
    private Long id;
    private String studentName;
    private int age;
    private String email;
    private int phoneNumber;

    public Student(Long id, String studentName, int age, String email, int phoneNumber) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}'+"\n";
    }
}
