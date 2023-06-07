package com.soucedemo;

import Base.TestUtil;
import Pages.LoginPage;
import Pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProblemUserTest extends TestUtil {

    @Test
    public void ProblemUserTestSauceDemo() {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage prPage = loginPage.login("problem_user", "secret_sauce");

        ProductPage productPage = new ProductPage(driver);
        productPage.addItemToTheCart("bike-light");

        WebElement shoppingCartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(shoppingCartBadge.getText(), "1");

        WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-bike-light"));
        Assert.assertFalse(removeButton.isEnabled());

        removeButton.click();
        Assert.assertEquals(shoppingCartBadge.getText(), "1");
        }


    }


