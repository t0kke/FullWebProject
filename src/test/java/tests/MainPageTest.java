package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lifecycle.WebTestLifeCycle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("Main page tests")
@ExtendWith(WebTestLifeCycle.class)
public class MainPageTest {
    @DisplayName("Проверка отображения названия компании, заголовка и подзаголовка в блоке с видео")
    @Test
    void titleMainTest() {
        step("Открываем главную страницу", () -> open(""));

        step("Проверяем наличие заголовка и подзаголовков главной страницы", () -> {
            $(".jumbotron-home__label").shouldHave(text("Distillery"));
            $(".jumbotron-home__title").shouldHave(text("РАЗРАБОТКА И ДИЗАЙН"));
            $(".jumbotron-home__subtitle").shouldHave(text("ВЕБ-СЕРВИСОВ И МОБИЛЬНЫХ ПРИЛОЖЕНИЙ"));
        });
    }

    @Story("Политика конфиденциальности")
    @DisplayName("Отображается всплывающее окно с согласием на использование cookie-файлов")
    @Test
    void cookieNotification() {
        step("Открываем главную страницу", () -> open(""));

        step("Проверяем наличие и текст поп-аппа использования куков", () -> {
            $(".cookie-notification__text").shouldHave
                    (text("Оставаясь на нашем сайте, вы соглашаетесь на использование cookie-файлов"));
            $(".cookie-notification__button").shouldBe(visible);
        });
    }

    @Story("Политика конфиденциальности")
    @DisplayName("Окно согласия использования cookie-файлов пропадает после принятия соглашения")
    @Test
    void cookieNotificationDisappearsAfterConsent() {
        step("Открываем главную страницу", () -> open(""));

        step("Проверяем наличие и текст поп-аппа использования куков", () -> {
            $(".cookie-notification__text").shouldBe(visible);
            $(".cookie-notification__button").click();
            $(".cookie-notification_hidden").shouldBe(visible);
        });
    }

    @AllureId("1940")
    @DisplayName("Проверка отображения блока \"Стартапы\" ")
    @Test
    void titleClientPageTest() {
        step("Открываем главную страницу", () -> open(""));

        step("Проверяем наличие заголовка в блоке с клиентами", () -> {
            $(".card-home_startups .card-home__title").shouldHave(text("стартапы"));

        });
    }

}
