package crackingthecodinginterview.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class PowerSet {

    public Set powerSet(Set<Integer> set) {
        Set<Set<Integer>> powerSet = new HashSet<>();
        powerSet.add(Set.of());
        set.forEach(o -> {
            Set<Set<Integer>> newSets = new HashSet<>();
            for (Set<Integer> s : powerSet) {
                Set<Integer> newSet = new HashSet<>(s);
                newSet.add(o);
                newSets.add(newSet);
            }
            powerSet.addAll(newSets);
        });

        return powerSet;
    }

    @Test
    void e1() {
        Assertions.assertEquals(Set.of(Set.of()), powerSet(Set.of()));
    }

    @Test
    void e2() {
        Assertions.assertEquals(Set.of(Set.of(), Set.of(1), Set.of(2), Set.of(1, 2)), powerSet(Set.of(1, 2)));
    }

    @Test
    void e3() {
        Assertions.assertEquals(
                Set.of(
                        Set.of(),
                        Set.of(1),
                        Set.of(2), Set.of(1, 2),
                        Set.of(3), Set.of(1, 3), Set.of(2, 3), Set.of(1, 2, 3)
                )
                , powerSet(Set.of(1, 2, 3)));
    }

    @Test
    void e4() {
        Assertions.assertEquals(
                Set.of(
                        Set.of(),
                        Set.of(1),
                        Set.of(2), Set.of(1, 2),
                        Set.of(3), Set.of(1, 3), Set.of(2, 3), Set.of(1, 2, 3),
                        Set.of(4), Set.of(1, 4), Set.of(2, 4), Set.of(1, 2, 4),
                        Set.of(3, 4), Set.of(1, 3, 4), Set.of(2, 3, 4), Set.of(1, 2, 3, 4)
                )
                , powerSet(Set.of(1, 2, 3, 4)));
    }
}
