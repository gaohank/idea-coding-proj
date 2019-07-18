package cn.gaohank.idea.java.base_09_socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Socket04UdpServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(10000);
        byte buf[] = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        String str = new String(buf, 0, buf.length);
        System.out.println(str);
    }
}
