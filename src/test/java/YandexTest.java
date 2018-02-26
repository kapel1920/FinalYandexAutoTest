import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class YandexTest {
    private WebDriver driver;
    private Wait<WebDriver> wait;


    @Before
    public void setUp() throws Exception {
        System.setProperty( "webdriver.gecko.driver", "drv/geckodriver.exe" );
        System.setProperty( "webdriver.chrome.driver", "drv/chromedriver.exe" );

        // 1. Открыть браузер и развернуть на весь экран.
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS );
        driver.manage().window().maximize();

        //2. Зайти на yandex.ru.
        driver.get( "https://www.yandex.ru/" );


        //3. Перейти в яндекс маркет
        driver.findElement( By.xpath( "//A[@class='home-link home-link_blue_yes home-tabs__link home-tabs__search'][text()='Маркет']" ) ).click();

        //4. Выбрать раздел Электроника
        driver.findElement( By.xpath( "//A[@class='link topmenu__link'][text()='Электроника']" ) ).click();
        wait =  new WebDriverWait(driver, 5, 1000);
    }


    @Test
    public void yandexTestTV() throws InterruptedException {

        //5. Выбрать раздел Телевизоры
        driver.findElement( By.xpath( "//A[@class='link catalog-menu__list-item metrika i-bem metrika_js_inited'][text()='Телевизоры']" ) ).click();

        //6. Зайти в расширенный поиск
        //7. Задать параметр поиска от 20000 рублей.
        driver.findElement( By.xpath( "//INPUT[@id='glf-pricefrom-var']" ) ).sendKeys( "20000" );

        //8. Выбрать производителей Samsung и LG
        driver.findElement( By.xpath( "//LABEL[@class='checkbox__label'][text()='Samsung']" ) ).click();
        driver.findElement( By.xpath( "//LABEL[@class='checkbox__label'][text()='LG']" ) ).click();

        //9. Нажать кнопку Применить.
        driver.findElement( By.xpath( "//button[@class='button button_action_n-filter-apply button_size_s button_pseudo_yes button_theme_pseudo i-bem button_js_inited']" ) ).click();

        //10. Проверить, что элементов на странице 12.
        assertEquals( 12, driver.findElements( By.xpath( "(//div[@class='n-snippet-card2__title'])" ) ).size() );

        //11. Запомнить первый элемент в списке.
        String a = driver.findElement( By.xpath( "(//div[@class='n-snippet-card2__title'])[1]" ) ).getText();

        //12. В поисковую строку ввести запомненное значение.
        driver.findElement( By.xpath( "//INPUT[@id='header-search']" ) ).sendKeys( a );

        //13. Найти и проверить, что наименование товара соответствует запомненному значению.

        wait.until( ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("(//BUTTON[@role='button'])[1]"))));
        driver.findElement( By.xpath( "(//BUTTON[@role='button'])[1]" ) ).click();
        Assert.assertTrue( driver.findElement( By.xpath( "//H1[@class='title title_size_28 title_bold_yes']" ) ).getText().contains( a ) );
    }


    @Test
    public void yandexTestHP() throws InterruptedException {

        //5. Выбрать раздел Наушники
        driver.findElement( By.xpath( " (//A[@class='link catalog-menu__list-item metrika i-bem metrika_js_inited'][text()='Наушники и Bluetooth-гарнитуры'])[2]" ) ).click();
        //6. Зайти в расширенный поиск
        //7. Задать параметр поиска от 5000 рублей.
        driver.findElement( By.xpath( "//INPUT[@id='glf-pricefrom-var']" ) ).sendKeys( "5000" );
        //8. Выбрать производителя Beats
        driver.findElement( By.xpath( "//LABEL[@class='checkbox__label'][text()='Beats']" ) ).click();
        //9. Нажать кнопку Применить.
        driver.findElement( By.xpath( "//button[@class='button button_action_n-filter-apply button_size_s button_pseudo_yes button_theme_pseudo i-bem button_js_inited']" ) ).click();

        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("(//DIV[@class='n-snippet-cell2__title'])"))));
        //10. Проверить, что элементов на странице 12.
        assertEquals( 12, driver.findElements( By.xpath( "(//DIV[@class='n-snippet-cell2__title'])" ) ).size() );
        Thread.sleep( 2000 );
        //11. Запомнить первый элемент в списке.
        String g = driver.findElement( By.xpath( "(//DIV[@class='n-snippet-cell2__title'])[1]" ) ).getText();
        //12. В поисковую строку ввести запомненное значение.
        driver.findElement( By.xpath( "//INPUT[@id='header-search']" ) ).sendKeys( g );
        wait.until( ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("(//BUTTON[@role='button'])[1]"))));
        driver.findElement( By.xpath( "(//BUTTON[@role='button'])[1]" ) ).click();
        //13. Найти и проверить, что наименование товара соответствует запомненному значению.
        Assert.assertTrue( driver.findElement( By.xpath( "//LI[@class='n-breadcrumbs__item n-breadcrumbs__item_type_text']" ) ).getText().contains( g ) );

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}