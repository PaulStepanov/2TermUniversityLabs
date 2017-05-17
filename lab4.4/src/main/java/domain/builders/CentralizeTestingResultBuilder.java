package domain.builders;

import domain.CentralizeTestingResult;

public final class CentralizeTestingResultBuilder {
    private Integer firstTestMark;
    private Integer secondTestMark;
    private Integer thirdTestMark;
    private Integer averageCertificateScore;

    private CentralizeTestingResultBuilder() {
    }

    public static CentralizeTestingResultBuilder aCentralizeTestingResult() {
        return new CentralizeTestingResultBuilder();
    }

    public CentralizeTestingResultBuilder firstTestMark(Integer firstTestMark) {
        this.firstTestMark = firstTestMark;
        return this;
    }

    public CentralizeTestingResultBuilder secondTestMark(Integer secondTestMark) {
        this.secondTestMark = secondTestMark;
        return this;
    }

    public CentralizeTestingResultBuilder thirdTestMark(Integer thirdTestMark) {
        this.thirdTestMark = thirdTestMark;
        return this;
    }

    public CentralizeTestingResultBuilder averageCertificateScore(Integer averageCertificateScore) {
        this.averageCertificateScore = averageCertificateScore;
        return this;
    }

    public CentralizeTestingResult build() {
        CentralizeTestingResult centralizeTestingResult = new CentralizeTestingResult();
        centralizeTestingResult.setFirstTestMark(firstTestMark);
        centralizeTestingResult.setSecondTestMark(secondTestMark);
        centralizeTestingResult.setThirdTestMark(thirdTestMark);
        centralizeTestingResult.setAverageCertificateScore(averageCertificateScore);
        return centralizeTestingResult;
    }
}
