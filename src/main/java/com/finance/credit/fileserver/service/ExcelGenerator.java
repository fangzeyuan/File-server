package com.finance.credit.fileserver.service;

import com.finance.credit.fileserver.model.MockResultSet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

public class ExcelGenerator {
    public static void generate() throws SQLException, IOException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        int rowNum = 0;
        MockResultSet resultsList = new MockResultSet();



        for (Object[] row : resultsList.getRows()) {
            Row excelRow = sheet.createRow(rowNum++);
            int cellNum = 0;
            for (Object obj : row) {
                Cell cell = excelRow.createCell(cellNum++);
                if (obj != null) {
                    cell.setCellValue(obj.toString());
                } else {
                    cell.setCellValue("");
                }
            }
        }

        String filePath = "path/to/file.xlsx";
        File file = new File(filePath);
        File parentDir = file.getParentFile();

        if (!parentDir.exists()) {
            boolean created = parentDir.mkdirs();

            if (!created) {
                System.out.println("无法创建文件目录");
                return;
            }
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            // 其他文件操作代码...
            System.out.println("文件创建成功");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            System.out.println("文件写入成功");

        } catch (IOException e) {
            System.out.println("文件创建失败: " + e.getMessage());
        }



    }
}

