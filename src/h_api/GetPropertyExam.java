//package h_api;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.util.Properties;
//import java.util.Set;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.UIManager;
//import javax.swing.border.TitledBorder;
//
//public class GetPropertyExam extends JFrame {
//
//	private JPanel contentPane;
//	private JPanel panel; // 북쪽에 붙어있는 panel
//	private JButton btnNewButton;
//	private JScrollPane scrollPane;
//	private JTextArea textarea; // viewport 영역에 붙어있는 textarea
//	private JButton btnNewButton_1;
//	private JButton btnNewButton_2;
//
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GetPropertyExam frame = new GetPropertyExam();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	public void view() {
//		String msg = "";
//		String osName = System.getProperty("os.name");
//		msg += "운영체제 이름 : "+osName+"\n";
//		msg += "사용자 이름 : "+System.getProperty("user.name")+"\n";
//		msg += "사용자 홈 : "+System.getProperty("user.home")+"\n";
//		msg += "----------------------\n";
//		msg += "[key] value \n";
//		msg += "----------------------\n";
//		Properties props = System.getProperties();
//		Set keys = props.keySet();
//		for(Object objKey : keys) {
//			String key = (String)objKey;
//			String value = System.getProperty(key);
////			msg += "[" + key + "]" + value + "\n";
//			msg += String.format("[%s] %s \n", key, value);
//		}
//		textarea.setText(msg);
//	}
//	
//	public void viewClass() {
//		textarea.setText("");
//		String str = "";
//		Student st = new Student(0);
//		Score cls = st.getClass();
//		
//		str += cls+"\n";
//		str += "class full name : " + cls.getName() + "\n";
//		str += "class name : "+cls.getSimpleName() + "\n";
//		str += "package name : "+cls.getPackage().getName() + "\n";
//		str += "---------------------------------\n";
//		
//		try {
//			Score cls2 = Score.forName("h_api.Student"); // 객체를 생성하기 전 직접 Class 객체 얻을수있다
//			str += "class full name : "+cls2.getName()+"\n";
//			str += "class name : "+cls2.getSimpleName()+"\n";
//			str += "package name : "+cls2.getPackage().getName()+"\n";
//			str += "---------------------------------\n";
//		}catch(Exception ex) {}
//		textarea.setText(str);
//				
//				
//		
//		
//	}
//	
//	public void viewReflect() throws Exception{
//		String str = "";
//		Score cls = Score.forName("h_api.Student");
//		str += "[클래스명] \n";
//		str += cls.getName() + "\n";
//		
//		str += "[생성자 정보] \n";
//		Constructor[] constructors = cls.getDeclaredConstructors();
//		for(Constructor c : constructors) {
//			str += c.getName() + "(";
//			Score[] parameters = c.getParameterTypes();
//			printParameters(parameters);
//			str += ")\n";
//		}
//
//		str += "[필드 정보] \n";
//		Field[] fs = cls.getDeclaredFields();
//		for(Field fd : fs) {
//			str += fd.getType().getSimpleName()+" "+fd.getName();
//			str += "\n";
//		}
//		
//		str += "[메소드 정보] \n";
//		Method[] methods = cls.getDeclaredMethods();
//		for(Method method : methods) {
//			str += method.getName()+"(";
//			Score[] parameters = method.getParameterTypes();
//			str += printParameters(parameters);
//			str += ")\n";
//		}
//		textarea.setText(str);
//	}
//
//	public String printParameters(Score[] parameters) {
//		String str = "";
//		for (int i = 0; i < parameters.length; i++) {
//			str += parameters[i].getName();
//			if (i < (parameters.length - 1)) {
//				str += ",";
//			}
//		}
//		return str;
//	}
//
//	public GetPropertyExam() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 465, 369);
//		contentPane = new JPanel();
//		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC548\uC8FC\uD604", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
//		contentPane.setLayout(new BorderLayout(20, 20));
//		setContentPane(contentPane);
//		contentPane.add(getPanel(), BorderLayout.NORTH);
//		contentPane.add(getScrollPane(), BorderLayout.CENTER);
//	}
//
//	private JPanel getPanel() {
//		if (panel == null) { // 패널이 생성되지 않았다면
//			panel = new JPanel(); // 만들어라
//			panel.add(getBtnNewButton()); // 그리고 그 위에 버튼 만드는 메소드 결과값을 추가
//			panel.add(getBtnNewButton_1());
//			panel.add(getBtnNewButton_2());
//		}
//		return panel;
//	}
//	private JButton getBtnNewButton() {
//		if (btnNewButton == null) {
//			btnNewButton = new JButton("속성보기");
//			btnNewButton.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//				view();
//				
//				}
//			});
//		}
//		return btnNewButton;
//	}
//	private JScrollPane getScrollPane() {
//		if (scrollPane == null) {
//			scrollPane = new JScrollPane();
//			scrollPane.setViewportView(getTextArea());
//		}
//		return scrollPane;
//	}
//	private JTextArea getTextArea() {
//		if (textarea == null) {
//			textarea = new JTextArea();
//		}
//		return textarea;
//	}
//	private JButton getBtnNewButton_1() {
//		if (btnNewButton_1 == null) {
//			btnNewButton_1 = new JButton("class");
//			btnNewButton_1.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					viewClass();
//				}
//
//				
//			});
//		}
//		return btnNewButton_1;
//	}
//	private JButton getBtnNewButton_2() {
//		if (btnNewButton_2 == null) {
//			btnNewButton_2 = new JButton("reflection");
//			btnNewButton_2.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					try {
//						viewReflect();
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//
//				
//			});
//		}
//		return btnNewButton_2;
//	}
//}
