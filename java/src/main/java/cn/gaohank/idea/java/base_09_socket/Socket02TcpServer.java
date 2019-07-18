package cn.gaohank.idea.java.base_09_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Socket02TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        Socket socket = serverSocket.accept();

        System.out.println("监听成功");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("服务器端接收：" + bufferedReader.readLine());

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("hello client");
        printWriter.flush();
    }
}
