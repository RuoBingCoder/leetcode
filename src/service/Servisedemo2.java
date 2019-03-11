package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Servisedemo2 implements Runnable {
	private Socket socket = null;
	private int number;
	public Servisedemo2(Socket socket, int number) {
		this.socket = socket;
		this.number = number;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
			while(true) {
				String str=br.readLine();
				System.out.println("�ͻ���"+number+":"+str);
				pw.println(str.toUpperCase());
				if(str.equals("bye")) {
					System.out.println("�ͻ���"+number+"�ѶϿ�����");
					break;
				}
			}
			br.close();
			pw.close();
		} catch (IOException e) {
			
		}

	}

}
