package MYWC;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//���ļ��Ķ�ȡ����
public class FileUtil{
	public BufferedReader gerReader(String fileName)throws Exception{
		File file=new File(fileName);
		if(! file.exists()){
			throw new Exception("�ļ�������");
		}
		FileInputStream input=new FileInputStream(file);
		BufferedReader reader=new BufferedReader(new InputStreamReader(input));
		return reader;
	}
}
