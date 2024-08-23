package com.guedosha.martlib.util;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LogHandler {
    public enum LogType{
        ADVANCEMENT,RESPAWN,CHAT,SLEPT,DEATH,TELEPORT,KICK,QUIT,JOIN,GAMEMODE,COMMAND,CREATIVE
    }

    private static File logFile;
    private static File logDir;
    private static FileConfiguration logFileConfig;

    public static void setup(Player player, LogType logType) {
        String name = player.getName();
        System.out.println("setup()");
        String dir = Bukkit.getServer().getPluginManager().getPlugin("MartLib").getDataFolder().getAbsolutePath() + "/PlayerLogs/" + name;
        logDir = new File(dir);
        logFile = new File(dir, logType.name()+".yml");

        if (!logDir.exists()) {
            if (logDir.mkdirs()) {
                System.out.println("Directory created");
            } else {
                System.out.println("Failed to create directory");
            }
        }
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Failed to create log file");
                return;
            }
        }
        logFileConfig = YamlConfiguration.loadConfiguration(logFile);
        switch (logType) {
            case ADVANCEMENT -> AdvancementConfigs.put(player.getUniqueId(), logFileConfig);
            case JOIN -> JoinConfigs.put(player.getUniqueId(), logFileConfig);
            case CHAT -> ChatConfigs.put(player.getUniqueId(), logFileConfig);
            case COMMAND -> CommandConfigs.put(player.getUniqueId(), logFileConfig);
            case CREATIVE -> CreativeConfigs.put(player.getUniqueId(), logFileConfig);
            case DEATH -> DeathConfigs.put(player.getUniqueId(), logFileConfig);
            case GAMEMODE -> GamemodeConfigs.put(player.getUniqueId(), logFileConfig);
            case KICK -> KickConfigs.put(player.getUniqueId(), logFileConfig);
            case QUIT -> QuitConfigs.put(player.getUniqueId(), logFileConfig);
            case RESPAWN -> RespawnConfigs.put(player.getUniqueId(), logFileConfig);
            case SLEPT -> SleptConfigs.put(player.getUniqueId(), logFileConfig);
            case TELEPORT -> TeleportConfigs.put(player.getUniqueId(), logFileConfig);
        }
        System.out.println("setup() complete");
    }

    private static HashMap<UUID,FileConfiguration> AdvancementConfigs = new HashMap<UUID,FileConfiguration>();
    private static HashMap<UUID,FileConfiguration> RespawnConfigs = new HashMap<UUID,FileConfiguration>();
    private static HashMap<UUID,FileConfiguration> ChatConfigs = new HashMap<UUID,FileConfiguration>();
    private static HashMap<UUID,FileConfiguration> SleptConfigs = new HashMap<UUID,FileConfiguration>();
    private static HashMap<UUID,FileConfiguration> DeathConfigs = new HashMap<UUID,FileConfiguration>();
    private static HashMap<UUID,FileConfiguration> TeleportConfigs = new HashMap<UUID,FileConfiguration>();
    private static HashMap<UUID,FileConfiguration> KickConfigs = new HashMap<UUID,FileConfiguration>();
    private static HashMap<UUID,FileConfiguration> QuitConfigs = new HashMap<UUID,FileConfiguration>();
    private static HashMap<UUID,FileConfiguration> JoinConfigs = new HashMap<UUID,FileConfiguration>();
    private static HashMap<UUID,FileConfiguration> GamemodeConfigs = new HashMap<UUID,FileConfiguration>();
    private static HashMap<UUID,FileConfiguration> CommandConfigs = new HashMap<UUID,FileConfiguration>();
    private static HashMap<UUID,FileConfiguration> CreativeConfigs = new HashMap<UUID,FileConfiguration>();

    public static FileConfiguration get(LogType type, Player p) {
        UUID id = p.getUniqueId();
        return switch (type) {
            case ADVANCEMENT -> AdvancementConfigs.get(id);
            case RESPAWN -> RespawnConfigs.get(id);
            case CHAT -> ChatConfigs.get(id);
            case SLEPT -> SleptConfigs.get(id);
            case DEATH -> DeathConfigs.get(id);
            case TELEPORT -> TeleportConfigs.get(id);
            case KICK -> KickConfigs.get(id);
            case QUIT -> QuitConfigs.get(id);
            case JOIN -> JoinConfigs.get(id);
            case GAMEMODE -> GamemodeConfigs.get(id);
            case COMMAND -> CommandConfigs.get(id);
            case CREATIVE -> CreativeConfigs.get(id);
        };
    }

    public static void save(LogType type, Player p) {
        System.out.println("JoinConfigs.getid = "+JoinConfigs.get(p.getUniqueId()).toString());
        UUID id = p.getUniqueId();
        String name = p.getName();
        File file = null;
        System.out.println("Switch start");
        switch (type) {
            case ADVANCEMENT -> iDontLikePasting12Times(AdvancementConfigs.get(id), type.name(), p.getName(), id);
            case RESPAWN -> iDontLikePasting12Times(RespawnConfigs.get(id), type.name(), p.getName(), id);
            case CHAT -> iDontLikePasting12Times(ChatConfigs.get(id), type.name(), p.getName(), id);
            case SLEPT -> iDontLikePasting12Times(SleptConfigs.get(id), type.name(), p.getName(), id);
            case DEATH -> iDontLikePasting12Times(DeathConfigs.get(id), type.name(), p.getName(), id);
            case TELEPORT -> iDontLikePasting12Times(TeleportConfigs.get(id), type.name(), p.getName(), id);
            case KICK -> iDontLikePasting12Times(KickConfigs.get(id), type.name(), p.getName(), id);
            case QUIT -> iDontLikePasting12Times(QuitConfigs.get(id), type.name(), p.getName(), id);
            case JOIN -> iDontLikePasting12Times(JoinConfigs.get(id), type.name(), p.getName(), id);
            case GAMEMODE -> iDontLikePasting12Times(GamemodeConfigs.get(id), type.name(), p.getName(), id);
            case COMMAND -> iDontLikePasting12Times(CommandConfigs.get(id), type.name(), p.getName(), id);
            case CREATIVE -> iDontLikePasting12Times(CreativeConfigs.get(id), type.name(), p.getName(), id);
        };
        System.out.println("Switch End");
    }

    public static void iDontLikePasting12Times(FileConfiguration config, String type, String name, UUID id) {
        String dir = Bukkit.getPluginManager().getPlugin("MartLib").getDataFolder().getAbsolutePath();
        File file = new File(dir+"/PlayerLogs/"+name+"/"+type+".yml");
        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
