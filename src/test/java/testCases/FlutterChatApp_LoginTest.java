package testCases;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import resources.BaseTestClass;

public class FlutterChatApp_LoginTest extends BaseTestClass {

    private AppiumDriver appiumDriver;
    private LoginPage loginPage;
    private static String username = "TestUser";

    @BeforeTest
    public void setup() {
        appiumDriver = setupDriver();
        loginPage = new LoginPage(appiumDriver);
    }

    @Test
    public void loginTest() {
        //loginPage.enterUsername(username);
        loginPage.clickLoginButton();
    }

    @AfterTest
    public void tearDown() {
        appiumDriver.quit();
    }

}
