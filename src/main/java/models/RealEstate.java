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
    public String rcNumber;
    public String area;
    public String addressNumber;
    public String action;
    public boolean exchange;
    public boolean auction;

    public RealEstate (String municipality, String city, String microdistrict, String street,
                      String discription, String picture, String url, String threeDtour, String price,
                      String phone, String email,
                      boolean emailCheckBox, boolean chatCheckBox, boolean rulesCheckBox,
                      String rcNumber, String area, String addressNumber, String action, boolean exchange, boolean auction) {

        this.municipality = municipality.toLowerCase();
        this.city = city.toLowerCase();
        this.microdistrict = microdistrict.toLowerCase();
        this.street = street.toLowerCase();
        this.discription = discription;
        this.picture = "C:\\Users\\Public\\Pictures\\Sample Pictures\\" + picture;
        this.url = url;
        this.threeDtour = threeDtour;
        this.price = price;
        this.phone = phone;
        this.email = email;
        this.emailCheckBox = emailCheckBox;
        this.chatCheckBox = chatCheckBox;
        this.rulesCheckBox = rulesCheckBox;
        this.rcNumber = rcNumber;
        this.addressNumber = addressNumber;
        this.area = area;
        this.action = action.toLowerCase();
        this.exchange = exchange;
        this.auction = auction;
        driver = Helper.driver;
    }

    public void fillAdvertForm() {
        setLocation(0, municipality);
        setLocation(1, city);
        setLocation(2, microdistrict);
        setLocation(3, street);
        setAddressNumber();
        setRcNumber();
        setArea();
        setAction();
        setDiscription();
        uploadpicture();
        uploadUrl();
        uploadThreeDtour();
        setPrice();
        setPhone();
        setEmail();
        clickEmailContact();
        clickChatContakt();
        clickRulesAgreement();
        setDetails();
    }

    public void submit() {
        driver.findElement(By.id("submitFormButton")).click();
    }

    public void setAddressNumber() {
        driver.findElement(By.name("FHouseNum")).sendKeys(addressNumber);
    }

    public void setArea() {
        driver.findElement(By.name("FAreaOverAll")).sendKeys(area);
    }

    public void setRcNumber() {
        driver.findElement(By.name("RCNumber")).sendKeys(rcNumber);
    }

    public void setAction() {
        List<WebElement> opt = driver.findElements(By.className("input-button-text"));
        for (WebElement op : opt) {
            if (op.getText().toLowerCase().contains(action)) {
                System.out.println(op.getText());
                op.click();
                break;
            }
        }

    }

    public void setLocation (int pos, String location) {
        try {
            WebElement span = driver.findElements(By.className("input-style-dropdown")).get(pos);
            Thread.sleep(500);
            span.findElement(By.className("dropdown-input-value-title")).click();
            WebElement ul = span.findElement(By.className("dropdown-input-values-address"));
            if (ul.findElements(By.tagName("input")).isEmpty()) {
                for (WebElement li : ul.findElements(By.tagName("li"))) {
                    if (li.getText().toLowerCase().contains(location)) {
                        li.click();
                        break;
                    }
                }
            } else {
                int count = ul.findElements(By.tagName("li")).size();
                ul.findElement(By.tagName("input")).sendKeys(location);
                while (true) {
                    List<WebElement> lis = ul.findElements(By.tagName("li"));
                    if (count != lis.size()) {
                        lis.get(lis.size() - 1).click();
                        break;
                    }
                }


            }
        } catch (Exception e) {
        }
    }

    public void setDiscription() {
        driver.findElement(By.name("notes_lt")).sendKeys(discription);
    }

    public void uploadpicture() { driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input")).sendKeys(this.picture);}

    public void uploadUrl() {
        driver.findElement(By.name("Video")).sendKeys(this.url);
    }

    public void uploadThreeDtour() {
        driver.findElement(By.name("tour_3d")).sendKeys(this.threeDtour);
    }

    public void setPrice() {
        driver.findElement(By.id("priceField")).sendKeys(price);
    }

    public void setPhone() {
        driver.findElement(By.name("phone")).sendKeys(phone);
    }

    public void setEmail() {
        driver.findElement(By.name("email")).sendKeys(email);
    }

    public void clickEmailContact() {
        List<WebElement> list = driver.findElements(By.tagName("li"));
        list.get(list.size() - 5).findElement(By.tagName("span")).click();
    }

    public void clickChatContakt() {
        List<WebElement> list = driver.findElements(By.tagName("li"));
        list.get(list.size() - 4).findElement(By.tagName("span")).click();
    }

    public void clickRulesAgreement() {
        List<WebElement> list = driver.findElements(By.tagName("li"));
        list.get(list.size() - 3).findElement(By.xpath("//*/span[1]/div/div/label/span")).click();
    }

    public void setDetails() {
        driver.findElement(By.id("showMoreFields")).click();
        if (exchange == true) {
            driver.findElement(By.xpath("//label[contains(@for,'cbInterestedChange')]")).click();
        }
        if (auction == true) {
            driver.findElement(By.xpath("//label[contains(@for,'cbAuction')]")).click();
        }
    }
}
