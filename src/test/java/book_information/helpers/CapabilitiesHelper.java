package book_information.helpers;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class CapabilitiesHelper {
    public static DesiredCapabilities getDesiredCapabilities(String udid, String systemPort) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability("systemPort", systemPort);
        capabilities.setCapability(MobileCapabilityType.APP, getAppFilePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        return capabilities;
    }

    private static String getAppFilePath() {
        File appFilePath = new File("src/test/resources/book_information.apk");
        return appFilePath.getAbsolutePath();
    }
}
