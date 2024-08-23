package com.guedosha.martlib.util;

import com.guedosha.martlib.MartLib;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public class Misc {

    Plugin plugin = MartLib.getPlugin(MartLib.class);
    public static StatusHandler statHand = new StatusHandler();

    public void formatMessage(boolean prefix, String message) {
        if (prefix) Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[MartLib] " + message));
        else Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public void error(boolean prefix, String message) {
        if (prefix) Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[MartLib] &4" + message));
        else Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4" + message));
    }

    public void initializeConfig() {
        plugin.getConfig().options().copyDefaults();
        plugin.saveDefaultConfig();
    }

}
