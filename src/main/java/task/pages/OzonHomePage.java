package task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.steps.BaseTest;

public class OzonHomePage {
    WebDriver driver;

    public OzonHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@placeholder = 'Искать на Ozon']")
    public WebElement searchInput;

    @FindBy(xpath = "//a[@data-widget = 'cart']")
    public WebElement cartButton;

    @FindBy(xpath = "//a[@class='exponea-banner exponea-popup-banner exponea-animate']")
    public WebElement popUp;

    @FindBy(xpath = "//button[@aria-label='Закрыть сообщение']")
    public WebElement cookieCloseButton;
}
