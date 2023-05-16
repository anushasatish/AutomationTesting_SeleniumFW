package Demo;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelDemo
{

    public static void main(String[] args) throws IOException
    {
        String location = "/Users/dank/Downloads/IntellijProjects/AutomationTesting_SeleniumFW/src/main/resources/TestData.xlsx";
        XSSFWorkbook wb = new XSSFWorkbook(location);

        XSSFSheet sheet = wb.getSheet("login");

       //System.out.println(sheet.getLastRowNum());


       int noofRows = sheet.getLastRowNum() +1;
        for (int i =0; i< noofRows; i ++)
        {
            XSSFRow row = sheet.getRow(i);
            System.out.print(row.getCell(0) + " :: ");
            System.out.print(row.getCell(1) + " :: ");
            System.out.println(row.getCell(2));

        }

    }
}
