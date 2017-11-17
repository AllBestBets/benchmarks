import java.util.ArrayList;
import java.util.List;

import static java.lang.System.nanoTime;

public class ArrayOrList {
    public static void main(String[] args) {
        long start;

        start = nanoTime();
        listTest();
        System.out.println("listTest = " + (nanoTime() - start) / 1000);

        start = nanoTime();
        arrayTest();
        System.out.println("ArrayTest = " + (nanoTime() - start) / 1000);

        long[] bigArray = new long[100_000_000];
        for (int i = 0; i < bigArray.length; i++) bigArray[i] = i;

        for (int x = 0; x < 100; x++) {
            start = nanoTime();
            for (int i = 0; i < 1000_000; i++) {
                for (long l : bigArray) {
                    long a = l;
                }
            }
            System.out.println("" + x + "# for iteration = " + (nanoTime() - start) / 1000);

            start = nanoTime();
            for (int i = 0; i < 1000_000; i++) {
                for (int i1 = 0; i1 < bigArray.length; i1++) {
                    long a = bigArray[i1];
                }
            }
            System.out.println("" + x + "# foreach iteration = " + (nanoTime() - start) / 1000);
        }
    }

    private static void listTest() {
        List<Long> longList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) longList.add((long) i);

        for (int i = 0; i < 10_000_000; i++) {
            boolean b = longList.contains(6L) || longList.contains(66L);
        }
    }


    private static void arrayTest() {
        long[] longArray = new long[1000];
        for (int i = 0; i < 1000; i++) longArray[i] = (long) i;


        for (int i = 0; i < 10_000_000; i++) {
            for (int j = 0; j < longArray.length; j++) {
                if (longArray[j] == 6L || longArray[j] == 66L) {
                    boolean b = true;
                    break;
                } else {
                    boolean b = false;
                }
            }
        }
    }
}
