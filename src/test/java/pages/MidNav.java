package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

import java.util.List;

public class MidNav {

    public MidNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id = "Combined-Shape")
    public WebElement combinedShapeCloseButton;

    @FindBy(css = "[class*='button submit']")
    public WebElement loginSubmit;

    @FindBy(css = "div[class='image-overlay-body']")
    public List<WebElement> products;

    @FindBy(css = "[class='product-button-container']>button")
    public WebElement addToBasket;

    @FindBy(className = ".checkout-saving-remove-button")
    public WebElement removeButton;
}
