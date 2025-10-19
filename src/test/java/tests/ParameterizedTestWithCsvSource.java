package tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class ParameterizedTestWithCsvSource {
    @BeforeEach
    void setUp(){
        open("https://ipakyulibank.uz/physical");
    }

    @CsvSource(value = {
            "To‘lovlar va o‘tkazmalar, Xalqaro pul o'tkazmalari",
            "Valyuta ayirboshlash, Valyuta kurslari va ayirboshlash",
            //"Bo‘limlar va bankomatlar, Ipak Yo‘li Banki ofislari va bankomatlari xaritada",
            "Aksiyalar, Aksiyalar"
    })
    @ParameterizedTest(name = "Проверка открытия окна c текстом {1} после нажатия на кнопку {0}")
    @Tag("SMOKE")
    void clickButton_OpensWindowWithTextTest(String buttonName, String textValue ) {
        open();
        $$(".transition-colors").findBy(text(buttonName)).click();
        $$(".text-h1").findBy(text(textValue)).shouldBe(visible);


    }
}
