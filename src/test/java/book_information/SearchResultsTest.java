package book_information;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static book_information.helpers.CapabilitiesHelper.getDesiredCapabilities;
import static book_information.helpers.ServerHelper.getServerUrl;

public class SearchResultsTest {
    MobileDriver<MobileElement> driver = new AndroidDriver<>(getServerUrl(), getDesiredCapabilities());

    @Test
    public void verifyBookSearchResults() {
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
