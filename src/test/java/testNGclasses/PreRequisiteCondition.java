package testNGclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PreRequisiteCondition {

    public static WebDriver driver;

    @BeforeMethod(groups = {"smoke"})
    public void preRequisite(){
        driver = new ChromeDriver();
    }
    @Test(groups = {"smoke"})
    public void testCase1(){
        Assert.assertTrue(true);
        driver.get("https://www.facebook.com/");
        System.out.println(" TESTNG BASICS CLASS ");
    }

    @Test(dependsOnGroups = {"smoke"})
    public void testCase2(){
        driver.get("https://www.amazon.in/");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
