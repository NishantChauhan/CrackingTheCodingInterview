package crackingthecodinginterview.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class TowerOfHanoi {

    Stack<Integer> towerOfHanoi(Stack<Integer> first, Stack<Integer> middle, Stack<Integer> last) {
        move(first, middle, last, first.size());
        return last;
    }

    void move(Stack<Integer> first, Stack<Integer> middle, Stack<Integer> last, Integer x) {
        if (x == 0) {
            return;
        }
        if (x == 1) {
            Integer el = first.pop();
            last.push(el);
            return;
        }

        move(first, last, middle, x - 1);
        move(first, middle, last, 1);
        move(middle, first, last, x - 1);
    }

    //---------------------------------------------------------------------------------------------------//
    @Test
    void e0() {
        Stack<Integer> first = new Stack<>();
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> last = new Stack<>();

        Stack<Integer> expectedLast = new Stack<>();
        Assertions.assertEquals(expectedLast, towerOfHanoi(first, middle, last));
    }

    void multiPush(Stack<Integer> s, Integer n) {
        for (int j = n; j >= 1; j--) {
            s.push(j);
        }
    }

    @Test
    void e1() {
        Stack<Integer> first = new Stack<>();
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> last = new Stack<>();

        multiPush(first, 1);
        Stack<Integer> expectedLast = (Stack<Integer>) first.clone();

        Assertions.assertEquals(expectedLast, towerOfHanoi(first, middle, last));
    }

    @Test
    void e2() {
        Stack<Integer> first = new Stack<>();
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> last = new Stack<>();

        multiPush(first, 2);
        Stack<Integer> expectedLast = (Stack<Integer>) first.clone();

        Assertions.assertEquals(expectedLast, towerOfHanoi(first, middle, last));
    }

    @Test
    void e3() {
        Stack<Integer> first = new Stack<>();
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> last = new Stack<>();

        multiPush(first, 3);
        Stack<Integer> expectedLast = (Stack<Integer>) first.clone();

        Assertions.assertEquals(expectedLast, towerOfHanoi(first, middle, last));
    }

    @Test
    void e4() {
        Stack<Integer> first = new Stack<>();
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> last = new Stack<>();

        multiPush(first, 4);
        Stack<Integer> expectedLast = (Stack<Integer>) first.clone();

        Assertions.assertEquals(expectedLast, towerOfHanoi(first, middle, last));
    }

    @Test
    void e10() {
        Stack<Integer> first = new Stack<>();
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> last = new Stack<>();

        multiPush(first, 10);
        Stack<Integer> expectedLast = (Stack<Integer>) first.clone();

        Assertions.assertEquals(expectedLast, towerOfHanoi(first, middle, last));
    }

}
