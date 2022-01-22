package org.com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.com.runner.BaseClass;

import sun.awt.SunHints.Value;

public class ExcelUtility extends BaseClass{
	public static String ReportPath=System.getProperty("user.dir")+"/src/main/resources";
	public static String CurrentDateAndTime=getCurrentDateAndTime();
	
	
	static public void writeStringValueIntoExcel(String sheetName,List<String> list1,List<String> list2) throws IOException
	{
		ZipSecureFile.setMinInflateRatio(0);
		//FileInputStream ref = new FileInputStream(path);
		
		//FileInputStream ref = new FileInputStream(ReportPath+"/AccessibilityReport"+Calendar.getInstance().getTime()+System.currentTimeMillis()+".xlsx");
		File path=new File(ReportPath+"/AccessibilityReport_"+CurrentDateAndTime+".xlsx");
		if(path.exists())
		{
			FileInputStream ref=new FileInputStream(ReportPath+"/AccessibilityReport_"+CurrentDateAndTime+".xlsx");
			XSSFWorkbook wbw=new XSSFWorkbook(ref);		
			XSSFSheet sheet =wbw.createSheet(sheetName);
			Row header = sheet.createRow(0);
		    header.createCell(0).setCellValue("CSS selectors of elements"); 
		    header.createCell(1).setCellValue("Description"); 
			sheet.setColumnWidth(0, 7000);
			sheet.setColumnWidth(1, 25400);
			sheet.setColumnWidth(2, 18500);
			CellStyle style = wbw.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			Font font=wbw.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			style.setFont(font);;
			for (int i=0; i<list2.size(); i++) {
				if(i==0)
				{
					Row r = sheet.createRow(i+1);
					r.createCell(0).setCellValue(list1.get(i));
					r.createCell(1).setCellValue(list2.get(i));
				}
				else
				{
					Row r = sheet.createRow(i);
					r.createCell(0).setCellValue(list1.get(i));
					r.createCell(1).setCellValue(list2.get(i));
				}
					
			  }
			try {
				FileOutputStream fos =new FileOutputStream(ReportPath+"/AccessibilityReport_"+CurrentDateAndTime+".xlsx");
	            wbw.write(fos);
	            fos.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		else
			{
			FileOutputStream ref=new FileOutputStream(new File(ReportPath+"/AccessibilityReport_"+CurrentDateAndTime+".xlsx"));
			XSSFWorkbook wbw=new XSSFWorkbook();		
			XSSFSheet sheet =wbw.createSheet(sheetName);
			Row header = sheet.createRow(0);
		    header.createCell(0).setCellValue("CSS selectors of elements"); 
		    header.createCell(1).setCellValue("Description"); 
			sheet.setColumnWidth(0, 7000);
			sheet.setColumnWidth(1, 25400);
			sheet.setColumnWidth(2, 18500);
			CellStyle style = wbw.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			Font font=wbw.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			style.setFont(font);;
			//XSSFRow lclRow=sheet.createRow(0);
			//XSSFCell cell = lclRow.createCell(0);
			
			/*List<String> list1=new ArrayList<>();
			List<String> list2=new ArrayList<>();
			for(int i=0;i<value.size();i++)
		    {  if((i%2)!=0)
		    	{
		    		list1.add(value.get(i));
		    	}
		    	if((i%2)==0)
		    	{
		    		list2.add(value.get(i));
		    	}
		    }*/
			for (int i=0; i<list2.size(); i++) {
				if(i==0)
				{
					Row r = sheet.createRow(i+1);
					r.createCell(0).setCellValue(list1.get(i));
					r.createCell(1).setCellValue(list2.get(i));
				}
				else
				{
					Row r = sheet.createRow(i);
					r.createCell(0).setCellValue(list1.get(i));
					r.createCell(1).setCellValue(list2.get(i));
				}
					
			  }
			try {
	            
	            wbw.write(ref);
	            ref.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			}
		
	}
		
	
	static public void writeStringValueIntoExcel_Blue(String path,String sheetName,int row,List<String> value) throws IOException
	{
		ZipSecureFile.setMinInflateRatio(0);
		FileInputStream ref = new FileInputStream(path);
		XSSFWorkbook wbw =new XSSFWorkbook(ref);
		XSSFSheet sheet =wbw.getSheet(sheetName);
		sheet.setColumnWidth(0, 7000);
		sheet.setColumnWidth(1, 25400);
		sheet.setColumnWidth(2, 18500);
		XSSFRow lclRow = sheet.createRow(row);
		
		for(int i=0;i<value.size();i++)
		{
			
			CellStyle style = wbw.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			Font font=wbw.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			style.setFont(font);;
			XSSFCell cell = lclRow.createCell(i);
			cell.setCellValue(value.get(i));
			cell.setCellStyle(style);
		}
		
		
		FileOutputStream fos =new FileOutputStream(path);
		fos.flush();
		wbw.write(fos);
		
		wbw.close();
		fos.close();
		
	}
	
	
	

}
