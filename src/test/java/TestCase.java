import Actions.WebElementActions;
import Pages.FalabellaHomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.assertEquals;


public class TestCase {

    WebDriver driver = new ChromeDriver();

    @Before
    public void prepareTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Utils/chromedriver.exe");
        driver.get("https://www.falabella.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //Clean PopUps
        driver.findElement(By.cssSelector(".dy-lb-close")).click();
        Thread.sleep(2000);
        String script = "document.querySelector(\"body > div.airship-html-prompt-shadow\").shadowRoot.querySelector" +
                "(\"div > div > div.airship-alert-buttons > button.airship-btn.airship-btn-deny\").click()";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
        Thread.sleep(2000);
    }

    @Test
    public void FalabellaTestCasePrices() throws InterruptedException {
        //Instances
        FalabellaHomePage FalabellaHomePage = new FalabellaHomePage(driver);
        WebElementActions WebElementActions = new WebElementActions(driver);

        //Click on Menu
        FalabellaHomePage.clickMenu();
        Thread.sleep(2000);
        //Navigate Menu
        FalabellaHomePage.clickCategoryMenu("//*[contains(text(),'Vacaciones')]");
        Thread.sleep(2000);
        FalabellaHomePage.clickSubMenu("//*[contains(text(),'Bebidas')]");
        Thread.sleep(2000);
        //Select and Add Item to the basket
        WebElementActions.scrollDown(500);
        WebElementActions.clickOnElementByXpath("//*[contains(text(),'Bebida Energetica Red Bull Regular')]");
        WebElementActions.clickOnElementByXpath("//*[contains(text(),'Agregar al Carro')]");
        Thread.sleep(2000);
        WebElementActions.clickOnElementByXpath("//*[contains(text(),'Ir al Carro')]");
        Thread.sleep(2000);

        //Obtain product price
        String productPrice = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[2]/div/div[2]/div/ul/li/div/div[2]/div[1]/div[2]/span")).getText();
        //Obtain total price
        String totalPrice = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[2]/div/div[2]/div/ul/li/div/div[2]/div[2]/div[2]/span")).getText();

        //Validate if the prices are equals
        assertEquals(productPrice,totalPrice);

        //Closing browser session
        driver.quit();
    }

}
