import models.Helper;
import models.REObject;
import models.RealEstate;
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
                "Hydrangeas.jpg", "https://www.youtube.com/watch?v=DMNKqsIkq3I",
                "https://www.youtube.com/watch?v=DMNKqsIkq3I", "160000",
                "62200000", "a@kk.vv", true, true, true, true, true, "patalp");
        re.fillAdvertForm();
        Helper.submit();
        String actual = Helper.driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void stsearchRealEstateNoPhoneNumber() throws InterruptedException {
        REObject re = new REObject("Vilnius", "Vilniaus", "BUk",
                "A. Jakšto", "2 kambariu butas",
                "Hydrangeas.jpg", "https://www.youtube.com/watch?v=DMNKqsIkq3I",
                "https://www.youtube.com/watch?v=DMNKqsIkq3I", "160000",
                "", "a@kk.vv", true, true, true, true, true, "patalp");
        re.fillAdvertForm();
        Helper.submit();
        Thread.sleep(200);
        String actual = Helper.driver.findElement(By.xpath("//*[contains(text(), 'Neteisingas telefono numeris')]")).getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
    }

    @Test
    public void stsearchRealEstateNo6startingPhoneNumber() throws InterruptedException {
        REObject re = new REObject("Vilnius", "Vilniaus", "BUk",
                "A. Jakšto", "2 kambariu butas",
                "Hydrangeas.jpg", "https://www.youtube.com/watch?v=DMNKqsIkq3I",
                "https://www.youtube.com/watch?v=DMNKqsIkq3I", "160000",
                "02200000", "a@kk.vv", true, true, true, true, true, "patalp");
        re.fillAdvertForm();
//        Helper.submit();
        Thread.sleep(200);
        String actual = Helper.driver.findElement(By.xpath("//span[@class=\"input-style-phone input-width-wide\"]/following::span[1]")).getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
    }

    @Test
    public void stsearchRealEstate7digitPhoneNumber() {
        REObject re = new REObject("Vilnius", "Vilniaus", "BUk",
                "A. Jakšto", "2 kambariu butas",
                "Hydrangeas.jpg", "https://www.youtube.com/watch?v=DMNKqsIkq3I",
                "https://www.youtube.com/watch?v=DMNKqsIkq3I", "160000",
                "6220000", "a@kk.vv", true, true, true, true, true, "patalp");
        re.fillAdvertForm();
        String actual = Helper.driver.findElement(By.xpath("//*[contains(text(), 'Neteisingas telefono numeris')]")).getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
        Helper.submit();
    }

    @Test
    public void stsearchRealEstate9digitPhoneNumber() {
        REObject re = new REObject("Vilnius", "Vilniaus", "BUk",
                "A. Jakšto", "2 kambariu butas",
                "Hydrangeas.jpg", "https://www.youtube.com/watch?v=DMNKqsIkq3I",
                "https://www.youtube.com/watch?v=DMNKqsIkq3I", "160000",
                "622000000", "a@kk.vv", true, true, true, true, true, "patalp");
        re.fillAdvertForm();
        String actual = Helper.driver.findElement(By.xpath("//*[contains(text(), 'Neteisingas telefono numeris')]")).getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
        Helper.submit();
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
