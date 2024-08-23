package com.guedosha.martlib.modules;

import com.guedosha.martlib.util.StatusHandler;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class WardenHeartFix implements Listener {
    @EventHandler
    public void blockBreakEvent(BlockBreakEvent e) {
        if (!(new StatusHandler().isWardenHeartFix())) return;

        if (e.getBlock().getType().equals(Material.SCULK_CATALYST)) e.setExpToDrop(0);
        else if (e.getBlock().getType().equals(Material.SCULK_SHRIEKER)) e.setExpToDrop(0);
    }
}
