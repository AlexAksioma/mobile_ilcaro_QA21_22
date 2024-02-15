package tests;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.SearchScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    boolean flagIsUserLogin = false;
    boolean flagIsErrorMessageDisplays = false;

    @Test
    public void loginPositiveTest() {
        UserDTO user = UserDTO.builder()
                .email("alexmedqwerty@gmail.com")
                .password("Qwerty12345!")
                .build();
        flagIsUserLogin = true;
        Assert.assertTrue(new SplashScreen(driver)
                .goToSearchScreen()
                .clickDots()
                .clickLogin()
                .typeLoginForm(user)
                .clickButtonYallaPositiveActions()
                .validatePopUpLoginSuccess())
        ;
    }

    @Test
    public void loginNegativeTest_wrongPassword() {
        UserDTO user = UserDTO.builder()
                .email("alexmedqwerty@gmail.com")
                .password("Qwerty12345")
                .build();
        flagIsErrorMessageDisplays = true;
        Assert.assertTrue(
                new SplashScreen(driver)
                        .goToSearchScreen()
                        .clickDots()
                        .clickLogin()
                        .typeLoginForm(user)
                        .clickButtonYallaNegativeActions()
                        .validatePopUpErrorMessage())
        ;
    }

    @AfterMethod
    public void afterTest() {
        if (flagIsErrorMessageDisplays && !flagIsUserLogin) {
            flagIsErrorMessageDisplays = false;
            flagIsUserLogin = true;
            new LoginScreen(driver)
                    .clickButtonOkErrorMessage()
                    .typeLoginForm(UserDTO.builder()
                            .email("alexmedqwerty@gmail.com")
                            .password("Qwerty12345!")
                            .build())
                    .clickButtonYallaPositiveActions()
            ;
        }
        if (flagIsUserLogin) {
            new SearchScreen(driver)
                    .clickDots()
                    .logout();
            flagIsUserLogin = false;

        }
    }
}
