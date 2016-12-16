package util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.IOException;

public class XlxsUtil {
	public static void main(String[] args) {
		try {
			read(new File("E:/test.xls"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String[][] read(File file) throws IOException{
	
	NPOIFSFileSystem fs = new NPOIFSFileSystem(file);
	HSSFWorkbook wb = new HSSFWorkbook(fs.getRoot(), true);
	Sheet sheet1 = wb.getSheetAt(0);
	for(int rowIndex =0 ;rowIndex<=sheet1.getLastRowNum();rowIndex++){
		Row row = sheet1.getRow(rowIndex);
		if(row==null) {
			continue;
		}
		
		
	}
	
	int firstCell=0;
    for (Row row : sheet1) {
    
        for (Cell cell : row) {
        	firstCell++;
            CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
            System.out.print(cellRef.formatAsString());
            System.out.print(" - ");
            if(cell.getCellType()==Cell.CELL_TYPE_STRING){
            	System.out.println(cell.getRichStringCellValue().getString());
            }
           
            else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
            	 if (DateUtil.isCellDateFormatted(cell)) {
                     System.out.println(cell.getDateCellValue());
                 } else {
                     System.out.println(cell.getNumericCellValue());
                 }
            }
            else if( cell.getCellType()==Cell.CELL_TYPE_FORMULA){
                System.out.println( cell.getNumericCellValue());
            }
            else{
            	System.out.println("");
            }
                    
            
        }
    }
	
	fs.close();
	 return null;
	}
}
