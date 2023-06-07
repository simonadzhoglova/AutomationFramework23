package com.soucedemo;

import Base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UnsuccessfulLogin extends TestUtil {

    @DataProvider (name = "InvalidCredentials")
    public Object [][] getCredentials(){
        return new Object[][]{
                {"invalidUsername","secret_sauce"},
                {"standard_user","invalidPassword"},
                {"invalid","invalid"}
        };
    }

    @Test(dataProvider = "InvalidCredentials")
    public void UnsuccessfulLoginSauceDemo(String username, String password){

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("username");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("password");

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        WebElement ErrorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertTrue(ErrorMessage.isDisplayed());
    }

}
