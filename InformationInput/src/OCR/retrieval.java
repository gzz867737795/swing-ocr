/**
 * 
 */
package OCR;

import java.io.File;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * @author 光头强
 *
 */
public class retrieval {

	
 // 输入图片路径识别文字  path
	String distinGuish(String path) {
		//File img=new File("D:\\ee\\eurotext.png");
		File img=new File(path);
		ITesseract instance=new Tesseract();
		 instance.setLanguage("chi_sim");//添加中文字库  
		 System.out.println(img.canRead());//判读是否可读
		String sesult=null;
	try {
		sesult = instance.doOCR(img);
		//System.out.println(sesult);
	} catch (TesseractException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	return sesult;

	}

//	//得到企业名称和企业注册号
//	String  enterpriseinformation(){
//		String info="dwefdwe 企业注册号:257328ds5357325 vdsf   企业名称:fdsewrfsf ewtrw";
//		String id="[企业注册号:](\\d.*\\d+)";  //正则企业注册号:
//		String name="企业名称:(\\S*)";
//		//String re="\\b( |\n).*?((大学)|(公司))\\b";	
//		Pattern p=Pattern.compile(name);
//		Matcher m=p.matcher(info);  
//		String temp=null;
//		  while(m.find()){
//		  // System.out.println(m.group(1));
//		    temp=m.group(1);
//			  }
//		 return temp;//group（0）就是指的整个串，group（1） 指的是第一个括号里的东西，group（2）指的第二个括号里的东西。
//	}
//	
	
}
