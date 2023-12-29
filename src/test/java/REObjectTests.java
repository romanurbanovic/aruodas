import models.Helper;
import models.REObject;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.time.Duration;

public class REObjectTests {

    @Test
    public void searchRealEstatePositive() {
        REObject re = new REObject("Vilnius", "Vilniaus", "BUk",
                "A. Jakšto", "2 kambariu butas",
                "Hydrangeas.jpg", "https://www.youtube.com/watch?v=DMNKqsIkq3I",
                "https://www.youtube.com/watch?v=DMNKqsIkq3I", "160000",
                "862200000", "a@kk.vv", true, true, true, true, true, "patalp");
        re.fillAdvertForm();
        Helper.submit();
        String actual = Helper.driver.findElement(By.id("btPlanChooseOrder")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void searchRealEstateNoPhoneNumber() throws InterruptedException {
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
    public void searchRealEstateNo6startingPhoneNumber() throws InterruptedException {
        REObject re = new REObject("Vilnius", "Vilniaus", "BUk",
                "A. Jakšto", "2 kambariu butas",
                "Hydrangeas.jpg", "https://www.youtube.com/watch?v=DMNKqsIkq3I",
                "https://www.youtube.com/watch?v=DMNKqsIkq3I", "160000",
                "802200000", "a@kk.vv", true, true, true, true, true, "patalp");
        re.fillAdvertForm();
        Helper.submit();
        Thread.sleep(200);
        String actual = Helper.driver.findElement(By.xpath("//span[@class=\"input-style-phone input-width-wide\"]/following::span[1]")).getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
    }

    @Test
    public void searchRealEstate8digitPhoneNumber() {
        REObject re = new REObject("Vilnius", "Vilniaus", "BUk",
                "A. Jakšto", "2 kambariu butas",
                "Hydrangeas.jpg", "https://www.youtube.com/watch?v=DMNKqsIkq3I",
                "https://www.youtube.com/watch?v=DMNKqsIkq3I", "160000",
                "86220000", "a@kk.vv", true, true, true, true, true, "patalp");
        re.fillAdvertForm();
        String actual = Helper.driver.findElement(By.xpath("//*[contains(text(), 'Neteisingas telefono numeris')]")).getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
        Helper.submit();
    }

    @Test
    public void searchRealEstate10digitPhoneNumber() {
        REObject re = new REObject("Vilnius", "Vilniaus", "BUk",
                "A. Jakšto", "2 kambariu butas",
                "Hydrangeas.jpg", "https://www.youtube.com/watch?v=DMNKqsIkq3I",
                "https://www.youtube.com/watch?v=DMNKqsIkq3I", "160000",
                "8622000000", "a@kk.vv", true, true, true, true, true, "patalp");
        re.fillAdvertForm();
        String actual = Helper.driver.findElement(By.xpath("//*[contains(text(), 'Neteisingas telefono numeris')]")).getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
        Helper.submit();
    }

    @Test
    public void searchRealEstateLetterPhoneNumber() {
        REObject re = new REObject("Vilnius", "Vilniaus", "BUk",
                "A. Jakšto", "2 kambariu butas",
                "Hydrangeas.jpg", "https://www.youtube.com/watch?v=DMNKqsIkq3I",
                "https://www.youtube.com/watch?v=DMNKqsIkq3I", "160000",
                "86000000l", "a@kk.vv", true, true, true, true, true, "patalp");
        re.fillAdvertForm();
        String actual = Helper.driver.findElement(By.xpath("//*[contains(text(), 'Neteisingas telefono numeris')]")).getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
        Helper.submit();
    }

    @Test
    public void searchRealEstateSpecCharPhoneNumber() {
        REObject re = new REObject("Vilnius", "Vilniaus", "BUk",
                "A. Jakšto", "2 kambariu butas",
                "Hydrangeas.jpg", "https://www.youtube.com/watch?v=DMNKqsIkq3I",
                "https://www.youtube.com/watch?v=DMNKqsIkq3I", "160000",
                "86+200000", "a@kk.vv", true, true, true, true, true, "patalp");
        re.fillAdvertForm();
        String actual = Helper.driver.findElement(By.xpath("//*[contains(text(), 'Neteisingas telefono numeris')]")).getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
        Helper.submit();
    }

    @Test
    public void searchRealEstateNotValidPhoneNumber() throws InterruptedException {
        REObject re = new REObject("Vilnius", "Vilniaus", "BUk",
                "A. Jakšto", "2 kambariu butas",
                "Hydrangeas.jpg", "https://www.youtube.com/watch?v=DMNKqsIkq3I",
                "https://www.youtube.com/watch?v=DMNKqsIkq3I", "160000",
                "+9716200", "a@kk.vv", true, true, true, true, true, "patalp");
        re.fillAdvertForm();
        String actual = Helper.driver.findElement(By.xpath("//span[@class=\"input-style-phone input-width-wide\"]/following::span[1]")).getText();
        Helper.softAssert.assertEquals(actual, "Neteisingas telefono numeris");
        Helper.submit();
        Helper.softAssert.assertAll();
    }

    @Test
    public void phoneTest()  {
        Helper.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=10");
        String[] specChar = { "+", "-", "&&", "||", "!", "(", ")", "{", "}", "[", "]", "^",
                "~", "*", "?", ":", "\"", "\\" };
            Helper.driver.findElement(By.name("phone")).clear();
        for (String spср:specChar) {
            Helper.driver.findElement(By.name("phone")).sendKeys(spср);
//            String actual = Helper.driver.findElement(By.xpath("//span[@class=\"input-style-phone input-width-wide\"]/following::span[1]")).getText();
//            Helper.softAssert.assertEquals(actual, "Neteisingas telefono numeris");
        }
//        Helper.softAssert.assertAll();
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
