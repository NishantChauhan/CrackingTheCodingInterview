import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MagicIndex {
    int MISSING_MAGIC_INDEX = -9999;
    int[] array;

    public int magicIndex(int[] arr) {
        if (arr.length == 0) {
            return MISSING_MAGIC_INDEX;
        }
        array = arr;
        int left = 0; // 0,1,2,3
        int right = array.length - 1;
        return magicIndex(left, right);
    }

    public int magicIndex(int left, int right) {
        int mid = (left + right) / 2;
        if (left > right) {
            return MISSING_MAGIC_INDEX;
        }
        if (array[mid] == mid) {
            return mid;
        }
        int leftIndex = Math.min(mid - 1, array[mid]);
        int result = magicIndex(left, leftIndex);
        if (result == MISSING_MAGIC_INDEX) {
            int rightIndex = Math.max(mid + 1, array[mid]);
            result = magicIndex(rightIndex, right);
        }
        return result;
    }

    @Test
    void e1() {
        Assertions.assertEquals(MISSING_MAGIC_INDEX, magicIndex(new int[]{}));
    }

    @Test
    void e2() {
        Assertions.assertEquals(7, magicIndex(new int[]{-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13}));
    }

    @Test
    void e3() {
        Assertions.assertEquals(2, magicIndex(new int[]{-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13}));
    }

    @Test
    void e4() {
        Assertions.assertEquals(2, magicIndex(new int[]{-10, -5, 2, 2, 2, 3, 4, 8, 9, 12, 13}));
    }

    @Test
    void e5() {
        Assertions.assertEquals(MISSING_MAGIC_INDEX, magicIndex(new int[]{-10, -5, -1, 2, 2, 3, 4, 8, 9, 12, 13}));
    }

    @Test
    void e6() {
        Assertions.assertEquals(1, magicIndex(new int[]{0, 1, 2, 3}));
    }

    @Test
    void e7() {
        Assertions.assertEquals(1, magicIndex(new int[]{0, 1, 2}));
    }

}
