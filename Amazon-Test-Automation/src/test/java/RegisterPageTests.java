import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import org.testng.annotations.Test;

public class RegisterPageTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    HomePage homePage = new HomePage();

    @Test(description = "Create account")
    public void create_account() {
        homePage.acceptCookies();
        homePage.clickFirstLogin();
        loginPage.clickRegisterButton();
        registerPage.enterNameLastname("Test Selenium");
        registerPage.enterRegisterEmail("hepsiburadatest123@gmail.com");
        registerPage.enterRegisterPassword("test789");
        registerPage.enterRegisterPasswordAgain("test789");
        registerPage.clickRegister();
    }

    @Test(description = "Creating an account with an incorrect password")
    public void creating_an_account_with_an_incorrect_password() {
        homePage.acceptCookies();
        homePage.clickFirstLogin();
        loginPage.clickRegisterButton();
        registerPage.enterNameLastname("Gunes Gulay");
        registerPage.enterRegisterEmail("test@hotmail.com");
        registerPage.enterRegisterPassword("test789");
        registerPage.enterRegisterPasswordAgain("test78");
        registerPage.clickRegister();
        registerPage.repeatedMessageController("Şifreler eşleşmiyor");
    }

    @Test(description = "Creating an account with a password less than 6 characters")
    public void creating_an_account_with_a_password_less_than_6_characters() {
        homePage.acceptCookies();
        homePage.clickFirstLogin();
        loginPage.clickRegisterButton();
        registerPage.enterNameLastname("Gunes Gulay");
        registerPage.enterRegisterEmail("test1@hotmail.com");
        registerPage.enterRegisterPassword("test");
        registerPage.enterRegisterPasswordAgain("test");
        registerPage.clickRegister();
        registerPage.errorMessageController("Şifreler en az 6 karakterden oluşmalıdır.");
    }
}
