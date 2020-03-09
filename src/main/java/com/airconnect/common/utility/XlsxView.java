package com.airconnect.common.utility;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.airconnect.buyer.model.Buyer;

@Component
public class XlsxView extends AbstractXlsxView {
	
	// private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"my-xlsx-file.xlsx\"");

        @SuppressWarnings("unchecked")
        List<Buyer> buyers = (List<Buyer>) model.get("buyer");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Spring MVC AbstractXlsxView");

        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Name");
       // header.createCell(2).setCellValue("Date");

        // Create data cells
        int rowCount = 1;
        for (Buyer buyer : buyers){
            Row buyerRow = sheet.createRow(rowCount++);
            buyerRow.createCell(0).setCellValue(buyer.getId());
            buyerRow.createCell(1).setCellValue(buyer.getBuyerName());
          //  buyerRow.createCell(2).setCellValue(DATE_FORMAT.format(course.getDate()));
        }

    }

}
