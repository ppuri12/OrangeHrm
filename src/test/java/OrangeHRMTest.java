import Pages.AddedCandidatePage;
import Pages.LandingPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrangeHRMTest extends BaseTest{


    @Test
    public void verifyAddingCandidate() throws IOException {
        LoginPage orangeHRMLoginPage = new LoginPage(getWebDriver());
        LandingPage landingPage= new LandingPage(getWebDriver());
        AddedCandidatePage addedCandidatePage = new AddedCandidatePage(getWebDriver());
        orangeHRMLoginPage.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        orangeHRMLoginPage.login();
        landingPage.selectModule("Recruitment");
        landingPage.addCandidate();
        landingPage.addName();
        landingPage.addVacancy("Senior QA Lead");
        landingPage.addEmail("marie@gmai.com");
        landingPage.addcontact("9028371321");
        landingPage.addResume();
        landingPage.addKeywords("java, selenium, Apache");
        landingPage.addDate();
        landingPage.addNotes("Source : LinkedIn");
        landingPage.clickSave();
        addedCandidatePage.Screenshot();


    }

}
