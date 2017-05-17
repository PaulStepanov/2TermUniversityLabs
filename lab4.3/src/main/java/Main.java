import matrix.MatrixLogic;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import parser.CSVParser;

import java.io.IOException;

/**
 * Created by pili on 5/11/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BlockRealMatrix matrix = CSVParser.parseCSVtoMatrix("E:\\progects\\2TermUniversityLabs\\lab4.3\\src\\main\\resources\\matrix.csv");
        new MatrixLogic().elmentsAboveMainDiagonal(matrix).forEach(dme-> {
            System.out.println("Row:"+dme.getRow()+" column:"+dme.getColumn()+" value:"+dme.getValue());
        });

        System.out.println("-----Max elements----");
        new MatrixLogic().maxElmentsAboveMainDiagonal(matrix).forEach(dme-> {
            System.out.println("Row:"+dme.getRow()+" column:"+dme.getColumn()+" value:"+dme.getValue());
        });
    }
}
