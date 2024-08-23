package com.guedosha.martlib.commands;

import com.guedosha.martlib.util.StatusHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String reloaded = ChatColor.translateAlternateColorCodes('&', "&a[MartLib] &fSuccessfully Reloaded Config");
        if (sender instanceof Player p) {
            if (!p.hasPermission("Martlib.reload")) {
                p.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
                return true;
            }
            new StatusHandler().reloadConfig();
            p.sendMessage(reloaded);
        } else if (sender instanceof ConsoleCommandSender){
            new StatusHandler().reloadConfig();
        }
        return true;
    }
}
