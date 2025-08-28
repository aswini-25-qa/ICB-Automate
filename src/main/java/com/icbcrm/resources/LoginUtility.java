package com.icbcrm.resources;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class LoginUtility
{
    public static Object[][] getTestData(String filePath, String sheetName)
    {
        Object[][] data = null;

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis))
        {
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            //Initialize 2D Object Array
            data = new Object[rowCount][colCount];

            //Read Data from Sheet
            for (int i = 1; i <= rowCount; i++)
            {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++)
                {
                    data[i - 1][j] = row.getCell(j).toString();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return data;
    }


}