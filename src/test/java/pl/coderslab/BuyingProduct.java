package pl.coderslab;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pl.coderslab.pages.AccountPage;
import pl.coderslab.pages.AuthPage;
import pl.coderslab.pages.HomePage;

public class BuyingProduct {

    private final WebDriver driver = Helpers.getDriver();

    @Given("the user is on Home Page while he is logged")
    public void theUserIsOnHomePageWhileHeIsLogged() {

        // przejscie na stronę logowania
        HomePage homePage = new HomePage(driver);
        homePage.signInButtonClick();

        //logowanie się użytkownika posiadającego konto
        AuthPage authPage = new AuthPage(driver);
        authPage.checkIfAuthPageVisible(driver);
        authPage.typeEmailIntoEmailInput();
        authPage.typePasswordIntoPasswordInput();
        authPage.clickSignInButtonToLogIn();

        //powrot do HomePage poprzez logo mystore
        AccountPage accountPage = new AccountPage(driver);
        accountPage.returnToHomePage();

    }

    @And("the user chooses a product")
    public void theUserChoosesAProduct() {
        HomePage homePage = new HomePage(driver);
        homePage.selectedProductClick();
    }
}
