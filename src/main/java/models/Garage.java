package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Garage extends RealEstate {

    public String type;
    public String make;
    public String accommodates;
    public String[] feature;

    public Garage(String municipality, String city, String microdistrict, String street, String discription, String picture,
                  String url, String threeDtour, String price, String phone, String email, boolean emailCheckBox,
                  boolean chatCheckBox, boolean rulesCheckBox, String rcNumber, String area, String addressNumber,
                  String action, boolean exchange, boolean auction, String type, String make, String accommodates,
                  String[] feature) {
        super(municipality, city, microdistrict, street, discription, picture, url, threeDtour, price, phone, email,
                emailCheckBox, chatCheckBox, rulesCheckBox, rcNumber, area, addressNumber, action, exchange, auction);
        this.type = type.toLowerCase();
        this.make = make.toLowerCase();
        this.accommodates = accommodates;
        this.feature = feature;
    }

    @Override
    public void fillAdvertForm() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=13");
        super.fillAdvertForm();
        setType();
        setMake();
        setAccommodates();
        setFeatures();
        //    submit();
    }

    public void setMake() {
        if (type.contains("gar")) {
        if (make.contains("mu")) {
            driver.findElement(By.xpath("//div[contains(@data-title,'Mūrinis')]")).click();
        } else if (make.contains("gel")) {
            driver.findElement(By.xpath("//div[contains(@data-title,'Geležinis')]")).click();
        } else if (make.contains("po")) {
                driver.findElement(By.xpath("//div[contains(@data-title,'Požeminis')]")).click();
        } else if (make.contains("daug")) {
                driver.findElement(By.xpath("//div[contains(@data-title,'Daugiaaukštis')]")).click();
        } else {
                driver.findElement(By.xpath("//div[contains(@data-title,'Kita')]")).click();
        }
        } else if (type.contains("viet")) {
            if (make.contains("pož")) {
                driver.findElement(By.xpath("//div[contains(@data-title,'Požeminėje aikštelėje')]")).click();
            } else if (make.contains("ant")) {
                driver.findElement(By.xpath("//div[contains(@data-title,'Antžeminėje aikštelėje')]")).click();
            } else if (make.contains("daug")) {
                driver.findElement(By.xpath("//div[contains(@data-title,'Daugiaaukštėje aikštelėje')]")).click();
            } else if (make.contains("kit")) {
                driver.findElement(By.xpath("//div[contains(@data-title,'Kita')]")).click();
            }
        }
    }

    public void setAccommodates() {
        switch (accommodates) {
            case "1":
                driver.findElement(By.xpath("//div[contains(@data-title,'1')]")).click();
                break;
            case "2":
                driver.findElement(By.xpath("//div[contains(@data-title,'2')]")).click();
                break;
            case "3":
                driver.findElement(By.xpath("//div[contains(@data-title,'3')]")).click();
                break;
            case "4":
                driver.findElement(By.xpath("//div[contains(@data-title,'4')]")).click();
                break;
            default:
                driver.findElement(By.xpath("//input[contains(@placeholder,'Įveskite')]")).sendKeys(accommodates);
                break;
        }
    }

    public void setType() {
        if (type.contains("viet")) {
            driver.findElement(By.xpath("//label[contains(@for,'parking_parking')]")).click();
        } else {
            driver.findElement(By.xpath("//label[contains(@for,'parking_garage')]")).click();
        }
    }

    public void setFeatures() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[22]/div"));
        List<WebElement> det = driver.findElements(By.xpath("//label[contains(@for,'cb_FGarageFeatures')]"));
        for (WebElement details : det) {
            for (int i = 0; i < feature.length; i++) {

                if (details.getText().contains(feature[i])) {
                    System.out.println(details.getText());
                    details.click();
                }
            }
        }
    }
}

