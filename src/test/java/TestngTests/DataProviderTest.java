package TestngTests;

import Demo.ExcelDemoDataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderTest
{

    @Test(dataProvider = "ExcelData", dataProviderClass = ExcelDemoDataProvider.class)
    public void TestExcel(String[] a)
    {
        System.out.print(a[0] + " :: ");
        System.out.print(a[1] + " :: ");
        System.out.println(a[2]);

    }

}
