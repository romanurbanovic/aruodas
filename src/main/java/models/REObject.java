package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class REObject extends RealEstate {

    public String objectType;

    public REObject(String municipality, String city, String microdistrict, String street, String discription,
                    String picture, String url, String threeDtour, String price, String phone, String email,
                    boolean emailCheckBox, boolean chatCheckBox, boolean rulesCheckBox, boolean exchange, boolean auction, String objectType) {
        super(municipality, city, microdistrict, street, discription, picture, url, threeDtour, price, phone,
                email, emailCheckBox, chatCheckBox, rulesCheckBox, "", "", "", "", exchange, auction);
        this.objectType = objectType.toLowerCase();
    }

    @Override
    public void fillAdvertForm() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=10");
        super.fillAdvertForm();
        setObjectType();
    }

    @Override
    public void setAddressNumber() {

    }

    @Override
    public void setArea() {

    }

    @Override
    public void setRcNumber() {

    }

    @Override
    public void setAction() {

    }

    @Override
    public void setDetails() {

    }

    public void setObjectType() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]")).click();
        List<WebElement> lis = driver.findElements(By.className("dropdown-input-values"));
        for (WebElement li : lis) {
            if (li.getText().toLowerCase().contains(objectType)) {
                li.click();
                break;
            }
        }


    }
}