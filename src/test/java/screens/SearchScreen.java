package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchScreen extends BaseScreen {
    public SearchScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")   //	//android.widget.ImageView[@content-desc="More options"]
    MobileElement buttonDots;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title' and @text='Registration']")
    MobileElement buttonRegistration;
//    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title' and @text='Logout']")   //com.telran.ilcarro:id/title
//    MobileElement buttonLogout;
    @FindBy(xpath = "//android.widget.ListView" +
            "/android.widget.LinearLayout[2]/android.widget.LinearLayout" +
            "/android.widget.RelativeLayout/android.widget.TextView")
    MobileElement buttonLogout;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title' and @text='Login']")
    MobileElement buttonLogin;

    @FindBy(xpath = "//*[@text='Registration success!']")
    MobileElement popUpRegSuccess;
    @FindBy(xpath = "//*[@text='Login success!']")
    MobileElement popUpLoginSuccess;

    //=================
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLocation']")
    MobileElement fieldLocation;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editFrom']")
    MobileElement fieldDateFrom;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editTo']")
    MobileElement fieldDateTo;

    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement buttonCalendarOk;
    public SearchScreen clickDots() {
        click(buttonDots);
//        new WebDriverWait(driver,7)
//                .until(ExpectedConditions.elementToBeClickable(buttonDots)).click();
        return this;
    }

    public RegistrationScreen clickRegistration() {
        click(buttonRegistration);
        return new RegistrationScreen(driver);
    }

    public boolean validatePopUpRegSuccess(){
        return isElementPresentByText(popUpRegSuccess, "Registration success!", 7);
    }
    public boolean validatePopUpLoginSuccess(){
        return isElementPresentByText(popUpLoginSuccess, "Login success!", 7);
    }

    public SearchScreen logout() {
        System.out.println("---> "+buttonLogout.getText());
        click(buttonLogout);
        return this;
    }

    public LoginScreen clickLogin() {
        click(buttonLogin);
        return new LoginScreen(driver);
    }

    public SearchScreen typeFindCarForm(String city, String dateFrom, String dateTo) {
        type(fieldLocation, city );
        click(fieldDateFrom);
        typeCalendar(dateFrom);
        return this;
    }

    private SearchScreen typeCalendar(String date) {  //xpath	//android.view.View[@content-desc='22 March 2024']
        String [] dateArr = date.split("/");
        String calendarDate = String.format("//android.view.View[@content-desc='%s']",
                dateArr[0]+" "+dateArr[1]+" "+dateArr[2]);
        System.out.println(calendarDate);
        MobileElement elementDateClick = driver.findElement(By.xpath(calendarDate));
        click(elementDateClick);
        click(buttonCalendarOk);
        return this;
    }
}
