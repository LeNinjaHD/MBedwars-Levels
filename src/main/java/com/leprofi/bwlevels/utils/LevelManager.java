package com.leprofi.bwlevels.utils;

import de.marcely.bedwars.api.BedwarsAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/*
 *  Class Created by LeNinjaHD at 02.09.2021
 */
public class LevelManager {
    private Player player;

    public LevelManager(String UUID) {
        player = Bukkit.getPlayer(UUID);
    }

    public void addXP(Integer xp) {


    }

    //Don't know if we will need this, and it might be a little difficult to do if level increments are different
    /*
    public void addLevels(Integer levels) {

    }

     */
}
