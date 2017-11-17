
import com.allbestbets.SearchUtils;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.nanoTime;

public class SearchUtilsTest {
    static long start = nanoTime();

    public static void main(String[] args) throws InterruptedException {

        long[] bigArray = new long[1000];
        for (int i = 0; i < bigArray.length; i++) bigArray[i] = i;

        List<Long> bigLong = new ArrayList<>();
        for (long l : bigArray) {
            bigLong.add(l);
        }

        for (int x = 0; x < 10; x++) {
            startTimer();
            for (int i = 0; i < 1000_000; i++) {
                boolean b = SearchUtils.includeInArray(bigArray, -1L, 10L, 20L);
            }
            printDuration("" + x + "# Test with Array");

            startTimer();
            for (int i = 0; i < 1000_000; i++) {
                boolean b = bigLong.contains(-1l) || bigLong.contains(10L) || bigLong.contains(20L);
            }
            printDuration("" + x + "# Test with List");
        }
    }

    private static void startTimer() {
        start = nanoTime();
    }

    private static void printDuration(String label) {
        System.out.println(label + " " + (nanoTime() - start) / 1000_000);
    }
}
