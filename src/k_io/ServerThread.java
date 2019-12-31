package k_io;

import java.awt.Rectangle;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// client와 1:1로 대화하는 클래스
public class ServerThread extends Thread{

	ServerFrame frame;
	Socket socket;
	
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	public ServerThread(ServerFrame frame, Socket socket){
		this.frame = frame;
		this.socket = socket;
		//serverThread에서도 UI 접근해야돼서 frame,
		//socket은 1:1 통신정보를 받아야해서
	}
	

	
	@Override
	public void run() {
		
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			while(true) {
				ChattData cd = (ChattData)ois.readObject();
				// readObject 만나는 순간 blocking -> 스레드를 만들 수 밖에 없는 이유
//				날라온 로그인 정보가 ChatData 타입이었으니까
				String html = "";
				switch(cd.getCommand()) {
				
				case ChattData.LOGIN:
					html = "<font color='#00ff00'>"+cd.getMessage()+ cd.getmId()
							+ "님이 접속하였습니다" + "</font>";
//					JList에 로그인 사람 정보를 표시 (ServerFrame 소속 kit를 가져온다)
					frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					
					//1. 먼저 자신과 연결된 oos에게 기존 접속자 목록을 전송
					ChattData cd2 = new ChattData();
					List<String> users = new ArrayList<String>();
					for (int i = 0; i < frame.model.size(); i++) {
						users.add(frame.model.get(i));
					}
					
					System.out.println(users.toString());
					
					cd2.setCommand(ChattData.LOGIN);
					cd2.setUsers(users);
					oos.writeObject(cd2);//기존에 채팅하고 있었던 유저들 목록을 담아서 자기 자신에게
					oos.flush();
					
					//2. 자신의 아이디를 model에 추가
					frame.model.addElement(cd.getmId());
					
					//3. 모든 접속자에게 현재 자신의아이디를 전송
					users.clear();
					users.add(cd.getmId()); // 현재 자신의 아이디만 집어넣고
					cd2.setUsers(users);
					sendAll(cd2);
					
					break;
					
				case ChattData.LOGOUT:
					
					break;
					
				case ChattData.USERS:
				
					break;
					
				case ChattData.MESSAGE:
					html = "<div style='border:3px solid #6f594a;padding:3px;"
							 + "background-color:#e0daf0;width:150px'>"
							 + cd.toString()
							 + "</div>";
						
						frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
						
						sendAll(cd);
						
					break;
				} // end of switch
				
				frame.getTextPane().scrollRectToVisible(
						new Rectangle(0, frame.getTextPane().getHeight()+100, 1, 1) );
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}



	private void sendAll(ChattData cd) throws Exception{
		for(ServerThread st : frame.clients) {
//			frame.clients : ServerThread를 add한 것.
			st.oos.writeObject(cd);
			st.oos.flush();
//			이 메소드 때문에 다른 클라이언트들도 메시지를 받은 것
			
		}
	}
	
	
}
