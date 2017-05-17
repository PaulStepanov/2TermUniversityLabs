import domain.Student;
import domain.chinesseGenerator.学生发电机;
import domain.exeptions.StudentsWithSameMarkExeption;
import domain.logic.EnrollmentCalculator;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("seril1.ser");
        file.createNewFile();

        FileOutputStream fileOut = new FileOutputStream("seril1.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        EnrollmentCalculator enrollmentCalculator = new EnrollmentCalculator();
        ArrayList<Student> students = null;
        try {
            students = enrollmentCalculator.getEnrollmentList(学生发电机.generateStudentTestList(),1);
        } catch (StudentsWithSameMarkExeption studentsWithSameMarkExeption) {
            studentsWithSameMarkExeption.printStackTrace();
        }


        out.writeObject(students);

        FileInputStream fileIn = new FileInputStream("seril1.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        ArrayList<Student> students1 = (ArrayList<Student>) in.readObject();


        students1.forEach(student -> System.out.println(student.getCentralizeTestingResult().getSumOfMarks()));
    }
}

