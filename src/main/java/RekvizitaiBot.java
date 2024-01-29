import models.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class RekvizitaiBot {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rekvizitai.vz.lt/imones/kompiuteriu_programines_irangos_kurimas/vilnius/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.findElement(By.id("sas_labelClose_12048483")).click();
        driver.findElement(By.id("cookiescript_accept")).click();

        for (int p = 1; p < 2; p++) {

            for (int i = 6; i < 16; i++) {
            List<WebElement> companiesList = driver.findElements(By.className("company-title"));
                System.out.println(companiesList.get(i).getText() + "; i = " + i);
                companiesList.get(i).click();
                driver.findElement(By.xpath("//button[contains(@data-target,'#contactByEmail')]")).click();
                driver.findElement(By.id("email")).sendKeys("romas.cpservisas@gmail.com");
                driver.findElement(By.id("text")).sendKeys(
                        "Hello, my name is Roman \n" +
                                " \n" +
                                "I recently finished Manual & Automation Software Testing Course at Vilnius Coding School and I’m looking for a job as a Junior QA position. \n" +
                                " \n" +
                                "I have basic knowledge in the following areas: \n" +
                                "    Manual testing; \n" +
                                "    Test automation; \n" +
                                "    Test cases and test scenarios;\n" +
                                "    Java; \n" +
                                "    Selenium; \n" +
                                "    TestNG;\n" +
                                "    Postman; \n" +
                                "    Swagger; \n" +
                                "    SQL; \n" +
                                "    GitHub; \n" +
                                "    HTTPS, TCP/IP, HTML, CSS, Chrome DevTools, JSON, XML.\n" +
                                " \n" +
                                "Thank you for your time and consideration of my candidacy.\n" +
                                " \n" +
                                "Best regards\n" +
                                "Roman Urbanovič\n" +
                                "+37062200464\n" +
                                "romas.cpservisas@gmail.com\n");
                driver.findElement(By.xpath("//*[@id=\"formContactByEmail\"]/button/span")).click();
//                driver.findElement(By.xpath("//*[@id=\"contactByEmail\"]/div/div/button")).click();
                driver.navigate().back();
            }
//            System.out.println(companiesList.size());
//            driver.navigate().to("https://rekvizitai.vz.lt/imones/kompiuteriu_programines_irangos_kurimas/vilnius/" + p);
        }


    }
}
