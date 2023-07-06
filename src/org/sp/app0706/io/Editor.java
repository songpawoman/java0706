package org.sp.app0706.io;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Editor extends JFrame implements ActionListener{
	JMenuBar bar;
	JMenu[] menu;
	JMenuItem[] item;
	JTextArea area;
	JScrollPane scroll;
	JFileChooser chooser;
	
	public Editor() {
		bar = new JMenuBar();
		menu = new JMenu[5];
		item = new JMenuItem[8];
		area = new JTextArea();
		scroll = new JScrollPane(area);
		chooser = new JFileChooser("D:/morning/javase_workspace");
		
		
		//메뉴 5개 생성 
		String[] menuName= {"파일","편집","서식","보기","도움말"};
		
		for(int i=0;i<menu.length;i++) {
			menu[i] = new JMenu(menuName[i]);
			//생성된 메뉴를 바에 부착 
			bar.add(menu[i]);
		}
		
		//메뉴 아이템 생성 
		String[] itemName= {"새로만들기","새창","열기","저장","다른이름으로 저장","페이지설정","인쇄","끝내기"};
		
		//java 5(jdk 1.5) 부터는 개선된(improved) for문 지원
		//반복문의 대상이 컬렉션, 배열 등의 집합인 경우 유용
		for(int i=0;i<itemName.length;i++){
			item[i] = new JMenuItem(itemName[i]);
			menu[0].add(item[i]);
			
			//메뉴아이템들에 리스너 연결
			item[i].addActionListener(this);
		}
		
		//속성 지정 
		area.setBackground(Color.BLACK);
		area.setForeground(Color.YELLOW);
		
		//조립 
		setJMenuBar(bar); //프레임에 바 부착
		add(scroll);
		
		setSize(800,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //margin auto
		
		setFont(); 
	}
	
	public void setFont() {
		Font font=new Font("Verdana", Font.PLAIN, 16);
		area.setFont(font);
	}
	
	public void openFile() {
		System.out.println("열꺼야?");
		chooser.showOpenDialog(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		JMenuItem obj=(JMenuItem)e.getSource();
		
		if(obj==item[2]) {//열기 눌렀을때...
			openFile();
		}
		
	}
	
	public static void main(String[] args) {
		new Editor();
	}
}






