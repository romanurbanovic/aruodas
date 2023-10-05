import models.Helper;
import models.RealEstate;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdNTAruotasTests {

    @Test
    public void adNTAruodasPositive() throws InterruptedException {
           RealEstate re = new RealEstate("Vil","Vilniaus m.","BUk",
                   "A. Jakšto g.", "Butai pirkti", "2 kambariu butas",
                   "testScenarioCase.png","https://www.youtube.com/watch?v=DMNKqsIkq3I",
                   "https://www.youtube.com/watch?v=DMNKqsIkq3I","160000",
                   "65000000", "99999@two.lt",true,true,true);
           re.fillAdvertForm();
    }

    @BeforeClass
    public void beforeClass(){
        Helper.driver = new ChromeDriver();
        Helper.driver.manage().window().maximize();
        Helper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Helper.acceptCookies();
    }

    @BeforeClass
    public void afterClass(){

    }
}
