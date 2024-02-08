package tests;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationPositiveTest(){
        int i = new Random().nextInt(1000);
        UserDTO user = UserDTO.builder()
                .email("frodo_baggins"+i+"@mail.com")
                .name("Frodo")
                .lastName("Bagggins")
                .password("Qwerty123!_")
                .build();
        Assert.assertTrue(new SplashScreen(driver)
                .goToSearchScreen()
                .clickDots()
                .clickRegistration()
                .typeRegistrationForm(user)
                .clickYallaPositive()
                .validatePopUpRegSuccess())
        ;
    }
}
