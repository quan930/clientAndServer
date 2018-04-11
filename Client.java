package quan.network;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Socket client = new Socket("47.94.13.255",5000);
		Scanner in = new Scanner(client.getInputStream());
		PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream(),"UTF-8"));
		System.out.println("客户端已连接服务器(quit退出)");
		while(true) {
			Scanner inTer = new Scanner(System.in);
			String clientStr = inTer.nextLine();
			out.println("客户端:"+clientStr);
			out.flush();
			if(clientStr.equals(new String("quit"))) {
				out.println("Bye!");
				out.flush();
				break;
			}
			String stringSer = in.nextLine();
			System.out.println("服务器端:"+stringSer);
		}
		client.close();
	}

}
