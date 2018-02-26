package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends BasePage{



    @FindBy (xpath = "//div[@class='home-arrow__tabs']")
    WebElement mainMenu;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectMainMenu(String menuItem){
        mainMenu.findElement(By.xpath(".//a[contains(text(),'"+menuItem+"')]")).click();

    }

}
