package OCR;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class execl_w {
	 @SuppressWarnings("resource")
	void write(ArrayList<String>name,ArrayList<String>id,String path) {  
			Workbook workbook = new XSSFWorkbook();  
	        Sheet sheet = workbook.createSheet("0");  
	        Row row = sheet.createRow(0);  
	        row.createCell(0).setCellValue("企业名称");  
	        
	        row.createCell(1).setCellValue("企业注册号"); 
	    	for (int j = 0; j < name.size(); j++) {			
			    // 创建一行：从第二行开始，跳过属性列
			    Row row1 = sheet.createRow(j+ 1);
			    // 得到要插入的每一条记录
			    String tname =name.get(j);//dataMap.get("BankName").toString();
			    String tid = id.get(j);	   
			    for (int k = 0; k <= 1; k++) {
				// 在一行内循环
				Cell first = row1.createCell(0);
				first.setCellValue(tname);
		
				Cell second = row1.createCell(1);
				second.setCellValue(tid);
			  
			    }
	  
	        workbook.setSheetName(0, "企业信息");  
	        try {  
	        	//获取当前时间
				Date day=new Date();    
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
				String time=df.format(day);
				//System.out.println(time);
				String path1=path+"\\"+time+".xlsx";
				//path="\\2018-05-19-15-03-45.xlsx";
	            File file = new File(path1);  
	            FileOutputStream fileoutputStream = new FileOutputStream(file);  
	            workbook.write(fileoutputStream);  
	            fileoutputStream.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  	 
	  }
}
