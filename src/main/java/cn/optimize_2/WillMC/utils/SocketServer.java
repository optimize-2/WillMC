package cn.optimize_2.WillMC.utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class SocketServer {
    public static LinkedList q = new LinkedList<String>();

    public static ServerSocket ss;
    public static Socket s;
    public static BufferedReader br;
    public static BufferedWriter bw;


    public static void load() {
        try {
            System.out.println("[WillMC SocketServer] Starting socket server...");
            ss = new ServerSocket(2333);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void start() throws IOException {
        try {
            Thread connect = new SocketConnect();
            connect.setName("connect");
            connect.setPriority(5);
            connect.start();
            Thread listener = new SocketListener();
            listener.setName("listener");
            listener.setPriority(5);
            listener.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void send(String msg) {
        q.offer(msg);
        Thread send = new SocketSend();
        send.setName("send");
        send.setPriority(5);
        send.start();
    }
}
