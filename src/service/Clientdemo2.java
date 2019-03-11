package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Clientdemo2 implements Runnable {
	private Socket socket=null;
	public  Clientdemo2(Socket socket) {
		this.socket=socket;
	}
	@Override
	public void run() {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
			while(true) {
				String str=br.readLine();
				pw.println(str);
				if(str.equals("bye")) {
					break;
				}
			}
			br.close();
			pw.close();
			socket.close();
		} catch (IOException e) {
			
		}
		
	}

}
