package domain.exeptions;

import domain.Student;

import java.util.ArrayList;

public class StudentsWithSameMarkExeption extends Exception {
    private ArrayList<Student> studentList;

    public StudentsWithSameMarkExeption(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentsWithSameMarkExeption(String message, ArrayList<Student> studentList) {
        super(message);
        this.studentList = studentList;
    }
}
