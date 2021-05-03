package tests;

import io.qameta.allure.Feature;
import lifecycle.WebTestLifeCycle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Feature("Navigation menu tests")
@ExtendWith(WebTestLifeCycle.class)
public class NavigationMenuTest {
    @DisplayName("Навигационная панель отображает разделы")
    @Test
    void navigationMenuContainsSections() {
        step("Открываем главную страницу", () -> open(""));

        step("Проверяем наличие всех разделов в навигационном меню", () -> {
            $$("nav[id='navMenuBlock'] div a").shouldHave(containExactTextsCaseSensitive("Наши работы", "О нас", "Карьера", "Блог", "Контакты"));
        });
    }

    @DisplayName("Разделы навигационной панели содержат верные ссылки")
    @Test
    void sectionsHaveCorrectLinks() {
        step("Открываем главную страницу", () -> open(""));

        step("Проверяем соотвествие разделов ссылкам ", () -> {
            $("#navMenuBlock").find(byText("Наши работы"))
                    .shouldHave(href("https://distillery.com/ru/work/"));
            $("#navMenuBlock").find(byText("О нас"))
                    .shouldHave(href("https://distillery.com/ru/about/"));
            $("#navMenuBlock").find(byText("Карьера"))
                    .shouldHave(href("https://distillery.com/ru/career-russia/"));
            $("#navMenuBlock").find(byText("Блог"))
                    .shouldHave(href("https://distillery.com/ru/blog/"));
            $("#navMenuBlock").find(byText("Контакты"))
                    .shouldHave(href("https://distillery.com/ru/contact/"));
        });
    }
}
