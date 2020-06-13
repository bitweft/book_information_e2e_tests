package helpers;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static helpers.AppiumServerHelper.getServerUrl;
import static helpers.CapabilitiesHelper.getDesiredCapabilities;

public class DriverHelper {
    public static MobileDriver<MobileElement> getDriver() {
        DesiredCapabilities capabilities = getDesiredCapabilities();
        URL remoteAddress = getServerUrl();
        return new AndroidDriver<>(remoteAddress, capabilities);
    }
}
