package book_information;

import helpers.DriverHelper;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static MobileDriver<MobileElement> driver;

    @BeforeMethod
    public static void testSuiteSetup() {
        driver = DriverHelper.getDriver();
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }
}
