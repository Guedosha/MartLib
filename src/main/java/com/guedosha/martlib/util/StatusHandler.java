package com.guedosha.martlib.util;

import com.guedosha.martlib.MartLib;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.Plugin;

public class StatusHandler {

    // To whomever reads this. I am aware of how unoptimized this is. I'll fix it later

    static Plugin plugin = MartLib.getPlugin(MartLib.class);

    private boolean BookSignature = plugin.getConfig().getBoolean("Modules.BookSignature");
    private boolean BushmanBow = plugin.getConfig().getBoolean("Modules.BushmanBow");
    private boolean CultistBanner = plugin.getConfig().getBoolean("Modules.CultistBanner");
    private boolean DeathCoordinates = plugin.getConfig().getBoolean("Modules.DeathCoordinates");
    private boolean EasyRaidEvokers = plugin.getConfig().getBoolean("Modules.EasyRaidEvokers");
    private boolean LunarIntegrations = plugin.getConfig().getBoolean("Modules.LunarIntegrations");
    private boolean PlayerLogger = plugin.getConfig().getBoolean("Modules.PlayerLogger");
    private boolean GlobalFreeze = plugin.getConfig().getBoolean("Modules.GlobalFreeze");
    private boolean InvincibilityFrames = plugin.getConfig().getBoolean("Modules.InvincibilityFrames.Enabled");
    private int InvincibilityTicks = plugin.getConfig().getInt("Modules.InvincibilityFrames.InvincibilityTicks");
    private boolean SeasonalItems = plugin.getConfig().getBoolean("Modules.SeasonalItems");
    private boolean SimpleSpleef = plugin.getConfig().getBoolean("Modules.SimpleSpleef");
    private boolean StopSoundsOnDeath = plugin.getConfig().getBoolean("Modules.StopSoundsOnDeath");
    private boolean WardenBoss = plugin.getConfig().getBoolean("Modules.WardenBoss");
    private boolean WardenHeartFix = plugin.getConfig().getBoolean("Modules.WardenHeartFix");

    public void reloadConfig() {
        plugin.reloadConfig();
        Configuration config = plugin.getConfig();
        Misc misc = new Misc();

        misc.formatMessage(true, "Reloading Config");

        BookSignature = config.getBoolean("Modules.BookSignature");
        misc.formatMessage(true, "&fBookSignature = " + BookSignature);

        BushmanBow = config.getBoolean("Modules.BushmanBow");
        misc.formatMessage(true, "&fBushmanBow = " + BushmanBow);

        CultistBanner = config.getBoolean("Modules.CultistBanner");
        misc.formatMessage(true, "&fCultistBanner = " + CultistBanner);

        DeathCoordinates = config.getBoolean("Modules.DeathCoordinates");
        misc.formatMessage(true,"&fDeathCoordinates = " + DeathCoordinates);

        EasyRaidEvokers = config.getBoolean("Modules.EasyRaidEvokers");
        misc.formatMessage(true,"&fEasyRaidEvokers = " + EasyRaidEvokers);

        LunarIntegrations = config.getBoolean("Modules.LunarIntegrations");
        misc.formatMessage(true, "&fLunarIntegrations = " + LunarIntegrations);

        GlobalFreeze = config.getBoolean("Modules.GlobalFreeze");
        misc.formatMessage(true, "&fGlobalFreeze = " + GlobalFreeze);

        PlayerLogger = config.getBoolean("Modules.PlayerLogger");
        misc.formatMessage(true, "&fPlayerLogger = " + PlayerLogger);

        InvincibilityFrames = config.getBoolean("Modules.InvincibilityFrames.Enabled");
        misc.formatMessage(true, "&fInvincibilityFrames = " + InvincibilityFrames);

        InvincibilityTicks = config.getInt("Modules.InvincibilityFrames.InvincibilityTicks");
        misc.formatMessage(true,  "&fInvincibilityTicks = " + InvincibilityTicks);

        SeasonalItems = config.getBoolean("Modules.SeasonalItems");
        misc.formatMessage(true, "&fSeasonalItems = " + SeasonalItems);

        SimpleSpleef = config.getBoolean("Modules.SimpleSpleef");
        misc.formatMessage(true, "&fSimpleSpleef = " + SimpleSpleef);

        StopSoundsOnDeath = config.getBoolean("Modules.StopSoundsOnDeath");
        misc.formatMessage(true, "&fStopSoundsOnDeath = " + StopSoundsOnDeath);

        WardenBoss = config.getBoolean("Modules.WardenBoss");
        misc.formatMessage(true, "&fWardenBoss = " + WardenBoss);

        WardenHeartFix = config.getBoolean("Modules.WardenHeartFix");
        misc.formatMessage(true, "&fWardenHeartFix = " + WardenHeartFix);

        misc.formatMessage(true, "&fFinished Reloading Config");
    }

    public boolean isBookSignature() {
        return BookSignature;
    }

    public boolean isBushmanBow() {
        return BushmanBow;
    }

    public boolean isCultistBanner() { return CultistBanner; }

    public boolean isDeathCoordinates() { return DeathCoordinates; }

    public boolean isEasyRaidEvokers() { return EasyRaidEvokers; }

    public boolean isLunarIntegrations() {
        return LunarIntegrations;
    }

    public boolean isPlayerLogger() { return PlayerLogger; }

    public boolean isGlobalFreeze() {
        return GlobalFreeze;
    }

    public boolean isInvincibilityFrames() { return InvincibilityFrames; }

    public int getInvincibilityTicks() { return InvincibilityTicks; }

    public boolean isSeasonalItems() {
        return SeasonalItems;
    }

    public boolean isSimpleSpleef() {
        return SimpleSpleef;
    }

    public boolean isStopSoundsOnDeath() {
        return StopSoundsOnDeath;
    }

    public boolean isWardenBoss() {
        return WardenBoss;
    }

    public boolean isWardenHeartFix() {
        return WardenHeartFix;
    }

}
