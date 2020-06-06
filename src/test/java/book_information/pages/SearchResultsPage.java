package book_information.pages;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage {
    private final MobileDriver<MobileElement> driver;
    private final WebDriverWait wait;

    private final By title = By.id("title");

    public SearchResultsPage(MobileDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    public List<String> getBookTitles() {
        List<MobileElement> searchResults = getSearchResults();
        return searchResults
                .stream()
                .map(RemoteWebElement::getText)
                .collect(Collectors.toList());
    }

    private List<MobileElement> getSearchResults() {
        wait.until(ExpectedConditions.presenceOfElementLocated(title));
        return driver.findElements(title);
    }
}
