import models.Helper;
import models.Plot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class PlotTests {
 @Test
    public void searchPlotPositve() {
     Plot sp = new Plot ("Vilnius","Vilniaus","BUk",
             "A. Jakšto", "sklypas ",
             "testScenarioCase.png","https://www.youtube.com/watch?v=DMNKqsIkq3I",
             "https://www.youtube.com/watch?v=DMNKqsIkq3I","100000",
             "65000000", "a@kk.vv",true,true,true,
             "4444-4444-4444","40","1234","pard", true,true, new int[] {1,2,4});
     sp.fillAdvertForm();
    }

    @BeforeClass
    public void beforeClass() {
        Helper.driver = new ChromeDriver();
        Helper.driver.manage().window().maximize();
        Helper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Helper.acceptCookies();
    }

    @AfterClass
    public void afterClass() {

    }
}
