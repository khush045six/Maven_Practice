package testNGclasses.parameterization;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
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

public class AllTypeOfDataExample {
        @DataProvider(name = "testdata")
        public Object[][] dataFunction() throws IOException {
            Object[][] arraObj = getExcelData("C:\\Users\\User\\Documents\\AutomationPractice.xls", "practice");
            return arraObj;
        }

        public Object[][] getExcelData(String fileName, String sheetName) throws IOException {
            FileInputStream File = new FileInputStream(fileName); //Normal File Access
            HSSFWorkbook wb = new HSSFWorkbook(File); // Excel File Access
            HSSFSheet sheet = wb.getSheet(sheetName);  //SheetName Access
            HSSFRow row = sheet.getRow(0);
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfColumns = row.getLastCellNum();



            Object[][] data = new Object[noOfRows - 1 ][noOfColumns];

            for(int i = 1; i < noOfRows;i++){
                for (int j = 0;j < noOfColumns; j++){
                    row = sheet.getRow(i);
                 Cell cell = row.getCell(j);
                    data[i-1][j] = getCellValue(cell);
                }
            }
            return data;
        }
    private Object getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                } else {
                    return cell.getNumericCellValue();
                }
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }


    @Test( dataProvider = "testdata")
        public void verifyNeedOfParameterization(Object NAME,  Object AGE, Object SALARY, Object ISLIVINGINPUNE){
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            WebElement SearchTextBox = driver.findElement(By.name("q"));
            SearchTextBox.sendKeys(NAME + " "+ AGE + " " + SALARY + " " + ISLIVINGINPUNE );
            SearchTextBox.sendKeys(Keys.ENTER);

            driver.close();
        }
    }


