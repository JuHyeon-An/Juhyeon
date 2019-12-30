package MemberAndProductApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductSearch extends JInternalFrame {
	
	Set<ProductVo> piList;
	Set<ProductVo> peList;
	
	ButtonGroup group = new ButtonGroup();
	
	private JPanel panel;
	private JTextField textField;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel_1;
	private JRadioButton imBtn;
	private JRadioButton exBtn;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductSearch frame = new ProductSearch();
					frame.setVisible(true);
					frame.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ProductSearch() {
		super("제품검색", true, true, true);
		setVisible(true);
		setTitle("\uC81C\uD488\uC870\uD68C");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
		getContentPane().add(getScrollPane());

	}
	
	public ProductSearch(Set<ProductVo> pi, Set<ProductVo> pe) {
		this();
		this.piList = pi;
		this.peList = pe;
	}
	
	private void search() {
		Set<ProductVo> list = null;
//		 하나의 메소드 안에 두개의 객체를 사용하고 싶을때
		
		textArea.setText("");
		ProductVo find = new ProductVo();
//		검색어 (시리얼, 제품코드, 제품명)
/*		equals를 실행할때 오브젝트 타입이 들어갔는데, 그게 Product 타입이 맞는지 비교를 했으므로 
 * 		find Product 타입으로 만들어줘야함		
 */
		find.setSerial(textField.getText());
		find.setpCode(textField.getText());
		find.setpName(textField.getText());
//		사용자가 입력한 값을 시리얼, 코드, 이름이라고 가정
		
		
		if(imBtn.isSelected()) { // 입고 버튼을 눌렀을때
			list = piList;
		}else { // 출고 버튼을 눌렀을때
			list = peList;
		}
		Iterator<ProductVo> iter = list.iterator();
		while(iter.hasNext()) {
			ProductVo vo = iter.next();
			if(vo.equals(find)) {
			// equals 오버라이딩해서 정확하게 일치하는 검색어가 아닌 일부 일치하는 검색어 찾음
				textArea.append(vo.toString());
			}
		}
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 434, 30);
			panel.setPreferredSize(new Dimension(10, 30));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getTextField(), BorderLayout.CENTER);
			panel.add(getBtnNewButton(), BorderLayout.EAST);
			panel.add(getPanel_1(), BorderLayout.WEST);
		}
		return panel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					search();
					
				}

				
			});
			btnNewButton.setBackground(new Color(250, 128, 114));
			btnNewButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 30, 434, 241);
			scrollPane.setViewportView(getTextArea());
			scrollPane.setColumnHeaderView(getLblNewLabel());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBackground(new Color(255, 228, 196));
		}
		return textArea;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 245, 238));
			panel_1.setPreferredSize(new Dimension(120, 20));
			panel_1.add(getImBtn());
			panel_1.add(getRadioButton_1());
		}
		return panel_1;
	}
	private JRadioButton getImBtn() {
		if (imBtn == null) {
			imBtn = new JRadioButton("입고");
			imBtn.setBackground(new Color(255, 245, 238));
			imBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			group.add(imBtn);
			imBtn.setSelected(true);
		}
		return imBtn;
	}
	private JRadioButton getRadioButton_1() {
		if (exBtn == null) {
			exBtn = new JRadioButton("출고");
			exBtn.setBackground(new Color(255, 245, 238));
			exBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			group.add(exBtn);
		}
		return exBtn;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("     \uC2DC\uB9AC\uC5BCno.             \uC81C\uD488\uCF54\uB4DC               \uC81C\uD488\uBA85                 \uC218\uB7C9                    \uB0A0\uC9DC           ");
			lblNewLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		}
		return lblNewLabel;
	}
}
