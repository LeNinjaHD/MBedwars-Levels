package com.leprofi.bwlevels.utils;

import de.marcely.bedwars.api.player.PlayerDataAPI;
import de.marcely.bedwars.api.player.PlayerStatSet;
import de.marcely.bedwars.api.player.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class LevelManager {
    private Player player;
    private final PlayerStats playerStats;
    private final PlayerStatSet expSet = new RegisterMBedwarsStat();

    public LevelManager(String uuid) {
        player = Bukkit.getPlayer(uuid);
        playerStats = PlayerDataAPI.get().getStatsNow(UUID.fromString(uuid)).get();
    }

    public void addXP(Integer xp) {

        //Where do I run this?
        PlayerDataAPI.get().registerStatSet(expSet);

        expSet.setValue(playerStats, xp);
    }


    public void addLevels(Integer levels) {

    }

}
