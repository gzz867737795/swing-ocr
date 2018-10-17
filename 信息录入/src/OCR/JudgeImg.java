package OCR;

import java.io.File;

import javax.activation.MimetypesFileTypeMap;

public class JudgeImg {
	/**
	 * @author 判断是否为图片类
	 *
	 */
	private  MimetypesFileTypeMap mtftp;

    public JudgeImg(){
        mtftp = new MimetypesFileTypeMap();
        // 不添加下面的类型会造成误判 
        mtftp.addMimeTypes("image png tif jpg jpeg bmp");
    }
    public  boolean isImage(File file){
        String mimetype= mtftp.getContentType(file);
        String type = mimetype.split("/")[0];
        return type.equals("image");
    }
}
