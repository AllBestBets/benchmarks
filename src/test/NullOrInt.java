public class NullOrInt {
    public static void main(String[] args) {
        long start;

        nullTest();
        intTest();
        nullTest();
        intTest();
        nullTest();
        intTest();
        nullTest();
        intTest();

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            nullTest();
        System.out.println("nullTest = " + (System.nanoTime() - start) / 1000);

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            intTest();
        System.out.println("intTest = " + (System.nanoTime() - start) / 1000);

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            nullTest();
        System.out.println("nullTest = " + (System.nanoTime() - start) / 1000);

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            intTest();
        System.out.println("intTest = " + (System.nanoTime() - start) / 1000);

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            nullTest();
        System.out.println("nullTest = " + (System.nanoTime() - start) / 1000);

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            intTest();
        System.out.println("intTest = " + (System.nanoTime() - start) / 1000);
    }

    private static void nullTest() {
        boolean b;
        Object a = new Object();

        for (int i = 0; i < 1000_000_000; i++) {
            b = a == null;
        }
    }


    private static void intTest() {
        boolean b;
        int a = 0;

        for (int i = 0; i < 1000_000_000; i++) {
            b = a == i;
        }
    }
}
