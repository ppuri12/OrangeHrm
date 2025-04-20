package Pages;

import Utilities.BaseFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class AddedCandidatePage extends BaseFunction {
    public AddedCandidatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//div[contains(@class,'oxd-loading-spinner-container')]")
    public WebElement loader;
    @FindBy (xpath = "//div[contains(@class,'orangehrm-card-container')]")
    public WebElement applicantCard;

    public void Screenshot() throws IOException {

        waitForInVisibilityOfElements(loader,20);
        takeScreenshot();
    }
}
