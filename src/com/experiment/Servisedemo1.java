package com.experiment;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servisedemo1 {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8888);
		//Socket socket = serverSocket.accept();
		int number = 1;
		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("�ͻ���" + number + "������");
			new Thread(new Servisedemo2(socket, number)).start();
			number++;
		}
	}

}
