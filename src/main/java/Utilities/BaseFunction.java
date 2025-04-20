package Utilities;

import Pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseFunction {
    protected WebDriver driver;
   protected static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    public BaseFunction(WebDriver driver)
    {   this.driver=driver;
        PageFactory.initElements(driver,this);


    }

    public void waitForVisibilityOfElements(WebElement element, int timeOutSeconds)
    {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeOutSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForInVisibilityOfElements(WebElement element, int timeOutSeconds)
    {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeOutSeconds));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void openUrl(String url)
    {
        this.driver.get(url);
    }
    public void tearDown()
    {
        this.driver.quit();
    }
    public void takeScreenshot() throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        TakesScreenshot tc = (TakesScreenshot) driver;
        File src = tc.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/ScreenShot/" + timestamp + ".png";
        File trg =  new File(path);
        FileUtils.copyFile(src,trg);


    }



}
