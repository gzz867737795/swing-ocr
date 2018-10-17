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
	 // 裁剪图片
    void cut(String path) throws IOException {
        String type = "png";
        // 裁剪的位置
        int x = 0;
        int y = 0;
        int width = 630;
        int height = 200;

        // 文件地址
        File file = new File(path);
        InputStream input = new FileInputStream(file); 
        ImageInputStream imageStream = null;
        try {
            // 图片类型 默认 png
            String imageType = (null == type || "".equals(type)) ? "png" : type;
            // 将图片转化为 imageReader
            Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(imageType);
            ImageReader reader = readers.next();
            // 读入图片
            imageStream = ImageIO.createImageInputStream(input);
            reader.setInput(imageStream, true);
            // 参数
            ImageReadParam param = reader.getDefaultReadParam();
            // 图片裁剪范围
            Rectangle rect = new Rectangle(x, y, width, height);
            param.setSourceRegion(rect);
            // 裁剪出图片
            BufferedImage bi = reader.read(0, param);
          //获取当前时间
			Date day=new Date();    
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String time=df.format(day);
			//System.out.println(time);
			  //创建目录
            File file3=new File("C:\\OCR");
			if(!file3.exists())
			{
				
			file3.mkdir();	
			}
			String path1="C:\\OCR\\"+time+".png";
            // 输出达到文件夹
            ImageIO.write(bi, imageType, new File(path1)); 
        } catch (Exception e) {

        } finally {
            // 关闭stream
            imageStream.close();
        }
    }
}
