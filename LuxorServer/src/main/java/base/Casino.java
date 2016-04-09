package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import pokerBase.Table;

public class Casino  extends Thread {

	private ArrayList<Table> Tables = new ArrayList<Table>();
	private Socket socket;
	private BufferedReader input;
	private PrintWriter output;
    
	public Casino(Socket socket)	
	{
		this.socket = socket;
		System.out.println("A");
		for (int a = 0; a< 10;a++)
		{
			Table t = new Table();
			Tables.add(t);
		}
		System.out.println("B");
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("D");
            output = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("E");
            output.println("MESSAGE Waiting for opponent to connect");
            System.out.println("F");
        } catch (IOException e) {
            System.out.println("Player died: " + e);
        }
        
	}
	
	public void run() {
        try {        	
            while (true) {
                String command = input.readLine();
                System.out.println("Waiting");
            }
        } catch (IOException e) {
            System.out.println("Player died: " + e);
        } finally {
            try {socket.close();} catch (IOException e) {}
        }
    }
	
	
}
