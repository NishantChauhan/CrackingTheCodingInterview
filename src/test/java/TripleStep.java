import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TripleStep {

    public long count(int n) {
        long memo[] = new long[n + 1];
        Arrays.fill(memo, -1);
        return count(n, memo);
    }

    public long count(int n, long[] memo) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        if (memo[n] > -1) {
            return memo[n];
        }
        memo[n] = count(n - 1, memo) + count(n - 2, memo) + count(n - 3, memo);
        return memo[n];
    }


    @Test
    void e1() {
        Assertions.assertEquals(1, count(1));
        Assertions.assertEquals(2, count(2));
        Assertions.assertEquals(4, count(3));
        Assertions.assertEquals(13, count(5));
    }
}

