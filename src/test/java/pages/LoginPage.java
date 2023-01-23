package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private AppiumDriver appiumDriver;
    private Actions actions;
    @FindBy(xpath = "//android.widget.EditText[@text='user']")
    private WebElement inputText;
    @FindBy(xpath = "//android.widget.Button[@content-desc=\"LOGIN\"]")
    private WebElement loginButton;

    public LoginPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
        actions = new Actions(appiumDriver);
    }

    public void clearUsername() {
        inputText.clear();
    }

    public void enterUsername(String username) {
        inputText.click();
        actions.sendKeys(username).build().perform();
    }

    public SelectChatPage clickLoginButton() {
        loginButton.click();
        return new SelectChatPage(appiumDriver);
    }

}
