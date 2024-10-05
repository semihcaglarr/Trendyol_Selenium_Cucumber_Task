package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

import java.util.List;

public class MidNav extends ParentPage {

    public MidNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement acceptButton;

    @FindBy(css = "[class*='button submit']")
    public WebElement loginSubmit;

    @FindBy(xpath = "//div[@class='ratings-container']/..")
    public List<WebElement> products;

    @FindBy(css = "div[class='product-price-container'] span")
    public WebElement productPrice;

    @FindBy(xpath = "(//button[@component-id='1'])[2]")
    public WebElement addToBasket;

    @FindBy(xpath = "//div[contains(@class,'success')]")
    public WebElement addToBasketSuccessText;

    @FindBy(xpath = "//div[@class='tooltip-content']/button")
    public WebElement toolTipContent;

    @FindBy(xpath = "(//div[@class='pb-basket-item-price'])[1]")
    public WebElement basketPrice;

    @FindBy(xpath = "(//div[contains(@class,'numeric-counter')]/button)[2]")
    public WebElement numericButton;

    @FindBy(css = "button[class*='remove-button']")
    public WebElement removeButton;

    @FindBy(xpath = "//ul[@class='pb-summary-box-prices']//strong")
    public WebElement totalText;


}
