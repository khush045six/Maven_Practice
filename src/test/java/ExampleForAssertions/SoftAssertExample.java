package ExampleForAssertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {
    @Test(description = "verify page text, bmw radio button and enabled text box on practice page")
    public void verifyPracticePage() {
        SoftAssert ast = new SoftAssert();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();

        WebElement bmwradiobutton = driver.findElement(By.id("bmwradio"));
        WebElement Text = driver.findElement(By.xpath("//h1[text()='Practice Page']"));
        WebElement enabledtextbox = driver.findElement(By.id("enabled-example-input"));
        ast.assertFalse(bmwradiobutton.isSelected(), "bmw radio button should not be selected by default");
        ast.assertEquals(Text.getText(), "Practice Page", "Practice Page Text should be displayed");
        ast.assertTrue(enabledtextbox.isEnabled(), "enabled textbox should be enabled");

        ast.assertAll();


    }
}