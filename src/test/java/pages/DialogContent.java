package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

public class DialogContent extends ParentPage {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='login-email']")
    public WebElement loginEmail;

    @FindBy(id = "login-password-input")
    public WebElement loginPassword;

    @FindBy(css = "span[class='message']")
    public WebElement warningMessage;

    @FindBy(xpath = "//div[@class='fltr-item-text chckd']")
    public WebElement filterLaptopChecked;

}

