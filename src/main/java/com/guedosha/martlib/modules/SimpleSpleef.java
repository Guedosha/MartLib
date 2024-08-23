package com.guedosha.martlib.modules;

import com.guedosha.martlib.util.StatusHandler;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class SimpleSpleef implements Listener {
    @EventHandler
    public void onProjectileLandEvent(ProjectileHitEvent e) {
        if (!(new StatusHandler().isSimpleSpleef())) return;
        if (!(e.getEntity().getShooter() instanceof Player)) return;

        Player p = (Player) e.getEntity().getShooter();
        Block b = e.getHitBlock();
        Entity v = e.getHitEntity();
        Entity entity = e.getEntity();

        if (b == null) { return; }
        if (b.getType() != Material.SNOW_BLOCK) { return; }
        if (entity.getType() != EntityType.SNOWBALL) { return; }
        if (v == null) { b.setType(Material.AIR); }

        b.setType(Material.AIR);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (!(new StatusHandler().isSimpleSpleef())) return;

        Player p = e.getPlayer();
        Material b = e.getBlock().getType();
        Material i = e.getPlayer().getInventory().getItemInMainHand().getType();

        if (i != Material.GOLDEN_SHOVEL) { return; }
        if (b != Material.SNOW_BLOCK) { return; }

        p.getInventory().addItem(new ItemStack(Material.SNOWBALL, 2));
        e.setDropItems(false);
    }
}
