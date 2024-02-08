package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SearchScreen extends BaseScreen {
    public SearchScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    MobileElement buttonDots;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title' and @text='Registration']")
    MobileElement buttonRegistration;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title' and @text='Login']")
    MobileElement buttonLogin;

    @FindBy(xpath = "//*[@text='Registration success!']")
    MobileElement popUpRegSuccess;
    public SearchScreen clickDots() {
        click(buttonDots);
        return this;
    }

    public RegistrationScreen clickRegistration() {
        click(buttonRegistration);
        return new RegistrationScreen(driver);
    }

    public boolean validatePopUpRegSuccess(){
        return isElementPresentByText(popUpRegSuccess, "Registration success!", 7);
    }
}
