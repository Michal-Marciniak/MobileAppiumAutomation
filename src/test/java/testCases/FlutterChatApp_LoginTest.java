package testCases;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

public class FlutterChatApp_LoginTest {

    private static int portNumber = 4725;
    private static String serverUrl = "http://127.0.0.1:" + portNumber + "/wd/hub";
    private static URL url;
    private static DesiredCapabilities desiredCapabilities;
    private static AppiumDriver appiumDriver;

    @BeforeClass
    public void setup() {

        try {
            url = new URL(serverUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appPackage", "pl.flutter.chatapp.bugs");
        desiredCapabilities.setCapability("appActivity", "pl.flutter.chatapp.flutter_chat.MainActivity");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("udid", "86a6b9d2");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        // Disable the timer to prevent throwing errors due to not sending any request for 60 seconds
        desiredCapabilities.setCapability("newCommandTimeout", 0);

        appiumDriver = new AppiumDriver(url, desiredCapabilities);
    }

    @Test
    public void loginTest() {

        WebElement loginButton = appiumDriver.findElement(new AppiumBy.ByAccessibilityId("LOGIN"));
        loginButton.click();
    }

}
