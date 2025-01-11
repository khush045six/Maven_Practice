package testNGclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethodClass {

    @Test
    public void verifyLogin(){
        Assert.assertTrue(false);
        System.out.println("VERIFY LOGIN");
    }
    @Test(dependsOnMethods = {"verifyLogin"})
    public void verifyHomePage(){
        System.out.println("VERIFY HOMEPAGE");
    }
    @Test
    public void verifyOnboarding(){
        System.out.println("VERIFY ONBOARDING");
    }
}
