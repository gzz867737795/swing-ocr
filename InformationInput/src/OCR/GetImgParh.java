package OCR;

import java.io.File;
import java.util.ArrayList;

public class GetImgParh {
	/**
	 * 从文件夹中取出图片，并获取图片路径
	 * @return 
	 */
	public static ArrayList<String> pfile(String path){
		JudgeImg imageCheck = new JudgeImg();
//		UI ui=new UI();
//		
//		String text = ui.getOutpath();
		String str = path.replaceAll("\'", "\\'"); 
		//System.out.println(str);	
		File file = new File(str);           //获取路径
        File [] files = file.listFiles();    //定义数组
        String r =null;  
        ArrayList<String> list=new ArrayList<String>();
        //遍历文件夹里的所有图片
        for (int i = 0; i < files.length; i++)
        {   
            File file1 = files[i];
            
            //调用ImagerCheck类，判断是否为图片
            if (imageCheck.isImage(file1)){
	            file1.getName();   //根据后缀判断
	             r = str + "\\" + file1.getName();   //获取图片路径
	           // System.out.println(r);
	            list.add(r);
            }   		
        }
        return  list;
       
	}
	
}

