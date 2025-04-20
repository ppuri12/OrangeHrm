package Pages;

import Utilities.BaseFunction;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class LandingPage extends BaseFunction {
    public LandingPage(WebDriver driver) {
        super(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    public WebElement module(String text)
    {
       WebElement selectModule =  driver.findElement(By.xpath("//ul[contains(@class,'oxd-main-menu')]//li//span[text()='"+text+"']"));
              return selectModule;
    }
    @FindBy (xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    public WebElement addButton;
    @FindBy (xpath = "//div[contains(@class,'oxd-select-text--after')]")
    public WebElement vacancyDropDown;
    @FindBy(xpath = "//label[contains(text(),'Email')]//parent::div//following-sibling::div/input")
    public WebElement email;
    @FindBy (xpath = "//label[text()='Full Name']")
    public WebElement firstNameField;
    @FindBy (xpath = "//input[@type='file']")
    public WebElement resumeField;
    @FindBy (xpath = "//label[contains(text(),'Notes')]//parent::div//following-sibling::div/textarea")
    public WebElement notes;
    @FindBy (xpath = "//div[contains(@class,'oxd-date-input-calendar')]//div[text()='Today']")
    public WebElement clickToday;
    @FindBy (xpath = "//div[contains(@class,'oxd-date-input')]")
    public WebElement calendar;
    @FindBy (xpath = "//button[contains(@class,'oxd-button oxd-button--medium oxd-button--sec') and (text()=' Save ')]")
    public WebElement save;

    public WebElement addValues(String value)
    {
        WebElement fieldValue=driver.findElement(By.xpath("//label[contains(text(),'"+ value +"')]//parent::div//following-sibling::div/input"));
        log.info(value +" is added");
        return fieldValue;

    }
    public void selectModule(String moduleValue)
    {
        waitForVisibilityOfElements(module(moduleValue),10);
        module(moduleValue).click();
        log.info(moduleValue +" is selected");

    }
    public void addCandidate()
    {
        waitForVisibilityOfElements(addButton,3);
        addButton.click();
        log.info("candidate is added");
    }

    public void addName() {
        waitForVisibilityOfElements(firstNameField,4);
        Map<String, String> name = new HashMap<>();
        name.put("firstName","Marie");
        name.put("middleName","M");
        name.put("lastName","Lou");
        driver.findElement(By.xpath("//form[contains(@class,'oxd-form')]//div//input[@name='firstName']")).sendKeys(name.get("firstName"));
        driver.findElement(By.xpath("//form[contains(@class,'oxd-form')]//div//input[@name='middleName']")).sendKeys(name.get("middleName"));
        driver.findElement(By.xpath("//form[contains(@class,'oxd-form')]//div//input[@name='lastName']")).sendKeys(name.get("lastName"));
        log.info("name is added");

    }
    public WebElement addVacancy(String value)
    {
        waitForVisibilityOfElements(vacancyDropDown,5);
        vacancyDropDown.click();

        WebElement vacancy = driver.findElement(By.xpath("//div[contains(@class,'oxd-select-option')]/span[contains(text(),'"+ value +"')]"));
        vacancy.click();
        log.info(value+" is selected");
        return vacancy;
    }
    public void addEmail(String Email)
    {
        addValues("Email").sendKeys(Email);
        log.info(Email+" is added");
    }
    public void addcontact(String contact)
    {
        addValues("Contact Number").sendKeys(contact);
        log.info(contact+" is added");
    }

    public void addResume()
    {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/uploads/PrernaPuri_Resume.pdf";
        resumeField.sendKeys(filePath);
        log.info("resume is added");

    }
    public void addKeywords(String keyword)
    {
        addValues("Keywords").sendKeys(keyword);
        log.info("keywords are added");
    }
    public void addNotes(String noteValue)
    {
        notes.sendKeys(noteValue);
        log.info("notes are added");
    }
    public void addDate()
    {
        calendar.click();
        waitForVisibilityOfElements(clickToday,2);
        clickToday.click();
        log.info("date is selected");
    }
    public void clickSave()
    {
        save.click();
    }













}
