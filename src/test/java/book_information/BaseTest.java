package book_information;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static MobileDriver<MobileElement> driver;

    @BeforeMethod
    public static void testSuiteSetup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        File appFilePath = new File("src/test/resources/book_information.apk");
        capabilities.setCapability(MobileCapabilityType.APP, appFilePath.getAbsolutePath());

        URL remoteAddress = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<>(remoteAddress, capabilities);
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }
}
