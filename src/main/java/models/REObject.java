package models;

import org.openqa.selenium.By;

public class REObject extends RealEstate {

    public String objectType;

    public REObject(String municipality, String city, String microdistrict, String street, String discription, String picture, String url, String threeDtour, String price, String phone, String email, boolean emailCheckBox, boolean chatCheckBox, boolean rulesCheckBox, String objectType) {
        super(municipality, city, microdistrict, street, discription, picture, url, threeDtour, price, phone, email, emailCheckBox, chatCheckBox, rulesCheckBox, "", "","");
        this.objectType = objectType;
    }

    @Override
    public void fillAdvertForm() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=10");
        super.fillAdvertForm();
        setObjectType();
        submit();
    }

    @Override
    public void setAddressNumber(){

    }
    @Override
    public void setArea(){

    }
    @Override
    public void setRcNumber(){

    }

    public void setObjectType() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/ul/li[7]")).click();
    }
}