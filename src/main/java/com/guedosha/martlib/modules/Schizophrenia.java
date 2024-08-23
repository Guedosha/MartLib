package com.guedosha.martlib.modules;

import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class Schizophrenia implements Listener {

    //W.I.P. Module that i've deleted and remade 3 times. ignore this

    @EventHandler
    public void onPlayerSleep(PlayerBedEnterEvent e) {

        e.getPlayer().playSound(e.getPlayer(), Sound.AMBIENT_CRIMSON_FOREST_ADDITIONS, 1 ,1);

    }
}
