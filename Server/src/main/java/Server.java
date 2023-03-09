import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.scene.control.ListView;
/*
 */
public class Server {

	int count = 1;
	ArrayList<ClientThread> clients = new ArrayList<ClientThread>();
	TheServer server;
	private Consumer<Serializable> callback;
	Integer Port;

	MorraInfo passMorraClass;

	Server(Consumer<Serializable> call, Integer port){
		callback = call;
		this.Port = port;
		server = new TheServer();
		server.start();
	}

	public void setPort(Integer Port) {
		this.Port = Port;
	}

	public class TheServer extends Thread {
		public void run(){
			try(ServerSocket mysocket = new ServerSocket(Port);){
		    System.out.println("Server is waiting for a client on port : " + Port);

		    while(true) {
				ClientThread c = new ClientThread(mysocket.accept(), count);
				callback.accept("client has connected to server: " + "client #" + count);
				clients.add(c);
				c.start();
				count++;
			    }
			}//end of try
				catch(Exception e) {
					callback.accept("Server socket did not launch");
				}
			}//end of while
		}

		class ClientThread extends Thread{

			Socket connection;
			int count;
			ObjectInputStream in;
			ObjectOutputStream out;

			ClientThread(Socket s, int count){
				this.connection = s;
				this.count = count;
			}

			public void updateClients(String message) {
				for(int i = 0; i < clients.size(); i++) {
					ClientThread t = clients.get(i);
					try {
					 t.out.writeObject(message);
					}
					catch(Exception e) {}
				}
			}

			public void run(){

				try {
					in = new ObjectInputStream(connection.getInputStream());
					out = new ObjectOutputStream(connection.getOutputStream());
					connection.setTcpNoDelay(true);
				}
				catch(Exception e) {
					System.out.println("Streams not open");
				}

				updateClients("new client on server: client #"+count);

				 while(true) {
					    try {

							//MorraInfo class passed from the client side
							passMorraClass = new MorraInfo();
							passMorraClass = (MorraInfo) in.readObject();

//					    	MorraInfo data = (MorraInfo) in.readObject();
//					    	callback.accept("client: " + count + " sent: " + data.p1Guess);
//					    	updateClients("client #"+count+" said: "+data);
					    	callback.accept("Client " + count + " +sent: " + passMorraClass.playerPlays);
							updateClients("client #"+count+" said: "+passMorraClass.playerPlays);

					    	}
					    catch(Exception e) {
					    	callback.accept("OOOOPPs...Something wrong with the socket from client: " + count + "....closing down!");
					    	updateClients("Client #"+count+" has left the server!");
					    	clients.remove(this);
					    	break;
					    }
					}
				}//end of run


		}//end of client thread
}






