package pl.coderslab.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.coderslab.Helpers;

import java.time.Duration;

public class AccountPage {

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // deklaracja Webelementow - newAddressButton występuje gdy nie mamy żadnego adresu przypisanego do konta;
    // anotherAddressButton gdy posiadamy przynajmniej jeden adres
    @FindBy(id = "address-link")
    WebElement newAddressButton;

    @FindBy(id = "addresses-link")
    WebElement anotherAddressButton;

    @FindBy(xpath = "//a[@title='View my customer account']")
    WebElement viewMyCustomerAccount;

    @FindBy(xpath = "//span[contains(text(),'Home')]")
    WebElement myStoreHomeButtonReturnToHomePage;

    // metoda sprawdzająca czy pojawia się button umozliwiajacy tworzenie nowego adresu czy tworzenie kolejnego adresu


    public void clickAddNewAddressButton() {
        //oczekiwanie na element w przypadku załadowania się strony z opcją dodania kolejnego adresu
        WebDriverWait waitForAddAnotherAddressButton = new WebDriverWait(Helpers.getDriver(), Duration.ofSeconds(10));

        //oczekiwanie na element w przypadku załadowania się strony z opcją dodania nowego adresu
        WebDriverWait waitForAddNewAddressButton = new WebDriverWait(Helpers.getDriver(), Duration.ofSeconds(10));

        if (anotherAddressButton.isDisplayed()) {
            viewMyCustomerAccount.click();
            waitForAddAnotherAddressButton.until(ExpectedConditions.visibilityOf(anotherAddressButton));
            anotherAddressButton.click();
        } else {
            viewMyCustomerAccount.click();
            waitForAddNewAddressButton.until(ExpectedConditions.visibilityOf(newAddressButton));
            newAddressButton.click();
        }

    }
    public void returnToHomePage() {
        myStoreHomeButtonReturnToHomePage.click();
    }

}
