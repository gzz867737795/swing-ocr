package OCR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Re {
	//�õ���ҵ���ƺ���ҵע���
	String enterpriseid(String strings){
		String id="��ҵע��� : (\\d.*\\d+)";  //������ҵע���:
		//String re="\\b( |\n).*?((��ѧ)|(��˾))\\b";	
		Pattern p=Pattern.compile(id);
		Matcher m=p.matcher(strings);  
		String temp1=null;
		  while(m.find()){
		  // System.out.println(m.group(1));
		    temp1=m.group(1);
			  }
		 return temp1;//group��0������ָ����������group��1�� ָ���ǵ�һ��������Ķ�����group��2��ָ�ĵڶ���������Ķ�����
	}
	String  enterprisename(String str2){
		String name="��ҵ���� :(.*)";
		//String re="\\b( |\n).*?((��ѧ)|(��˾))\\b";	
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
