import Base.BaseTest;
import Pages.HomePage;
import org.testng.annotations.*;

public class HomePageTests extends BaseTest {

    HomePage homePage = new HomePage();
    LoginPageTests loginpage = new LoginPageTests();

    public void createList() throws InterruptedException {
        loginpage.login();
        homePage.elementToHover();
        Thread.sleep(2000);
        homePage.clickCreateList();
        homePage.clickCreateAList();
        Thread.sleep(3000);
        homePage.clickCreateListButton();
    }

    @Test(description = "Viewing product details")
    public void viewing_product_details() throws InterruptedException {
        loginpage.login();
        Thread.sleep(2000);
        homePage.clickBookCategory();
        homePage.clickChildren();
        homePage.clickThird();
        homePage.checkProduct("Ters Olan Bir Şeyler Var!: Eğlenceli Ara-Bul Kitabı");
    }

    @Test(description = "Add product to basket")
    public void add_product_to_basket() throws InterruptedException {
        loginpage.login();
        homePage.clickBookCategory();
        homePage.clickChildren();
        Thread.sleep(2000);
        homePage.clickThird();
        homePage.addBasket();
        homePage.basketMessageController("Sepete Eklendi");
    }

    @Test (description = "Check the complete purchase button")
    public void check_the_complete_purchase_button() throws InterruptedException {
        loginpage.login();
        homePage.clickBookCategory();
        homePage.clickChildren();
        Thread.sleep(2000);
        homePage.clickThird();
        homePage.addBasket();
        homePage.goBasket();
        homePage.completePurchase();
        Thread.sleep(5000);
        homePage.checkPaymentPage("Sipariş Özeti");
    }

    @Test (description = "Delete list control")
    public void delete_list_control() throws InterruptedException {
        createList();
        Thread.sleep(3000);
        homePage.clickMoreButton();
        homePage.elementToHover2();
        Thread.sleep(3000);
        homePage.clickEditListButton();
        Thread.sleep(2000);
        homePage.clickDeleteListButton();
        homePage.clickYesButton();
    }

    @Test (description = "List creation control")
    public void list_creation_control() throws InterruptedException {
        createList();
        homePage.checkList("Listelerim");
    }

    @Test (description = "Adding address information")
    public void adding_address_information() throws InterruptedException {
        loginpage.login();
        homePage.elementToHover();
        Thread.sleep(2000);
        homePage.clickMyAccountButton();
        homePage.clickAddressButton();
        homePage.clickAddAddress();
        homePage.enterAddressNameLastname("Gunes Gulay");
        homePage.enterPhoneNumber("5069873513");
        homePage.enterAddressLine1("Ev");
        homePage.enterAddressLine2("Mavi Apt. Daire:10 Kat:4");
        homePage.waitCityOptions("İ", "S");
        homePage.clickCity();
        homePage.waitDistrictOptions("K","A");
        homePage.clickDistrict();
        homePage.waitNeighborhoodOptions("B","O");
        homePage.clickNeighborhood();
        homePage.clickAddAddressButton();
        homePage.addressMessageController("Adres kaydedildi");
    }

    @Test (description = "Adding an address by leaving the address details blank")
    public void adding_an_address_by_leaving_the_address_details_blank() throws InterruptedException {
        loginpage.login();
        homePage.elementToHover();
        Thread.sleep(2000);
        homePage.clickMyAccountButton();
        homePage.clickAddressButton();
        homePage.clickAddAddress();
        homePage.clickAddAddressButton();
        homePage.errorMessageForAddress("Lütfen bir isim girin.");
    }

    @Test (description = "Successful user logout")
    public void successful_user_logout() throws InterruptedException {
        loginpage.login();
        homePage.elementToHover();
        Thread.sleep(2000);
        homePage.clickLogoutButton();
        homePage.logoutMessageController("Giriş yap");
    }
}
