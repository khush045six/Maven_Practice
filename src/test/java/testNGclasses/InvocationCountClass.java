package testNGclasses;
import org.testng.annotations.Test;

public class InvocationCountClass {
    @Test(invocationCount = 7, invocationTimeOut = 1)
    public void method1(){
        System.out.println("METHOD 1");
    }
}
