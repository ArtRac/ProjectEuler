import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class E454 {
    static final long PARAMETER = 100;

    public static void main(String[] args) {
        System.out.println(findResult(PARAMETER));
    }

    private static long findResult(final long parameter) {
        long result = 0;
        for (long y = 2; y <= parameter; y++) {
            for (long x = 1; x <= y - 1; x++) {
                if ((y * x) % (y + x) == 0) {
                    System.out.printf(" y=%d x=%d%n",y,x);
                    result += 1;
                }
            }
        }
        return result;
    }

    @ParameterizedTest
    @CsvSource({"15,4", "1000,1069"})
    void test(int parameter, int ey_pected) {
        assertEquals(ey_pected, findResult(parameter));

    }

    @Test
    void takieTam() {
        for (long i = 1; i <= 100; i++) {
            long p = i * (3 * i - 1) / 2;
            System.out.printf("P(%d) = %d%n", i, p);
            //System.out.printf("F %d = %d%n", i, findResult(i));
        }
    }
}

/*
y,x są całkowite dodatnie. Dla jakich y i x, y*x/(y+x) daje wartość całkowitą?
 */