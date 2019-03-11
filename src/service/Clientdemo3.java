package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Clientdemo3 implements Runnable {
	private Socket socket=null;
	public Clientdemo3(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				String str=br.readLine();
				System.out.println(str);
			}
			//br.close();
		} catch (IOException e) {
			
		}
		

	}

}
