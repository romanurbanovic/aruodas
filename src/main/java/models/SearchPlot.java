package models;

import org.openqa.selenium.By;

public class SearchPlot extends RealEstate {

    public String action;
    public String plotNumber;
    public String rcNumber;
    public String erea;
    public String purpose;


    public SearchPlot(String municipality, String city, String microdistrict, String street, String discription, String picture, String url, String threeDtour, String price, String phone, String email, boolean emailCheckBox, boolean chatCheckBox, boolean rulesCheckBox, String action, String plotNumber, String rcNumber, String erea, String purpose) {
        super(municipality, city, microdistrict, street, discription, picture, url, threeDtour, price, phone, email, emailCheckBox, chatCheckBox, rulesCheckBox);
        this.action = action;
        this.plotNumber = plotNumber;
        this.rcNumber = rcNumber;
        this.erea = erea;
        this.purpose = purpose;
    }

    @Override
    public void fillAdvertForm() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11");
        setAction();
        setPlotNumber();
        setRcNumber();
        setErea();
        setPurpose();
        super.fillAdvertForm();
    }

    public void setAction() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[14]/div/div[1]")).click();
    }

    public void setPlotNumber() {
        driver.findElement(By.name("FHouseNum")).sendKeys(plotNumber);
    }

    public void setRcNumber() {
        driver.findElement(By.name("RCNumber")).sendKeys(rcNumber);
    }

    public void setErea() {
        driver.findElement(By.name("FAreaOverAll")).sendKeys(erea);
    }

    public void setPurpose() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[1]/label")).click();
    }

}
