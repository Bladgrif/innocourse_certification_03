package ru.inno.tests.selenide.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static ru.inno.tests.selenide.utils.Config.getUrl;

public class ProfilePage {

    public static final String PROFILE_PATH = "profile";


    private BooksPage booksPage = new BooksPage();

    private List<SelenideElement> profileTableRows = $$("div.rt-tr-group img");
    private SelenideElement profileTableCountRows = $("[aria-label='rows per page']");
    private SelenideElement buttonDeleteAllBooks = $(".buttonWrap").$(byText("Delete All Books"));
    private SelenideElement buttonDeleteAllBooksAllert = $(".modal-content #closeSmallModal-ok");
    private SelenideElement buttonDeleteAllBooksSucessful = $(".modal-content #closeSmallModal-ok");


    public void openProfilePage() {
        open(getUrl() + PROFILE_PATH);
    }

    public void refresh() {
        refresh();
    }

    public int countBooksWithImages(int count) {
        switch (count) {
            case 5:
                profileTableCountRows.selectOption("5 rows");
                break;
            case 10:
                profileTableCountRows.selectOption("10 rows");
                break;
            case 20:
                profileTableCountRows.selectOption("20 rows");
                break;
            case 25:
                profileTableCountRows.selectOption("25 rows");
                break;
            case 50:
                profileTableCountRows.selectOption("50 rows");
                break;
            case 100:
                profileTableCountRows.selectOption("100 rows");
                break;
            default:
                throw new IllegalArgumentException("Invalid count: " + count);
        }
        return profileTableRows.size();
    }

    private void ExpandTheProfileTableWithBooks() {
        profileTableCountRows.selectOption("10 rows");
    }

    public void deleteAllBooks() {
        buttonDeleteAllBooks.shouldBe(visible, Duration.ofSeconds(5)).click();
        buttonDeleteAllBooksAllert.shouldBe(visible, Duration.ofSeconds(5)).click();
        Selenide.confirm();
    }

}
