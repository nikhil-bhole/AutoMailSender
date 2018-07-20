package test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;


public class ReadExcel {
	
	public static LinkedHashMap getMapData() throws Exception {
        
		DataFormatter dataFormatter = new DataFormatter();
		LinkedHashMap<Integer, List<String>> hashMap = new LinkedHashMap<Integer, List<String> >();
		
		try {
			
			FileInputStream file = new FileInputStream(new File("/home/nikhilbhole/eclipse-workspace/Automail/src/test/resources/Excel Files/EmailID.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheetname;
			
			for (int i = 0; i < workbook.getNumberOfSheets(); i++)
            {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator rows = sheet.rowIterator();
                while (rows.hasNext())
                {
                    XSSFRow row = (XSSFRow) rows.next();
                    Iterator cells = row.cellIterator();

                    List<String> data = new ArrayList();
                    while (cells.hasNext())
                    {
                        XSSFCell cell = (XSSFCell) cells.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        data.add(dataFormatter.formatCellValue(cell));
                    }
                    hashMap.put(row.getRowNum(), data);
                }
			workbook.close();
           }
			
		} catch (Exception e) {
			
		}
		return hashMap;

	}
}

