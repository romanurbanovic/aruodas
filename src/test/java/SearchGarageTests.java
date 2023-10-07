import models.Helper;
import models.SearchGarage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchGarageTests {
@Test
public void searchGaragePositive(){
    SearchGarage sg = new SearchGarage("Vilnius","Vilniaus","BUk",
            "A. Jakšto", "garazas ",
            "testScenarioCase.png","https://www.youtube.com/watch?v=DMNKqsIkq3I",
            "https://www.youtube.com/watch?v=DMNKqsIkq3I","20000",
            "65000000", "a@kk.vv",true,true,true,
            "Garage","54321","1111-1111-1111","6","Pardavimui","Stone","1");
    sg.fillAdvertForm();
}

@BeforeClass
    public void beforeClass(){
    Helper.driver = new ChromeDriver();
    Helper.driver.manage().window().maximize();
    Helper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    Helper.acceptCookies();
}

@AfterClass
    public void afterClass(){

}
}
