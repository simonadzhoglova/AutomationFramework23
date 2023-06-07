package com.soucedemo;

import Base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class SuccessfulLogin extends TestUtil {

    @DataProvider(name="correctUsers")
    public Object [][] readUsersFromCsv(){
        try{
        CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/correctUsers.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object [][] cvsDataObj = new Object[csvData.size()][2];

            for (int i = 0; i < csvData.size(); i++) {
                cvsDataObj[i] = csvData.get(i);

            }
                return cvsDataObj;
    }catch(IOException e){
            System.out.println("Not possible to find the file");
            return null;
        }catch (CsvException e){
            return null;
        }

    }

    @Test(dataProvider = "correctUsers")
    public void SuccessfulLoginSauceDemo(String username, String password){

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        WebElement MyProfilePageTitle = driver.findElement(By.cssSelector(".title"));
        Assert.assertTrue(MyProfilePageTitle.isDisplayed());

        WebElement MenuButton = driver.findElement(By.id("react-burger-menu-btn"));
        Assert.assertTrue(MenuButton.isEnabled());
        MenuButton.click();

        WebElement LogoutLink = driver.findElement(By.id("logout_sidebar_link"));
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
        //wait2.until(ExpectedConditions.visibilityOf(LogoutLink));
        //Assert.assertTrue(LogoutLink.isDisplayed());


    }
}
