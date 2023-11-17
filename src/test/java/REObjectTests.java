import models.Helper;
import models.REObject;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class REObjectTests {

    @Test
    public void searchRealEstatePositive() {
        REObject re = new REObject("Vilnius", "Vilniaus", "BUk",
                "A. Jakšto", "2 kambariu butas",
                "testScenarioCase.png", "https://www.youtube.com/watch?v=DMNKqsIkq3I",
                "https://www.youtube.com/watch?v=DMNKqsIkq3I", "160000",
                "65000000", "a@kk.vv", true, true, true, true, true,"patalp");
        re.fillAdvertForm();
        String actual = Helper.driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, "Užsakyti");
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
