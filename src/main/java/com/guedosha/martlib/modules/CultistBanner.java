package com.guedosha.martlib.modules;

import com.guedosha.martlib.MartLib;
import com.guedosha.martlib.util.Misc;
import org.bukkit.*;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CultistBanner implements CommandExecutor {

    Plugin plugin = MartLib.getPlugin(MartLib.class);

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player p) {
            Set<OfflinePlayer> dragon = Bukkit.getScoreboardManager().getMainScoreboard().getTeam("cult").getPlayers();
            Set<OfflinePlayer> sun  = Bukkit.getScoreboardManager().getMainScoreboard().getTeam("sun").getPlayers();
            for (OfflinePlayer offlinePlayer : dragon) {
                if (offlinePlayer.getName().equals(p.getName())) {
                    p.getInventory().addItem(getBanner(1));
                    p.sendMessage(ChatColor.WHITE + "You have been given the " + ChatColor.DARK_PURPLE + "Dragon Cultist Banner");
                }
            }
            for (OfflinePlayer offlinePlayer : sun) {
                if (offlinePlayer.getName().equals(p.getName())) {
                    p.getInventory().addItem(getBanner(0));
                    p.sendMessage(ChatColor.WHITE + "You have been given the " + ChatColor.YELLOW + "Sun Cultist Banner");
                }
            }
        } else {
            new Misc().error(true, "This command can only be ran by players");
        }
        return true;
    }

    public ItemStack getBanner(int type) {
        ItemStack banner;
        if (type == 1) {
            //dragon
            banner = new ItemStack(Material.PURPLE_BANNER);
            BannerMeta meta = (BannerMeta) banner.getItemMeta();
            assert meta != null;
            meta.setDisplayName(ChatColor.DARK_PURPLE + "Dragon Cultist Banner");

            List<Pattern> patterns = new ArrayList<Pattern>();
            patterns.add(new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_TOP));
            patterns.add(new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_BOTTOM));
            meta.setPatterns(patterns);
            banner.setItemMeta(meta);

        } else {
            //sun
            banner = new ItemStack(Material.YELLOW_BANNER);
            BannerMeta meta = (BannerMeta) banner.getItemMeta();
            assert meta != null;
            meta.setDisplayName(ChatColor.YELLOW + "Sun Cultist Banner");

            List<Pattern> patterns = new ArrayList<Pattern>();
            patterns.add(new Pattern(DyeColor.WHITE, PatternType.TRIANGLE_TOP));
            patterns.add(new Pattern(DyeColor.WHITE, PatternType.TRIANGLE_BOTTOM));
            meta.setPatterns(patterns);
            banner.setItemMeta(meta);
        }
        return banner;
    }
}
