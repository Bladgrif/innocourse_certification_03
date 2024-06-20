package ru.inno.tests.selenide.utils;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import ru.inno.tests.selenide.models.User;

public class BaseTest {

    protected static final User USER = new User(Config.getUsername(), Config.getPassword());

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }
}
