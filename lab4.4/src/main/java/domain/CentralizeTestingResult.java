package domain;

import java.io.Serializable;

public class CentralizeTestingResult implements Serializable{
    private Integer firstTestMark;
    private Integer secondTestMark;
    private Integer thirdTestMark;
    private Integer averageCertificateScore;

    public CentralizeTestingResult(){}

    public CentralizeTestingResult(Integer firstTestMark, Integer secondTestMark, Integer thirdTestMark, Integer averageCertificateScore) {
        this.firstTestMark = firstTestMark;
        this.secondTestMark = secondTestMark;
        this.thirdTestMark = thirdTestMark;
        this.averageCertificateScore = averageCertificateScore;
    }

    public Integer getSumOfMarks(){
        return firstTestMark+secondTestMark+thirdTestMark+averageCertificateScore;
    }

    public Integer getFirstTestMark() {
        return firstTestMark;
    }

    public CentralizeTestingResult setFirstTestMark(Integer firstTestMark) {
        this.firstTestMark = firstTestMark;
        return this;
    }

    public Integer getSecondTestMark() {
        return secondTestMark;
    }

    public CentralizeTestingResult setSecondTestMark(Integer secondTestMark) {
        this.secondTestMark = secondTestMark;
        return this;
    }

    public Integer getThirdTestMark() {
        return thirdTestMark;
    }

    public CentralizeTestingResult setThirdTestMark(Integer thirdTestMark) {
        this.thirdTestMark = thirdTestMark;
        return this;
    }

    public Integer getAverageCertificateScore() {
        return averageCertificateScore;
    }

    public CentralizeTestingResult setAverageCertificateScore(Integer averageCertificateScore) {
        this.averageCertificateScore = averageCertificateScore;
        return this;
    }
}
