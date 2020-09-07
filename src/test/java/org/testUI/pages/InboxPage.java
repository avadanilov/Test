package org.testUI.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage {
    public WebDriver driver;
    public InboxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * ссылка на профиль пользователя (его логин)
     */
    @FindBy(id="PH_user-email")
    private WebElement profileLink;

    /**
     * метод получения логина пользователя
     */
    @Step
   public String getLogin() {
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOf(profileLink));
       return profileLink.getText();
   }

}
