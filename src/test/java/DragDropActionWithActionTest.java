package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class DragDropActionWithActionTest {

    @BeforeAll
    static void setUpTests() {
        Configuration.browserSize = "1920x1080";// открыть браузер в разрешении
        Configuration.holdBrowserOpen = false;//закрыть браузер после теста
    }

    @Test
    void ActionProgrammDD() {
//открыть страницу https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

//Перенесите прямоугольник А на место В
        actions()
                .moveToElement($("#column-a")).clickAndHold()
                .moveToElement($("#column-b")).release().perform();
        //sleep(5000);// ожидание 5 сек

//Проверьте, что прямоугольники действительно поменялись
// для #column-a" найди тег(header) B
/// для #column-b" найди тег(header) A

        $("#column-a").$(byTagAndText("header", "B")).shouldBe(exist);
        $("#column-b").$(byTagAndText("header", "A")).shouldBe(exist);

//Перенесите обратно прямоугольник А на место В
        actions()
                .moveToElement($("#column-a")).clickAndHold()
                .moveToElement($("#column-b")).release().perform();

//Проверьте, что прямоугольники действительно поменялись
// для #column-a" будет найден тег(header) A
/// для #column-b" будет найден тег(header) B
        $("#column-a").$(byTagAndText("header", "A")).shouldBe(exist);
        $("#column-b").$(byTagAndText("header", "B")).shouldBe(exist);
    }

    @Test
    void ActionDragAndDrop(){
        //В Selenide есть команда $(element).dragAndDrop($(to-element)),
// проверьте работает ли тест, если использовать её вместо actions()
        //открыть страницу https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //$("#column-a").dragAndDrop((DragAndDropOptions) $("#column-b"));
        $("#column-a").dragAndDrop(to("#column-b"));
        sleep(5000);// ожидание 5 сек

//Проверьте, что прямоугольники действительно поменялись
// для #column-a" будет найден тег(header) A
/// для #column-b" будет найден тег(header) B

        $("#column-a").$(byTagAndText("header", "B")).shouldBe(exist);
        $("#column-b").$(byTagAndText("header", "A")).shouldBe(exist);

//Перенесите обратно прямоугольник А на место В

        $("#column-a").dragAndDrop(to("#column-b"));
        sleep(5000);// ожидание 5 сек

//Проверьте, что прямоугольники действительно поменялись
// для #column-a" НЕ будет найден тег(header) A
/// для #column-b" НЕ будет найден тег(header) B

        $("#column-a").$(byTagAndText("header", "B")).shouldNotBe(exist);
        $("#column-b").$(byTagAndText("header", "A")).shouldNotBe(exist);
    }
}
