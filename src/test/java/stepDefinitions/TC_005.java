package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MidNav;

public class TC_005 {
    MidNav mn = new MidNav();
    public static double basketPrice;

    @And("The user check the product price in the cart")
    public void theUserCheckTheProductPriceInTheCart() {
        String strBasketPriceText = mn.basketPrice.getText();
        String cleanedStr1 = strBasketPriceText.substring(0, strBasketPriceText.indexOf(" TL")).trim();
        basketPrice = Double.parseDouble(cleanedStr1);
//        System.out.println(basketPrice);
    }

    @Then("The price should remain the same before and after adding to the cart")
    public void thePriceShouldRemainTheSameBeforeAndAfterAddingToTheCart() {
        Assert.assertEquals(TC_004.productPrice, basketPrice);
    }
}
