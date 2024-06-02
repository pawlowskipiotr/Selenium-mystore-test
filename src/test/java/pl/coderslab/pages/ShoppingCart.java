package pl.coderslab.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.coderslab.Helpers;

public class ShoppingCart {
    public ShoppingCart() {
        PageFactory.initElements(Helpers.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//div[1]/section[2]/div/div/form/div[1]/article[1]/header/label")
    WebElement myDeliveryAddress;

    @FindBy(name = "confirm-addresses")
    WebElement continueAfterChoosingDeliveryAddress;

    @FindBy(name = "confirmDeliveryOption")
    WebElement continueAfterChoosingShipmentMethod;

    @FindBy(xpath = "//span[contains(text(),'Pick up in-store')]")
    WebElement chooseShipmentMethodRadioButton;

    @FindBy(xpath = "//input[@id='payment-option-1']")
    WebElement choosePaymentMethodRadioButton;

    @FindBy(xpath = "//input[@id='conditions_to_approve[terms-and-conditions]']")
    WebElement agreeingToTermsOfServiceRadioButton;

    @FindBy(xpath = "//button[contains(text(),'Place order')]")
    WebElement placeOrderButton;

    public void proceedToCheckoutButtonClick() {
        proceedToCheckoutButton.click();
    }

    public void choosingDeliveryAddress() {
        Assertions.assertTrue(myDeliveryAddress.isDisplayed());
        myDeliveryAddress.click();
        continueAfterChoosingDeliveryAddress.click();
    }

    public void choosingShipmentMethod() {
        if (chooseShipmentMethodRadioButton.isSelected()) {
            chooseShipmentMethodRadioButton.click();
        } else {
            continueAfterChoosingShipmentMethod.click();
        }
    }

    public void choosingPaymentMethod() {
        choosePaymentMethodRadioButton.click();
        agreeingToTermsOfServiceRadioButton.click();
    }

    public void placingTheOrder() {
        placeOrderButton.click();
    }

}
