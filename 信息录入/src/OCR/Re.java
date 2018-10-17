package OCR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Re {
	//得到企业名称和企业注册号
	String enterpriseid(String strings){
		String id="企业注册号 : (\\d.*\\d+)";  //正则企业注册号:
		//String re="\\b( |\n).*?((大学)|(公司))\\b";	
		Pattern p=Pattern.compile(id);
		Matcher m=p.matcher(strings);  
		String temp1=null;
		  while(m.find()){
		  // System.out.println(m.group(1));
		    temp1=m.group(1);
			  }
		 return temp1;//group（0）就是指的整个串，group（1） 指的是第一个括号里的东西，group（2）指的第二个括号里的东西。
	}
	String  enterprisename(String str2){
		String name="企业名称 :(.*)";
		//String re="\\b( |\n).*?((大学)|(公司))\\b";	
		Pattern p=Pattern.compile(name);
		Matcher m=p.matcher(str2);  
		String temp2=null;
		  while(m.find()){
		  // System.out.println(m.group(1));
		    temp2=m.group(1);
			  }
		 return temp2;
	}
	
}
