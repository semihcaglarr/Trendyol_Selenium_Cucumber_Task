package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MidNav;
import pages.TopNav;
import utilities.GWD;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TC_001 {
    TopNav tn = new TopNav();
    MidNav mn = new MidNav();
    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("The User navigate to the Trendyol Homepage")
    public void theUserNavigateToTheTrendyolHomepage() {
        GWD.getDriver().get("https://www.trendyol.com/");
    }

    @When("The homepage should load successfully")
    public void theHomepageShouldLoadSuccessfully() {
        mn.JavaScriptClick(mn.acceptButton);
    }

    @Then("The Trendyol logo and menu bar should be visible")
    public void theTrendyolLogoAndMenuBarShouldBeVisible() {
        tn.Wait(10);
        try {
            robot = new Robot();
            for (int i = 0; i < 3; i++) {
                mn.Wait(1);
                robot.keyPress(KeyEvent.VK_TAB);
                mn.Wait(1);
                robot.keyRelease(KeyEvent.VK_TAB);
            }
            mn.Wait(1);
            robot.keyPress(KeyEvent.VK_ENTER);
            mn.Wait(1);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            System.out.println(e.getMessage());
        }
        tn.verifyContainsText(tn.trendyolLogo, "trendyol", "title");
    }
}
