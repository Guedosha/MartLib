package com.guedosha.martlib.modules;

import com.guedosha.martlib.util.StatusHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class StopSoundsOnDeath implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (!(new StatusHandler().isStopSoundsOnDeath())) return;

        e.getEntity().stopAllSounds();
    }
}
