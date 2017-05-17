package matrix;

/**
 * Created by pili on 5/11/17.
 */
public class MatrixEntry<T> {
    private int row;
    private int column;
    private T value;

    public MatrixEntry(int row, int column, T value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
