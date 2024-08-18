package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DialogContent;
import pages.MidNav;
import pages.TopNav;

public class TC_002 {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();
    MidNav mn = new MidNav();

    @Given("The User enter a correct email and an incorrect password")
    public void theUserEnterACorrectEmailAndAnIncorrectPassword() {
        tn.ActionHover(tn.loginLinkText);
        tn.JavaScriptClick(tn.loginButton);
        dc.mySendKeys(dc.loginEmail, "caglarsemih1@gmail.com");
        dc.mySendKeys(dc.loginPassword, "karizmatikTakım");
    }

    @When("The User attempt to log in")
    public void theUserAttemptToLogIn() {
        mn.myClick(mn.loginSubmit);
    }


    @Then("The User should receive an incorrect password error message")
    public void theUserShouldReceiveAnIncorrectPasswordErrorMessage() {
        dc.scrollToElement(dc.loginEmail);
        dc.verifyContainsText(dc.warningMessage, "incorrect", "");
    }

    @Given("The User enter a incorrect email and an correct password")
    public void theUserEnterAIncorrectEmailAndAnCorrectPassword() {
        tn.ActionHover(tn.loginLinkText);
        tn.JavaScriptClick(tn.loginButton);
        dc.mySendKeys(dc.loginEmail, "tatlis@ekip.com");
        dc.mySendKeys(dc.loginPassword, "mupmutevaziLider");
    }

    @Given("The User enter a incorrect email and an incorrect password")
    public void theUserEnterAIncorrectEmailAndAnIncorrectPassword() {
        tn.ActionHover(tn.loginLinkText);
        tn.JavaScriptClick(tn.loginButton);
        dc.mySendKeys(dc.loginEmail, "tatlis@ekip.com");
        dc.mySendKeys(dc.loginPassword, "Semih3435");
    }
}
