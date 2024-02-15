package screens;

import dto.UserDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationScreen extends BaseScreen {
    public RegistrationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegName']")
    MobileElement fieldName;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegLastName']")
    MobileElement fieldLastName;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegEmail']")
    MobileElement fieldEmail;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegPassword']")
    MobileElement fieldPassword;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/checkBoxAgree']")
    MobileElement checkBox;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/regBtn']")
    MobileElement buttonYalla;
    //========================
    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement popUpReg_wrongEmail;

    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement buttonOkPopUp;

    public RegistrationScreen typeRegistrationForm(UserDTO user) {
        type(fieldName, user.getName());
        type(fieldLastName, user.getLastName());
        clickButtonBack();
        type(fieldEmail, user.getEmail());
        clickButtonBack();
        type(fieldPassword, user.getPassword());
        clickButtonBack();
        click(checkBox);
        return this;
    }

    public SearchScreen clickYallaPositive() {
        click(buttonYalla);
        return new SearchScreen(driver);
    }

    public RegistrationScreen clickYallaNegative() {
        click(buttonYalla);
        return this;
    }

    public boolean validatePopUpReg_wrongEmail() {
        try {
            return popUpReg_wrongEmail.getText().contains("must be a well-formed email address");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public RegistrationScreen clickOkPopUp() {
        click(buttonOkPopUp);
        pause(5);
        return this;
    }

    public SearchScreen goToSearchPage() {
        clickButtonBack();
        return new SearchScreen(driver);
    }
}
