package task.steps;

import cucumber.api.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    protected static String URL;
    public static Properties properties = TestProperties.getInstance().getProperties();
    public static WebDriverWait wait;

    public void initialize() {
        String browser = properties.getProperty("browser");
        if ("chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser)) {
            System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
            driver = new ChromeDriver();
        } else if ("IE".equals(browser)) {
            System.setProperty("webdriver.ie.driver", properties.getProperty("webdriver.ie.driver"));
            driver = new InternetExplorerDriver();

            System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
            driver = new ChromeDriver();
        }
        URL = properties.getProperty("appURL");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.getLifecycle().addAttachment(LocalDateTime.now()
                            .format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")), "image/png",
                    "png", screenShot);
        }

        driver.quit();
    }
}
