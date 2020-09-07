package org.testUI.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public LoginPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * поле ввода логина
     */
    @FindBy (id="mailbox:login-input")
    private WebElement loginField;
    /**
     * кнопка для отображения поля ввода пароля
     */
    @FindBy (id="mailbox:submit-button")
    private WebElement enterРasswordBtn;
    /**
     * поле ввода пароля
     */
    @FindBy (id="mailbox:password-input")
    private WebElement passwordField;
    /**
     * кнопка Войти
     */
    @FindBy (id="mailbox:submit-button")
    private WebElement loginBtn;

    /**
     * метод ввода логина
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login);    }
    /**
     * метод ввода пароля
     */
    @Step
    public void inputPassword(String password) {
        passwordField.sendKeys(password);    }

    /**
     * метод нажатия кнопки перехода к полю ввода пароля
     */

    public void pressEnterPasswordBtn() {
        enterРasswordBtn.click();    }
    /**
     * метод нажатия кнопки Войти
     */

    public void clickLoginBtn() {
        loginBtn.click();   }
}
