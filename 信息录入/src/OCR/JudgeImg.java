package OCR;

import java.io.File;

import javax.activation.MimetypesFileTypeMap;

public class JudgeImg {
	/**
	 * @author �ж��Ƿ�ΪͼƬ��
	 *
	 */
	private  MimetypesFileTypeMap mtftp;

    public JudgeImg(){
        mtftp = new MimetypesFileTypeMap();
        // �������������ͻ�������� 
        mtftp.addMimeTypes("image png tif jpg jpeg bmp");
    }
    public  boolean isImage(File file){
        String mimetype= mtftp.getContentType(file);
        String type = mimetype.split("/")[0];
        return type.equals("image");
    }
}
