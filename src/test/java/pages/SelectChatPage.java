package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectChatPage {

    private AppiumDriver appiumDriver;
    private Actions actions;
    @FindBy(xpath = "//android.view.View[contains(@content-desc, \"Room\")]")
    private List<WebElement> chatRooms;

    public SelectChatPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
        actions = new Actions(appiumDriver);
    }

    public ChatPage goToChat(String chatName) {
        chatRooms.forEach(chatRoom -> {
            if(chatRoom.getAttribute("content-desc").startsWith(chatName)) {
                chatRoom.click();
            }
        });
        return new ChatPage(appiumDriver);
    }

}
