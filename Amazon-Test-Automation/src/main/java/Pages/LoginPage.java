package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest{

    @Step("Fill the email address field")
    public void enterEmail(String text){
        driver.findElement(By.id("ap_email")).sendKeys(text);
    }

    @Step("Click the continue button")
    public void clickContinue(){
        driver.findElement(By.cssSelector(".a-button-input")).click();
    }

    @Step("Fill the password field")
    public void enterPassword(String password){
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @Step("Click the login button")
    public void clickLogin(){
        driver.findElement(By.cssSelector("#signInSubmit")).click();
    }

    @Step("Verify error message")
    public void errorMessageController(String text){
        String value = driver.findElement(By.cssSelector(".a-list-item")).getText();
        Assert.assertEquals(value, text);
    }

    @Step("Verify email alert message")
    public void emailAlertMessageController(String text){
        String value = driver.findElement(By.xpath("//div[@id='auth-email-missing-alert']//div[@class='a-alert-content']")).getText();
        Assert.assertEquals(value, text);
    }

    @Step("Verify password alert message")
    public void passwordAlertMessageController(String text){
        String value = driver.findElement(By.xpath("//div[@id='auth-password-missing-alert']//div[@class='a-alert-content']")).getText();
        Assert.assertEquals(value, text);
    }

    @Step("Click the register button")
    public void clickRegisterButton() {
        driver.findElement(By.id("createAccountSubmit")).click();
    }
}

