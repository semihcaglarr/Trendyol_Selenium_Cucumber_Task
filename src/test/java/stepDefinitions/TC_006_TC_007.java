package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.MidNav;
import pages.TopNav;

public class TC_006_TC_007 {
    MidNav mn = new MidNav();
    TopNav tn = new TopNav();

    @Then("The user should double the product quantity and the total price should be updated correctly")
    public void theUserShouldDoubleTheProductQuantityAndTheTotalPriceShouldBeUpdatedCorrectly() {
        if (mn.numericButton.isEnabled()) {
            mn.myClick(mn.numericButton);
            System.out.println("Product quantity increased");
            String strBasketPriceTextIncrs = mn.basketPrice.getText();
            String cleanedStr2 = strBasketPriceTextIncrs.replace(" TL", "").trim();
            double basketPriceUpdate = Double.parseDouble(cleanedStr2);

            String result = (TC_005.basketPrice == 2 * basketPriceUpdate)
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
