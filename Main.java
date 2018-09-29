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
	
	JLabel charNumber = new JLabel("�ַ�����");
	JLabel wordNumber = new JLabel("��������");
	JLabel wlh=new JLabel("������");
	JLabel dmh=new JLabel("������");
	JLabel zsh=new JLabel("ע����");
	JLabel kh=new JLabel("����");
	JLabel filePath=new JLabel("�ļ�·��");
	JTextField text=new JTextField(10);
	JButton bs=new JButton("ѡ���ļ�");
	JButton result=new JButton("�����ȡ��ͳ��");
	JButton exit=new JButton("�˳�");
	
	public Main(){
		
		getContentPane().setLayout(new BorderLayout());//��Ӽ����¼�
		bs.addActionListener(this);
		exit.addActionListener(this);
		result.addActionListener(this);
		
		this.setTitle("��������ͳ����");
		this.setVisible(true);
		this.setSize(400,293);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(3,1));//�ܲ���
		 
		
		JPanel p2=new JPanel();
		p2.add(filePath);
		p2.add(text);
		p2.add(bs);
		getContentPane().add(p2, BorderLayout.CENTER);
		

		JPanel p3=new JPanel();//�ֲ���1
		p3.setLayout(new GridLayout(4,1));//�ܲ���
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
	
public void actionPerformed(ActionEvent e){// �����¼�
		
		String soruceName=e.getActionCommand();
		
		if(soruceName.equals("ѡ���ļ�")){// �����¼�
			
			FileDialog fd=new FileDialog(new JFrame());//������ʾ����
			fd.setVisible(true);
			text.setText(fd.getDirectory()+fd.getFile());// ·����ַ+�ļ���
			String filename = fd.getFile();
			
			if(filename==null || "".equals(filename)){
				text.setText("");
				return;
			}
			if(!filename.endsWith(".c") && !filename.endsWith(".cpp")){
				JOptionPane.showMessageDialog(null, "��ѡ��c���Ե�Դ�ļ�����Ȼ�����ͳ�Ʋ���ȷ����", "alert", JOptionPane.ERROR_MESSAGE);
				text.setText("");
				return ;
			}
			
			
			
		}else if(soruceName.equals("�˳�")){// �����¼�
			System.exit(0);//�˳�
		
		}else if(soruceName.equals("�����ȡ��ͳ��")){// �����¼�
			
			if(text.getText()==null || "".equals(text.getText())){
				JOptionPane.showMessageDialog(null, "��ѡ���ļ���", "alert", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			LineNumber oper=new LineNumber();//��ȡ����������
			WordNumber words = new WordNumber();
			String fileName=text.getText();//�õ�·��
			
			try{
				Line st=oper.getCount(fileName);
				Word word = words.getCount(fileName);
				setValue(st,word);
//				System.out.println("������="+st.getWlhLine());
//				System.out.println("����"+st.getKhLine());
//				System.out.println("������"+st.getDmhLine());
//				System.out.println("ע����"+st.getZshLine());
//				System.out.println("�����ַ�����"+word.word.getCharNumber());
//				System.out.println("���뵥������"+word.getWordNumber());
			}catch(Exception el){
				JOptionPane.showMessageDialog(null, "�ļ������ڣ������ԣ�", "alert", JOptionPane.ERROR_MESSAGE);

			}
			
		
		}
	}

	
	
public void setValue(Line st,Word word){
	wlh.setText("������"+"  "+st.getWlhLine()+"    100%");
	
	long dmhValue=(long)(((double)st.getDmhLine()/(double)st.getWlhLine())*100);
	
	dmh.setText("������"+"  "+st.getDmhLine()+"  "+dmhValue+"%");
	
	long zshValue=(long)(((double)st.getZshLine()/(double)st.getWlhLine())*100);
	
	zsh.setText("ע����"+"  "+st.getZshLine()+"  "+zshValue+"%");
	
	long khValue=(long)(((double)st.getKhLine()/(double)st.getWlhLine())*100);
	
	kh.setText("����"+"  "+st.getKhLine()+"  "+khValue+"%");
	
	charNumber.setText("�ַ�����"+"  "+ word.getCharNumber());
	wordNumber.setText("��������"+ "  "+word.getWordNumber());
	
}
	
}
