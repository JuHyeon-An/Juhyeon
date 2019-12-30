package io_App;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextEditor extends JInternalFrame {

	String fileName;
	public JLabel status;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	boolean modifyFlag = false;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextEditor frame = new TextEditor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TextEditor() {
		super("noname", true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 450, 378);
		getContentPane().add(getStatus(), BorderLayout.SOUTH);
		getContentPane().add(getScrollPane_1(), BorderLayout.CENTER);

	}
	
	public TextEditor(String fileName) {
		this();
		this.fileName = fileName;
		setTitle(fileName);
//		파일을 로드하는 메소드
		load();
	}
	
	
	public void load() {
		try {
			FileReader fr = new FileReader(fileName);
			char[] data = new char[100];
			int readData = 0; //읽은 데이터의 크기
			textArea.setText("");
			
			while ((readData = fr.read(data)) != -1) {
				String temp = new String(data, 0, readData);
				textArea.append(temp);
			}
			fr.close();
			
		}catch(Exception ex) {
			
		}
	}
	
	public boolean save() {
		boolean b = true;
		
		if(!modifyFlag) return b;
//		저장되지 않았어도 참
		
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(textArea.getText());
			fw.flush(); // write는 flush 필수로
			fw.close();
			setTitle(fileName); //저장되면 * 표시 없애주기
		} catch (Exception ex) {
			b = false;
		}
		return b;
	}
	public JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setPreferredSize(new Dimension(0, 24));
		}
		return status;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea_1());
		}
		return scrollPane;
	}
	private JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent ev) {
//				어떤 키라도 눌리면 편집된것으로 판단.
					if(ev.getKeyCode() != KeyEvent.VK_SHIFT &&
						ev.getKeyCode() != KeyEvent.VK_ALT &&
						ev.getKeyCode() != KeyEvent.VK_CONTROL &&
						ev.getKeyCode() != KeyEvent.VK_HOME &&
						ev.getKeyCode() != KeyEvent.VK_END &&
						ev.getKeyCode() != KeyEvent.VK_PAGE_UP &&
						ev.getKeyCode() != KeyEvent.VK_PAGE_DOWN &&
						ev.getKeyCode() != KeyEvent.VK_RIGHT &&
						ev.getKeyCode() != KeyEvent.VK_LEFT &&
						ev.getKeyCode() != KeyEvent.VK_UP &&
						ev.getKeyCode() != KeyEvent.VK_DOWN ) {
//						다음과 같은 컨트롤키 말고 다른게 눌렸을때 문서가 편집됐다고 생각
						modifyFlag = true;
						if(fileName==null) {
							setTitle("noname(*)");
						}else {
						setTitle(fileName + "(*)");} // 편집됐다는 의미로
						
					if(ev.getKeyCode() == KeyEvent.VK_CONTROL&& 
							ev.getKeyCode() == KeyEvent.VK_S) 
						{
							modifyFlag = false;
						}
					}
					
					
				}
			});
		}
		return textArea;
	}
}
