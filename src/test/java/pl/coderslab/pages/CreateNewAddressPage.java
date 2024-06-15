package pl.coderslab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.coderslab.Helpers;

import java.time.Duration;

public class CreateNewAddressPage {

    public CreateNewAddressPage() {
        PageFactory.initElements(Helpers.getDriver(), this);
    }


    // deklaracja selektora do pobierania imienia i nazwiska potrzebnego do asercji
    @FindBy(css = "#_desktop_user_info > div > a.account > span")
    WebElement firstAndLastName;

    @FindBy(name = "id_country")
    WebElement countryComboMenu;

    //deklaracja selektorów
    @FindBy(id = "field-alias")
    WebElement aliasInput;

    @FindBy(id = "field-address1")
    WebElement addressInput;

    @FindBy(id = "field-city")
    WebElement cityInput;

    @FindBy(id = "field-postcode")
    WebElement postalCodeInput;

    @FindBy(id = "field-id_country")
    WebElement countryInput;

    @FindBy(id = "field-phone")
    WebElement phoneInput;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveNewAddressButton;

    public void fillAlias(String alias) {
        WebDriverWait webDriverWait = new WebDriverWait(Helpers.getDriver(), Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(aliasInput));
        aliasInput.sendKeys(alias);
    }

    public void fillAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void fillCity(String city) {
        cityInput.sendKeys(city);
    }

    public void fillPostcode(String postalcode) {
        postalCodeInput.sendKeys(postalcode);
    }

    //wybranie Wielkiej Brytanii jako jedynego wyboru na stronie
    public void fillCountry() {
        Select select = new Select(countryComboMenu);
        select.selectByValue("17");
    }

    public void fillPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void saveButtonClick() {
        saveNewAddressButton.click();
    }

    public String returnFirstAndLastName() {
        return firstAndLastName.getText();
    }

    // pobranie wyboru
    public String returnCountry() {
        Select select = new Select(countryComboMenu);
        return select.getFirstSelectedOption().getText();
    }

}
