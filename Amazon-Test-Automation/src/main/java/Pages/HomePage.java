package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.Instant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseTest{

    private org.openqa.selenium.JavascriptExecutor JavascriptExecutor;

    @Step("Accept cookies")
    public void acceptCookies() {
        driver.findElement(By.id("sp-cc-accept")).click();
    }

    @Step("Click the first login button")
    public void clickFirstLogin(){
        driver.findElement(By.xpath("//span[@class='nav-line-2 ']/span[@class='nav-icon nav-arrow']")).click();
    }

    @Step("Check the successful login")
    public void checkSuccessfulLogin(String text) {
        String value = driver.findElement(By.xpath("//span[.='test\u200B']")).getText();
        Assert.assertEquals(value, text);
    }

    @Step("Click the book category")
    public void clickBookCategory() {
        driver.findElement(By.xpath("//a[.='Kitap']")).click();
    }

    @Step("Click the children books category")
    public void clickChildren() {
        driver.findElement(By.xpath("//div[@id='s-refinements']//span[.='Çocuk Kitapları']")).click();
    }

    @Step("Click the third book")
    public void clickThird() {
        driver.findElement(By.cssSelector("[alt='Ters Olan Bir Şeyler Var!: Eğlenceli Ara-Bul Kitabı']")).click();
    }

    @Step("Check the product title")
    public void checkProduct(String text){
        String value = driver.findElement(By.id("productTitle")).getText();
        Assert.assertEquals(value, text);
    }

    @Step("Add to basket")
    public void addBasket() {
        driver.findElement(By.id("add-to-cart-button")).click();
    }

    @Step("Add to basket confirmation message")
    public void basketMessageController(String text) {
        String value = driver.findElement(By.cssSelector(".a-size-medium-plus")).getText();
        Assert.assertEquals(value, text);
    }

    @Step("Go to basket")
    public void goBasket() {
        driver.findElement(By.xpath("//span[@id='sw-gtc']//a[contains(.,'Sepete Git')]")).click();
    }

    @Step("Click the complete purchase button")
    public void completePurchase() {
        driver.findElement(By.name("proceedToRetailCheckout")).click();
    }

    @Step("Check the payment page")
    public void checkPaymentPage(String text) {
        String value = driver.findElement(By.xpath("//h3[@class='a-spacing-base a-spacing-top-micro']")).getText();
        Assert.assertEquals(value, text);
    }

    @Step("Hovering over the Account and Lists button")
    public void elementToHover() {
        WebElement elementToHover = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
    }

    @Step("Click the create list")
    public void clickCreateList() {
        driver.findElement(By.xpath("//span[.='Liste Oluşturun']")).click();
    }

    @Step("Click the create a list")
    public void clickCreateAList() {
        driver.findElement(By.cssSelector(".a-button-input")).click();
    }

    @Step("Click the create list button")
    public void clickCreateListButton() {
        driver.findElement(By.xpath("//span[@class='a-button a-button-primary']//input[@class='a-button-input a-declarative']")).click();
    }

    @Step("Check the created list")
    public void checkList(String text) {
        String value = driver.findElement(By.xpath("//a[@href='/hz/wishlist/ls/ref=cm_wl_your_lists']/div[contains(.,'Listelerim')]")).getText();
        Assert.assertEquals(value, text);
    }

    @Step("Click the more button")
    public void clickMoreButton() {
        driver.findElement(By.id("overflow-menu-popover-trigger")).click();
    }

    @Step("Hovering over the edit your list button")
    public void elementToHover2() {
        WebElement elementToHover2 = driver.findElement(By.id("overflow-menu-popover-trigger"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover2).perform();
    }

    @Step("Click the edit your list button")
    public void clickEditListButton() {
        driver.findElement(By.id("editYourList")).click();
    }

    @Step("Click the delete list button")
    public void clickDeleteListButton() {
        driver.findElement(By.xpath("//span[@class='a-button a-spacing-base a-button-base full-width-element']//input[@class='a-button-input']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
    }

    @Step("Click the yes button")
    public void clickYesButton() {
        driver.findElement(By.name("submit.save")).click();
    }

    @Step("Click the My Account button")
    public void clickMyAccountButton() {
        driver.findElement(By.xpath("//span[.='Hesabım']")).click();
    }

    @Step("Click the address button")
    public void clickAddressButton() {
        driver.findElement(By.xpath("//h2[contains(.,'Adres')]")).click();
    }

    @Step("Click the add address")
    public void clickAddAddress() {
        driver.findElement(By.cssSelector(".a-box-inner")).click();
    }

    @Step("Fill the name-lastname field")
    public void enterAddressNameLastname(String text) {
        driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys(text);
    }

    @Step("Fill the phone number field")
    public void enterPhoneNumber(String text) {
        driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys(text);
    }

    @Step("Fill the address line 1 field")
    public void enterAddressLine1(String text) {
        driver.findElement(By.cssSelector("[placeholder='Açık adres, P.O. kutusu, şirket adı, c/o']")).sendKeys(text);
    }

    @Step("Fill the address line 2 field")
    public void enterAddressLine2(String text) {
        driver.findElement(By.cssSelector("[placeholder='Apartman, daire, ünite, bina, kat vb.']")).sendKeys(text);
    }

    @Step("Wait until visibility of city options")
    public void waitCityOptions(String text1, String text2) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        WebElement inputBox = driver.findElement(By.id("address-ui-widgets-enterAddressCity"));
        inputBox.sendKeys(text1);
        Thread.sleep(1000);
        inputBox.sendKeys(text2);
    }

    @Step("Click the city")
    public void clickCity() {
        WebElement clickCity = driver.findElement(By.xpath("//li[.='İstanbul']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(clickCity).click().build().perform();
    }

    @Step("Wait until visibility of district options")
    public void waitDistrictOptions(String text1, String text2) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        WebElement inputBox = driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion"));
        inputBox.sendKeys(text1);
        Thread.sleep(1000);
        inputBox.sendKeys(text2);
    }

    @Step("Click the district")
    public void clickDistrict() {
        WebElement clickDistrict = driver.findElement(By.xpath("//li[.='Kadıköy']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(clickDistrict).click().build().perform();
    }

    @Step("Wait until visibility of neighborhood options")
    public void waitNeighborhoodOptions(String text1, String text2) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        WebElement inputBox = driver.findElement(By.id("address-ui-widgets-enterAddressDistrictOrCounty"));
        inputBox.sendKeys(text1);
        Thread.sleep(1000);
        inputBox.sendKeys(text2);
    }

    @Step("Click the neighborhood")
    public void clickNeighborhood() {
        WebElement clickNeighborhood = driver.findElement(By.xpath("//li[.='Bostancı Mh.']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(clickNeighborhood).click().build().perform();
    }

    @Step("Click the add address button")
    public void clickAddAddressButton() {
        driver.findElement(By.cssSelector(".a-button-input")).click();
    }

    @Step("Add address verification message")
    public void addressMessageController(String text) {
        String value = driver.findElement(By.cssSelector(".a-alert-heading")).getText();
        Assert.assertEquals(value, text);
    }

    @Step("Error message for leaving the address details blank")
    public void errorMessageForAddress(String text) {
        String value = driver.findElement(By.xpath("//div[@id='address-ui-widgets-enterAddressFullName-full-validation-alerts']//div[@class='a-section']")).getText();
        Assert.assertEquals(value, text);
    }

    @Step("Click the logout button")
    public void clickLogoutButton() {
        driver.findElement(By.xpath("//span[.='Çıkış Yap']")).click();
    }

    @Step("Logout message")
    public void logoutMessageController(String text) {
        String value = driver.findElement(By.cssSelector("h1")).getText();
        Assert.assertEquals(value, text);
    }
}

