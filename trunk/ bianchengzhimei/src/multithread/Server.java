package multithread;

import java.net.*;
import java.io.*;
import javax.swing.*;

public class Server {
	public Server() throws Exception {
		ServerSocket socket = new ServerSocket(1000); // ÔÚ1000¶Ë¿Ú¼àÌý
		while (true) {
			Socket s = socket.accept();
			System.out.println("accept!!");
//			while (!s.isConnected()) {
//			}
//			new Processor(s).start();
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			System.out.println("get obj");
			BufferedReader br = new BufferedReader(isr);
			while(true){
				String str = br.readLine();
				if(str != null)
					System.out.println("from sever :" + br.readLine());
				else
					break;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		new Server();
	}
}

class Processor extends Thread {
	Socket s = null;
	static int count = 0;
	public Processor(Socket s) throws Exception {
		this.s = s;
		System.out.println("start processor " + count++);
	}

	public void run() {
		try {
			System.out.println("in run");
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
//			ObjectInputStream obj = new ObjectInputStream(s.getInputStream());
//			JOptionPane.showMessageDialog(null, (String) obj.readObject());
			System.out.println("get obj");
			BufferedReader br = new BufferedReader(isr);
			while(true){
				String str = br.readLine();
				if(str != null)
					System.out.println("from sever :" + br.readLine());
				else
					break;
			}
			
//			System.err.println((String) obj.readObject());
//			obj.close();
		} catch (Exception e) {
		}
	}
}
