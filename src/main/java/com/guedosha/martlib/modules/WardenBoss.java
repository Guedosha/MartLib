package com.guedosha.martlib.modules;

import com.guedosha.martlib.MartLib;
import com.guedosha.martlib.util.StatusHandler;
import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.mobs.ActiveMob;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class WardenBoss implements Listener {
    Plugin plugin = MartLib.getPlugin(MartLib.class);

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        if (!(new StatusHandler().isWardenBoss())) return;

        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand().getType() == Material.NETHER_STAR){
            if (e.getClickedBlock().getType() != Material.SCULK_SHRIEKER) return;
            if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;

            p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);

            for (int i = 0; i <12; i++) {
                p.getWorld().strikeLightning(e.getClickedBlock().getLocation());
            }

            p.sendMessage(locationNormalize(p.getLocation()));
            MythicMob mob = MythicBukkit.inst().getMobManager().getMythicMob("WardenBoss").orElse(null);
            Location spawnLoc = e.getClickedBlock().getLocation();
            ActiveMob boss = mob.spawn(BukkitAdapter.adapt(spawnLoc),1);

            p.getWorld().playSound(e.getClickedBlock().getLocation(), "littlelife.warden_spawn", 1, 1);
            p.getWorld().playSound(e.getClickedBlock().getLocation(), "littlelife.warden_fast_whisper", 1, 1);

            p.getWorld().spawnParticle(Particle.DRAGON_BREATH, e.getClickedBlock().getLocation(), 500);

            e.getClickedBlock().setType(Material.AIR);
        } else if (p.getInventory().getItemInOffHand().getType() == Material.NETHER_STAR) {
            if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
            if (e.getClickedBlock().getType() != Material.SCULK_SHRIEKER) return;

            p.getInventory().getItemInOffHand().setAmount(p.getInventory().getItemInOffHand().getAmount()-1);

            p.sendMessage(locationNormalize(p.getLocation()));

            p.getWorld().playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1 ,1);

            p.getWorld().spawnParticle(Particle.DRAGON_BREATH, e.getClickedBlock().getLocation(), 500);

            e.getClickedBlock().setType(Material.AIR);

            for (Player online : Bukkit.getOnlinePlayers()) {
                online.getWorld().playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_WARDEN_EMERGE, 1, 1);
            }
            e.getPlayer().getWorld().playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_WARDEN_EMERGE, 1, 1);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    MythicMob mob = MythicBukkit.inst().getMobManager().getMythicMob("WardenBoss").orElse(null);
                    Location spawnLoc = e.getClickedBlock().getLocation();
                    ActiveMob boss = mob.spawn(BukkitAdapter.adapt(spawnLoc),1);
                    for (int i = 0; i <12; i++) {
                        p.getWorld().strikeLightning(e.getClickedBlock().getLocation());
                    }
                    p.getWorld().playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_WARDEN_ROAR, 2, 1);
                }
            }, 105);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    p.getWorld().playSound(e.getClickedBlock().getLocation(), "littlelife.warden_whispering_fast", 1, 1);
                }
            }, 140);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        online.getWorld().playSound(e.getClickedBlock().getLocation(), "littlelife.warden_spawn", 1, 1);
                    }
                }
            }, 160);

        }

    }

    public String locationNormalize(Location location) {
        return location.getWorld().getName()+","+location.getBlockX()+","+location.getBlockY()+","+location.getBlockZ();
    }

    public void playSound(Sound s, Location loc, int volume, int pitch) {

    }

    public void playSound(Sound s, int volume, int pitch) {
        HandlerList handlerList = PlayerInteractEvent.getHandlerList();
        handlerList.unregister(new WardenBoss());
    }
}
