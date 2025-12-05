package com.flipkartAutomation.utils;   // <-- keep your existing package

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtil {

    private Sheet sheet;

    // Constructor: pass file path and sheet name
    public ExcelUtil(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet '" + sheetName + "' not found");
            }

        } catch (IOException e) {
            throw new RuntimeException("Excel file not found: " + filePath, e);
        }
    }

    // ✅ For DataProvider (if you want)
    public Object[][] getData() {
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {          // start from 1 to skip header
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = getCellValue(cell);
            }
        }
        return data;
    }

    // ✅ NEW: get a single cell (for Cucumber steps)
    public String getCellData(int rowIndex, int colIndex) {
        Row row = sheet.getRow(rowIndex);
        if (row == null) return "";
        Cell cell = row.getCell(colIndex);
        return getCellValue(cell);
    }

    // helper to convert any cell to String
    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }
 // Get one full row as key-value (header -> cell value)
    public Map<String, String> getRowData(int rowIndex) {
        Map<String, String> rowData = new HashMap<>();

        Row headerRow = sheet.getRow(0);          // header
        Row row       = sheet.getRow(rowIndex);   // data row

        if (row == null) return rowData;

        int colCount = headerRow.getPhysicalNumberOfCells();

        for (int col = 0; col < colCount; col++) {
            String header = getCellValue(headerRow.getCell(col));   // column name
            String value  = getCellValue(row.getCell(col));         // actual data
            rowData.put(header, value);
        }
        return rowData;
    }
}