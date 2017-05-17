package domain.chinesseGenerator;

import domain.Student;
import domain.builders.CentralizeTestingResultBuilder;
import domain.builders.StudentBuilder;

import java.util.ArrayList;

public class 学生发电机 {
    public static ArrayList<Student> generateStudentTestList() {
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(StudentBuilder.aStudent()
                .surname("Test1")
                .initials("same")
                .centralizeTestingResult(
                        CentralizeTestingResultBuilder.aCentralizeTestingResult()
                                .firstTestMark(56)
                                .secondTestMark(78)
                                .thirdTestMark(43)
                                .averageCertificateScore(89)
                                .build()
                ).build());

        students.add(StudentBuilder.aStudent()
                .surname("Test2")
                .initials("same")
                .centralizeTestingResult(
                        CentralizeTestingResultBuilder.aCentralizeTestingResult()
                                .firstTestMark(56)
                                .secondTestMark(78)
                                .thirdTestMark(43)
                                .averageCertificateScore(89)
                                .build()
                ).build());

        students.add(StudentBuilder.aStudent()
                .surname("Test2")
                .initials("same")
                .centralizeTestingResult(
                        CentralizeTestingResultBuilder.aCentralizeTestingResult()
                                .firstTestMark(12)
                                .secondTestMark(89)
                                .thirdTestMark(57)
                                .averageCertificateScore(73)
                                .build()
                ).build());


        return students;
    }
}
