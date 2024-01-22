package com.lara;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class M3 {
	public static void main(String args) throws Exception
	{

		File f1 = new File("src");
		FileInputStream file = new FileInputStream(f1);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter sheet namr(g,s,e,p)");
		String sheetName = sc.next();
		XSSFWorkbook workbook1 = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook1.getSheetAt(0);
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


