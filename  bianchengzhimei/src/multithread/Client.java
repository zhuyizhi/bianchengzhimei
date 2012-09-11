package multithread;
import java.net.*;
import java.io.*;
public class Client {
	public static void main(String[] args)throws Exception{
		String pcName = "ucai-PC";
		InetAddress a = InetAddress.getByName(pcName);
		Socket socket = new Socket(a, 1000);
		try{
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
			PrintWriter out = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(socket.getOutputStream())), true);
			for(int i = 0; i < 10; i++){
				out.println("howdy" + i);
				System.out.println("howdy" + i);
//				String str = in.readLine();
//				System.out.println("in client " + str);
			}
		}finally{
			socket.close();
		}
	}
}
