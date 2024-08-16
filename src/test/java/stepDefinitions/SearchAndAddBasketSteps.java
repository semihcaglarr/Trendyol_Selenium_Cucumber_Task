package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;
import pages.MidNav;
import pages.TopNav;
import utilities.GWD;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SearchAndAddBasketSteps {
    MidNav mn = new MidNav();
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();

    @Given("Navigate to trendyol.com")
    public void navigateToTrendyolCom() {
        GWD.getDriver().get("https://www.trendyol.com/");
    }

    @When("The User clicks the Accept button")
    public void theUserClicksTheAcceptButton() {
        mn.JavaScriptClick(mn.acceptButton);
    }

    @And("User must block notifications from trendyol.com")
    public void userMustBlockNotificationsFromTrendyolCom() {
        try {
            Robot robot = new Robot();
            for (int i = 0; i < 2; i++) {
                mn.Wait(1);
                robot.keyPress(KeyEvent.VK_ESCAPE);
                mn.Wait(1);
                robot.keyRelease(KeyEvent.VK_ESCAPE);
            }
        } catch (AWTException e) {
            System.out.println(e.getMessage());
        }
    }

    @And("User should see the home page open")
    public void userShouldSeeTheHomePageOpen() {
        tn.verifyContainsText(tn.trendyolLogo, "trendyol", "title");
        // System.out.println(tn.trendyolLogo.getAttribute("title"));
    }

    @And("User hover and then click Login")
    public void userHoverAndThenClickLogin() {
        tn.ActionHover(tn.loginLinkText);
        tn.JavaScriptClick(tn.loginButton);
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        dc.mySendKeys(dc.loginEmail, "tatlis@ekip.com");
        dc.mySendKeys(dc.loginPassword, "müpmütevaziLider");
        mn.myClick(mn.loginSubmit);
    }

    @And("Already warning message should be displayed")
    public void alreadyWarningMessageShouldBeDisplayed() {
        dc.verifyContainsText(dc.warningMessage, "hatalı", "");
    }

    @And("User must enter the word laptop in the search box")
    public void userMustEnterTheWordLaptopInTheSearchBox() {
        try {
            Robot robot = new Robot();
            for (int i = 0; i < 2; i++) {
                mn.Wait(1);
                robot.keyPress(KeyEvent.VK_ESCAPE);
                mn.Wait(1);
                robot.keyRelease(KeyEvent.VK_ESCAPE);
            }
        } catch (AWTException e) {
            System.out.println(e.getMessage());
        }
        tn.mySendKeys(tn.searchBox, "laptop");
        tn.JavaScriptClick(tn.searchIcon);
        dc.verifyContainsText(dc.filterLaptopChecked, "Laptop", "");
    }
}
