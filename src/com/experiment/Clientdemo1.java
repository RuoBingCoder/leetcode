package com.experiment;

import java.io.IOException;
import java.net.Socket;

public class Clientdemo1 {

	public static void main(String[] args) throws IOException{
		Socket socket=new Socket("10.10.48.70", 8888);
		new Thread(new Clientdemo2(socket)).start();
		new Thread(new Clientdemo3(socket)).start();
	}

}
