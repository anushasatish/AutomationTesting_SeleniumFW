package Demo;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.IOException;


public class ExcelDemoDataProvider
{
    XSSFWorkbook wb;


        @DataProvider (name = "ExcelData")
        public Object[][] exceldp(){

        {
            String location = "/Users/dank/Downloads/IntellijProjects/AutomationTesting_SeleniumFW/src/main/resources/TestData.xlsx";

            try {
                wb = new XSSFWorkbook(location);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            XSSFSheet sheet = wb.getSheet("login");

            //System.out.println(sheet.getLastRowNum());

            int numOfRows = sheet.getLastRowNum() +1;
            int numOfColumns = sheet.getRow(0).getLastCellNum();

            String[][] data = new String[numOfRows -1][numOfColumns];

            for (int i = 1; i< numOfRows; i ++)
            {
                XSSFRow row = sheet.getRow(i);

                data[i-1][0] = row.getCell(0).getStringCellValue();
                data[i-1][1] = row.getCell(1).getStringCellValue();
                data[i-1][2] = row.getCell(2).getStringCellValue();
            }

            return data;
        }
    }

}
