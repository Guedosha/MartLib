package com.guedosha.martlib.modules;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.raid.RaidSpawnWaveEvent;

public class EasyRaidEvokers implements Listener {
    @EventHandler
    public void raidWave(RaidSpawnWaveEvent e) {
        Location loc = e.getPatrolLeader().getLocation();

        if (e.getRaid().getBadOmenLevel() >= 2) {
            loc.getWorld().spawnEntity(loc, EntityType.EVOKER);
        }

        if (e.getRaid().getBadOmenLevel() >= 4) {
            double randDouble = Math.random();
            if (randDouble < 0.25) {
                loc.getWorld().spawnEntity(loc, EntityType.EVOKER);
            }
        }
    }
}
