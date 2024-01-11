import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.*;

public class LoginPageTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    public void login() throws InterruptedException {
        Thread.sleep(2000);
        homePage.acceptCookies();
        homePage.clickFirstLogin();
        loginPage.enterEmail("testautomation652@gmail.com");
        loginPage.clickContinue();
        loginPage.enterPassword("deneme123");
        loginPage.clickLogin();
    }

    @Test(description = "Successful user login")
    public void successful_user_login() throws InterruptedException {
        login();
        homePage.checkSuccessfulLogin("test");
    }

    @Test(description = "Incorrect email entry")
    public void incorrect_email_entry() {
        homePage.clickFirstLogin();
        loginPage.enterEmail("test123");
        loginPage.clickContinue();
        loginPage.errorMessageController("Bu e-posta adresiyle bir hesap bulamıyoruz");
    }

    @Test(description = "Incorrect password entry")
    public void incorrect_password_entry() {
        homePage.acceptCookies();
        homePage.clickFirstLogin();
        loginPage.enterEmail("testautomation652@gmail.com");
        loginPage.clickContinue();
        loginPage.enterPassword("test45");
        loginPage.clickLogin();
        loginPage.errorMessageController("Şifreniz yanlış");
    }

    @Test(description = "Leaving the email field blank")
    public void leaving_the_email_field_blank() {
        homePage.acceptCookies();
        homePage.clickFirstLogin();
        loginPage.enterEmail("");
        loginPage.clickContinue();
        loginPage.emailAlertMessageController("E-posta adresinizi veya cep telefonu numaranızı girin");
    }

    @Test(description = "Leaving the password field blank")
    public void leaving_the_password_field_blank() {
        homePage.acceptCookies();
        homePage.clickFirstLogin();
        loginPage.enterEmail("testautomation652@gmail.com");
        loginPage.clickContinue();
        loginPage.enterPassword("");
        loginPage.clickLogin();
        loginPage.passwordAlertMessageController("Şifrenizi girin");
    }
}
