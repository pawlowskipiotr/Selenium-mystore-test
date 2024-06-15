package pl.coderslab.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.coderslab.Helpers;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


public class OrderInformation {

    public OrderInformation(WebDriver driver) {
        PageFactory.initElements(Helpers.getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(text(),'Your order on mystore-testlab.coderslab.pl is complete.')]")
    WebElement OrderConfirmedMessage;

    public void confirmationOfOrderMessage() {
        Assertions.assertEquals("Your order on mystore-testlab.coderslab.pl is complete.", OrderConfirmedMessage.getText());
    }

    public void takingScreenshotOfOrderAndPrice() {
        File screenshot = ((TakesScreenshot) Helpers.getDriver()).getScreenshotAs(OutputType.FILE);
        String myStoreProjectPath = System.getProperty("user.dir");
        File screenshotSaveDestination = new File(myStoreProjectPath, "screenshot.png");

        try {
            Files.copy(screenshot.toPath(), screenshotSaveDestination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
