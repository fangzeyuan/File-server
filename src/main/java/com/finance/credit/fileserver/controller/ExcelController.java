package com.finance.credit.fileserver.controller;
import com.finance.credit.fileserver.service.ExcelGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/")
public class ExcelController {
    @PostMapping("/generate")
    public void handlePostRequest(@RequestBody YourRequestObject requestObject) throws SQLException, IOException {
        // 处理您的POST请求逻辑
        System.out.print("处理中...");
        ExcelGenerator.generate();
    }
}