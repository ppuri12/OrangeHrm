package Pages;

import Utilities.BaseFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class LoginPage extends BaseFunction {

    public LoginPage(WebDriver driver) {
        super(driver);

    }
    @FindBy (xpath = "//div[contains(@class,'oxd-s')]/p")
    public List<WebElement>loginDetails;
    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;
    @FindBy(xpath = "//button[contains(@class,'oxd-b')]")
    public WebElement login;

    public void login(){
      waitForVisibilityOfElements(userName,2);
        String Username = loginDetails.get(0).getText().split(":")[1].trim();
        userName.sendKeys(Username);
        String Password = loginDetails.get(1).getText().split(":")[1].trim();
        password.sendKeys(Password);
        login.click();
        log.info("login is done");
    }
}
