package com.leprofi.bwlevels.utils;

import de.marcely.bedwars.api.player.PlayerDataAPI;
import de.marcely.bedwars.api.player.PlayerStatSet;
import de.marcely.bedwars.api.player.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.UUID;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class LevelManager {
    private Player player;
    private final Optional<PlayerStats> playerStats;
    private final PlayerStatSet expSet = new RegisterMBedwarsStat();

    public LevelManager(String uuid) {
        player = Bukkit.getPlayer(uuid);
        playerStats = PlayerDataAPI.get().getStatsNow(UUID.fromString(uuid));
    }

    public void addXP(Integer xp) {

        PlayerDataAPI.get().registerStatSet(expSet);

        playerStats.ifPresent(stats -> expSet.setValue(stats, xp));
    }


    public void addLevels(Integer levels) {

    }

}
