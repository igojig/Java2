package lesson_2;

import lesson_2.exceptions.MyArrayDataException;
import lesson_2.exceptions.MyArraySizeException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {
    public final static int ROW_COL_SIZE = 4;

    private static class SumOfStringMatrix {
        public static int sumOfStringMatrix(String[][] array) throws MyArraySizeException, MyArrayDataException {
            checkDimensions(array);
            return getSum(array);
        }

        private static int getSum(String[][] array) throws MyArrayDataException {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j, array[i][j]);
                    }
                }
            }
            return sum;
        }

        private static void checkDimensions(String[][] array) throws MyArraySizeException {
            if (array.length != ROW_COL_SIZE) {
                throw new MyArraySizeException(array.length);
            }
            for (int i = 0; i < ROW_COL_SIZE; i++) {
                if (array[i].length != ROW_COL_SIZE) {
                    throw new MyArraySizeException(i, array[i].length);
                }
            }
        }
    }


    public static void main(String[] args) {

        String[][] array = {
                {"1", "2", "3", "4",},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4",},
                {"1", "2", "3", "4"},
        };
//
//        String[][] array = {
//                {"1", "2", "3", "4",},
//                {"1", "2", "3", "4"},
//                {"1", "2", "3", "4"},
//        };
//
//        String[][] array = {
//                {"1", "2", "3", "4",},
//                {"1", "2", "3", "4", "5"},
//                {"1", "2", "3", "4",},
//                {"1", "2", "3", "4"},
//        };

//        String[][] array = {
//                {"1", "2", "3", "4",},
//                {"1", "2", "3eee", "4"},
//                {"1", "2", "3", "4",},
//                {"1", "2", "3", "4"},
//        };


        try {
            System.out.printf("Sum of elements: %s", SumOfStringMatrix.sumOfStringMatrix(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("ERROR:");
            System.out.println(e.getMessage());
        }

    }
}
