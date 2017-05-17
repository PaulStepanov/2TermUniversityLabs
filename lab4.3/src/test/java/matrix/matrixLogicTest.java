package matrix;

import converters.ArrayConverter;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.junit.Test;

import java.util.Scanner;

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

        System.out.println("----");
        new MatrixLogic().maxElmentsAboveMainDiagonal(new BlockRealMatrix(matrix)).forEach(dme-> {
            System.out.println("Row:"+dme.getRow()+" column:"+dme.getColumn()+" value:"+dme.getValue());
        });

        System.out.println(Double.valueOf("7"));
    }

    @Test
    public void maxElem() throws Exception {
        double[][] matrix = {
                {1,3,4,1},
                {2,4,5,1},
                {2,4,5,6},
                {3,6,1,1}
        };
        Double result = new MatrixLogic().findMaxElement(new BlockRealMatrix(matrix));
        assertEquals(result,new Double(6.0));
    }
}