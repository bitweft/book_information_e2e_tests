package book_information.pages;

import book_information.helpers.DriverHelper;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected MobileDriver<MobileElement> driver = DriverHelper.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20);
}
