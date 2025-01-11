package testNGclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AfterAndBeforeMethodClass {

    @BeforeMethod
    public void beforemethod() {
        System.out.println("BEFORE METHOD");
    }

    @Test
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
