package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;
import pages.MidNav;
import pages.TopNav;
import utilities.GWD;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

public class TC_004 {
    public static double productPrice;
    TopNav tn = new TopNav();
    MidNav mn = new MidNav();
    DialogContent dc = new DialogContent();
    String firstTabId;
    String secondTabId;
    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("The user randomly selects a product")
    public void theUserRandomlySelectsAProduct() {
        int random = mn.randomGenerator(mn.products.size());
        mn.myClick(mn.products.get(random));

        Set<String> windowsIdS = GWD.getDriver().getWindowHandles();
        Iterator<String> cursor = windowsIdS.iterator();
        firstTabId = cursor.next();
        secondTabId = cursor.next().toString();
        dc.wait.until(ExpectedConditions.urlContains("laptop"));

        GWD.getDriver().switchTo().window(secondTabId);

        dc.JavaScriptClick(dc.onBoardingButton);
    }

    @When("The user adds the product to the basket")
    public void theUserAddsTheProductToTheBasket() {
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
    }

    @And("The product must be successfully added to the basket")
    public void theProductMustBeSuccessfullyAddedToTheBasket() {
        mn.Wait(10);
        tn.myClick(tn.basketLink);
    }

    @Then("The number of products added to the basket must be updated correctly")
    public void theNumberOfProductsAddedToTheBasketMustBeUpdatedCorrectly() {
        mn.JavaScriptClick(mn.toolTipContent);
    }
}
