package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RealEstate {

    public WebDriver driver;

    public String municipality;
    public String city;
    public String microdistrict;
    public String street;
    public String objectTipe;
    public String discription;
    public String picture;
    public String url;
    public String threeDtour;
    public String price;
    public String phone;
    public String email;
    public boolean emailCheckBox;
    public boolean chatCheckBox;
    public boolean rulesCheckBox;


    public RealEstate(String municipality, String city, String microdistrict, String street, String objectTipe,
                      String discription, String picture, String url, String threeDtour, String price,
                      String phone, String email, boolean emailCheckBox, boolean chatCheckBox, boolean rulesCheckBox) {

        this.municipality = municipality;
        this.city = city;
        this.microdistrict = microdistrict.toLowerCase();
        this.street = street;
        this.objectTipe = objectTipe;
        this.discription = discription;
        this.picture = "C:\\Users\\Fiberta\\Desktop\\" + picture;
        this.url = url;
        this.threeDtour = threeDtour;
        this.price = price;
        this.phone = phone;
        this.email = email;
        this.emailCheckBox = emailCheckBox;
        this.chatCheckBox = chatCheckBox;
        this.rulesCheckBox = rulesCheckBox;
        driver = Helper.driver;
    }

    public void fillAdvertForm() throws InterruptedException {
        setMunicipality();
        setCity();
        setMicrodistrict();
        Thread.sleep(5000);
        setStreet();
        setObjectTipe();
        driver.findElement(By.name("notes_lt")).sendKeys(discription);
        driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input")).sendKeys(this.picture);
        driver.findElement(By.name("Video")).sendKeys(this.url);
        driver.findElement(By.name("tour_3d")).sendKeys(this.threeDtour);
        driver.findElement(By.id("priceField")).sendKeys(price);
        driver.findElement(By.name("phone")).sendKeys(phone);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[23]/span/label")).click();
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[24]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[25]/span[1]/div/div/label/span")).click();
        //    driver.findElement(By.id("submitFormButton")).click();
    }

    public void setMunicipality() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[3]/span[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"regionDropdown\"]/li[2]")).click();
    }

    public void setCity() {
        driver.findElement(By.id("districtTitle")).click();
        driver.findElement(By.xpath("//*[@id=\"districts_461\"]/li[2]")).click();
    }

    public void setMicrodistrict() {
//        driver.findElement(By.id("quartalTitle")).click();
//        driver.findElement(By.xpath("//*[@id=\"quartals_1\"]/li[2]")).click();

        WebElement municipalityList = driver.findElement(By.id("quartalTitle"));
        municipalityList.click();
        List<WebElement> md = driver.findElements(By.className("drop-down-value-row"));
        for (WebElement mun : md) {
            if (mun.getText().toLowerCase().contains(microdistrict)) {
                mun.click();
                break;
            }

        }
    }

    public void setStreet() {
        driver.findElement(By.id("streetTitle")).click();
        driver.findElement(By.xpath("//*[@id=\"streets_1\"]/li[5]")).click();
    }

    public void setObjectTipe() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/ul/li[1]")).click();
    }

}
