package k_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JProgressBar;

public class FileCopyThread extends Thread{

	JProgressBar bar;
	String original;
	String target;
	

	public void setOriginal(String original) {
		this.original = original;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public FileCopyThread(JProgressBar bar) {
		this.bar = bar;
	}
	
	@Override
	public void run() {
		try {
			if (original != null && target != null) {
				FileInputStream fis = new FileInputStream(original);
				FileOutputStream fos = new FileOutputStream(target);
				int readByteNo = 0;
				long totReadByte = 0;
				
				byte[] readBytes = new byte[100];
//				100바이트 크기만큼 original 파일을 읽음
				long fileSize = new File(original).length();
				// original의 문자열로 파일객체 만들고 길이를 long타입 변수에 담는다
				
				bar.setValue(0);
				while((readByteNo = fis.read(readBytes)) != -1) {
//					fos.write(읽혀진 데이터 있는 장소, 시작위치, 읽혀진 데이터 시작위치);
					fos.write(readBytes, 0, readByteNo);
//					Thread.sleep(50); // 일부로 좀 느리게!
//					progressbar 변화 잘 보기 위해서
					
					totReadByte += readByteNo;
//					tot에 읽은 바이트 수를 계속 누적시킴
					bar.setValue((int)((double)totReadByte/fileSize*100));
				
				}
				
				fos.flush(); // 버퍼에 남아있는 데이터 달리고
				fos.close();
				fis.close();
				
			}
		} catch (Exception ex) {}
	}
	
}
