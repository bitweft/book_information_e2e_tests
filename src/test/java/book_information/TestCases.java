package book_information;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCases extends BaseTest {
    @Test
    public void verifySearchResults() {
        driver.findElement(By.id("book_name")).sendKeys("harry");
        driver.findElement(By.id("search_books")).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title")));
        List<MobileElement> titlesElements = driver.findElements(By.id("title"));
        List<String> titles = new ArrayList<>();
        for (MobileElement title : titlesElements) {
            titles.add(title.getText());
        }

        boolean match = true;
        for (String title : titles) {
            if (!title.toLowerCase().contains("harry")) {
                match = false;
                break;
            }
        }
        assert match;
    }

    @Test
    public void verifySearchedBookDetails() {
        driver.findElementById("book_name").sendKeys("harry");
        driver.findElementById("search_books").click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title")));
        driver.findElementsById("title").get(0).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title")));
        MobileElement title = driver.findElement(By.id("title"));
        assert title.getText().toLowerCase().contains("harry");
    }
}
