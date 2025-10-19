package tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class ParameterizedTestWithValueSource {
    @BeforeEach
    void setUp(){
        open("https://ipakyulibank.uz/physical");
    }

    @ValueSource(strings = {
            "Kartalar",
            "Omonatlar",
            "Kreditlar",
            "Xizmatlar"
    })
    @ParameterizedTest(name = "Проверка появления дропдауна после нажатия на кнопку {0}")
    @Tag("SMOKE")
    void whenYouClickMainNavigationButtonDropdownAppearsTest(String buttonName) {
        open();
        $$(".transition-colors").findBy(text(buttonName)).click();
        $$(".text-h4.text-secondary-text-on-light").findBy(text(buttonName)).shouldBe(visible);


    }
}
