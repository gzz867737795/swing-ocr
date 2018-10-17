package OCR;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UI  extends Frame implements ActionListener {
	JTextField fileText; 
	JTextField sava_fileText;
	JButton fileButton; 
	JButton saveButton; 
	JButton statButton;
	String s;
	JFileChooser fc = new JFileChooser();
	GetImgParh img=new GetImgParh();
	 retrieval v=new retrieval();
	 Re r=new Re();
	 execl_w w=new execl_w();
	 CutImage cutimage=new CutImage();
	  ArrayList<String> image = new ArrayList<String>(); //图片的路径  
	   ArrayList<String> id = new ArrayList<String>();
	   ArrayList<String> name = new ArrayList<String>();
	public UI(){
		
		//指定使用当前的Look&Feel装饰窗口。
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		//创建并设定关闭窗口操作
		JFrame frame = new JFrame("企业信息检索工具");
		 //设置窗体左上角与显示屏左上角的坐标，     

		frame .setLocation(300,300);           //离显示屏上边缘300像素，里显示屏左边缘300像素

		//frame .setSize(300,200);            //设置窗体的大小为300*200像素大小

		frame .setResizable(false);       //设置窗体是否可以调整大小，参数为布尔值

        //设置窗体可见，没有该语句，窗体将不可见，此语句必须有，否则没有界面就没有如何意义了

		//frame .setVisible( true);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//创建面板
		JPanel panel = new JPanel();
		//添加面板
		frame.add(panel);
		
		//显示窗口
		frame.pack();
		frame.setSize(600, 300);
		frame.setVisible(true);
		//布局暂时设置为null
		panel.setLayout(null);
		
		//创建Jlabel
		JLabel fileLabel = new JLabel("文件路劲：");
		//设置显示位置
		fileLabel.setBounds(10, 20, 80, 25);
		panel.add(fileLabel);
		
		//创建文本域用于显示选中文件路径
		fileText = new JTextField(20);
		fileText.setBounds(80, 20, 165, 25);
		panel.add(fileText);
		
		
		//创建选择文件按钮
		fileButton = new JButton("选择文件夹");
		fileButton.setBounds(260, 20, 150, 25);
		panel.add(fileButton);
		fileButton.addActionListener(this);   
		
		//创建开始检索按钮
		statButton = new JButton("开始检索");
		statButton.setBounds(480, 20, 100, 25);
		panel.add(statButton);
		statButton.addActionListener(this);  
		
		//创建Jlabel
		//JLabel sava_fileLabel = new JLabel("存储路劲：");
		//设置显示位置
		//sava_fileLabel.setBounds(10, 70, 80, 25);
	//	panel.add(sava_fileLabel);
		
		//创建文本域用于显示选中文件路径
		//sava_fileText = new JTextField(20);
		//sava_fileText.setBounds(80, 70, 165, 25);
	//	panel.add(sava_fileText);
		
		//创建另存为按钮
	//	saveButton = new JButton("另存为");
	//	saveButton.setBounds(260, 70, 150, 25);
		//panel.add(saveButton);
		//saveButton.addActionListener(this);   
	}
	public void  actionPerformed(ActionEvent e){ 
		 
		 
		//打开文件按钮
	    if(e.getSource()==fileButton){ 
	      fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
	      int intRetVal = fc.showOpenDialog(this);        //打开文件
	      if( intRetVal == JFileChooser.APPROVE_OPTION){ 
	        fileText.setText(fc.getSelectedFile().getPath()); 
	        String s = fileText.getText();	   
	      // System.out.println(s);  //输出打开文件text的内容   
           image=GetImgParh.pfile(s);  //图片的路径  
           //输出裁剪之后的图片
           for (String str :  image) {
        	   try {
				cutimage.cut(str);
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
           image=GetImgParh.pfile("C:\\OCR");

	    }
	   } 
//	    //实现另存为事件
//	     if(e.getSource() == saveButton){
//		      fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
//		      int intRetVal1 = fc.showSaveDialog(this);       //保存文件
//		      if( intRetVal1 == JFileChooser.APPROVE_OPTION){ 
//		    	  sava_fileText.setText(fc.getSelectedFile().getPath()); 
//		    	  String ss = sava_fileText.getText();  //要保存到的文件夹的路径 	 
//		    	  //System.out.println(ss);	
//		    	  w.write(name, id, ss);
//		      }   
//	    }
	    
	    //开始检索按钮
	   if(e.getSource() == statButton){
	    	for (String string : image) {   	
	    		s=v.distinGuish(string);
	    		id.add(r.enterpriseid(s));//生成企业id
	    		name.add(r.enterprisename(s));//企业姓名	 	    	
			}
	    	  //创建目录
            File file3=new File("C:\\OCR\\R");
			if(!file3.exists())
			{
				
			file3.mkdirs();	
			}
	    	w.write(name, id, "C:\\OCR\\R");
	    	
	   }
	   
	}
}
