package solved;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class E15 {
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
    @CsvSource({"1,2", "2,6", "3,20", "4,70", "5,252", "6,924","7,3432","14,40116600","20,137846528820"})
    void test(int size, int numberOfPath) {
        assertEquals(numberOfPath, numberOfPossiblePaths(size));
    }
}
/*
1->2
2->6
3->20
4->70
5->252
6->924
7->3432
8->12870
9->48620
10->184756
11->705432
12->2704156
13->10400600
14->40116600
-----------------------------
0.
0

1.
0 1

0
1

2.
00 10 11 20 21 22

00          1
10 11       2
20 21 22    3

3.
000 100 110 111 200 210 211 220 221 222 300 310 311 320 321 322 330 331 332 333

000                                         1
100 110 111                                 3
200 210 211 220 221 222                     6
300 310 311 320 321 322 330 331 332 333     10



4.
0000 1000 1100 1110 1111
2000 2100 2110 2111 2200
2210 2211 2220 2221 2222
3000 3100 3110 3111 3200
3210 3211 3220 3221 3222
3300 3310 3311 3320 3321
3322 3330 3331 3332 3333
4000 4100 4110 4111 4200
4210 4211 4220 4221 4222
4300 4310 4311 4320 4321
4322 4330 4331 4332 4333
4400 4410 4411 4420 4421
4422 4430 4431 4432 4433
4440 4441 4442 4443 4444

0000    1
1000 1100 1110 1111     4
2000 2100 2110 2111 2200 2210 2211 2220 2221 2222       10
3000 3100 3110 3111 3200 3210 3211 3220 3221 3222 3300 3310 3311 3320 3321 3322 3330 3331 3332 3333     20
4000 4100 4110 4111 4200 4210 4211 4220 4221 4222 4300 4310 4311 4320 4321 4322 4330 4331 4332 4333 4400 4410 4411 4420 4421 4422 4430 4431 4432 4433 4440 4441 4442 4443 4444      35

5.
0   1
1   5
2   15
3   35
4   70
5   126

6.
0   1
1   5+1
2   15+6
3   35+21
4   70+56
5   126+
6

---------------------------------

0.
0   1

1.
0   1
1   1

2.
0   1
1   2
2   3

3.
0   1
1   2+1
2   3+3
3   10

4.
0   1
1   4
2   10
3   20
4   35

5.

6.

*/



