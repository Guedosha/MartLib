package com.guedosha.martlib;

import com.guedosha.martlib.commands.CommandHandler;
import com.guedosha.martlib.modules.*;
import com.guedosha.martlib.util.Misc;
import com.guedosha.martlib.util.StatusHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class MartLib extends JavaPlugin {

    @Override
    public void onEnable() {

        ///this  is a test test test

        ConsoleCommandSender console = Bukkit.getConsoleSender();
        Misc misc = new Misc();
        StatusHandler statHand = null;

        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"========== &2&lMartLib&r =========="));

        try {
            misc.initializeConfig();
            misc.formatMessage(true, "&fSuccessfully Loaded Config");
        } catch (Exception e) {
            misc.error(true, "Error: Failed to load config!");
            misc.error(false, "Report this to 'guedosha' on Discord if you can't find errors in the config");
            misc.error(false, Arrays.toString(e.getStackTrace()));
            misc.error(false, "Shutting plugin down!");
            getServer().getPluginManager().disablePlugin(this);
        }

        try {
            misc.formatMessage(true, "&fInitializing Module Handler");
            statHand = new StatusHandler();
        } catch (Exception e) {
            misc.error(true, "Error: Failed to initialize status handler!");
            misc.error(false, "Report this to 'guedosha' on Discord if you can't find errors in the config");
            misc.error(false, Arrays.toString(e.getStackTrace()));
            misc.error(false, "Shutting plugin down!");
            getServer().getPluginManager().disablePlugin(this);
        }

        assert statHand != null;

        getCommand("reload").setExecutor(new CommandHandler());

        try {
            getCommand("sign").setExecutor(new BookSignature());
            if (statHand.isBookSignature())
                misc.formatMessage(true, "&7Loaded Module: &fBookSignature");
        } catch (Exception e) { misc.error(true, "Failed to load module: BookSignature"); }

        try {
            getServer().getPluginManager().registerEvents(new BushmanBow(), this);
            if (statHand.isBushmanBow())
                misc.formatMessage(true, "&7Loaded Module: &fBushmanBow");
        } catch (Exception e) { misc.error(true, "Failed to load module: BushmanBow"); }

        try {
            getCommand("banner").setExecutor(new CultistBanner());
            if (statHand.isCultistBanner())
                misc.formatMessage(true, "&7Loaded Module: &fCultistBanner");
        } catch (Exception e) { misc.error(true, "Failed to load module: CultistBanner"); }

        try {
            getServer().getPluginManager().registerEvents(new DeathCoordinates(), this);
            if (statHand.isDeathCoordinates()) {
                misc.formatMessage(true, "&7Loaded Module: &fDeathCoordinates");
            }
        } catch (Exception e) { misc.error(true, "Failed to load module: DeathCoordinates"); }

        try {
            getServer().getPluginManager().registerEvents(new EasyRaidEvokers(), this);
            if (statHand.isEasyRaidEvokers()) {
                misc.formatMessage(true, "&7Loaded Module: &fEasyRaidEvokers");
            }
        } catch (Exception e) { misc.error(true, "Failed to load module: EasyRaidEvokers"); }

        try {
            getServer().getPluginManager().registerEvents(new GlobalFreeze(), this);
            if (statHand.isGlobalFreeze())
                misc.formatMessage(true,"&7Loaded Module: &fGlobalFreeze");
        } catch (Exception e) { misc.error(true, "Failed to load module: GlobalFreeze"); }

        try {
            getServer().getPluginManager().registerEvents(new InvincibilityFrames(), this);
            if (statHand.isInvincibilityFrames()) {
                misc.formatMessage(true, "&7Loaded Module: &fInvincibilityFrames");
            }
        } catch (Exception e) { misc.error(true, "Failed to load module: InvincibilityFrames"); }

        try {
            getServer().getPluginManager().registerEvents(new PlayerLogger(), this);
            if (statHand.isPlayerLogger()) {
                misc.formatMessage(true, "&7Loaded Module: &fPlayerLogger");

            }
        } catch (Exception e) { misc.error(true, "Failed to load module: PlayerLogger"); }

        try {
            getServer().getPluginManager().registerEvents(new SeasonalItems(), this);
            if (statHand.isSeasonalItems())
                misc.formatMessage(true, "&7Loaded Module: &fSeasonalItems");
        } catch (Exception e) { misc.error(true, "Failed to load module: SeasonalItems"); }

        try {
            getServer().getPluginManager().registerEvents(new SimpleSpleef(), this);
            if (statHand.isSimpleSpleef())
                misc.formatMessage(true, "&7Loaded Module: &fSimpleSpleef");
        } catch (Exception e) { misc.error(true, "Failed to load module: SimpleSpleef"); }

        try {
            getServer().getPluginManager().registerEvents(new StopSoundsOnDeath(), this);
            if (statHand.isStopSoundsOnDeath())
                misc.formatMessage(true, "&7Loaded Module: &fStopSoundsOnDeath");
        } catch (Exception e) { misc.error(true, "Failed to load module: StopSoundsOnDeath"); }

        try {
            getServer().getPluginManager().registerEvents(new WardenBoss(), this);
            if (statHand.isWardenBoss())
                misc.formatMessage(true, "&7Loaded Module: &fWardenBoss");
        } catch (Exception e) { misc.error(true, "Failed to load module: WardenBoss"); }

        try {
            getServer().getPluginManager().registerEvents(new WardenHeartFix(), this);
            if (statHand.isWardenHeartFix())
                misc.formatMessage(true, "&7Loaded Module: &fWardenHeartFix");
        } catch (Exception e) { misc.error(true, "Failed to load module: WardenHeartFix"); }

        misc.formatMessage(true, "&7Finished Enabling MartLib");
        misc.formatMessage(false, "&r========== &2&lMartLib&r ==========");

    }
}
