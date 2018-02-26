package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps{

    @Step ("Осуществлен переход на страницу Яндекса")
    public void stepTransferToYandex(){
        driver.get(baseUrl);
    }

    @Step("Выбран пунк меню {0}")
    public void stepSelectMainMenu(String menuItem){
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu(menuItem);
    }

}
