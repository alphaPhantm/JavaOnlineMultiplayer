package server.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket serverSocket;
    Socket socket;

    public void launch() throws IOException {

        serverSocket = new ServerSocket(1337);

    }

    public void run() throws IOException {

        while (true) {

            socket = serverSocket.accept();
            String message = reciveMessage();
            System.out.println(message);
            if (message.equals("Hallo")) {
                sendMessage("Hallo Client");
            } else {
                sendMessage("Wer bist du ?");
            }

        }

    }

    private String reciveMessage() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }

    private void sendMessage(String message) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println(message);
    }
}
