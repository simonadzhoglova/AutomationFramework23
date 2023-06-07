package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {
    private final static String Product_ID = "add-to-cart-sauce-labs-";
    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement userMenu;

    @FindBy(id = "shopping-cart-container")
    private WebElement shoppingCart;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addItemToTheCart(String itemName){
        WebElement itemToBeAdded = driver.findElement(By.id(Product_ID + itemName));
        itemToBeAdded.click();
    }

    public int getItemsInCart(){
        return Integer.parseInt(shoppingCartBadge.getText());
    }

    public CheckoutPage goToCheckout() {
        shoppingCartBadge.click();
        checkoutBtn.click();
        return new CheckoutPage(driver);
    }
}

