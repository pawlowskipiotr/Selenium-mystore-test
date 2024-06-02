package pl.coderslab;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Helpers {


    private static final String webURL = "https://mystore-testlab.coderslab.pl/";

    private static WebDriver driver;
    private static StringBuilder stringbuilder;

    public static WebDriver getDriver() {
        return driver;
    }

    public static StringBuilder getStringbuilder() {
        return stringbuilder;
    }

    //metoda tworząca obiekt Stringbuilder - wykorzystywana do pobierania danych podczas wypełniania formularza
    // nowego adresu
    public static void shouldMakeStringToAssertAddress(String alias, String firstandlastname, String address,
                                                       String city, String postalcode, String country, String phone) {
        stringbuilder = new StringBuilder();
        stringbuilder.append(alias).append("\n");
        stringbuilder.append(firstandlastname).append("\n");
        stringbuilder.append(address).append("\n");
        stringbuilder.append(city).append("\n");
        stringbuilder.append(postalcode).append("\n");
        stringbuilder.append(country).append("\n");
        stringbuilder.append(phone).append("\n");
    }

    public static boolean checkIfElementClickable(WebElement webElement) {
        return webElement.isEnabled();
    }


    //metoda pobierająca liczbę z WebElementu

    public static String getNumberFromWebElement(WebElement webElement){
        String result;
        String element = webElement.getText();
        result = element.replaceAll("[^\\d.]", "");

        return result;
    }



    //---------------------- metody wywoływane przed i po każdym scenariuszu
    @Before
    public static void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(webURL);
    }

    @After
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
//---------------------- koniec metod wywoływanych przed i po każdym scenariuszu
}
