package tests;

import io.qameta.allure.Feature;
import lifecycle.WebTestLifeCycle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Feature("Our work page tests")
@ExtendWith(WebTestLifeCycle.class)
public class OurWorkPage {
    @DisplayName("На странице отображается кнопка обратной связи \"Напишите нам\"")
    @Test
    void checkFeedbackButton() {
        step("Открываем страницу \"Наши работы\"", () -> open("/work"));

        step("Проверям наличие кнопки и ссылку в ней", () -> {
            $(".jumbotron_details .styleguide-button_medium").shouldHave(text("Напишите нам"))
                    .shouldHave(href("https://distillery.com/ru/contact/"));
        });
    }

    @DisplayName("На странице отображается grid выполненных работ")
    @Test
    void checkDisplayOfWorkTable() {
        step("Открываем страницу \"Наши работы\"", () -> open("/work"));

        step("Проверяем отображение блоков работ и их количество", () -> {
            $(".work-list").shouldHave(visible);
            $$(".work-list__item").shouldHave(size(7));
        });
    }
}
