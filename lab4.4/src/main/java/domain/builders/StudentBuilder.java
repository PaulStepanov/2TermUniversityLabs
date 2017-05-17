package domain.builders;

import domain.CentralizeTestingResult;
import domain.Student;

public final class StudentBuilder {
    private String surname;
    private String initials;
    private CentralizeTestingResult centralizeTestingResult;

    private StudentBuilder() {
    }

    public static StudentBuilder aStudent() {
        return new StudentBuilder();
    }

    public StudentBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public StudentBuilder initials(String initials) {
        this.initials = initials;
        return this;
    }

    public StudentBuilder centralizeTestingResult(CentralizeTestingResult centralizeTestingResult) {
        this.centralizeTestingResult = centralizeTestingResult;
        return this;
    }

    public Student build() {
        Student student = new Student();
        student.setSurname(surname);
        student.setInitials(initials);
        student.setCentralizeTestingResult(centralizeTestingResult);
        return student;
    }
}
