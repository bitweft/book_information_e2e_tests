package book_information.helpers;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import static book_information.helpers.ServerHelper.getServerUrl;

public class DriverHelper {
    static ThreadLocal<MobileDriver<MobileElement>> threadLocal;

    public static void createDriver(String udid, String systemPort) {
        MobileDriver<MobileElement> driver = getDriver(udid, systemPort);
        if (threadLocal == null) {
            threadLocal = ThreadLocal.withInitial(() -> driver);
        }
        threadLocal.set(driver);
    }

    public static MobileDriver<MobileElement> getDriver() {
        return threadLocal.get();
    }

    private static MobileDriver<MobileElement> getDriver(String udid, String systemPort) {
        var capabilities = CapabilitiesHelper.getDesiredCapabilities(udid, systemPort);
        var serverUrl = getServerUrl();
        return new AndroidDriver<>(serverUrl, capabilities);
    }
}