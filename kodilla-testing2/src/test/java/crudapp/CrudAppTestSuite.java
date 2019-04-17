package crudapp;

import config.WebDriverConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static java.util.stream.Collectors.toList;


public class CrudAppTestSuite {
    private static final String BASE_URL = "https://kszubra.github.io";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTest() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @After
    public void cleanUpAfterTest() {
        driver.close();
    }

    private String createCrudApptestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";

        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);
        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);
        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();

        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream() //uruchomienie strumienia na kolekcji obiektów form, które mają klasę datatable__row. Tagi tej klasy reprezentują kolejne wiersze z danymi na stronie WWW:
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")) //rozpoczyna się od kropki przed slashami, co oznacza wyszukiwanie w kontekście aktualnego elementu (.//), zamiast w całej stronie WWW.
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard
                            = theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });

        Thread.sleep(5000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        final String TRELLO_LOGIN = "ktrello@wp.pl";
        final String TRELLO_PASSWORD = "AfZ29AT5qxkzMD4";
        boolean result = false;

        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL); //otwieramy okno przeglądarki na stronie logowania Trello.

        //dane logowanie + "login"
        driverTrello.findElement(By.id("user")).sendKeys(TRELLO_LOGIN);
        driverTrello.findElement(By.id("password")).sendKeys(TRELLO_PASSWORD);
        driverTrello.findElement(By.id("login")).submit();

        Thread.sleep(2000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//span[@title=\"Kodilla Application\"]")).size() > 0) //odfiltrowujemy tylko takie tagi, które zawierają w sobie taga div o wartości "Kodilla Board"
                .forEach(aHref -> aHref.click()); //kliknięcie w tablicę, aby wejść do jej wnętrza. Powinna być tylko jedna tablica o nazwie "Kodilla Board".

        Thread.sleep(2000);

        result = driverTrello.findElements(By.xpath("//span")).stream() //wyszukujemy wszystkie tagi span na stronie prezentującej listy zadań wewnątrz tablicy.
                .filter(theSpan -> theSpan.getText().contains(taskName)) //odfiltrowuje rezultaty, pozostawiając tylko takie, które zawierają w swoim wnętrzu tekst równy tytułowi zadania, przekazanemu jako parametr.
                .collect(toList())
                .size() > 0;

        driverTrello.close();

        return result;
    }

    private void deleteCrudAppTestTask(String taskName) throws InterruptedException {
        driver.navigate().refresh();
        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement deleteTaskButton
                            = theForm.findElement(By.xpath(".//button[contains(@class, \"data-task-delete-button\")]"));
                    deleteTaskButton.click();
                });

        Thread.sleep(5000);
    }

    @Test
    public void createTrelloCard() throws InterruptedException {
        //Given
        String taskName = createCrudApptestTask();

        //When
        sendTestTaskToTrello(taskName);

        //Then
        Assert.assertTrue(checkTaskExistsInTrello(taskName));

        //Cleanup
        deleteCrudAppTestTask(taskName);
    }
}
