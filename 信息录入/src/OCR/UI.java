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
	  ArrayList<String> image = new ArrayList<String>(); //ͼƬ��·��  
	   ArrayList<String> id = new ArrayList<String>();
	   ArrayList<String> name = new ArrayList<String>();
	public UI(){
		
		//ָ��ʹ�õ�ǰ��Look&Feelװ�δ��ڡ�
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		//�������趨�رմ��ڲ���
		JFrame frame = new JFrame("��ҵ��Ϣ��������");
		 //���ô������Ͻ�����ʾ�����Ͻǵ����꣬     

		frame .setLocation(300,300);           //����ʾ���ϱ�Ե300���أ�����ʾ�����Ե300����

		//frame .setSize(300,200);            //���ô���Ĵ�СΪ300*200���ش�С

		frame .setResizable(false);       //���ô����Ƿ���Ե�����С������Ϊ����ֵ

        //���ô���ɼ���û�и���䣬���彫���ɼ������������У�����û�н����û�����������

		//frame .setVisible( true);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�������
		JPanel panel = new JPanel();
		//������
		frame.add(panel);
		
		//��ʾ����
		frame.pack();
		frame.setSize(600, 300);
		frame.setVisible(true);
		//������ʱ����Ϊnull
		panel.setLayout(null);
		
		//����Jlabel
		JLabel fileLabel = new JLabel("�ļ�·����");
		//������ʾλ��
		fileLabel.setBounds(10, 20, 80, 25);
		panel.add(fileLabel);
		
		//�����ı���������ʾѡ���ļ�·��
		fileText = new JTextField(20);
		fileText.setBounds(80, 20, 165, 25);
		panel.add(fileText);
		
		
		//����ѡ���ļ���ť
		fileButton = new JButton("ѡ���ļ���");
		fileButton.setBounds(260, 20, 150, 25);
		panel.add(fileButton);
		fileButton.addActionListener(this);   
		
		//������ʼ������ť
		statButton = new JButton("��ʼ����");
		statButton.setBounds(480, 20, 100, 25);
		panel.add(statButton);
		statButton.addActionListener(this);  
		
		//����Jlabel
		//JLabel sava_fileLabel = new JLabel("�洢·����");
		//������ʾλ��
		//sava_fileLabel.setBounds(10, 70, 80, 25);
	//	panel.add(sava_fileLabel);
		
		//�����ı���������ʾѡ���ļ�·��
		//sava_fileText = new JTextField(20);
		//sava_fileText.setBounds(80, 70, 165, 25);
	//	panel.add(sava_fileText);
		
		//�������Ϊ��ť
	//	saveButton = new JButton("���Ϊ");
	//	saveButton.setBounds(260, 70, 150, 25);
		//panel.add(saveButton);
		//saveButton.addActionListener(this);   
	}
	public void  actionPerformed(ActionEvent e){ 
		 
		 
		//���ļ���ť
	    if(e.getSource()==fileButton){ 
	      fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
	      int intRetVal = fc.showOpenDialog(this);        //���ļ�
	      if( intRetVal == JFileChooser.APPROVE_OPTION){ 
	        fileText.setText(fc.getSelectedFile().getPath()); 
	        String s = fileText.getText();	   
	      // System.out.println(s);  //������ļ�text������   
           image=GetImgParh.pfile(s);  //ͼƬ��·��  
           //����ü�֮���ͼƬ
           for (String str :  image) {
        	   try {
				cutimage.cut(str);
			} catch (IOException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		}
           image=GetImgParh.pfile("C:\\OCR");

	    }
	   } 
//	    //ʵ�����Ϊ�¼�
//	     if(e.getSource() == saveButton){
//		      fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
//		      int intRetVal1 = fc.showSaveDialog(this);       //�����ļ�
//		      if( intRetVal1 == JFileChooser.APPROVE_OPTION){ 
//		    	  sava_fileText.setText(fc.getSelectedFile().getPath()); 
//		    	  String ss = sava_fileText.getText();  //Ҫ���浽���ļ��е�·�� 	 
//		    	  //System.out.println(ss);	
//		    	  w.write(name, id, ss);
//		      }   
//	    }
	    
	    //��ʼ������ť
	   if(e.getSource() == statButton){
	    	for (String string : image) {   	
	    		s=v.distinGuish(string);
	    		id.add(r.enterpriseid(s));//������ҵid
	    		name.add(r.enterprisename(s));//��ҵ����	 	    	
			}
	    	  //����Ŀ¼
            File file3=new File("C:\\OCR\\R");
			if(!file3.exists())
			{
				
			file3.mkdirs();	
			}
	    	w.write(name, id, "C:\\OCR\\R");
	    	
	   }
	   
	}
}
