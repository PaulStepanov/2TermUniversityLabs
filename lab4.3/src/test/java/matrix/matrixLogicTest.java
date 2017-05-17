package matrix;

import converters.ArrayConverter;
import org.apache.commons.math3.linear.BlockRealMatrix;

import static org.junit.Assert.*;

/**
 * Created by pili on 5/11/17.
 */
public class matrixLogicTest {
    @org.junit.Test
    public void elmentsAboveMainDiagonal() throws Exception {
        double[][] matrix = {
                {1,3,4,1},
                {2,4,5,1},
                {2,4,5,6},
                {3,6,1,1}
        };

        new MatrixLogic().elmentsAboveMainDiagonal(new BlockRealMatrix(matrix)).forEach(dme-> {
            System.out.println("Row:"+dme.getRow()+" column:"+dme.getColumn()+" value:"+dme.getValue());
        });

    }

}