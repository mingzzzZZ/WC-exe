package MYWC;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener{
	
	JLabel charNumber = new JLabel("字符数量");
	JLabel wordNumber = new JLabel("单词数量");
	JLabel wlh=new JLabel("总行数");
	JLabel dmh=new JLabel("代码行");
	JLabel zsh=new JLabel("注释行");
	JLabel kh=new JLabel("空行");
	JLabel filePath=new JLabel("文件路径");
	JTextField text=new JTextField(10);
	JButton bs=new JButton("选择文件");
	JButton result=new JButton("代码读取并统计");
	JButton exit=new JButton("退出");
	
	public Main(){
		
		getContentPane().setLayout(new BorderLayout());//添加监听事件
		bs.addActionListener(this);
		exit.addActionListener(this);
		result.addActionListener(this);
		
		this.setTitle("代码数据统计器");
		this.setVisible(true);
		this.setSize(400,293);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(3,1));//总布局
		 
		
		JPanel p2=new JPanel();
		p2.add(filePath);
		p2.add(text);
		p2.add(bs);
		getContentPane().add(p2, BorderLayout.CENTER);
		

		JPanel p3=new JPanel();//分布局1
		p3.setLayout(new GridLayout(4,1));//总布局
		p3.add(charNumber);
		p3.add(wordNumber);
		p3.add(wlh);
		p3.add(dmh);
		p3.add(zsh);
		p3.add(kh);
		getContentPane().add(p3);
		

		JPanel p4=new JPanel();
		p4.setLayout(new GridLayout(2,1));
		p4.add(result);
		p4.add(exit);
		getContentPane().add(p4);
	
	}
	
	
	public static void main(String[] args) {
		Main jm=new Main();

	}
	
public void actionPerformed(ActionEvent e){// 监听事件
		
		String soruceName=e.getActionCommand();
		
		if(soruceName.equals("选择文件")){// 监听事件
			
			FileDialog fd=new FileDialog(new JFrame());//弹出显示窗口
			fd.setVisible(true);
			text.setText(fd.getDirectory()+fd.getFile());// 路径地址+文件名
			String filename = fd.getFile();
			
			if(filename==null || "".equals(filename)){
				text.setText("");
				return;
			}
			if(!filename.endsWith(".c") && !filename.endsWith(".cpp")){
				JOptionPane.showMessageDialog(null, "请选择c语言的源文件，不然会存在统计不正确的误差！", "alert", JOptionPane.ERROR_MESSAGE);
				text.setText("");
				return ;
			}
			
			
			
		}else if(soruceName.equals("退出")){// 监听事件
			System.exit(0);//退出
		
		}else if(soruceName.equals("代码读取并统计")){// 监听事件
			
			if(text.getText()==null || "".equals(text.getText())){
				JOptionPane.showMessageDialog(null, "请选择文件！", "alert", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			LineNumber oper=new LineNumber();//读取行数操作类
			WordNumber words = new WordNumber();
			String fileName=text.getText();//得到路径
			
			try{
				Line st=oper.getCount(fileName);
				Word word = words.getCount(fileName);
				setValue(st,word);
//				System.out.println("总数行="+st.getWlhLine());
//				System.out.println("空行"+st.getKhLine());
//				System.out.println("代码行"+st.getDmhLine());
//				System.out.println("注释行"+st.getZshLine());
//				System.out.println("代码字符数量"+word.word.getCharNumber());
//				System.out.println("代码单词数量"+word.getWordNumber());
			}catch(Exception el){
				JOptionPane.showMessageDialog(null, "文件不存在，请重试！", "alert", JOptionPane.ERROR_MESSAGE);

			}
			
		
		}
	}

	
	
public void setValue(Line st,Word word){
	wlh.setText("总行数"+"  "+st.getWlhLine()+"    100%");
	
	long dmhValue=(long)(((double)st.getDmhLine()/(double)st.getWlhLine())*100);
	
	dmh.setText("代码行"+"  "+st.getDmhLine()+"  "+dmhValue+"%");
	
	long zshValue=(long)(((double)st.getZshLine()/(double)st.getWlhLine())*100);
	
	zsh.setText("注释行"+"  "+st.getZshLine()+"  "+zshValue+"%");
	
	long khValue=(long)(((double)st.getKhLine()/(double)st.getWlhLine())*100);
	
	kh.setText("空行"+"  "+st.getKhLine()+"  "+khValue+"%");
	
	charNumber.setText("字符数量"+"  "+ word.getCharNumber());
	wordNumber.setText("单词数量"+ "  "+word.getWordNumber());
	
}
	
}
