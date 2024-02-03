import models.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class RekvizitaiBot {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rekvizitai.vz.lt/imones/kompiuteriu_programines_irangos_kurimas/vilnius/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("cookiescript_accept")).click();
        int last = 48;

        for (int p = 47; p < last; p++) {
            driver.navigate().to("https://rekvizitai.vz.lt/imones/kompiuteriu_programines_irangos_kurimas/vilnius/" + p);
            List<WebElement> companiesList = driver.findElements(By.className("titles-block"));
            System.out.println("Page nr " + p);
            System.out.println(companiesList.size());
            for (int i = 0; i < companiesList.size(); i++) {
                companiesList = driver.findElements(By.className("titles-block"));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                Thread.sleep(1000);
                companiesList.get(i).click();

                try {
                    driver.findElement(By.xpath("//button[contains(@data-target,'#contactByEmail')]")).click();
                } catch (Exception e) {
                    System.out.println(i + " - no email");
                    driver.navigate().to("https://rekvizitai.vz.lt/imones/kompiuteriu_programines_irangos_kurimas/vilnius/" + p);
                    continue;
                }

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

                driver.findElement(By.xpath("//*[@id=\"formContactByEmail\"]/button")).click();

                try {
                    new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/div[4]/div[2]/iframe")));
                    String stop = driver.findElement(By.id("rc-imageselect")).getText();
                    if (stop != null) {
                        Thread.sleep(30000);
                        System.out.println("Stop on i = " + i);
                        Thread.sleep(1000);
                        driver.navigate().to("https://rekvizitai.vz.lt/imones/kompiuteriu_programines_irangos_kurimas/vilnius/" + p);
//                        p = last;
//                        break;
                    }
                } catch (Exception e) {
                    System.out.println("i = " + i);
                    Thread.sleep(1000);
                    driver.navigate().to("https://rekvizitai.vz.lt/imones/kompiuteriu_programines_irangos_kurimas/vilnius/" + p);
                }
            }
        }
    }
}
