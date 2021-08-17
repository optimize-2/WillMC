package cn.optimize_2.WillMC.utils;

import java.io.IOException;
import java.net.SocketException;

public class SocketSend extends Thread {
    public void run() {
        while (!SocketServer.q.isEmpty()) {
            String msg = SocketServer.q.poll().toString();
            try {
                try {
                    SocketServer.bw.write(msg + "\n");
                    SocketServer.bw.flush();
                    System.out.println("[WillMC SocketServer] Sent message: " + msg);
                } catch (NullPointerException | SocketException e) {
                    // 管你呢
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
