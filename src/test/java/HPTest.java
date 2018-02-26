import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;
import pages.MarketPage;
import steps.BaseSteps;

public class HPTest extends BaseSteps {

    @Test
    public void newYandexTestTwo() throws InterruptedException {
        driver.get( baseUrl );
        MainPage mainPage = new MainPage( driver );
        MarketPage marketPage = new MarketPage( driver );
        mainPage.selectMainMenu( "Маркет" );
        marketPage.electronica.click();
        marketPage.headphones.click();
        marketPage.fillField("Сумма", "5000");
        marketPage.clickBeats.click();
        marketPage.clickButtonPrimenit.click();
        marketPage.checkCountOfElementHeadphone();
        Thread.sleep( 2000 );
        String b = marketPage.takeFirstElementOfheadphones.getText();
        marketPage.searchField.sendKeys( b );
        marketPage.waitToclickButtonSearch();
        marketPage.clickButton2.click();
        Assert.assertTrue(marketPage.tittleOfHeadphonesElement.getText().contains( b ));

    }
}
