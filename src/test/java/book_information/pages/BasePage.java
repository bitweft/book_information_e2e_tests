package book_information.pages;

import book_information.helpers.DriverHelper;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private final int maxWaitTimeInSeconds = 30;
    protected MobileDriver<MobileElement> driver = DriverHelper.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, maxWaitTimeInSeconds);

    protected void waitForPresenceOfElement(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
