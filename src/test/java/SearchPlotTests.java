import models.Helper;
import models.SearchPlot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchPlotTests {
 @Test
    public void searchPlotPositve(){
     SearchPlot sp = new SearchPlot("Vilnius","Vilniaus","BUk",
             "A. Jakšto", "sklypas ",
             "testScenarioCase.png","https://www.youtube.com/watch?v=DMNKqsIkq3I",
             "https://www.youtube.com/watch?v=DMNKqsIkq3I","100000",
             "65000000", "a@kk.vv",true,true,true,
             "Pardavimui","12345","4444-4444-4444","40","Namų valda");
     sp.fillAdvertForm();
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
