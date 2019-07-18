package cn.gaohank.idea.java.base_09_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Socket01TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10000);

        InetAddress localAddress = socket.getLocalAddress();
        System.out.println(localAddress.getHostName());
        System.out.println(localAddress.getHostAddress());
        System.out.println(InetAddress.getLocalHost());
        System.out.println(InetAddress.getLoopbackAddress());
        System.out.println(socket.getPort());
        System.out.println(socket.getLocalPort());
        System.out.println(socket.getInetAddress());
        System.out.println(socket.getLocalAddress());

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("hello server");
        printWriter.flush();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());

        socket.close();
    }
}
