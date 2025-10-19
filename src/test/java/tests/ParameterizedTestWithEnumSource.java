package tests;

import data.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ParameterizedTestWithEnumSource {
    @BeforeEach
    void setUp() {
        open("https://ipakyulibank.uz/physical");
    }

    @EnumSource(Language.class)
    @ParameterizedTest(name = "Проверка появления текста после смены языка {0}")
    @Tag("SMOKE")
    void checkLocalizedTextAfterLanguageSwitch(Language language) {
        $(".i-select-container").click();
        $$(".overflow-y-auto").findBy(text(language.buttonText)).click();
        $(".text-h2").shouldHave(text(language.description));
    }
}
