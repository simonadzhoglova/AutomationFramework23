package testsPOM;

import Base.TestUtil;
import Pages.LoginPage;
import Pages.ProductPage;
import org.testng.annotations.Test;

public class LoginTest extends TestUtil {

    @Test
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage prPage = loginPage.login("standard_user", "secret_sauce");
    }
}
