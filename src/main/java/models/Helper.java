package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Helper {

    public static WebDriver driver;

    public static void acceptCookies() {
        driver.get("https://www.aruodas.lt/ideti-skelbima");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    public static void submit() {
        Helper.driver.findElement(By.id("submitFormButton")).click();
    }
}
