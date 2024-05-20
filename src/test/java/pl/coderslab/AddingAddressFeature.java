package pl.coderslab;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.coderslab.pages.*;

import java.util.ArrayList;
import java.util.List;

public class AddingAddressFeature {


    private final WebDriver driver = Helpers.getDriver();
    private final StringBuilder stringBuilder = Helpers.getStringbuilder();
    private List<WebElement> addresses = new ArrayList<>();

    @Given("the user is on the authentication page")
    public void theUserIsOnTheAuthenticationPage() {

        HomePage homePage = new HomePage(Helpers.getDriver());
        homePage.signInButtonClick();
        AuthPage authPage = new AuthPage(driver);
        authPage.checkIfAuthPageVisible(driver);
    }

    @When("the user gives correct login and password and clicks Sign In Button")
    public void theUserGivesCorrectLoginAndPasswordAndClicksSignInButton() {
        AuthPage authPage = new AuthPage(driver);
        authPage.typeEmailIntoEmailInput();
        authPage.typePasswordIntoPasswordInput();
        authPage.clickSignInButtonToLogIn();
    }

    @And("the user clicks Addresses link and wants to create a new address")
    public void theUserClicksAddressesLinkAndWantsToCreateANewAddress() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickAddNewAddressButton();
        MyAddressesPage myAddressesPage = new MyAddressesPage();
        myAddressesPage.createNewAddressButtonClick();
    }


    @And("the user fills {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserFills(String alias, String address, String city, String postalcode, String country, String phone) {
        CreateNewAddressPage createNewAddressPage = new CreateNewAddressPage();

        // wpisywanie danych do formularza dodawania nowego adresu
        createNewAddressPage.fillAlias(alias);
        createNewAddressPage.fillAddress(address);
        createNewAddressPage.fillCity(city);
        createNewAddressPage.fillPostcode(postalcode);
        createNewAddressPage.fillCountry();
        createNewAddressPage.fillPhone(phone);

        //tworzenie ciągu znaków nowego adresu do asercji
        Helpers.shouldMakeStringToAssertAddress(alias, createNewAddressPage.returnFirstAndLastName(), address, city, postalcode, createNewAddressPage.returnCountry(), phone);

    }

    @And("the user clicks save new address button")
    public void theUserClicksSaveNewAddressButton() {
        CreateNewAddressPage createNewAddressPage = new CreateNewAddressPage();
        createNewAddressPage.saveButtonClick();
    }

    @Then("the address should be added And the account should display success message")
    public void theAddressShouldBeAddedAndTheAccountShouldDisplaySuccessMessage() {
        MyAddressesPage myAddressesPage = new MyAddressesPage();

        //asercja -  czy pojawił się alert o dodaniu nowego adresu
        myAddressesPage.checkIfAddressAddedSuccessfully();
        myAddressesPage.checkIfDataIsCorrect(driver);
        Assertions.assertTrue(myAddressesPage.checkIfDataIsCorrect(driver));
    }
}

