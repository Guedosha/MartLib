package com.guedosha.martlib.modules;

import com.guedosha.martlib.MartLib;
import com.guedosha.martlib.util.StatusHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class InvincibilityFrames implements Listener {

    Plugin plugin = MartLib.getPlugin(MartLib.class);

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        StatusHandler statHand = new StatusHandler();

        if (!(statHand.isInvincibilityFrames())) return;
        e.getPlayer().setNoDamageTicks(statHand.getInvincibilityTicks());
    }
}
