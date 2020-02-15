package task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoodsListPage extends OzonHomePage {

    public GoodsListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form[@action]")
    public List<WebElement> sliderBlocks;

    @FindBy(xpath = "//button[@qa-id='tile-buy-button']")
    public List<WebElement> buttons;
}
