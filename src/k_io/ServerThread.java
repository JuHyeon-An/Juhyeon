package k_io;

import java.awt.Rectangle;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// client�� 1:1�� ��ȭ�ϴ� Ŭ����
public class ServerThread extends Thread{
	
	String mId;
	ServerFrame frame;
	Socket socket;
	
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	public ServerThread(ServerFrame frame, Socket socket){
		this.frame = frame;
		this.socket = socket;
		//serverThread������ UI �����ؾߵż� frame,
		//socket�� 1:1 ��������� �޾ƾ��ؼ�
	}
	
	@Override
	public void run() {
		
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			while(true) {
				ChattData cd = (ChattData)ois.readObject();
				// readObject ������ ���� blocking -> �����带 ���� �� �ۿ� ���� ����
//				����� �α��� ������ ChatData Ÿ���̾����ϱ�
				String html = "";
				switch(cd.getCommand()) {
				
				case ChattData.LOGIN:
					this.mId = cd.getmId(); // �ڽŰ� ����� Ŭ���̾�Ʈ�� mId�� ����
//					(������ �ϳ��� Ŭ���̾�Ʈ�ۿ� �������� �� �ϴϱ�)
					
					html = "<font color='#00ff00'>"+cd.getMessage()+ cd.getmId()
							+ "���� �����Ͽ����ϴ�" + "</font>";
//					JList�� �α��� ��� ������ ǥ�� (ServerFrame �Ҽ� kit�� �����´�)
					frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					
					//1. ���� �ڽŰ� ����� oos���� ���� ������ ����� ����
					ChattData cd2 = new ChattData();
					List<String> users = new ArrayList<String>();
					for (int i = 0; i < frame.model.size(); i++) {
						users.add(frame.model.get(i));
					}
					
					System.out.println(users.toString());
					
					cd2.setCommand(ChattData.LOGIN);
					cd2.setUsers(users);
					oos.writeObject(cd2);//������ ä���ϰ� �־��� ������ ����� ��Ƽ� �ڱ� �ڽſ���
					oos.flush();
					
					//2. �ڽ��� ���̵� model�� �߰�
					frame.model.addElement(cd.getmId());
					
					//3. ��� �����ڿ��� ���� �ڽ��Ǿ��̵� ����
					cd2 = new ChattData();
					cd2.setCommand(ChattData.LOGIN);
					users = new ArrayList<String>();
					
					users.add(cd.getmId()); // ���� �ڽ��� ���̵� ����ְ�
					cd2.setUsers(users);
					sendAll(cd2);
					System.out.println(users.toString());
					
					break;
					
					
				case ChattData.WHISPER:
					int[] to = new int[cd.getUsers().size()];
					int index = 0;
					for (String str : cd.getUsers()) {
						for(int i = 0; i<frame.clients.size(); i++) {
							ServerThread st = frame.clients.get(i);
							if(str.equals(st.mId)) {
								to[index] = i;
								index++;
							}
						}
					}
					
					frame.sendAll(cd, to);
					break;
					
				case ChattData.MESSAGE:
					html = "<div style='border:3px solid #6f594a;padding:3px;"
							 + "background-color:#e0daf0;width:150px'>"
							 + cd.toString()
							 + "</div>";
						
						frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
						
						sendAll(cd);
						
					break;

				case ChattData.LOGOUT:
					throw new Exception();
//					�α׾ƿ� Ŀ�ǵ� �߻������� exception �߻� -> catch��������
					
				} // end of switch
				
				frame.getTextPane().scrollRectToVisible(
						new Rectangle(0, frame.getTextPane().getHeight()+100, 1, 1) );
			}
		}catch(Exception ex) {
			int index = frame.clients.indexOf(ServerThread.this);
//			Ŭ���̾�Ʈ �ݷ��ǿ� ����Ǿ��ִ� ���������� �߿��� �ڱ��ڽ��� ��ġ��ȣ�� ����
			frame.model.remove(index);
			frame.clients.remove(index); // �ڱ��ڽ� ����� �۾� (������� ���� ���� x)
			
//			�ٸ� ��� �������� ������ logout�� ����� �뺸
			ChattData cd = new ChattData();
			cd.setCommand(ChattData.LOGOUT);
			cd.setmId(this.mId);
			
			try {
				sendAll(cd);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	private void sendAll(ChattData cd) throws Exception{
		
		for(ServerThread st : frame.clients) {
//			frame.clients : ServerThread�� add�� ��.
			st.oos.writeObject(cd);
			st.oos.flush();
//			�� �޼ҵ� ������ �ٸ� Ŭ���̾�Ʈ�鵵 �޽����� ���� ��
		}
	}
	
	
}
