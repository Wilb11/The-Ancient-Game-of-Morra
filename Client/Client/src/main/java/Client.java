// file yang lama

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.function.Consumer;

public class Client extends Thread {
    String IP;
    Integer Port;
    Boolean isConnected;
    Socket socketClient;
    Integer zero = 0;
    Integer one = 1;
    Integer two = 2;
    Integer three = 3;
    Integer four = 4;
    Integer five = 5;

    ObjectOutputStream out;
    ObjectInputStream in;

    MorraInfo passMorraClass;

    String inputFromUser;

    private Consumer<Serializable> callback;

    Client(Consumer<Serializable> call)
    {
        isConnected = false;
        callback = call;
    }

    public void run() {
        try {
            socketClient = new Socket(IP, Port);
            out = new ObjectOutputStream(socketClient.getOutputStream());
            in = new ObjectInputStream(socketClient.getInputStream());
            socketClient.setTcpNoDelay(true);
        }
        catch(Exception e) {
            System.out.println("Unable to connect to the server.");
        }

        isConnected = true;

        // Listening for messages
        while(true) {

            try {
                String message = in.readObject().toString();
                // Accept a message and pass it along to the call
                callback.accept(message);
            }
            catch(Exception e) {}
        }
    }

    public void send(MorraInfo data) {
        try {
            // making a new morainfo class to send it to the server
            passMorraClass = new MorraInfo();
            out.writeObject(data);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void sendMorraInfoClass(String inputUser) {
        try {
            // making a new morainfo class to send it to the server
            passMorraClass = new MorraInfo();
            passMorraClass.playerPlays = inputUser;
            out.writeObject(passMorraClass);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setIP(String IP)
    {
        this.IP = IP;
    }

    public void setPort(Integer Port) {
        this.Port = Port;
    }
}
