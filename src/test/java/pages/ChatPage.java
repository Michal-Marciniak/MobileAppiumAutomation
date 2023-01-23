package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {

    private AppiumDriver appiumDriver;
    private Actions actions;
    @FindBy(xpath = "//android.view.View[contains(@content-desc, \"|\")]")
    private WebElement chatName;

    public ChatPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
        actions = new Actions(appiumDriver);
    }

    public String getChatName() {
        return chatName.getAttribute("content-desc");
    }

}
