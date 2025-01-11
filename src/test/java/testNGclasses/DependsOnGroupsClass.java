package testNGclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnGroupsClass {

    @Test(groups = {"smoke"})
    public void verifyAddAccountInPayee(){
        Assert.assertTrue(true);
        System.out.println("verify add account in payee");


    }

    @Test(dependsOnGroups = {"smoke"})
    public void verifyFundTransfer(){
        System.out.println("verify fund transfer");
    }

    @Test(dependsOnGroups = {"smoke"})
    public void verifyCashBackOffer(){
        System.out.println("verify cash back offer");
    }

}
