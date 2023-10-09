package models;

import org.openqa.selenium.By;

public class Plot extends RealEstate {

    public String action;

    public String purpose;


    public Plot(String municipality, String city, String microdistrict, String street, String discription, String picture, String url, String threeDtour, String price, String phone, String email, boolean emailCheckBox, boolean chatCheckBox, boolean rulesCheckBox, String action, String addressNumber, String rcNumber, String area, String purpose) {
        super(municipality, city, microdistrict, street, discription, picture, url, threeDtour, price, phone, email, emailCheckBox, chatCheckBox, rulesCheckBox, rcNumber, area, addressNumber);
        this.action = action;
        this.purpose = purpose;
    }

    @Override
    public void fillAdvertForm() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11");
        super.fillAdvertForm();
        setAction();
        setPurpose();
        submit();
    }

    public void setAction() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[14]/div/div[1]")).click();
    }

    public void setPurpose() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[1]/label")).click();
    }

}
