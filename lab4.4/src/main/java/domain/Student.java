package domain;

import java.io.Serializable;

public class Student implements Serializable{
    private String surname;
    private String initials;
    private CentralizeTestingResult centralizeTestingResult;

    public Student(){}

    public Student(String surname, String initials, CentralizeTestingResult centralizeTestingResult) {
        this.surname = surname;
        this.initials = initials;
        this.centralizeTestingResult = centralizeTestingResult;
    }

    public String getSurname() {
        return surname;
    }

    public Student setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getInitials() {
        return initials;
    }

    public Student setInitials(String initials) {
        this.initials = initials;
        return this;
    }

    public CentralizeTestingResult getCentralizeTestingResult() {
        return centralizeTestingResult;
    }

    public Student setCentralizeTestingResult(CentralizeTestingResult centralizeTestingResult) {
        this.centralizeTestingResult = centralizeTestingResult;
        return this;
    }
}
