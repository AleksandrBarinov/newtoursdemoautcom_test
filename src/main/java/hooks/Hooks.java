package hooks;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;
    private String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        baseUrl = properties.getProperty("app.url");

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get(baseUrl);

    }

    @After
    public void afterTest() {
        driver.quit();
    }

}

