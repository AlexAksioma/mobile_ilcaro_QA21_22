package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreen {
    AppiumDriver<MobileElement> driver;

    public BaseScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pause(int time) {
        try {
            Thread.sleep(1000L * time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isTextEqual(MobileElement element, String text) {
        return (element.getText().equals(text));
    }

    public void click(MobileElement element) {
        element.click();
    }

    public void type(MobileElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void typeCtrl(MobileElement element, String text) {
        element.click();
        element.sendKeys();
        element.clear();
        element.sendKeys(text);
    }

    public void clickButtonBack() {
        driver.navigate().back();
    }

    public boolean isElementPresentByText(MobileElement element, String text, int time) {
        try {
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.textToBePresentInElement(element, text));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    public boolean textInElementPresent(MobileElement element, String text, int time){
        return new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}
