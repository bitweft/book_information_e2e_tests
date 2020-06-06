package book_information.pages;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class HomePage {
    private final MobileDriver<MobileElement> driver;
    private final By bookSearchField = By.id("book_name");
    private final By searchButton = By.id("search_books");

    public HomePage(MobileDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public SearchResultsPage searchBook(String bookName) {
        driver.findElement(bookSearchField).sendKeys(bookName);
        driver.findElement(searchButton).click();
        return new SearchResultsPage(driver);
    }
}
