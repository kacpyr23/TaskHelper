package pl.koziol.taskhelper.finances.excelimporter;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;

@Service
public class ExcelImporterService {
	
	public void importData(MultipartFile file) {
		try (InputStream inputStream = file.getInputStream()) {
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.rowIterator();
			Row row = rowIterator.next();
			while (rowIterator.hasNext()){
				row = rowIterator.next();
				int day = (int)row.getCell(0).getNumericCellValue();
				String type = row.getCell(1).getStringCellValue();
				String name = row.getCell(2).getStringCellValue();
				BigDecimal amount = new BigDecimal(row.getCell(3).getNumericCellValue());
				System.out.println(day + " " + type + " " + name + " " + amount);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
