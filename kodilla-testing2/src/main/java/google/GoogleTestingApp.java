package google;

import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleTestingApp {
    public static final String SEARCHFIELD = "gLFyf"; //stałą o nazwie SEARCHFIELD, przechowującą identyfikator pola input na stronie, które jest kontrolką służącą do wpisywania tekstu do wyszukania w internecie.

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME); //tworzymy Selenium WebDriver i otwieramy stronę www.google.com.
        driver.get("https://www.google.com");

        WebElement searchField = driver.findElement(By.id(SEARCHFIELD)); //wraca ona element typu WebElement na podstawie różnych kryteriów wyszukiwania: identyfikatora, klasy, selektora CSS, wyrażenia xPath (o tym będzie w dalszej części modułu) i innych.
        searchField.sendKeys("Kodilla"); //do znalezionego elementu WebElement wysyłamy zasymulowane przyciśnięcia przycisków klawiatury — wpisujemy w to pole szukaną frazę, czyli wyraz "Kodilla".
        searchField.submit();
    }
}
