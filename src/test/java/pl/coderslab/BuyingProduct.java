package pl.coderslab;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pl.coderslab.pages.*;

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

    @And("the user chooses a product, size and quantity")
    public void theUserChoosesAProductSizeAndQuantity() {

        //wybranie przedmiotu na stronie glownej
        HomePage homePage = new HomePage(driver);
        homePage.selectedProductClick();

        //sprawdzenie poprawnosci naliczania znizki dla produktu, wybor ilosci i rozmiaru produktu
        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.isDiscountAvailable());
        productPage.chooseSizeOfProduct("M");
        productPage.chooseQuantityOfProduct(5);
    }

    @And("the user places it in the cart")
    public void theUserPlacesItInTheCart() {

        //sprawdzenie czy produkt jest dostepny w danej ilosci i rozmiarze - jesli tak to dodawany jest do koszyka
        ProductPage productPage = new ProductPage(Helpers.getDriver());
        productPage.addProductToCartButton();
        productPage.proceedToCheckout();
    }

    @And("the user chooses delivery address and payment method")
    public void theUserChoosesDeliveryAddressAndPaymentMethod() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.proceedToCheckoutButtonClick();
        shoppingCart.choosingDeliveryAddress();
        shoppingCart.choosingShipmentMethod();
        shoppingCart.choosingPaymentMethod();
    }

    @When("the user places the order")
    public void theUserPlacesTheOrder() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.placingTheOrder();
    }

    @Then("the confirmation of transaction is visible")
    public void theConfirmationOfTransactionIsVisible() {
        OrderInformation orderInformation = new OrderInformation(Helpers.getDriver());
        orderInformation.confirmationOfOrderMessage();
    }

    @And("screenshot of confirmation and price is taken")
    public void screenshotOfConfirmationAndPriceIsTaken() {
        OrderInformation orderInformation = new OrderInformation(Helpers.getDriver());
        orderInformation.takingScreenshotOfOrderAndPrice();
    }
}



