package MYWC;
//判断注释行的逻辑（仅针对c语言）
public class Annotation {
	public boolean flag = false;

	//判空
	public boolean isNull(String str){
	if(flag==false){
		if(str==null||str.trim().length()<1){
			return true;
		}else{
		return false;
		}
		
		}else{
		return false;
	    }
	}

	//判断是否为单行注释
	public boolean simpleNote(String str) {
		if (flag == false && str.trim().startsWith("//")) {
			return true;

		} else {
			return false;
		}
	}

	//判断是否为多行注释中的注释代码
	public boolean isCode(String str) {
		if (flag == false && (!str.trim().startsWith("/*"))) {
			return true;
		} else {
			return false;
		}
	}

	//判断注释是否结束
	public boolean isMuNote(String str){
		boolean isflag=false;
		if(flag==false&&str.trim().startsWith("/*")){
			if(str.trim().endsWith("/*")){
				flag=false;
			}else{
				flag=true;
			}
		    isflag=true;
		}else if(flag==true&&str.trim().endsWith("*/")){
			flag=false;
			isflag=true;
		}else if(flag==true){
			flag=true;
			isflag=true;
		}
		return isflag;
		}

}