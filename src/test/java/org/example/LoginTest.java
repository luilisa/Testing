package org.example;

import io.qameta.allure.Step;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\bin\\\\chromedriver.exe");
        driver = new ChromeDriver();
        profilePage = new ProfilePage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://kpfu.ru");
    }

    public void checkURL(String expectedURL, String currentURL) {
        Assert.assertEquals(expectedURL, currentURL);
    }
    @Test
    public void loginTest() {
        String url = driver.getCurrentUrl();
        checkURL(ConfProperties.getProperty("loginpage"), url);
        loginPage.locateElements();
        loginPage.clickAccount();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();

    }
    @Test
    public void checkUser() {
        profilePage.perfomanceClick();
        profilePage.homeClick();
        String user = profilePage.getUserName();
        String expectedName = "Хайбуллина Луиза Юнировна";
        Assert.assertEquals(expectedName, user);
    }
    @AfterClass
    public static void tearDown() {
        profilePage.userLogout();
        driver.quit();
    }
}
