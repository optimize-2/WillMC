package cn.optimize_2.WillMC.utils;

import java.io.IOException;
import java.net.SocketException;

public class SocketListener extends Thread {
    public void run() {
        while (true) {
            try {
                try {
                    String msg = SocketServer.br.readLine();
                    if (msg == null) continue;
                    System.out.println("[WillMC SocketServer] Received message: " + msg);
                    PlayerChatUtils.sendChatMessage(msg);
                } catch (NullPointerException | SocketException e) {
                    // 管你呢
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
