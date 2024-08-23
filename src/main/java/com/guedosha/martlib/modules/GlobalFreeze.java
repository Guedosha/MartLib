package com.guedosha.martlib.modules;

import com.guedosha.martlib.MartLib;
import com.guedosha.martlib.util.StatusHandler;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class GlobalFreeze implements Listener {

    //This code is incredibly unoptimized and was quickly slapped together for the purpose of only being functional.

    Plugin plugin = MartLib.getPlugin(MartLib.class);

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (!(new StatusHandler().isGlobalFreeze())) return;

        if (!e.getPlayer().hasPermission("MartLib.GlobalFreeze.move")) {
            new BukkitRunnable(){
                public void run(){
                    e.getPlayer().sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Please wait");
                    e.getPlayer().sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You will be allowed to move shortly");
                }
            }.runTaskLater(plugin, 20);
            e.getPlayer().sendTitle(ChatColor.GOLD + "" + ChatColor.BOLD + "Please wait", ChatColor.GOLD + "" + ChatColor.BOLD + "You will be allowed to move shortly", 5, 240, 5);
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        if (!(new StatusHandler().isGlobalFreeze())) return;

        if (!e.getPlayer().hasPermission("MartLib.GlobalFreeze.move")) {
            e.setCancelled(true);
            e.getPlayer().sendTitle(ChatColor.GOLD + "" + ChatColor.BOLD + "Please wait", ChatColor.GOLD + "" + ChatColor.BOLD + "You will be allowed to move shortly", 5, 240, 5);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (!(new StatusHandler().isGlobalFreeze())) return;

        if (!e.getPlayer().hasPermission("MartLib.GlobalFreeze.move")) e.setCancelled(true);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (!(new StatusHandler().isGlobalFreeze())) return;

        if (!e.getPlayer().hasPermission("MartLib.GlobalFreeze.move")) e.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (!(new StatusHandler().isGlobalFreeze())) return;

        if (!e.getPlayer().hasPermission("MartLib.GlobalFreeze.move")) e.setCancelled(true);
    }

    @EventHandler
    public void onInventoryInteract(InventoryClickEvent e) {
        if (!(new StatusHandler().isGlobalFreeze())) return;

        if (!e.getWhoClicked().hasPermission("MartLib.GlobalFreeze.move")) e.setCancelled(true);
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e){
        if (!(new StatusHandler().isGlobalFreeze())) return;

        if (!e.getPlayer().hasPermission("MartLib.GlobalFreeze.move")) e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e) {
        if (!(new StatusHandler().isGlobalFreeze())) return;

        if (e.getEntity() instanceof Player p) {
            if (!p.hasPermission("MartLib.GlobalFreeze.move")) e.setCancelled(true);
        }
    }
}
