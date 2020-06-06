package book_information.pages;

import org.openqa.selenium.By;

public class BookDetailsPage extends BasePage {
    private final By title = By.id("title");
    private final By numberOfPages = By.id("num_of_pages");

    public String getTitle() {
        waitForPresenceOfElement(title);
        return driver.findElement(title).getText();
    }

    public String getNumberOfPages() {
        waitForPresenceOfElement(numberOfPages);
        return driver.findElement(numberOfPages).getText();
    }
}
