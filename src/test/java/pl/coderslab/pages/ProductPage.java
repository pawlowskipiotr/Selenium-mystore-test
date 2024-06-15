package pl.coderslab.pages;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.coderslab.Helpers;
import java.time.Duration;


public class ProductPage {
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='regular-price']")
    WebElement regularPrice;

    @FindBy(xpath = "//span[@class='current-price-value']")
    WebElement priceAfterDiscount;

    @FindBy(xpath = "//li[@class='product-flag discount']")
    WebElement discount;

    @FindBy(xpath = "//select[@name='group[1]']")
    WebElement chooseSizeComboMenu;

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement chooseQuantity;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//i[@class='material-icons touchspin-up']")
    WebElement changeQuantityButtonUp;

    @FindBy(xpath = "//*[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckOutButton;


    // wybranie ilości kupowanego przedmiotu poprzez nacisniecie buttona zwikszajacego wartosc
    public void chooseQuantityOfProduct(int quantity) {

        for (int i = 0; i < quantity-1; i++) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            changeQuantityButtonUp.click();
        }
    }

    //metoda sprawdzajaca czy po podaniu wszystkich parametrow mozna przeniesc produkt do koszyka
    public void addProductToCartButton() {

        Assertions.assertTrue(Helpers.checkIfElementClickable(addToCartButton));

        if (Helpers.checkIfElementClickable(addToCartButton)) {
            addToCartButton.click();
        }
    }

    //  metoda sprawdzajaca czy produkt objety jest znizka i czy cena po znizce jest zgodna.
    public boolean isDiscountAvailable() {
        WebDriverWait wait = new WebDriverWait(Helpers.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(regularPrice));

        if (discount.isDisplayed()) {
            if (Double.parseDouble(Helpers.getNumberFromWebElement(regularPrice)) *
                    ((100 - Double.parseDouble(Helpers.getNumberFromWebElement(discount))) / 100)
                    == Double.parseDouble(Helpers.getNumberFromWebElement(priceAfterDiscount))) {
                return true;
            } else return false;
        } else return false;
    }

    public void chooseSizeOfProduct(String size) {
        Select select = new Select(chooseSizeComboMenu);
        select.selectByVisibleText(size.toUpperCase());
    }

    public void proceedToCheckout() {
        WebDriverWait webDriverWait = new WebDriverWait(Helpers.getDriver(),Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(proceedToCheckOutButton));
        Assertions.assertTrue(proceedToCheckOutButton.isDisplayed());
        proceedToCheckOutButton.click();
    }

}
