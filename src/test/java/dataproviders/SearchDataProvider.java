package dataproviders;

import Utils.ExcelUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class SearchDataProvider {

    @DataProvider(name="search")
    public Object[][] getData() throws IOException
    {


        String filePath = "src/test/resources/Input_file.xlsx";

        ExcelUtils excelUtils=new ExcelUtils(filePath);

        int totalrows=excelUtils.getRowCount("Sheet1");
        int totalcols=excelUtils.getCellCount("Sheet1",1);

        String loginData[][]=new String[totalrows][totalcols];


        for(int i=1;i<=totalrows;i++) //1
        {
            for(int j=0;j<totalcols;j++) //0
            {
                loginData[i-1][j]=excelUtils.getCellData("Sheet1", i, j);
            }

        }

        return loginData;

    }
}
