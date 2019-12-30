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
//				100����Ʈ ũ�⸸ŭ original ������ ����
				long fileSize = new File(original).length();
				// original�� ���ڿ��� ���ϰ�ü ����� ���̸� longŸ�� ������ ��´�
				
				bar.setValue(0);
				while((readByteNo = fis.read(readBytes)) != -1) {
//					fos.write(������ ������ �ִ� ���, ������ġ, ������ ������ ������ġ);
					fos.write(readBytes, 0, readByteNo);
//					Thread.sleep(50); // �Ϻη� �� ������!
//					progressbar ��ȭ �� ���� ���ؼ�
					
					totReadByte += readByteNo;
//					tot�� ���� ����Ʈ ���� ��� ������Ŵ
					bar.setValue((int)((double)totReadByte/fileSize*100));
				
				}
				
				fos.flush(); // ���ۿ� �����ִ� ������ �޸���
				fos.close();
				fis.close();
				
			}
		} catch (Exception ex) {}
	}
	
}
