package MYWC;
import java.io.BufferedReader;

//判断行数情况
public class LineNumber{
	
	public Line getCount(String fileName)throws Exception{
		
		FileUtil wj=new FileUtil();
		
		BufferedReader reader=wj.gerReader(fileName);
			String liner=null;
			Line line=new Line();
			Annotation lj=new Annotation();
			
			while((liner=reader.readLine())!=null){
				if(lj.isNull(liner)){
					line.setKhLine(line.getKhLine()+1);
					line.setWlhLine(line.getWlhLine()+1);
					
				}else if(lj.simpleNote(liner)){
					line.setZshLine(line.getZshLine()+1);
					line.setWlhLine(line.getWlhLine()+1);
					
				}else if(lj.isCode(liner)){
					line.setDmhLine(line.getDmhLine()+1);
					line.setWlhLine(line.getWlhLine()+1);
					
				}else if(lj.isMuNote(liner)){
					line.setZshLine(line.getZshLine()+1);
					line.setWlhLine(line.getWlhLine()+1);
				}
			}
			
			reader.close();
			return line;
		
	}
	

}
