import static java.lang.System.nanoTime;

public class ArrayOrFields {

    public static void main(String[] args) {
        long start;
        float r;

        for (int j = 0; j < 10; j++) {
            start = nanoTime();
            for (int i = 0; i < 100_000_000; i++) {
                B b = new B(new float[]{i, i * 2, i * 3});
                r = b.b[0] + b.b[1] + b.b[2];
            }
            System.out.println("Array = " + (nanoTime() - start) / 1000);

            start = nanoTime();
            for (int i = 0; i < 100_000_000; i++) {
                A a = new A(i, i * 2, i * 3);
                r = a.a1 + a.a2 + a.a3;
            }
            System.out.println("Fields = " + (nanoTime() - start) / 1000);
        }
    }

    private static class A {
        final float a1;
        final float a2;
        final float a3;

        A(float a1, float a2, float a3) {
            this.a1 = a1;
            this.a2 = a2;
            this.a3 = a3;
        }
    }

    private static class B {
        final float[] b;

        B(float[] b) {
            this.b = b;
        }
    }
}