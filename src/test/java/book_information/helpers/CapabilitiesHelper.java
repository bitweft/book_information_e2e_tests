package book_information.helpers;

import book_information.helpers.capability_config_helpers.CapabilitiesConfigHelper;
import book_information.helpers.capability_config_helpers.DeviceSpecificCapability;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class CapabilitiesHelper {
    public static DesiredCapabilities getDesiredCapabilities(String device) {
        DeviceSpecificCapability deviceCapability = CapabilitiesConfigHelper.getDeviceCapability(device);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, deviceCapability.platformName());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceCapability.deviceName());
        capabilities.setCapability(MobileCapabilityType.UDID, deviceCapability.udid());
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, deviceCapability.systemPort());
        capabilities.setCapability(MobileCapabilityType.APP, getAppFilePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        return capabilities;
    }

    private static String getAppFilePath() {
        File appFilePath = new File("src/test/resources/book_information.apk");
        return appFilePath.getAbsolutePath();
    }
}
