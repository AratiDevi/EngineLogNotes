package commonfunction;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.write.WritableWorkbook;

public class ExcelRead {
	
	XSSFWorkbook wb;
	 
	 XSSFSheet sheet1;
	 
	 XSSFCell Cell;
	 
	 static WritableWorkbook wwb;
	 
	 
	 public ExcelRead(String excelpath)
	 {
	  
	  try
	  {
	//Get the excel file 
		  
	   File src = new File(excelpath);// get the excel  path
	   
	   FileInputStream fis = new FileInputStream(src);// get the excel file path
	   
	   wb = new XSSFWorkbook(fis); // load the excel workbook
	   
	   
	  }
	  catch (Exception e)
	  {
	   System.out.println(e.getMessage());
	  }
	 }
	 
	 //get the excel row and column no
	 
	 public String getData (int Sheetnumber ,int row,int column){
	  
	  sheet1 = wb.getSheetAt(Sheetnumber);
	  
	  Cell = sheet1.getRow(row).getCell(column);
	  
	  String data = CellToString(Cell);
	     
	  return data;
	 }
	 
	//Convert the Cell intr String
	 
	 public String CellToString(XSSFCell Cell)
	 {
	  FormulaEvaluator formulaEvalutor = wb.getCreationHelper().createFormulaEvaluator();
	 
	  Object data = null ; 
	  
	  switch(formulaEvalutor.evaluateInCell(Cell).getCellType())
	  {
	   case 0:
	   data = NumberToTextConverter.toText(Cell.getNumericCellValue());  //Cell.getNumericCellValue();
	   break;
	   
	   case 1:
	   data = Cell.getStringCellValue();
	   break;
	           
	  }
	  return data.toString();
	 }



	 
	 public int getRowCount(int sheetIndex){
	  
	  int row = wb.getSheetAt(sheetIndex).getLastRowNum();
	  
	  row = row + 1;
	   
	  return row; 
	 }

	 public int getColumnCount(int sheetIndex){
	  
	  int column = sheet1.getRow(0).getLastCellNum();
	  
	  column = column + 1;
	  
	  return column;
	    
	 }

}
