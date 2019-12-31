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
	public void run() { // 언제 들어올지 모르는 데이터를 계속 수신하고 있어야함 -> while
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			frame.login();
			// run 메소드 실행됐다는 것은 스레드가 만들어졌다는거니까 여기서 로그인 실행
			
			while(true) {
				ChattData cd = (ChattData)ois.readObject();
				String html = "";
				
				switch(cd.getCommand()) {
				case ChattData.MESSAGE:
					html = "<div style='border:1px solid #0000ff;background-color:#e0daf0;"
						  + "padding:3px;width:300px;margin-left:150px'>"
						  + cd.toString()
						  + "</div>";
					frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					break;
				
				case ChattData.LOGIN:
					
					for(int i = 0; i<cd.getUsers().size(); i++) {
						String mId = cd.getUsers().get(i); // 유저목록
						frame.model.addElement(mId);
					}
					
					break;
				}
				frame.getTextPane().scrollRectToVisible(
						new Rectangle(0, frame.getTextPane().getHeight()+100, 1, 1) );
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("ClientThread.run()");
		}
	}
	
}
