import static java.lang.System.currentTimeMillis;

public class AccessBenchmark {
    private final long N = 1_000_000_000;
    private static final int M = 1;

    private LocalClass instanceVar;

    private class LocalClass {
        void someFunc() {
        }
    }

    private double testInstanceVar() {
        // System.out.println("Running instance variable benchmark:");
        instanceVar = new LocalClass();

        long start = currentTimeMillis();
        for (int i = 0; i < N; i++) {
            instanceVar.someFunc();
        }

        long elapsed = currentTimeMillis() - start;

        double avg = (elapsed * 1000.0) / N;

        // System.out.println("elapsed time = " + elapsed + "ms");
        // System.out.println(avg + " microseconds per execution");

        return avg;
    }

    private double testLocalVar() {
        // System.out.println("Running local variable benchmark:");
        instanceVar = new LocalClass();
        LocalClass localVar = instanceVar;

        long start = currentTimeMillis();
        for (int i = 0; i < N; i++) {
            localVar.someFunc();
        }

        long elapsed = currentTimeMillis() - start;

        double avg = (elapsed * 1000.0) / N;

        // System.out.println("elapsed time = " + elapsed + "ms");
        // System.out.println(avg + " microseconds per execution");

        return avg;
    }

    public static void main(String[] args) {
        AccessBenchmark bench;

        double[] avgInstance = new double[M];
        double[] avgLocal = new double[M];

        for (int i = 0; i < M; i++) {
            bench = new AccessBenchmark();

            avgInstance[i] = bench.testInstanceVar();
            avgLocal[i] = bench.testLocalVar();

            System.gc();
        }

        double sumInstance = 0.0;
        for (double d : avgInstance) sumInstance += d;
        System.out.println("Average time for instance variable access: " + sumInstance / M);

        double sumLocal = 0.0;
        for (double d : avgLocal) sumLocal += d;
        System.out.println("Average time for local variable access: " + sumLocal / M);
    }
}