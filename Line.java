package MYWC;
//输出的行数情况
public class Line {

	public int wlhLine=0;//总行数
	public int zshLine=0;//注释行
	public int dmhLine=0;//代码行
	public int khLine=0;//空行
	
	public int getWlhLine(){
		return wlhLine;
	}
	public void setWlhLine(int wlhLine){
		this.wlhLine=wlhLine;
	}
	
	public int getZshLine() {
		return zshLine;
	}
	public void setZshLine(int zshLine) {
		this.zshLine = zshLine;
	}
	
	public int getDmhLine() {
		return dmhLine;
	}
	public void setDmhLine(int dmhLine) {
		this.dmhLine = dmhLine;
	}
	
	public int getKhLine() {
		return khLine;
	}
	public void setKhLine(int khLine) {
		this.khLine = khLine;
	}


}