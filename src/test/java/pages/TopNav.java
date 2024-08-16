package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

public class TopNav extends ParentPage {

    public TopNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "a[title='trendyol']")
    public WebElement trendyolLogo;

    @FindBy(css = "[class='link account-user'] p")
    public WebElement loginLinkText;

    @FindBy(xpath = "//div[@class='login-button']")
    public WebElement loginButton;

    @FindBy(css = "[data-testid='suggestion']")
    public WebElement searchBox;

    @FindBy(css = "i[data-testid='search-icon']")
    public WebElement searchIcon;

    @FindBy(css = "a[class='link account-basket']")
    public WebElement basketLink;

}
