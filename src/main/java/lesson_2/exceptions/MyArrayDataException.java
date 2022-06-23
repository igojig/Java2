package lesson_2.exceptions;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int col, int row, String data) {
        super(String.format("array[%s][%s] contains non numeric value: %s", col, row, data));
    }
}
