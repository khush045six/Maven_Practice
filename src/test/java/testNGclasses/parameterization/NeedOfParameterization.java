package testNGclasses.parameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class NeedOfParameterization {

    public static WebDriver driver;

    @Parameters({"browserName"})
    @BeforeMethod
    public void setUp(String browserName ){
        if (browserName.equals("chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equals("edge")) {
            driver = new EdgeDriver();
        }
    }
    @Parameters({"PriceOfCourse", "CourseName"})
    @Test
    public void verifyNeedOfParameterization(String PriceOfCourse, String CourseName){
        SoftAssert ast = new SoftAssert();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

      WebElement SearchTextBox = driver.findElement(By.name("q"));
      SearchTextBox.sendKeys(PriceOfCourse + " "+ CourseName );
      SearchTextBox.sendKeys(Keys.ENTER);



        driver.close();
    }
}
