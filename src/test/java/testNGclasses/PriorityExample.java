package testNGclasses;

import org.testng.annotations.Test;

public class PriorityExample {
    @Test(priority = 1) //4
    public void testCaseA(){
        System.out.println("TEST CASE A");
    }
    @Test(priority = 4) //5
    public void testCaseZ(){
        System.out.println("TEST CASE Z");
    }
    @Test //2
    public void testCaseO(){
        System.out.println("TEST CASE O");
    }
    @Test(priority = -1) //1
    public void testCaseL(){
        System.out.println("TEST CASE L");
    }
    @Test//3
    public void testCaseW(){
        System.out.println("TEST CASE W");
    }
}
