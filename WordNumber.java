package MYWC;
import java.io.BufferedReader;

//统计代码字符数量，单词数量
public class WordNumber {

	private FileUtil fileUtil = new FileUtil();

	public Word getCount(String fileName) {
		Word word = new Word();
		
		try {
			BufferedReader reader = fileUtil.gerReader(fileName);
			String line = reader.readLine();
			StringBuffer buffer = new StringBuffer(line);
			while(line != null){
				line = reader.readLine();
				buffer.append(line);
			}
			word.setCharNumber(buffer.length());
			line = buffer.toString();
			line.replaceAll(";", " ");
			String[] split = line.split(" ");
			
			if(split.length>0){
				String s = split[0];
				char c = s.charAt(0);
				if((c >= 'A' && c<='Z') || (c >= 'a' && c <= 'z') || c=='#'){
					word.setWordNumber(split.length);	
				}

			}else{
				word.setWordNumber(0);
			}
			
					
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return word;
	}

}
