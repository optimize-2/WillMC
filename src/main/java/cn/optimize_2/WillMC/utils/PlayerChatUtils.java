package cn.optimize_2.WillMC.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


public class PlayerChatUtils {
    public static void sendChatMessage(String msg) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage("§a[QQ] " + msg);
        }
    }
}
