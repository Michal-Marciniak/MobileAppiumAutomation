package pages;

import io.appium.java_client.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private AppiumDriver appiumDriver;
    private WebElement loginButton;
    private WebElement inputText;

    public LoginPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void enterUsername(String username) {
        inputText = appiumDriver.findElement(By.className("android.widget.EditText"));
        inputText.sendKeys(username);
    }

    public void clickLoginButton() {
        loginButton = appiumDriver.findElement(new AppiumBy.ByAccessibilityId("LOGIN"));
        loginButton.click();
    }
}
