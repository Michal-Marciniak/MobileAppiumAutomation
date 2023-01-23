package testCases;

import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ChatPage;
import pages.LoginPage;
import pages.SelectChatPage;
import resources.BaseTestClass;

public class FlutterChatApp_Tests extends BaseTestClass {

    private AppiumDriver appiumDriver;
    private LoginPage loginPage;
    private SelectChatPage selectChatPage;
    private ChatPage chatPage;

    @BeforeTest
    public void setup() {
        appiumDriver = setupDriver();
        loginPage = new LoginPage(appiumDriver);
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username) {
        loginPage.clearUsername();
        loginPage.enterUsername(username);
        selectChatPage = loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "loginTest",
            dataProvider = "chatRoomsData")
    public void selectChatTest(String chatName) {
        chatPage = selectChatPage.goToChat(chatName);
    }

    @Test(dependsOnMethods = "selectChatTest",
            dataProvider = "chatRoomsData")
    public void chatTest(String chatName) throws InterruptedException {
        Assert.assertFalse(chatPage.getChatName().startsWith(chatName));
        Thread.sleep(1000);
        navigateBack(appiumDriver);
    }

    @AfterTest
    public void tearDown() {
        tearDown(appiumDriver);
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"TestUser123"}
        };
    }

    @DataProvider(name = "chatRoomsData")
    public Object[][] chatRoomsData() {
        return new Object[][] {
                {"Room 1"}
        };
    }
}
