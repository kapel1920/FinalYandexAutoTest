import org.junit.Ignore;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.MainSteps;
import steps.MarketSteps;
import java.util.HashMap;


public class YandexAllureReportTest extends BaseSteps {

    @Test
    @Title("Яндекс Маркет Телевизоры (1-й сценарий)")
    public void testYandexTestOne() throws InterruptedException {

        MainSteps mainSteps = new MainSteps();
        MarketSteps marketSteps = new MarketSteps();

        mainSteps.stepTransferToYandex();
        mainSteps.stepSelectMainMenu( "Маркет" );
        marketSteps.stepClickElectronika();
        marketSteps.stepClickMenuTV();

        HashMap<String, String> testDate = new HashMap<>();
        testDate.put("Сумма", "20000");
        marketSteps.stepFillFields(testDate);

        marketSteps.stepClickSamsung();
        marketSteps.stepClickLG();
        marketSteps.stepButtonPrimenit();
        marketSteps.stepCheckCountOfEliments();
        String d = marketSteps.stepFoundFirstEliment();
        marketSteps.stepInputFirstElimentToSearch(d);
        marketSteps.stepClickToSearch();
        marketSteps.stepCheckText(d);
    }

    @Test
    @Title("Яндекс Маркет Наушники (2-й сценарий)")
    public void testYandexTestTwo() throws InterruptedException {

        MainSteps mainSteps = new MainSteps();
        MarketSteps marketSteps = new MarketSteps();

        mainSteps.stepTransferToYandex();
        mainSteps.stepSelectMainMenu( "Маркет" );
        marketSteps.stepClickElectronika();
        marketSteps.stepClickMenuHeadphones();

        HashMap<String, String> testDate = new HashMap<>();
        testDate.put("Сумма", "5000");
        marketSteps.stepFillFields(testDate);

        marketSteps.stepClickBeats();
        marketSteps.stepButtonPrimenit();
        marketSteps.stepCheckCountOfHeadphonesEliments();
        Thread.sleep( 2000 );
        String z = marketSteps.stepFoundFirstHeadphonesEliment();
        marketSteps.stepInputFirstElimentOfHeadphonesToSearch(z);
        marketSteps.stepClickToSearch();
        marketSteps.stepCheckTextOfHeadphones( z );
    }
}
