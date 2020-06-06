package book_information;

import book_information.helpers.DriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    @BeforeMethod
    @Parameters({"device"})
    public void setup(String device) {
        DriverHelper.createDriver(device);
    }

    @AfterMethod
    public void tearDown() {
        DriverHelper.getDriver().quit();
    }
}
