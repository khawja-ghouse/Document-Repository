package com.lara;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class M2 {
	
	public static void main(String args) throws Exception
	{
		File f1 = new File("test1.xlsx");
		FileInputStream file = new FileInputStream(f1);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		Row row = null;
		while(rowIterator.hasNext())
		{
			row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			Cell cell;
			while(cellIterator.hasNext())
			{
				cell = cellIterator.next();
				System.out.println(cell + "\t");
			}
			System.out.println();
			
			}
			
			
		}
		
	}


