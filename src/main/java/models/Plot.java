package models;

import org.openqa.selenium.By;

public class Plot extends RealEstate {

    public int[] purpose;

    public Plot (String municipality, String city, String microdistrict, String street, String discription, String picture, String url, String threeDtour, String price, String phone, String email, boolean emailCheckBox, boolean chatCheckBox, boolean rulesCheckBox, String action, String addressNumber, String rcNumber, String area, int[] purpose) {
        super(municipality, city, microdistrict, street, discription, picture, url, threeDtour, price, phone, email, emailCheckBox, chatCheckBox, rulesCheckBox, rcNumber, area, addressNumber, action);
        this.purpose = purpose;
    }

    @Override
    public void fillAdvertForm() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11");
        super.fillAdvertForm();
        setPurpose();
        //    submit();
    }

    /**
     * 1 - Namų valda <br>
     * 2 - Daugiabučių statyba
     * 3 - Žemės ūkio
     * 4 - Sklypas soduose
     * 5 - Miško ūkio
     * 6 - Pramonės
     * 7 - Sandėliavimo
     * 8 - Komercinė
     * 9 - Rekreacinė
     * 10 - Kita
     */
    public void setPurpose() {
        for (int i = 0; i < purpose.length; i++) {
            switch (purpose[i]) {
                case 1:
                    driver.findElement(By.xpath("//label[contains(@for,'cb_FIntendance_property')]")).click();
                    break;
                case 2:
                    driver.findElement(By.xpath("//label[contains(@for,'cb_FIntendance_manufacturingland')]")).click();
                    break;
                case 3:
                    driver.findElement(By.xpath("//label[contains(@for,'cb_FIntendance_farm')]")).click();
                    break;
                case 4:
                    driver.findElement(By.xpath("//label[contains(@for,'cb_FIntendance_garden')]")).click();
                    break;
                case 5:
                    driver.findElement(By.xpath("//label[contains(@for,'cb_FIntendance_forest')]")).click();
                    break;
                case 6:
                    driver.findElement(By.xpath("//label[contains(@for,'cb_FIntendance_factory')]")).click();
                    break;
                case 7:
                    driver.findElement(By.xpath("//label[contains(@for,'cb_FIntendance_storage')]")).click();
                    break;
                case 8:
                    driver.findElement(By.xpath("//label[contains(@for,'cb_FIntendance_comm')]")).click();
                    break;
                case 9:
                    driver.findElement(By.xpath("//label[contains(@for,'cb_FIntendance_recr')]")).click();
                    break;
                case 10:
                    driver.findElement(By.xpath("//label[contains(@for,'cb_FIntendance_none')]")).click();
                    break;
            }

        }
    }

}
