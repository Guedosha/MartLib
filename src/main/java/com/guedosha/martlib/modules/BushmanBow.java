package com.guedosha.martlib.modules;

import com.guedosha.martlib.MartLib;
import com.guedosha.martlib.util.StatusHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.plugin.Plugin;

public class BushmanBow implements Listener {

    Plugin plugin = MartLib.getPlugin(MartLib.class);

    @EventHandler
    public void arrowLaunch(ProjectileLaunchEvent e) {

        if (!(e.getEntity().getShooter() instanceof Player p)) return;
        if (!(new StatusHandler().isBushmanBow())) return;

        try {
            if (p.getInventory().getItemInMainHand().hasItemMeta()) {
                if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Bushman's Bow")) {
                    e.getEntity().setGravity(false);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        @Override
                        public void run() {
                            e.getEntity().setGravity(true);
                        }
                    }, 300);
                }
            }
        } catch (NullPointerException ignored) {}
        try {
            if (p.getInventory().getItemInOffHand().hasItemMeta()) {
                if (p.getInventory().getItemInOffHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Bushman's Bow")) {
                    e.getEntity().setGravity(false);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        @Override
                        public void run() {
                            e.getEntity().setGravity(true);
                        }
                    }, 300);

                }
            }
        } catch (NullPointerException ignored) {}

    }
}
