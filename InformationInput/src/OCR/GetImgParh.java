package OCR;

import java.io.File;
import java.util.ArrayList;

public class GetImgParh {
	/**
	 * ���ļ�����ȡ��ͼƬ������ȡͼƬ·��
	 * @return 
	 */
	public static ArrayList<String> pfile(String path){
		JudgeImg imageCheck = new JudgeImg();
//		UI ui=new UI();
//		
//		String text = ui.getOutpath();
		String str = path.replaceAll("\'", "\\'"); 
		//System.out.println(str);	
		File file = new File(str);           //��ȡ·��
        File [] files = file.listFiles();    //��������
        String r =null;  
        ArrayList<String> list=new ArrayList<String>();
        //�����ļ����������ͼƬ
        for (int i = 0; i < files.length; i++)
        {   
            File file1 = files[i];
            
            //����ImagerCheck�࣬�ж��Ƿ�ΪͼƬ
            if (imageCheck.isImage(file1)){
	            file1.getName();   //���ݺ�׺�ж�
	             r = str + "\\" + file1.getName();   //��ȡͼƬ·��
	           // System.out.println(r);
	            list.add(r);
            }   		
        }
        return  list;
       
	}
	
}

