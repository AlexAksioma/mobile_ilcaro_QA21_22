package screens;

import dto.UserDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends BaseScreen{
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLoginEmail']")
    MobileElement fieldEmail;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLoginPassword']")
    MobileElement fieldPassword;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/loginBtn']")
    MobileElement buttonYalla;
    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement popUpErrorMessage;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement buttonOkErrorMessage;


    public LoginScreen typeLoginForm(UserDTO user) {
        type(fieldEmail, user.getEmail());
        type(fieldPassword, user.getPassword());
        return this;
    }

    public SearchScreen clickButtonYallaPositive() {
        click(buttonYalla);
        return new SearchScreen(driver);
    }

    public SearchScreen clickButtonYallaPositiveActions() {
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonYalla, 0, -15).click().perform();
        return new SearchScreen(driver);
    }

    public LoginScreen clickButtonYallaNegativeActions() {
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonYalla, 0, -15).click().perform();
        return this;
    }

    public boolean validatePopUpErrorMessage() {
        return textInElementPresent(popUpErrorMessage, "Login or Password incorrect", 5);
    }

    public LoginScreen clickButtonOkErrorMessage() {
        click(buttonOkErrorMessage);
        return this;
    }
}
