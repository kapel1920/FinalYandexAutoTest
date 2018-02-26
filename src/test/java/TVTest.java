import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;
import pages.MarketPage;
import steps.BaseSteps;

public class TVTest extends BaseSteps {

    @Test
    public void newYandexTestOne() throws InterruptedException {
        driver.get( baseUrl );
        MainPage mainPage = new MainPage( driver );
        MarketPage marketPage = new MarketPage( driver );
        mainPage.selectMainMenu( "Маркет" );
        marketPage.electronica.click();
        marketPage.televizor.click();
        marketPage.fillField("Сумма", "20000");
        marketPage.clickSamsung.click();
        marketPage.clickLG.click();
        marketPage.clickButtonPrimenit.click();

        marketPage.checkCountOfElementOfTV();

        String a = marketPage.takeFirstElement.getText();
        marketPage.searchField.sendKeys( a );
        marketPage.waitToclickButtonSearch();
        marketPage.clickButton2.click();
        Assert.assertTrue( marketPage.tittleOfElement.getText().contains( a ) );

    }
}
