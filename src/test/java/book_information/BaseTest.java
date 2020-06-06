package book_information;

import book_information.helpers.DriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    @BeforeMethod
    @Parameters({"udid", "systemPort"})
    public void setup(String udid, String systemPort) {
        DriverHelper.createDriver(udid, systemPort);
    }

    @AfterMethod
    public void tearDown() {
        DriverHelper.getDriver().quit();
    }
}
