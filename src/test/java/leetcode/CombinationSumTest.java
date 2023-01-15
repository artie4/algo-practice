package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

public class CombinationSumTest {

    private CombinationSum combinationSum;

    @BeforeEach
    void setUp() {
        combinationSum = new CombinationSum();
    }

    @ParameterizedTest
    @ArgumentsSource(ArrayProvider.class)
    public void combinationSumTest(int[] ints, int sum, List<List<Integer>> expectedCombos) {
        List<List<Integer>> result = combinationSum.combinationSum(ints, sum);

        Assertions.assertEquals(expectedCombos, result);
    }

    static class ArrayProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{2, 3, 5}, 8, List.of(
                            List.of(2, 2, 2, 2),
                            List.of(2, 3, 3),
                            List.of(3, 5)
                    )),
                    Arguments.of(new int[] {2,7,6,3,5,1}, 9, List.of(
                            List.of(2, 2, 2, 2, 1),
                            List.of(2, 2, 2, 3),
                            List.of(2, 2, 2, 1, 1, 1),
                            List.of(2, 2, 3, 1, 1),
                            List.of(2, 2, 5),
                            List.of(2, 2, 1, 1, 1, 1, 1),
                            List.of(2, 7),
                            List.of(2, 6, 1),
                            List.of(2, 3, 3, 1),
                            List.of(2, 3, 1, 1, 1, 1),
                            List.of(2, 5, 1, 1),
                            List.of(2, 1, 1, 1, 1, 1, 1, 1),
                            List.of(7, 1, 1),
                            List.of(6, 3),
                            List.of(6, 1, 1, 1),
                            List.of(3, 3, 3),
                            List.of(3, 3, 1, 1, 1),
                            List.of(3, 5, 1),
                            List.of(3, 1, 1, 1, 1, 1, 1),
                            List.of(5, 1, 1, 1, 1),
                            List.of(1, 1, 1, 1, 1, 1, 1, 1, 1)
                    ))
            );


        }
    }

}
