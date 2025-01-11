package mavenclasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MavenBasicExample {
    public static void main(String[] args) {
       WebDriver driver = new ChromeDriver();
       driver.get("https://amazon.in/");

       driver.close();

    }
}
