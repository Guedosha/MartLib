package com.guedosha.martlib.modules;

import com.guedosha.martlib.util.StatusHandler;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.geysermc.floodgate.api.FloodgateApi;

public class DeathCoordinates implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {

        if (!(new StatusHandler().isDeathCoordinates())) return;

        Player p = e.getEntity();
        Location loc = e.getEntity().getLocation();
        String formLoc = loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ();

        FloodgateApi floodgate = FloodgateApi.getInstance();

        if (!floodgate.isFloodgatePlayer(p.getUniqueId())) {
            TextComponent message = new TextComponent(ChatColor.translateAlternateColorCodes('&',"&7Hover to see death coordinates"));
            message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(ChatColor.translateAlternateColorCodes('&',"&f"+formLoc+" &7Click to copy"))));
            message.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, formLoc));

            p.spigot().sendMessage(message);
            return;
        }

        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7Death Coordinates: &f" + formLoc));

    }
}
