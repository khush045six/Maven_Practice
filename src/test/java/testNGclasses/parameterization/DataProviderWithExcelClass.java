package testNGclasses.parameterization;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class DataProviderWithExcelClass {
    @DataProvider(name = "testdata")
    public Object[][] dataFunction() throws IOException {
       Object[][] arraObj = getExcelData("C:\\Users\\User\\Documents\\AutomationPractice.xls", "TestData");
        return arraObj;
    }

    public String[][] getExcelData(String fileName, String sheetName) throws IOException {
        FileInputStream File = new FileInputStream(fileName); //Normal File Access
        HSSFWorkbook wb = new HSSFWorkbook(File); // Excel File Access
        HSSFSheet sheet = wb.getSheet(sheetName);  //SheetName Access
        HSSFRow row = sheet.getRow(0);
        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfColumns = row.getLastCellNum();

        Cell cell;

        String[][] data = new String[noOfRows - 1 ][noOfColumns];

        for(int i = 1; i <= noOfRows-1;i++){
            for (int j = 0;j < noOfColumns; j++){
                row = sheet.getRow(i);
                cell = row.getCell(j);
                data[i-1][j] = cell.getStringCellValue();
            }
        }
          return data;
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
