package resources;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class BaseTestClass {

    protected AppiumDriver setupDriver() {

        int portNumber = 4725;
        String serverUrl = "http://127.0.0.1:" + portNumber + "/wd/hub";
        URL url = null;
        DesiredCapabilities desiredCapabilities;

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

        return new AppiumDriver(url, desiredCapabilities);
    }
}
