package matrix;

import converters.ArrayConverter;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 12. Выведите все элементы массива
 * и их индексы, равные максимальному элементу среди элементов, лежащих выше главной диагонали.
 */
public class MatrixLogic {
    //return as array all elements as entries above main diagonal
    public ArrayList<MatrixEntry<Double>> elmentsAboveMainDiagonal(RealMatrix matrix) {
        ArrayList<MatrixEntry<Double>> retArr = new ArrayList<>();
        AtomicInteger rowIndent = new AtomicInteger(1);//Store how many elemets to skip from left size to slice row
        IntStream.range(0, matrix.getRowDimension())
                .forEach(row -> {
                    ArrayList<Double> rowValues = ArrayConverter.convertDoublePlainArrayToList(matrix.getRow(row));
                    rowValues.subList(rowIndent.get(), rowValues.size())//slice with indent to get elements upon main diagonal
                            .stream()
                            .reduce(0, (column, element) -> {
                                retArr.add(new MatrixEntry<Double>(row, column+rowIndent.get(), element));//column+rowIndent to restore column index, because row was already sliced with indent,
                                return column + 1;
                            }, (integer, integer2) -> integer2);
                    rowIndent.incrementAndGet();
                });

        return retArr;
    }

    

}
