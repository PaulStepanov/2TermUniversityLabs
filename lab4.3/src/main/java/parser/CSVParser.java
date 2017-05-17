package parser;

import org.apache.commons.math3.linear.BlockRealMatrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class CSVParser {
    public static BlockRealMatrix parseCSVtoMatrix(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        //read from file
        ArrayList<ArrayList<Double>> matrixArr = new ArrayList<>();
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            ArrayList<Double> row = new ArrayList<>();
            Arrays.asList(currentLine.split(";"))
                    .forEach(s ->
                            row.add(Double.valueOf(s)));
            matrixArr.add(row);
        }

        //Parse ArrayList<ArrayList<Double>> to double[][]
        double[][] plainArray = new double[matrixArr.size()][];

        IntStream.range(0, matrixArr.size())
                .forEach(rowIndex -> {
                    double[] rowPlainArray = new double[matrixArr.get(rowIndex).size()];
                    matrixArr.get(rowIndex).stream()
                            .reduce(0, (i, value) -> {
                                rowPlainArray[i] = value;
                                return i + 1;
                            }, (integer, integer2) -> integer);

                    plainArray[rowIndex] = rowPlainArray;
                });

        return new BlockRealMatrix(plainArray);
    }


}
