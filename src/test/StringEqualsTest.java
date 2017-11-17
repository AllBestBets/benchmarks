import static java.lang.System.nanoTime;

public class StringEqualsTest {

    public static void main(String[] args) {
        long start;

        boolean b;

        String to = "TO";
        String tu = "TU";

        start = nanoTime();
        for (int i = 0; i < 1_000_000; i++)
            b = to.equals(tu);
        System.out.println("to.equals(tu): " + (nanoTime() - start) / 1000);

        int toCode = to.hashCode();
        int tuCode = tu.hashCode();

        start = nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            b = toCode == tuCode;
        }
        System.out.println("toCode == tuCode: " + (nanoTime() - start) / 1000);

    }
}