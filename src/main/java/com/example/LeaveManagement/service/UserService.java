package com.example.LeaveManagement.service;

import com.example.LeaveManagement.Enum.ExcelReportUserHeader;
import com.example.LeaveManagement.model.UserDetails;
import com.example.LeaveManagement.repository.UserRepository;
import com.example.LeaveManagement.request.UserRequest;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    public Optional<UserDetails> findById(int id) {
        Optional<UserDetails> us = repo.findById(id);
        return us;
    }

    public Optional<UserDetails> findByName(String name) {
        Optional<UserDetails> un = repo.findByName(name);
        return un;
    }

    public List<UserDetails> findByreportsTo(String name) {
        List<UserDetails> ur = repo.findByreportsTo(name);
        return ur;

    }

    public UserRequest create(UserRequest userRequest) {
        return repo.save(userRequest);
    }

    public ByteArrayDataSource EmployeeReport(List<UserDetails> employeelist) throws IOException {
        if (employeelist != null) {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("EmployeeList");
            int rowNo = 0;
            Row header = sheet.createRow(rowNo++);
            int column = 0;
            for (ExcelReportUserHeader excelReportHeader : ExcelReportUserHeader.values()) {
                header.createCell(column++).setCellValue(String.valueOf(excelReportHeader));
            }
            for (UserDetails employee : employeelist) {
                int columnNo = 0;
                Row excelData = sheet.createRow(rowNo++);
                excelData.createCell(columnNo++).setCellValue(employee.getId());
                excelData.createCell(columnNo++).setCellValue(employee.getName());
                excelData.createCell(columnNo++).setCellValue(employee.getProjectName());
                excelData.createCell(columnNo++).setCellValue(employee.getReportingManager());
                excelData.createCell(columnNo++).setCellValue(employee.getUseremail());

            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try {
                workbook.write(bos);
            } finally {
                bos.close();
            }
            byte[] excelFileAsBytes = bos.toByteArray();
            ByteArrayDataSource dataSource = new ByteArrayDataSource(excelFileAsBytes, "application/excel");
            return dataSource;
        }
        return null;
    }
}
