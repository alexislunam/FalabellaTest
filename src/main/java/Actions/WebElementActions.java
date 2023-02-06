package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WebElementActions {

    WebDriver driver;

    public WebElementActions(WebDriver driver) {
        this.driver = driver;
    }

    //Method to click on Element By Xpath
    public void clickOnElementByXpath(String element) {
        driver.findElement(By.xpath(element)).click();
    }

    //Method to scrollDown
    public void scrollDown(int scroll) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+scroll+")");
    }


}
