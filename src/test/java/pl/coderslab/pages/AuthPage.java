package pl.coderslab.pages;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.Timeout;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Visibility;
import java.time.Duration;
import java.util.concurrent.locks.Condition;

public class AuthPage {

    private final String myLogin = "sele@wp.pl";
    private final String myPassword = "12345";

    //deklaracja klasy PageFactory
    public AuthPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    // deklaracja lokalizatorow

    @FindBy(id = "submit-login")
    WebElement signInButton;
    @FindBy(id = "content")
    WebElement contentFieldOnAuthPage;

    @FindBy(id = "field-email")
    WebElement emailAddressInput;

    @FindBy(id = "field-password")
    WebElement passwordInput;

    @FindBy(xpath = "//span[contains(text(),'Log in to your account')]")
    WebElement checkIfAuthPageIsVisible;

    // wpisanie loginu do formularza logowania
    public void typeEmailIntoEmailInput() {
        emailAddressInput.sendKeys(myLogin);
    }

    // wpisanie hasła do formularza logowania
    public void typePasswordIntoPasswordInput() {
        passwordInput.sendKeys(myPassword);
    }

    // asercja sprawdzająca pojawienie się strony logowania
    public void checkIfAuthPageVisible(WebDriver driver) {
        WebDriverWait waitForAuthPage = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForAuthPage.until(ExpectedConditions.visibilityOf(contentFieldOnAuthPage));
        Assertions.assertEquals("Log in to your account", checkIfAuthPageIsVisible.getText());
    }
    public void clickSignInButtonToLogIn() {
        signInButton.click();
    }

}
