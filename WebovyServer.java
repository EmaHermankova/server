package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebovyServer {
    public static void main(String[] args) throws IOException {
        System.out.println("start");
        ServerSocket server = new ServerSocket(10000);

        System.out.println("krok1");
        Socket socket = server.accept();

        System.out.println("krok2");
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        in.readLine();

        out.println("HTTP/1.0 200");//oblafnuti webovyho prohlizece. proste prohlizeci reknes,
        // jakym protokolem se bude trn program s nim bavit.
        out.println();
        out.println("marie, hod sem cihlu, ma se vracet, taratata \n" +
                "marie ma se vracet, ta co tu bydli \n" +
                "marie ma se vracet, tak postav zidli \n");

        socket.close();
        System.out.println("hotovo");
    }
}
