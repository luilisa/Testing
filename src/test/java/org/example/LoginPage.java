package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;
    private WebElement accountBtn;
    private WebElement loginField;
    private WebElement loginBtn;
    private WebElement passwdField;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        }

    public void locateElements() {
        accountBtn = driver.findElement(By.xpath("//*[@id=\"top-panel\"]/div[1]/div[1]/a"));
        loginField = driver.findElement(By.xpath("//*[contains(@name, 'p_login')]"));
        loginBtn = driver.findElement(By.xpath("//*[@id=\"eu_enter\"]/input[3]"));
        passwdField = driver.findElement(By.xpath("//*[contains(@name, 'p_pass')]"));
    }


    public void clickAccount() {
        accountBtn.click(); }

    public void inputLogin(String login) {
        loginField.sendKeys(login); }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd); }

    public void clickLoginBtn() {
        loginBtn.click(); }

}
