package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.MidNav;
import pages.TopNav;
import utilities.GWD;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

public class AllSteps {
    MidNav mn = new MidNav();
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();
    double productPrice;
    double basketPrice;
    double basketPriceUpdate;
    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

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
            robot = new Robot();
            for (int i = 0; i < 2; i++) {
                mn.Wait(1);
                robot.keyPress(KeyEvent.VK_ENTER);
                mn.Wait(1);
                robot.keyRelease(KeyEvent.VK_ENTER);
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
        tn.mySendKeys(tn.searchBox, "laptop");
        tn.JavaScriptClick(tn.searchIcon);
        dc.verifyContainsText(dc.filterLaptopChecked, "Laptop", "");
    }

    @Then("User selects a random product from the laptops according to the results and adds it to the basket")
    public void userSelectsARandomProductFromTheLaptopsAccordingToTheResultsAndAddsItToTheBasket() {
        int random = mn.randomGenerator(mn.products.size());
        mn.myClick(mn.products.get(random));

        Set<String> windowsIdS = GWD.getDriver().getWindowHandles();
        Iterator<String> cursor = windowsIdS.iterator();
        String firstTabId = cursor.next();
        String secondTabId = cursor.next().toString();
        dc.wait.until(ExpectedConditions.urlContains("laptop"));

        GWD.getDriver().switchTo().window(secondTabId);

        dc.JavaScriptClick(dc.onBoardingButton);

        try {
            robot = new Robot();
            for (int i = 0; i < 6; i++) {
                mn.Wait(1);
                robot.keyPress(KeyEvent.VK_TAB);
                mn.Wait(1);
                robot.keyRelease(KeyEvent.VK_TAB);
            }
        } catch (AWTException e) {
            System.out.println(e.getMessage());
        }
        GWD.getDriver().switchTo().window(firstTabId);
        mn.Wait(3);
        GWD.getDriver().switchTo().window(secondTabId);

        String strProductPriceText = mn.productPrice.getText();
        String cleanedStr = strProductPriceText.substring(0, strProductPriceText.indexOf(" TL")).trim();
        productPrice = Double.parseDouble(cleanedStr);
//        System.out.println(productPrice);

        mn.myClick(mn.addToBasket);
        mn.Wait(10);
    }

    @When("The price of the product before it is added to the basket and the price after it is added to the basket must be the same")
    public void thePriceOfTheProductBeforeItIsAddedToTheBasketAndThePriceAfterItIsAddedToTheBasketMustBeTheSame() {
        tn.myClick(tn.basketLink);
        mn.JavaScriptClick(mn.toolTipContent);
        mn.scrollToElement(mn.basketPrice);

        String strBasketPriceText = mn.basketPrice.getText();
        String cleanedStr1 = strBasketPriceText.substring(0, strBasketPriceText.indexOf(" TL")).trim();
        basketPrice = Double.parseDouble(cleanedStr1);
//        System.out.println(basketPrice);

        Assert.assertEquals(productPrice, basketPrice);
    }

    @Then("The number of items in the basket should be doubled and the total price updated correctly")
    public void theNumberOfItemsInTheBasketShouldBeDoubledAndTheTotalPriceUpdatedCorrectly() {
        if (mn.numericButton.isEnabled()) {
            mn.myClick(mn.numericButton);
            System.out.println("Product quantity increased");
            String strBasketPriceTextIncrs = mn.basketPrice.getText();
            String cleanedStr2 = strBasketPriceTextIncrs.replace(" TL", "").trim();
            basketPriceUpdate = Double.parseDouble(cleanedStr2);

            String result = (basketPrice == 2 * basketPriceUpdate)
                    ? "Test passed: The price doubled as expected."
                    : "Test failed: The price did not double.";
            System.out.println("result = " + result);

            mn.myClick(mn.removeButton);
//            System.out.println("Product quantity could not be increased");
            tn.Wait(5);
            mn.verifyContainsText(mn.totalText, "0", "");
        } else {
            mn.myClick(mn.removeButton);
//            System.out.println("Product quantity could not be increased");
            tn.Wait(5);
            mn.verifyContainsText(mn.totalText, "0 TL", "");
        }
    }
}

