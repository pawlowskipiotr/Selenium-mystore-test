package pl.coderslab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.coderslab.Helpers;
import java.time.Duration;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    WebElement signInButton;

    @FindBy(xpath = "//a[contains(text(),'sweater')]")
    WebElement selectedProduct;


    public void signInButtonClick() {
        WebDriverWait wait = new WebDriverWait(Helpers.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }

    public void selectedProductClick() {
        selectedProduct.click();
    }

}
