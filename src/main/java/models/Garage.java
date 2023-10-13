package models;

import org.openqa.selenium.By;

public class Garage extends RealEstate{

    public String type;
    public String make;
    public String accommodates;

    public Garage(String municipality, String city, String microdistrict, String street, String discription, String picture, String url, String threeDtour, String price, String phone, String email, boolean emailCheckBox, boolean chatCheckBox, boolean rulesCheckBox, String rcNumber, String area, String addressNumber, String type, String action, String make, String accommodates) {
        super(municipality, city, microdistrict, street, discription, picture, url, threeDtour, price, phone, email, emailCheckBox, chatCheckBox, rulesCheckBox, rcNumber, area, addressNumber, action);
        this.type = type;
        this.make = make;
        this.accommodates = accommodates;
    }

    @Override
    public void fillAdvertForm(){
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=13");
        super.fillAdvertForm();
        setType();
        setMake();
        setAccommodates();
    //    submit();
    }
    public void setMake() {
        switch (make) {
            case "Mūrinis":
                driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[1]/div[2]")).click();
                break;
            case "Geležinis":
                driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[2]/div[2]")).click();
                break;
            case "Požeminis":
                driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[3]/div[2]")).click();
                break;
            case "Daugiaaukštis":
                driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[4]/div[2]")).click();
                break;
            case "Kita":
                driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[5]/div[2]")).click();
                break;
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

    public void setType(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[1]/div[2]")).click();
    }
}

