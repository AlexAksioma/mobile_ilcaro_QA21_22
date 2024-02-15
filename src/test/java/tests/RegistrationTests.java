package tests;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.RegistrationScreen;
import screens.SearchScreen;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {
    RegistrationScreen registrationScreen;

    @BeforeClass
    public void beforeClass() {
        registrationScreen = new SplashScreen(driver)
                .goToSearchScreen()
                .clickDots()
                .clickRegistration();
    }
//    @BeforeMethod
//    public void beforeMethod(){
//        new SearchScreen(driver).clickDots().clickRegistration();
//    }

    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000);
        UserDTO user = UserDTO.builder()
                .email("frodo_baggins" + i + "@mail.com")
                .name("Frodo")
                .lastName("Bagggins")
                .password("Qwerty123!_")
                .build();
        Assert.assertTrue(registrationScreen.typeRegistrationForm(user)
                .clickYallaPositive()
                .validatePopUpRegSuccess())
        ;
    }

    @Test
    public void registrationNegativeTest_wrongEmail() {
        int i = new Random().nextInt(1000);
        UserDTO user = UserDTO.builder()
                .email("frodo_baggins" + i + "mail.com")
                .name("Frodo")
                .lastName("Bagggins")
                .password("Qwerty123!_")
                .build();
        Assert.assertTrue(registrationScreen.typeRegistrationForm(user)
                .clickYallaNegative()
                .validatePopUpReg_wrongEmail())
        ;

    }

    @AfterMethod
    public void afterTest() {
        if (registrationScreen.validatePopUpReg_wrongEmail()) {
            registrationScreen.clickOkPopUp()
                    .goToSearchPage()
                    .clickDots()
                    .clickRegistration();
        }//
    }
}
