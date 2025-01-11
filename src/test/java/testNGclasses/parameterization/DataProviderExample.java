package testNGclasses.parameterization;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

public class DataProviderExample {
     @DataProvider(name = "testdata")
    public Object[][] dataFunction(){
         return new Object[][]{
                 {"Selenium", "Delhi"},{"Java", "Mumbai"}, {"WHAT COURSE ARE YOU DOING?", "I AM DOING AN AUTOMATION COURSE FROM EDSO SERVICES."}
         };
    }
    @Test( dataProvider = "testdata")
    public void verifyNeedOfParameterization(String Course, String City){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement SearchTextBox = driver.findElement(By.name("q"));
        SearchTextBox.sendKeys(Course + " "+ City );
        SearchTextBox.sendKeys(Keys.ENTER);

        driver.close();
    }
}
