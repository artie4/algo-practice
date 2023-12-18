package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;


import java.util.stream.Stream;

public class ValidAnagramTest {

    @ParameterizedTest
    @ArgumentsSource(InputProvider.class)
    public void given_InputString_Return_isAnagram(String val1, String val2, boolean result) {
        Assertions.assertEquals(ValidAnagram.isAnagram(val1, val2), result);
    }

    static class InputProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("water", "atrew", true),
                    Arguments.of("water", "wartt", false),
                    Arguments.of("word", "drow", true),
                    Arguments.of("like", "lake", false),
                    Arguments.of("marshmallow", "arlhowlmams", true)
            );
        }
    }
}
