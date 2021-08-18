package cn.optimize_2.WillMC.utils;
import cn.optimize_2.WillMC.utils.SocketServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import static cn.optimize_2.WillMC.utils.SocketServer.s;

public class SocketConnect extends Thread {
    private Boolean check(String ip) {
        List<String> wl = SocketServer.whitelist;
        for (String add : wl) {
            String[] split1 = ("/" + add).split("\\.");
            String[] split2 = ip.split("\\.");
            if (split1.length != 4 || split2.length != 4) {
                System.out.println("[WillMC Error] A wrong ip-address appeared. Please check your config.");
            }
            for (int i = 0; i <= 3; i++) {
                if (split1[i].equals("*")) continue;
                else if (!split1[i].equals(split2[i])) return false;
            }
        }
        return true;
    }

    public void run() {
        while (true) {
            try {
                s = SocketServer.ss.accept();
                if (check(s.getInetAddress().toString())) {
                    SocketServer.br = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
                    SocketServer.bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));
                    System.out.println("[WillMC SocketServer] Client from " + s.getInetAddress() + " connected");
                } else {
                    System.out.println("[WillMC Warning] An unverified client from " + s.getInetAddress() + " tried to connect");
                }
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
