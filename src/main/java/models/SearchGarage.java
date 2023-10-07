package models;

import org.openqa.selenium.By;

public class SearchGarage extends RealEstate{

    public String type;
    public String garageNumber;
    public String rcNumber;
    public String area;
    public String action;
    public String make;
    public String accomodates;

    public SearchGarage(String municipality, String city, String microdistrict, String street, String discription, String picture, String url, String threeDtour, String price, String phone, String email, boolean emailCheckBox, boolean chatCheckBox, boolean rulesCheckBox, String type, String garageNumber, String rcNumber, String area, String action, String make, String accomodates) {
        super(municipality, city, microdistrict, street, discription, picture, url, threeDtour, price, phone, email, emailCheckBox, chatCheckBox, rulesCheckBox);
        this.type = type;
        this.garageNumber = garageNumber;
        this.rcNumber = rcNumber;
        this.area = area;
        this.action = action;
        this.make = make;
        this.accomodates = accomodates;
    }

    @Override
    public void fillAdvertForm(){
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=13");
        setType();
        setGarageNumber();
        setRcNumber();
        setErea();
        setAction();
        setMake();
        setAccomodates();
        super.fillAdvertForm();

    }

    public void setType(){
        driver.findElement(By.xpath("//*[@id=\"parking_checkbox\"]/div/label/span")).click();
    }
    public void setRcNumber() {
        driver.findElement(By.name("RCNumber")).sendKeys(rcNumber);
    }
    public void setErea() {
        driver.findElement(By.name("FAreaOverAll")).sendKeys(area);
    }
    public void setAction(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[15]/div/div[1]/div[2]")).click();
    }
    public void setGarageNumber() {
        driver.findElement(By.name("FHouseNum")).sendKeys(garageNumber);
    }
    public void setMake(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[1]/div[2]")).click();
    }
    public void setAccomodates(){
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[18]/div/div[1]/div[2]")).click();
    }

}

