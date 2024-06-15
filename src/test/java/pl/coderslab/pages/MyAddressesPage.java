package pl.coderslab.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.coderslab.Helpers;

import java.time.Duration;
import java.util.List;

public class MyAddressesPage {

    @FindBy(xpath = "//span[contains(text(),'Create new address')]")
    WebElement createNewAddressButton;

    @FindBy(xpath = "//li[contains(text(),'Address successfully added!')]")
    WebElement addressAddedAlert;

    @FindBy(className = "address")
    WebElement addressField;

    public MyAddressesPage() {
        PageFactory.initElements(Helpers.getDriver(), this);
    }

    public void createNewAddressButtonClick() {

        WebDriverWait webDriverWait = new WebDriverWait(Helpers.getDriver(), Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(createNewAddressButton));

        createNewAddressButton.click();
    }

    //Sprawdznenie czy pojawił się alert o sukcesie dodawania nowego adresu
    public void checkIfAddressAddedSuccessfully() {
        Assertions.assertEquals("Address successfully added!", addressAddedAlert.getText());
    }

    //Metoda sprawdzająca czy dwa obiekty StringBuilder posiadają te same ciągi znaków
    public boolean checkIfDataIsCorrect(WebDriver driver) {

        List<WebElement> addresses = driver.findElements(By.className("address"));
        StringBuilder addressShownOnMyAddressesPage = new StringBuilder();
        boolean areStringsSimiliar;

        //Stringbuilder zawierający pobrany ciag znakow z danych wprowadzanych w formularzu podczas dodawania nowego adresu
        StringBuilder addressGivenWhenAddingNewAddress = Helpers.getStringbuilder();

        //Stringbuilder zawierający ciąg znaków utworzony z wszystkich adresów w zakładce Addresses
        for (WebElement address : addresses) {
            addressShownOnMyAddressesPage.append(address.getText());
        }

        // Sprawdzenie czy jeden ciąg znaków zawiera się w drugim
        areStringsSimiliar = addressShownOnMyAddressesPage.toString().contains(addressGivenWhenAddingNewAddress.toString());
        return areStringsSimiliar;
    }
}
