package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchRealEstate extends RealEstate {

    public String objectType;

    public SearchRealEstate(String municipality, String city, String microdistrict, String street, String discription, String picture, String url, String threeDtour, String price, String phone, String email, boolean emailCheckBox, boolean chatCheckBox, boolean rulesCheckBox, String objectType) {
        super(municipality, city, microdistrict, street, discription, picture, url, threeDtour, price, phone, email, emailCheckBox, chatCheckBox, rulesCheckBox);
        this.objectType = objectType;
    }

    @Override
    public void fillAdvertForm() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=10");
        super.fillAdvertForm();
        setObjectTipe();
        driver.findElement(By.id("submitFormButton")).click();
    }

    public void setObjectTipe() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/ul/li[7]")).click();
    }
}