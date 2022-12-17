package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;


public class TreeMaxDepthTest {

    @ParameterizedTest
    @ArgumentsSource(TreeProvider.class)
    public void givenAnyTree_WhenMaxDepth_ReturnDepth(TreeNode treeNode, int expectedDepth) {
        var treeMaxDepth = new TreeMaxDepth();

        int result = treeMaxDepth.maxDepth(treeNode);

        Assertions.assertEquals(expectedDepth, result);
    }

    static class TreeProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            var oneNodeDepth = new TreeNode(100);

            var twoNodeDepth = new TreeNode(20)
                    .leftNode(new TreeNode(10))
                    .rightNode(new TreeNode(30));

            var fiveNodeDepth = new TreeNode(20)
                    .leftNode(new TreeNode(10)
                            .rightNode(new TreeNode(15).leftNode(new TreeNode(12).rightNode(new TreeNode(13)))))
                    .rightNode(new TreeNode(30));

            return Stream.of(
                    Arguments.of(oneNodeDepth, 1),
                    Arguments.of(twoNodeDepth, 2),
                    Arguments.of(fiveNodeDepth, 5)
            );
        }
    }
}
