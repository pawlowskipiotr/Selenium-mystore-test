package pl.coderslab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    WebElement signInButton;

    @FindBy(xpath = "//a[contains(text(),'sweater')]")
    WebElement selectedProduct;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void signInButtonClick() {
        signInButton.click();
    }

    public void selectedProductClick() {
        selectedProduct.click();
    }

}
