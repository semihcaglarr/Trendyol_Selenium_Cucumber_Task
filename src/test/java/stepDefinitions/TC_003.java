package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DialogContent;
import pages.TopNav;

public class TC_003 {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();

    @Given("The user enter the name of an existing product laptop in the search bar")
    public void theUserEnterTheNameOfAnExistingProductLaptopInTheSearchBar() {
        tn.mySendKeys(tn.searchBox, "laptop");
    }

    @When("The user perform the search")
    public void theUserPerformTheSearch() {
        tn.JavaScriptClick(tn.searchIcon);
    }

    @Then("Relevant products should be listed")
    public void relevantProductsShouldBeListed() {
        dc.verifyContainsText(dc.filterLaptopChecked, "Laptop", "");
    }

    @Given("The user enter the name of an existing product asdfghty55 in the search bar")
    public void theUserEnterTheNameOfAnExistingProductAsdfghty55InTheSearchBar() {
        tn.mySendKeys(tn.searchBox, "asdfghty55");
    }

    @Then("Product not found message should be displayed")
    public void productNotFoundMessageShouldBeDisplayed() {
        dc.verifyContainsText(dc.noResultText, "aramanız için sonuç bulunamadı.", "");
    }
}
