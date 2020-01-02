package k_io;

import java.awt.Rectangle;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientThread extends Thread{
	
	ClientFrame frame;
	Socket socket;
	
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	public ClientThread(ClientFrame frame, Socket socket) {
		this.frame = frame;
		this.socket = socket;
	}
	
	@Override
	public void run() { // ���� ������ �𸣴� �����͸� ��� �����ϰ� �־���� -> while
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			frame.login();
			// run �޼ҵ� ����ƴٴ� ���� �����尡 ��������ٴ°Ŵϱ� ���⼭ �α��� ����
			
			while(true) {
				ChattData cd = (ChattData)ois.readObject();
				String html = "";
				
				switch(cd.getCommand()) {
				case ChattData.WHISPER:
					html = "<div style='border:1px solid #0000ff;background-color:#e0daf0;"
							  + "padding:3px;width:300px;margin-left:150px'>"
							  + "(�Ӹ�) "+cd.toString()
							  + "</div>";
						frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
						
				case ChattData.MESSAGE:

					if (cd.mId.equals(frame.getTmId().getText())) {
						html = "<div style='border:0px solid #0000ff;background-color:#e0daf0;"
								+ "padding:5px;width:150px;margin:3px; margin-left:150px'>" + cd.toString() + "</div></font>";
					} else if (cd.mId.equals("���")) {
						html = "<div style='border:0px solid #ff00ff;background-color:#ffffcc;"
								+ "padding:5px;width:300px;margin:3px; margin-left:150'></font>>" + cd.toString() + "</div></font>";
					} else {
						html = "<div style='border:0px solid #0000ff;background-color:#e0daf0;"
								+ "padding:5px;width:150px;margin:3px; margin-left:0px'></font>>" + cd.toString() + "</div></font>";
					}
					frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					break;
				
				case ChattData.LOGIN:
					
					for(int i = 0; i<cd.getUsers().size(); i++) {
						String mId = cd.getUsers().get(i); // �������
						frame.model.addElement(mId);
						
						//����� ���ŵ��� �ʴ� ���
						frame.getList().ensureIndexIsVisible(frame.model.getSize());
						// list�� ������ �ִ� graphics�� �����ٰ� �ڱ��ڽ��� �ٽ� ����Ʈ
					}
					
					break;
					
				case ChattData.LOGOUT:
					
				frame.model.removeElement(cd.getmId());
				frame.getList().updateUI();
				frame.getList().paint(frame.getList().getGraphics());
				
				break;
				
				case ChattData.GETOUT:
					
					//1) ������ ������ ���� getout
					//2) Ư�� ������ ����
					frame.getCloseBtn().setEnabled(false);
					frame.getStartBtn().setEnabled(true);

					if (cd.getUsers() == null) { // ������ ����
						
						html = "<font color='#00ff00'>" + "������ ���������ϴ�" + "</font>";
						frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
						
						frame.model.clear();
						throw new Exception();
						// => catch��������
					
					}else { // ����
					for(String mId : cd.getUsers()) { // ���� ������ߴٸ�
						if(mId.equals(frame.getTmId().getText())) {
							
							html = "<font color='#00ff00'>" +frame.getTmId().getText()+ "���� ������ϼ̽��ϴ�." + "</font>";
							frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
							
							frame.model.clear();
							throw new Exception();
						}else {
							frame.model.removeElement(mId);
						}
					}
					}
					
					
				}//end of Switch
				frame.getTextPane().scrollRectToVisible(
						new Rectangle(0, frame.getTextPane().getHeight()+100, 1, 1) );
			}
		}catch(Exception ex) {
			try {
				ois.close();
				oos.close();
				socket.close();
				
				ois = null;
				oos = null;
				socket = null;
			}catch(Exception ex2) {
				
			}
		}
	}
	
}
