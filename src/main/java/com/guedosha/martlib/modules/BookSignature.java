package com.guedosha.martlib.modules;

import com.guedosha.martlib.MartLib;
import com.guedosha.martlib.util.Misc;
import com.guedosha.martlib.util.StatusHandler;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BookSignature implements CommandExecutor {

    Plugin plugin = MartLib.getPlugin(MartLib.class);

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (!(new StatusHandler().isBookSignature())) {
            if (commandSender instanceof Player p) {
                p.sendMessage(ChatColor.RED + "This module is disabled!");
            } else {
                plugin.getLogger().info(ChatColor.RED + "This module is disabled!");
            }
            return true;
        }

        if (!(commandSender instanceof Player)) {
            plugin.getLogger().warning("This command can only be ran by players!");
        } else {
            Player p = ((Player) commandSender).getPlayer();
            if (!(p.getInventory().getItemInMainHand().getType().equals(Material.WRITTEN_BOOK))) {
                p.sendMessage(ChatColor.RED + "You can only sign written books!");
                return true;
            }
            if (p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                if (p.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§f" + p.getName())) {
                    p.sendMessage(ChatColor.RED + "You can only sign a book once!");
                    return true;
                } else
                    signBook(p, p.getInventory().getItemInMainHand(), true);
            } else
                signBook(p, p.getInventory().getItemInMainHand(), false);
        }
        return true;
    }

    private void signBook(Player p, ItemStack book, boolean hasLore) {
        if (!hasLore) {
            ItemMeta meta = book.getItemMeta();
            List<String> lore = new ArrayList<>();

            lore.add("");
            lore.add(ChatColor.AQUA + "Signed By:");
            lore.add(ChatColor.WHITE + p.getName());

            meta.setLore(lore);
            book.setItemMeta(meta);
            p.sendMessage(ChatColor.YELLOW + "Book Signed!");
            p.playSound(p, Sound.ITEM_BOOK_PAGE_TURN, 1, 1);

        } else if (book.getItemMeta().getLore().toString().contains("Signed By:")){
            ItemMeta meta = book.getItemMeta();
            List<String> lore = meta.getLore();

            lore.add(ChatColor.WHITE + p.getName());

            meta.setLore(lore);
            book.setItemMeta(meta);

            p.sendMessage(ChatColor.YELLOW + "Book Signed!");
            p.playSound(p, Sound.ITEM_BOOK_PAGE_TURN, 1, 1);
        } else {
            ItemMeta meta = book.getItemMeta();
            List<String> lore = meta.getLore();

            lore.add("");
            lore.add(ChatColor.AQUA + "Signed By:");
            lore.add(ChatColor.WHITE + p.getName());

            meta.setLore(lore);
            book.setItemMeta(meta);

            p.sendMessage(ChatColor.YELLOW + "Book Signed!");
            p.playSound(p, Sound.ITEM_BOOK_PAGE_TURN, 1, 1);
        }
    }
}
