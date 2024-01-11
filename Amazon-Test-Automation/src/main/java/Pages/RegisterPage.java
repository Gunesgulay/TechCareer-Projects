package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class RegisterPage extends BaseTest{

    @Step("Fill the name-lastname field")
    public void enterNameLastname(String text) {
        driver.findElement(By.id("ap_customer_name")).sendKeys(text);
    }

    @Step("Fill the register email field")
    public void enterRegisterEmail(String text) {
        driver.findElement(By.id("ap_email")).sendKeys(text);
    }

    @Step("Fill the register password field")
    public void enterRegisterPassword(String password) {
        driver.findElement(By.id("ap_password")).sendKeys(password);
    }

    @Step("Fill the 'Enter the password again' field")
    public void enterRegisterPasswordAgain(String password) {
        driver.findElement(By.id("ap_password_check")).sendKeys(password);
    }

    @Step("Click the register button")
    public void clickRegister() {
        driver.findElement(By.id("continue")).click();
    }

    @Step("Verify repeated password message")
    public void repeatedMessageController(String text) {
        String value = driver.findElement(By.xpath("//div[@id='auth-password-mismatch-alert']//div[@class='a-alert-content']")).getText();
        Assert.assertEquals(value,text);
    }

    @Step("Error message check for password less than 6 characters")
    public void errorMessageController(String text) {
        String value = driver.findElement(By.xpath("//div[@id='auth-password-invalid-password-alert']//div[@class='a-alert-content']")).getText();
        Assert.assertEquals(value, text);
    }
}

