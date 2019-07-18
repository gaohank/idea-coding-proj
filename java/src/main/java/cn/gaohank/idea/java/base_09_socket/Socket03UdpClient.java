package cn.gaohank.idea.java.base_09_socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Socket03UdpClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] bytes = "hello server".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.1"), 10000);
        datagramSocket.send(datagramPacket);
    }
}
