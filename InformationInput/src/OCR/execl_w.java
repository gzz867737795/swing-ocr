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
	        row.createCell(0).setCellValue("��ҵ����");  
	        
	        row.createCell(1).setCellValue("��ҵע���"); 
	    	for (int j = 0; j < name.size(); j++) {			
			    // ����һ�У��ӵڶ��п�ʼ������������
			    Row row1 = sheet.createRow(j+ 1);
			    // �õ�Ҫ�����ÿһ����¼
			    String tname =name.get(j);//dataMap.get("BankName").toString();
			    String tid = id.get(j);	   
			    for (int k = 0; k <= 1; k++) {
				// ��һ����ѭ��
				Cell first = row1.createCell(0);
				first.setCellValue(tname);
		
				Cell second = row1.createCell(1);
				second.setCellValue(tid);
			  
			    }
	  
	        workbook.setSheetName(0, "��ҵ��Ϣ");  
	        try {  
	        	//��ȡ��ǰʱ��
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
