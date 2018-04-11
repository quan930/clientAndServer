package quan.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket s = new ServerSocket(7777);
		Socket server = s.accept();
		OutputStream outServer = server.getOutputStream();
		InputStream inServer = server.getInputStream();
		Scanner in = new Scanner(inServer,"UTF-8");
		PrintWriter out = new PrintWriter(new OutputStreamWriter(outServer,"UTF-8"));
		out.println("已连接服务器(quit退出)");
		System.out.println("有一个客户端进行了连接");
		out.flush();
		while(true) {
			String stringSer = in.nextLine();
			System.out.println("客户端:"+stringSer);
			if(stringSer.equals(new String("quit"))) {
				out.println("Bye!");
				out.flush();
				break;
			}
			Scanner inTer = new Scanner(System.in);
			out.println("服务器端:"+inTer.nextLine());
			out.flush();
		}
		server.close();
	}
}
