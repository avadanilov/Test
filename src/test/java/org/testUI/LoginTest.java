package org.testUI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testUI.pages.InboxPage;
import org.testUI.pages.LoginPage;
import org.testUI.utils.ConfigProperties;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    public static LoginPage loginPage;
    public static InboxPage inboxPage;
    public static WebDriver driver;

    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromedriver"));
        driver= new ChromeDriver();
        loginPage = new LoginPage(driver);
        inboxPage = new InboxPage(driver);
        driver.manage().window().maximize();
        driver.get(ConfigProperties.getProperty("testPage"));
    }

    @Test
    public void loginTest() {
        loginPage.inputLogin(ConfigProperties.getProperty("login"));
        loginPage.pressEnterPasswordBtn();
        loginPage.inputPassword(ConfigProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        String userName = inboxPage.getLogin();
        Assert.assertEquals(ConfigProperties.getProperty("login").toLowerCase()+"@mail.ru", userName);
    }


    @AfterTest
    public static void tearDown(){
        driver.quit();
    }

}
