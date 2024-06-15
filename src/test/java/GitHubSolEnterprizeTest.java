package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
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

    //На главной странице GitHub выберите: Меню -> Solutions -> Enterprize 
    //(с помощью команды hover для Solutions). 
    //Убедитесь, что загрузилась нужная страница (например, что заголовок: "The AI-powered developer platform.").
    
    @Test
    void downloadPagesTest(){

        open("https://github.com");
        $$(".HeaderMenu-item").find(text(" Solutions ")).hover();
        $(Selectors.byTagAndText("a","Enterprise")).pressEnter();
        $(withText("The AI-powered")).shouldBe(visible);
    }
}
