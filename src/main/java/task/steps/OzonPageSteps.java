package task.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import task.pages.OzonHomePage;

public class OzonPageSteps extends BaseTest{
    OzonHomePage ozonHomePage = new OzonHomePage(driver);

    public void closePopUp() {
        try {
            new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(ozonHomePage.popUp));
            ozonHomePage.popUp.findElement(By.xpath(".//span[@class='exponea-close-cross']")).click();
            //new WebDriverWait(driver,5).until(ExpectedConditions.invisibilityOf(ozonHomePage.popUp));
        } catch (NoSuchElementException| TimeoutException e) {

        }
        ozonHomePage.cookieCloseButton.click();
    }

    public void performSearch(String input) {
        ozonHomePage.searchInput.click();
        ozonHomePage.searchInput.sendKeys(input);
        ozonHomePage.searchInput.sendKeys(Keys.ENTER);
    }
}
