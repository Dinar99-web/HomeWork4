import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.*;

public class HomeWork4 {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulSearchJunitCode() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".Box-row.wiki-more-pages-link").click();
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").shouldHave(text("Soft assertions")).click();
        $$(".markdown-heading").findBy(text("JUnit5")).sibling(0).$("pre").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
