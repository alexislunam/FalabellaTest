package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FalabellaHomePage {

    WebDriver driver;

    //Locator for Menu
    By menubtn = By.id("testId-HamburgerBtn-toggle");

    public FalabellaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to click on Menu button
    public void clickMenu() {
        driver.findElement(menubtn).click();
    }

    //Methos to select first Menu
    public void clickCategoryMenu(String category) {
        Actions action = new Actions(driver);
        WebElement categoryMenu = driver.findElement(By.xpath(category));
        action.moveToElement(categoryMenu).build().perform();
    }

    //Method to select sub menu
    public void clickSubMenu(String subMenu) {
        driver.findElement(By.xpath(subMenu)).click();
    }



}
