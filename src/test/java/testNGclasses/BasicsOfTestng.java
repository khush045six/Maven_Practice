package testNGclasses;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class BasicsOfTestng {
     @Test
    public void testCase1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        System.out.println(" TESTNG BASICS CLASS ");
         System.out.println("Hello Java");

    }

    @Test
    public void testCase2(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.close();
    }

}
