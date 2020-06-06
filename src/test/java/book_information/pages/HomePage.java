package book_information.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By bookSearchField = By.id("book_name");
    private final By searchButton = By.id("search_books");

    public SearchResultsPage searchBook(String bookName) {
        driver.findElement(bookSearchField).sendKeys(bookName);
        driver.findElement(searchButton).click();
        return new SearchResultsPage();
    }
}
