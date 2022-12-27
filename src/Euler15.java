import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Euler15 {
    static final int SIZE = 20;

    public static void main(String[] args) {
        System.out.println(numberOfPossiblePaths(SIZE));
    }

    private static long numberOfPossiblePaths(final int size) {
        long[] wiersz = new long[22];
        wiersz[0] = 1;
        for (var i : IntStream.rangeClosed(1, size).toArray()) {
            for (var j : IntStream.rangeClosed(1, i - 1).toArray()) {
                wiersz[j] += wiersz[j - 1];
            }
            wiersz[i] = Arrays.stream(wiersz).sum();
        }
        return Arrays.stream(wiersz).sum();
    }

    @ParameterizedTest
    @CsvSource({"1,2", "2,6", "3,20", "4,70", "5,252", "6,924","7,3432","14,40116600"})
    void testWithCsvSource(int size, int numberOfPath) {
        assertEquals(numberOfPath, numberOfPossiblePaths(size));
    }
}
