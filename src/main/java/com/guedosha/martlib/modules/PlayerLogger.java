package com.guedosha.martlib.modules;

import com.guedosha.martlib.MartLib;
import com.guedosha.martlib.util.LogHandler;
import com.guedosha.martlib.util.LogHandler.LogType;
import com.guedosha.martlib.util.StatusHandler;
import org.bukkit.Location;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.player.*;
import org.bukkit.plugin.Plugin;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PlayerLogger implements Listener {

    //Once again, could be optimized but I'm lazy

    Plugin plugin = MartLib.getPlugin(MartLib.class);

    @EventHandler
    public void creativeEvent(InventoryCreativeEvent e) {
        if (!(new StatusHandler().isPlayerLogger())) return;

        Configuration config = LogHandler.get(LogType.CREATIVE, (Player) e.getWhoClicked());
        String date = FormatDate(Instant.now());

        Player p = (Player) e.getWhoClicked();
        String name = p.getName();
        Location loc = p.getLocation();
        String slot = e.getSlotType().name();
        String item = e.getCursor().getType().toString();
        String time = String.valueOf(new Date().getTime());

        config.set(time + ".Event", "Creative Event");
        config.set(time + ".Name", name);
        config.set(time + ".Slot", slot);
        config.set(time + ".Item", item);
        config.set(time + ".Loc", loc);
        LogHandler.save(LogType.CREATIVE, p);
    }

    @EventHandler
    public void commandSend(PlayerCommandPreprocessEvent e) {
        if (!(new StatusHandler().isPlayerLogger())) return;

        Configuration config = LogHandler.get(LogType.COMMAND, e.getPlayer());
        String date = FormatDate(Instant.now());


        Player p = e.getPlayer();
        String name = p.getName();
        Location loc = p.getLocation();
        String gamemode = p.getGameMode().toString();
        String command = e.getMessage();
        String time = String.valueOf(new Date().getTime());

        config.set(time + ".Event", "Command Sent");
        config.set(time + ".Name", name);
        config.set(time + ".Gamemode", gamemode);
        config.set(time + ".Command", command);
        config.set(time + ".Loc", loc);
       LogHandler.save(LogType.COMMAND, p);
    }

    @EventHandler
    public void gamemodeChange(PlayerGameModeChangeEvent e) {
        if (!(new StatusHandler().isPlayerLogger())) return;

        Configuration config = LogHandler.get(LogType.GAMEMODE, e.getPlayer());
        String date = FormatDate(Instant.now());


        Player p = e.getPlayer();
        String name = p.getName();
        Location loc = p.getLocation();
        String gamemode = p.getGameMode().toString();
        String time = String.valueOf(new Date().getTime());

        config.set(time + ".Event", "Gamemode Change");
        config.set(time + ".Name", name);
        config.set(time + ".Date", date);
        config.set(time + ".Gamemode", gamemode);
        config.set(time + ".Loc", loc);
       LogHandler.save(LogType.GAMEMODE, p);
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        if (!(new StatusHandler().isPlayerLogger())) return;
        setupLogFiles(e.getPlayer());

        FileConfiguration config = LogHandler.get(LogType.JOIN, e.getPlayer());
        String date = FormatDate(Instant.now());

        Player p = e.getPlayer();
        String name = p.getName();
        Location loc = p.getLocation();
        String ip = p.getAddress().toString();
        String time = String.valueOf(new Date().getTime());

        config.set(time + ".Name", name);
        config.set(time + ".EntityID", p.getEntityId());
        config.set(time + ".Date", date);
        config.set(time + ".Address", ip);
        config.set(time + ".Loc", loc);

        LogHandler.save(LogType.JOIN, p);
    }

    @EventHandler
    public void playerQuit(PlayerQuitEvent e) {
        if (!(new StatusHandler().isPlayerLogger())) return;

        Configuration config = LogHandler.get(LogType.QUIT, e.getPlayer());
        String date = FormatDate(Instant.now());

        Player p = e.getPlayer();
        String name = p.getName();
        String reason = e.getQuitMessage();
        Location loc = p.getLocation();
        String time = String.valueOf(new Date().getTime());

        config.set(time + ".Event", "Player Disconnect");
        config.set(time + ".Name", name);
        config.set(time + ".Cause", reason);
        config.set(time + ".Date",date);
        config.set(time + ".Loc", loc);
       LogHandler.save(LogType.QUIT, p);
    }

    @EventHandler
    public void playerKick(PlayerKickEvent e) {
        if (!(new StatusHandler().isPlayerLogger())) return;

        Configuration config = LogHandler.get(LogType.KICK, e.getPlayer());
        String date = FormatDate(Instant.now());

        Player p = e.getPlayer();
        String name = p.getName();
        String reason = e.getReason();
        Location loc = p.getLocation();
        String time = String.valueOf(new Date().getTime());

        config.set(time + ".Event", "Player Kicked");
        config.set(time + ".Name", name);
        config.set(time + ".Date", date);
        config.set(time + ".Reason", reason);
        config.set(time + ".Loc", loc);
       LogHandler.save(LogType.KICK, p);
    }

    @EventHandler
    public void playerTeleport(PlayerTeleportEvent e) {
        if (!(new StatusHandler().isPlayerLogger())) return;

        Configuration config = LogHandler.get(LogType.TELEPORT, e.getPlayer());
        String date = FormatDate(Instant.now());

        Player p = e.getPlayer();
        String name = p.getName();
        String time = String.valueOf(new Date().getTime());
        String reason = e.getCause().toString();

        config.set(time + ".Event", "Player Teleport");
        config.set(time + ".Name", name);
        config.set(time + ".Cause", reason);
        config.set(time + ".Date",date);
        config.set(time + ".To", e.getTo());
        config.set(time + ".From", e.getFrom());
       LogHandler.save(LogType.TELEPORT, p);
    }

    @EventHandler
    public void playerDeath(PlayerDeathEvent e) {
        if (!(new StatusHandler().isPlayerLogger())) return;

        Configuration config = LogHandler.get(LogType.DEATH, e.getEntity());
        String date = FormatDate(Instant.now());

        Player p = e.getEntity();

        String killer = null;
        try {
            killer = e.getEntity().getKiller().getName();
        } catch (NullPointerException ignored) {}
        String name = p.getName();
        Location loc = p.getLocation();
        String time = String.valueOf(new Date().getTime());
        String deathMessage = e.getDeathMessage();
        String cause = null;
        try {
            cause = p.getLastDamageCause().getCause().name();
        } catch (NullPointerException ignored) {}

        config.set(time + ".Event", "Player Death");
        config.set(time + ".Name", name);
        if (killer != null) config.set(time + ".Killer", killer);
        if (cause != null) config.set(time + ".Cause", cause);
         config.set(time + ".Message", deathMessage);
        config.set(time + ".Date",date);
        config.set(time + ".Loc", loc);
        LogHandler.save(LogType.DEATH, p);
    }

    @EventHandler
    public void playerSlept(PlayerBedEnterEvent e) {
        if (!(new StatusHandler().isPlayerLogger())) return;
        if (!(e.getBedEnterResult().equals(PlayerBedEnterEvent.BedEnterResult.OK) || e.getBedEnterResult().equals(PlayerBedEnterEvent.BedEnterResult.NOT_POSSIBLE_NOW))) return;

        Configuration config = LogHandler.get(LogType.SLEPT, e.getPlayer());
        String date = FormatDate(Instant.now());


        Player p = e.getPlayer();
        String name = p.getName();
        Location loc = p.getLocation();
        String time = String.valueOf(new Date().getTime());

        config.set(time + ".Event", "Set Spawn");
        config.set(time + ".Name", name);
        config.set(time + ".Date", date);
        config.set(time + ".Loc", loc);
        LogHandler.save(LogType.SLEPT, p);
    }

    @EventHandler
    public void chatLog(AsyncPlayerChatEvent e) {

    }

    @EventHandler
    public void respawn(PlayerRespawnEvent e) {
        if (!(new StatusHandler().isPlayerLogger())) return;

        Configuration config = LogHandler.get(LogType.RESPAWN, e.getPlayer());
        String date = FormatDate(Instant.now());

        Player p = e.getPlayer();
        String name = p.getName();
        Location loc = p.getLocation();
        String time = String.valueOf(new Date().getTime());

        config.set(time + ".Event", "Player Respawn");
        config.set(time + ".Name", name);
        config.set(time + ".Date", date);
        config.set(time + ".Loc", loc);
       LogHandler.save(LogType.RESPAWN, p);
    }

    @EventHandler
    public void advancement(PlayerAdvancementDoneEvent e) {
        if (!(new StatusHandler().isPlayerLogger())) return;
        String type = e.getAdvancement().getKey().toString();
        if(type.contains("minecraft:recipes")) return;

        Configuration config = LogHandler.get(LogType.ADVANCEMENT, e.getPlayer());
        String date = FormatDate(Instant.now());

        Player p = e.getPlayer();
        String name = p.getName();
        Location loc = p.getLocation();
        String time = String.valueOf(new Date().getTime());

        config.set(time + ".Event", "Advancement");
        config.set(time + ".Name", name);
        config.set(time + ".Date", date);
        config.set(time + ".Type", type);
        config.set(time + ".Location", loc);
        LogHandler.save(LogType.ADVANCEMENT, p);
    }



    //Util functions
    private void setupLogFiles(Player p) {
        System.out.println("setupLogFiles()");
        for (LogType type : LogType.values()) {
            System.out.println("setupLogFiles()forlooped");
            LogHandler.setup(p,type);
        }
    }

    public static String FormatDate(Instant instant) {
        ZoneId timezone = ZoneId.of("America/Phoenix");
        ZonedDateTime nowMT = ZonedDateTime.ofInstant(instant, timezone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss z");
        return nowMT.format(formatter);
    }

}
