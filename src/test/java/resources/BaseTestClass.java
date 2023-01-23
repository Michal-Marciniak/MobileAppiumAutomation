package resources;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class BaseTestClass implements ExMobileCapabilityType{

    private String serverUrl;
    private URL url = null;
    private String appPackage;
    private String appActivity;
    private String platformName;
    private String udid;
    private String automationName;
    private int newCommandTimeout;
    private DesiredCapabilities desiredCapabilities;
    private Properties prop;
    private FileInputStream fis;
    private String propertiesPath = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\config.properties";

    protected AppiumDriver setupDriver() {

        prop = new Properties();

        try {
            fis = new FileInputStream(propertiesPath);
            prop.load(fis);

            serverUrl = "http://127.0.0.1:" + prop.getProperty("portNumber") + "/wd/hub";
            url = new URL(serverUrl);

            appPackage = prop.getProperty("appPackage");
            appActivity = prop.getProperty("appActivity");
            platformName = prop.getProperty("platformName");
            udid = prop.getProperty("udid");
            automationName = prop.getProperty("automationName");
            newCommandTimeout = Integer.parseInt(prop.getProperty("newCommandTimeout"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        desiredCapabilities = new DesiredCapabilities();

        // Set this two capabilities to enable sending keys to input text boxes
        desiredCapabilities.setCapability(UNICODE_KEYBOARD, false);
        desiredCapabilities.setCapability(RESET_KEYBOARD, false);

        desiredCapabilities.setCapability(APP_PACKAGE, appPackage);
        desiredCapabilities.setCapability(APP_ACTIVITY, appActivity);
        desiredCapabilities.setCapability(PLATFORM_NAME, platformName);
        desiredCapabilities.setCapability(UDID, udid);
        desiredCapabilities.setCapability(AUTOMATION_NAME, automationName);

        // Disable the timer to prevent throwing errors due to not sending any request for 60 seconds
        desiredCapabilities.setCapability(NEW_COMMAND_TIMEOUT, newCommandTimeout);

        return new AppiumDriver(url, desiredCapabilities);
    }

    public void navigateBack(AppiumDriver appiumDriver) {
        appiumDriver.navigate().back();
    }

    public void tearDown(AppiumDriver appiumDriver) {
        appiumDriver.quit();
    }
}
