package testNGclasses;

import org.testng.annotations.*;

public class AfterandBeforeClass {
    @BeforeClass(groups = {"smoke"})
    public void beforeClass() {
        System.out.println("Before class");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
    @BeforeMethod
    public void beforemethod() {
        System.out.println("BEFORE METHOD");
    }

    @Test(groups = {"smoke"})
    public void demo_1() {
        System.out.println("DEMO1");
    }

    @Test
    public void demo_2() {
        System.out.println("DEMO2");
    }

    @Test
    public void demo_3() {
        System.out.println("DEMO3");
    }

    @AfterMethod
    public void aftermethod() {
        System.out.println("AFTER METHOD");
    }
}
