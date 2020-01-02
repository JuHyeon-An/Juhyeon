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
				case ChattData.WHISPER:
					html = "<div style='border:1px solid #0000ff;background-color:#e0daf0;"
							  + "padding:3px;width:300px;margin-left:150px'>"
							  + "(귓말) "+cd.toString()
							  + "</div>";
						frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
						
				case ChattData.MESSAGE:

					if (cd.mId.equals(frame.getTmId().getText())) {
						html = "<div style='border:0px solid #0000ff;background-color:#e0daf0;"
								+ "padding:5px;width:150px;margin:3px; margin-left:150px'>" + cd.toString() + "</div></font>";
					} else if (cd.mId.equals("운영자")) {
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
						String mId = cd.getUsers().get(i); // 유저목록
						frame.model.addElement(mId);
						
						//목록이 갱신되지 않는 경우
						frame.getList().ensureIndexIsVisible(frame.model.getSize());
						// list가 가지고 있는 graphics를 가져다가 자기자신을 다시 페인트
					}
					
					break;
					
				case ChattData.LOGOUT:
					
				frame.model.removeElement(cd.getmId());
				frame.getList().updateUI();
				frame.getList().paint(frame.getList().getGraphics());
				
				break;
				
				case ChattData.GETOUT:
					
					//1) 서버의 중지에 따른 getout
					//2) 특정 유저의 강퇴
					frame.getCloseBtn().setEnabled(false);
					frame.getStartBtn().setEnabled(true);

					if (cd.getUsers() == null) { // 서버의 중지
						
						html = "<font color='#00ff00'>" + "접속이 끊어졌습니다" + "</font>";
						frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
						
						frame.model.clear();
						throw new Exception();
						// => catch문장으로
					
					}else { // 강퇴
					for(String mId : cd.getUsers()) { // 내가 강퇴당했다면
						if(mId.equals(frame.getTmId().getText())) {
							
							html = "<font color='#00ff00'>" +frame.getTmId().getText()+ "님이 강퇴당하셨습니다." + "</font>";
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
