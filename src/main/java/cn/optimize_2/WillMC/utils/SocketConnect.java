package cn.optimize_2.WillMC.utils;
import cn.optimize_2.WillMC.utils.SocketServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SocketConnect extends Thread {
    public void run() {
        while (true) {
            try {
                SocketServer.s = SocketServer.ss.accept();
                SocketServer.br = new BufferedReader(new InputStreamReader(SocketServer.s.getInputStream(), "UTF-8"));
                SocketServer.bw = new BufferedWriter(new OutputStreamWriter(SocketServer.s.getOutputStream(), "UTF-8"));
                System.out.println("[WillMC SocketServer] Socket connected");
            } catch (Exception e) {
                // 我管你呢日你妈
            }
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
