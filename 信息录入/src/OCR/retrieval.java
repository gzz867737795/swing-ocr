/**
 * 
 */
package OCR;

import java.io.File;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * @author ��ͷǿ
 *
 */
public class retrieval {

	
 // ����ͼƬ·��ʶ������  path
	String distinGuish(String path) {
		//File img=new File("D:\\ee\\eurotext.png");
		File img=new File(path);
		ITesseract instance=new Tesseract();
		 instance.setLanguage("chi_sim");//��������ֿ�  
		 System.out.println(img.canRead());//�ж��Ƿ�ɶ�
		String sesult=null;
	try {
		sesult = instance.doOCR(img);
		//System.out.println(sesult);
	} catch (TesseractException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
	return sesult;

	}

//	//�õ���ҵ���ƺ���ҵע���
//	String  enterpriseinformation(){
//		String info="dwefdwe ��ҵע���:257328ds5357325 vdsf   ��ҵ����:fdsewrfsf ewtrw";
//		String id="[��ҵע���:](\\d.*\\d+)";  //������ҵע���:
//		String name="��ҵ����:(\\S*)";
//		//String re="\\b( |\n).*?((��ѧ)|(��˾))\\b";	
//		Pattern p=Pattern.compile(name);
//		Matcher m=p.matcher(info);  
//		String temp=null;
//		  while(m.find()){
//		  // System.out.println(m.group(1));
//		    temp=m.group(1);
//			  }
//		 return temp;//group��0������ָ����������group��1�� ָ���ǵ�һ��������Ķ�����group��2��ָ�ĵڶ���������Ķ�����
//	}
//	
	
}
