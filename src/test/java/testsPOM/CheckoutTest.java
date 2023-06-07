package testsPOM;

import Base.TestUtil;
import Pages.CheckoutPage;
import Pages.LoginPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends TestUtil {

    @Test
    public void Checkout(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage prPage = loginPage.login("standard_user", "secret_sauce");

        ProductPage productPage= new ProductPage(driver);
        productPage.addItemToTheCart("bolt-t-shirt");
        Assert.assertEquals(productPage.getItemsInCart(),1);

        productPage.addItemToTheCart("backpack");
        Assert.assertEquals(productPage.getItemsInCart(),2);

        CheckoutPage checkoutPage = productPage.goToCheckout();
        checkoutPage.checkout("Harry", "Potter", "12345");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

    }
}
