package MYWC;
//�ж�ע���е��߼��������c���ԣ�
public class Annotation {
	public boolean flag = false;

	//�п�
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

	//�ж��Ƿ�Ϊ����ע��
	public boolean simpleNote(String str) {
		if (flag == false && str.trim().startsWith("//")) {
			return true;

		} else {
			return false;
		}
	}

	//�ж��Ƿ�Ϊ����ע���е�ע�ʹ���
	public boolean isCode(String str) {
		if (flag == false && (!str.trim().startsWith("/*"))) {
			return true;
		} else {
			return false;
		}
	}

	//�ж�ע���Ƿ����
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