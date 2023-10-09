import models.Helper;
import models.Garage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class GarageTests {
@Test
public void searchGaragePositive(){
    Garage sg = new Garage("Vilnius","Vilniaus","BUk",
            "A. Jakšto", "garazas ",
            "testScenarioCase.png","https://www.youtube.com/watch?v=DMNKqsIkq3I",
            "https://www.youtube.com/watch?v=DMNKqsIkq3I","20000",
            "65000000", "a@kk.vv",true,true,true,
            "Garage","6","1","Pardavimui","Stone","111-111","accos");
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
