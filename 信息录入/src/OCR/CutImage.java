package OCR;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class CutImage {
	 // �ü�ͼƬ
    void cut(String path) throws IOException {
        String type = "png";
        // �ü���λ��
        int x = 0;
        int y = 0;
        int width = 630;
        int height = 200;

        // �ļ���ַ
        File file = new File(path);
        InputStream input = new FileInputStream(file); 
        ImageInputStream imageStream = null;
        try {
            // ͼƬ���� Ĭ�� png
            String imageType = (null == type || "".equals(type)) ? "png" : type;
            // ��ͼƬת��Ϊ imageReader
            Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(imageType);
            ImageReader reader = readers.next();
            // ����ͼƬ
            imageStream = ImageIO.createImageInputStream(input);
            reader.setInput(imageStream, true);
            // ����
            ImageReadParam param = reader.getDefaultReadParam();
            // ͼƬ�ü���Χ
            Rectangle rect = new Rectangle(x, y, width, height);
            param.setSourceRegion(rect);
            // �ü���ͼƬ
            BufferedImage bi = reader.read(0, param);
          //��ȡ��ǰʱ��
			Date day=new Date();    
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String time=df.format(day);
			//System.out.println(time);
			  //����Ŀ¼
            File file3=new File("C:\\OCR");
			if(!file3.exists())
			{
				
			file3.mkdir();	
			}
			String path1="C:\\OCR\\"+time+".png";
            // ����ﵽ�ļ���
            ImageIO.write(bi, imageType, new File(path1)); 
        } catch (Exception e) {

        } finally {
            // �ر�stream
            imageStream.close();
        }
    }
}
