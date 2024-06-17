package ru.inno.tests.selenide.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void scenarioOne() {
        open("https://demoqa.com/login");
        $("#userName").setValue("VanHelsing");
        $("#password").setValue("Dracula3000!");
        $("#login").click();
        $(".profile-wrapper .ReactTable .rt-noData").shouldHave(text("No rows found"), Duration.ofSeconds(10));
    }
}
