import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
The most naive way of computing n15 requires fourteen multiplications:
n × n × ... × n = n15
But using a "binary" method you can compute it in six multiplications:
n × n = n2
n2 × n2 = n4
n4 × n4 = n8
n8 × n4 = n12
n12 × n2 = n14
n14 × n = n15
However it is yet possible to compute it in only five multiplications:
n × n = n2
n2 × n = n3
n3 × n3 = n6
n6 × n6 = n12
n12 × n3 = n15
We shall define m(k) to be the minimum number of multiplications to compute nk; for example m(15) = 5.
For 1 ≤ k ≤ 200, find ∑ m(k).
*/

public class E122 {
    public static void main(String[] args) {
        final long PARAMETER = 200;

        System.out.println(findResult(PARAMETER));
    }

    private static long findResult(long parameter) {
        long result = 0;
        for(long i=1; i<=parameter;i++)
            result+=findSubResult(i);
        return result;
    }

    private static long findSubResult(long parameter)
    {
        long result = 0;
        return result;
    }

    @ParameterizedTest
    @CsvSource({"15,5"})
    void findResultTest(long parameter, long expected) {
        assertEquals(expected, findSubResult(parameter));

    }

    @Test
    void research() {
    }
}

