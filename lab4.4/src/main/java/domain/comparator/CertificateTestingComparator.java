package domain.comparator;

import domain.CentralizeTestingResult;

import java.util.Comparator;

public class CertificateTestingComparator implements Comparator<CentralizeTestingResult> {
    @Override
    public int compare(CentralizeTestingResult o1, CentralizeTestingResult o2) {
        if (o1.getAverageCertificateScore() > o2.getAverageCertificateScore()) {
            return 1;
        }
        if (o1.getAverageCertificateScore() < o2.getAverageCertificateScore()) {
            return -1;
        }
        //if average cert score is equals
        if (o1.getAverageCertificateScore().equals(o2.getAverageCertificateScore())) {
            //compare first mark
            if (o1.getFirstTestMark() > o2.getFirstTestMark())
                return 1;

            if (o1.getFirstTestMark() < o2.getFirstTestMark()) {
                return -1;
            }
            //if first marks is equals - compare second mark
            if (o1.getFirstTestMark().equals(o2.getFirstTestMark())) {
                if (o1.getSecondTestMark() > o2.getSecondTestMark())
                    return 1;

                if (o1.getSecondTestMark() < o2.getSecondTestMark()) {
                    return -1;
                }
                //if second marks is equals - compare third mark
                if (o1.getSecondTestMark().equals(o2.getSecondTestMark())) {
                    if (o1.getThirdTestMark() > o2.getThirdTestMark())
                        return 1;

                    if (o1.getThirdTestMark() < o2.getThirdTestMark()) {
                        return -1;
                    }
                    //if third marks are equals
                    if(o1.getThirdTestMark().equals(o2.getThirdTestMark())) {
                        return 0;
                    }
                }

            }

        }

        return 0;
    }
}
