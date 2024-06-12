package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByTagAndText;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class GitHubSolEnterprizeTest {

    @BeforeAll
    static void setUpTests() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void DownloadPages(){
//открыть страницу https://github.com
        open("https://github.com");

// среди других вкладок найти вкладку Solutions методом hover
        $$(".HeaderMenu-item").find(text(" Solutions ")).hover();

        sleep(5000);// ожидание 5 сек
// выбрать в ней вкладку Enterprise
        $(Selectors.byTagAndText("a","Enterprise")).pressEnter();

// проверить, что загруженная страница имеет заголовок(текст) "The AI-powered developer platform."
$(withText("The AI-powered")).shouldBe(visible);

    }
}
