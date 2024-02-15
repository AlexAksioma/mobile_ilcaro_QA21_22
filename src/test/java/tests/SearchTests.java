package tests;

import config.AppiumConfig;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class SearchTests extends AppiumConfig {

    @Test
    public void searchPositiveTest(){
        new SplashScreen(driver).goToSearchScreen()
                .typeFindCarForm("Haifa", "22/March/2024", "29/March/2024");
    }
}
