package lesson_4;


public class Main {
    final static int SIZE = 1_000_000;
    final static int HALF_SIZE = SIZE / 2;

    public static void main(String[] args) {
        float[] array = new float[SIZE];
        method1(array);
        method2(array);
    }

    private static void method1(float[] array) {
        fillArray(array);

        long startTime = System.currentTimeMillis();
        calc(array, 0);
        long endTime = System.currentTimeMillis();

        System.out.printf("Duration: %,d ms\n", endTime - startTime);
//        System.out.println(Arrays.toString(array));
    }

    private static void method2(float[] array) {
        fillArray(array);

        float[] arrLeft = new float[HALF_SIZE];
        float[] arrRight = new float[HALF_SIZE];

        long startTime = System.currentTimeMillis();

        System.arraycopy(array, 0, arrLeft, 0, HALF_SIZE);
        System.arraycopy(array, HALF_SIZE, arrRight, 0, HALF_SIZE);

        Thread th1 = new Thread(() -> calc(arrLeft, 0));
        Thread th2 = new Thread(() -> calc(arrRight, HALF_SIZE));

        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        System.out.println("Array 1: " + Arrays.toString(arrLeft));
//        System.out.println("Array 2: " + Arrays.toString(array2));

        System.arraycopy(arrLeft, 0, array, 0, HALF_SIZE);
        System.arraycopy(arrRight, 0, array, HALF_SIZE, HALF_SIZE);

        long endTime = System.currentTimeMillis();
//        System.out.println("Result array: " + Arrays.toString(array));

        System.out.printf("Duration: %,d ms\n", endTime - startTime);
    }

    static void calc(float[] array, int offset) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i]
                    * Math.sin(0.2f + (i + offset) / 5)
                    * Math.cos(0.2f + (i + offset) / 5)
                    * Math.cos(0.4f + (i + offset) / 2));

//            array[i]=i+offset;
        }
    }

    static void fillArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

}
