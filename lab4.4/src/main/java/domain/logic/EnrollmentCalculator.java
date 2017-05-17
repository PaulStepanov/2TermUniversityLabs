package domain.logic;

import domain.Student;
import domain.comparator.CertificateTestingComparator;
import domain.exeptions.StudentsWithSameMarkExeption;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class EnrollmentCalculator {
    public Integer enrollmenMark(ArrayList<Student> students, Integer amountPositions) {
        if (students.size()<=amountPositions){
            return students.get(students.size()-1).getCentralizeTestingResult().getSumOfMarks();
        }

        return students.get(amountPositions - 1).getCentralizeTestingResult().getSumOfMarks();
    }

    public ArrayList<Student> getEnrollmentList(ArrayList<Student> students, Integer positionsAmount) throws StudentsWithSameMarkExeption {
        Integer enrollmenMark = enrollmenMark(students, positionsAmount);
        ArrayList<Student> enrollmentList = new ArrayList<>();

        students.forEach(student -> {
            if (student.getCentralizeTestingResult().getSumOfMarks() >= enrollmenMark) {
                enrollmentList.add(student);
            }
        });

        //if all right and no people with same sum of marks
        if (enrollmentList.size() <= positionsAmount)
            return enrollmentList;

        enrollmentList.sort((o1, o2) -> {
            CertificateTestingComparator certificateTestingComparator = new CertificateTestingComparator();
            return certificateTestingComparator.compare(o1.getCentralizeTestingResult(), o2.getCentralizeTestingResult());
        });


        if (getStudentsListWithAllSameMarks(enrollmentList).isEmpty()) {
            return new ArrayList<Student>(enrollmentList.subList(0, positionsAmount + 1));
        }

        throw new StudentsWithSameMarkExeption(getStudentsListWithAllSameMarks(enrollmentList));

    }

    //return list of students with full same marks
    private ArrayList<Student> getStudentsListWithAllSameMarks(ArrayList<Student> students) {
        Integer lastStudentScore = students.get(students.size() - 1).getCentralizeTestingResult().getSumOfMarks();
        ArrayList<Student> result = new ArrayList<>();

        IntStream.range(0,students.size() - 1).forEach(i -> {
            CertificateTestingComparator certificateTestingComparator = new CertificateTestingComparator();
            //if student have full same marks they added to list
            if (certificateTestingComparator.compare(students.get(i).getCentralizeTestingResult(), students.get(i + 1).getCentralizeTestingResult()) == 0
                    && students.get(i).getCentralizeTestingResult().getSumOfMarks().equals(lastStudentScore)) {
                result.add(students.get(i));
            }
        });

        return result;
    }
}
