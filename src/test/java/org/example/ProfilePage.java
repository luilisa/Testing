package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

    public WebDriver driver;
    private WebElement homeBtn;
    private WebElement logoutBtn;
    private WebElement perfomanceBtn;
    private WebElement userInfo;
    public ProfilePage(WebDriver driver) {
        this.driver = driver; }

    public void homeClick() {
        homeBtn = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/a[2]"));
        homeBtn.click(); }

    public void perfomanceClick() {
        perfomanceBtn = driver.findElement(By.xpath("//*[@id=\"main-blocks\"]/div[1]/div[6]/a"));
        perfomanceBtn.click(); }

    public void userLogout() {
        logoutBtn = driver.findElement(By.xpath("//*[@id=\"page\"]/header/a[1]"));
        logoutBtn.click(); }

    public String getUserName() {
        userInfo = driver.findElement(By.xpath("//*[@id=\"info\"]/div/div[1]/div[2]/div[2]/span[2]"));
        String userName = userInfo.getText();
        return userName; } }
