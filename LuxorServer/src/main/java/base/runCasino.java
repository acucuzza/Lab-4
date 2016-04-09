package base;

import java.io.IOException;
import java.net.ServerSocket;


public class runCasino {

	public static void main(String[] args) throws IOException {
		ServerSocket listener = new ServerSocket(8901);
		System.out.println("Casino is Running");

		try {
			System.out.println("1");
			while (true) {
				System.out.println("1A");	
				Casino cas = new Casino(listener.accept());
				System.out.println("2");
				cas.start();
				System.out.println("3");
			}
		} catch (Exception e) {
				System.out.println(e.getStackTrace());
		} finally {
			listener.close();
		}
	}

}
