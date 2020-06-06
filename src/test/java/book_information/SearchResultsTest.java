package book_information;

import book_information.helpers.DriverHelper;
import book_information.pages.HomePage;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class SearchResultsTest {

    @BeforeMethod
    @Parameters({"udid", "systemPort"})
    public void setup(String udid, String systemPort) {
        DriverHelper.createDriver(udid, systemPort);
    }

    @Test
    public void verifyBookSearchResults() {
        String bookName = "harry";
        List<String> bookTitles = new HomePage()
                .searchBook(bookName)
                .getBookTitles();

        assertTrue(bookTitles.stream().allMatch(title -> title.toLowerCase().contains(bookName)));
    }

    @AfterMethod
    public void tearDown() {
        DriverHelper.getDriver().quit();
    }
}
