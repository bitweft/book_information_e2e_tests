package book_information;

import book_information.pages.HomePage;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

import static book_information.helpers.CapabilitiesHelper.getDesiredCapabilities;
import static book_information.helpers.ServerHelper.getServerUrl;
import static org.testng.AssertJUnit.assertTrue;

public class SearchResultsTest {
    MobileDriver<MobileElement> driver = new AndroidDriver<>(getServerUrl(), getDesiredCapabilities());

    @Test
    public void verifyBookSearchResults() {
        String bookName = "harry";
        List<String> bookTitles = new HomePage(driver)
                .searchBook(bookName)
                .getBookTitles();

        assertTrue(bookTitles.stream().allMatch(title -> title.toLowerCase().contains(bookName)));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
