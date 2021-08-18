package cn.optimize_2.WillMC;

import cn.optimize_2.WillMC.utils.PlayerChatListener;
import cn.optimize_2.WillMC.utils.SocketServer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WillMC extends JavaPlugin {
    static FileConfiguration configFile;

    public static FileConfiguration getConfigFile() {
        return configFile;
    }

    @Override
    public void onLoad() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        configFile = getConfig();
        SocketServer.load();
    }

    @Override
    public void onEnable() {
        System.out.println("[WillMC] Author: optimize_2 (qq 2086297211)");
        new PlayerChatListener(this);
        try {
            SocketServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*
    §1深蓝
　 　§2深绿
　 　§3天蓝
　 　§4红色
　 　§5深紫
　 　§6金黄
　 　§7浅灰
　 　§8深灰
　 　§9淡紫
　 　§a浅绿
　 　§b淡蓝
　 　§c淡红
　 　§d淡紫
　 　§e淡黄
　 　§f白色
    §l字体加粗
　　 §m斜体字
　　 §n下划线
    */
}
