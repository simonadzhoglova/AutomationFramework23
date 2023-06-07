package testsPOM;

import Base.TestUtil;
import Pages.LoginPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends TestUtil {

    @Test
    public void addItemToCart(){
        LoginPage loginTest = new LoginPage(driver);
        ProductPage productPage = loginTest.login("standard_user", "secret_sauce");

        productPage.addItemToTheCart("bolt-t-shirt");
        Assert.assertEquals(productPage.getItemsInCart(),1);

        productPage.addItemToTheCart("backpack");
        Assert.assertEquals(productPage.getItemsInCart(),2);

    }
}
