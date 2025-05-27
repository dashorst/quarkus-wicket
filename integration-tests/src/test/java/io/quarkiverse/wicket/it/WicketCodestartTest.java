package io.quarkiverse.wicket.it;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.quarkus.devtools.codestarts.quarkus.QuarkusCodestartCatalog.Language;
import io.quarkus.devtools.testing.codestarts.QuarkusCodestartTest;

public class WicketCodestartTest {

    @RegisterExtension
    public static QuarkusCodestartTest codestartTest = QuarkusCodestartTest.builder()
            .languages(Language.JAVA)
            .setupStandaloneExtensionTest("io.quarkiverse.wicket:quarkus-wicket")
            .build();

    /**
     * Make sure the generated code meets the expectations.
     * <br>
     * The generated code uses mocked data to be immutable and allow snapshot testing.
     * <br>
     * <br>
     *
     * Read the doc: <br>
     *
     */
    @Test
    void testContent() throws Throwable {
        codestartTest.checkGeneratedSource("org.acme.MyPage");
        codestartTest.checkGeneratedSource("org.acme.MyApplication");
        codestartTest.assertThatGeneratedFileMatchSnapshot(Language.JAVA, "src/main/resources/ilove/quark/us/MyPage.html");
    }

    /**
     * This test runs the build (with tests) on generated projects for all selected languages
     */
    @Test
    void buildAllProjects() throws Throwable {
        codestartTest.buildAllProjects();
    }
}
