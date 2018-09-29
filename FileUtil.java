package MYWC;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//对文件的读取操作
public class FileUtil{
	public BufferedReader gerReader(String fileName)throws Exception{
		File file=new File(fileName);
		if(! file.exists()){
			throw new Exception("文件不存在");
		}
		FileInputStream input=new FileInputStream(file);
		BufferedReader reader=new BufferedReader(new InputStreamReader(input));
		return reader;
	}
}
