package com.guedosha.martlib.modules;

import com.guedosha.martlib.util.StatusHandler;
import io.lumine.mythic.bukkit.utils.events.extra.ArmorEquipEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

public class SeasonalItems implements Listener {

    // To the unfortunate soul reading this: I am sorry for my ungodly amount of boilerplate. Lord have mercy.

    @EventHandler
    public void playerInteract(PlayerInteractEvent e) {
        if (!(new StatusHandler().isSeasonalItems())) return;

        ItemStack mainHand = e.getPlayer().getInventory().getItemInMainHand();
        ItemStack offHand = e.getPlayer().getInventory().getItemInOffHand();

        if (mainHand.hasItemMeta()) {
            ItemMeta mainMeta = mainHand.getItemMeta();
            if (!mainMeta.hasLore()) return;
            if (!(mainMeta.getLore().contains(ChatColor.DARK_PURPLE + "Verified")||mainMeta.getLore().contains("Bug Finder Trophy"))) return;
            e.setCancelled(true);
        }

        if (offHand.hasItemMeta()) {
            ItemMeta offMeta = offHand.getItemMeta();
            if (!offMeta.hasLore()) return;
            if (!offMeta.getLore().contains(ChatColor.DARK_PURPLE + "Verified")) return;
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void playerConsume(PlayerItemConsumeEvent e) {
        if (!(new StatusHandler().isSeasonalItems())) return;

        ItemStack mainHand = e.getPlayer().getInventory().getItemInMainHand();
        ItemStack offHand = e.getPlayer().getInventory().getItemInOffHand();

        if (mainHand.hasItemMeta()) {
            ItemMeta mainMeta = mainHand.getItemMeta();
            if (!mainMeta.hasLore()) return;
            if (!mainMeta.getLore().contains(ChatColor.DARK_PURPLE + "Verified")) return;
            e.setCancelled(true);
        }

        if (offHand.hasItemMeta()) {
            ItemMeta offMeta = offHand.getItemMeta();
            if (!offMeta.hasLore()) return;
            if (!offMeta.getLore().contains(ChatColor.DARK_PURPLE + "Verified")) return;
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void resurrectEvent(EntityResurrectEvent e) {
        if (!(e.getEntity() instanceof Player p)) return;
        if (!(new StatusHandler().isSeasonalItems())) return;
        ItemStack mainHand = p.getInventory().getItemInMainHand();
        ItemStack offHand = p.getInventory().getItemInOffHand();

        if (mainHand.hasItemMeta()) {
            ItemMeta mainMeta = mainHand.getItemMeta();
            if (!mainMeta.hasLore()) return;
            if (!mainMeta.getLore().contains(ChatColor.DARK_PURPLE + "Verified")) return;
            e.setCancelled(true);
        }

        if (offHand.hasItemMeta()) {
            ItemMeta offMeta = offHand.getItemMeta();
            if (!offMeta.hasLore()) return;
            if (!offMeta.getLore().contains(ChatColor.DARK_PURPLE + "Verified")) return;
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        if (!(new StatusHandler().isSeasonalItems())) return;

        CraftingInventory inv = e.getInventory();
        for (ItemStack item : inv.getStorageContents()) {
            try {
                if (item.getItemMeta().getLore().contains(ChatColor.DARK_PURPLE + "Verified")) inv.setResult(null);
            } catch (NullPointerException ignored) {}
        }
    }

    @EventHandler
    public void onSmith(SmithItemEvent e) {
        if (!(new StatusHandler().isSeasonalItems())) return;

        SmithingInventory inv = e.getInventory();
        for (ItemStack item : inv.getStorageContents()) {
            try {
                if (item.getItemMeta().getLore().contains(ChatColor.DARK_PURPLE + "Verified")) inv.setResult(null);
            } catch (NullPointerException ignored) {}
        }
    }

    @EventHandler
    public void onBrew(BrewEvent e) {
        if (!(new StatusHandler().isSeasonalItems())) return;

        BrewerInventory inv = e.getContents();
        for (ItemStack item : inv.getStorageContents()) {
            try {
                if (item.getItemMeta().getLore().contains(ChatColor.DARK_PURPLE + "Verified")) e.setCancelled(true);
            } catch (NullPointerException ignored) {}
        }
    }

    @EventHandler
    public void onArmorEquip(ArmorEquipEvent e) {
        if (!(new StatusHandler().isSeasonalItems())) return;

        ItemStack item = e.getNewArmorPiece();
        ItemStack old = e.getOldArmorPiece();
        if (item.getItemMeta().getLore().contains(ChatColor.DARK_PURPLE + "Verified")) e.setCancelled(true);
        else if (old.getItemMeta().getLore().contains(ChatColor.DARK_PURPLE + "Verified")) e.setCancelled(true);
//        try {
//            if (item.getItemMeta().getLore().contains(ChatColor.DARK_PURPLE + "Verified")) e.setCancelled(true);
//        } catch (NullPointerException ignored) {}
//        try {
//            if (old.getItemMeta().getLore().contains(ChatColor.DARK_PURPLE + "Verified")) e.setCancelled(true);
//        } catch (NullPointerException ignored) {}
    }

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e) {
        if (!(new StatusHandler().isSeasonalItems())) return;

        if (e.getDamager() instanceof Player p) {
            ItemStack item = p.getInventory().getItemInMainHand();
            try {
                if (item.getItemMeta().getLore().contains(ChatColor.DARK_PURPLE + "Verified")) e.setCancelled(true);
            } catch (NullPointerException ignored) {}
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (!(new StatusHandler().isSeasonalItems())) return;

        if (e.getWhoClicked() instanceof Player p) {
            ItemStack cursor = e.getView().getCursor();
            try {
                if (!cursor.getItemMeta().getLore().contains(ChatColor.DARK_PURPLE + "Verified")) return;
                if (e.getSlotType().equals(InventoryType.SlotType.ARMOR)) e.setCancelled(true);
            } catch (NullPointerException ignored) {}
            if (e.getClick() == ClickType.SHIFT_LEFT || e.getClick() == ClickType.SHIFT_RIGHT) {
                try {
                    if (e.getCurrentItem().getItemMeta().getLore().contains(ChatColor.DARK_PURPLE + "Verified")) e.setCancelled(true);
                } catch (NullPointerException ignored) {}
            }
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        if (!(new StatusHandler().isSeasonalItems())) return;

        if (e.getWhoClicked() instanceof Player p) {
            try {
                if (!e.getCursor().getItemMeta().getLore().contains(ChatColor.DARK_PURPLE + "Verified")) return;
                e.setCancelled(true);
            } catch (NullPointerException ignored) {}
        }
    }

    @EventHandler
    public void dispense(BlockDispenseEvent e) {
        if (!(new StatusHandler().isSeasonalItems())) return;
        ItemStack item = e.getItem();

        try {
            if (!(item.getItemMeta().getLore().contains(ChatColor.DARK_PURPLE + "Verified")||item.getItemMeta().getLore().contains("Bug Finder Trophy"))) return;
            e.setCancelled(true);
        } catch (NullPointerException ignored) {}
    }
}
