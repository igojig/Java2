package lesson_2.exceptions;

import lesson_2.Main;

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException(int row) {
        super(String.format("In array[ROW][COL]:[%s][] ROW must equals %s, we have: %s", row, Main.ROW_COL_SIZE, row));
    }

    public MyArraySizeException(int row, int column) {
        super(String.format("In array[ROW][COL]:[%s][%s] COL must equals %s, we have: %s", row, column, Main.ROW_COL_SIZE, column));
    }
}
